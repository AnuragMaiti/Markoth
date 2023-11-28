package com.bits.markoth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource not found")
public class ResourceNotFoundException extends ResourceException {

    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(String resourceId, Class type) {
        super(resourceId, type);
    }

    public ResourceNotFoundException(Long resourceId, Class type) {
        super(resourceId, type);
    }
}