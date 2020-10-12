package com.epam.tasks.seventh.data.impl;

import com.epam.tasks.seventh.data.DataReader;
import com.epam.tasks.seventh.data.InputValidator;
import com.epam.tasks.seventh.data.QuadrangleReader;
import com.epam.tasks.seventh.data.exception.DataException;
import com.epam.tasks.seventh.data.validation.QuadrangleInputValidator;
import com.epam.tasks.seventh.model.Quadrangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class QuadrangleReaderImpl implements QuadrangleReader {
    private final static Logger LOGGER = LogManager.getLogger();
    private final DataReader reader;
    private final InputValidator validator = new QuadrangleInputValidator();
    private final QuadrangleParserImpl parser;

    public QuadrangleReaderImpl(DataReader reader, QuadrangleParserImpl parser) {
        this.reader = reader;
        this.parser = parser;
    }

    @Override
    public List<Quadrangle> readQuadrangles() throws DataException {
        List<Quadrangle> result = new LinkedList<>();
        List<String> lines;
        try {
            LOGGER.info("trying to read quadrangle");
            lines = reader.readAllLines();
            LOGGER.info("read quadrangles");
        } catch (IOException e) {
            throw new DataException(e);
        }

        Optional<Quadrangle> parsed;

        LOGGER.info("parsing quadrangles");
        for (String line : lines) {
            parsed = getQuadrangleIfValid(line);
            if (parsed.isPresent()) {
                result.add(parsed.get());
                LOGGER.info("parsed quadrangle " + line);
            } else {
                LOGGER.info("incorrect line " + line);
            }
        }

        return result;
    }

    private Optional<Quadrangle> getQuadrangleIfValid(String line) {
        return validator.isValid(line) ? parser.parseQuadrangle(line) : Optional.empty();
    }
}
