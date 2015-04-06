/**
 * ProductInfoTest.java
 * myRetail-api
 * 
 * Created by jeremy on Apr 5, 2015
 * DoApp, Inc. owns and reserves all rights to the intellectual
 * property and design of the following application.
 *
 * Copyright 2015 - All rights reserved.  Created by DoApp, Inc.
 */
package com.doapps.myretail.api.info;

import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * @author jeremy
 *
 */
public class ProductInfoTest {

  /**
   * @throws java.lang.Exception
   */
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {}

  /**
   * @throws java.lang.Exception
   */
  @AfterClass
  public static void tearDownAfterClass() throws Exception {}

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {}

  /**
   * @throws java.lang.Exception
   */
  @After
  public void tearDown() throws Exception {}

  @Test
  public void testNo_product_composite_response() throws JsonParseException, JsonMappingException, IOException {
    String response = "{}";
    ObjectMapper objectMapper = new ObjectMapper();
    ProductInfo info = objectMapper.readValue(response, ProductInfo.class);
    Assert.assertNull(info.getName());
  }

  @Test
  public void testNo_items() throws JsonParseException, JsonMappingException, IOException {
    String response = "{ \"product_composite_response\": {}}";
    ObjectMapper objectMapper = new ObjectMapper();
    ProductInfo info = objectMapper.readValue(response, ProductInfo.class);
    Assert.assertNull(info.getName());
  }

  @Test
  public void testNo_empty_items() throws JsonParseException, JsonMappingException, IOException {
    String response = "{ \"product_composite_response\": { \"items\": [] }}";
    ObjectMapper objectMapper = new ObjectMapper();
    ProductInfo info = objectMapper.readValue(response, ProductInfo.class);
    Assert.assertNull(info.getName());
  }

  @Test
  public void testNo_no_online_description() throws JsonParseException, JsonMappingException, IOException {
    String response = "{ \"product_composite_response\": { \"items\": [ {} ] }}";
    ObjectMapper objectMapper = new ObjectMapper();
    ProductInfo info = objectMapper.readValue(response, ProductInfo.class);
    Assert.assertNull(info.getName());
  }

  @Test
  public void testNo_no_value() throws JsonParseException, JsonMappingException, IOException {
    String response = "{ \"product_composite_response\": { \"items\": [ { \"online_description\": {} } ] }}";
    ObjectMapper objectMapper = new ObjectMapper();
    ProductInfo info = objectMapper.readValue(response, ProductInfo.class);
    Assert.assertNull(info.getName());
  }

  @Test
  public void test() throws JsonParseException, JsonMappingException, IOException {
    String response = "{ \"product_composite_response\": { \"items\": [ { \"online_description\": { \"value\": \"My Online Description Name\"} } ] }}";
    ObjectMapper objectMapper = new ObjectMapper();
    ProductInfo info = objectMapper.readValue(response, ProductInfo.class);
    Assert.assertEquals("My Online Description Name", info.getName());
  }
}
