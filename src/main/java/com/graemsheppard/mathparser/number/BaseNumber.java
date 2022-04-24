package com.graemsheppard.mathparser.number;

public abstract class BaseNumber<T extends BaseNumber<?>> {

    protected Number value;

    public abstract T add(T v);

    public abstract T subtract(T v);

    public abstract T multiply(T v);

    public abstract T divide(T v);

    public Number getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }

}
