package com.epam.tasks.seventh.logic.comparator;

import com.epam.tasks.seventh.model.Point;
import com.epam.tasks.seventh.model.Quadrangle;
import java.util.Comparator;

public class QuadrangleFirstPointYComparator implements Comparator<Quadrangle> {
    @Override
    public int compare(Quadrangle o1, Quadrangle o2) {
        Point a = o1.getPointA();
        Point b = o2.getPointB();
        return a.getY().compareTo(b.getY());
    }
}
