package com.mes.ps.billing.config;

import java.sql.SQLException;

import javax.sql.DataSource;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import oracle.jdbc.pool.OracleDataSource;

/**
 * Configuration class for MES database connectivity
 */
@Configuration
@ConfigurationProperties("mes.db")
public class MesDBConfiguration {
  private static final Logger logger = LoggerFactory.getLogger(MesDBConfiguration.class);

  @NotNull
  private String username;
  @NotNull
  private String password;
  @NotNull
  private String url;

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  /**
   * Datasource configuration method for MES database connectivity
   * @return
   * @throws SQLException
   */
  @Bean
  DataSource dataSource() throws SQLException {
    OracleDataSource dataSource = new OracleDataSource();
    dataSource.setUser(username);
    dataSource.setPassword(password);
    dataSource.setURL(url);
    logger.info("MES Datasource Configured successfully");

    return dataSource;
  }
}
