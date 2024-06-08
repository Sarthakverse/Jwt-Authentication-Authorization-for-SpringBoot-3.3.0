package com.securitygateway.loginandsignup.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(){
        super();
    }

    public ResourceNotFoundException(String message){
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable cause){
        super(message, cause);
    }

    public ResourceNotFoundException(Throwable cause){
        super(cause);
    }

    // Returns the detail message string of this throwable.
    @Override
    public String toString(){
        String s = getClass().getName();
        String message = getLocalizedMessage();
        if(message != null){
            return (s + ": " + message);
        }else {
            return s;
        }
    }
}
