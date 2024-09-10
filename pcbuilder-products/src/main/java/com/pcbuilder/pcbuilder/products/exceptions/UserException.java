package com.pcbuilder.pcbuilder.products.exceptions;

public class UserException extends ServiceException{
    public UserException() { super();}
    public UserException(String message) { super(message);}

    public UserException(Throwable t) { super(t);}

    public UserException(String message, Throwable t) { super(message, t);}


}
