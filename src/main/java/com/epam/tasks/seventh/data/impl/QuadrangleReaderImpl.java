package com.epam.tasks.seventh.data.impl;

import com.epam.tasks.seventh.data.DataReader;
import com.epam.tasks.seventh.data.validation.InputValidator;
import com.epam.tasks.seventh.data.QuadrangleReader;
import com.epam.tasks.seventh.data.exception.DataException;
import com.epam.tasks.seventh.data.validation.impl.QuadrangleInputValidator;
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
    private final QuadrangleParserImpl parser;

    public QuadrangleReaderImpl(DataReader reader, QuadrangleParserImpl parser) {
        this.reader = reader;
        this.parser = parser;
    }

    @Override
    public List<Quadrangle> readQuadrangles(String link) throws DataException {
        List<String> lines = readAllLines(link);
        return parseValidQuadrangles(lines);
    }

    private List<String> readAllLines(String link) throws DataException {
        List<String> lines;
        try {
            LOGGER.info("trying to read quadrangles");
            lines = reader.readAllLines("");
            LOGGER.info("read quadrangles");
        } catch (IOException e) {
            throw new DataException(e);
        }

        return lines;
    }

    private List<Quadrangle> parseValidQuadrangles(List<String> lines) {
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
