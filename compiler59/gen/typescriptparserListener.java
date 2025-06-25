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
	 * Enter a parse tree produced by the {@code ComponentStmt}
	 * labeled alternative in {@link typescriptparser#statement}.
	 * @param ctx the parse tree
	 */
	void enterComponentStmt(typescriptparser.ComponentStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComponentStmt}
	 * labeled alternative in {@link typescriptparser#statement}.
	 * @param ctx the parse tree
	 */
	void exitComponentStmt(typescriptparser.ComponentStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ClassStmt}
	 * labeled alternative in {@link typescriptparser#statement}.
	 * @param ctx the parse tree
	 */
	void enterClassStmt(typescriptparser.ClassStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ClassStmt}
	 * labeled alternative in {@link typescriptparser#statement}.
	 * @param ctx the parse tree
	 */
	void exitClassStmt(typescriptparser.ClassStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InterfaceStmt}
	 * labeled alternative in {@link typescriptparser#statement}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceStmt(typescriptparser.InterfaceStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InterfaceStmt}
	 * labeled alternative in {@link typescriptparser#statement}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceStmt(typescriptparser.InterfaceStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VariableDeclStmt}
	 * labeled alternative in {@link typescriptparser#statement}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclStmt(typescriptparser.VariableDeclStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VariableDeclStmt}
	 * labeled alternative in {@link typescriptparser#statement}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclStmt(typescriptparser.VariableDeclStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignmentStmt}
	 * labeled alternative in {@link typescriptparser#statement}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStmt(typescriptparser.AssignmentStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignmentStmt}
	 * labeled alternative in {@link typescriptparser#statement}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStmt(typescriptparser.AssignmentStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionCallStmt}
	 * labeled alternative in {@link typescriptparser#statement}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallStmt(typescriptparser.FunctionCallStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionCallStmt}
	 * labeled alternative in {@link typescriptparser#statement}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallStmt(typescriptparser.FunctionCallStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MethodStmt}
	 * labeled alternative in {@link typescriptparser#statement}.
	 * @param ctx the parse tree
	 */
	void enterMethodStmt(typescriptparser.MethodStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MethodStmt}
	 * labeled alternative in {@link typescriptparser#statement}.
	 * @param ctx the parse tree
	 */
	void exitMethodStmt(typescriptparser.MethodStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ImportStmt}
	 * labeled alternative in {@link typescriptparser#statement}.
	 * @param ctx the parse tree
	 */
	void enterImportStmt(typescriptparser.ImportStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ImportStmt}
	 * labeled alternative in {@link typescriptparser#statement}.
	 * @param ctx the parse tree
	 */
	void exitImportStmt(typescriptparser.ImportStmtContext ctx);
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
	 * Enter a parse tree produced by the {@code ClassDeclRule}
	 * labeled alternative in {@link typescriptparser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclRule(typescriptparser.ClassDeclRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ClassDeclRule}
	 * labeled alternative in {@link typescriptparser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclRule(typescriptparser.ClassDeclRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ClassBodyRule}
	 * labeled alternative in {@link typescriptparser#classDeclarationBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBodyRule(typescriptparser.ClassBodyRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ClassBodyRule}
	 * labeled alternative in {@link typescriptparser#classDeclarationBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBodyRule(typescriptparser.ClassBodyRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ClassMethodMember}
	 * labeled alternative in {@link typescriptparser#classMember}.
	 * @param ctx the parse tree
	 */
	void enterClassMethodMember(typescriptparser.ClassMethodMemberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ClassMethodMember}
	 * labeled alternative in {@link typescriptparser#classMember}.
	 * @param ctx the parse tree
	 */
	void exitClassMethodMember(typescriptparser.ClassMethodMemberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ClassPropertyMember}
	 * labeled alternative in {@link typescriptparser#classMember}.
	 * @param ctx the parse tree
	 */
	void enterClassPropertyMember(typescriptparser.ClassPropertyMemberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ClassPropertyMember}
	 * labeled alternative in {@link typescriptparser#classMember}.
	 * @param ctx the parse tree
	 */
	void exitClassPropertyMember(typescriptparser.ClassPropertyMemberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NestedClassMember}
	 * labeled alternative in {@link typescriptparser#classMember}.
	 * @param ctx the parse tree
	 */
	void enterNestedClassMember(typescriptparser.NestedClassMemberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NestedClassMember}
	 * labeled alternative in {@link typescriptparser#classMember}.
	 * @param ctx the parse tree
	 */
	void exitNestedClassMember(typescriptparser.NestedClassMemberContext ctx);
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
	 * Enter a parse tree produced by the {@code MethodDeclRule}
	 * labeled alternative in {@link typescriptparser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclRule(typescriptparser.MethodDeclRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MethodDeclRule}
	 * labeled alternative in {@link typescriptparser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclRule(typescriptparser.MethodDeclRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MethodBodyRule}
	 * labeled alternative in {@link typescriptparser#methodBody}.
	 * @param ctx the parse tree
	 */
	void enterMethodBodyRule(typescriptparser.MethodBodyRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MethodBodyRule}
	 * labeled alternative in {@link typescriptparser#methodBody}.
	 * @param ctx the parse tree
	 */
	void exitMethodBodyRule(typescriptparser.MethodBodyRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MethodAssignment}
	 * labeled alternative in {@link typescriptparser#statementMethod}.
	 * @param ctx the parse tree
	 */
	void enterMethodAssignment(typescriptparser.MethodAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MethodAssignment}
	 * labeled alternative in {@link typescriptparser#statementMethod}.
	 * @param ctx the parse tree
	 */
	void exitMethodAssignment(typescriptparser.MethodAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MethodThisPropertyAssignment}
	 * labeled alternative in {@link typescriptparser#statementMethod}.
	 * @param ctx the parse tree
	 */
	void enterMethodThisPropertyAssignment(typescriptparser.MethodThisPropertyAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MethodThisPropertyAssignment}
	 * labeled alternative in {@link typescriptparser#statementMethod}.
	 * @param ctx the parse tree
	 */
	void exitMethodThisPropertyAssignment(typescriptparser.MethodThisPropertyAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MethodExpression}
	 * labeled alternative in {@link typescriptparser#statementMethod}.
	 * @param ctx the parse tree
	 */
	void enterMethodExpression(typescriptparser.MethodExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MethodExpression}
	 * labeled alternative in {@link typescriptparser#statementMethod}.
	 * @param ctx the parse tree
	 */
	void exitMethodExpression(typescriptparser.MethodExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MethodReturnOnly}
	 * labeled alternative in {@link typescriptparser#statementMethod}.
	 * @param ctx the parse tree
	 */
	void enterMethodReturnOnly(typescriptparser.MethodReturnOnlyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MethodReturnOnly}
	 * labeled alternative in {@link typescriptparser#statementMethod}.
	 * @param ctx the parse tree
	 */
	void exitMethodReturnOnly(typescriptparser.MethodReturnOnlyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReturnExpression}
	 * labeled alternative in {@link typescriptparser#returnStatment}.
	 * @param ctx the parse tree
	 */
	void enterReturnExpression(typescriptparser.ReturnExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReturnExpression}
	 * labeled alternative in {@link typescriptparser#returnStatment}.
	 * @param ctx the parse tree
	 */
	void exitReturnExpression(typescriptparser.ReturnExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReturnIdentifier}
	 * labeled alternative in {@link typescriptparser#returnStatment}.
	 * @param ctx the parse tree
	 */
	void enterReturnIdentifier(typescriptparser.ReturnIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReturnIdentifier}
	 * labeled alternative in {@link typescriptparser#returnStatment}.
	 * @param ctx the parse tree
	 */
	void exitReturnIdentifier(typescriptparser.ReturnIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReturnBoolean}
	 * labeled alternative in {@link typescriptparser#returnStatment}.
	 * @param ctx the parse tree
	 */
	void enterReturnBoolean(typescriptparser.ReturnBooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReturnBoolean}
	 * labeled alternative in {@link typescriptparser#returnStatment}.
	 * @param ctx the parse tree
	 */
	void exitReturnBoolean(typescriptparser.ReturnBooleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReturnVoid}
	 * labeled alternative in {@link typescriptparser#returnStatment}.
	 * @param ctx the parse tree
	 */
	void enterReturnVoid(typescriptparser.ReturnVoidContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReturnVoid}
	 * labeled alternative in {@link typescriptparser#returnStatment}.
	 * @param ctx the parse tree
	 */
	void exitReturnVoid(typescriptparser.ReturnVoidContext ctx);
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
	 * Enter a parse tree produced by the {@code InterfacePropertyMember}
	 * labeled alternative in {@link typescriptparser#interfaceMember}.
	 * @param ctx the parse tree
	 */
	void enterInterfacePropertyMember(typescriptparser.InterfacePropertyMemberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InterfacePropertyMember}
	 * labeled alternative in {@link typescriptparser#interfaceMember}.
	 * @param ctx the parse tree
	 */
	void exitInterfacePropertyMember(typescriptparser.InterfacePropertyMemberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InterfaceMethodMember}
	 * labeled alternative in {@link typescriptparser#interfaceMember}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceMethodMember(typescriptparser.InterfaceMethodMemberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InterfaceMethodMember}
	 * labeled alternative in {@link typescriptparser#interfaceMember}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceMethodMember(typescriptparser.InterfaceMethodMemberContext ctx);
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
	 * Enter a parse tree produced by the {@code ParameterListRule}
	 * labeled alternative in {@link typescriptparser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterListRule(typescriptparser.ParameterListRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParameterListRule}
	 * labeled alternative in {@link typescriptparser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterListRule(typescriptparser.ParameterListRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstDeclaration}
	 * labeled alternative in {@link typescriptparser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstDeclaration(typescriptparser.ConstDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstDeclaration}
	 * labeled alternative in {@link typescriptparser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstDeclaration(typescriptparser.ConstDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LetDeclaration}
	 * labeled alternative in {@link typescriptparser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterLetDeclaration(typescriptparser.LetDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LetDeclaration}
	 * labeled alternative in {@link typescriptparser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitLetDeclaration(typescriptparser.LetDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarDeclaration}
	 * labeled alternative in {@link typescriptparser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclaration(typescriptparser.VarDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarDeclaration}
	 * labeled alternative in {@link typescriptparser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclaration(typescriptparser.VarDeclarationContext ctx);
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
	 * Enter a parse tree produced by the {@code NumberLiteralExpr}
	 * labeled alternative in {@link typescriptparser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumberLiteralExpr(typescriptparser.NumberLiteralExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NumberLiteralExpr}
	 * labeled alternative in {@link typescriptparser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumberLiteralExpr(typescriptparser.NumberLiteralExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VariableDeclarationExpr}
	 * labeled alternative in {@link typescriptparser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarationExpr(typescriptparser.VariableDeclarationExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VariableDeclarationExpr}
	 * labeled alternative in {@link typescriptparser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarationExpr(typescriptparser.VariableDeclarationExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionCallExpr}
	 * labeled alternative in {@link typescriptparser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallExpr(typescriptparser.FunctionCallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionCallExpr}
	 * labeled alternative in {@link typescriptparser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallExpr(typescriptparser.FunctionCallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdentifierExpr}
	 * labeled alternative in {@link typescriptparser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierExpr(typescriptparser.IdentifierExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdentifierExpr}
	 * labeled alternative in {@link typescriptparser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierExpr(typescriptparser.IdentifierExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BooleanLiteralExpr}
	 * labeled alternative in {@link typescriptparser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteralExpr(typescriptparser.BooleanLiteralExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BooleanLiteralExpr}
	 * labeled alternative in {@link typescriptparser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteralExpr(typescriptparser.BooleanLiteralExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinaryExpr}
	 * labeled alternative in {@link typescriptparser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpr(typescriptparser.BinaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinaryExpr}
	 * labeled alternative in {@link typescriptparser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpr(typescriptparser.BinaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringLiteralExpr}
	 * labeled alternative in {@link typescriptparser#expression}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteralExpr(typescriptparser.StringLiteralExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringLiteralExpr}
	 * labeled alternative in {@link typescriptparser#expression}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteralExpr(typescriptparser.StringLiteralExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenthesizedExpr}
	 * labeled alternative in {@link typescriptparser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesizedExpr(typescriptparser.ParenthesizedExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenthesizedExpr}
	 * labeled alternative in {@link typescriptparser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesizedExpr(typescriptparser.ParenthesizedExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MemberAccessExpr}
	 * labeled alternative in {@link typescriptparser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMemberAccessExpr(typescriptparser.MemberAccessExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MemberAccessExpr}
	 * labeled alternative in {@link typescriptparser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMemberAccessExpr(typescriptparser.MemberAccessExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PlusOp}
	 * labeled alternative in {@link typescriptparser#operator}.
	 * @param ctx the parse tree
	 */
	void enterPlusOp(typescriptparser.PlusOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PlusOp}
	 * labeled alternative in {@link typescriptparser#operator}.
	 * @param ctx the parse tree
	 */
	void exitPlusOp(typescriptparser.PlusOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MinusOp}
	 * labeled alternative in {@link typescriptparser#operator}.
	 * @param ctx the parse tree
	 */
	void enterMinusOp(typescriptparser.MinusOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MinusOp}
	 * labeled alternative in {@link typescriptparser#operator}.
	 * @param ctx the parse tree
	 */
	void exitMinusOp(typescriptparser.MinusOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StarOp}
	 * labeled alternative in {@link typescriptparser#operator}.
	 * @param ctx the parse tree
	 */
	void enterStarOp(typescriptparser.StarOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StarOp}
	 * labeled alternative in {@link typescriptparser#operator}.
	 * @param ctx the parse tree
	 */
	void exitStarOp(typescriptparser.StarOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SlashOp}
	 * labeled alternative in {@link typescriptparser#operator}.
	 * @param ctx the parse tree
	 */
	void enterSlashOp(typescriptparser.SlashOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SlashOp}
	 * labeled alternative in {@link typescriptparser#operator}.
	 * @param ctx the parse tree
	 */
	void exitSlashOp(typescriptparser.SlashOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StandardFunctionCall}
	 * labeled alternative in {@link typescriptparser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterStandardFunctionCall(typescriptparser.StandardFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StandardFunctionCall}
	 * labeled alternative in {@link typescriptparser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitStandardFunctionCall(typescriptparser.StandardFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionArgument}
	 * labeled alternative in {@link typescriptparser#argument}.
	 * @param ctx the parse tree
	 */
	void enterExpressionArgument(typescriptparser.ExpressionArgumentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionArgument}
	 * labeled alternative in {@link typescriptparser#argument}.
	 * @param ctx the parse tree
	 */
	void exitExpressionArgument(typescriptparser.ExpressionArgumentContext ctx);
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