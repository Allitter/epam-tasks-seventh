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
    public static final int X_1 = 0;
    public static final int X_2 = 2;
    public static final int X_3 = 4;
    public static final int X_4 = 6;
    public static final int Y_1 = 1;
    public static final int Y_2 = 3;
    public static final int Y_3 = 5;
    public static final int Y_4 = 7;

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
            builder.putA(numbers[X_1], numbers[Y_1]);
            builder.putB(numbers[X_2], numbers[Y_2]);
            builder.putC(numbers[X_3], numbers[Y_3]);
            builder.putD(numbers[X_4], numbers[Y_4]);
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
