/**
 * ProductAPIResult.java
 * myRetail-api
 * 
 * Created by jeremy on Apr 3, 2015
 * DoApp, Inc. owns and reserves all rights to the intellectual
 * property and design of the following application.
 *
 * Copyright 2015 - All rights reserved.  Created by DoApp, Inc.
 */
package com.myretail.api;

import static com.google.common.base.Preconditions.checkNotNull;
import com.google.common.base.MoreObjects;
import com.myretail.api.pricing.PricingData;


/**
 * @author jeremy
 *
 */
public class ProductAPIResult {
  public final Integer id;
  public final String name;
  public final PricingData currentPrice;

  public ProductAPIResult(Integer id, String name, PricingData pricingData) {
    this.id = checkNotNull(id);
    this.name = checkNotNull(name);
    this.currentPrice = checkNotNull(pricingData);
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("id", id).add("name", name).add("price", currentPrice).toString();
  }
}
