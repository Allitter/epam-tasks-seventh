package com.epam.tasks.seventh.data.impl;

import com.epam.tasks.seventh.data.DataReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FileDataReader implements DataReader {
    private static final Logger LOGGER = LogManager.getLogger();
    private final File file;

    public FileDataReader(File file) {
        this.file = file;
    }

    @Override
    public List<String> readAllLines() throws IOException {
        Scanner scanner = null;
        try {
            LOGGER.info("trying to create input stream");
            scanner = new Scanner(new FileInputStream(file));
            LOGGER.info("input stream created");
            List<String> lines = new LinkedList<>();
            String line;

            while (scanner.hasNext()) {
                line = scanner.nextLine();
                lines.add(line);
            }
            LOGGER.info("all lines read");
            return lines;
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
