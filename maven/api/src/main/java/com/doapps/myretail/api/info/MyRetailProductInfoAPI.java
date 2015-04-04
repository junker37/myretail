/**
 * MyRetailProductInfoAPI.java
 * myRetail-api
 * 
 * Created by jeremy on Apr 3, 2015
 * DoApp, Inc. owns and reserves all rights to the intellectual
 * property and design of the following application.
 *
 * Copyright 2015 - All rights reserved.  Created by DoApp, Inc.
 */
package com.doapps.myretail.api.info;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;


/**
 * @author jeremy
 *
 */
public interface MyRetailProductInfoAPI {

  @GET("/products/v{version}/{id}")
  public ProductInfo getProductInfo(
      @Path("version") Integer version,
      @Path("id") Integer id,
      @Query("fields") String fields,
      @Query("id_type") String idType,
      @Query("key") String key);

}
