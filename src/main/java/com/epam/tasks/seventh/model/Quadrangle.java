package com.epam.tasks.seventh.model;

import java.util.Objects;

public class Quadrangle {
    private final Point pointA;
    private final Point pointB;
    private final Point pointC;
    private final Point pointD;

    public Quadrangle(Point pointA, Point pointB, Point pointC, Point pointD) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.pointD = pointD;
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
        return "Quadrangle{" +
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
}
