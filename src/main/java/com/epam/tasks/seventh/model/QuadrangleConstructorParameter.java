package com.epam.tasks.seventh.model;

import com.epam.tasks.seventh.logic.impl.IdGeneratorImpl;
import java.math.BigDecimal;

public class QuadrangleConstructorParameter {
    private int id;
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private Point pointD;

    private QuadrangleConstructorParameter() {
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

    @Override
    public String toString() {
        return "FourPointParameter{" +
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
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        QuadrangleConstructorParameter that = (QuadrangleConstructorParameter) o;

        return pointD.equals(that.pointD) &&
                pointA.equals(that.pointA) &&
                pointB.equals(that.pointB) &&
                pointC.equals(that.pointC);
    }

    @Override
    public int hashCode() {
        int result = pointA.hashCode();
        result = 31 * result + pointB.hashCode();
        result = 31 * result + pointC.hashCode();
        result = 31 * result + pointD.hashCode();
        return result;
    }

    public static class Builder {
        private static final IdGeneratorImpl ID_GENERATOR = new IdGeneratorImpl();
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

        public QuadrangleConstructorParameter build() {
            QuadrangleConstructorParameter parameter = new QuadrangleConstructorParameter();
            parameter.id = ID_GENERATOR.getId();
            parameter.pointA = pointA;
            parameter.pointB = pointB;
            parameter.pointC = pointC;
            parameter.pointD = pointD;
            setPointsToDefault();

            return parameter;
        }

        private void setPointsToDefault() {
            pointA = DEFAULT_POINT;
            pointB = DEFAULT_POINT;
            pointC = DEFAULT_POINT;
            pointD = DEFAULT_POINT;
        }
    }
}
