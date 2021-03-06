/**
 * MyRetailPricingAPI.java
 * myRetail-api
 * 
 * Created by jeremy on Apr 3, 2015
 * DoApp, Inc. owns and reserves all rights to the intellectual
 * property and design of the following application.
 *
 * Copyright 2015 - All rights reserved.  Created by DoApp, Inc.
 */
package com.myretail.api.pricing;

/**
 * @author jeremy
 *
 */
public interface MyRetailPricingAPI {

  /**
   * 
   * @param productId the product id
   * @return the pricing data for the product
   */
  public PricingData getPricingData(Integer productId);

  /**
   * 
   * @param productId the product id
   * @param pricingData the new pricing data for the product
   */
  public void updatePricingData(Integer productId, PricingData pricingData);
}
