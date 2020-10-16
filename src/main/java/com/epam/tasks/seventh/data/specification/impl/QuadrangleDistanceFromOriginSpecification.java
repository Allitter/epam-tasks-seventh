package com.epam.tasks.seventh.data.specification.impl;

import com.epam.tasks.seventh.data.specification.Specification;
import com.epam.tasks.seventh.logic.VectorCalculator;
import com.epam.tasks.seventh.logic.impl.VectorCalculatorImpl;
import com.epam.tasks.seventh.model.Point;
import com.epam.tasks.seventh.model.Quadrangle;

import java.math.BigDecimal;

public class QuadrangleDistanceFromOriginSpecification implements Specification<Quadrangle> {
    private final BigDecimal maxDistance;

    public QuadrangleDistanceFromOriginSpecification(BigDecimal maxDistance) {
        this.maxDistance = maxDistance;
    }

    @Override
    public boolean specified(Quadrangle quadrangle) {
        VectorCalculator logic = new VectorCalculatorImpl();
        Point a = quadrangle.getPointA();
        Point b = quadrangle.getPointB();
        Point c = quadrangle.getPointC();
        Point d = quadrangle.getPointD();

        BigDecimal distanceA = logic.countDistanceFromOrigin(a);
        BigDecimal distanceB = logic.countDistanceFromOrigin(b);
        BigDecimal distanceC = logic.countDistanceFromOrigin(c);
        BigDecimal distanceD = logic.countDistanceFromOrigin(d);
        return distanceA.compareTo(maxDistance) <= 0 &&
                distanceB.compareTo(maxDistance) <= 0 &&
                distanceC.compareTo(maxDistance) <= 0 &&
                distanceD.compareTo(maxDistance) <= 0;
    }
}
