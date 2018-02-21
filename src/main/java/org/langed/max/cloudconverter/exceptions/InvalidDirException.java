package org.langed.max.cloudconverter.exceptions;

/**
 * Created by max on 21.02.18.
 */
public class InvalidDirException extends Exception {


    public InvalidDirException() {
        super();
    }


    public InvalidDirException(String message) {
        super(message);
    }

    public InvalidDirException(String message, Throwable cause) {
        super(message, cause);
    }
}
