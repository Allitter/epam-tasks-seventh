package com.epam.tasks.seventh.logic;

import com.epam.tasks.seventh.model.Point;
import com.epam.tasks.seventh.model.Vector;
import java.math.BigDecimal;

public class VectorLogic {
    private final BigDecimalUtil bigDecimalUtil = new BigDecimalUtil();

    public BigDecimal countLineLength(Point a, Point b) {
        Vector vector = createVector(a, b);
        return countVectorLength(vector);
    }

    public BigDecimal countVectorLength(Vector vector) {
        BigDecimal x = vector.getX();
        BigDecimal y = vector.getY();

        BigDecimal xSqr = x.pow(2);
        BigDecimal ySqr = y.pow(2);
        BigDecimal sum = xSqr.add(ySqr);
        return bigDecimalUtil.sqrt(sum);
    }

    /**
     * cos between vectors =
     * (x1 * x2 + y1 * y2) / (sqrt(x1^2 + y1^2) * sqrt(x2^2 + y2^2))
     * where x1 and y1 are diagonal vector 1 coordinates and x2, y2 are
     * diagonal vector 2 coordinates
     * */
    public BigDecimal countCosBetweenVectors(Vector vector1, Vector vector2) {
        BigDecimal length1 = countVectorLength(vector1);
        BigDecimal length2 = countVectorLength(vector2);

        Vector multiplied = multiplyVectorsLength(vector1, vector2);
        BigDecimal top = multiplied.getX().add(multiplied.getY());
        BigDecimal bottom = length1.multiply(length2);

        return top.divide(bottom, BigDecimal.ROUND_DOWN);
    }

    public boolean areVectorsParallel(Vector vector1, Vector vector2) {
        BigDecimal cos = countCosBetweenVectors(vector1, vector2);
        cos = cos.abs();
        return bigDecimalUtil.numbersEqual(cos, BigDecimal.ONE);
    }

    public Vector createVector(Point a, Point b) {
        BigDecimal x1 = a.getX();
        BigDecimal x2 = b.getX();
        BigDecimal y1 = a.getY();
        BigDecimal y2 = b.getY();

        BigDecimal xVector = x2.subtract(x1);
        BigDecimal yVector = y2.subtract(y1);
        return new Vector(xVector, yVector);
    }

    public Vector multiplyVectorsLength(Vector vector1, Vector vector2) {
        BigDecimal x1 = vector1.getX();
        BigDecimal x2 = vector2.getX();
        BigDecimal y1 = vector1.getY();
        BigDecimal y2 = vector2.getY();

        BigDecimal x = x1.multiply(x2);
        BigDecimal y = y1.multiply(y2);

        return new Vector(x, y);
    }
}
