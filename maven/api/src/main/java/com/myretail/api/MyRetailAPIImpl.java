/**
 * MyRetailAPIInstance.java
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
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import com.doapps.myretail.api.info.MyRetailProductInfoAPI;
import com.doapps.myretail.api.info.ProductInfo;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.myretail.api.pricing.MyRetailPricingAPI;
import com.myretail.api.pricing.PricingData;


/**
 * Implentation of the MyRetailAPI
 * 
 * @author jeremy
 *
 */
public class MyRetailAPIImpl implements MyRetailAPI {
  private final MyRetailProductInfoAPI infoAPI;
  private final MyRetailPricingAPI pricingAPI;
  private final ExecutorService executor = Executors.newFixedThreadPool(2, new ThreadFactoryBuilder().setNameFormat("MyRetailAPI %d").build());

  public MyRetailAPIImpl(MyRetailProductInfoAPI infoAPI, MyRetailPricingAPI pricingAPI) {
    this.infoAPI = checkNotNull(infoAPI);
    this.pricingAPI = checkNotNull(pricingAPI);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.myretail.api.MyRetailAPI#getProduct(java.lang.Integer)
   */
  public ProductAPIResult getProduct(Integer id) throws Exception {
    checkNotNull(id);
    CountDownLatch latch = new CountDownLatch(2);

    Future<PricingData> pricingData = executor.submit((Callable<PricingData>) () -> {
      try {
        return pricingAPI.getPricingData(id);
      } finally {
        latch.countDown();
      }
    });
    Future<ProductInfo> productInfo = executor.submit((Callable<ProductInfo>) () -> {
      try {
        return infoAPI.getProductInfo(id);
      } finally {
        latch.countDown();
      }
    });

    if (!latch.await(5, TimeUnit.SECONDS)) {
      throw new Exception("Timeout getting product info");
    }
    return new ProductAPIResult(id, productInfo.get().getName(), pricingData.get());
  }
}
