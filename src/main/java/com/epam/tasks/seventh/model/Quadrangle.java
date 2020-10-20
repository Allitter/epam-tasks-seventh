package com.epam.tasks.seventh.model;

import com.epam.tasks.seventh.logic.IdGenerator;
import com.epam.tasks.seventh.logic.impl.IdGeneratorImpl;
import java.math.BigDecimal;

public class Quadrangle {
    private int id;
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private Point pointD;

    private Quadrangle() {
    }

    public Quadrangle(Quadrangle quadrangle) {
        id = quadrangle.id;
        Point a = quadrangle.pointA;
        Point b = quadrangle.pointB;
        Point c = quadrangle.pointC;
        Point d = quadrangle.pointD;
        pointA = new Point(a);
        pointB = new Point(b);
        pointC = new Point(c);
        pointD = new Point(d);
    }

    public int getId() {
        return id;
    }

    public Point getPointA() {
        return pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    public Point getPointD() {
        return pointD;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }

    public void setPointD(Point pointD) {
        this.pointD = pointD;
    }

    @Override
    public String toString() {
        return "Quadrangle{" +
                "pointA=" + pointA +
                ", pointB=" + pointB +
                ", pointC=" + pointC +
                ", pointD=" + pointD +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass())  {
            return false;
        }
        Quadrangle that = (Quadrangle) o;
        return pointA.equals(that.pointA) &&
                pointB.equals(that.pointB) &&
                pointC.equals(that.pointC) &&
                pointD.equals(that.pointD);
    }

    @Override
    public int hashCode() {
        double result = pointA.hashCode();
        result *= pointB.hashCode();
        result += pointC.hashCode();
        result *= pointD.hashCode();
        return (int)result;
    }

    public static class Builder {
        private static final IdGenerator ID_GENERATOR = new IdGeneratorImpl();
        private static final  Point DEFAULT_POINT =
                new Point(BigDecimal.ZERO, BigDecimal.ZERO);
        private Point pointA;
        private Point pointB;
        private Point pointC;
        private Point pointD;

        public Builder() {
            setPointsToDefault();
        }

        /**
         *  null values will be replaced with "0"
         * */
        public void putA(BigDecimal x, BigDecimal y) {
            BigDecimal x1 = x != null ? x : BigDecimal.ZERO;
            BigDecimal y1 = y != null ? y : BigDecimal.ZERO;

            pointA = new Point(x1, y1);
        }

        /**
         *  null values will be replaced with "0"
         * */
        public void putB(BigDecimal x, BigDecimal y) {
            BigDecimal x1 = x != null ? x : BigDecimal.ZERO;
            BigDecimal y1 = y != null ? y : BigDecimal.ZERO;

            pointB = new Point(x1, y1);
        }

        /**
         *  null values will be replaced with "0"
         * */
        public void putC(BigDecimal x, BigDecimal y) {
            BigDecimal x1 = x != null ? x : BigDecimal.ZERO;
            BigDecimal y1 = y != null ? y : BigDecimal.ZERO;

            pointC = new Point(x1, y1);
        }

        /**
         *  null values will be replaced with "0"
         * */
        public void putD(BigDecimal x, BigDecimal y) {
            BigDecimal x1 = x != null ? x : BigDecimal.ZERO;
            BigDecimal y1 = y != null ? y : BigDecimal.ZERO;

            pointD = new Point(x1, y1);
        }

        public Quadrangle build() {
            Quadrangle quadrangle = new Quadrangle();
            quadrangle.id = ID_GENERATOR.getId();
            quadrangle.pointA = pointA;
            quadrangle.pointB = pointB;
            quadrangle.pointC = pointC;
            quadrangle.pointD = pointD;
            setPointsToDefault();

            return quadrangle;
        }

        private void setPointsToDefault() {
            pointA = DEFAULT_POINT;
            pointB = DEFAULT_POINT;
            pointC = DEFAULT_POINT;
            pointD = DEFAULT_POINT;
        }
    }
}

