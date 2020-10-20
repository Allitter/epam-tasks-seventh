package com.epam.tasks.seventh.data.impl;

import com.epam.tasks.seventh.data.exception.DataException;
import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

public class FileDataReaderTest {
    private static final String PATH = "src/test/resources/testinput.txt";

    @Test
    public void testReadLinesShouldReadMultipleLinesWhenHasInput() throws DataException {
        FileDataReader reader = new FileDataReader();
        List<String> expected = Arrays.asList("line 1", "line 2", "line 3");

        List<String> actual = reader.readAllLines(PATH);

        Assert.assertEquals(expected, actual);
    }

}