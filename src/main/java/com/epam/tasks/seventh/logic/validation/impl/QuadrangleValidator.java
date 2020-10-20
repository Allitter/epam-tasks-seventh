package com.epam.tasks.seventh.logic.validation.impl;

import com.epam.tasks.seventh.logic.util.BigDecimalUtil;
import com.epam.tasks.seventh.logic.validation.Validator;
import com.epam.tasks.seventh.model.Point;
import com.epam.tasks.seventh.model.Quadrangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.math.BigDecimal;

public class QuadrangleValidator implements Validator<Quadrangle> {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public boolean isValid(Quadrangle object) {
        Point a = object.getPointA();
        Point b = object.getPointB();
        Point c = object.getPointC();
        Point d = object.getPointD();
        LOGGER.info("is quadrangle " + object);
        boolean result = !(areDotsOnOneLine(a, b, c) || areDotsOnOneLine(a, b, d)
                || areDotsOnOneLine(b, c, d) || areDotsOnOneLine(a, c, d));
        LOGGER.info("is quadrangle " + result);
        return result;
    }

    /**
     * straight line equation
     * (y3 - y1) * (x2 - x1) = (y2 - y1) * (x3 - x1)
     * */
    private boolean areDotsOnOneLine(Point a, Point b, Point c) {
        BigDecimal x1 = a.getX();
        BigDecimal x2 = b.getX();
        BigDecimal x3 = c.getX();
        BigDecimal y1 = a.getY();
        BigDecimal y2 = b.getY();
        BigDecimal y3 = c.getY();
        LOGGER.info(String.format("are dots {%s, %s, %s} on one line", a, b, c));
        BigDecimal left = y3.subtract(y1).multiply(x2.subtract(x1));
        BigDecimal right = y2.subtract(y1).multiply(x3.subtract(x1));
        boolean result = left.compareTo(right) == 0;
        LOGGER.info("are dots on one line " + result);
        return result;
    }
}
