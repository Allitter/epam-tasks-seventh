package com.epam.tasks.seventh.logic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;

public class BigDecimalUtil {
    private static final Logger LOGGER = LogManager.getLogger();

    public BigDecimal sqrt(BigDecimal value) {
        LOGGER.info("calculating sqrt of " + value);
        if (value.compareTo(BigDecimal.ZERO) == 0) {
            LOGGER.info("result is " + BigDecimal.ZERO);
            return BigDecimal.ZERO;
        }

        BigDecimal root = BigDecimal.valueOf(Math.sqrt(value.doubleValue()));
        double deviation = value.subtract(root.multiply(root)).doubleValue();
        deviation /= (root.doubleValue() * 2.0);
        root = root.add(BigDecimal.valueOf(deviation));
        LOGGER.info("result is " + root);
        return root;
    }

    public boolean numbersEqual(BigDecimal x, BigDecimal y) {
        return x.compareTo(y) == 0;
    }
}
