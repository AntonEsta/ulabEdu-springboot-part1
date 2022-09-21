package com.edu.ulab.app.storage.exceptions;

public class StorageEntityNotFoundException extends RuntimeException {
    public StorageEntityNotFoundException(String message) {
        super(message);
    }

    public StorageEntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
