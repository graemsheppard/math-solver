package com.graemsheppard.mathparser;

public class Main {

    public static void main(String[] args) {
        MathParserService parser = new MathParserService();
        String result = parser.parse("1+2/(6/3)+10");
        System.out.println(result);
    }
}
