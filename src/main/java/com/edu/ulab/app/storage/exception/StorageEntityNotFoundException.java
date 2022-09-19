package com.edu.ulab.app.storage.exception;

public class StorageEntityNotFoundException extends RuntimeException {
    public StorageEntityNotFoundException(String message) {
        super(message);
    }

    public StorageEntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
