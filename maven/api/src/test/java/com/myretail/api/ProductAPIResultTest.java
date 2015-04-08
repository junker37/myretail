/**
 * ProductAPIResultTest.java
 * myRetail-api
 * 
 * Created by jeremy on Apr 7, 2015
 * DoApp, Inc. owns and reserves all rights to the intellectual
 * property and design of the following application.
 *
 * Copyright 2015 - All rights reserved.  Created by DoApp, Inc.
 */
package com.myretail.api;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * @author jeremy
 *
 */
public class ProductAPIResultTest {

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
  public void testConstructor() {
    try {
      new ProductAPIResult(null, "", null);
    } catch (NullPointerException e) {
      Assert.assertEquals("Product id is null", e.getMessage());
    }
    try {
      new ProductAPIResult(1, "", null);
    } catch (NullPointerException e) {
      Assert.assertEquals("Pricing data is null", e.getMessage());
    }
  }

}
