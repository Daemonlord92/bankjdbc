package org.blitmatthew.bankjdbc.exception;

import org.springframework.dao.DuplicateKeyException;

public class EntityExistsException extends DuplicateKeyException {
    public EntityExistsException(String msg) {
        super(msg);
    }
}
