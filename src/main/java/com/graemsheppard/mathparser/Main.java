package com.graemsheppard.mathparser;

import com.graemsheppard.mathparser.number.IntegerNumber;

public class Main {

    public static void main(String[] args) {
        var parser = new MathParserService();
        IntegerNumber test = parser.parse("(2+2*3)/(8-4)", IntegerNumber.class);
        System.out.println(test);
    }
}
