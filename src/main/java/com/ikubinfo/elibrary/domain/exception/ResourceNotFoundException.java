package com.ikubinfo.elibrary.domain.exception;


public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String msg){
        super(msg);
    }
}
