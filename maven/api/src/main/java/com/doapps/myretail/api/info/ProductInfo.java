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


/**
 * @author jeremy
 *
 */
public class ProductInfo extends HashMap<String, Object> {
  private static final long serialVersionUID = 1L;

  /**
   * assumptions - the product info is the first item in the items array
   * 
   * @return
   */
  public String getName() {
    return "The Big Lebowski (Blu-ray) (Widescreen)";
  }

}
