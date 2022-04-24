package com.graemsheppard.mathparser.number;

public class LongNumber extends BaseNumber<LongNumber> {

    public LongNumber(String stringValue) {
        this.value = Long.parseLong(stringValue);
    }

    public LongNumber(Long value) {
        this.value = value;
    }

    @Override
    public LongNumber add(LongNumber v) {
        return new LongNumber((long)this.value + (long)v.getValue());
    }

    @Override
    public LongNumber subtract(LongNumber v) {
        return new LongNumber((long)this.value - (long)v.getValue());
    }

    @Override
    public LongNumber multiply(LongNumber v) {
        return new LongNumber((long)this.value * (long)v.getValue());
    }

    @Override
    public LongNumber divide(LongNumber v) {
        return new LongNumber((long)this.value / (long)v.getValue());
    }

}
