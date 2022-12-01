package com.example.algorithms_1_1;

public class StrorageIsFullExpcetion extends RuntimeException {
    public StrorageIsFullExpcetion() {
    }

    public StrorageIsFullExpcetion(String message) {
        super(message);
    }

    public StrorageIsFullExpcetion(String message, Throwable cause) {
        super(message, cause);
    }

    public StrorageIsFullExpcetion(Throwable cause) {
        super(cause);
    }

    public StrorageIsFullExpcetion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
