package com.mes.ps.billing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Startup class for this billing application
 */
@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = "com.mes.ps.billing,com.mes.lcr.billing")
//@EnableDiscoveryClient
public class BillingApplication {
  private static final Logger LOGGER = LoggerFactory.getLogger(BillingApplication.class);
  private static final String CONFIG_APPLICATION_NAME = "spring.application.name";
  private static final String CONFIG_MES_DB_ENV = "mes.db.environment";

  public static void main(String[] args) {
    LOGGER.info("Starting BillingApplication");
    ConfigurableApplicationContext context = new SpringApplicationBuilder(BillingApplication.class)

        .properties("spring.config.name:application,billing-config-ps,billing-config-lcr,db-config")
        .build().run(args);

    ConfigurableEnvironment environment = context.getEnvironment();

    LOGGER.info("BillingApplication config file loaded successfully: {}", environment.getProperty(CONFIG_APPLICATION_NAME));
    LOGGER.info("Database config file loaded successfully: {}", environment.getProperty(CONFIG_MES_DB_ENV));
  }
}
