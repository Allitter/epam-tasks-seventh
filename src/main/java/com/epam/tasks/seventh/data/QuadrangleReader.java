package com.epam.tasks.seventh.data;

import com.epam.tasks.seventh.data.exception.DataException;
import com.epam.tasks.seventh.model.Quadrangle;
import java.util.List;

public interface QuadrangleReader {

    List<Quadrangle> readQuadrangles(String link) throws DataException;

}
