package com.epam.tasks.seventh.model;

import com.epam.tasks.seventh.logic.Observable;
import com.epam.tasks.seventh.logic.Observer;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class ObservableQuadrangle extends Quadrangle implements Observable<Quadrangle> {
    private final Set<Observer<Quadrangle>> observers = new HashSet<>();

    public ObservableQuadrangle(QuadrangleConstructorParameter parameter) {
        super(parameter);
    }

    @Override
    public void addObserver(Observer<Quadrangle> observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer<Quadrangle> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer<Quadrangle> observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
