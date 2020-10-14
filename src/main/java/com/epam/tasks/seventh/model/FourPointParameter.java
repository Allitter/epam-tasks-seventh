package com.epam.tasks.seventh.model;

import java.math.BigDecimal;

public class FourPointParameter {
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private Point pointD;

    private FourPointParameter() {
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

    public static class Builder {
        private final static Point DEFAULT_POINT =
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

        public FourPointParameter build() {
            FourPointParameter parameter = new FourPointParameter();
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FourPointParameter that = (FourPointParameter) o;

        if (!pointA.equals(that.pointA)) return false;
        if (!pointB.equals(that.pointB)) return false;
        if (!pointC.equals(that.pointC)) return false;
        return pointD.equals(that.pointD);
    }

    @Override
    public int hashCode() {
        int result = pointA.hashCode();
        result = 31 * result + pointB.hashCode();
        result = 31 * result + pointC.hashCode();
        result = 31 * result + pointD.hashCode();
        return result;
    }
}
