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

import static com.google.common.base.Preconditions.checkNotNull;
import java.math.BigDecimal;
import com.google.common.base.MoreObjects;


/**
 * @author jeremy
 *
 */
public class PricingData {
  public final BigDecimal value;
  public final String currencyCode;

  private PricingData() {
    this.value = null;
    this.currencyCode = null;
  }

  public PricingData(BigDecimal value, String currencyCode) {
    this.value = checkNotNull(value);
    this.currencyCode = checkNotNull(currencyCode);
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
