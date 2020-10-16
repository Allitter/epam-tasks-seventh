package com.epam.tasks.seventh.data.impl;

import com.epam.tasks.seventh.data.Repository;
import com.epam.tasks.seventh.data.exception.DataException;
import com.epam.tasks.seventh.data.specification.Specification;
import com.epam.tasks.seventh.model.Quadrangle;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// TODO create tests

public final class QuadrangleRepositoryImpl implements Repository<Quadrangle> {
    private final List<Quadrangle> quadrangles = new ArrayList<>();

    @Override
    public void add(Quadrangle quadrangle) throws DataException {
        if (quadrangles.contains(quadrangle)) {
            throw new DataException("Repository already contains quadrangle"
                    + quadrangle);
        }
        quadrangles.add(quadrangle);
    }

    @Override
    public void remove(Quadrangle quadrangle) throws DataException {
        if (quadrangles.contains(quadrangle)) {
            throw new DataException("Repository doesn't contain quadrangle"
                    + quadrangle);
        }
        quadrangles.remove(quadrangle);
    }

    @Override
    public void update(Quadrangle quadrangle) throws DataException {
        int id = quadrangle.getId();
        Quadrangle thatQuadrangle;
        int i = 0;
        while (i < quadrangles.size()) {
            thatQuadrangle = quadrangles.get(i);
            if (thatQuadrangle.getId() == id) {
                remove(thatQuadrangle);
                add(quadrangle);
            }
        }
    }

    @Override
    public List<Quadrangle> query(Specification<Quadrangle> specification) {
        List<Quadrangle> result = new LinkedList<>();
        for (Quadrangle quadrangle : quadrangles) {
            if (specification.specified(quadrangle)) {
                result.add(quadrangle);
            }
        }
        return result;
    }
}
