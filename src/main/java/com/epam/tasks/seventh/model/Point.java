package com.epam.tasks.seventh.model;

import java.math.BigDecimal;

public class Point implements Cloneable {
    private static final int PRIME_FOR_HASH = 23;
    private static final int ROUND = BigDecimal.ROUND_HALF_UP;
    private static final int SCALE = 20;
    private final BigDecimal x;
    private final BigDecimal y;

    public Point(BigDecimal x1, BigDecimal y1) {
        this.x = x1.setScale(SCALE, ROUND);
        this.y = y1.setScale(SCALE, ROUND);
    }

    public Point(Point point) {
        this.x = point.x;
        this.y = point.y;
    }

    public BigDecimal getX() {
        return x;
    }

    public BigDecimal getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
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
        Point point = (Point) o;
        return point.x.compareTo(x) == 0 &&
                point.y.compareTo(y) == 0;
    }

    @Override
    public int hashCode() {
        int xValue = this.x.intValue();
        int yValue = this.y.intValue();
        int result = PRIME_FOR_HASH * xValue + xValue;
        return PRIME_FOR_HASH * result * yValue + yValue;
    }
}
