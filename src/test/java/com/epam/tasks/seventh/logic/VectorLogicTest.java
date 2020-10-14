package com.epam.tasks.seventh.logic;

import com.epam.tasks.seventh.model.Point;
import com.epam.tasks.seventh.model.Vector;
import org.junit.Assert;
import org.junit.Test;
import java.math.BigDecimal;

public class VectorLogicTest {
    private final Point point1 = new Point(BigDecimal.valueOf(0), BigDecimal.valueOf(4));
    private final Point point2 = new Point(BigDecimal.valueOf(3), BigDecimal.valueOf(0));
    private final Vector vector1 = new Vector(BigDecimal.valueOf(1), BigDecimal.valueOf(1));
    private final Vector vector2 = new Vector(BigDecimal.valueOf(2), BigDecimal.valueOf(2));
    private final Vector vector3 = new Vector(BigDecimal.valueOf(3), BigDecimal.valueOf(4));

    @Test
    public void testCountLineLengthShouldReturnLengthWhenInputIsCorrect() {
        VectorLogic vectorLogic = new VectorLogic();
        BigDecimal expected = BigDecimal.valueOf(5)
                .setScale(10, BigDecimal.ROUND_HALF_UP);
        BigDecimal actual = vectorLogic.countLineLength(point1, point2)
                .setScale(10, BigDecimal.ROUND_HALF_UP);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCountVectorLengthShouldCountLengthWhenInputIsCorrect() {
        VectorLogic vectorLogic = new VectorLogic();
        BigDecimal expected = BigDecimal.valueOf(5)
                .setScale(10, BigDecimal.ROUND_HALF_UP);

        BigDecimal actual = vectorLogic.countVectorLength(vector3)
                .setScale(10, BigDecimal.ROUND_HALF_UP);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCountCosBetweenVectorsShouldReturnCosWhenInputIsCorrect() {
        VectorLogic vectorLogic = new VectorLogic();
        BigDecimal expected = BigDecimal.valueOf(1)
                .setScale(10, BigDecimal.ROUND_HALF_UP);

        BigDecimal actual = vectorLogic.countCosBetweenVectors(vector1, vector2)
                .setScale(10, BigDecimal.ROUND_HALF_UP);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAreVectorsParallelShouldReturnTrueWhenVectorsParallel() {
        VectorLogic vectorLogic = new VectorLogic();

        Assert.assertTrue(vectorLogic.areVectorsParallel(vector1, vector2));
    }

    @Test
    public void testAreVectorsParallelShouldReturnFalseWhenVectorsNotParallel() {
        VectorLogic vectorLogic = new VectorLogic();

        Assert.assertFalse(vectorLogic.areVectorsParallel(vector1, vector3));
    }

    @Test
    public void createVectorShouldCreateVectorFromPointsWhenInputIsCorrect() {
        VectorLogic vectorLogic = new VectorLogic();
        Vector expected = new Vector(BigDecimal.valueOf(3), BigDecimal.valueOf(-4));

        Vector actual = vectorLogic.createVector(point1, point2);

        Assert.assertEquals(expected, actual);
    }
}