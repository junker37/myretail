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
import java.math.BigDecimal;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;


/**
 * @author jeremy
 *
 */
public class MyRetailPricingAPICassandra implements MyRetailPricingAPI {
  public static final String ID = "id";
  public static final String VALUE = "value";
  public static final String CURRENCY_CODE = "currency_code";

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
    checkNotNull(productId, "Product id is null");
    ResultSet resultSet = session.execute("SELECT * FROM myretail.pricing WHERE id = ?", productId);
    Row row = resultSet.one();
    if (row != null) {
      BigDecimal value = row.getDecimal(VALUE);
      if (value != null) {
        String currencyCode = row.getString(CURRENCY_CODE);
        if (currencyCode != null) {
          return new PricingData(value, currencyCode);
        }
      }
    }
    return null;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.myretail.api.pricing.MyRetailPricingAPI#updatePricingData(java.lang.Integer, com.myretail.api.pricing.PricingData)
   */
  @Override
  public void updatePricingData(Integer productId, PricingData pricingData) {
    checkNotNull(productId, "Product id is null");
    checkNotNull(pricingData, "PricingData is null");
    session.execute("UPDATE myretail.pricing SET value = ?, currency_code = ? WHERE id = ?", pricingData.value, pricingData.currencyCode, productId);
  }

}
