package com.linkTracker.LinkTracker.exceptions;

public class NotActiveUrl extends RuntimeException{
    public NotActiveUrl(String message) {
        super(message);
    }
}
