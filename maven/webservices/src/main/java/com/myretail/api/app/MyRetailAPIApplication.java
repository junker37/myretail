/**
 * MetricsWsApplication.java
 * ws
 * 
 * Created by jeremy on Oct 28, 2014
 * DoApp, Inc. owns and reserves all rights to the intellectual
 * property and design of the following application.
 *
 * Copyright 2014 - All rights reserved.  Created by DoApp, Inc.
 */
package com.myretail.api.app;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import retrofit.RestAdapter;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.doapps.myretail.api.info.MyRetailProductInfoAPI;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.myretail.api.MyRetailAPI;
import com.myretail.api.MyRetailAPIImpl;
import com.myretail.api.pricing.MyRetailPricingAPI;
import com.myretail.api.pricing.MyRetailPricingAPIDynamoDB;
import com.myretail.api.resource.ProductsResource;


/**
 * @author jeremy
 *
 */
public class MyRetailAPIApplication extends Application<MyRetailAPIConfiguration> {

  /*
   * (non-Javadoc)
   * 
   * @see io.dropwizard.Application#initialize(io.dropwizard.setup.Bootstrap)
   */
  @Override
  public void initialize(Bootstrap<MyRetailAPIConfiguration> bootstrap) {
    // set a short dns cache time
    // http://docs.aws.amazon.com/AWSSdkDocsJava/latest/DeveloperGuide/java-dg-jvm-ttl.html
    java.security.Security.setProperty("networkaddress.cache.ttl", "60");
  }

  private MyRetailAPI getApi() {
    return new MyRetailAPIImpl(getInfoAPI(), getPricingAPI());
  }

  /**
   * @return
   */
  private MyRetailPricingAPI getPricingAPI() {
    return new MyRetailPricingAPIDynamoDB(getDynamoDB());
  }

  /**
   * @return
   */
  private AmazonDynamoDBClient getDynamoDB() {
    String accessKey = System.getProperty("aws.accessKey", "myRetail");
    String secretKey = System.getProperty("aws.secretKey", "");
    String region = System.getProperty("aws.region", "us-east-1");
    // it fails if it can't find credentials, so just using dummy (db file is created with name of accessKey) basic credentials since we're using a local db file
    AmazonDynamoDBClient dynamoDB = new AmazonDynamoDBClient(new BasicAWSCredentials(accessKey, secretKey));
    dynamoDB.setRegion(Region.getRegion(Regions.fromName(region)));
    String endpoint = System.getProperty("aws.dynamodb.endpoint", null);
    if (endpoint != null) {
      dynamoDB.setEndpoint(endpoint);
    }
    return dynamoDB;
  }

  /**
   * @return
   */
  private MyRetailProductInfoAPI getInfoAPI() {
    RestAdapter restAdapter = new RestAdapter.Builder()
        .setEndpoint("https://api.target.com")
        .build();
    MyRetailProductInfoAPI infoAPI = restAdapter.create(MyRetailProductInfoAPI.class);
    return infoAPI;
  }

  /*
   * (non-Javadoc)
   * 
   * @see io.dropwizard.Application#run(io.dropwizard.Configuration, io.dropwizard.setup.Environment)
   */
  @Override
  public void run(MyRetailAPIConfiguration configuration, Environment environment) throws Exception {
    // the /products endpoints
    environment.jersey().register(new ProductsResource(getApi()));
    // we want lower case with underscores, not camel case
    environment.getObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
  }

  public static void main(String[] args) throws Exception {
    new MyRetailAPIApplication().run(args);
  }
}
