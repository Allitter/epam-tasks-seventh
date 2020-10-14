package com.epam.tasks.seventh.data.impl;

import com.epam.tasks.seventh.data.DataReader;
import com.epam.tasks.seventh.QuadrangleParserForTestUse;
import com.epam.tasks.seventh.data.exception.DataException;
import com.epam.tasks.seventh.model.Quadrangle;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class QuadrangleReaderImplTest {
    private static final String CORRECT_QUADRANGLE_LINE_1 = "1 2 3 -4.2 5 6 7.6 8";
    private static final String INCORRECT_QUADRANGLE_LINE = "-1 2 3 -4 5 6";
    private final QuadrangleParserForTestUse parserForTest = new QuadrangleParserForTestUse();
    private final Quadrangle quadrangle = parserForTest.getQuadrangle(CORRECT_QUADRANGLE_LINE_1);

    @Test
    public void testReadQuadranglesShouldReturnQuadranglesWhenInputIsCorrect()
            throws IOException, DataException {
        //given
        //Mock parser
        QuadrangleParserImpl parser = Mockito.mock(QuadrangleParserImpl.class);
        Mockito.when(parser.parseQuadrangle(Mockito.any()))
                .thenReturn(Optional.of(quadrangle));
        //Mock reader
        List<String> lines = Arrays.asList(CORRECT_QUADRANGLE_LINE_1, CORRECT_QUADRANGLE_LINE_1);
        DataReader linesReader = Mockito.mock(DataReader.class);
        Mockito.when(linesReader.readAllLines(Mockito.any())).thenReturn(lines);
        QuadrangleReaderImpl quadrangleReader = new QuadrangleReaderImpl(linesReader, parser);
        //expected
        List<Quadrangle> expected = Arrays.asList(quadrangle, quadrangle);

        //when
        List<Quadrangle> actual = quadrangleReader.readQuadrangles("");

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testReadQuadranglesShouldReturnQuadranglesWhenInputIsNotCorrect()
            throws DataException, IOException {
        //given
        //Mock parser
        QuadrangleParserImpl parser = Mockito.mock(QuadrangleParserImpl.class);
        Mockito.when(parser.parseQuadrangle(Mockito.any()))
                .thenReturn(Optional.of(quadrangle));
        //Mock reader
        List<String> lines = Arrays.asList(CORRECT_QUADRANGLE_LINE_1, INCORRECT_QUADRANGLE_LINE);
        DataReader linesReader = Mockito.mock(DataReader.class);
        Mockito.when(linesReader.readAllLines(Mockito.any())).thenReturn(lines);
        QuadrangleReaderImpl quadrangleReader = new QuadrangleReaderImpl(linesReader, parser);
        //expected
        List<Quadrangle> expected = new LinkedList<>();
        Quadrangle quadrangle1 = parserForTest.getQuadrangle(CORRECT_QUADRANGLE_LINE_1);
        expected.add(quadrangle1);

        //when
        List<Quadrangle> actual = quadrangleReader.readQuadrangles("");

        //then
        Assert.assertEquals(expected, actual);
    }
}