package com.graemsheppard.mathparser;

import com.graemsheppard.generated.MathBaseVisitor;
import com.graemsheppard.generated.MathParser;
import com.graemsheppard.mathparser.number.BaseNumber;
import com.graemsheppard.mathparser.number.IntegerNumber;

public class MathSolverVisitor<T extends BaseNumber<T>> extends MathBaseVisitor<T> {

    private final Class<T> type;

    public MathSolverVisitor (Class<T> type) {
        this.type = type;
    }

    @Override
    public T visitExpression(MathParser.ExpressionContext ctx) {
        final int size = ctx.ADDSUB().size();
        T result = visitTerm(ctx.term(0));
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                final String symbol = ctx.ADDSUB(i).getText();
                if (symbol.equals("+"))
                    result = result.add(visitTerm(ctx.term(i+1)));
                else if (symbol.equals("-"))
                    result = result.subtract(visitTerm(ctx.term(i+1)));
            }
        }
        return result;
    }

    @Override
    public T visitTerm(MathParser.TermContext ctx) {
        T result = visitFactor(ctx.factor(0));
        final int size = ctx.MULDIV().size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                final String symbol = ctx.MULDIV(i).getText();
                if (symbol.equals("*"))
                    result = result.multiply(visitFactor(ctx.factor(i+1)));
                else if (symbol.equals("/"))
                    result = result.divide(visitFactor(ctx.factor(i+1)));
            }
        }
        return result;
    }

    @Override
    public T visitFactor(MathParser.FactorContext ctx) {
        if (ctx.VALUE() != null){
            return fromString(ctx.VALUE().getText());
        } else {
            var test = ctx.expression().getText();
            return visitExpression(ctx.expression());
        }
    }

    private T fromString(String stringValue) {
        try {
            return type.getConstructor(String.class).newInstance(stringValue);
        } catch (Exception e) {
            throw new RuntimeException("Failed to instantiate type: " + type.getSimpleName());
        }
    }

}
