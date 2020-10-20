package com.epam.tasks.seventh.data.impl;

import com.epam.tasks.seventh.data.Repository;
import com.epam.tasks.seventh.data.exception.DataException;
import com.epam.tasks.seventh.data.specification.Specification;
import com.epam.tasks.seventh.model.Quadrangle;
import java.util.*;

public final class QuadrangleRepositoryImpl implements Repository<Quadrangle> {
    private final List<Quadrangle> quadrangles;

    public QuadrangleRepositoryImpl() {
        quadrangles = new ArrayList<>();
    }

    /*package private for test*/
    QuadrangleRepositoryImpl(List<Quadrangle> source) {
        quadrangles = source;
    }

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
        if (!quadrangles.contains(quadrangle)) {
            throw new DataException("Repository doesn't contain quadrangle"
                    + quadrangle);
        }
        quadrangles.remove(quadrangle);
    }

    @Override
    public void update(Quadrangle quadrangle) {
        int id = quadrangle.getId();
        Iterator<Quadrangle> iterator = quadrangles.iterator();
        Quadrangle thatQuadrangle;
        while (iterator.hasNext()) {
            thatQuadrangle = iterator.next();
            if (thatQuadrangle.getId() == id) {
                quadrangles.remove(thatQuadrangle);
                quadrangles.add(quadrangle);
                break;
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
