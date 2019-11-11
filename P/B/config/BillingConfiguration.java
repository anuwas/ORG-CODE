package com.mes.ps.billing.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.mes.ps.billing.client.provider.BillingSoapClient;

/**
 * Configuration class for billing application
 */
@Configuration
public class BillingConfiguration extends WebSecurityConfigurerAdapter {
  @Value("${ps.transaction.reporting.endpoint}")
  private String psReportingEndpoint;
  @Value("${app.api.userId}")
  private String appApiAuthUserId;
  @Value("${app.api.password}")
  private String appApiAuthPass;
  @Value("${app.api.role}")
  private String appApiAuthRole;
  private static final String PROFIT_STAR_REPORT_CONTEXT_PATH = "com.mes.ps.billing.dto.profitstars.report";
  private static final String PROFIT_STAR_TXN_CONTEXT_PATH = "com.mes.ps.billing.dto.profitstars.transaction";
  
  @Autowired
  private AuthenticationEntryPoint authEntryPoint;
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
	  http.csrf().disable().authorizeRequests()
	  .anyRequest().authenticated()
	  .and().httpBasic()
	  .authenticationEntryPoint(authEntryPoint);
  }

  /**
   * HTTP Authentication feature configuration for Billing Application APIs
   * @param auth
   * @throws Exception
   */
  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	  auth.inMemoryAuthentication().withUser(appApiAuthUserId).password(appApiAuthPass).roles(appApiAuthRole);
  }

  /**
   * Marshaling configuration for Profitstars Report Service API
   * @return
   */
  @Bean(name = "rptMarshaller")
  public Jaxb2Marshaller marshaller() {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    // this package must match the package in the <generatePackage> specified in pom.xml
    marshaller.setContextPath(PROFIT_STAR_REPORT_CONTEXT_PATH);

    return marshaller;
  }

  /**
   * Marshaling configuration for Profitstars Transaction Service API
   * @return
   */
  @Bean(name = "txnMarshaller")
  public Jaxb2Marshaller txnMarshaller() {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    // this package must match the package in the <generatePackage> specified in pom.xml
    marshaller.setContextPath(PROFIT_STAR_TXN_CONTEXT_PATH);

    return marshaller;
  }

  /**
   * Soap client configuration for Profitstars Report Service API
   * @param marshaller
   * @return
   */
  @Bean
  public BillingSoapClient reportSoapClient(@Qualifier("rptMarshaller") Jaxb2Marshaller marshaller) {
    BillingSoapClient client = new BillingSoapClient();
    client.setDefaultUri(psReportingEndpoint);
    client.setMarshaller(marshaller);
    client.setUnmarshaller(marshaller);

    return client;
  }
  
}
