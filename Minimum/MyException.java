package com.company.Minimum;

public class MyException extends Exception {
    private String msg;

    public MyException(String msg){
        this.msg = msg;
    }

    @Override
    public String getMessage() {
        return msg;
    }
}
