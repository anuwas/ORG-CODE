package com.mes.ps.billing.exception;

/**
 * Custom Exception class for billing application
 */
public class BillingException extends RuntimeException {
  private ErrorCode code;
  private static final long serialVersionUID = 1L;

  public BillingException() {
    super();
  }

  public BillingException(String message) {
    super(message);
  }

  public BillingException(String message, Throwable cause) {
    super(message, cause);
  }

  public BillingException(Throwable cause) {
    super(cause);
  }

  public BillingException(ErrorCode code) {
    this.code = code;
  }

  /**
   * Getter method for code
   * @return
   */
  public ErrorCode getErrorCode() {
    return code;
  }
}
