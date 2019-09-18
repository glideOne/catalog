package com.students.catalog.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends RuntimeException {

    private String id;

    public StudentNotFoundException(String id) {
        super(String.format("not found: '%s'", id));
        this.id = id;
    }

}
