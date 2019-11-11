package com.mes.ps.billing.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Load mail properties based on environment
 */
@Component
public class Environments {
  @Autowired
  private Environment env;

  public Environments() {
  }

  public boolean getBoolean(String propertyName) {
    String val = get(propertyName);
    return val.equals("true") || val.equals("Y") ? true : false;
  }

  public String get(String propertyName) {
    String val = env.getProperty(propertyName);
    return  val == null ? "" : val;
  }

  public String get(String propertyName, String defaults) {
    String val = get(propertyName);
    return  val == null ? defaults : val;
  }
}
