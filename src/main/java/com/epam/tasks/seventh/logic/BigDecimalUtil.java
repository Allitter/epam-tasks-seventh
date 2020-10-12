package com.epam.tasks.seventh.logic;

import java.math.BigDecimal;

public class BigDecimalUtil {
    public BigDecimal sqrt(BigDecimal value) {
        if (value.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }

        BigDecimal root = BigDecimal.valueOf(Math.sqrt(value.doubleValue()));
        double deviation = value.subtract(root.multiply(root)).doubleValue();
        deviation /= (root.doubleValue() * 2.0);
        return root.add(BigDecimal.valueOf(deviation));
    }

    public boolean numbersEqual(BigDecimal x, BigDecimal y) {
        return x.compareTo(y) == 0;
    }
}
