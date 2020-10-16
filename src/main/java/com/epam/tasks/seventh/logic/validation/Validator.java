package com.epam.tasks.seventh.logic.validation;

public interface Validator<T> {

    boolean isValid(T object);

}
