package com.pcbuilder.pcbuilder.products.exceptions;

import java.io.Serializable;

public abstract class ServiceException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 202402251147L;

    public ServiceException(){
        super();
    }
    public ServiceException(String message){
        super(message);
    }

    public ServiceException(Throwable t){
        super(t);
    }

    public ServiceException(String message, Throwable t){
        super(message, t);
    }
}
