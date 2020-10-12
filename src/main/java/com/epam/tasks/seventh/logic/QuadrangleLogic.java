package com.epam.tasks.seventh.logic;

import com.epam.tasks.seventh.model.Point;
import com.epam.tasks.seventh.model.Quadrangle;
import com.epam.tasks.seventh.model.Vector;
import java.math.BigDecimal;

public class QuadrangleLogic {
    private final VectorLogic vectorLogic = new VectorLogic();
    private final BigDecimalUtil bigDecimalUtil = new BigDecimalUtil();

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

        BigDecimal left = x1.multiply(y2)
                .add(x2.multiply(y3))
                .add(x3.multiply(y4))
                .add(x4.multiply(y1));

        BigDecimal right = x2.multiply(y1)
                .add(x3.multiply(y2))
                .add(x4.multiply(y3))
                .add(x1.multiply(y4));
        BigDecimal half = new BigDecimal("0.5");
        return left.subtract(right)
                .multiply(half).abs();
    }

    public BigDecimal calculatePerimeter(Quadrangle quadrangle) {
        Point a = quadrangle.getPointA();
        Point b = quadrangle.getPointB();
        Point c = quadrangle.getPointC();
        Point d = quadrangle.getPointD();

        BigDecimal side1 = vectorLogic.countLineLength(a, b);
        BigDecimal side2 = vectorLogic.countLineLength(b, c);
        BigDecimal side3 = vectorLogic.countLineLength(c, d);
        BigDecimal side4 = vectorLogic.countLineLength(a, d);

        return side1.add(side2).add(side3).add(side4);
    }

    public boolean isSquare(Quadrangle quadrangle) {
        return isRectangle(quadrangle) && isRhombus(quadrangle);
    }

    public boolean isRhombus(Quadrangle quadrangle) {
        if (!isParallelogram(quadrangle)) {
            return false;
        }
        Point a = quadrangle.getPointA();
        Point b = quadrangle.getPointB();
        Point c = quadrangle.getPointC();
        Point d = quadrangle.getPointD();

        BigDecimal side1 = vectorLogic.countLineLength(a, b);
        BigDecimal side2 = vectorLogic.countLineLength(b, c);
        BigDecimal side3 = vectorLogic.countLineLength(c, d);
        BigDecimal side4 = vectorLogic.countLineLength(a, d);

        return  bigDecimalUtil.numbersEqual(side1, side2) &&
                bigDecimalUtil.numbersEqual(side1, side3) &&
                bigDecimalUtil.numbersEqual(side1, side4);
    }

    public boolean isTrapeze(Quadrangle quadrangle) {
        if (!isQuadrangle(quadrangle)) {
            return false;
        }
        Point a = quadrangle.getPointA();
        Point b = quadrangle.getPointB();
        Point c = quadrangle.getPointC();
        Point d = quadrangle.getPointD();

        Vector vectorAB = vectorLogic.createVector(a, b);
        Vector vectorCD = vectorLogic.createVector(c, d);
        Vector vectorBC = vectorLogic.createVector(b, c);
        Vector vectorAD = vectorLogic.createVector(a, d);

        boolean areParallelABAndCD = vectorLogic.areVectorsParallel(vectorAB, vectorCD);
        boolean areParallelBCAndAD = vectorLogic.areVectorsParallel(vectorBC, vectorAD);

        return areParallelABAndCD ^ areParallelBCAndAD;
    }

    public boolean isQuadrangle(Quadrangle quadrangle) {
        Point a = quadrangle.getPointA();
        Point b = quadrangle.getPointB();
        Point c = quadrangle.getPointC();
        Point d = quadrangle.getPointD();

        return !(areDotsOnOneLine(a, b, c) || areDotsOnOneLine(a, b, d)
                || areDotsOnOneLine(b, c, d) || areDotsOnOneLine(a, c, d));
    }

    // TODO try to change implementation
    public boolean isConvex(Quadrangle quadrangle) {
        if (!isQuadrangle(quadrangle)) {
            return false;
        }
        Point a = quadrangle.getPointA();
        Point b = quadrangle.getPointB();
        Point c = quadrangle.getPointC();
        Point d = quadrangle.getPointD();

        return (getPointLocationRelativeToABLine(a, b, c) < 0
                == getPointLocationRelativeToABLine(a, b, d) < 0) &&
                (getPointLocationRelativeToABLine(b, c, a) < 0
                        == getPointLocationRelativeToABLine(b, c, d) < 0) &&
                (getPointLocationRelativeToABLine(c, d, a) < 0
                        == getPointLocationRelativeToABLine(c, d, b) < 0) &&
                (getPointLocationRelativeToABLine(a, d, b) < 0
                        == getPointLocationRelativeToABLine(a, d, c) < 0);
    }

    private boolean isRectangle(Quadrangle quadrangle) {
        if (!isParallelogram(quadrangle)) {
            return false;
        }
        Point a = quadrangle.getPointA();
        Point b = quadrangle.getPointB();
        Point d = quadrangle.getPointD();

        Vector vectorAB = vectorLogic.createVector(a, b);
        Vector vectorAD = vectorLogic.createVector(a, d);

        BigDecimal cos = vectorLogic.countCosBetweenVectors(vectorAB, vectorAD);

        return bigDecimalUtil.numbersEqual(cos, BigDecimal.ZERO);
    }

    private boolean isParallelogram(Quadrangle quadrangle) {
        if (!isConvex(quadrangle)) {
            return false;
        }
        Point a = quadrangle.getPointA();
        Point b = quadrangle.getPointB();
        Point c = quadrangle.getPointC();
        Point d = quadrangle.getPointD();

        Vector vectorAB = vectorLogic.createVector(a, b);
        Vector vectorCD = vectorLogic.createVector(c, d);
        Vector vectorBC = vectorLogic.createVector(b, c);
        Vector vectorAD = vectorLogic.createVector(a, d);

        boolean areParallelABAndCD = vectorLogic.areVectorsParallel(vectorAB, vectorCD);
        boolean areParallelBCAndAD = vectorLogic.areVectorsParallel(vectorBC, vectorAD);

        return areParallelABAndCD && areParallelBCAndAD;
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

        return x3.subtract(x1).multiply(y2.subtract(y1))
                .subtract(y3.subtract(y1).multiply(x2.subtract(x1))).intValue();
    }

    /**
     * straight line equation
     * (y3 - y1) * (x2 - x1) = (y2 - y1) * (x3 - x1)
     * */
    private boolean areDotsOnOneLine(Point a, Point b, Point c) {
        BigDecimal x1 = a.getX();
        BigDecimal x2 = b.getX();
        BigDecimal x3 = c.getX();
        BigDecimal y1 = a.getY();
        BigDecimal y2 = b.getY();
        BigDecimal y3 = c.getY();

        BigDecimal left = y3.subtract(y1).multiply(x2.subtract(x1));
        BigDecimal right = y2.subtract(y1).multiply(x3.subtract(x1));

        return bigDecimalUtil.numbersEqual(left, right);
    }

}
