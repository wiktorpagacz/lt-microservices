package com.pagacz.resvault.exception;

public class ResVaultCustomException extends RuntimeException {

    private String errorCode;

    public ResVaultCustomException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
