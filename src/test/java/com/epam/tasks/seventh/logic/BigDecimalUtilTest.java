package com.epam.tasks.seventh.logic;

import org.junit.Assert;
import org.junit.Test;
import java.math.BigDecimal;

public class BigDecimalUtilTest {

    @Test
    public void testSqrtShouldReturnSqrtWhenInputIsCorrect() {
        BigDecimalUtil util = new BigDecimalUtil();
        BigDecimal number = new BigDecimal("25");
        BigDecimal expected = new BigDecimal("5")
                .setScale(10, BigDecimal.ROUND_HALF_UP);

        BigDecimal actual = util.sqrt(number)
                .setScale(10, BigDecimal.ROUND_HALF_UP);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSqrtShouldReturnZeroWhenInputIsZero() {
        BigDecimalUtil util = new BigDecimalUtil();
        BigDecimal number = new BigDecimal("0");
        BigDecimal expected = BigDecimal.ZERO
                .setScale(10, BigDecimal.ROUND_HALF_UP);

        BigDecimal actual = util.sqrt(number)
                .setScale(10, BigDecimal.ROUND_HALF_UP);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testNumbersEqualShouldReturnTrueWhenNumbersEqual() {
        BigDecimalUtil util = new BigDecimalUtil();
        BigDecimal bigDecimal1 = new BigDecimal("1.20");
        BigDecimal bigDecimal2 = new BigDecimal("1.2");

        Assert.assertTrue(util.numbersEqual(bigDecimal1, bigDecimal2));
    }

    @Test
    public void testNumbersEqualShouldReturnFalseWhenNumbersNotEqual() {
        BigDecimalUtil util = new BigDecimalUtil();
        BigDecimal bigDecimal1 = new BigDecimal("120");
        BigDecimal bigDecimal2 = new BigDecimal("1.2");

        Assert.assertFalse(util.numbersEqual(bigDecimal1, bigDecimal2));
    }
}