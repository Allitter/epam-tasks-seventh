package com.epam.tasks.seventh.logic;

import com.epam.tasks.seventh.logic.util.BigDecimalUtil;
import com.epam.tasks.seventh.logic.validation.QuadrangleValidator;
import com.epam.tasks.seventh.model.Point;
import com.epam.tasks.seventh.model.Quadrangle;
import com.epam.tasks.seventh.model.Vector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;

public class QuadrangleLogic {
    private static final Logger LOGGER = LogManager.getLogger();
    private final VectorLogic vectorLogic = new VectorLogic();

    /**
     * Area of quadrangle is calculated using Gauss area formula
     * Area = (1/2) * |(x1y2 + x2y3 + x3y4 + x4y1 - x2y1 - x3y2 - x4y3 -x1y4)|
     * where x1..x4, y1..y4 are coordinates of quadrangle corners
     * */
    public BigDecimal calculateArea(Quadrangle quadrangle) {
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

        LOGGER.info("calculating area " + quadrangle);
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

    public BigDecimal calculatePerimeter(Quadrangle quadrangle) {
        Point a = quadrangle.getPointA();
        Point b = quadrangle.getPointB();
        Point c = quadrangle.getPointC();
        Point d = quadrangle.getPointD();
        LOGGER.info("calculating perimeter " + quadrangle);
        BigDecimal side1 = vectorLogic.countLineLength(a, b);
        BigDecimal side2 = vectorLogic.countLineLength(b, c);
        BigDecimal side3 = vectorLogic.countLineLength(c, d);
        BigDecimal side4 = vectorLogic.countLineLength(a, d);
        BigDecimal result = side1.add(side2).add(side3).add(side4);
        LOGGER.info("perimeter is " + result);
        return result;
    }

    public boolean isSquare(Quadrangle quadrangle) {
        LOGGER.info("is square " + quadrangle);
        boolean result = isRectangle(quadrangle) && isRhombus(quadrangle);
        LOGGER.info("is square result " + result);
        return result;
    }

    public boolean isRhombus(Quadrangle quadrangle) {
        if (!isParallelogram(quadrangle)) {
            return false;
        }
        Point a = quadrangle.getPointA();
        Point b = quadrangle.getPointB();
        Point c = quadrangle.getPointC();
        Point d = quadrangle.getPointD();
        LOGGER.info("is rhombus " + quadrangle);
        BigDecimal side1 = vectorLogic.countLineLength(a, b);
        BigDecimal side2 = vectorLogic.countLineLength(b, c);
        BigDecimal side3 = vectorLogic.countLineLength(c, d);
        BigDecimal side4 = vectorLogic.countLineLength(a, d);

        boolean result = BigDecimalUtil.numbersEqual(side1, side2) &&
                BigDecimalUtil.numbersEqual(side1, side3) &&
                BigDecimalUtil.numbersEqual(side1, side4);
        LOGGER.info("is rhombus " + result);
        return result;
    }

    public boolean isTrapeze(Quadrangle quadrangle) {
        QuadrangleValidator validator = new QuadrangleValidator();
        if (!validator.isQuadrangle(quadrangle)) {
            return false;
        }
        Point a = quadrangle.getPointA();
        Point b = quadrangle.getPointB();
        Point c = quadrangle.getPointC();
        Point d = quadrangle.getPointD();
        LOGGER.info("is trapeze " + quadrangle);
        Vector vectorAB = vectorLogic.createVector(a, b);
        Vector vectorCD = vectorLogic.createVector(c, d);
        Vector vectorBC = vectorLogic.createVector(b, c);
        Vector vectorAD = vectorLogic.createVector(a, d);

        boolean areParallelABAndCD = vectorLogic.areVectorsParallel(vectorAB, vectorCD);
        boolean areParallelBCAndAD = vectorLogic.areVectorsParallel(vectorBC, vectorAD);
        boolean result = areParallelABAndCD ^ areParallelBCAndAD;
        LOGGER.info("is trapeze " + result);
        return result;
    }

    // TODO try to change implementation
    public boolean isConvex(Quadrangle quadrangle) {
        QuadrangleValidator validator = new QuadrangleValidator();
        if (!validator.isQuadrangle(quadrangle)) {
            return false;
        }
        Point a = quadrangle.getPointA();
        Point b = quadrangle.getPointB();
        Point c = quadrangle.getPointC();
        Point d = quadrangle.getPointD();
        LOGGER.info("is convex " + quadrangle);
        boolean result = (getPointLocationRelativeToABLine(a, b, c) < 0
                        == getPointLocationRelativeToABLine(a, b, d) < 0) &&
                (getPointLocationRelativeToABLine(b, c, a) < 0
                        == getPointLocationRelativeToABLine(b, c, d) < 0) &&
                (getPointLocationRelativeToABLine(c, d, a) < 0
                        == getPointLocationRelativeToABLine(c, d, b) < 0) &&
                (getPointLocationRelativeToABLine(a, d, b) < 0
                        == getPointLocationRelativeToABLine(a, d, c) < 0);
        LOGGER.info("is convex " + result);
        return result;
    }

    private boolean isRectangle(Quadrangle quadrangle) {
        if (!isParallelogram(quadrangle)) {
            return false;
        }
        Point a = quadrangle.getPointA();
        Point b = quadrangle.getPointB();
        Point d = quadrangle.getPointD();
        LOGGER.info("is rectangle " + quadrangle);
        Vector vectorAB = vectorLogic.createVector(a, b);
        Vector vectorAD = vectorLogic.createVector(a, d);

        BigDecimal cos = vectorLogic.countCosBetweenVectors(vectorAB, vectorAD);
        boolean result = BigDecimalUtil.numbersEqual(cos, BigDecimal.ZERO);
        LOGGER.info("is rectangle " + result);
        return result;
    }

    private boolean isParallelogram(Quadrangle quadrangle) {
        if (!isConvex(quadrangle)) {
            return false;
        }
        Point a = quadrangle.getPointA();
        Point b = quadrangle.getPointB();
        Point c = quadrangle.getPointC();
        Point d = quadrangle.getPointD();
        LOGGER.info("is parallelogram " + quadrangle);
        Vector vectorAB = vectorLogic.createVector(a, b);
        Vector vectorCD = vectorLogic.createVector(c, d);
        Vector vectorBC = vectorLogic.createVector(b, c);
        Vector vectorAD = vectorLogic.createVector(a, d);

        boolean areParallelABAndCD = vectorLogic.areVectorsParallel(vectorAB, vectorCD);
        boolean areParallelBCAndAD = vectorLogic.areVectorsParallel(vectorBC, vectorAD);
        boolean result = areParallelABAndCD && areParallelBCAndAD;
        LOGGER.info("is parallelogram " + result);
        return result;
    }

    /**
    * (based on straight line equation)
    * result = (х3 - х1) * (у2 - у1) - (у3 - у1) * (х2 - х1)
    * if result = 0 point c lies on ab line
    * if result > 0 point c lies on the right of ab line
    * if result < 0 point c lies on the left of ab line
    * */
    private int getPointLocationRelativeToABLine(Point a, Point b, Point c) {
        BigDecimal x1 = a.getX();
        BigDecimal x2 = b.getX();
        BigDecimal x3 = c.getX();
        BigDecimal y1 = a.getY();
        BigDecimal y2 = b.getY();
        BigDecimal y3 = c.getY();
        LOGGER.info(String.format("getting point {%s} location " +
                "relative to ab {%s, %s} line ", c, a, b));
        int result = x3.subtract(x1).multiply(y2.subtract(y1))
                .subtract(y3.subtract(y1).multiply(x2.subtract(x1))).intValue();
        LOGGER.info("point location relative to ab line is " + result);
        return result;
    }

}
