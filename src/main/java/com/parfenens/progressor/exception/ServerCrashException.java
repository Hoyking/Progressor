package com.parfenens.progressor.exception;

public class ServerCrashException extends RuntimeException {

    public ServerCrashException(String reason) {
        super(reason);
    }

}
