package com.mes.ps.billing.exception;

import com.mes.ps.billing.util.PropertyUtil;
import org.apache.commons.configuration2.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.ws.soap.client.SoapFaultClientException;

import javax.annotation.PostConstruct;

/**
 * Handler class for billing application exceptions
 * based on @ControllerAdvice to be applicable for
 * all controllers, ie: published APIs and job schedulers
 */
@ControllerAdvice
public class GlobalExceptionHandler {
  private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  private Configuration config;

  @PostConstruct
  public void init() {
        config = PropertyUtil.loadProperties("/error-code-mapping.properties");
    }

  /**
   * Global exception handling method for generic exceptions 
   * @param ex
   * @return
   */
  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
    logger.error("", ex);
    ErrorResponse error = new ErrorResponse();

    if (ex instanceof SoapFaultClientException) {
      String message = config.getString("invalid.req.to.ps");
      String[] messageCode = message.split(":");

      String errorMsg = messageCode[1] + " :  " + ex.getMessage();
      error.setCode(Integer.parseInt(messageCode[0]));
      error.setMessage(errorMsg);
    }  else if (ex instanceof RuntimeException) {
      if (ex.getMessage().contains("org.springframework.ws.soap.client.SoapFaultClientException:")) {
        String message = config.getString("invalid.req.to.ps");
        String[] messageCode = message.split(":");

        String errorMsg = messageCode[1] + " :  " + ex.getMessage();
        error.setCode(Integer.parseInt(messageCode[0]));
        error.setMessage(errorMsg);
      } else {
        error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setMessage("Please contact your administrator");
      }
    } else if (ex instanceof org.springframework.web.HttpMediaTypeNotAcceptableException) {
      String message = config.getString("ach.invalid.media.type");
      String[] messageCode = message.split(":");
      error.setCode(Integer.parseInt(messageCode[0]));
      error.setMessage(messageCode[1]);
    } else {
      error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
      error.setMessage("Please contact your administrator");
    }
    
    logger.error("", ex);
    return new ResponseEntity<ErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  /**
   * Global exception handling method for custom billing exceptions 
   * @param ex
   * @return
   */
  @ExceptionHandler(BillingException.class)
  public ResponseEntity<ErrorResponse> billingExceptionHandler(BillingException ex) {
    return new ResponseEntity<ErrorResponse>(getErrorResponse(ex), HttpStatus.BAD_REQUEST);
  }

  /**
   * This method generate ErrorResponse object from custom billing exceptions 
   * @param ex
   * @return
   */
  private ErrorResponse getErrorResponse(BillingException ex) {
    ErrorResponse error = new ErrorResponse();
    ErrorCode errorCode = ex.getErrorCode();
    String message = config.getString(errorCode.getErrorCode());
    String[] messageCode = message.split(":");
    error.setCode(Integer.parseInt(messageCode[0]));
    error.setMessage(messageCode[1]);

    return error;
  }
}