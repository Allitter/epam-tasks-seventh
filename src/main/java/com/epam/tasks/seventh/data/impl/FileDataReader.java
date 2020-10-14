package com.epam.tasks.seventh.data.impl;

import com.epam.tasks.seventh.data.DataReader;
import com.epam.tasks.seventh.data.exception.DataException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FileDataReader implements DataReader {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public List<String> readAllLines(String link) throws IOException, DataException {
        Scanner scanner = null;
        try {
            LOGGER.info("trying to create input stream");
            Path path = convertPath(link);
            File file = new File(String.valueOf(path));
            FileInputStream inputStream = new FileInputStream(file);
            scanner = new Scanner(inputStream);
            LOGGER.info("input stream created");
            List<String> lines = new LinkedList<>();
            String line;

            while (scanner.hasNext()) {
                line = scanner.nextLine();
                lines.add(line);
            }
            LOGGER.info("all lines read");
            return lines;
        } catch (URISyntaxException e) {
            throw new DataException(e);
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    // TODO check later
    private Path convertPath(String link) throws URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resourceURL = classLoader.getResource(link);
        URI resourceURI = resourceURL.toURI();

        return Paths.get(resourceURI);
    }
}
