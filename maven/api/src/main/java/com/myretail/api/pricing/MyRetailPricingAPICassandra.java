/**
 * MyRetailPricingAPICassandra.java
 * myRetail-api
 * 
 * Created by jeremy on Apr 8, 2015
 * DoApp, Inc. owns and reserves all rights to the intellectual
 * property and design of the following application.
 *
 * Copyright 2015 - All rights reserved.  Created by DoApp, Inc.
 */
package com.myretail.api.pricing;

import static com.google.common.base.Preconditions.checkNotNull;
import com.datastax.driver.core.Session;


/**
 * @author jeremy
 *
 */
public class MyRetailPricingAPICassandra implements MyRetailPricingAPI {
  private final Session session;

  public MyRetailPricingAPICassandra(Session session) {
    this.session = checkNotNull(session);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.myretail.api.pricing.MyRetailPricingAPI#getPricingData(java.lang.Integer)
   */
  @Override
  public PricingData getPricingData(Integer productId) {

    return null;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.myretail.api.pricing.MyRetailPricingAPI#updatePricingData(java.lang.Integer, com.myretail.api.pricing.PricingData)
   */
  @Override
  public void updatePricingData(Integer productId, PricingData pricingData) {
    // TODO Auto-generated method stub

  }

}
