package com.epam.tasks.seventh.data.impl;

import org.junit.Assert;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class FileDataReaderTest {
    private final File file = new File("src/test/resources/input.txt");

    @Test
    public void testReadLinesShouldReadMultipleLinesWhenHasInput()
            throws IOException {

        FileDataReader reader = new FileDataReader(file);
        List<String> expected = new LinkedList<>();
        expected.add("line 1");
        expected.add("line 2");
        expected.add("line 3");

        List<String> actual = reader.readAllLines();

        Assert.assertEquals(expected, actual);
    }
}