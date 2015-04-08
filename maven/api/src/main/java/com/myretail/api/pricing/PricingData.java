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

  public PricingData(BigDecimal value, String currencyCode) {
    this.value = checkNotNull(value, "Value is null");
    this.currencyCode = checkNotNull(currencyCode, "Currency code is null");
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

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    PricingData other = (PricingData) obj;
    if (currencyCode == null) {
      if (other.currencyCode != null) return false;
    } else if (!currencyCode.equals(other.currencyCode)) return false;
    if (value == null) {
      if (other.value != null) return false;
    } else if (!value.equals(other.value)) return false;
    return true;
  }

}
