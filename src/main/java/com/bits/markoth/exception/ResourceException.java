package com.bits.markoth.exception;

import lombok.Getter;

public class ResourceException extends RuntimeException {
    @Getter
    private final Object resourceId;

    @Getter
    private final Class type;

    public ResourceException() {
        resourceId = null;
        type = null;
    }

    public ResourceException(String resourceId, Class type) {
        this.resourceId = resourceId;
        this.type = type;
    }

    public ResourceException(Long resourceId, Class type) {
        this.resourceId = resourceId;
        this.type = type;
    }
}