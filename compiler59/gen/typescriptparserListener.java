// Generated from C:/Users/ALZOUBI/ideaProjecte/compiler2/typescriptparser.g4 by ANTLR 4.13.2
package gen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link typescriptparser}.
 */
public interface typescriptparserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link typescriptparser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(typescriptparser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link typescriptparser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(typescriptparser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link typescriptparser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(typescriptparser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link typescriptparser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(typescriptparser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignmentRule}
	 * labeled alternative in {@link typescriptparser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentRule(typescriptparser.AssignmentRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignmentRule}
	 * labeled alternative in {@link typescriptparser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentRule(typescriptparser.AssignmentRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComponentDeclarationRule}
	 * labeled alternative in {@link typescriptparser#componentDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterComponentDeclarationRule(typescriptparser.ComponentDeclarationRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComponentDeclarationRule}
	 * labeled alternative in {@link typescriptparser#componentDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitComponentDeclarationRule(typescriptparser.ComponentDeclarationRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComponentBody}
	 * labeled alternative in {@link typescriptparser#componentDeclarationBody}.
	 * @param ctx the parse tree
	 */
	void enterComponentBody(typescriptparser.ComponentBodyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComponentBody}
	 * labeled alternative in {@link typescriptparser#componentDeclarationBody}.
	 * @param ctx the parse tree
	 */
	void exitComponentBody(typescriptparser.ComponentBodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SelectorDeclaration}
	 * labeled alternative in {@link typescriptparser#selector}.
	 * @param ctx the parse tree
	 */
	void enterSelectorDeclaration(typescriptparser.SelectorDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SelectorDeclaration}
	 * labeled alternative in {@link typescriptparser#selector}.
	 * @param ctx the parse tree
	 */
	void exitSelectorDeclaration(typescriptparser.SelectorDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StandaloneProperty}
	 * labeled alternative in {@link typescriptparser#standalone}.
	 * @param ctx the parse tree
	 */
	void enterStandaloneProperty(typescriptparser.StandalonePropertyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StandaloneProperty}
	 * labeled alternative in {@link typescriptparser#standalone}.
	 * @param ctx the parse tree
	 */
	void exitStandaloneProperty(typescriptparser.StandalonePropertyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TemplateDefinition}
	 * labeled alternative in {@link typescriptparser#template}.
	 * @param ctx the parse tree
	 */
	void enterTemplateDefinition(typescriptparser.TemplateDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TemplateDefinition}
	 * labeled alternative in {@link typescriptparser#template}.
	 * @param ctx the parse tree
	 */
	void exitTemplateDefinition(typescriptparser.TemplateDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StylesBlock}
	 * labeled alternative in {@link typescriptparser#styles}.
	 * @param ctx the parse tree
	 */
	void enterStylesBlock(typescriptparser.StylesBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StylesBlock}
	 * labeled alternative in {@link typescriptparser#styles}.
	 * @param ctx the parse tree
	 */
	void exitStylesBlock(typescriptparser.StylesBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StandardImportDecl}
	 * labeled alternative in {@link typescriptparser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterStandardImportDecl(typescriptparser.StandardImportDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StandardImportDecl}
	 * labeled alternative in {@link typescriptparser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitStandardImportDecl(typescriptparser.StandardImportDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComponentImportDecl}
	 * labeled alternative in {@link typescriptparser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterComponentImportDecl(typescriptparser.ComponentImportDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComponentImportDecl}
	 * labeled alternative in {@link typescriptparser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitComponentImportDecl(typescriptparser.ComponentImportDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ImportArrayDecl}
	 * labeled alternative in {@link typescriptparser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterImportArrayDecl(typescriptparser.ImportArrayDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ImportArrayDecl}
	 * labeled alternative in {@link typescriptparser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitImportArrayDecl(typescriptparser.ImportArrayDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComponentSelector}
	 * labeled alternative in {@link typescriptparser#componentBodyElement}.
	 * @param ctx the parse tree
	 */
	void enterComponentSelector(typescriptparser.ComponentSelectorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComponentSelector}
	 * labeled alternative in {@link typescriptparser#componentBodyElement}.
	 * @param ctx the parse tree
	 */
	void exitComponentSelector(typescriptparser.ComponentSelectorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComponentStandalone}
	 * labeled alternative in {@link typescriptparser#componentBodyElement}.
	 * @param ctx the parse tree
	 */
	void enterComponentStandalone(typescriptparser.ComponentStandaloneContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComponentStandalone}
	 * labeled alternative in {@link typescriptparser#componentBodyElement}.
	 * @param ctx the parse tree
	 */
	void exitComponentStandalone(typescriptparser.ComponentStandaloneContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComponentImportElement}
	 * labeled alternative in {@link typescriptparser#componentBodyElement}.
	 * @param ctx the parse tree
	 */
	void enterComponentImportElement(typescriptparser.ComponentImportElementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComponentImportElement}
	 * labeled alternative in {@link typescriptparser#componentBodyElement}.
	 * @param ctx the parse tree
	 */
	void exitComponentImportElement(typescriptparser.ComponentImportElementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComponentTemplate}
	 * labeled alternative in {@link typescriptparser#componentBodyElement}.
	 * @param ctx the parse tree
	 */
	void enterComponentTemplate(typescriptparser.ComponentTemplateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComponentTemplate}
	 * labeled alternative in {@link typescriptparser#componentBodyElement}.
	 * @param ctx the parse tree
	 */
	void exitComponentTemplate(typescriptparser.ComponentTemplateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComponentStyles}
	 * labeled alternative in {@link typescriptparser#componentBodyElement}.
	 * @param ctx the parse tree
	 */
	void enterComponentStyles(typescriptparser.ComponentStylesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComponentStyles}
	 * labeled alternative in {@link typescriptparser#componentBodyElement}.
	 * @param ctx the parse tree
	 */
	void exitComponentStyles(typescriptparser.ComponentStylesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TrueBoolean}
	 * labeled alternative in {@link typescriptparser#isboolean}.
	 * @param ctx the parse tree
	 */
	void enterTrueBoolean(typescriptparser.TrueBooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TrueBoolean}
	 * labeled alternative in {@link typescriptparser#isboolean}.
	 * @param ctx the parse tree
	 */
	void exitTrueBoolean(typescriptparser.TrueBooleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FalseBoolean}
	 * labeled alternative in {@link typescriptparser#isboolean}.
	 * @param ctx the parse tree
	 */
	void enterFalseBoolean(typescriptparser.FalseBooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FalseBoolean}
	 * labeled alternative in {@link typescriptparser#isboolean}.
	 * @param ctx the parse tree
	 */
	void exitFalseBoolean(typescriptparser.FalseBooleanContext ctx);
	/**
	 * Enter a parse tree produced by {@link typescriptparser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(typescriptparser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link typescriptparser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(typescriptparser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link typescriptparser#classDeclarationBody}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclarationBody(typescriptparser.ClassDeclarationBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link typescriptparser#classDeclarationBody}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclarationBody(typescriptparser.ClassDeclarationBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link typescriptparser#classMember}.
	 * @param ctx the parse tree
	 */
	void enterClassMember(typescriptparser.ClassMemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link typescriptparser#classMember}.
	 * @param ctx the parse tree
	 */
	void exitClassMember(typescriptparser.ClassMemberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PropertyWithInit}
	 * labeled alternative in {@link typescriptparser#propertyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterPropertyWithInit(typescriptparser.PropertyWithInitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PropertyWithInit}
	 * labeled alternative in {@link typescriptparser#propertyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitPropertyWithInit(typescriptparser.PropertyWithInitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PropertyWithoutInit}
	 * labeled alternative in {@link typescriptparser#propertyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterPropertyWithoutInit(typescriptparser.PropertyWithoutInitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PropertyWithoutInit}
	 * labeled alternative in {@link typescriptparser#propertyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitPropertyWithoutInit(typescriptparser.PropertyWithoutInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link typescriptparser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(typescriptparser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link typescriptparser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(typescriptparser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link typescriptparser#methodBody}.
	 * @param ctx the parse tree
	 */
	void enterMethodBody(typescriptparser.MethodBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link typescriptparser#methodBody}.
	 * @param ctx the parse tree
	 */
	void exitMethodBody(typescriptparser.MethodBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link typescriptparser#statementMethod}.
	 * @param ctx the parse tree
	 */
	void enterStatementMethod(typescriptparser.StatementMethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link typescriptparser#statementMethod}.
	 * @param ctx the parse tree
	 */
	void exitStatementMethod(typescriptparser.StatementMethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link typescriptparser#return}.
	 * @param ctx the parse tree
	 */
	void enterReturn(typescriptparser.ReturnContext ctx);
	/**
	 * Exit a parse tree produced by {@link typescriptparser#return}.
	 * @param ctx the parse tree
	 */
	void exitReturn(typescriptparser.ReturnContext ctx);
	/**
	 * Enter a parse tree produced by {@link typescriptparser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceDeclaration(typescriptparser.InterfaceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link typescriptparser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceDeclaration(typescriptparser.InterfaceDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link typescriptparser#interfaceMember}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceMember(typescriptparser.InterfaceMemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link typescriptparser#interfaceMember}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceMember(typescriptparser.InterfaceMemberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParameterRule}
	 * labeled alternative in {@link typescriptparser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameterRule(typescriptparser.ParameterRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParameterRule}
	 * labeled alternative in {@link typescriptparser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameterRule(typescriptparser.ParameterRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link typescriptparser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(typescriptparser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link typescriptparser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(typescriptparser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link typescriptparser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(typescriptparser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link typescriptparser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(typescriptparser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringType}
	 * labeled alternative in {@link typescriptparser#type}.
	 * @param ctx the parse tree
	 */
	void enterStringType(typescriptparser.StringTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringType}
	 * labeled alternative in {@link typescriptparser#type}.
	 * @param ctx the parse tree
	 */
	void exitStringType(typescriptparser.StringTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NumberType}
	 * labeled alternative in {@link typescriptparser#type}.
	 * @param ctx the parse tree
	 */
	void enterNumberType(typescriptparser.NumberTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NumberType}
	 * labeled alternative in {@link typescriptparser#type}.
	 * @param ctx the parse tree
	 */
	void exitNumberType(typescriptparser.NumberTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BooleanType}
	 * labeled alternative in {@link typescriptparser#type}.
	 * @param ctx the parse tree
	 */
	void enterBooleanType(typescriptparser.BooleanTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BooleanType}
	 * labeled alternative in {@link typescriptparser#type}.
	 * @param ctx the parse tree
	 */
	void exitBooleanType(typescriptparser.BooleanTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AnyType}
	 * labeled alternative in {@link typescriptparser#type}.
	 * @param ctx the parse tree
	 */
	void enterAnyType(typescriptparser.AnyTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AnyType}
	 * labeled alternative in {@link typescriptparser#type}.
	 * @param ctx the parse tree
	 */
	void exitAnyType(typescriptparser.AnyTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VoidType}
	 * labeled alternative in {@link typescriptparser#type}.
	 * @param ctx the parse tree
	 */
	void enterVoidType(typescriptparser.VoidTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VoidType}
	 * labeled alternative in {@link typescriptparser#type}.
	 * @param ctx the parse tree
	 */
	void exitVoidType(typescriptparser.VoidTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdType}
	 * labeled alternative in {@link typescriptparser#type}.
	 * @param ctx the parse tree
	 */
	void enterIdType(typescriptparser.IdTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdType}
	 * labeled alternative in {@link typescriptparser#type}.
	 * @param ctx the parse tree
	 */
	void exitIdType(typescriptparser.IdTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListType}
	 * labeled alternative in {@link typescriptparser#type}.
	 * @param ctx the parse tree
	 */
	void enterListType(typescriptparser.ListTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListType}
	 * labeled alternative in {@link typescriptparser#type}.
	 * @param ctx the parse tree
	 */
	void exitListType(typescriptparser.ListTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ThisMemberAccess}
	 * labeled alternative in {@link typescriptparser#memberAccess}.
	 * @param ctx the parse tree
	 */
	void enterThisMemberAccess(typescriptparser.ThisMemberAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ThisMemberAccess}
	 * labeled alternative in {@link typescriptparser#memberAccess}.
	 * @param ctx the parse tree
	 */
	void exitThisMemberAccess(typescriptparser.ThisMemberAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SimpleMemberAccess}
	 * labeled alternative in {@link typescriptparser#memberAccess}.
	 * @param ctx the parse tree
	 */
	void enterSimpleMemberAccess(typescriptparser.SimpleMemberAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SimpleMemberAccess}
	 * labeled alternative in {@link typescriptparser#memberAccess}.
	 * @param ctx the parse tree
	 */
	void exitSimpleMemberAccess(typescriptparser.SimpleMemberAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListDeclaration}
	 * labeled alternative in {@link typescriptparser#list}.
	 * @param ctx the parse tree
	 */
	void enterListDeclaration(typescriptparser.ListDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListDeclaration}
	 * labeled alternative in {@link typescriptparser#list}.
	 * @param ctx the parse tree
	 */
	void exitListDeclaration(typescriptparser.ListDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BodyListRule}
	 * labeled alternative in {@link typescriptparser#bodylist}.
	 * @param ctx the parse tree
	 */
	void enterBodyListRule(typescriptparser.BodyListRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BodyListRule}
	 * labeled alternative in {@link typescriptparser#bodylist}.
	 * @param ctx the parse tree
	 */
	void exitBodyListRule(typescriptparser.BodyListRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ObjectRule}
	 * labeled alternative in {@link typescriptparser#object}.
	 * @param ctx the parse tree
	 */
	void enterObjectRule(typescriptparser.ObjectRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ObjectRule}
	 * labeled alternative in {@link typescriptparser#object}.
	 * @param ctx the parse tree
	 */
	void exitObjectRule(typescriptparser.ObjectRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ObjectBodyRule}
	 * labeled alternative in {@link typescriptparser#bodyobject}.
	 * @param ctx the parse tree
	 */
	void enterObjectBodyRule(typescriptparser.ObjectBodyRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ObjectBodyRule}
	 * labeled alternative in {@link typescriptparser#bodyobject}.
	 * @param ctx the parse tree
	 */
	void exitObjectBodyRule(typescriptparser.ObjectBodyRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code KeyValue}
	 * labeled alternative in {@link typescriptparser#keyValuePair}.
	 * @param ctx the parse tree
	 */
	void enterKeyValue(typescriptparser.KeyValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code KeyValue}
	 * labeled alternative in {@link typescriptparser#keyValuePair}.
	 * @param ctx the parse tree
	 */
	void exitKeyValue(typescriptparser.KeyValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NumberInitValue}
	 * labeled alternative in {@link typescriptparser#initvalue}.
	 * @param ctx the parse tree
	 */
	void enterNumberInitValue(typescriptparser.NumberInitValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NumberInitValue}
	 * labeled alternative in {@link typescriptparser#initvalue}.
	 * @param ctx the parse tree
	 */
	void exitNumberInitValue(typescriptparser.NumberInitValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringInitValue}
	 * labeled alternative in {@link typescriptparser#initvalue}.
	 * @param ctx the parse tree
	 */
	void enterStringInitValue(typescriptparser.StringInitValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringInitValue}
	 * labeled alternative in {@link typescriptparser#initvalue}.
	 * @param ctx the parse tree
	 */
	void exitStringInitValue(typescriptparser.StringInitValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BooleanInitValue}
	 * labeled alternative in {@link typescriptparser#initvalue}.
	 * @param ctx the parse tree
	 */
	void enterBooleanInitValue(typescriptparser.BooleanInitValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BooleanInitValue}
	 * labeled alternative in {@link typescriptparser#initvalue}.
	 * @param ctx the parse tree
	 */
	void exitBooleanInitValue(typescriptparser.BooleanInitValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListInitValue}
	 * labeled alternative in {@link typescriptparser#initvalue}.
	 * @param ctx the parse tree
	 */
	void enterListInitValue(typescriptparser.ListInitValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListInitValue}
	 * labeled alternative in {@link typescriptparser#initvalue}.
	 * @param ctx the parse tree
	 */
	void exitListInitValue(typescriptparser.ListInitValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ObjectInitValue}
	 * labeled alternative in {@link typescriptparser#initvalue}.
	 * @param ctx the parse tree
	 */
	void enterObjectInitValue(typescriptparser.ObjectInitValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ObjectInitValue}
	 * labeled alternative in {@link typescriptparser#initvalue}.
	 * @param ctx the parse tree
	 */
	void exitObjectInitValue(typescriptparser.ObjectInitValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link typescriptparser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(typescriptparser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link typescriptparser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(typescriptparser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link typescriptparser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(typescriptparser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link typescriptparser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(typescriptparser.OperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link typescriptparser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(typescriptparser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link typescriptparser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(typescriptparser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link typescriptparser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(typescriptparser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link typescriptparser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(typescriptparser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TagElement}
	 * labeled alternative in {@link typescriptparser#element}.
	 * @param ctx the parse tree
	 */
	void enterTagElement(typescriptparser.TagElementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TagElement}
	 * labeled alternative in {@link typescriptparser#element}.
	 * @param ctx the parse tree
	 */
	void exitTagElement(typescriptparser.TagElementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code HtmlNameElement}
	 * labeled alternative in {@link typescriptparser#element}.
	 * @param ctx the parse tree
	 */
	void enterHtmlNameElement(typescriptparser.HtmlNameElementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code HtmlNameElement}
	 * labeled alternative in {@link typescriptparser#element}.
	 * @param ctx the parse tree
	 */
	void exitHtmlNameElement(typescriptparser.HtmlNameElementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InterpolationElement}
	 * labeled alternative in {@link typescriptparser#element}.
	 * @param ctx the parse tree
	 */
	void enterInterpolationElement(typescriptparser.InterpolationElementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InterpolationElement}
	 * labeled alternative in {@link typescriptparser#element}.
	 * @param ctx the parse tree
	 */
	void exitInterpolationElement(typescriptparser.InterpolationElementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OpenCloseTag}
	 * labeled alternative in {@link typescriptparser#tag}.
	 * @param ctx the parse tree
	 */
	void enterOpenCloseTag(typescriptparser.OpenCloseTagContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OpenCloseTag}
	 * labeled alternative in {@link typescriptparser#tag}.
	 * @param ctx the parse tree
	 */
	void exitOpenCloseTag(typescriptparser.OpenCloseTagContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SelfClosingTagElement}
	 * labeled alternative in {@link typescriptparser#tag}.
	 * @param ctx the parse tree
	 */
	void enterSelfClosingTagElement(typescriptparser.SelfClosingTagElementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SelfClosingTagElement}
	 * labeled alternative in {@link typescriptparser#tag}.
	 * @param ctx the parse tree
	 */
	void exitSelfClosingTagElement(typescriptparser.SelfClosingTagElementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OpeningTagRule}
	 * labeled alternative in {@link typescriptparser#openingTag}.
	 * @param ctx the parse tree
	 */
	void enterOpeningTagRule(typescriptparser.OpeningTagRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OpeningTagRule}
	 * labeled alternative in {@link typescriptparser#openingTag}.
	 * @param ctx the parse tree
	 */
	void exitOpeningTagRule(typescriptparser.OpeningTagRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ClosingTagRule}
	 * labeled alternative in {@link typescriptparser#closingTag}.
	 * @param ctx the parse tree
	 */
	void enterClosingTagRule(typescriptparser.ClosingTagRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ClosingTagRule}
	 * labeled alternative in {@link typescriptparser#closingTag}.
	 * @param ctx the parse tree
	 */
	void exitClosingTagRule(typescriptparser.ClosingTagRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SelfClosingTagRule}
	 * labeled alternative in {@link typescriptparser#selfClosingTag}.
	 * @param ctx the parse tree
	 */
	void enterSelfClosingTagRule(typescriptparser.SelfClosingTagRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SelfClosingTagRule}
	 * labeled alternative in {@link typescriptparser#selfClosingTag}.
	 * @param ctx the parse tree
	 */
	void exitSelfClosingTagRule(typescriptparser.SelfClosingTagRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code HtmlAttribute}
	 * labeled alternative in {@link typescriptparser#attributes}.
	 * @param ctx the parse tree
	 */
	void enterHtmlAttribute(typescriptparser.HtmlAttributeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code HtmlAttribute}
	 * labeled alternative in {@link typescriptparser#attributes}.
	 * @param ctx the parse tree
	 */
	void exitHtmlAttribute(typescriptparser.HtmlAttributeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StructuralDirectiveAttribute}
	 * labeled alternative in {@link typescriptparser#attributes}.
	 * @param ctx the parse tree
	 */
	void enterStructuralDirectiveAttribute(typescriptparser.StructuralDirectiveAttributeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StructuralDirectiveAttribute}
	 * labeled alternative in {@link typescriptparser#attributes}.
	 * @param ctx the parse tree
	 */
	void exitStructuralDirectiveAttribute(typescriptparser.StructuralDirectiveAttributeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BindingAttribute}
	 * labeled alternative in {@link typescriptparser#attributes}.
	 * @param ctx the parse tree
	 */
	void enterBindingAttribute(typescriptparser.BindingAttributeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BindingAttribute}
	 * labeled alternative in {@link typescriptparser#attributes}.
	 * @param ctx the parse tree
	 */
	void exitBindingAttribute(typescriptparser.BindingAttributeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EventBindingAttribute}
	 * labeled alternative in {@link typescriptparser#attributes}.
	 * @param ctx the parse tree
	 */
	void enterEventBindingAttribute(typescriptparser.EventBindingAttributeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EventBindingAttribute}
	 * labeled alternative in {@link typescriptparser#attributes}.
	 * @param ctx the parse tree
	 */
	void exitEventBindingAttribute(typescriptparser.EventBindingAttributeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InterpolationRule}
	 * labeled alternative in {@link typescriptparser#interpolation}.
	 * @param ctx the parse tree
	 */
	void enterInterpolationRule(typescriptparser.InterpolationRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InterpolationRule}
	 * labeled alternative in {@link typescriptparser#interpolation}.
	 * @param ctx the parse tree
	 */
	void exitInterpolationRule(typescriptparser.InterpolationRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CssBodyRule}
	 * labeled alternative in {@link typescriptparser#cssBody}.
	 * @param ctx the parse tree
	 */
	void enterCssBodyRule(typescriptparser.CssBodyRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CssBodyRule}
	 * labeled alternative in {@link typescriptparser#cssBody}.
	 * @param ctx the parse tree
	 */
	void exitCssBodyRule(typescriptparser.CssBodyRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CssObjectsRule}
	 * labeled alternative in {@link typescriptparser#cssObjects}.
	 * @param ctx the parse tree
	 */
	void enterCssObjectsRule(typescriptparser.CssObjectsRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CssObjectsRule}
	 * labeled alternative in {@link typescriptparser#cssObjects}.
	 * @param ctx the parse tree
	 */
	void exitCssObjectsRule(typescriptparser.CssObjectsRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CssElementRule}
	 * labeled alternative in {@link typescriptparser#csselement}.
	 * @param ctx the parse tree
	 */
	void enterCssElementRule(typescriptparser.CssElementRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CssElementRule}
	 * labeled alternative in {@link typescriptparser#csselement}.
	 * @param ctx the parse tree
	 */
	void exitCssElementRule(typescriptparser.CssElementRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CssDeclaration}
	 * labeled alternative in {@link typescriptparser#bodyelement}.
	 * @param ctx the parse tree
	 */
	void enterCssDeclaration(typescriptparser.CssDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CssDeclaration}
	 * labeled alternative in {@link typescriptparser#bodyelement}.
	 * @param ctx the parse tree
	 */
	void exitCssDeclaration(typescriptparser.CssDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PercentValue}
	 * labeled alternative in {@link typescriptparser#cssValue}.
	 * @param ctx the parse tree
	 */
	void enterPercentValue(typescriptparser.PercentValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PercentValue}
	 * labeled alternative in {@link typescriptparser#cssValue}.
	 * @param ctx the parse tree
	 */
	void exitPercentValue(typescriptparser.PercentValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdValue}
	 * labeled alternative in {@link typescriptparser#cssValue}.
	 * @param ctx the parse tree
	 */
	void enterIdValue(typescriptparser.IdValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdValue}
	 * labeled alternative in {@link typescriptparser#cssValue}.
	 * @param ctx the parse tree
	 */
	void exitIdValue(typescriptparser.IdValueContext ctx);
}