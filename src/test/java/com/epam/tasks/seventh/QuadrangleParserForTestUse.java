package com.epam.tasks.seventh;

import com.epam.tasks.seventh.model.FourPointParameter;
import com.epam.tasks.seventh.model.Quadrangle;
import java.math.BigDecimal;


public class QuadrangleParserForTestUse {
    // Works only with correct input
    public Quadrangle getQuadrangle(String line) {
        String[] coordinates = splitToCoordinates(line);
        return getQuadrangle(coordinates);
    }

    private Quadrangle getQuadrangle(String[] coordinates) {
        FourPointParameter.Builder builder = new FourPointParameter.Builder();
        builder.putA(new BigDecimal(coordinates[0]), new BigDecimal(coordinates[1]));
        builder.putB(new BigDecimal(coordinates[2]), new BigDecimal(coordinates[3]));
        builder.putC(new BigDecimal(coordinates[4]), new BigDecimal(coordinates[5]));
        builder.putD(new BigDecimal(coordinates[6]), new BigDecimal(coordinates[7]));
        FourPointParameter parameter = builder.build();
        return new Quadrangle(parameter);
    }

    private String[] splitToCoordinates(String line) {
        return line.split("\\s+");
    }
}
