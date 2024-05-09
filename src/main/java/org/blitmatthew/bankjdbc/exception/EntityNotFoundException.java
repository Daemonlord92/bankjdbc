package org.blitmatthew.bankjdbc.exception;

import org.springframework.dao.DataAccessException;

public class EntityNotFoundException extends DataAccessException {
    public EntityNotFoundException(String msg) {
        super(msg);
    }
}
