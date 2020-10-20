package com.epam.tasks.seventh.data.impl;

import com.epam.tasks.seventh.data.DataReader;
import com.epam.tasks.seventh.data.QuadrangleParser;
import com.epam.tasks.seventh.data.validation.InputValidator;
import com.epam.tasks.seventh.data.QuadrangleReader;
import com.epam.tasks.seventh.data.exception.DataException;
import com.epam.tasks.seventh.data.validation.impl.QuadrangleInputValidator;
import com.epam.tasks.seventh.model.Quadrangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class QuadrangleReaderImpl implements QuadrangleReader {
    private final static Logger LOGGER = LogManager.getLogger();
    private final DataReader reader;
    private final QuadrangleParser parser;

    public QuadrangleReaderImpl(DataReader reader, QuadrangleParser parser) {
        this.reader = reader;
        this.parser = parser;
    }

    @Override
    public List<Quadrangle> readQuadrangles(String link) throws DataException {
        List<String> lines = reader.readAllLines(link);

        List<Quadrangle> result = new LinkedList<>();
        InputValidator validator = new QuadrangleInputValidator();

        LOGGER.info("parsing quadrangles");
        Optional<Quadrangle> parsed;
        for (String line : lines) {
            if (validator.isValid(line)){
                parsed = parser.parseQuadrangle(line);
                if (parsed.isPresent()) {
                    result.add(parsed.get());
                    LOGGER.info("parsed quadrangle " + line);
                }
            } else {
                LOGGER.info("incorrect line " + line);
            }
        }

        return result;
    }
}
