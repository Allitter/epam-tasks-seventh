package com.epam.tasks.seventh.logic;

import com.epam.tasks.seventh.data.QuadrangleParserForTestUse;
import com.epam.tasks.seventh.logic.util.BigDecimalUtil;
import com.epam.tasks.seventh.model.Point;
import com.epam.tasks.seventh.model.Quadrangle;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.*;

public class QuadrangleRecorderTest {
    private static final String QUADRANGLE = "1 1 1 4 4 4 4 1";
    private static int firstQuadrangleId;
    private static Quadrangle firstQuadrangle;

    @BeforeClass
    public static void toDoBeforeAllTests() {
        QuadrangleRecorder recorder = QuadrangleRecorder.getInstance();
        QuadrangleParserForTestUse parser = new QuadrangleParserForTestUse();
        Quadrangle quadrangle = parser.getQuadrangle(QUADRANGLE);
        firstQuadrangle = quadrangle;
        recorder.update(quadrangle);
        firstQuadrangleId = quadrangle.getId();
    }

    @Test
    public void testGetAreaShouldReturnAreaWhenContains() {
        QuadrangleRecorder recorder = QuadrangleRecorder.getInstance();
        Optional<BigDecimal> optional = recorder.getArea(firstQuadrangleId);

        Assert.assertTrue(optional.isPresent());
    }

    @Test
    public void testGetAreaShouldReturnEmptyOptionalWhenNotContains() {
        QuadrangleRecorder recorder = QuadrangleRecorder.getInstance();
        Optional<BigDecimal> optional = recorder.getArea(firstQuadrangleId - 1);

        Assert.assertFalse(optional.isPresent());
    }

    @Test
    public void testGetPerimeterShouldReturnPerimeterWhenContains() {
        QuadrangleRecorder recorder = QuadrangleRecorder.getInstance();
        Optional<BigDecimal> optional = recorder.getPerimeter(firstQuadrangleId);

        Assert.assertTrue(optional.isPresent());
    }

    @Test
    public void testGetPerimeterShouldReturnEmptyOptionalWhenNotContains() {
        QuadrangleRecorder recorder = QuadrangleRecorder.getInstance();
        Optional<BigDecimal> optional = recorder.getPerimeter(firstQuadrangleId - 1);

        Assert.assertFalse(optional.isPresent());
    }

    @Test
    public void testUpdateShouldAddParametersForQuadrangleIfNotContains() {
        QuadrangleRecorder recorder = QuadrangleRecorder.getInstance();
        QuadrangleParserForTestUse parser = new QuadrangleParserForTestUse();
        Quadrangle quadrangle = parser.getQuadrangle(QUADRANGLE);
        recorder.update(quadrangle);
        int id = quadrangle.getId();

        Optional<BigDecimal> optional = recorder.getPerimeter(id);

        Assert.assertTrue(optional.isPresent());
    }

    @Test
    public void testUpdateShouldUpdateAreaForQuadrangleIfContains() {
        QuadrangleRecorder recorder = QuadrangleRecorder.getInstance();
        Point pointB = new Point(BigDecimal.valueOf(1), BigDecimal.valueOf(5));
        Point pointC = new Point(BigDecimal.valueOf(4), BigDecimal.valueOf(5));
        firstQuadrangle.setPointB(pointB);
        firstQuadrangle.setPointC(pointC);
        recorder.update(firstQuadrangle);
        BigDecimal expected = BigDecimal.valueOf(12)
                .setScale(10, BigDecimal.ROUND_DOWN);

        Optional<BigDecimal> optional = recorder.getArea(firstQuadrangleId);
        BigDecimal actual = optional.get()
                .setScale(10, BigDecimal.ROUND_DOWN);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testUpdateShouldUpdatePerimeterForQuadrangleIfContains() {
        QuadrangleRecorder recorder = QuadrangleRecorder.getInstance();
        Point pointB = new Point(BigDecimal.valueOf(1), BigDecimal.valueOf(5));
        Point pointC = new Point(BigDecimal.valueOf(4), BigDecimal.valueOf(5));
        firstQuadrangle.setPointB(pointB);
        firstQuadrangle.setPointC(pointC);
        recorder.update(firstQuadrangle);
        BigDecimal expected = BigDecimal.valueOf(14)
                .setScale(10, BigDecimal.ROUND_DOWN);

        Optional<BigDecimal> optional = recorder.getPerimeter(firstQuadrangleId);
        BigDecimal actual = optional.get()
                .setScale(10, BigDecimal.ROUND_DOWN);

        Assert.assertEquals(expected, actual);
    }
}