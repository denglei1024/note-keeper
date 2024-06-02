package com.github.denglei1024.soloblogger.exception;

/**
 * ResourceNotFoundException
 *
 * @author denglei
 * @since 2024-06-02 11:17
 */
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}