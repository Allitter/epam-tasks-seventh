package com.epam.tasks.seventh.data;

import com.epam.tasks.seventh.model.Quadrangle;
import java.util.Optional;

public interface QuadrangleParser {

    Optional<Quadrangle> parseQuadrangle(String line);

}
