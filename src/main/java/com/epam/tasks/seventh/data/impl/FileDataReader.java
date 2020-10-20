package com.epam.tasks.seventh.data.impl;

import com.epam.tasks.seventh.data.DataReader;
import com.epam.tasks.seventh.data.exception.DataException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FileDataReader implements DataReader {

    @Override
    public List<String> readAllLines(String path) throws DataException {
        Scanner scanner = null;
        try {
            File file = new File(String.valueOf(path));
            FileInputStream inputStream = new FileInputStream(file);
            scanner = new Scanner(inputStream);
            List<String> lines = new LinkedList<>();

            String line;
            while (scanner.hasNext()) {
                line = scanner.nextLine();
                lines.add(line);
            }

            return lines;
        } catch (IOException e) {
            throw new DataException(e);
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
