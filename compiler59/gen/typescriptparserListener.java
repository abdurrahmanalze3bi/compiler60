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
	 * Enter a parse tree produced by {@link typescriptparser#componentDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterComponentDeclaration(typescriptparser.ComponentDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link typescriptparser#componentDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitComponentDeclaration(typescriptparser.ComponentDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link typescriptparser#componentDeclarationBody}.
	 * @param ctx the parse tree
	 */
	void enterComponentDeclarationBody(typescriptparser.ComponentDeclarationBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link typescriptparser#componentDeclarationBody}.
	 * @param ctx the parse tree
	 */
	void exitComponentDeclarationBody(typescriptparser.ComponentDeclarationBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link typescriptparser#componentBodyElement}.
	 * @param ctx the parse tree
	 */
	void enterComponentBodyElement(typescriptparser.ComponentBodyElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link typescriptparser#componentBodyElement}.
	 * @param ctx the parse tree
	 */
	void exitComponentBodyElement(typescriptparser.ComponentBodyElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link typescriptparser#selector}.
	 * @param ctx the parse tree
	 */
	void enterSelector(typescriptparser.SelectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link typescriptparser#selector}.
	 * @param ctx the parse tree
	 */
	void exitSelector(typescriptparser.SelectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link typescriptparser#standalone}.
	 * @param ctx the parse tree
	 */
	void enterStandalone(typescriptparser.StandaloneContext ctx);
	/**
	 * Exit a parse tree produced by {@link typescriptparser#standalone}.
	 * @param ctx the parse tree
	 */
	void exitStandalone(typescriptparser.StandaloneContext ctx);
	/**
	 * Enter a parse tree produced by {@link typescriptparser#template}.
	 * @param ctx the parse tree
	 */
	void enterTemplate(typescriptparser.TemplateContext ctx);
	/**
	 * Exit a parse tree produced by {@link typescriptparser#template}.
	 * @param ctx the parse tree
	 */
	void exitTemplate(typescriptparser.TemplateContext ctx);
	/**
	 * Enter a parse tree produced by {@link typescriptparser#styles}.
	 * @param ctx the parse tree
	 */
	void enterStyles(typescriptparser.StylesContext ctx);
	/**
	 * Exit a parse tree produced by {@link typescriptparser#styles}.
	 * @param ctx the parse tree
	 */
	void exitStyles(typescriptparser.StylesContext ctx);
	/**
	 * Enter a parse tree produced by {@link typescriptparser#isboolean}.
	 * @param ctx the parse tree
	 */
	void enterIsboolean(typescriptparser.IsbooleanContext ctx);
	/**
	 * Exit a parse tree produced by {@link typescriptparser#isboolean}.
	 * @param ctx the parse tree
	 */
	void exitIsboolean(typescriptparser.IsbooleanContext ctx);
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
	 * Enter a parse tree produced by {@link typescriptparser#propertyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterPropertyDeclaration(typescriptparser.PropertyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link typescriptparser#propertyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitPropertyDeclaration(typescriptparser.PropertyDeclarationContext ctx);
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
	 * Enter a parse tree produced by {@link typescriptparser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(typescriptparser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link typescriptparser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(typescriptparser.ParameterContext ctx);
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
	 * Enter a parse tree produced by {@link typescriptparser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterImportDeclaration(typescriptparser.ImportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link typescriptparser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitImportDeclaration(typescriptparser.ImportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link typescriptparser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(typescriptparser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link typescriptparser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(typescriptparser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link typescriptparser#memberAccess}.
	 * @param ctx the parse tree
	 */
	void enterMemberAccess(typescriptparser.MemberAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link typescriptparser#memberAccess}.
	 * @param ctx the parse tree
	 */
	void exitMemberAccess(typescriptparser.MemberAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link typescriptparser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(typescriptparser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link typescriptparser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(typescriptparser.ListContext ctx);
	/**
	 * Enter a parse tree produced by {@link typescriptparser#bodylist}.
	 * @param ctx the parse tree
	 */
	void enterBodylist(typescriptparser.BodylistContext ctx);
	/**
	 * Exit a parse tree produced by {@link typescriptparser#bodylist}.
	 * @param ctx the parse tree
	 */
	void exitBodylist(typescriptparser.BodylistContext ctx);
	/**
	 * Enter a parse tree produced by {@link typescriptparser#object}.
	 * @param ctx the parse tree
	 */
	void enterObject(typescriptparser.ObjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link typescriptparser#object}.
	 * @param ctx the parse tree
	 */
	void exitObject(typescriptparser.ObjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link typescriptparser#bodyobject}.
	 * @param ctx the parse tree
	 */
	void enterBodyobject(typescriptparser.BodyobjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link typescriptparser#bodyobject}.
	 * @param ctx the parse tree
	 */
	void exitBodyobject(typescriptparser.BodyobjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link typescriptparser#initvalue}.
	 * @param ctx the parse tree
	 */
	void enterInitvalue(typescriptparser.InitvalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link typescriptparser#initvalue}.
	 * @param ctx the parse tree
	 */
	void exitInitvalue(typescriptparser.InitvalueContext ctx);
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
	 * Enter a parse tree produced by {@link typescriptparser#element}.
	 * @param ctx the parse tree
	 */
	void enterElement(typescriptparser.ElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link typescriptparser#element}.
	 * @param ctx the parse tree
	 */
	void exitElement(typescriptparser.ElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link typescriptparser#tag}.
	 * @param ctx the parse tree
	 */
	void enterTag(typescriptparser.TagContext ctx);
	/**
	 * Exit a parse tree produced by {@link typescriptparser#tag}.
	 * @param ctx the parse tree
	 */
	void exitTag(typescriptparser.TagContext ctx);
	/**
	 * Enter a parse tree produced by {@link typescriptparser#openingTag}.
	 * @param ctx the parse tree
	 */
	void enterOpeningTag(typescriptparser.OpeningTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link typescriptparser#openingTag}.
	 * @param ctx the parse tree
	 */
	void exitOpeningTag(typescriptparser.OpeningTagContext ctx);
	/**
	 * Enter a parse tree produced by {@link typescriptparser#closingTag}.
	 * @param ctx the parse tree
	 */
	void enterClosingTag(typescriptparser.ClosingTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link typescriptparser#closingTag}.
	 * @param ctx the parse tree
	 */
	void exitClosingTag(typescriptparser.ClosingTagContext ctx);
	/**
	 * Enter a parse tree produced by {@link typescriptparser#selfClosingTag}.
	 * @param ctx the parse tree
	 */
	void enterSelfClosingTag(typescriptparser.SelfClosingTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link typescriptparser#selfClosingTag}.
	 * @param ctx the parse tree
	 */
	void exitSelfClosingTag(typescriptparser.SelfClosingTagContext ctx);
	/**
	 * Enter a parse tree produced by {@link typescriptparser#attributes}.
	 * @param ctx the parse tree
	 */
	void enterAttributes(typescriptparser.AttributesContext ctx);
	/**
	 * Exit a parse tree produced by {@link typescriptparser#attributes}.
	 * @param ctx the parse tree
	 */
	void exitAttributes(typescriptparser.AttributesContext ctx);
	/**
	 * Enter a parse tree produced by {@link typescriptparser#interpolation}.
	 * @param ctx the parse tree
	 */
	void enterInterpolation(typescriptparser.InterpolationContext ctx);
	/**
	 * Exit a parse tree produced by {@link typescriptparser#interpolation}.
	 * @param ctx the parse tree
	 */
	void exitInterpolation(typescriptparser.InterpolationContext ctx);
	/**
	 * Enter a parse tree produced by {@link typescriptparser#cssBody}.
	 * @param ctx the parse tree
	 */
	void enterCssBody(typescriptparser.CssBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link typescriptparser#cssBody}.
	 * @param ctx the parse tree
	 */
	void exitCssBody(typescriptparser.CssBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link typescriptparser#cssObjects}.
	 * @param ctx the parse tree
	 */
	void enterCssObjects(typescriptparser.CssObjectsContext ctx);
	/**
	 * Exit a parse tree produced by {@link typescriptparser#cssObjects}.
	 * @param ctx the parse tree
	 */
	void exitCssObjects(typescriptparser.CssObjectsContext ctx);
	/**
	 * Enter a parse tree produced by {@link typescriptparser#csselement}.
	 * @param ctx the parse tree
	 */
	void enterCsselement(typescriptparser.CsselementContext ctx);
	/**
	 * Exit a parse tree produced by {@link typescriptparser#csselement}.
	 * @param ctx the parse tree
	 */
	void exitCsselement(typescriptparser.CsselementContext ctx);
	/**
	 * Enter a parse tree produced by {@link typescriptparser#bodyelement}.
	 * @param ctx the parse tree
	 */
	void enterBodyelement(typescriptparser.BodyelementContext ctx);
	/**
	 * Exit a parse tree produced by {@link typescriptparser#bodyelement}.
	 * @param ctx the parse tree
	 */
	void exitBodyelement(typescriptparser.BodyelementContext ctx);
	/**
	 * Enter a parse tree produced by {@link typescriptparser#cssValue}.
	 * @param ctx the parse tree
	 */
	void enterCssValue(typescriptparser.CssValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link typescriptparser#cssValue}.
	 * @param ctx the parse tree
	 */
	void exitCssValue(typescriptparser.CssValueContext ctx);
}