package com.epam.tasks.seventh.data.validation.impl;

import com.epam.tasks.seventh.data.validation.InputValidator;

public class QuadrangleInputValidator implements InputValidator {
    //language=RegExp
    private static final String QUADRANGLE_REGEX =
            "(-?\\d+(\\.\\d+)?\\s+){7}(-?\\d+(\\.\\d+)?)";

    @Override
    public boolean isValid(String line) {
        return line.matches(QUADRANGLE_REGEX);
    }
}
