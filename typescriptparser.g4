parser grammar typescriptparser;

options { tokenVocab=typescriptlexer; }

program     : statement+;


statement   :
             componentDeclaration
            |classDeclaration
            | interfaceDeclaration
            | variableDeclaration
            | assignmentStatement
            |functionCall
            | methodDeclaration
            | importDeclaration
            ;
            // to do class and visitor
assignmentStatement
    : ID ASSIGN expression SEMICOLON?
    ;
componentDeclaration
    : DECORATOR COMPONENT LPAREN LBRACE componentDeclarationBody RBRACE RPAREN ;
componentDeclarationBody
    : componentBodyElement (COMMA componentBodyElement)* ;


   componentBodyElement
       : selector             # SelectorElement
       | standalone           # StandaloneElement
       | importDeclaration    # ImportElement
       | template             # TemplateElement
       | styles               # StylesElement
   ;

selector :SELECTOR COLON STRING_LIT ;
standalone : STANDALONE COLON isboolean  ;
template
    : TEMPLATE COLON_HTML BACKTICK_HTML  element* END_TEMPLATE
    ;

styles :
    STYLES COLON_CSS OPEN_LIST cssBody CLOSE_LIST COMMA? # StylesRule
;


isboolean :TRUE | FALSE;


classDeclaration :
    EXPORT? CLASS ID  classDeclarationBody
    ;

classDeclarationBody
    : LBRACE (classMember SEMICOLON?)* RBRACE
    ;

classMember
    : methodDeclaration
    | propertyDeclaration
    | classDeclaration
    ;




propertyDeclaration
    : ID COLON type ASSIGN initvalue SEMICOLON?
    | ID COLON type  (OR ID ASSIGN ID)? SEMICOLON ?

    ;

methodDeclaration
    : ID LPAREN parameterList? RPAREN COLON type? LBRACE methodBody RBRACE
    ;
methodBody :(statementMethod)* ;



statementMethod :
ID ASSIGN expression SEMICOLON return?
|THIS DOT ID ASSIGN expression SEMICOLON return?
| expression SEMICOLON  return?
| return

;


 return : RETURN expression SEMICOLON |RETURN ID SEMICOLON | RETURN isboolean SEMICOLON  ;


interfaceDeclaration
    : INTERFACE ID LBRACE interfaceMember* RBRACE
    ;

interfaceMember
    : propertyDeclaration
    | methodDeclaration
    ;

parameter
    : ID COLON type
    ;
parameterList
    : parameter (COMMA parameter)*
    ;
    // to do
    // date type regular
    // datatype : (int| double | float |final | String | private | public | protected | char | ) ID COLON initialvalue | ID ID COLON initialvalue
variableDeclaration
    : (CONST | LET | VAR ) ID   (ASSIGN expression)?
    ;

importDeclaration
    : IMPORT LBRACE ID RBRACE FROM STRING_LIT SEMICOLON
    | IMPORT LBRACE COMPONENT RBRACE FROM STRING_LIT SEMICOLON
    | IMPORTS COLON LBRACKET ID? RBRACKET
    ;



type        : STRING_TYPE
            | NUMBER_TYPE
            | BOOLEAN_TYPE
            | ANY_TYPE
            | VOID_TYPE
            | ID
            | list;

memberAccess: THIS DOT ID;

list
    : ID LBRACKET RBRACKET
    ;
bodylist
    : (initvalue (COMMA initvalue)*)?
    ;

object
    : LBRACE bodyobject RBRACE COMMA?
    ;

bodyobject
    : (ID COLON initvalue (COMMA ID COLON initvalue COMMA?)*)?

    ;

   initvalue
     : NUMBER_LIT
     | STRING_LIT
     | isboolean
     | LBRACKET bodylist RBRACKET
     | object
 ;

expression
    : STRING_LIT
    | NUMBER_LIT
    | ID
    | isboolean
    | functionCall
    | variableDeclaration
    | memberAccess
    | expression operator expression     // <-- دعم العمليات الحسابية
    | LPAREN expression RPAREN           // <-- دعم الأقواس
    ;

operator
        : PLUS
        | MINUS
        | STAR
        | SLASH
        ;



functionCall
    : ID LPAREN argument* RPAREN
    ;

argument    : expression
            ;
element
    : tag
    | NAME_HTML (COLON_HTML)?
    | interpolation
    ;

tag
    : openingTag element* closingTag
    | selfClosingTag
    ;

openingTag
    : TAG_OPEN_START_HTML attributes* TAG_CLOSE_END_HTML
    ;

closingTag
    : TAG_CLOSE_START_HTML NAME_HTML TAG_CLOSE_END_HTML
    ;

selfClosingTag
    : TAG_OPEN_START_HTML attributes* TAG_END_HTML
    ;

attributes
    : NAME_HTML ATTRIBUTE_EQUALS_HTML STRING_HTML
    | STRUCTURAL_DIR_HTML ATTRIBUTE_EQUALS_HTML STRING_HTML
    | BINDING_HTML ATTRIBUTE_EQUALS_HTML STRING_HTML
    | EVENT_BINDING_HTML ATTRIBUTE_EQUALS_HTML STRING_HTML
    ;

interpolation
    : INTERPOLATION_START_HTML NAME_HTML INTERPOLATION_END_HTML
    ;


  cssBody :
      BACKTICK_CSS cssObjects BACKTICK_CSS COMMA_CSS? # CssBodyRule
  ;
cssObjects :
    csselement? (COMMA_CSS? csselement)* # CssObjectsRule
;


   csselement :
       DOT_CSS ID_CSS+ LBRACE_CSS bodyelement+ RBRACE_CSS # CssElementRule
   ;
 bodyelement :
     ID_CSS COLON_CSS cssValue SEMICOLON_CSS # CssDeclaration
 ;

// Updated cssValue rule with labels
cssValue : PERCENT (ID_CSS ID_CSS?)?     # PercentValue
         | ID_CSS (ID_CSS ID_CSS?)?      # IdValue
         ;