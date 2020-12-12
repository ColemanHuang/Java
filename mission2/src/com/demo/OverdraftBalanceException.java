package com.demo;

public class OverdraftBalanceException extends RuntimeException {
    public OverdraftBalanceException() {
    }

    public OverdraftBalanceException(String message) {
        super(message);
    }

    public OverdraftBalanceException(String message, Throwable cause) {
        super(message, cause);
    }

    public OverdraftBalanceException(Throwable cause) {
        super(cause);
    }
}
