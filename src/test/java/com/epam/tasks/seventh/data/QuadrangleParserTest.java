package com.epam.tasks.seventh.data;

import com.epam.tasks.seventh.QuadrangleParserForTestUse;
import com.epam.tasks.seventh.model.Quadrangle;
import org.junit.Assert;
import org.junit.Test;
import java.util.Optional;

public class QuadrangleParserTest {
    private static final String CORRECT_QUADRANGLE_LINE_1 = "1 2 3 -4.2 5 6 7.6 8";
    private static final String INCORRECT_QUADRANGLE_LINE = "-1 2 3 -4 5 6";
    private final QuadrangleParserForTestUse parserForTest = new QuadrangleParserForTestUse();

    @Test
    public void testParseQuadrangleShouldReturnQuadrangleWhenInputIsCorrect() {
        //given
        QuadrangleParser parser = new QuadrangleParser();
        Quadrangle quadrangle = parserForTest.getQuadrangle(CORRECT_QUADRANGLE_LINE_1);
        Optional<Quadrangle> expected = Optional.of(quadrangle);

        //when
        Optional<Quadrangle> actual = parser.parseQuadrangle(CORRECT_QUADRANGLE_LINE_1);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testParseQuadrangleShouldReturnEmptyOptionalWhenInputIsIncorrect() {
        //given
        QuadrangleParser parser = new QuadrangleParser();
        Optional<Quadrangle> expected = Optional.empty();

        //when
        Optional<Quadrangle> actual = parser.parseQuadrangle(INCORRECT_QUADRANGLE_LINE);

        //then
        Assert.assertEquals(expected, actual);
    }
}