package com.epam.tasks.seventh.logic.impl;

import com.epam.tasks.seventh.logic.IdGenerator;

public class IdGeneratorImpl implements IdGenerator {
    private int id = 0;

    @Override
    public int getId() {
        return id++;
    }
}
