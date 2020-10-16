package com.epam.tasks.seventh.logic.comparator;

import com.epam.tasks.seventh.model.Quadrangle;
import java.util.Comparator;

public class QuadrangleIdComparator implements Comparator<Quadrangle> {
    @Override
    public int compare(Quadrangle o1, Quadrangle o2) {
        int id1 = o1.getId();
        int id2 = o2.getId();
        return id1 - id2;
    }
}
