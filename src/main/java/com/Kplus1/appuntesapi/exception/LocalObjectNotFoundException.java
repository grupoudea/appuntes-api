package com.Kplus1.appuntesapi.exception;

public class LocalObjectNotFoundException extends GeneralRuntimeException {

    private static final long serialVersionUID = 1L;

    public LocalObjectNotFoundException(String message){
        super(LocalObjectNotFoundException.class,message);
    }

}
