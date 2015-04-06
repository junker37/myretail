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
 * Interface to the product info API
 * 
 * @author jeremy
 *
 */
public interface MyRetailProductInfoAPI {

  /**
   * 
   * @param version
   * @param id the product id
   * @param fields
   * @param idType
   * @param key
   * @return { "product_composite_response": { "request_attributes": [ { "name": "product_id", "value": "13860428" }, { "name": "key", "value": "43cJWpLjH8Z8oR18KdrZDBKAgLLQKJjz" }, { "name": "id_type", "value": "TCIN" }, { "name": "fields", "value": "descriptions" } ], "items": [ { "relation":
   *         "TAC", "data_page_link": "http://www.target.com/p/the-big-lebowski-blu-ray-widescreen/-/A-13860428", "imn_identifier": 12244586, "identifier": [ { "id_type": "DPCI", "id": "058-34-0436", "is_primary": null, "source": "Online and Store" }, { "id_type": "TCIN", "id": "13860428",
   *         "is_primary": null, "source": "Online" } ], "is_orderable": true, "is_sellable": true, "general_description": "BIG LEBOWSKI, THE Blu-ray", "business_process_status": [ { "process_status": { "is_ready": true, "operation_description": "assortment ready", "operation_code": "PAAP" } }, {
   *         "process_status": { "is_ready": true, "operation_description": "import ready", "operation_code": "PIPT" } }, { "process_status": { "is_ready": true, "operation_description": "order ready", "operation_code": "PORD" } }, { "process_status": { "is_ready": true, "operation_description":
   *         "presentation ready", "operation_code": "PPRS" } }, { "process_status": { "is_ready": true, "operation_description": "project ready", "operation_code": "PCMT" } }, { "process_status": { "is_ready": true, "operation_description": "replenishment ready", "operation_code": "PRPL" } }, {
   *         "process_status": { "is_ready": false, "operation_description": "scale ready", "operation_code": "PSCL" } }, { "process_status": { "is_ready": false, "operation_description": "target.com ready", "operation_code": "PTGT" } } ], "dpci": "058-34-0436", "department_id": 58, "class_id": 34,
   *         "item_id": 436, "online_description": { "value": "The Big Lebowski (Blu-ray) (Widescreen)", "type": "GENL" }, "store_description": { "value": "BIG LEBOWSKI, THE Blu-ray", "type": "GENL" }, "alternate_description": [ { "type": "ADSG", "value": "The Big Lebowski:</Blu-ray Disc",
   *         "type_description": "Ad Signage Description" }, { "type": "POS", "value": "BLU-RAY", "type_description": "POS Desc" }, { "type": "SHLF", "value": "BIG LEBOWSKI, THE UNIV", "type_description": "Shelf Desc" }, { "type": "VEND", "value": "BIG LEBOWSKI BD", "type_description":
   *         "Vendor Description" } ] } ] } }
   */
  @GET("/products/v{version}/{id}")
  public ProductInfo getProductInfo(
      @Path("version") Integer version,
      @Path("id") Integer id,
      @Query("fields") String fields,
      @Query("id_type") String idType,
      @Query("key") String key);

  /**
   * 
   * @param id the product id
   * @return { "product_composite_response": { "request_attributes": [ { "name": "product_id", "value": "13860428" }, { "name": "key", "value": "43cJWpLjH8Z8oR18KdrZDBKAgLLQKJjz" }, { "name": "id_type", "value": "TCIN" }, { "name": "fields", "value": "descriptions" } ], "items": [ { "relation":
   *         "TAC", "data_page_link": "http://www.target.com/p/the-big-lebowski-blu-ray-widescreen/-/A-13860428", "imn_identifier": 12244586, "identifier": [ { "id_type": "DPCI", "id": "058-34-0436", "is_primary": null, "source": "Online and Store" }, { "id_type": "TCIN", "id": "13860428",
   *         "is_primary": null, "source": "Online" } ], "is_orderable": true, "is_sellable": true, "general_description": "BIG LEBOWSKI, THE Blu-ray", "business_process_status": [ { "process_status": { "is_ready": true, "operation_description": "assortment ready", "operation_code": "PAAP" } }, {
   *         "process_status": { "is_ready": true, "operation_description": "import ready", "operation_code": "PIPT" } }, { "process_status": { "is_ready": true, "operation_description": "order ready", "operation_code": "PORD" } }, { "process_status": { "is_ready": true, "operation_description":
   *         "presentation ready", "operation_code": "PPRS" } }, { "process_status": { "is_ready": true, "operation_description": "project ready", "operation_code": "PCMT" } }, { "process_status": { "is_ready": true, "operation_description": "replenishment ready", "operation_code": "PRPL" } }, {
   *         "process_status": { "is_ready": false, "operation_description": "scale ready", "operation_code": "PSCL" } }, { "process_status": { "is_ready": false, "operation_description": "target.com ready", "operation_code": "PTGT" } } ], "dpci": "058-34-0436", "department_id": 58, "class_id": 34,
   *         "item_id": 436, "online_description": { "value": "The Big Lebowski (Blu-ray) (Widescreen)", "type": "GENL" }, "store_description": { "value": "BIG LEBOWSKI, THE Blu-ray", "type": "GENL" }, "alternate_description": [ { "type": "ADSG", "value": "The Big Lebowski:</Blu-ray Disc",
   *         "type_description": "Ad Signage Description" }, { "type": "POS", "value": "BLU-RAY", "type_description": "POS Desc" }, { "type": "SHLF", "value": "BIG LEBOWSKI, THE UNIV", "type_description": "Shelf Desc" }, { "type": "VEND", "value": "BIG LEBOWSKI BD", "type_description":
   *         "Vendor Description" } ] } ] } }
   */
  @GET("/products/v3/{id}?fields=descriptions&id_type=TCIN&key=43cJWpLjH8Z8oR18KdrZDBKAgLLQKJjz")
  public ProductInfo getProductInfo(@Path("id") Integer id);
}
