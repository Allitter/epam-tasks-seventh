package com.epam.tasks.seventh.logic;

import com.epam.tasks.seventh.logic.impl.QuadrangleCalculatorImpl;
import com.epam.tasks.seventh.model.Quadrangle;
import com.epam.tasks.seventh.model.QuadrangleParameters;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class QuadrangleRecorder implements Observer<Quadrangle> {
    private final Map<Integer, QuadrangleParameters> quadrangleParameters = new HashMap<>();
    private final QuadrangleCalculator logic = new QuadrangleCalculatorImpl();
    private static final QuadrangleRecorder INSTANCE = new QuadrangleRecorder();

    private QuadrangleRecorder() {
    }

    public static QuadrangleRecorder getInstance() {
        return INSTANCE;
    }

    public Optional<BigDecimal> getArea(int id) {
        if (!quadrangleParameters.containsKey(id)) {
            return Optional.empty();
        }

        QuadrangleParameters parameters = quadrangleParameters.get(id);
        BigDecimal area = parameters.getArea();
        return Optional.of(area);
    }

    public Optional<BigDecimal> getPerimeter(int id) {
        if (!quadrangleParameters.containsKey(id)) {
            return Optional.empty();
        }

        QuadrangleParameters parameters = quadrangleParameters.get(id);
        BigDecimal perimeter = parameters.getPerimeter();
        return Optional.of(perimeter);
    }

    @Override
    public void update(Quadrangle observable) {
        BigDecimal area = logic.calculateArea(observable);
        BigDecimal perimeter = logic.calculatePerimeter(observable);
        QuadrangleParameters newParameters =
                new QuadrangleParameters(area, perimeter);
        Integer id = observable.getId();
        quadrangleParameters.put(id, newParameters);
    }

}
