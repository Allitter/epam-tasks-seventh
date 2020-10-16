package com.epam.tasks.seventh.logic;

import com.epam.tasks.seventh.model.Quadrangle;
import java.math.BigDecimal;

public interface QuadrangleCalculator {
    BigDecimal calculateArea(Quadrangle quadrangle);

    BigDecimal calculatePerimeter(Quadrangle quadrangle);

    boolean isSquare(Quadrangle quadrangle);

    boolean isRhombus(Quadrangle quadrangle);

    boolean isTrapeze(Quadrangle quadrangle);

    boolean isConvex(Quadrangle quadrangle);
}
