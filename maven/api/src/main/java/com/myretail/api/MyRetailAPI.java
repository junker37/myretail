/**
 * MyRetailAPI.java
 * myRetail-api
 * 
 * Created by jeremy on Apr 3, 2015
 * DoApp, Inc. owns and reserves all rights to the intellectual
 * property and design of the following application.
 *
 * Copyright 2015 - All rights reserved.  Created by DoApp, Inc.
 */
package com.myretail.api;

import com.myretail.api.pricing.PricingData;


/**
 * @author jeremy
 *
 */
public interface MyRetailAPI {

  /**
   * 
   * @param id the product id
   * @return {"id":13860428,"name":"The Big Lebowski (Blu-ray) (Widescreen)","current_price":{"value":13.49,"currency_code":"USD"}}
   * @throws Exception if an error occurs
   */
  public ProductAPIResult getProduct(Integer id) throws Exception;

  /**
   * 
   * @param id the product id
   * @Param pricingData the updated pricing data
   * @throws Exception if an error occurs
   */
  public void updatePricingData(Integer id, PricingData pricingData) throws Exception;
}
