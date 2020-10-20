package com.epam.tasks.seventh.data;

import com.epam.tasks.seventh.data.exception.DataException;
import java.util.List;

public interface DataReader {

    List<String> readAllLines(String path) throws DataException;

}
