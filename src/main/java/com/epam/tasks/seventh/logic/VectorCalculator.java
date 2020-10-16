package com.epam.tasks.seventh.logic;

import com.epam.tasks.seventh.model.Point;
import com.epam.tasks.seventh.model.Vector;

import java.math.BigDecimal;

public interface VectorCalculator {
    BigDecimal countLineLength(Point a, Point b);

    BigDecimal countDistanceFromOrigin(Point a);

    BigDecimal countVectorLength(Vector vector);

    BigDecimal countCosBetweenVectors(Vector vector1, Vector vector2);

    boolean areVectorsParallel(Vector vector1, Vector vector2);

    Vector createVector(Point a, Point b);

    int getPointLocationRelativeToABLine(Point a, Point b, Point c);
}
