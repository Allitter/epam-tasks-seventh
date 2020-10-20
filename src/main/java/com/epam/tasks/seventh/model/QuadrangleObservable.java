package com.epam.tasks.seventh.model;

import com.epam.tasks.seventh.logic.Observable;
import com.epam.tasks.seventh.logic.Observer;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class QuadrangleObservable extends Quadrangle implements Observable<Quadrangle> {
    private final Set<Observer<Quadrangle>> observers = new HashSet<>();

    public QuadrangleObservable(Quadrangle quadrangle) {
        super(quadrangle);
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
    public void setPointA(Point pointA) {
        super.setPointA(pointA);
        notifyObservers();
    }

    @Override
    public void setPointB(Point pointB) {
        super.setPointB(pointB);
        notifyObservers();
    }

    @Override
    public void setPointC(Point pointC) {
        super.setPointC(pointC);
        notifyObservers();
    }

    @Override
    public void setPointD(Point pointD) {
        super.setPointD(pointD);
        notifyObservers();
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

    public static class Builder {
        private final Quadrangle.Builder quadrangleBuilder = new Quadrangle.Builder();

        public void putA(BigDecimal x, BigDecimal y) {
            quadrangleBuilder.putA(x, y);
        }

        public void putB(BigDecimal x, BigDecimal y) {
            quadrangleBuilder.putB(x, y);
        }

        public void putC(BigDecimal x, BigDecimal y) {
            quadrangleBuilder.putC(x, y);
        }

        public void putD(BigDecimal x, BigDecimal y) {
            quadrangleBuilder.putD(x, y);
        }

        public QuadrangleObservable build() {
            Quadrangle quadrangle = quadrangleBuilder.build();
            return new QuadrangleObservable(quadrangle);
        }
    }
}
