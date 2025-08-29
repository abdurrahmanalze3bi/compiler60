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
	 * Visit a parse tree produced by the {@code ComponentStmt}
	 * labeled alternative in {@link typescriptparser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponentStmt(typescriptparser.ComponentStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ClassStmt}
	 * labeled alternative in {@link typescriptparser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassStmt(typescriptparser.ClassStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InterfaceStmt}
	 * labeled alternative in {@link typescriptparser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceStmt(typescriptparser.InterfaceStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VariableDeclStmt}
	 * labeled alternative in {@link typescriptparser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclStmt(typescriptparser.VariableDeclStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignmentStmt}
	 * labeled alternative in {@link typescriptparser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStmt(typescriptparser.AssignmentStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionCallStmt}
	 * labeled alternative in {@link typescriptparser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallStmt(typescriptparser.FunctionCallStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MethodStmt}
	 * labeled alternative in {@link typescriptparser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodStmt(typescriptparser.MethodStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ImportStmt}
	 * labeled alternative in {@link typescriptparser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportStmt(typescriptparser.ImportStmtContext ctx);
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
	 * Visit a parse tree produced by the {@code ClassDeclRule}
	 * labeled alternative in {@link typescriptparser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclRule(typescriptparser.ClassDeclRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ClassBodyRule}
	 * labeled alternative in {@link typescriptparser#classDeclarationBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBodyRule(typescriptparser.ClassBodyRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ClassMethodMember}
	 * labeled alternative in {@link typescriptparser#classMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMethodMember(typescriptparser.ClassMethodMemberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ClassPropertyMember}
	 * labeled alternative in {@link typescriptparser#classMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassPropertyMember(typescriptparser.ClassPropertyMemberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NestedClassMember}
	 * labeled alternative in {@link typescriptparser#classMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNestedClassMember(typescriptparser.NestedClassMemberContext ctx);
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
	 * Visit a parse tree produced by the {@code MethodDeclRule}
	 * labeled alternative in {@link typescriptparser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclRule(typescriptparser.MethodDeclRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MethodBodyRule}
	 * labeled alternative in {@link typescriptparser#methodBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodBodyRule(typescriptparser.MethodBodyRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MethodAssignment}
	 * labeled alternative in {@link typescriptparser#statementMethod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodAssignment(typescriptparser.MethodAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MethodThisPropertyAssignment}
	 * labeled alternative in {@link typescriptparser#statementMethod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodThisPropertyAssignment(typescriptparser.MethodThisPropertyAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MethodExpression}
	 * labeled alternative in {@link typescriptparser#statementMethod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodExpression(typescriptparser.MethodExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MethodReturnOnly}
	 * labeled alternative in {@link typescriptparser#statementMethod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodReturnOnly(typescriptparser.MethodReturnOnlyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReturnExpression}
	 * labeled alternative in {@link typescriptparser#returnStatment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnExpression(typescriptparser.ReturnExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReturnIdentifier}
	 * labeled alternative in {@link typescriptparser#returnStatment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnIdentifier(typescriptparser.ReturnIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReturnBoolean}
	 * labeled alternative in {@link typescriptparser#returnStatment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnBoolean(typescriptparser.ReturnBooleanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReturnVoid}
	 * labeled alternative in {@link typescriptparser#returnStatment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnVoid(typescriptparser.ReturnVoidContext ctx);
	/**
	 * Visit a parse tree produced by {@link typescriptparser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceDeclaration(typescriptparser.InterfaceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InterfacePropertyMember}
	 * labeled alternative in {@link typescriptparser#interfaceMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfacePropertyMember(typescriptparser.InterfacePropertyMemberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InterfaceMethodMember}
	 * labeled alternative in {@link typescriptparser#interfaceMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceMethodMember(typescriptparser.InterfaceMethodMemberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParameterRule}
	 * labeled alternative in {@link typescriptparser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterRule(typescriptparser.ParameterRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParameterListRule}
	 * labeled alternative in {@link typescriptparser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterListRule(typescriptparser.ParameterListRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConstDeclaration}
	 * labeled alternative in {@link typescriptparser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDeclaration(typescriptparser.ConstDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LetDeclaration}
	 * labeled alternative in {@link typescriptparser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetDeclaration(typescriptparser.LetDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VarDeclaration}
	 * labeled alternative in {@link typescriptparser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclaration(typescriptparser.VarDeclarationContext ctx);
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
	 * Visit a parse tree produced by the {@code KeyValuePairRule}
	 * labeled alternative in {@link typescriptparser#keyValuePair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyValuePairRule(typescriptparser.KeyValuePairRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ObjectBodyRule}
	 * labeled alternative in {@link typescriptparser#bodyobject}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectBodyRule(typescriptparser.ObjectBodyRuleContext ctx);
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
	 * Visit a parse tree produced by the {@code NumberLiteralExpr}
	 * labeled alternative in {@link typescriptparser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberLiteralExpr(typescriptparser.NumberLiteralExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VariableDeclarationExpr}
	 * labeled alternative in {@link typescriptparser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarationExpr(typescriptparser.VariableDeclarationExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionCallExpr}
	 * labeled alternative in {@link typescriptparser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallExpr(typescriptparser.FunctionCallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdentifierExpr}
	 * labeled alternative in {@link typescriptparser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierExpr(typescriptparser.IdentifierExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BooleanLiteralExpr}
	 * labeled alternative in {@link typescriptparser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanLiteralExpr(typescriptparser.BooleanLiteralExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinaryExpr}
	 * labeled alternative in {@link typescriptparser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryExpr(typescriptparser.BinaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringLiteralExpr}
	 * labeled alternative in {@link typescriptparser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteralExpr(typescriptparser.StringLiteralExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenthesizedExpr}
	 * labeled alternative in {@link typescriptparser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizedExpr(typescriptparser.ParenthesizedExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MemberAccessExpr}
	 * labeled alternative in {@link typescriptparser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberAccessExpr(typescriptparser.MemberAccessExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PlusOp}
	 * labeled alternative in {@link typescriptparser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusOp(typescriptparser.PlusOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MinusOp}
	 * labeled alternative in {@link typescriptparser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinusOp(typescriptparser.MinusOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StarOp}
	 * labeled alternative in {@link typescriptparser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStarOp(typescriptparser.StarOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SlashOp}
	 * labeled alternative in {@link typescriptparser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlashOp(typescriptparser.SlashOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StandardFunctionCall}
	 * labeled alternative in {@link typescriptparser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStandardFunctionCall(typescriptparser.StandardFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionArgument}
	 * labeled alternative in {@link typescriptparser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionArgument(typescriptparser.ExpressionArgumentContext ctx);
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
	/**
	 * Visit a parse tree produced by the {@code StringValue}
	 * labeled alternative in {@link typescriptparser#cssValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringValue(typescriptparser.StringValueContext ctx);
}