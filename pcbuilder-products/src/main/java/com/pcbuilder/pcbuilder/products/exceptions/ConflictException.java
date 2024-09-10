package com.pcbuilder.pcbuilder.products.exceptions;

public class ConflictException extends ServiceException{
    public ConflictException() { super();}
    public ConflictException(String message) { super(message);}

    public ConflictException(Throwable t) { super(t);}

    public ConflictException(String message, Throwable t) { super(message, t);}


}
