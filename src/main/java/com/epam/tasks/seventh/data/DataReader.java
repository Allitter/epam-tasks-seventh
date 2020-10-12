package com.epam.tasks.seventh.data;

import java.io.IOException;
import java.util.List;

public interface DataReader {

    List<String> readAllLines() throws IOException;

}
