package com.epam.tasks.seventh.data.impl;

import com.epam.tasks.seventh.data.QuadrangleParser;
import com.epam.tasks.seventh.model.FourPointParameter;
import com.epam.tasks.seventh.model.Quadrangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.math.BigDecimal;
import java.util.Optional;

public class QuadrangleParserImpl implements QuadrangleParser {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String SPLITTER = "\\s+";

    public Optional<Quadrangle> parseQuadrangle(String line) {
        String[] split = line.split(SPLITTER);
        BigDecimal[] numbers = new BigDecimal[split.length];
        Optional<Quadrangle> result;
        LOGGER.info("trying to create quadrangle");
        try {
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = new BigDecimal(split[i]);
            }

            FourPointParameter.Builder builder = new FourPointParameter.Builder();
            builder.putA(numbers[0], numbers[1]);
            builder.putB(numbers[2], numbers[3]);
            builder.putC(numbers[4], numbers[5]);
            builder.putD(numbers[6], numbers[7]);
            FourPointParameter parameter = builder.build();
            result = Optional.of(new Quadrangle(parameter));
            LOGGER.info("quadrangle created");
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            LOGGER.warn("incorrect line");
            result = Optional.empty();
        }

        return result;
    }
}
