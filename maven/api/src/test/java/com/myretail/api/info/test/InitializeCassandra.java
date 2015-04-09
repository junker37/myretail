/**
 * InitializeCassandra.java
 * myRetail-api
 * 
 * Created by jeremy on Apr 8, 2015
 * DoApp, Inc. owns and reserves all rights to the intellectual
 * property and design of the following application.
 *
 * Copyright 2015 - All rights reserved.  Created by DoApp, Inc.
 */
package com.myretail.api.info.test;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;


/**
 * @author jeremy
 *
 */
public class InitializeCassandra {

  public static void main(String[] args) {
    Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
    Session session = cluster.connect();
    session.execute("CREATE KEYSPACE IF NOT EXISTS myretail WITH replication = {'class':'SimpleStrategy', 'replication_factor':3};");
    session.execute("CREATE TABLE IF NOT EXISTS myretail.pricing (id int, value decimal, currency_code text, PRIMARY KEY (id));");
    session.execute("INSERT INTO myretail.pricing (id, value, currency_code) VALUES (13860428, 13.49, 'USD');");
    ResultSet resultSet = session.execute("SELECT * FROM myretail.pricing");
    for (Row row : resultSet) {
      System.out.println(String.format("%-30s\t%-20s\t%-20s", row.getInt("id"), row.getDecimal("value"), row.getString("currency_code")));
    }
  }

}
