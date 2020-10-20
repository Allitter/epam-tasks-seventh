package com.epam.tasks.seventh.logic.comparator;

import com.epam.tasks.seventh.model.Point;
import com.epam.tasks.seventh.model.Quadrangle;
import java.math.BigDecimal;
import java.util.Comparator;

public class QuadrangleFirstPointYComparator implements Comparator<Quadrangle> {
    @Override
    public int compare(Quadrangle firstQuadrangle, Quadrangle secondQuadrangle) {
        Point firstQuadranglePointA = firstQuadrangle.getPointA();
        Point secondQuadranglePointA = secondQuadrangle.getPointA();
        BigDecimal firstQuadrangleFirstPointX = firstQuadranglePointA.getX();
        BigDecimal secondQuadrangleFirstPointX = secondQuadranglePointA.getX();
        return firstQuadrangleFirstPointX.compareTo(secondQuadrangleFirstPointX);
    }
}
