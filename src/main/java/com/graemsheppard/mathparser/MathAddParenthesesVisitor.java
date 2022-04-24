package com.graemsheppard.mathparser;

import com.graemsheppard.generated.MathBaseVisitor;
import com.graemsheppard.generated.MathParser;

public class MathAddParenthesesVisitor extends MathBaseVisitor<String> {

    @Override
    public String visitExpression(MathParser.ExpressionContext ctx) {
        final int size = ctx.ADDSUB().size();
        if (size > 0) {
            StringBuilder builder = new StringBuilder(ctx.term(0).getText());
            for (int i = 0; i < size; i++) {
                builder.append(ctx.ADDSUB(i).getText());
                builder.append(visitTerm(ctx.term(i+1)));
            }
            return "(" + builder.toString() + ")";
        } else {
            return visitTerm(ctx.term(0));
        }
    }

    @Override
    public String visitTerm(MathParser.TermContext ctx) {
        final int size = ctx.MULDIV().size();
        if (size > 0) {
            StringBuilder builder = new StringBuilder(ctx.factor(0).getText());
            for (int i = 0; i < size; i++) {
                builder.append(ctx.MULDIV(i).getText());
                builder.append(visitFactor(ctx.factor(i+1)));
            }
            return "(" + builder.toString() + ")";
        } else {
            return visitFactor(ctx.factor(0));
        }
    }

    @Override
    public String visitFactor(MathParser.FactorContext ctx) {
        if (ctx.VALUE() != null){
            return ctx.VALUE().getText();
        } else {
            return visitExpression(ctx.expression());
        }
    }
}
