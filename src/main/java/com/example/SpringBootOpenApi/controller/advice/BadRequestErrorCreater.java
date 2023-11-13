package com.example.SpringBootOpenApi.controller.advice;

import com.example.todoapi.model.BadRequestError;
import com.example.todoapi.model.InvalidParam;
import jakarta.validation.ConstraintViolationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.stream.Collectors;

public class BadRequestErrorCreater {
    public static BadRequestError from(MethodArgumentNotValidException ex) {
        var invalidParamList = ex.getFieldErrors()
                .stream()
                .map(BadRequestErrorCreater::createInvalidParam)
                .collect(Collectors.toList());
        var error = new BadRequestError();
        error.setInvalidParams(invalidParamList);

        return error;
    }

    private static InvalidParam createInvalidParam(FieldError fieldError) {
        var invalidParam = new InvalidParam();
        invalidParam.setName(fieldError.getField());
        invalidParam.setReason(fieldError.getDefaultMessage());
        return invalidParam;
    }

    public static BadRequestError from(ConstraintViolationException ex) {
        return new BadRequestError();
    }
}
