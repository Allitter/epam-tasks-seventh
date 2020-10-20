package com.epam.tasks.seventh.data.specification.impl;

import com.epam.tasks.seventh.data.specification.Specification;
import com.epam.tasks.seventh.logic.QuadrangleCalculator;
import com.epam.tasks.seventh.logic.VectorCalculator;
import com.epam.tasks.seventh.logic.impl.VectorCalculatorImpl;
import com.epam.tasks.seventh.model.Point;
import com.epam.tasks.seventh.model.Quadrangle;

import java.math.BigDecimal;

public class QuadrangleDistanceFromOriginSpecification implements Specification<Quadrangle> {
    private final BigDecimal maxDistance;
    private final VectorCalculator vectorCalculator;

    public QuadrangleDistanceFromOriginSpecification(BigDecimal maxDistance) {
        this.maxDistance = maxDistance;
        vectorCalculator = new VectorCalculatorImpl();
    }

    /*package private for test*/
    public QuadrangleDistanceFromOriginSpecification(BigDecimal maxDistance,
                                                     VectorCalculator calculator) {
        this.maxDistance = maxDistance;
        vectorCalculator = calculator;
    }

    @Override
    public boolean specified(Quadrangle quadrangle) {
        Point a = quadrangle.getPointA();
        Point b = quadrangle.getPointB();
        Point c = quadrangle.getPointC();
        Point d = quadrangle.getPointD();

        BigDecimal distanceA = vectorCalculator.countDistanceFromOrigin(a);
        BigDecimal distanceB = vectorCalculator.countDistanceFromOrigin(b);
        BigDecimal distanceC = vectorCalculator.countDistanceFromOrigin(c);
        BigDecimal distanceD = vectorCalculator.countDistanceFromOrigin(d);
        return distanceA.compareTo(maxDistance) <= 0 &&
                distanceB.compareTo(maxDistance) <= 0 &&
                distanceC.compareTo(maxDistance) <= 0 &&
                distanceD.compareTo(maxDistance) <= 0;
    }
}
