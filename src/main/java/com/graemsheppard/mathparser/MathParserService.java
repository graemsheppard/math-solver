package com.graemsheppard.mathparser;

import com.graemsheppard.generated.MathLexer;
import com.graemsheppard.generated.MathParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class MathParserService {

    public String parse(String expression) {
        var lexer = new MathLexer(CharStreams.fromString(expression));
        var parser = new MathParser(new CommonTokenStream(lexer));
        var visitor = new MathAddParenthesesVisitor();

        return visitor.visit(parser.expression());
    }
}