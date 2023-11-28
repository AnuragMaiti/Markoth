package com.bits.markoth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Resource already exists")
public class DuplicateResourceException extends ResourceException {
    public DuplicateResourceException() {
        super();
    }

    public DuplicateResourceException(String resourceId, Class type) {
        super(resourceId, type);
    }

    public DuplicateResourceException(Long resourceId, Class type) {
        super(resourceId, type);
    }
}
