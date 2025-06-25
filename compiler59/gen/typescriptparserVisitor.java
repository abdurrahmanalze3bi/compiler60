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
	 * Visit a parse tree produced by the {@code AssignmentRule}
	 * labeled alternative in {@link typescriptparser#assignmentStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentRule(typescriptparser.AssignmentRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComponentDeclarationRule}
	 * labeled alternative in {@link typescriptparser#componentDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponentDeclarationRule(typescriptparser.ComponentDeclarationRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComponentBody}
	 * labeled alternative in {@link typescriptparser#componentDeclarationBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponentBody(typescriptparser.ComponentBodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SelectorDeclaration}
	 * labeled alternative in {@link typescriptparser#selector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectorDeclaration(typescriptparser.SelectorDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StandaloneProperty}
	 * labeled alternative in {@link typescriptparser#standalone}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStandaloneProperty(typescriptparser.StandalonePropertyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TemplateDefinition}
	 * labeled alternative in {@link typescriptparser#template}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplateDefinition(typescriptparser.TemplateDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StylesBlock}
	 * labeled alternative in {@link typescriptparser#styles}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStylesBlock(typescriptparser.StylesBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StandardImportDecl}
	 * labeled alternative in {@link typescriptparser#importDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStandardImportDecl(typescriptparser.StandardImportDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComponentImportDecl}
	 * labeled alternative in {@link typescriptparser#importDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponentImportDecl(typescriptparser.ComponentImportDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ImportArrayDecl}
	 * labeled alternative in {@link typescriptparser#importDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportArrayDecl(typescriptparser.ImportArrayDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComponentSelector}
	 * labeled alternative in {@link typescriptparser#componentBodyElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponentSelector(typescriptparser.ComponentSelectorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComponentStandalone}
	 * labeled alternative in {@link typescriptparser#componentBodyElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponentStandalone(typescriptparser.ComponentStandaloneContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComponentImportElement}
	 * labeled alternative in {@link typescriptparser#componentBodyElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponentImportElement(typescriptparser.ComponentImportElementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComponentTemplate}
	 * labeled alternative in {@link typescriptparser#componentBodyElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponentTemplate(typescriptparser.ComponentTemplateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComponentStyles}
	 * labeled alternative in {@link typescriptparser#componentBodyElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponentStyles(typescriptparser.ComponentStylesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TrueBoolean}
	 * labeled alternative in {@link typescriptparser#isboolean}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueBoolean(typescriptparser.TrueBooleanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FalseBoolean}
	 * labeled alternative in {@link typescriptparser#isboolean}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseBoolean(typescriptparser.FalseBooleanContext ctx);
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
	 * Visit a parse tree produced by the {@code PropertyWithInit}
	 * labeled alternative in {@link typescriptparser#propertyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyWithInit(typescriptparser.PropertyWithInitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PropertyWithoutInit}
	 * labeled alternative in {@link typescriptparser#propertyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyWithoutInit(typescriptparser.PropertyWithoutInitContext ctx);
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
	 * Visit a parse tree produced by {@link typescriptparser#return}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn(typescriptparser.ReturnContext ctx);
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
	 * Visit a parse tree produced by the {@code ParameterRule}
	 * labeled alternative in {@link typescriptparser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterRule(typescriptparser.ParameterRuleContext ctx);
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
	 * Visit a parse tree produced by the {@code StringType}
	 * labeled alternative in {@link typescriptparser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringType(typescriptparser.StringTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumberType}
	 * labeled alternative in {@link typescriptparser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberType(typescriptparser.NumberTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BooleanType}
	 * labeled alternative in {@link typescriptparser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanType(typescriptparser.BooleanTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AnyType}
	 * labeled alternative in {@link typescriptparser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnyType(typescriptparser.AnyTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VoidType}
	 * labeled alternative in {@link typescriptparser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoidType(typescriptparser.VoidTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdType}
	 * labeled alternative in {@link typescriptparser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdType(typescriptparser.IdTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ListType}
	 * labeled alternative in {@link typescriptparser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListType(typescriptparser.ListTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ThisMemberAccess}
	 * labeled alternative in {@link typescriptparser#memberAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThisMemberAccess(typescriptparser.ThisMemberAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SimpleMemberAccess}
	 * labeled alternative in {@link typescriptparser#memberAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleMemberAccess(typescriptparser.SimpleMemberAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ListDeclaration}
	 * labeled alternative in {@link typescriptparser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListDeclaration(typescriptparser.ListDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BodyListRule}
	 * labeled alternative in {@link typescriptparser#bodylist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBodyListRule(typescriptparser.BodyListRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ObjectRule}
	 * labeled alternative in {@link typescriptparser#object}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectRule(typescriptparser.ObjectRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ObjectBodyRule}
	 * labeled alternative in {@link typescriptparser#bodyobject}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectBodyRule(typescriptparser.ObjectBodyRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code KeyValue}
	 * labeled alternative in {@link typescriptparser#keyValuePair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyValue(typescriptparser.KeyValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumberInitValue}
	 * labeled alternative in {@link typescriptparser#initvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberInitValue(typescriptparser.NumberInitValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringInitValue}
	 * labeled alternative in {@link typescriptparser#initvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringInitValue(typescriptparser.StringInitValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BooleanInitValue}
	 * labeled alternative in {@link typescriptparser#initvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanInitValue(typescriptparser.BooleanInitValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ListInitValue}
	 * labeled alternative in {@link typescriptparser#initvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListInitValue(typescriptparser.ListInitValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ObjectInitValue}
	 * labeled alternative in {@link typescriptparser#initvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectInitValue(typescriptparser.ObjectInitValueContext ctx);
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
	 * Visit a parse tree produced by the {@code TagElement}
	 * labeled alternative in {@link typescriptparser#element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagElement(typescriptparser.TagElementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code HtmlNameElement}
	 * labeled alternative in {@link typescriptparser#element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlNameElement(typescriptparser.HtmlNameElementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InterpolationElement}
	 * labeled alternative in {@link typescriptparser#element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterpolationElement(typescriptparser.InterpolationElementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OpenCloseTag}
	 * labeled alternative in {@link typescriptparser#tag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpenCloseTag(typescriptparser.OpenCloseTagContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SelfClosingTagElement}
	 * labeled alternative in {@link typescriptparser#tag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelfClosingTagElement(typescriptparser.SelfClosingTagElementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OpeningTagRule}
	 * labeled alternative in {@link typescriptparser#openingTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpeningTagRule(typescriptparser.OpeningTagRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ClosingTagRule}
	 * labeled alternative in {@link typescriptparser#closingTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClosingTagRule(typescriptparser.ClosingTagRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SelfClosingTagRule}
	 * labeled alternative in {@link typescriptparser#selfClosingTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelfClosingTagRule(typescriptparser.SelfClosingTagRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code HtmlAttribute}
	 * labeled alternative in {@link typescriptparser#attributes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlAttribute(typescriptparser.HtmlAttributeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StructuralDirectiveAttribute}
	 * labeled alternative in {@link typescriptparser#attributes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructuralDirectiveAttribute(typescriptparser.StructuralDirectiveAttributeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BindingAttribute}
	 * labeled alternative in {@link typescriptparser#attributes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBindingAttribute(typescriptparser.BindingAttributeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EventBindingAttribute}
	 * labeled alternative in {@link typescriptparser#attributes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEventBindingAttribute(typescriptparser.EventBindingAttributeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InterpolationRule}
	 * labeled alternative in {@link typescriptparser#interpolation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterpolationRule(typescriptparser.InterpolationRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CssBodyRule}
	 * labeled alternative in {@link typescriptparser#cssBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssBodyRule(typescriptparser.CssBodyRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CssObjectsRule}
	 * labeled alternative in {@link typescriptparser#cssObjects}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssObjectsRule(typescriptparser.CssObjectsRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CssElementRule}
	 * labeled alternative in {@link typescriptparser#csselement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssElementRule(typescriptparser.CssElementRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CssDeclaration}
	 * labeled alternative in {@link typescriptparser#bodyelement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssDeclaration(typescriptparser.CssDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PercentValue}
	 * labeled alternative in {@link typescriptparser#cssValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPercentValue(typescriptparser.PercentValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdValue}
	 * labeled alternative in {@link typescriptparser#cssValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdValue(typescriptparser.IdValueContext ctx);
}