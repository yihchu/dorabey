package com.joker.dorabey.model.common;

public class DRBException extends RuntimeException{

    public DRBException() {
        super();
    }

    public DRBException(String message, Throwable cause) {
        super(message, cause);
    }

    public DRBException(String message) {
        super(message);
    }

    public DRBException(Throwable cause) {
        super(cause);
    }

}
