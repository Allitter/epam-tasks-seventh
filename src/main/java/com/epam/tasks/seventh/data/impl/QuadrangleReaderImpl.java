package com.epam.tasks.seventh.data.impl;

import com.epam.tasks.seventh.data.DataReader;
import com.epam.tasks.seventh.data.QuadrangleParser;
import com.epam.tasks.seventh.data.QuadrangleReader;
import com.epam.tasks.seventh.data.validation.QuadrangleInputValidator;
import com.epam.tasks.seventh.model.Quadrangle;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class QuadrangleReaderImpl implements QuadrangleReader {
    private final DataReader reader;
    private final QuadrangleInputValidator validator = new QuadrangleInputValidator();
    private final QuadrangleParser parser;

    public QuadrangleReaderImpl(DataReader reader, QuadrangleParser parser) {
        this.reader = reader;
        this.parser = parser;
    }

    @Override
    public List<Quadrangle> readQuadrangles() {
        List<Quadrangle> result = new LinkedList<>();
        List<String> lines = reader.readAllLines();
        Optional<Quadrangle> parsed;

        for (String line : lines) {
            parsed = getQuadrangleIfValid(line);
            if (parsed.isPresent()) {
                result.add(parsed.get());
            }
        }

        return result;
    }

    private Optional<Quadrangle> getQuadrangleIfValid(String line) {
        return validator.isValid(line) ? parser.parseQuadrangle(line) : Optional.empty();
    }
}
