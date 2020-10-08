package com.epam.tasks.seventh.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileLinesReader implements LinesReader {
    private static final String EOL_MARKER = "\r\n";
    private final Scanner scanner;

    public FileLinesReader(File file) throws FileNotFoundException {
        FileInputStream inputStream = new FileInputStream(file);
        scanner = new Scanner(inputStream);
    }

    @Override
    public String readLines(int amount) {
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        for (int i = 0; i < amount - 1; i++) {
            line = readLine();
            stringBuilder.append(line);
            stringBuilder.append(EOL_MARKER);
        }
        line = readLine();
        stringBuilder.append(line);

        return stringBuilder.toString();
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
