package com.epam.tasks.seventh.data.impl;

import com.epam.tasks.seventh.data.DataReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FileDataReader implements DataReader {
    private static final String EOL_MARKER = "\r\n";
    private final Scanner scanner;

    public FileDataReader(File file) throws FileNotFoundException {
        FileInputStream inputStream = new FileInputStream(file);
        scanner = new Scanner(inputStream);
    }

    @Override
    public List<String> readAllLines() {
        List<String> lines = new LinkedList<>();
        String line;

        while (scanner.hasNext()) {
            line = readLine();
            lines.add(line);
        }

        return lines;
    }

    @Override
    public String readLine() {
        return scanner.nextLine();
    }

    @Override
    public void close() {
        scanner.close();
    }
}
