grammar Math;

expression          : term ((ADD | SUB) term)*;
term                : factor ((MUL | DIV) factor)*;
factor              : '(' expression ')'
                    | VALUE;

VALUE               : [1-9][0-9]*;

ADD                 : '+';
SUB                 : '-';
MUL                 : '*';
DIV                 : '/';
LB                  : '(';
RB                  : ')';