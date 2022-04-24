package com.graemsheppard.mathparser.number;

public class IntegerNumber extends BaseNumber<IntegerNumber> {

    public IntegerNumber(String stringValue) {
        this.value = Integer.parseInt(stringValue);
    }

    public IntegerNumber(Integer value) {
        this.value = value;
    }

    @Override
    public IntegerNumber add(IntegerNumber v) {
        return new IntegerNumber((int)this.value + (int)v.getValue());
    }

    @Override
    public IntegerNumber subtract(IntegerNumber v) {
        return new IntegerNumber((int)this.value - (int)v.getValue());
    }

    @Override
    public IntegerNumber multiply(IntegerNumber v) {
        return new IntegerNumber((int)this.value * (int)v.getValue());
    }

    @Override
    public IntegerNumber divide(IntegerNumber v) {
        return new IntegerNumber((int)this.value / (int)v.getValue());
    }
}
