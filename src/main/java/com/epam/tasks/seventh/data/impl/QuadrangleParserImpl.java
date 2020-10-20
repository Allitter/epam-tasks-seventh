package com.epam.tasks.seventh.data.impl;

import com.epam.tasks.seventh.data.QuadrangleParser;
import com.epam.tasks.seventh.model.Quadrangle;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class QuadrangleParserImpl implements QuadrangleParser {
    private static final String SPLITTER = "\\s+";
    private static final int X_1 = 0;
    private static final int X_2 = 2;
    private static final int X_3 = 4;
    private static final int X_4 = 6;
    private static final int Y_1 = 1;
    private static final int Y_2 = 3;
    private static final int Y_3 = 5;
    private static final int Y_4 = 7;

    public Optional<Quadrangle> parseQuadrangle(String line) {
        List<BigDecimal> coordinates = convertLineToCoordinates(line);
        if (coordinates.size() != 8) {
            return Optional.empty();
        }

        Quadrangle.Builder builder = new Quadrangle.Builder();
        builder.putA(coordinates.get(X_1), coordinates.get(Y_1));
        builder.putB(coordinates.get(X_2), coordinates.get(Y_2));
        builder.putC(coordinates.get(X_3), coordinates.get(Y_3));
        builder.putD(coordinates.get(X_4), coordinates.get(Y_4));
        Quadrangle quadrangle = builder.build();
        return Optional.of(quadrangle);
    }

    private List<BigDecimal> convertLineToCoordinates(String line) {
        String[] coordinates = line.split(SPLITTER);

        List<BigDecimal> result = new ArrayList<>(8);
        for (String coordinate : coordinates) {
            result.add(new BigDecimal(coordinate));
        }

        return result;
    }
}
