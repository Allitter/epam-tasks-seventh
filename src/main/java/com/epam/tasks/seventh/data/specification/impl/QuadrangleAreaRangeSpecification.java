package com.epam.tasks.seventh.data.specification.impl;

import com.epam.tasks.seventh.data.specification.Specification;
import com.epam.tasks.seventh.logic.QuadrangleCalculator;
import com.epam.tasks.seventh.logic.impl.QuadrangleCalculatorImpl;
import com.epam.tasks.seventh.model.Quadrangle;
import java.math.BigDecimal;

public class QuadrangleAreaRangeSpecification implements Specification<Quadrangle> {
    private final BigDecimal minArea;
    private final BigDecimal maxArea;
    private final QuadrangleCalculator quadrangleCalculator;

    public QuadrangleAreaRangeSpecification(BigDecimal minArea, BigDecimal maxArea) {
        this.minArea = minArea;
        this.maxArea = maxArea;
        quadrangleCalculator = new QuadrangleCalculatorImpl();
    }

    /*package private for test*/
    QuadrangleAreaRangeSpecification(BigDecimal minArea,
                                            BigDecimal maxArea,
                                            QuadrangleCalculator calculator) {
        this.minArea = minArea;
        this.maxArea = maxArea;
        quadrangleCalculator = calculator;
    }

    @Override
    public boolean specified(Quadrangle quadrangle) {
        BigDecimal area = quadrangleCalculator.calculateArea(quadrangle);
        return area.compareTo(minArea) >= 0 && area.compareTo(maxArea) <= 0;
    }
}
