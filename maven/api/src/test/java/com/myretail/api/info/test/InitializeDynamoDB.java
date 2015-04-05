/**
 * InitializeDynamoDB.java
 * myRetail-api
 * 
 * Created by jeremy on Apr 4, 2015
 * DoApp, Inc. owns and reserves all rights to the intellectual
 * property and design of the following application.
 *
 * Copyright 2015 - All rights reserved.  Created by DoApp, Inc.
 */
package com.myretail.api.info.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.CreateTableResult;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazonaws.services.dynamodbv2.model.PutItemResult;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import com.myretail.api.pricing.MyRetailPricingAPIDynamoDB;


/**
 * @author jeremy
 *
 */
public class InitializeDynamoDB {

  private static CreateTableResult createTable(AmazonDynamoDBClient dynamoDB) {
    List<KeySchemaElement> schema = new ArrayList<>();
    schema.add(new KeySchemaElement(MyRetailPricingAPIDynamoDB.PRODUCT_ID, KeyType.HASH));
    List<AttributeDefinition> attrDef = new ArrayList<>();
    attrDef.add(new AttributeDefinition(MyRetailPricingAPIDynamoDB.PRODUCT_ID, ScalarAttributeType.N));
    ProvisionedThroughput provisionedThroughput = new ProvisionedThroughput(1L, 1L);
    CreateTableRequest createTableRequest = new CreateTableRequest(attrDef, MyRetailPricingAPIDynamoDB.TABLE_NAME, schema, provisionedThroughput);
    return dynamoDB.createTable(createTableRequest);
  }

  private static PutItemResult initialize(AmazonDynamoDBClient dynamoDB) {
    Map<String, AttributeValue> item = new HashMap<>();
    item.put(MyRetailPricingAPIDynamoDB.PRODUCT_ID, new AttributeValue().withN("13860428"));
    item.put(MyRetailPricingAPIDynamoDB.VALUE, new AttributeValue().withN("13.49"));
    item.put(MyRetailPricingAPIDynamoDB.CURRENCY_CODE, new AttributeValue().withS("USD"));
    PutItemRequest putItemRequest = new PutItemRequest(MyRetailPricingAPIDynamoDB.TABLE_NAME, item);
    return dynamoDB.putItem(putItemRequest);
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    // it fails if it can't find credentials, so just using dummy (db file is created with name of accessKey) basic credentials since we're using a local db file
    AmazonDynamoDBClient dynamoDB = new AmazonDynamoDBClient(new BasicAWSCredentials("myRetail", ""));
    dynamoDB.setRegion(Region.getRegion(Regions.US_EAST_1));
    dynamoDB.setEndpoint("http://localhost:8000");

    createTable(dynamoDB);
    initialize(dynamoDB);
  }

}
