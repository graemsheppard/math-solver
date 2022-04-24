package com.graemsheppard.mathparser.number;

public class DoubleNumber extends BaseNumber<DoubleNumber> {

    public DoubleNumber(String stringValue) {
        this.value = Double.parseDouble(stringValue);
    }

    public DoubleNumber(Double value) {
        this.value = value;
    }

    @Override
    public DoubleNumber add(DoubleNumber v) {
        return new DoubleNumber((double)this.value + (double)v.getValue());
    }

    @Override
    public DoubleNumber subtract(DoubleNumber v) {
        return new DoubleNumber((double)this.value - (double)v.getValue());
    }

    @Override
    public DoubleNumber multiply(DoubleNumber v) {
        return new DoubleNumber((double)this.value * (double)v.getValue());
    }

    @Override
    public DoubleNumber divide(DoubleNumber v) {
        return new DoubleNumber((double)this.value / (double)v.getValue());
    }

}
