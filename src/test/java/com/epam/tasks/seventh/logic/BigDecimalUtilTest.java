package com.epam.tasks.seventh.logic;

import com.epam.tasks.seventh.logic.util.BigDecimalUtil;
import org.junit.Assert;
import org.junit.Test;
import java.math.BigDecimal;

public class BigDecimalUtilTest {

    @Test
    public void testSqrtShouldReturnSqrtWhenInputIsCorrect() {
        BigDecimal number = new BigDecimal("25");
        BigDecimal expected = new BigDecimal("5")
                .setScale(10, BigDecimal.ROUND_HALF_UP);

        BigDecimal actual = BigDecimalUtil.sqrt(number)
                .setScale(10, BigDecimal.ROUND_HALF_UP);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSqrtShouldReturnZeroWhenInputIsZero() {
        BigDecimal number = new BigDecimal("0");
        BigDecimal expected = BigDecimal.ZERO
                .setScale(10, BigDecimal.ROUND_HALF_UP);

        BigDecimal actual = BigDecimalUtil.sqrt(number)
                .setScale(10, BigDecimal.ROUND_HALF_UP);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testNumbersEqualShouldReturnTrueWhenNumbersEqual() {
        BigDecimal bigDecimal1 = new BigDecimal("1.20");
        BigDecimal bigDecimal2 = new BigDecimal("1.2");

        Assert.assertTrue(BigDecimalUtil.numbersEqual(bigDecimal1, bigDecimal2));
    }

    @Test
    public void testNumbersEqualShouldReturnFalseWhenNumbersNotEqual() {
        BigDecimal bigDecimal1 = new BigDecimal("120");
        BigDecimal bigDecimal2 = new BigDecimal("1.2");

        Assert.assertFalse(BigDecimalUtil.numbersEqual(bigDecimal1, bigDecimal2));
    }
}