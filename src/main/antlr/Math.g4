grammar Math;

expression          : term (ADDSUB term)*;
term                : factor (MULDIV factor)*;
factor              : LB expression RB
                    | VALUE;

VALUE               : [0-9] '.' [0-9]+
                    | [1-9][0-9]* '.' [0-9]+
                    | [1-9][0-9]*;

ADDSUB              : '+' | '-';
MULDIV              : '*' | '/';
LB                  : '(';
RB                  : ')';