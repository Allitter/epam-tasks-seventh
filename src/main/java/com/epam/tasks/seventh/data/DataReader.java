package com.epam.tasks.seventh.data;

import java.io.Closeable;
import java.util.List;

public interface DataReader extends Closeable {

    String readLine();

    List<String> readAllLines();
}
