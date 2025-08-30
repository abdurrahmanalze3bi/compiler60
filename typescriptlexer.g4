
lexer grammar typescriptlexer;

// Keywords
IF        : 'if';
ELSE      : 'else';
ELSE_IF: 'else' 'if';
FOR       : 'for';
FOR_EACH: 'forEach';
BREAK: 'break';
CONTINUE: 'continue';
RETURN: 'return';
WHILE: 'while';
DO: 'do';
IN: 'in';
DEFAULT_CASE: 'default';
NEW: 'new';


FUNCTION  : 'function';
CLASS     : 'class';
INTERFACE : 'interface';
IMPORT    : 'import';
EXPORT    : 'export';
CONST     : 'const';
LET       : 'let';
VAR       : 'var';
FROM      : 'from';
COMPONENT : 'Component';

SELECTOR  : 'selector';
STANDALONE: 'standalone';
IMPORTS   : 'imports';
TEMPLATE : 'template' ->pushMode(HTML);
STYLES : 'styles' ->pushMode(CSS);


STRING_TYPE : 'string';
NUMBER_TYPE : 'number';
BOOLEAN_TYPE: 'boolean';
ANY_TYPE    : 'any';
VOID_TYPE   : 'void';

COMMA      : ',';
COLON      : ':';
DOT        : '.';
SEMICOLON  : ';';
EQUALS     : '==';
THIS: 'this';

ASSIGN     : '=';
PLUS       : '+';
MINUS      : '-';
STAR       : '*';
SLASH      : '/';
LESS       : '<';
GREATER    : '>';
EQUAL      : '==';
NOT_EQUAL  : '!=';

LPAREN     : '(';
RPAREN     : ')';
LBRACE     : '{';
RBRACE     : '}';

TRUE : 'true';
FALSE : 'false';
ID  : [a-zA-Z_][a-zA-Z0-9_]*;

// Literals
STRING_LIT : '\'' (~['\\])* '\''
           | '"' (~["\\])* '"' ;

NUMBER_LIT : [0-9]+;

WS         : [ \t\r\n]+ -> skip;
LINE_COMMENT: '//' ~[\r\n]* -> skip;
BLOCK_COMMENT: '/*' .*? '*/' -> skip;

DECORATOR  : '@';
AS         : 'as';
TYPE       : 'type';
LBRACKET   : '[';
RBRACKET   : ']';
OR : '|';
BACKTICK : '`';


mode HTML ;

LINE_COMMENT_HTML: '//' ~[\r\n]* -> skip;
BLOCK_COMMENT_HTML: '/*' .*? '*/' -> skip;

TAG_OPEN_START_HTML    : '<' NAME_HTML;
TAG_CLOSE_START_HTML   : '</' ;
TAG_CLOSE_END_HTML     : '>';
TAG_END_HTML           : '/>';

ATTRIBUTE_EQUALS_HTML  : '=';
STRING_HTML            : '"' (~["\r\n])* '"';
STRUCTURAL_DIR_HTML    : '*' NAME_HTML;
BINDING_HTML           : '[' NAME_HTML ']';
EVENT_BINDING_HTML     : '(' NAME_HTML ')';

NEGATION_HTML          : '!';
COLON_HTML             : ':';

INTERPOLATION_START_HTML : '{{';
INTERPOLATION_END_HTML  : '}}';
DOT_HTML               : '.';
NAME_HTML: [a-zA-Z_][a-zA-Z0-9_!.-]*;
WS_HTML                : [ \t\r\n]+ -> skip;
END_TEMPLATE : '`,' -> popMode;

BACKTICK_HTML: '`';


mode CSS ;
BACKTICK_CSS: '`';
COLON_CSS : ':';
COMMA_CSS: ',';
// End of the template block
OPEN_LIST : '[';
CLOSE_LIST :']'->popMode;
DOT_CSS: '.';
SEMICOLON_CSS : ';';
LBRACE_CSS     : '{';
RBRACE_CSS     : '}';
PERCENT : '%';
WS_CSS         : [ \t\r\n]+ -> skip;
LINE_COMMENT_CSS: '//' ~[\r\n]* -> skip;
BLOCK_COMMENT_CSS: '/*' .*? '*/' -> skip;
PX   : 'px';
EM   : 'em';
REM  : 'rem';
ID_CSS
    : [0-9]+ (PX | EM | REM | PERCENT)?
    |'#'[a-zA-Z_][a-zA-Z0-9_]*
    | [a-zA-Z_-][a-zA-Z0-9_-]*;