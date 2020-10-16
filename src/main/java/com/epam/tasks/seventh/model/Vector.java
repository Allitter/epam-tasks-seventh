package com.epam.tasks.seventh.model;

import java.math.BigDecimal;

public class Vector {
    private static final int PRIME_FOR_HASH = 23;
    private final BigDecimal x;
    private final BigDecimal y;

    public Vector(BigDecimal x1, BigDecimal y1) {
        this.x = x1;
        this.y = y1;
    }

    public BigDecimal getX() {
        return x;
    }

    public BigDecimal getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Vector{" +
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
        Vector vector = (Vector) o;
        return vector.x.compareTo(x) == 0 &&
                vector.y.compareTo(y) == 0;
    }

    @Override
    public int hashCode() {
        int xValue = this.x.intValue();
        int yValue = this.y.intValue();
        int result = PRIME_FOR_HASH * xValue + xValue;
        result = PRIME_FOR_HASH * result * yValue + yValue;
        return result;
    }
}
