package com.epam.tasks.seventh.data;

import com.epam.tasks.seventh.model.QuadrangleConstructorParameter;
import com.epam.tasks.seventh.model.Quadrangle;
import java.math.BigDecimal;

/**
 * Only for test use
 * Works with correct input :
 * "x1 x2 x3 x4 x5 x6 x7 x8", where x(i) is a real or integer number
 * */
public class QuadrangleParserForTestUse {
    private static final int X_1 = 0;
    private static final int Y_1 = 1;
    private static final int X_2 = 2;
    private static final int Y_2 = 3;
    private static final int X_3 = 4;
    private static final int Y_3 = 5;
    private static final int X_4 = 6;
    private static final int Y_4 = 7;
    private static final String SPLITTER = "\\s+";

    // Works only with correct input
    public Quadrangle getQuadrangle(String line) {
        String[] coordinates = splitToCoordinates(line);
        return getQuadrangle(coordinates);
    }

    private Quadrangle getQuadrangle(String[] coordinates) {
        QuadrangleConstructorParameter.Builder builder = new QuadrangleConstructorParameter.Builder();
        builder.putA(new BigDecimal(coordinates[X_1]), new BigDecimal(coordinates[Y_1]));
        builder.putB(new BigDecimal(coordinates[X_2]), new BigDecimal(coordinates[Y_2]));
        builder.putC(new BigDecimal(coordinates[X_3]), new BigDecimal(coordinates[Y_3]));
        builder.putD(new BigDecimal(coordinates[X_4]), new BigDecimal(coordinates[Y_4]));
        QuadrangleConstructorParameter parameter = builder.build();
        return new Quadrangle(parameter);
    }

    private String[] splitToCoordinates(String line) {
        return line.split(SPLITTER);
    }
}
