package org.nowak.exceptions;

public class NoIdClientInDatabaseException extends RuntimeException{
    public NoIdClientInDatabaseException(String message){
        super(message);
    }
}
