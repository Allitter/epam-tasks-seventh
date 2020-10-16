package com.epam.tasks.seventh.logic.impl;

import com.epam.tasks.seventh.logic.QuadrangleCalculator;
import com.epam.tasks.seventh.logic.VectorCalculator;
import com.epam.tasks.seventh.logic.util.BigDecimalUtil;
import com.epam.tasks.seventh.logic.validation.Validator;
import com.epam.tasks.seventh.logic.validation.impl.QuadrangleValidator;
import com.epam.tasks.seventh.model.Point;
import com.epam.tasks.seventh.model.Quadrangle;
import com.epam.tasks.seventh.model.Vector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.math.BigDecimal;

public class QuadrangleCalculatorImpl implements QuadrangleCalculator {
    private static final Logger LOGGER = LogManager.getLogger();
    private final VectorCalculator vectorCalculator = new VectorCalculatorImpl();

    /**
     * Area of quadrangle is calculated using Gauss area formula
     * Area = (1/2) * |(x1y2 + x2y3 + x3y4 + x4y1 - x2y1 - x3y2 - x4y3 -x1y4)|
     * where x1..x4, y1..y4 are coordinates of quadrangle corners
     * */
    @Override
    public BigDecimal calculateArea(Quadrangle quadrangle) {
        LOGGER.info("calculating area " + quadrangle);
        Point a = quadrangle.getPointA();
        Point b = quadrangle.getPointB();
        Point c = quadrangle.getPointC();
        Point d = quadrangle.getPointD();
        BigDecimal x1 = a.getX();
        BigDecimal x2 = b.getX();
        BigDecimal x3 = c.getX();
        BigDecimal x4 = d.getX();
        BigDecimal y1 = a.getY();
        BigDecimal y2 = b.getY();
        BigDecimal y3 = c.getY();
        BigDecimal y4 = d.getY();

        BigDecimal left = x1.multiply(y2)
                .add(x2.multiply(y3))
                .add(x3.multiply(y4))
                .add(x4.multiply(y1));

        BigDecimal right = x2.multiply(y1)
                .add(x3.multiply(y2))
                .add(x4.multiply(y3))
                .add(x1.multiply(y4));
        BigDecimal half = new BigDecimal("0.5");

        BigDecimal result = left.subtract(right)
                .multiply(half).abs();
        LOGGER.info("area is " + result);
        return result;
    }

    @Override
    public BigDecimal calculatePerimeter(Quadrangle quadrangle) {
        LOGGER.info("calculating perimeter " + quadrangle);
        Point a = quadrangle.getPointA();
        Point b = quadrangle.getPointB();
        Point c = quadrangle.getPointC();
        Point d = quadrangle.getPointD();
        BigDecimal side1 = vectorCalculator.countLineLength(a, b);
        BigDecimal side2 = vectorCalculator.countLineLength(b, c);
        BigDecimal side3 = vectorCalculator.countLineLength(c, d);
        BigDecimal side4 = vectorCalculator.countLineLength(a, d);
        BigDecimal result = side1.add(side2).add(side3).add(side4);
        LOGGER.info("perimeter is " + result);
        return result;
    }

    @Override
    public boolean isSquare(Quadrangle quadrangle) {
        LOGGER.info("is square " + quadrangle);
        boolean result = isRectangle(quadrangle) && isRhombus(quadrangle);
        LOGGER.info("is square result " + result);
        return result;
    }

    @Override
    public boolean isRhombus(Quadrangle quadrangle) {
        LOGGER.info("is rhombus " + quadrangle);
        if (!isParallelogram(quadrangle)) {
            LOGGER.info("is rhombus " + false);
            return false;
        }
        Point a = quadrangle.getPointA();
        Point b = quadrangle.getPointB();
        Point c = quadrangle.getPointC();
        Point d = quadrangle.getPointD();
        BigDecimal side1 = vectorCalculator.countLineLength(a, b);
        BigDecimal side2 = vectorCalculator.countLineLength(b, c);
        BigDecimal side3 = vectorCalculator.countLineLength(c, d);
        BigDecimal side4 = vectorCalculator.countLineLength(a, d);

        boolean result = BigDecimalUtil.numbersEqual(side1, side2) &&
                BigDecimalUtil.numbersEqual(side1, side3) &&
                BigDecimalUtil.numbersEqual(side1, side4);
        LOGGER.info("is rhombus " + result);
        return result;
    }

    @Override
    public boolean isTrapeze(Quadrangle quadrangle) {
        QuadrangleValidator validator = new QuadrangleValidator();
        LOGGER.info("is trapeze " + quadrangle);
        if (!validator.isValid(quadrangle)) {
            LOGGER.info("is trapeze " + false);
            return false;
        }
        Point a = quadrangle.getPointA();
        Point b = quadrangle.getPointB();
        Point c = quadrangle.getPointC();
        Point d = quadrangle.getPointD();
        Vector vectorAB = vectorCalculator.createVector(a, b);
        Vector vectorCD = vectorCalculator.createVector(c, d);
        Vector vectorBC = vectorCalculator.createVector(b, c);
        Vector vectorAD = vectorCalculator.createVector(a, d);

        boolean areParallelABAndCD = vectorCalculator.areVectorsParallel(vectorAB, vectorCD);
        boolean areParallelBCAndAD = vectorCalculator.areVectorsParallel(vectorBC, vectorAD);
        boolean result = areParallelABAndCD ^ areParallelBCAndAD;
        LOGGER.info("is trapeze " + result);
        return result;
    }

    // TODO try to change implementation
    @Override
    public boolean isConvex(Quadrangle quadrangle) {
        Validator<Quadrangle> validator = new QuadrangleValidator();
        LOGGER.info("is convex " + quadrangle);
        if (!validator.isValid(quadrangle)) {
            LOGGER.info("is convex " + false);
            return false;
        }
        Point a = quadrangle.getPointA();
        Point b = quadrangle.getPointB();
        Point c = quadrangle.getPointC();
        Point d = quadrangle.getPointD();
        boolean result = (vectorCalculator.getPointLocationRelativeToABLine(a, b, c) < 0
                        == vectorCalculator.getPointLocationRelativeToABLine(a, b, d) < 0) &&
                (vectorCalculator.getPointLocationRelativeToABLine(c, d, a) < 0
                        == vectorCalculator.getPointLocationRelativeToABLine(c, d, b) < 0);
        LOGGER.info("is convex " + result);
        return result;
    }

    private boolean isRectangle(Quadrangle quadrangle) {
        LOGGER.info("is rectangle " + quadrangle);
        if (!isParallelogram(quadrangle)) {
            LOGGER.info("is rectangle " + false);
            return false;
        }
        Point a = quadrangle.getPointA();
        Point b = quadrangle.getPointB();
        Point d = quadrangle.getPointD();
        Vector vectorAB = vectorCalculator.createVector(a, b);
        Vector vectorAD = vectorCalculator.createVector(a, d);

        BigDecimal cos = vectorCalculator.countCosBetweenVectors(vectorAB, vectorAD);
        boolean result = BigDecimalUtil.numbersEqual(cos, BigDecimal.ZERO);
        LOGGER.info("is rectangle " + result);
        return result;
    }

    private boolean isParallelogram(Quadrangle quadrangle) {
        LOGGER.info("is parallelogram " + quadrangle);
        if (!isConvex(quadrangle)) {
            LOGGER.info("is parallelogram " + false);
            return false;
        }
        Point a = quadrangle.getPointA();
        Point b = quadrangle.getPointB();
        Point c = quadrangle.getPointC();
        Point d = quadrangle.getPointD();
        Vector vectorAB = vectorCalculator.createVector(a, b);
        Vector vectorCD = vectorCalculator.createVector(c, d);
        Vector vectorBC = vectorCalculator.createVector(b, c);
        Vector vectorAD = vectorCalculator.createVector(a, d);

        boolean areParallelABAndCD = vectorCalculator.areVectorsParallel(vectorAB, vectorCD);
        boolean areParallelBCAndAD = vectorCalculator.areVectorsParallel(vectorBC, vectorAD);
        boolean result = areParallelABAndCD && areParallelBCAndAD;
        LOGGER.info("is parallelogram " + result);
        return result;
    }

}
