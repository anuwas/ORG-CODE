package com.mes.ps.billing.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * This class implements the basic authentication entry point
 * configuration for Billing application APIs.
 */
@Component
public class AuthenticationEntryPoint extends BasicAuthenticationEntryPoint {
	@Value("${app.api.realm}")
	private String realm;
	
	@Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx)
      throws IOException, ServletException {
        response.addHeader("WWW-Authenticate", "Basic realm=" +getRealmName());
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        PrintWriter writer = response.getWriter();
        writer.println("HTTP Status 401 - " + authEx.getMessage());
    }
	
	@Override
    public void afterPropertiesSet() throws Exception {
        setRealmName(realm);
        super.afterPropertiesSet();
    }
}
