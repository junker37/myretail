/**
 * PricingData.java
 * myRetail-api
 * 
 * Created by jeremy on Apr 3, 2015
 * DoApp, Inc. owns and reserves all rights to the intellectual
 * property and design of the following application.
 *
 * Copyright 2015 - All rights reserved.  Created by DoApp, Inc.
 */
package com.myretail.api.pricing;

import com.google.common.base.MoreObjects;


/**
 * @author jeremy
 *
 */
public class PricingData {
  public final Float value;
  public final String currencyCode;

  private PricingData() {
    this.value = null;
    this.currencyCode = null;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("value", value).add("code", currencyCode).toString();
  }

}
