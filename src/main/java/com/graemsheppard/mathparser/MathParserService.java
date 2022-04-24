package com.graemsheppard.mathparser;

import com.graemsheppard.generated.MathLexer;
import com.graemsheppard.generated.MathParser;
import com.graemsheppard.mathparser.number.BaseNumber;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class MathParserService {

    public <T extends BaseNumber<T>> T parse(String expression, Class<T> type) {
        var lexer = new MathLexer(CharStreams.fromString(expression));
        var parser = new MathParser(new CommonTokenStream(lexer));
        var visitor = new MathSolverVisitor<T>(type);

        return visitor.visit(parser.expression());
    }
}