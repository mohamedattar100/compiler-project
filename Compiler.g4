grammar Compiler ;


mainBlock : '{' block* '}'block*;

block : '{'block*'}';



WS : [ \t\r\n]+ -> skip;
