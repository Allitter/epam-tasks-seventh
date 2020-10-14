package com.epam.tasks.seventh.data;

import com.epam.tasks.seventh.data.exception.DataException;

import java.io.IOException;
import java.util.List;

public interface DataReader {

    List<String> readAllLines(String link) throws IOException, DataException;

}
