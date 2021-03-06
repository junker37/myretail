/**
 * MyRetailPricingAPIDynamoDB.java
 * myRetail-api
 * 
 * Created by jeremy on Apr 4, 2015
 * DoApp, Inc. owns and reserves all rights to the intellectual
 * property and design of the following application.
 *
 * Copyright 2015 - All rights reserved.  Created by DoApp, Inc.
 */
package com.myretail.api.pricing;

import static com.google.common.base.Preconditions.checkNotNull;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.model.AttributeAction;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.AttributeValueUpdate;
import com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import com.amazonaws.services.dynamodbv2.model.GetItemResult;
import com.amazonaws.services.dynamodbv2.model.UpdateItemRequest;


/**
 * AWS DynamoDB implemntation of the PricingAPI
 * 
 * @author jeremy
 *
 */
public class MyRetailPricingAPIDynamoDB implements MyRetailPricingAPI {
  public static final String TABLE_NAME = "product-pricing";
  public static final String PRODUCT_ID = "product_id";
  public static final String VALUE = "value";
  public static final String CURRENCY_CODE = "currency_code";
  private final AmazonDynamoDBClient dynamoDB;

  public MyRetailPricingAPIDynamoDB(AmazonDynamoDBClient dynamoDB) {
    this.dynamoDB = checkNotNull(dynamoDB);
  }

  private GetItemResult queryForPricingData(Integer productId) {
    Map<String, AttributeValue> key = new HashMap<>();
    key.put(PRODUCT_ID, new AttributeValue().withN(productId.toString()));
    GetItemRequest getItemRequest = new GetItemRequest(TABLE_NAME, key);
    return dynamoDB.getItem(getItemRequest);
  }

  /**
   * 
   * @param productId the product id
   * @return null unless we find the item and it contains the value AND currency code
   */
  private PricingData readPricingData(Integer productId) {
    GetItemResult result = queryForPricingData(productId);
    Map<String, AttributeValue> item = result.getItem();
    if (item == null) {
      return null;
    }
    BigDecimal value = null;
    AttributeValue valueAttribute = item.get(VALUE);
    if (valueAttribute != null) {
      value = new BigDecimal(valueAttribute.getN());
    } else {
      return null;
    }
    String currencyCode = null;
    AttributeValue currencyCodeAttribute = item.get(CURRENCY_CODE);
    if (currencyCodeAttribute != null) {
      currencyCode = currencyCodeAttribute.getS();
    } else {
      return null;
    }
    // require both value and currency code to create pricing data
    return new PricingData(value, currencyCode);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.myretail.api.pricing.MyRetailPricingAPI#getPricingData(java.lang.Integer)
   */
  @Override
  public PricingData getPricingData(Integer productId) {
    checkNotNull(productId);
    return readPricingData(productId);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.myretail.api.pricing.MyRetailPricingAPI#updatePricingData(java.lang.Integer, com.myretail.api.pricing.PricingData)
   */
  @Override
  public void updatePricingData(Integer productId, PricingData pricingData) {
    checkNotNull(productId, "Product id is null");
    checkNotNull(pricingData, "PricingData is null");
    Map<String, AttributeValue> key = new HashMap<>();
    key.put(PRODUCT_ID, new AttributeValue().withN(productId.toString()));
    Map<String, AttributeValueUpdate> attrUpdates = new HashMap<>();
    attrUpdates.put(VALUE, new AttributeValueUpdate(new AttributeValue().withN(pricingData.value.toString()), AttributeAction.PUT));
    attrUpdates.put(CURRENCY_CODE, new AttributeValueUpdate(new AttributeValue().withS(pricingData.currencyCode), AttributeAction.PUT));
    UpdateItemRequest updateItemRequest = new UpdateItemRequest(TABLE_NAME, key, attrUpdates);
    dynamoDB.updateItem(updateItemRequest);
  }
}
