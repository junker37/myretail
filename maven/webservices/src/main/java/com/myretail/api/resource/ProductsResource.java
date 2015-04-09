/**
 * ProducResource.java
 * myRetail-webservices
 * 
 * Created by jeremy on Apr 3, 2015
 * DoApp, Inc. owns and reserves all rights to the intellectual
 * property and design of the following application.
 *
 * Copyright 2015 - All rights reserved.  Created by DoApp, Inc.
 */
package com.myretail.api.resource;

import static com.google.common.base.Preconditions.checkNotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.WebServiceException;
import com.myretail.api.MyRetailAPI;
import com.myretail.api.ProductAPIResult;


/**
 * @author jeremy
 *
 */
@Path("/products/v{version}")
@Produces(MediaType.APPLICATION_JSON)
public class ProductsResource {
  private final MyRetailAPI api;

  public ProductsResource(MyRetailAPI api) {
    this.api = checkNotNull(api);
  }

  /**
   * 
   * @param id the product id
   * @return {"id":13860428,"name":"The Big Lebowski (Blu-ray) (Widescreen)","current_price":{"value":13.49,"currency_code":"USD"}}
   */
  @GET
  @Path("{id}")
  public ProductAPIResult getProduct(@PathParam("id") Integer id) {
    try {
      return api.getProduct(checkNotNull(id, "Product id is null"));
    } catch (Throwable t) {
      throw new WebServiceException(t);
    }
  }
}
