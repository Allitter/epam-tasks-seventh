package com.epam.tasks.seventh.model;

public class Quadrangle {
    private int id;
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private Point pointD;

    public Quadrangle(QuadrangleConstructorParameter parameter) {
        this.id = parameter.getId();
        this.pointA = parameter.getPointA();
        this.pointB = parameter.getPointB();
        this.pointC = parameter.getPointC();
        this.pointD = parameter.getPointD();
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
}

