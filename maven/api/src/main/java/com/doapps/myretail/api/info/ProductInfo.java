/**
 * ProductInfo.java
 * myRetail-api
 * 
 * Created by jeremy on Apr 3, 2015
 * DoApp, Inc. owns and reserves all rights to the intellectual
 * property and design of the following application.
 *
 * Copyright 2015 - All rights reserved.  Created by DoApp, Inc.
 */
package com.doapps.myretail.api.info;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Just extending HashMap so I don't have to model all of data from the info api
 * 
 * @author jeremy
 *
 */
public class ProductInfo extends HashMap<String, Object> {
  private static final long serialVersionUID = 1L;

  /**
   * assumptions - the product info is the first item in the items array
   * 
   * @return the name of the product
   */
  @SuppressWarnings("unchecked")
  public String getName() {
    Map<String, Object> productCompositeResponse = (Map<String, Object>) get("product_composite_response");
    if (productCompositeResponse != null) {
      List<Map<String, Object>> items = (List<Map<String, Object>>) productCompositeResponse.get("items");
      if ((items != null) && (items.size() > 0)) {
        // assuming items is a list of size 1, not caring if it's more though, just use first item
        Map<String, Object> item = items.get(0);
        Map<String, Object> onlineDescription = (Map<String, Object>) item.get("online_description");
        if (onlineDescription != null) {
          if (onlineDescription.containsKey("value")) {
            return (String) onlineDescription.get("value");
          }
        }
      }
    }
    return null;
  }

}
