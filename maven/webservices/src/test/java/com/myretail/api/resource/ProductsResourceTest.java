/**
 * ProductsResourceTest.java
 * myRetail-webservices
 * 
 * Created by jeremy on Apr 3, 2015
 * DoApp, Inc. owns and reserves all rights to the intellectual
 * property and design of the following application.
 *
 * Copyright 2015 - All rights reserved.  Created by DoApp, Inc.
 */
package com.myretail.api.resource;

import java.math.BigDecimal;
import javax.xml.ws.WebServiceException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.myretail.api.MyRetailAPI;
import com.myretail.api.ProductAPIResult;
import com.myretail.api.pricing.PricingData;


/**
 * @author jeremy
 *
 */
public class ProductsResourceTest {

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

  private MyRetailAPI dummyMyRetailAPI;

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    dummyMyRetailAPI = new MyRetailAPI() {
      @Override
      public ProductAPIResult getProduct(Integer id) throws Exception {
        return new ProductAPIResult(id, "ProductsResourceTest Product Name", new PricingData(new BigDecimal(5.67), "USD"));
      }
    };
  }

  /**
   * @throws java.lang.Exception
   */
  @After
  public void tearDown() throws Exception {}

  /**
   * Test method for {@link com.myretail.api.resource.ProductsResource#getProduct(java.lang.Integer)}.
   */
  @Test
  public void testGetProductNullId() {
    try {
      new ProductsResource(dummyMyRetailAPI).getProduct(null);
    } catch (WebServiceException e) {
      Assert.assertEquals("Product id is null", e.getCause().getMessage());
    }
  }

  /**
   * Test method for {@link com.myretail.api.resource.ProductsResource#getProduct(java.lang.Integer)}.
   */
  @Test
  public void testGetProduct() {
    ProductAPIResult actual = new ProductsResource(dummyMyRetailAPI).getProduct(1);
    ProductAPIResult expected = new ProductAPIResult(1, "ProductsResourceTest Product Name", new PricingData(new BigDecimal(5.67), "USD"));
    Assert.assertEquals(expected, actual);
  }
}
