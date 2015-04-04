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

import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.WebServiceException;


/**
 * @author jeremy
 *
 */
@Path("/products/v{version}")
@Produces(MediaType.APPLICATION_JSON)
public class ProductsResource {

  @GET
  @Path("{id}")
  public Map<String, Object> getProduct(@PathParam("id") Integer id) {
    try {
      Map<String, Object> result = new HashMap<>();
      result.put("id", id);
      result.put("name", "The Big Lebowski (Blu-ray) (Widescreen)");
      Map<String, Object> price = new HashMap<>();
      price.put("value", 13.49f);
      price.put("currency_code", "USD");
      result.put("current_price", price);
      return result;
    } catch (Throwable t) {
      throw new WebServiceException(t);
    }
  }
}
