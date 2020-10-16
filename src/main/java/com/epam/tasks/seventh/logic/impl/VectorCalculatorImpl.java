package com.epam.tasks.seventh.logic.impl;

import com.epam.tasks.seventh.logic.VectorCalculator;
import com.epam.tasks.seventh.logic.util.BigDecimalUtil;
import com.epam.tasks.seventh.model.Point;
import com.epam.tasks.seventh.model.Vector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.math.BigDecimal;

public class VectorCalculatorImpl implements VectorCalculator {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public BigDecimal countLineLength(Point a, Point b) {
        LOGGER.info(String.format("count line a,b {%s, %s} length", a, b));
        Vector vector = createVector(a, b);
        BigDecimal result = countVectorLength(vector);
        LOGGER.info("line length is " + result);
        return result;
    }

    @Override
    public BigDecimal countDistanceFromOrigin(Point a) {
        LOGGER.info(String.format("count distance from origin to point a {%s}", a));
        Point origin = new Point(BigDecimal.ZERO, BigDecimal.ZERO);
        Vector vector = createVector(a, origin);
        BigDecimal result = countVectorLength(vector);
        LOGGER.info("line length is " + result);
        return result;
    }

    @Override
    public BigDecimal countVectorLength(Vector vector) {
        LOGGER.info("count vector length " + vector);
        BigDecimal x = vector.getX();
        BigDecimal y = vector.getY();
        BigDecimal xSqr = x.pow(2);
        BigDecimal ySqr = y.pow(2);
        BigDecimal sum = xSqr.add(ySqr);
        BigDecimal result = BigDecimalUtil.sqrt(sum);
        LOGGER.info("vector length is " + result);
        return result;
    }

    /**
     * cos between vectors =
     * (x1 * x2 + y1 * y2) / (sqrt(x1^2 + y1^2) * sqrt(x2^2 + y2^2))
     * where x1 and y1 are diagonal vector 1 coordinates and x2, y2 are
     * diagonal vector 2 coordinates
     * */
    @Override
    public BigDecimal countCosBetweenVectors(Vector vector1, Vector vector2) {
        LOGGER.info(String.format("count cos between vectors {%s, %s}", vector1, vector2));
        BigDecimal length1 = countVectorLength(vector1);
        BigDecimal length2 = countVectorLength(vector2);
        Vector multiplied = multiplyVectorsLength(vector1, vector2);
        BigDecimal top = multiplied.getX().add(multiplied.getY());
        BigDecimal bottom = length1.multiply(length2);
        BigDecimal result = top.divide(bottom, BigDecimal.ROUND_DOWN);
        LOGGER.info("cos between two vectors is " + result);
        return result;
    }

    @Override
    public boolean areVectorsParallel(Vector vector1, Vector vector2) {
        LOGGER.info(String.format("are vectors parallel {%s, %s}", vector1, vector2));
        BigDecimal cos = countCosBetweenVectors(vector1, vector2);
        cos = cos.abs();
        boolean result = BigDecimalUtil.numbersEqual(cos, BigDecimal.ONE);
        LOGGER.info("are vectors parallel " + result);
        return result;
    }

    @Override
    public Vector createVector(Point a, Point b) {
        BigDecimal x1 = a.getX();
        BigDecimal x2 = b.getX();
        BigDecimal y1 = a.getY();
        BigDecimal y2 = b.getY();

        BigDecimal xVector = x2.subtract(x1);
        BigDecimal yVector = y2.subtract(y1);
        return new Vector(xVector, yVector);
    }

    private Vector multiplyVectorsLength(Vector vector1, Vector vector2) {
        BigDecimal x1 = vector1.getX();
        BigDecimal x2 = vector2.getX();
        BigDecimal y1 = vector1.getY();
        BigDecimal y2 = vector2.getY();

        BigDecimal x = x1.multiply(x2);
        BigDecimal y = y1.multiply(y2);

        return new Vector(x, y);
    }

    /**
     * First two parameters define the AB line
     * (based on straight line equation)
     * result = (х3 - х1) * (у2 - у1) - (у3 - у1) * (х2 - х1)
     * if result = 0 point c lies on AB line
     * if result > 0 point c lies on the right of AB line
     * if result < 0 point c lies on the left of AB line
     * */
    public int getPointLocationRelativeToABLine(Point a, Point b, Point c) {
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
