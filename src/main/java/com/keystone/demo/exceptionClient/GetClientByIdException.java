package com.keystone.demo.exceptionClient;

public class GetClientByIdException extends Exception{
    public GetClientByIdException(String msg) {
        super(msg);
    }
}
