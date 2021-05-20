/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novatronic.api.eecc.exception;

import java.io.IOException;

/**
 *
 * @author mrios
 */
public class StorageException extends IOException {

    private final String errorCode;
    private final String errorMessage;
    private final int statusCode;

    public StorageException(int statusCode, String errorCode, String errorMessage, Throwable cause) {
        super(cause);
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
