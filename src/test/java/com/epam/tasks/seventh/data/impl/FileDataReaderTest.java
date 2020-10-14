package com.epam.tasks.seventh.data.impl;

import com.epam.tasks.seventh.data.exception.DataException;
import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FileDataReaderTest {
    private static final String PATH = "input.txt";

    @Test
    public void testReadLinesShouldReadMultipleLinesWhenHasInput()
            throws IOException, DataException {
        FileDataReader reader = new FileDataReader();
        List<String> expected = Arrays.asList("line 1", "line 2", "line 3");

        List<String> actual = reader.readAllLines(PATH);

        Assert.assertEquals(expected, actual);
    }


}