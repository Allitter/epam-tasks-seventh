package com.epam.tasks.seventh.data;

import java.io.Closeable;

public interface LinesReader extends Closeable {

    String readLine();

    String readLines(int amount);
}
