package com.epam.tasks.seventh.logic;

import com.epam.tasks.seventh.logic.impl.VectorCalculatorImpl;
import com.epam.tasks.seventh.model.Point;
import com.epam.tasks.seventh.model.Vector;
import org.junit.Assert;
import org.junit.Test;
import java.math.BigDecimal;

public class VectorCalculatorTest {
    private final Point point1 = new Point(BigDecimal.valueOf(0), BigDecimal.valueOf(4));
    private final Point point2 = new Point(BigDecimal.valueOf(3), BigDecimal.valueOf(0));
    private final Vector vector1 = new Vector(BigDecimal.valueOf(1), BigDecimal.valueOf(1));
    private final Vector vector2 = new Vector(BigDecimal.valueOf(2), BigDecimal.valueOf(2));
    private final Vector vector3 = new Vector(BigDecimal.valueOf(3), BigDecimal.valueOf(4));

    @Test
    public void testCountLineLengthShouldReturnLengthWhenInputIsCorrect() {
        VectorCalculator vectorCalculator = new VectorCalculatorImpl();
        BigDecimal expected = BigDecimal.valueOf(5)
                .setScale(10, BigDecimal.ROUND_HALF_UP);
        BigDecimal actual = vectorCalculator.countLineLength(point1, point2)
                .setScale(10, BigDecimal.ROUND_HALF_UP);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCountVectorLengthShouldCountLengthWhenInputIsCorrect() {
        VectorCalculator vectorCalculator = new VectorCalculatorImpl();
        BigDecimal expected = BigDecimal.valueOf(5)
                .setScale(10, BigDecimal.ROUND_HALF_UP);

        BigDecimal actual = vectorCalculator.countVectorLength(vector3)
                .setScale(10, BigDecimal.ROUND_HALF_UP);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCountCosBetweenVectorsShouldReturnCosWhenInputIsCorrect() {
        VectorCalculator vectorCalculator = new VectorCalculatorImpl();
        BigDecimal expected = BigDecimal.valueOf(1)
                .setScale(10, BigDecimal.ROUND_HALF_UP);

        BigDecimal actual = vectorCalculator.countCosBetweenVectors(vector1, vector2)
                .setScale(10, BigDecimal.ROUND_HALF_UP);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAreVectorsParallelShouldReturnTrueWhenVectorsParallel() {
        VectorCalculator vectorCalculator = new VectorCalculatorImpl();

        Assert.assertTrue(vectorCalculator.areVectorsParallel(vector1, vector2));
    }

    @Test
    public void testAreVectorsParallelShouldReturnFalseWhenVectorsNotParallel() {
        VectorCalculator vectorCalculator = new VectorCalculatorImpl();

        Assert.assertFalse(vectorCalculator.areVectorsParallel(vector1, vector3));
    }

    @Test
    public void createVectorShouldCreateVectorFromPointsWhenInputIsCorrect() {
        VectorCalculator vectorCalculator = new VectorCalculatorImpl();
        Vector expected = new Vector(BigDecimal.valueOf(3), BigDecimal.valueOf(-4));

        Vector actual = vectorCalculator.createVector(point1, point2);

        Assert.assertEquals(expected, actual);
    }
}