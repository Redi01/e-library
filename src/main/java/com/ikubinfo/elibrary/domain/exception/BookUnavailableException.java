package com.ikubinfo.elibrary.domain.exception;

public class BookUnavailableException extends RuntimeException{

    public BookUnavailableException(String msg){
        super(msg);
    }
}
