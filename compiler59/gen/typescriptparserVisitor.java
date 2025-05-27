// Generated from C:/Users/ALZOUBI/ideaProjecte/compiler2/typescriptparser.g4 by ANTLR 4.13.2
package gen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link typescriptparser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface typescriptparserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link typescriptparser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(typescriptparser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link typescriptparser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(typescriptparser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link typescriptparser#componentDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponentDeclaration(typescriptparser.ComponentDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link typescriptparser#componentDeclarationBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponentDeclarationBody(typescriptparser.ComponentDeclarationBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link typescriptparser#componentBodyElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponentBodyElement(typescriptparser.ComponentBodyElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link typescriptparser#selector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelector(typescriptparser.SelectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link typescriptparser#standalone}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStandalone(typescriptparser.StandaloneContext ctx);
	/**
	 * Visit a parse tree produced by {@link typescriptparser#template}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplate(typescriptparser.TemplateContext ctx);
	/**
	 * Visit a parse tree produced by {@link typescriptparser#styles}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStyles(typescriptparser.StylesContext ctx);
	/**
	 * Visit a parse tree produced by {@link typescriptparser#isboolean}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsboolean(typescriptparser.IsbooleanContext ctx);
	/**
	 * Visit a parse tree produced by {@link typescriptparser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(typescriptparser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link typescriptparser#classDeclarationBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclarationBody(typescriptparser.ClassDeclarationBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link typescriptparser#classMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMember(typescriptparser.ClassMemberContext ctx);
	/**
	 * Visit a parse tree produced by {@link typescriptparser#propertyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyDeclaration(typescriptparser.PropertyDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link typescriptparser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(typescriptparser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link typescriptparser#methodBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodBody(typescriptparser.MethodBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link typescriptparser#statementMethod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementMethod(typescriptparser.StatementMethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link typescriptparser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceDeclaration(typescriptparser.InterfaceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link typescriptparser#interfaceMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceMember(typescriptparser.InterfaceMemberContext ctx);
	/**
	 * Visit a parse tree produced by {@link typescriptparser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(typescriptparser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link typescriptparser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(typescriptparser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link typescriptparser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(typescriptparser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link typescriptparser#importDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportDeclaration(typescriptparser.ImportDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link typescriptparser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(typescriptparser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link typescriptparser#memberAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberAccess(typescriptparser.MemberAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link typescriptparser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(typescriptparser.ListContext ctx);
	/**
	 * Visit a parse tree produced by {@link typescriptparser#bodylist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBodylist(typescriptparser.BodylistContext ctx);
	/**
	 * Visit a parse tree produced by {@link typescriptparser#object}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObject(typescriptparser.ObjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link typescriptparser#bodyobject}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBodyobject(typescriptparser.BodyobjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link typescriptparser#initvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitvalue(typescriptparser.InitvalueContext ctx);
	/**
	 * Visit a parse tree produced by {@link typescriptparser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(typescriptparser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link typescriptparser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(typescriptparser.OperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link typescriptparser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(typescriptparser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link typescriptparser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(typescriptparser.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link typescriptparser#element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElement(typescriptparser.ElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link typescriptparser#tag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTag(typescriptparser.TagContext ctx);
	/**
	 * Visit a parse tree produced by {@link typescriptparser#openingTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpeningTag(typescriptparser.OpeningTagContext ctx);
	/**
	 * Visit a parse tree produced by {@link typescriptparser#closingTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClosingTag(typescriptparser.ClosingTagContext ctx);
	/**
	 * Visit a parse tree produced by {@link typescriptparser#selfClosingTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelfClosingTag(typescriptparser.SelfClosingTagContext ctx);
	/**
	 * Visit a parse tree produced by {@link typescriptparser#attributes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributes(typescriptparser.AttributesContext ctx);
	/**
	 * Visit a parse tree produced by {@link typescriptparser#interpolation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterpolation(typescriptparser.InterpolationContext ctx);
	/**
	 * Visit a parse tree produced by {@link typescriptparser#cssBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssBody(typescriptparser.CssBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link typescriptparser#cssObjects}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssObjects(typescriptparser.CssObjectsContext ctx);
	/**
	 * Visit a parse tree produced by {@link typescriptparser#csselement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCsselement(typescriptparser.CsselementContext ctx);
	/**
	 * Visit a parse tree produced by {@link typescriptparser#bodyelement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBodyelement(typescriptparser.BodyelementContext ctx);
	/**
	 * Visit a parse tree produced by {@link typescriptparser#cssValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssValue(typescriptparser.CssValueContext ctx);
}