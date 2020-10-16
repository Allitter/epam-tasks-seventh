package com.epam.tasks.seventh.data;

import com.epam.tasks.seventh.data.exception.DataException;
import com.epam.tasks.seventh.data.specification.Specification;
import java.util.List;

public interface Repository<T> {
    void add(T quadrangle) throws DataException;
    void remove(T quadrangle) throws DataException;
    void update(T quadrangle) throws DataException;

    List<T> query(Specification<T> specification);
}
