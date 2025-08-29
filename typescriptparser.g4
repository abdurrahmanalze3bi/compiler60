parser grammar typescriptparser;

options {
    tokenVocab=typescriptlexer;
}

program     : statement+;

statement   : componentDeclaration      # ComponentStmt
            | classDeclaration         # ClassStmt
            | interfaceDeclaration     # InterfaceStmt
            | variableDeclaration      # VariableDeclStmt
            | assignmentStatement      # AssignmentStmt
            | functionCall             # FunctionCallStmt
            | methodDeclaration        # MethodStmt
            | importDeclaration        # ImportStmt
            ;

// to do class and visitor
assignmentStatement : ID ASSIGN expression SEMICOLON? # AssignmentRule ;

componentDeclaration : DECORATOR COMPONENT LPAREN LBRACE componentDeclarationBody RBRACE RPAREN # ComponentDeclarationRule ;

componentDeclarationBody : (componentBodyElement (COMMA componentBodyElement)*)? # ComponentBody ;

// ====================== MAIN RULES ======================
selector : SELECTOR COLON STRING_LIT # SelectorDeclaration ;

standalone : STANDALONE COLON isboolean # StandaloneProperty ;

template : TEMPLATE COLON_HTML BACKTICK_HTML element* END_TEMPLATE # TemplateDefinition ;

styles : STYLES COLON_CSS OPEN_LIST cssBody CLOSE_LIST COMMA? # StylesBlock ;

importDeclaration : IMPORT LBRACE ID RBRACE FROM STRING_LIT SEMICOLON     # StandardImportDecl
                  | IMPORT LBRACE COMPONENT RBRACE FROM STRING_LIT SEMICOLON  # ComponentImportDecl
                  | IMPORTS COLON LBRACKET ID? RBRACKET                   # ImportArrayDecl
                  ;

// ================= COMPONENT BODY ELEMENT =================
componentBodyElement : selector             # ComponentSelector
                    | standalone           # ComponentStandalone
                    | importDeclaration    # ComponentImportElement
                    | template             # ComponentTemplate
                    | styles               # ComponentStyles
                    ;

isboolean : TRUE   # TrueBoolean
          | FALSE  # FalseBoolean
          ;

classDeclaration : EXPORT? CLASS ID classDeclarationBody # ClassDeclRule ;

classDeclarationBody : LBRACE (classMember SEMICOLON?)* RBRACE # ClassBodyRule ;

classMember : methodDeclaration       # ClassMethodMember
           | propertyDeclaration     # ClassPropertyMember
           | classDeclaration        # NestedClassMember
           ;

propertyDeclaration : ID COLON type ASSIGN initvalue SEMICOLON?   # PropertyWithInit
                   | ID COLON type (OR ID ASSIGN ID)? SEMICOLON?  # PropertyWithoutInit
                   ;

methodDeclaration : ID LPAREN parameterList? RPAREN COLON type? LBRACE methodBody RBRACE # MethodDeclRule ;

methodBody : (statementMethod)* # MethodBodyRule ;

statementMethod : ID ASSIGN expression SEMICOLON returnStatment?   # MethodAssignment
               | THIS DOT ID ASSIGN expression SEMICOLON returnStatment?   # MethodThisPropertyAssignment
               | expression SEMICOLON returnStatment?   # MethodExpression
               | returnStatment   # MethodReturnOnly
               ;

returnStatment : RETURN expression SEMICOLON   # ReturnExpression
              | RETURN ID SEMICOLON           # ReturnIdentifier
              | RETURN isboolean SEMICOLON    # ReturnBoolean
              | RETURN SEMICOLON              # ReturnVoid
              ;

interfaceDeclaration : INTERFACE ID LBRACE interfaceMember* RBRACE ;

interfaceMember : propertyDeclaration   # InterfacePropertyMember
               | methodDeclaration     # InterfaceMethodMember
               ;

parameter : ID COLON type   # ParameterRule ;

parameterList : parameter (COMMA parameter)*   # ParameterListRule ;

variableDeclaration : CONST ID (ASSIGN expression)?   # ConstDeclaration
                   | LET ID (ASSIGN expression)?     # LetDeclaration
                   | VAR ID (ASSIGN expression)?     # VarDeclaration
                   ;

type : STRING_TYPE   # StringType
    | NUMBER_TYPE   # NumberType
    | BOOLEAN_TYPE  # BooleanType
    | ANY_TYPE      # AnyType
    | VOID_TYPE     # VoidType
    | ID            # IdType
    | list          # ListType
    ;

memberAccess : THIS DOT ID   # ThisMemberAccess
            | ID            # SimpleMemberAccess
            ;

list : ID LBRACKET RBRACKET   # ListDeclaration ;

bodylist : (initvalue (COMMA initvalue)*)?   # BodyListRule ;

object : LBRACE bodyobject RBRACE COMMA?   # ObjectRule ;

// Fixed: Add proper label for keyValuePair
keyValuePair : ID COLON initvalue # KeyValuePairRule ;

bodyobject : (keyValuePair (COMMA keyValuePair)* COMMA?)?   # ObjectBodyRule;

initvalue : NUMBER_LIT                   # NumberInitValue
         | STRING_LIT                   # StringInitValue
         | isboolean                    # BooleanInitValue
         | LBRACKET bodylist RBRACKET   # ListInitValue
         | object                       # ObjectInitValue
         ;

expression : STRING_LIT                             # StringLiteralExpr
          | NUMBER_LIT                             # NumberLiteralExpr
          | ID                                     # IdentifierExpr
          | isboolean                              # BooleanLiteralExpr
          | functionCall                           # FunctionCallExpr
          | variableDeclaration                    # VariableDeclarationExpr
          | memberAccess                           # MemberAccessExpr
          | expression operator expression         # BinaryExpr
          | LPAREN expression RPAREN               # ParenthesizedExpr
          ;

operator : PLUS   # PlusOp
        | MINUS  # MinusOp
        | STAR   # StarOp
        | SLASH  # SlashOp
        ;

functionCall : ID LPAREN argument* RPAREN   # StandardFunctionCall ;

argument : expression   # ExpressionArgument ;

element : tag                       # TagElement
       | NAME_HTML (COLON_HTML)?   # HtmlNameElement
       | interpolation             # InterpolationElement
       ;

tag : openingTag element* closingTag   # OpenCloseTag
   | selfClosingTag                   # SelfClosingTagElement
   ;

openingTag : TAG_OPEN_START_HTML attributes* TAG_CLOSE_END_HTML   # OpeningTagRule ;

closingTag : TAG_CLOSE_START_HTML NAME_HTML TAG_CLOSE_END_HTML    # ClosingTagRule ;

selfClosingTag : TAG_OPEN_START_HTML attributes* TAG_END_HTML         # SelfClosingTagRule ;

attributes : NAME_HTML ATTRIBUTE_EQUALS_HTML STRING_HTML          # HtmlAttribute
          | STRUCTURAL_DIR_HTML ATTRIBUTE_EQUALS_HTML STRING_HTML # StructuralDirectiveAttribute
          | BINDING_HTML ATTRIBUTE_EQUALS_HTML STRING_HTML        # BindingAttribute
          | EVENT_BINDING_HTML ATTRIBUTE_EQUALS_HTML STRING_HTML  # EventBindingAttribute
          ;

interpolation : INTERPOLATION_START_HTML NAME_HTML INTERPOLATION_END_HTML   # InterpolationRule ;

cssBody : BACKTICK_CSS cssObjects BACKTICK_CSS COMMA_CSS? # CssBodyRule ;

cssObjects : csselement? (COMMA_CSS? csselement)* # CssObjectsRule ;

csselement : DOT_CSS ID_CSS+ LBRACE_CSS bodyelement+ RBRACE_CSS # CssElementRule ;

bodyelement : ID_CSS COLON_CSS cssValue SEMICOLON_CSS # CssDeclaration ;

cssValue : PERCENT (ID_CSS)*             # PercentValue
         | ID_CSS (ID_CSS)*               # IdValue
         | STRING_LIT                     # StringValue
         ;
