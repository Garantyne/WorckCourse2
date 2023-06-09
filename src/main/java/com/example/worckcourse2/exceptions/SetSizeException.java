package com.example.worckcourse2.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.Set;

public class SetSizeException extends ResponseStatusException {
    public SetSizeException(Collection<?> set, int size) {
        super(HttpStatus.BAD_REQUEST, "Size of set is less than " + size);
    }
}