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
    : ID ASSIGN expression SEMICOLON? # AssignmentRule
    ;
componentDeclaration
    : DECORATOR COMPONENT LPAREN LBRACE componentDeclarationBody RBRACE RPAREN
      # ComponentDeclarationRule
    ;

componentDeclarationBody
    : (componentBodyElement (COMMA componentBodyElement)*)? # ComponentBody
    ;

   // ====================== MAIN RULES ======================
selector :
    SELECTOR COLON STRING_LIT # SelectorDeclaration
;

standalone :
    STANDALONE COLON isboolean # StandaloneProperty
;

template :
    TEMPLATE COLON_HTML BACKTICK_HTML element* END_TEMPLATE # TemplateDefinition
;

styles :
    STYLES COLON_CSS OPEN_LIST cssBody CLOSE_LIST COMMA? # StylesBlock
;

importDeclaration
    : IMPORT LBRACE ID RBRACE FROM STRING_LIT SEMICOLON     # StandardImportDecl
    | IMPORT LBRACE COMPONENT RBRACE FROM STRING_LIT SEMICOLON  # ComponentImportDecl  // Changed
    | IMPORTS COLON LBRACKET ID? RBRACKET                   # ImportArrayDecl         // Changed
;


   // ================= COMPONENT BODY ELEMENT =================



   componentBodyElement
       : selector             # ComponentSelector
       | standalone           # ComponentStandalone
       | importDeclaration    # ComponentImportElement  // Changed
       | template             # ComponentTemplate
       | styles               # ComponentStyles
       ;











































isboolean
    : TRUE   # TrueBoolean
    | FALSE  # FalseBoolean
    ;





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
    : ID COLON type ASSIGN initvalue SEMICOLON?   # PropertyWithInit
    | ID COLON type (OR ID ASSIGN ID)? SEMICOLON?  # PropertyWithoutInit
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
    : ID COLON type   # ParameterRule
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


type
    : STRING_TYPE   # StringType
    | NUMBER_TYPE   # NumberType
    | BOOLEAN_TYPE  # BooleanType
    | ANY_TYPE      # AnyType
    | VOID_TYPE     # VoidType
    | ID            # IdType
    | list          # ListType
    ;
memberAccess
    : THIS DOT ID   # ThisMemberAccess
    | ID            # SimpleMemberAccess  // Added alternative for regular member access
    ;

list
    : ID LBRACKET RBRACKET   # ListDeclaration
    ;
bodylist
    : (initvalue (COMMA initvalue)*)?   # BodyListRule
    ;
object
    : LBRACE bodyobject RBRACE COMMA?   # ObjectRule
    ;
bodyobject
    : (keyValuePair (COMMA keyValuePair)*)?   # ObjectBodyRule
    ;

keyValuePair
    : ID COLON initvalue   # KeyValue

    ;

 initvalue
     : NUMBER_LIT                   # NumberInitValue
     | STRING_LIT                   # StringInitValue
     | isboolean                    # BooleanInitValue
     | LBRACKET bodylist RBRACKET   # ListInitValue
     | object                       # ObjectInitValue
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
    : tag                       # TagElement
    | NAME_HTML (COLON_HTML)?   # HtmlNameElement
    | interpolation             # InterpolationElement
    ;

tag
    : openingTag element* closingTag   # OpenCloseTag
    | selfClosingTag                   # SelfClosingTagElement
    ;
openingTag
    : TAG_OPEN_START_HTML attributes* TAG_CLOSE_END_HTML   # OpeningTagRule
    ;

closingTag
    : TAG_CLOSE_START_HTML NAME_HTML TAG_CLOSE_END_HTML    # ClosingTagRule
    ;

selfClosingTag
    : TAG_OPEN_START_HTML attributes* TAG_END_HTML         # SelfClosingTagRule
    ;
attributes
    : NAME_HTML ATTRIBUTE_EQUALS_HTML STRING_HTML          # HtmlAttribute
    | STRUCTURAL_DIR_HTML ATTRIBUTE_EQUALS_HTML STRING_HTML # StructuralDirectiveAttribute
    | BINDING_HTML ATTRIBUTE_EQUALS_HTML STRING_HTML        # BindingAttribute
    | EVENT_BINDING_HTML ATTRIBUTE_EQUALS_HTML STRING_HTML  # EventBindingAttribute
    ;
interpolation
    : INTERPOLATION_START_HTML NAME_HTML INTERPOLATION_END_HTML   # InterpolationRule
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