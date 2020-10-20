package com.epam.tasks.seventh.data.specification;

public interface Specification<T> {

    boolean specified(T object);

}
