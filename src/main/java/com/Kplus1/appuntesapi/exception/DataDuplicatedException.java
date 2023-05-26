package com.Kplus1.appuntesapi.exception;

public class DataDuplicatedException extends GeneralRuntimeException {

    private static final long serialVersionUID = 1L;

    public DataDuplicatedException(String message){
        super(DataDuplicatedException.class, message);
    }

}
