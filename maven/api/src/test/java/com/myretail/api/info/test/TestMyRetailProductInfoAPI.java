/**
 * TestMyRetailProductInfoAPI.java
 * myRetail-api
 * 
 * Created by jeremy on Apr 3, 2015
 * DoApp, Inc. owns and reserves all rights to the intellectual
 * property and design of the following application.
 *
 * Copyright 2015 - All rights reserved.  Created by DoApp, Inc.
 */
package com.myretail.api.info.test;

import retrofit.RestAdapter;
import com.doapps.myretail.api.info.MyRetailProductInfoAPI;
import com.doapps.myretail.api.info.ProductInfo;


/**
 * @author jeremy
 *
 */
public class TestMyRetailProductInfoAPI {

  /**
   * @param args
   */
  public static void main(String[] args) {
    try {
      RestAdapter restAdapter = new RestAdapter.Builder()
          .setEndpoint("https://api.target.com")
          .build();
      MyRetailProductInfoAPI infoAPI = restAdapter.create(MyRetailProductInfoAPI.class);
      // ProductInfo info = infoAPI.getProductInfo(3, 13860428, "descriptions", "TCIN", "43cJWpLjH8Z8oR18KdrZDBKAgLLQKJjz");
      ProductInfo info = infoAPI.getProductInfo(13860428);
      System.out.println(info);
    } catch (Throwable t) {
      t.printStackTrace();
    }
  }

}
