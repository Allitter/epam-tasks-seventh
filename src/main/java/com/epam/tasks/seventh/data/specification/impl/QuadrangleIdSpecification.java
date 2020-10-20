package com.epam.tasks.seventh.data.specification.impl;

import com.epam.tasks.seventh.data.specification.Specification;
import com.epam.tasks.seventh.model.Quadrangle;

public class QuadrangleIdSpecification implements Specification<Quadrangle> {
    private final int id;

    public QuadrangleIdSpecification(Integer id) {
        this.id = id;
    }

    @Override
    public boolean specified(Quadrangle quadrangle) {
        return quadrangle.getId() == id;
    }
}
