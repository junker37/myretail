/**
 * MyRetailAPIImplTest.java
 * myRetail-api
 * 
 * Created by jeremy on Apr 7, 2015
 * DoApp, Inc. owns and reserves all rights to the intellectual
 * property and design of the following application.
 *
 * Copyright 2015 - All rights reserved.  Created by DoApp, Inc.
 */
package com.myretail.api;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.doapps.myretail.api.info.MyRetailProductInfoAPI;
import com.doapps.myretail.api.info.ProductInfo;
import com.myretail.api.pricing.MyRetailPricingAPI;
import com.myretail.api.pricing.PricingData;


/**
 * @author jeremy
 *
 */
public class MyRetailAPIImplTest {
  private MyRetailProductInfoAPI dummyInfoAPI;
  private MyRetailPricingAPI dummyPricingAPI;

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
  public void setUp() throws Exception {
    dummyInfoAPI = new MyRetailProductInfoAPI() {
      @Override
      public ProductInfo getProductInfo(Integer id) {
        return getProductInfo(null, id, null, null, null);
      }

      @Override
      public ProductInfo getProductInfo(Integer version, Integer id, String fields, String idType, String key) {
        ProductInfo productInfo = new ProductInfo();
        Map<String, Object> product_composite_response = new HashMap<>();
        List<Map<String, Object>> items = new ArrayList<>();
        Map<String, Object> item = new HashMap<>();
        Map<String, Object> online_description = new HashMap<>();
        online_description.put("value", "This is my items name");
        item.put("online_description", online_description);
        items.add(item);
        product_composite_response.put("items", items);
        productInfo.put("product_composite_response", product_composite_response);
        return productInfo;
      }
    };
    dummyPricingAPI = new MyRetailPricingAPI() {
      @Override
      public PricingData getPricingData(Integer productId) {
        return new PricingData(new BigDecimal(10.49), "USD");
      }
    };
  }

  /**
   * @throws java.lang.Exception
   */
  @After
  public void tearDown() throws Exception {}

  @Test
  public void testConstructor() {
    try {
      new MyRetailAPIImpl(null, null);
    } catch (NullPointerException e) {
      Assert.assertEquals("ProductInfo API is null", e.getMessage());
    }
    try {
      new MyRetailAPIImpl(dummyInfoAPI, null);
    } catch (NullPointerException e) {
      Assert.assertEquals("Pricing API is null", e.getMessage());
    }
  }

  @Test
  public void testGetProductInfoIdNull() throws Exception {
    try {
      new MyRetailAPIImpl(dummyInfoAPI, dummyPricingAPI).getProduct(null);
    } catch (NullPointerException e) {
      Assert.assertEquals("Product id is null", e.getMessage());
    }
  }

  @Test
  public void testGetProductInfoTimeout() {
    try {
      new MyRetailAPIImpl(dummyInfoAPI, new MyRetailPricingAPI() {
        @Override
        public PricingData getPricingData(Integer productId) {
          try {
            Thread.sleep(5100);
          } catch (InterruptedException e) {}
          return dummyPricingAPI.getPricingData(productId);
        }
      }).getProduct(1);
    } catch (Exception e) {
      Assert.assertEquals("Timeout getting product info", e.getMessage());
    }
  }

  @Test
  public void testGetProductInfo() throws Exception {
    ProductAPIResult productAPIResult = new MyRetailAPIImpl(dummyInfoAPI, dummyPricingAPI).getProduct(1);
    ProductAPIResult expected = new ProductAPIResult(1, "This is my items name", new PricingData(new BigDecimal(10.49), "USD"));
    Assert.assertEquals(expected, productAPIResult);
  }
}
