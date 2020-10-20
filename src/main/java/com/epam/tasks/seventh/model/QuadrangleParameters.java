package com.epam.tasks.seventh.model;

import java.math.BigDecimal;

public class QuadrangleParameters {
    private final BigDecimal area;
    private final BigDecimal perimeter;

    public QuadrangleParameters(BigDecimal area, BigDecimal perimeter) {
        this.area = area;
        this.perimeter = perimeter;
    }

    public BigDecimal getArea() {
        return area;
    }

    public BigDecimal getPerimeter() {
        return perimeter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        QuadrangleParameters that = (QuadrangleParameters) o;
        if (area != null ? !area.equals(that.area) : that.area != null) {
            return false;
        }
        return perimeter != null ? perimeter.equals(that.perimeter) : that.perimeter == null;
    }

    @Override
    public int hashCode() {
        int result = area != null ? area.hashCode() : 0;
        result = 31 * result + (perimeter != null ? perimeter.hashCode() : 0);
        return result;
    }
}
