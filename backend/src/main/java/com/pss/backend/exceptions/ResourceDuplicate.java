package com.pss.backend.exceptions;

public class ResourceDuplicate extends RuntimeException {
    public ResourceDuplicate(String message) {
        super(message);
    }
}
