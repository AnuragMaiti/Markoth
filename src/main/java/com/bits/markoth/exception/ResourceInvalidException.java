package com.bits.markoth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource invalid")
public class ResourceInvalidException extends ResourceException {

    private final String reason;

    public ResourceInvalidException() {
        super();
        reason = null;
    }

    public ResourceInvalidException(String resourceId, Class type) {
        super(resourceId, type);

        this.reason = null;
    }

    public ResourceInvalidException(String resourceId, Class type,
                                    String reason) {
        super(resourceId, type);

        this.reason = reason;
    }

    public ResourceInvalidException(Long resourceId, Class type) {
        super(resourceId, type);

        this.reason = null;
    }

    public ResourceInvalidException(Long resourceId, Class type,
                                    String reason) {
        super(resourceId, type);

        this.reason = reason;
    }
}