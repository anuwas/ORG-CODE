package com.mes.ps.billing.exception;

import java.io.Serializable;

/**
 * ErrorCode Bean
 */
public class ErrorCode implements Serializable {
	private static final long serialVersionUID = 3465992201315896187L;
	
	private String errorCode;

    public ErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
