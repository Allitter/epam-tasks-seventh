package com.epam.tasks.seventh.data.specification.impl;

import com.epam.tasks.seventh.data.specification.Specification;
import com.epam.tasks.seventh.logic.QuadrangleCalculator;
import com.epam.tasks.seventh.logic.impl.QuadrangleCalculatorImpl;
import com.epam.tasks.seventh.model.Quadrangle;
import java.math.BigDecimal;

public class QuadranglePerimeterRangeSpecification implements Specification<Quadrangle> {
    private final BigDecimal minPerimeter;
    private final BigDecimal maxPerimeter;

    public QuadranglePerimeterRangeSpecification(BigDecimal minPerimeter,
                                                 BigDecimal maxPerimeter) {
        this.minPerimeter = minPerimeter;
        this.maxPerimeter = maxPerimeter;
    }

    @Override
    public boolean specified(Quadrangle quadrangle) {
        QuadrangleCalculator logic = new QuadrangleCalculatorImpl();
        BigDecimal area = logic.calculateArea(quadrangle);
        return area.compareTo(minPerimeter) >= 0 &&
                area.compareTo(maxPerimeter) <= 0;
    }
}
