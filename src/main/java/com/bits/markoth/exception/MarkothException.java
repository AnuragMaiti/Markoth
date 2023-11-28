package com.bits.markoth.exception;

import lombok.Getter;

public class MarkothException extends RuntimeException {
    @Getter
    private final Object resourceId;

    @Getter
    private final Class type;

    public MarkothException() {
        resourceId = null;
        type = null;
    }

    public MarkothException(String message) {
        super(message);
        resourceId = null;
        type = null;
    }

    public MarkothException(String resourceId, Class type) {
        this.resourceId = resourceId;
        this.type = type;
    }

    public MarkothException(Long resourceId, Class type) {
        this.resourceId = resourceId;
        this.type = type;
    }
}
