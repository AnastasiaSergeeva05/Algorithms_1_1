package com.example.algorithms_1_1;

public class invalIndexException extends RuntimeException {
    public invalIndexException() {
    }

    public invalIndexException(String message) {
        super(message);
    }

    public invalIndexException(String message, Throwable cause) {
        super(message, cause);
    }

    public invalIndexException(Throwable cause) {
        super(cause);
    }

    public invalIndexException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
