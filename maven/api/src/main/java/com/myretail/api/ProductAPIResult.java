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
 *         Example {"id":13860428,"name":"The Big Lebowski (Blu-ray) (Widescreen)","current_price":{"value":13.49,"currency_code":"USD"}}
 */
public class ProductAPIResult {
  public final Integer id;
  public final String name;
  public final PricingData currentPrice;

  public ProductAPIResult(Integer id, String name, PricingData pricingData) {
    this.id = checkNotNull(id);
    this.name = name;
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

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
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
    ProductAPIResult other = (ProductAPIResult) obj;
    if (currentPrice == null) {
      if (other.currentPrice != null) return false;
    } else if (!currentPrice.equals(other.currentPrice)) return false;
    if (id == null) {
      if (other.id != null) return false;
    } else if (!id.equals(other.id)) return false;
    if (name == null) {
      if (other.name != null) return false;
    } else if (!name.equals(other.name)) return false;
    return true;
  }
}
