package com.graemsheppard.mathparser;

import com.graemsheppard.mathparser.number.DoubleNumber;
import com.graemsheppard.mathparser.number.IntegerNumber;

public class Main {

    public static void main(String[] args) {
        var parser = new MathParserService();
        DoubleNumber test = parser.parse("(2+2*3)/(16.2)", DoubleNumber.class);
        System.out.println(test);
    }
}
