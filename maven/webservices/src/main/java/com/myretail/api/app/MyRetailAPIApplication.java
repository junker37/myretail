/**
 * MetricsWsApplication.java
 * ws
 * 
 * Created by jeremy on Oct 28, 2014
 * DoApp, Inc. owns and reserves all rights to the intellectual
 * property and design of the following application.
 *
 * Copyright 2014 - All rights reserved.  Created by DoApp, Inc.
 */
package com.myretail.api.app;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import java.io.IOException;
import java.util.EnumSet;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration.Dynamic;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import com.myretail.api.resource.ProductsResource;


/**
 * @author jeremy
 *
 */
public class MyRetailAPIApplication extends Application<MyRetailAPIConfiguration> {

  /*
   * (non-Javadoc)
   * 
   * @see io.dropwizard.Application#initialize(io.dropwizard.setup.Bootstrap)
   */
  @Override
  public void initialize(Bootstrap<MyRetailAPIConfiguration> bootstrap) {
    // set a short dns cache time
    // http://docs.aws.amazon.com/AWSSdkDocsJava/latest/DeveloperGuide/java-dg-jvm-ttl.html
    java.security.Security.setProperty("networkaddress.cache.ttl", "60");
  }

  private static class CacheControlFilter implements ContainerResponseFilter {

    /*
     * (non-Javadoc)
     * 
     * @see javax.ws.rs.container.ContainerResponseFilter#filter(javax.ws.rs.container.ContainerRequestContext, javax.ws.rs.container.ContainerResponseContext)
     */
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
      responseContext.getHeaders().add("Cache-Control", "max-age=10, s-maxage=10");
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see io.dropwizard.Application#run(io.dropwizard.Configuration, io.dropwizard.setup.Environment)
   */
  @Override
  public void run(MyRetailAPIConfiguration configuration, Environment environment) throws Exception {
    environment.jersey().register(new ProductsResource());

    // environment.jersey().getResourceConfig().register(CacheControlFilter.class);

    // 0.6.2 - Allow CORS:
    // https://groups.google.com/forum/#!msg/dropwizard-user/QYknyWOZmns/6YA8SmHSGu8J
    // and http://wiki.eclipse.org/Jetty/Feature/Cross_Origin_Filter
    // 0.7.0 -
    // https://groups.google.com/forum/#!searchin/dropwizard-user/0.7.0$20crossoriginfilter/dropwizard-user/xl5dc_i8V24/tbE9geZkJTcJ
    Dynamic filter = environment.servlets().addFilter("CORS", CrossOriginFilter.class);
    filter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
    filter.setInitParameter("allowedOrigins", "*");
    filter.setInitParameter("allowedHeaders", "Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin");
    filter.setInitParameter("allowedMethods", "GET,PUT,POST,DELETE,OPTIONS");
    filter.setInitParameter("preflightMaxAge", "5184000"); // 2 months
    filter.setInitParameter("allowCredentials", "true");
  }

  public static void main(String[] args) throws Exception {
    new MyRetailAPIApplication().run(args);
  }
}
