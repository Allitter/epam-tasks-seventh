package com.epam.tasks.seventh.logic;

import com.epam.tasks.seventh.data.QuadrangleParserForTestUse;
import com.epam.tasks.seventh.logic.impl.QuadrangleCalculatorImpl;
import com.epam.tasks.seventh.model.Quadrangle;
import org.junit.Assert;
import org.junit.Test;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class QuadrangleCalculatorTest {
    private static final String TRAPEZE_LINE = "1 1 2 4 3 4 4 1";
    private static final String SQUARE_LINE = "1 1 1 4 4 4 4 1";
    private final QuadrangleCalculator quadrangleCalculator = new QuadrangleCalculatorImpl();
    private final QuadrangleParserForTestUse parserForTest = new QuadrangleParserForTestUse();
    private final Quadrangle square = parserForTest.getQuadrangle(SQUARE_LINE);
    private final Quadrangle trapeze = parserForTest.getQuadrangle(TRAPEZE_LINE);

    @Test
    public void testCalculateAreaShouldCalculateArea() {
        BigDecimal expected = new BigDecimal("9")
                .setScale(10, RoundingMode.HALF_UP);
        BigDecimal actual = quadrangleCalculator.calculateArea(square)
                .setScale(10, RoundingMode.HALF_UP);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCalculatePerimeterShouldCalculatePerimeter() {
        BigDecimal expected = new BigDecimal("12")
                .setScale(10, RoundingMode.HALF_UP);
        BigDecimal actual = quadrangleCalculator.calculatePerimeter(square)
                .setScale(10, RoundingMode.HALF_UP);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsConvexShouldReturnTrueForSquare() {
        Assert.assertTrue(quadrangleCalculator.isConvex(square));
    }

    @Test
    public void testIsSquareShouldReturnTrueForSquare() {
        Assert.assertTrue(quadrangleCalculator.isSquare(square));
    }

    @Test
    public void testIsRhombusShouldReturnTrueForSquare() {
        Assert.assertTrue(quadrangleCalculator.isRhombus(square));
    }

    @Test
    public void TestIsTrapezeShouldReturnTrueForTrapeze() {
        Assert.assertTrue(quadrangleCalculator.isTrapeze(trapeze));
    }

    @Test
    public void TestIsTrapezeShouldReturnFalseForSquare() {
        Assert.assertFalse(quadrangleCalculator.isTrapeze(square));
    }
}