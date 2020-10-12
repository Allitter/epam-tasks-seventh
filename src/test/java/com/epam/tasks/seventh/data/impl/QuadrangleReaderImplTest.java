package com.epam.tasks.seventh.data.impl;

import com.epam.tasks.seventh.data.DataReader;
import com.epam.tasks.seventh.data.QuadrangleParser;
import com.epam.tasks.seventh.QuadrangleParserForTestUse;
import com.epam.tasks.seventh.model.Quadrangle;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class QuadrangleReaderImplTest {
    private static final String CORRECT_QUADRANGLE_LINE_1 = "1 2 3 -4.2 5 6 7.6 8";
    private static final String INCORRECT_QUADRANGLE_LINE = "-1 2 3 -4 5 6";
    private final QuadrangleParserForTestUse parserForTest = new QuadrangleParserForTestUse();
    private final Quadrangle quadrangle = parserForTest.getQuadrangle(CORRECT_QUADRANGLE_LINE_1);

    @Test
    public void testReadQuadranglesShouldReturnQuadranglesWhenInputIsCorrect() {
        //given
        //Mock parser
        QuadrangleParser parser = Mockito.mock(QuadrangleParser.class);
        Mockito.when(parser.parseQuadrangle(Mockito.any()))
                .thenReturn(Optional.of(quadrangle));
        //Mock reader
        List<String> lines = new LinkedList<>();
        lines.add(CORRECT_QUADRANGLE_LINE_1);
        lines.add(CORRECT_QUADRANGLE_LINE_1);
        DataReader linesReader = Mockito.mock(DataReader.class);
        Mockito.when(linesReader.readAllLines()).thenReturn(lines);

        QuadrangleReaderImpl quadrangleReader =
                new QuadrangleReaderImpl(linesReader, parser);
        //expected
        List<Quadrangle> expected = new LinkedList<>();
        expected.add(quadrangle);
        expected.add(quadrangle);

        //when
        List<Quadrangle> actual = quadrangleReader.readQuadrangles();

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testReadQuadranglesShouldReturnQuadranglesWhenInputIsNotCorrect() {
        //given
        //Mock parser
        QuadrangleParser parser = Mockito.mock(QuadrangleParser.class);
        Mockito.when(parser.parseQuadrangle(Mockito.any()))
                .thenReturn(Optional.of(quadrangle));
        //Mock reader
        List<String> lines = new LinkedList<>();
        lines.add(CORRECT_QUADRANGLE_LINE_1);
        lines.add(INCORRECT_QUADRANGLE_LINE);
        DataReader linesReader = Mockito.mock(DataReader.class);
        Mockito.when(linesReader.readAllLines()).thenReturn(lines);

        QuadrangleReaderImpl quadrangleReader =
                new QuadrangleReaderImpl(linesReader, parser);
        //expected
        List<Quadrangle> expected = new LinkedList<>();
        Quadrangle quadrangle1 = parserForTest.getQuadrangle(CORRECT_QUADRANGLE_LINE_1);
        expected.add(quadrangle1);

        //when
        List<Quadrangle> actual = quadrangleReader.readQuadrangles();

        //then
        Assert.assertEquals(expected, actual);
    }
}