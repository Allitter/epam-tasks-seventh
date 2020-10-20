package com.epam.tasks.seventh.data.specification.impl;

import com.epam.tasks.seventh.data.specification.Specification;
import com.epam.tasks.seventh.model.Point;
import com.epam.tasks.seventh.model.Quadrangle;
import java.math.BigDecimal;

public class QuadrangleFirstQuadrantSpecification implements Specification<Quadrangle> {
    @Override
    public boolean specified(Quadrangle quadrangle) {
        Point a = quadrangle.getPointA();
        Point b = quadrangle.getPointA();
        Point c = quadrangle.getPointA();
        Point d = quadrangle.getPointA();

        return isPointFirstQuadrant(a) &&
                isPointFirstQuadrant(b) &&
                isPointFirstQuadrant(c) &&
                isPointFirstQuadrant(d);
    }

    private boolean isPointFirstQuadrant(Point point) {
        BigDecimal x = point.getX();
        BigDecimal y = point.getY();

        return x.compareTo(BigDecimal.ZERO) > 0 &&
                y.compareTo(BigDecimal.ZERO) > 0;
    }
}
