// Generated from C:/Users/ALZOUBI/ideaProjecte/compiler2/typescriptparser.g4 by ANTLR 4.13.2
package gen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class typescriptparser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IF=1, ELSE=2, ELSE_IF=3, FOR=4, FOR_EACH=5, BREAK=6, CONTINUE=7, RETURN=8, 
		WHILE=9, DO=10, IN=11, DEFAULT_CASE=12, NEW=13, FUNCTION=14, CLASS=15, 
		INTERFACE=16, IMPORT=17, EXPORT=18, CONST=19, LET=20, VAR=21, FROM=22, 
		COMPONENT=23, SELECTOR=24, STANDALONE=25, IMPORTS=26, TEMPLATE=27, STYLES=28, 
		STRING_TYPE=29, NUMBER_TYPE=30, BOOLEAN_TYPE=31, ANY_TYPE=32, VOID_TYPE=33, 
		COMMA=34, COLON=35, DOT=36, SEMICOLON=37, EQUALS=38, THIS=39, ASSIGN=40, 
		PLUS=41, MINUS=42, STAR=43, SLASH=44, LESS=45, GREATER=46, EQUAL=47, NOT_EQUAL=48, 
		LPAREN=49, RPAREN=50, LBRACE=51, RBRACE=52, TRUE=53, FALSE=54, ID=55, 
		STRING_LIT=56, NUMBER_LIT=57, WS=58, LINE_COMMENT=59, BLOCK_COMMENT=60, 
		DECORATOR=61, AS=62, TYPE=63, LBRACKET=64, RBRACKET=65, OR=66, BACKTICK=67, 
		LINE_COMMENT_HTML=68, BLOCK_COMMENT_HTML=69, TAG_OPEN_START_HTML=70, TAG_CLOSE_START_HTML=71, 
		TAG_CLOSE_END_HTML=72, TAG_END_HTML=73, ATTRIBUTE_EQUALS_HTML=74, STRING_HTML=75, 
		STRUCTURAL_DIR_HTML=76, BINDING_HTML=77, EVENT_BINDING_HTML=78, NEGATION_HTML=79, 
		COLON_HTML=80, INTERPOLATION_START_HTML=81, INTERPOLATION_END_HTML=82, 
		DOT_HTML=83, NAME_HTML=84, WS_HTML=85, END_TEMPLATE=86, BACKTICK_HTML=87, 
		BACKTICK_CSS=88, COLON_CSS=89, COMMA_CSS=90, OPEN_LIST=91, CLOSE_LIST=92, 
		DOT_CSS=93, SEMICOLON_CSS=94, LBRACE_CSS=95, RBRACE_CSS=96, PERCENT=97, 
		WS_CSS=98, LINE_COMMENT_CSS=99, BLOCK_COMMENT_CSS=100, PX=101, EM=102, 
		REM=103, ID_CSS=104;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_assignmentStatement = 2, RULE_componentDeclaration = 3, 
		RULE_componentDeclarationBody = 4, RULE_selector = 5, RULE_standalone = 6, 
		RULE_template = 7, RULE_styles = 8, RULE_importDeclaration = 9, RULE_componentBodyElement = 10, 
		RULE_isboolean = 11, RULE_classDeclaration = 12, RULE_classDeclarationBody = 13, 
		RULE_classMember = 14, RULE_propertyDeclaration = 15, RULE_methodDeclaration = 16, 
		RULE_methodBody = 17, RULE_statementMethod = 18, RULE_returnStatment = 19, 
		RULE_interfaceDeclaration = 20, RULE_interfaceMember = 21, RULE_parameter = 22, 
		RULE_parameterList = 23, RULE_variableDeclaration = 24, RULE_type = 25, 
		RULE_memberAccess = 26, RULE_list = 27, RULE_bodylist = 28, RULE_object = 29, 
		RULE_bodyobject = 30, RULE_keyValuePair = 31, RULE_initvalue = 32, RULE_expression = 33, 
		RULE_operator = 34, RULE_functionCall = 35, RULE_argument = 36, RULE_element = 37, 
		RULE_tag = 38, RULE_openingTag = 39, RULE_closingTag = 40, RULE_selfClosingTag = 41, 
		RULE_attributes = 42, RULE_interpolation = 43, RULE_cssBody = 44, RULE_cssObjects = 45, 
		RULE_csselement = 46, RULE_bodyelement = 47, RULE_cssValue = 48;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "assignmentStatement", "componentDeclaration", 
			"componentDeclarationBody", "selector", "standalone", "template", "styles", 
			"importDeclaration", "componentBodyElement", "isboolean", "classDeclaration", 
			"classDeclarationBody", "classMember", "propertyDeclaration", "methodDeclaration", 
			"methodBody", "statementMethod", "returnStatment", "interfaceDeclaration", 
			"interfaceMember", "parameter", "parameterList", "variableDeclaration", 
			"type", "memberAccess", "list", "bodylist", "object", "bodyobject", "keyValuePair", 
			"initvalue", "expression", "operator", "functionCall", "argument", "element", 
			"tag", "openingTag", "closingTag", "selfClosingTag", "attributes", "interpolation", 
			"cssBody", "cssObjects", "csselement", "bodyelement", "cssValue"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'if'", "'else'", null, "'for'", "'forEach'", "'break'", "'continue'", 
			"'return'", "'while'", "'do'", "'in'", "'default'", "'new'", "'function'", 
			"'class'", "'interface'", "'import'", "'export'", "'const'", "'let'", 
			"'var'", "'from'", "'Component'", "'selector'", "'standalone'", "'imports'", 
			"'template'", "'styles'", "'string'", "'number'", "'boolean'", "'any'", 
			"'void'", null, null, null, null, null, "'this'", null, "'+'", "'-'", 
			"'*'", "'/'", "'<'", null, null, "'!='", "'('", "')'", null, null, "'true'", 
			"'false'", null, null, null, null, null, null, "'@'", "'as'", "'type'", 
			null, null, "'|'", null, null, null, null, "'</'", null, "'/>'", null, 
			null, null, null, null, "'!'", null, "'{{'", "'}}'", null, null, null, 
			"'`,'", null, null, null, null, null, null, null, null, null, null, "'%'", 
			null, null, null, "'px'", "'em'", "'rem'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "IF", "ELSE", "ELSE_IF", "FOR", "FOR_EACH", "BREAK", "CONTINUE", 
			"RETURN", "WHILE", "DO", "IN", "DEFAULT_CASE", "NEW", "FUNCTION", "CLASS", 
			"INTERFACE", "IMPORT", "EXPORT", "CONST", "LET", "VAR", "FROM", "COMPONENT", 
			"SELECTOR", "STANDALONE", "IMPORTS", "TEMPLATE", "STYLES", "STRING_TYPE", 
			"NUMBER_TYPE", "BOOLEAN_TYPE", "ANY_TYPE", "VOID_TYPE", "COMMA", "COLON", 
			"DOT", "SEMICOLON", "EQUALS", "THIS", "ASSIGN", "PLUS", "MINUS", "STAR", 
			"SLASH", "LESS", "GREATER", "EQUAL", "NOT_EQUAL", "LPAREN", "RPAREN", 
			"LBRACE", "RBRACE", "TRUE", "FALSE", "ID", "STRING_LIT", "NUMBER_LIT", 
			"WS", "LINE_COMMENT", "BLOCK_COMMENT", "DECORATOR", "AS", "TYPE", "LBRACKET", 
			"RBRACKET", "OR", "BACKTICK", "LINE_COMMENT_HTML", "BLOCK_COMMENT_HTML", 
			"TAG_OPEN_START_HTML", "TAG_CLOSE_START_HTML", "TAG_CLOSE_END_HTML", 
			"TAG_END_HTML", "ATTRIBUTE_EQUALS_HTML", "STRING_HTML", "STRUCTURAL_DIR_HTML", 
			"BINDING_HTML", "EVENT_BINDING_HTML", "NEGATION_HTML", "COLON_HTML", 
			"INTERPOLATION_START_HTML", "INTERPOLATION_END_HTML", "DOT_HTML", "NAME_HTML", 
			"WS_HTML", "END_TEMPLATE", "BACKTICK_HTML", "BACKTICK_CSS", "COLON_CSS", 
			"COMMA_CSS", "OPEN_LIST", "CLOSE_LIST", "DOT_CSS", "SEMICOLON_CSS", "LBRACE_CSS", 
			"RBRACE_CSS", "PERCENT", "WS_CSS", "LINE_COMMENT_CSS", "BLOCK_COMMENT_CSS", 
			"PX", "EM", "REM", "ID_CSS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "typescriptparser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public typescriptparser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(98);
				statement();
				}
				}
				setState(101); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2341871806303928320L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ComponentStmtContext extends StatementContext {
		public ComponentDeclarationContext componentDeclaration() {
			return getRuleContext(ComponentDeclarationContext.class,0);
		}
		public ComponentStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterComponentStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitComponentStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitComponentStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallStmtContext extends StatementContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public FunctionCallStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterFunctionCallStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitFunctionCallStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitFunctionCallStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MethodStmtContext extends StatementContext {
		public MethodDeclarationContext methodDeclaration() {
			return getRuleContext(MethodDeclarationContext.class,0);
		}
		public MethodStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterMethodStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitMethodStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitMethodStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InterfaceStmtContext extends StatementContext {
		public InterfaceDeclarationContext interfaceDeclaration() {
			return getRuleContext(InterfaceDeclarationContext.class,0);
		}
		public InterfaceStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterInterfaceStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitInterfaceStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitInterfaceStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ImportStmtContext extends StatementContext {
		public ImportDeclarationContext importDeclaration() {
			return getRuleContext(ImportDeclarationContext.class,0);
		}
		public ImportStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterImportStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitImportStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitImportStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclStmtContext extends StatementContext {
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public VariableDeclStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterVariableDeclStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitVariableDeclStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitVariableDeclStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentStmtContext extends StatementContext {
		public AssignmentStatementContext assignmentStatement() {
			return getRuleContext(AssignmentStatementContext.class,0);
		}
		public AssignmentStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterAssignmentStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitAssignmentStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitAssignmentStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ClassStmtContext extends StatementContext {
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public ClassStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterClassStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitClassStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitClassStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(111);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new ComponentStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(103);
				componentDeclaration();
				}
				break;
			case 2:
				_localctx = new ClassStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(104);
				classDeclaration();
				}
				break;
			case 3:
				_localctx = new InterfaceStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(105);
				interfaceDeclaration();
				}
				break;
			case 4:
				_localctx = new VariableDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(106);
				variableDeclaration();
				}
				break;
			case 5:
				_localctx = new AssignmentStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(107);
				assignmentStatement();
				}
				break;
			case 6:
				_localctx = new FunctionCallStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(108);
				functionCall();
				}
				break;
			case 7:
				_localctx = new MethodStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(109);
				methodDeclaration();
				}
				break;
			case 8:
				_localctx = new ImportStmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(110);
				importDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentStatementContext extends ParserRuleContext {
		public AssignmentStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentStatement; }
	 
		public AssignmentStatementContext() { }
		public void copyFrom(AssignmentStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentRuleContext extends AssignmentStatementContext {
		public TerminalNode ID() { return getToken(typescriptparser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(typescriptparser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(typescriptparser.SEMICOLON, 0); }
		public AssignmentRuleContext(AssignmentStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterAssignmentRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitAssignmentRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitAssignmentRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentStatementContext assignmentStatement() throws RecognitionException {
		AssignmentStatementContext _localctx = new AssignmentStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_assignmentStatement);
		int _la;
		try {
			_localctx = new AssignmentRuleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(ID);
			setState(114);
			match(ASSIGN);
			setState(115);
			expression(0);
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(116);
				match(SEMICOLON);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComponentDeclarationContext extends ParserRuleContext {
		public ComponentDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_componentDeclaration; }
	 
		public ComponentDeclarationContext() { }
		public void copyFrom(ComponentDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ComponentDeclarationRuleContext extends ComponentDeclarationContext {
		public TerminalNode DECORATOR() { return getToken(typescriptparser.DECORATOR, 0); }
		public TerminalNode COMPONENT() { return getToken(typescriptparser.COMPONENT, 0); }
		public TerminalNode LPAREN() { return getToken(typescriptparser.LPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(typescriptparser.LBRACE, 0); }
		public ComponentDeclarationBodyContext componentDeclarationBody() {
			return getRuleContext(ComponentDeclarationBodyContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(typescriptparser.RBRACE, 0); }
		public TerminalNode RPAREN() { return getToken(typescriptparser.RPAREN, 0); }
		public ComponentDeclarationRuleContext(ComponentDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterComponentDeclarationRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitComponentDeclarationRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitComponentDeclarationRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComponentDeclarationContext componentDeclaration() throws RecognitionException {
		ComponentDeclarationContext _localctx = new ComponentDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_componentDeclaration);
		try {
			_localctx = new ComponentDeclarationRuleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(DECORATOR);
			setState(120);
			match(COMPONENT);
			setState(121);
			match(LPAREN);
			setState(122);
			match(LBRACE);
			setState(123);
			componentDeclarationBody();
			setState(124);
			match(RBRACE);
			setState(125);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComponentDeclarationBodyContext extends ParserRuleContext {
		public ComponentDeclarationBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_componentDeclarationBody; }
	 
		public ComponentDeclarationBodyContext() { }
		public void copyFrom(ComponentDeclarationBodyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ComponentBodyContext extends ComponentDeclarationBodyContext {
		public List<ComponentBodyElementContext> componentBodyElement() {
			return getRuleContexts(ComponentBodyElementContext.class);
		}
		public ComponentBodyElementContext componentBodyElement(int i) {
			return getRuleContext(ComponentBodyElementContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(typescriptparser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(typescriptparser.COMMA, i);
		}
		public ComponentBodyContext(ComponentDeclarationBodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterComponentBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitComponentBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitComponentBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComponentDeclarationBodyContext componentDeclarationBody() throws RecognitionException {
		ComponentDeclarationBodyContext _localctx = new ComponentDeclarationBodyContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_componentDeclarationBody);
		int _la;
		try {
			_localctx = new ComponentBodyContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 520224768L) != 0)) {
				{
				setState(127);
				componentBodyElement();
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(128);
					match(COMMA);
					setState(129);
					componentBodyElement();
					}
					}
					setState(134);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SelectorContext extends ParserRuleContext {
		public SelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selector; }
	 
		public SelectorContext() { }
		public void copyFrom(SelectorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SelectorDeclarationContext extends SelectorContext {
		public TerminalNode SELECTOR() { return getToken(typescriptparser.SELECTOR, 0); }
		public TerminalNode COLON() { return getToken(typescriptparser.COLON, 0); }
		public TerminalNode STRING_LIT() { return getToken(typescriptparser.STRING_LIT, 0); }
		public SelectorDeclarationContext(SelectorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterSelectorDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitSelectorDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitSelectorDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectorContext selector() throws RecognitionException {
		SelectorContext _localctx = new SelectorContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_selector);
		try {
			_localctx = new SelectorDeclarationContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(SELECTOR);
			setState(138);
			match(COLON);
			setState(139);
			match(STRING_LIT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StandaloneContext extends ParserRuleContext {
		public StandaloneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_standalone; }
	 
		public StandaloneContext() { }
		public void copyFrom(StandaloneContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StandalonePropertyContext extends StandaloneContext {
		public TerminalNode STANDALONE() { return getToken(typescriptparser.STANDALONE, 0); }
		public TerminalNode COLON() { return getToken(typescriptparser.COLON, 0); }
		public IsbooleanContext isboolean() {
			return getRuleContext(IsbooleanContext.class,0);
		}
		public StandalonePropertyContext(StandaloneContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterStandaloneProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitStandaloneProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitStandaloneProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StandaloneContext standalone() throws RecognitionException {
		StandaloneContext _localctx = new StandaloneContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_standalone);
		try {
			_localctx = new StandalonePropertyContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(STANDALONE);
			setState(142);
			match(COLON);
			setState(143);
			isboolean();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TemplateContext extends ParserRuleContext {
		public TemplateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_template; }
	 
		public TemplateContext() { }
		public void copyFrom(TemplateContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TemplateDefinitionContext extends TemplateContext {
		public TerminalNode TEMPLATE() { return getToken(typescriptparser.TEMPLATE, 0); }
		public TerminalNode COLON_HTML() { return getToken(typescriptparser.COLON_HTML, 0); }
		public TerminalNode BACKTICK_HTML() { return getToken(typescriptparser.BACKTICK_HTML, 0); }
		public TerminalNode END_TEMPLATE() { return getToken(typescriptparser.END_TEMPLATE, 0); }
		public List<ElementContext> element() {
			return getRuleContexts(ElementContext.class);
		}
		public ElementContext element(int i) {
			return getRuleContext(ElementContext.class,i);
		}
		public TemplateDefinitionContext(TemplateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterTemplateDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitTemplateDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitTemplateDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemplateContext template() throws RecognitionException {
		TemplateContext _localctx = new TemplateContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_template);
		int _la;
		try {
			_localctx = new TemplateDefinitionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(TEMPLATE);
			setState(146);
			match(COLON_HTML);
			setState(147);
			match(BACKTICK_HTML);
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & 18433L) != 0)) {
				{
				{
				setState(148);
				element();
				}
				}
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(154);
			match(END_TEMPLATE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StylesContext extends ParserRuleContext {
		public StylesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_styles; }
	 
		public StylesContext() { }
		public void copyFrom(StylesContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StylesBlockContext extends StylesContext {
		public TerminalNode STYLES() { return getToken(typescriptparser.STYLES, 0); }
		public TerminalNode COLON_CSS() { return getToken(typescriptparser.COLON_CSS, 0); }
		public TerminalNode OPEN_LIST() { return getToken(typescriptparser.OPEN_LIST, 0); }
		public CssBodyContext cssBody() {
			return getRuleContext(CssBodyContext.class,0);
		}
		public TerminalNode CLOSE_LIST() { return getToken(typescriptparser.CLOSE_LIST, 0); }
		public TerminalNode COMMA() { return getToken(typescriptparser.COMMA, 0); }
		public StylesBlockContext(StylesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterStylesBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitStylesBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitStylesBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StylesContext styles() throws RecognitionException {
		StylesContext _localctx = new StylesContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_styles);
		try {
			_localctx = new StylesBlockContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(STYLES);
			setState(157);
			match(COLON_CSS);
			setState(158);
			match(OPEN_LIST);
			setState(159);
			cssBody();
			setState(160);
			match(CLOSE_LIST);
			setState(162);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(161);
				match(COMMA);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImportDeclarationContext extends ParserRuleContext {
		public ImportDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importDeclaration; }
	 
		public ImportDeclarationContext() { }
		public void copyFrom(ImportDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ComponentImportDeclContext extends ImportDeclarationContext {
		public TerminalNode IMPORT() { return getToken(typescriptparser.IMPORT, 0); }
		public TerminalNode LBRACE() { return getToken(typescriptparser.LBRACE, 0); }
		public TerminalNode COMPONENT() { return getToken(typescriptparser.COMPONENT, 0); }
		public TerminalNode RBRACE() { return getToken(typescriptparser.RBRACE, 0); }
		public TerminalNode FROM() { return getToken(typescriptparser.FROM, 0); }
		public TerminalNode STRING_LIT() { return getToken(typescriptparser.STRING_LIT, 0); }
		public TerminalNode SEMICOLON() { return getToken(typescriptparser.SEMICOLON, 0); }
		public ComponentImportDeclContext(ImportDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterComponentImportDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitComponentImportDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitComponentImportDecl(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ImportArrayDeclContext extends ImportDeclarationContext {
		public TerminalNode IMPORTS() { return getToken(typescriptparser.IMPORTS, 0); }
		public TerminalNode COLON() { return getToken(typescriptparser.COLON, 0); }
		public TerminalNode LBRACKET() { return getToken(typescriptparser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(typescriptparser.RBRACKET, 0); }
		public TerminalNode ID() { return getToken(typescriptparser.ID, 0); }
		public ImportArrayDeclContext(ImportDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterImportArrayDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitImportArrayDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitImportArrayDecl(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StandardImportDeclContext extends ImportDeclarationContext {
		public TerminalNode IMPORT() { return getToken(typescriptparser.IMPORT, 0); }
		public TerminalNode LBRACE() { return getToken(typescriptparser.LBRACE, 0); }
		public TerminalNode ID() { return getToken(typescriptparser.ID, 0); }
		public TerminalNode RBRACE() { return getToken(typescriptparser.RBRACE, 0); }
		public TerminalNode FROM() { return getToken(typescriptparser.FROM, 0); }
		public TerminalNode STRING_LIT() { return getToken(typescriptparser.STRING_LIT, 0); }
		public TerminalNode SEMICOLON() { return getToken(typescriptparser.SEMICOLON, 0); }
		public StandardImportDeclContext(ImportDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterStandardImportDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitStandardImportDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitStandardImportDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportDeclarationContext importDeclaration() throws RecognitionException {
		ImportDeclarationContext _localctx = new ImportDeclarationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_importDeclaration);
		int _la;
		try {
			setState(185);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new StandardImportDeclContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(164);
				match(IMPORT);
				setState(165);
				match(LBRACE);
				setState(166);
				match(ID);
				setState(167);
				match(RBRACE);
				setState(168);
				match(FROM);
				setState(169);
				match(STRING_LIT);
				setState(170);
				match(SEMICOLON);
				}
				break;
			case 2:
				_localctx = new ComponentImportDeclContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(171);
				match(IMPORT);
				setState(172);
				match(LBRACE);
				setState(173);
				match(COMPONENT);
				setState(174);
				match(RBRACE);
				setState(175);
				match(FROM);
				setState(176);
				match(STRING_LIT);
				setState(177);
				match(SEMICOLON);
				}
				break;
			case 3:
				_localctx = new ImportArrayDeclContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(178);
				match(IMPORTS);
				setState(179);
				match(COLON);
				setState(180);
				match(LBRACKET);
				setState(182);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(181);
					match(ID);
					}
				}

				setState(184);
				match(RBRACKET);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComponentBodyElementContext extends ParserRuleContext {
		public ComponentBodyElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_componentBodyElement; }
	 
		public ComponentBodyElementContext() { }
		public void copyFrom(ComponentBodyElementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ComponentImportElementContext extends ComponentBodyElementContext {
		public ImportDeclarationContext importDeclaration() {
			return getRuleContext(ImportDeclarationContext.class,0);
		}
		public ComponentImportElementContext(ComponentBodyElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterComponentImportElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitComponentImportElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitComponentImportElement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ComponentSelectorContext extends ComponentBodyElementContext {
		public SelectorContext selector() {
			return getRuleContext(SelectorContext.class,0);
		}
		public ComponentSelectorContext(ComponentBodyElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterComponentSelector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitComponentSelector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitComponentSelector(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ComponentStandaloneContext extends ComponentBodyElementContext {
		public StandaloneContext standalone() {
			return getRuleContext(StandaloneContext.class,0);
		}
		public ComponentStandaloneContext(ComponentBodyElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterComponentStandalone(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitComponentStandalone(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitComponentStandalone(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ComponentTemplateContext extends ComponentBodyElementContext {
		public TemplateContext template() {
			return getRuleContext(TemplateContext.class,0);
		}
		public ComponentTemplateContext(ComponentBodyElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterComponentTemplate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitComponentTemplate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitComponentTemplate(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ComponentStylesContext extends ComponentBodyElementContext {
		public StylesContext styles() {
			return getRuleContext(StylesContext.class,0);
		}
		public ComponentStylesContext(ComponentBodyElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterComponentStyles(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitComponentStyles(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitComponentStyles(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComponentBodyElementContext componentBodyElement() throws RecognitionException {
		ComponentBodyElementContext _localctx = new ComponentBodyElementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_componentBodyElement);
		try {
			setState(192);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SELECTOR:
				_localctx = new ComponentSelectorContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(187);
				selector();
				}
				break;
			case STANDALONE:
				_localctx = new ComponentStandaloneContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(188);
				standalone();
				}
				break;
			case IMPORT:
			case IMPORTS:
				_localctx = new ComponentImportElementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(189);
				importDeclaration();
				}
				break;
			case TEMPLATE:
				_localctx = new ComponentTemplateContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(190);
				template();
				}
				break;
			case STYLES:
				_localctx = new ComponentStylesContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(191);
				styles();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IsbooleanContext extends ParserRuleContext {
		public IsbooleanContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_isboolean; }
	 
		public IsbooleanContext() { }
		public void copyFrom(IsbooleanContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TrueBooleanContext extends IsbooleanContext {
		public TerminalNode TRUE() { return getToken(typescriptparser.TRUE, 0); }
		public TrueBooleanContext(IsbooleanContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterTrueBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitTrueBoolean(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitTrueBoolean(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FalseBooleanContext extends IsbooleanContext {
		public TerminalNode FALSE() { return getToken(typescriptparser.FALSE, 0); }
		public FalseBooleanContext(IsbooleanContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterFalseBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitFalseBoolean(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitFalseBoolean(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IsbooleanContext isboolean() throws RecognitionException {
		IsbooleanContext _localctx = new IsbooleanContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_isboolean);
		try {
			setState(196);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
				_localctx = new TrueBooleanContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(194);
				match(TRUE);
				}
				break;
			case FALSE:
				_localctx = new FalseBooleanContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(195);
				match(FALSE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassDeclarationContext extends ParserRuleContext {
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
	 
		public ClassDeclarationContext() { }
		public void copyFrom(ClassDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ClassDeclRuleContext extends ClassDeclarationContext {
		public TerminalNode CLASS() { return getToken(typescriptparser.CLASS, 0); }
		public TerminalNode ID() { return getToken(typescriptparser.ID, 0); }
		public ClassDeclarationBodyContext classDeclarationBody() {
			return getRuleContext(ClassDeclarationBodyContext.class,0);
		}
		public TerminalNode EXPORT() { return getToken(typescriptparser.EXPORT, 0); }
		public ClassDeclRuleContext(ClassDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterClassDeclRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitClassDeclRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitClassDeclRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_classDeclaration);
		int _la;
		try {
			_localctx = new ClassDeclRuleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXPORT) {
				{
				setState(198);
				match(EXPORT);
				}
			}

			setState(201);
			match(CLASS);
			setState(202);
			match(ID);
			setState(203);
			classDeclarationBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassDeclarationBodyContext extends ParserRuleContext {
		public ClassDeclarationBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclarationBody; }
	 
		public ClassDeclarationBodyContext() { }
		public void copyFrom(ClassDeclarationBodyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ClassBodyRuleContext extends ClassDeclarationBodyContext {
		public TerminalNode LBRACE() { return getToken(typescriptparser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(typescriptparser.RBRACE, 0); }
		public List<ClassMemberContext> classMember() {
			return getRuleContexts(ClassMemberContext.class);
		}
		public ClassMemberContext classMember(int i) {
			return getRuleContext(ClassMemberContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(typescriptparser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(typescriptparser.SEMICOLON, i);
		}
		public ClassBodyRuleContext(ClassDeclarationBodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterClassBodyRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitClassBodyRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitClassBodyRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclarationBodyContext classDeclarationBody() throws RecognitionException {
		ClassDeclarationBodyContext _localctx = new ClassDeclarationBodyContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_classDeclarationBody);
		int _la;
		try {
			_localctx = new ClassBodyRuleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(LBRACE);
			setState(212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 36028797019258880L) != 0)) {
				{
				{
				setState(206);
				classMember();
				setState(208);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(207);
					match(SEMICOLON);
					}
				}

				}
				}
				setState(214);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(215);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassMemberContext extends ParserRuleContext {
		public ClassMemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classMember; }
	 
		public ClassMemberContext() { }
		public void copyFrom(ClassMemberContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ClassMethodMemberContext extends ClassMemberContext {
		public MethodDeclarationContext methodDeclaration() {
			return getRuleContext(MethodDeclarationContext.class,0);
		}
		public ClassMethodMemberContext(ClassMemberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterClassMethodMember(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitClassMethodMember(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitClassMethodMember(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ClassPropertyMemberContext extends ClassMemberContext {
		public PropertyDeclarationContext propertyDeclaration() {
			return getRuleContext(PropertyDeclarationContext.class,0);
		}
		public ClassPropertyMemberContext(ClassMemberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterClassPropertyMember(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitClassPropertyMember(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitClassPropertyMember(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NestedClassMemberContext extends ClassMemberContext {
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public NestedClassMemberContext(ClassMemberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterNestedClassMember(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitNestedClassMember(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitNestedClassMember(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassMemberContext classMember() throws RecognitionException {
		ClassMemberContext _localctx = new ClassMemberContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_classMember);
		try {
			setState(220);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new ClassMethodMemberContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(217);
				methodDeclaration();
				}
				break;
			case 2:
				_localctx = new ClassPropertyMemberContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(218);
				propertyDeclaration();
				}
				break;
			case 3:
				_localctx = new NestedClassMemberContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(219);
				classDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PropertyDeclarationContext extends ParserRuleContext {
		public PropertyDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyDeclaration; }
	 
		public PropertyDeclarationContext() { }
		public void copyFrom(PropertyDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PropertyWithInitContext extends PropertyDeclarationContext {
		public TerminalNode ID() { return getToken(typescriptparser.ID, 0); }
		public TerminalNode COLON() { return getToken(typescriptparser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(typescriptparser.ASSIGN, 0); }
		public InitvalueContext initvalue() {
			return getRuleContext(InitvalueContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(typescriptparser.SEMICOLON, 0); }
		public PropertyWithInitContext(PropertyDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterPropertyWithInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitPropertyWithInit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitPropertyWithInit(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PropertyWithoutInitContext extends PropertyDeclarationContext {
		public List<TerminalNode> ID() { return getTokens(typescriptparser.ID); }
		public TerminalNode ID(int i) {
			return getToken(typescriptparser.ID, i);
		}
		public TerminalNode COLON() { return getToken(typescriptparser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode OR() { return getToken(typescriptparser.OR, 0); }
		public TerminalNode ASSIGN() { return getToken(typescriptparser.ASSIGN, 0); }
		public TerminalNode SEMICOLON() { return getToken(typescriptparser.SEMICOLON, 0); }
		public PropertyWithoutInitContext(PropertyDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterPropertyWithoutInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitPropertyWithoutInit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitPropertyWithoutInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropertyDeclarationContext propertyDeclaration() throws RecognitionException {
		PropertyDeclarationContext _localctx = new PropertyDeclarationContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_propertyDeclaration);
		int _la;
		try {
			setState(242);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				_localctx = new PropertyWithInitContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(222);
				match(ID);
				setState(223);
				match(COLON);
				setState(224);
				type();
				setState(225);
				match(ASSIGN);
				setState(226);
				initvalue();
				setState(228);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(227);
					match(SEMICOLON);
					}
					break;
				}
				}
				break;
			case 2:
				_localctx = new PropertyWithoutInitContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(230);
				match(ID);
				setState(231);
				match(COLON);
				setState(232);
				type();
				setState(237);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OR) {
					{
					setState(233);
					match(OR);
					setState(234);
					match(ID);
					setState(235);
					match(ASSIGN);
					setState(236);
					match(ID);
					}
				}

				setState(240);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(239);
					match(SEMICOLON);
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MethodDeclarationContext extends ParserRuleContext {
		public MethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaration; }
	 
		public MethodDeclarationContext() { }
		public void copyFrom(MethodDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MethodDeclRuleContext extends MethodDeclarationContext {
		public TerminalNode ID() { return getToken(typescriptparser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(typescriptparser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(typescriptparser.RPAREN, 0); }
		public TerminalNode COLON() { return getToken(typescriptparser.COLON, 0); }
		public TerminalNode LBRACE() { return getToken(typescriptparser.LBRACE, 0); }
		public MethodBodyContext methodBody() {
			return getRuleContext(MethodBodyContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(typescriptparser.RBRACE, 0); }
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public MethodDeclRuleContext(MethodDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterMethodDeclRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitMethodDeclRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitMethodDeclRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_methodDeclaration);
		int _la;
		try {
			_localctx = new MethodDeclRuleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			match(ID);
			setState(245);
			match(LPAREN);
			setState(247);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(246);
				parameterList();
				}
			}

			setState(249);
			match(RPAREN);
			setState(250);
			match(COLON);
			setState(252);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 36028813661962240L) != 0)) {
				{
				setState(251);
				type();
				}
			}

			setState(254);
			match(LBRACE);
			setState(255);
			methodBody();
			setState(256);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MethodBodyContext extends ParserRuleContext {
		public MethodBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodBody; }
	 
		public MethodBodyContext() { }
		public void copyFrom(MethodBodyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MethodBodyRuleContext extends MethodBodyContext {
		public List<StatementMethodContext> statementMethod() {
			return getRuleContexts(StatementMethodContext.class);
		}
		public StatementMethodContext statementMethod(int i) {
			return getRuleContext(StatementMethodContext.class,i);
		}
		public MethodBodyRuleContext(MethodBodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterMethodBodyRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitMethodBodyRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitMethodBodyRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodBodyContext methodBody() throws RecognitionException {
		MethodBodyContext _localctx = new MethodBodyContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_methodBody);
		int _la;
		try {
			_localctx = new MethodBodyRuleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 279786676609876224L) != 0)) {
				{
				{
				setState(258);
				statementMethod();
				}
				}
				setState(263);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementMethodContext extends ParserRuleContext {
		public StatementMethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementMethod; }
	 
		public StatementMethodContext() { }
		public void copyFrom(StatementMethodContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MethodThisPropertyAssignmentContext extends StatementMethodContext {
		public TerminalNode THIS() { return getToken(typescriptparser.THIS, 0); }
		public TerminalNode DOT() { return getToken(typescriptparser.DOT, 0); }
		public TerminalNode ID() { return getToken(typescriptparser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(typescriptparser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(typescriptparser.SEMICOLON, 0); }
		public ReturnStatmentContext returnStatment() {
			return getRuleContext(ReturnStatmentContext.class,0);
		}
		public MethodThisPropertyAssignmentContext(StatementMethodContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterMethodThisPropertyAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitMethodThisPropertyAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitMethodThisPropertyAssignment(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MethodReturnOnlyContext extends StatementMethodContext {
		public ReturnStatmentContext returnStatment() {
			return getRuleContext(ReturnStatmentContext.class,0);
		}
		public MethodReturnOnlyContext(StatementMethodContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterMethodReturnOnly(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitMethodReturnOnly(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitMethodReturnOnly(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MethodAssignmentContext extends StatementMethodContext {
		public TerminalNode ID() { return getToken(typescriptparser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(typescriptparser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(typescriptparser.SEMICOLON, 0); }
		public ReturnStatmentContext returnStatment() {
			return getRuleContext(ReturnStatmentContext.class,0);
		}
		public MethodAssignmentContext(StatementMethodContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterMethodAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitMethodAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitMethodAssignment(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MethodExpressionContext extends StatementMethodContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(typescriptparser.SEMICOLON, 0); }
		public ReturnStatmentContext returnStatment() {
			return getRuleContext(ReturnStatmentContext.class,0);
		}
		public MethodExpressionContext(StatementMethodContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterMethodExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitMethodExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitMethodExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementMethodContext statementMethod() throws RecognitionException {
		StatementMethodContext _localctx = new StatementMethodContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_statementMethod);
		try {
			setState(286);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				_localctx = new MethodAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(264);
				match(ID);
				setState(265);
				match(ASSIGN);
				setState(266);
				expression(0);
				setState(267);
				match(SEMICOLON);
				setState(269);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(268);
					returnStatment();
					}
					break;
				}
				}
				break;
			case 2:
				_localctx = new MethodThisPropertyAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(271);
				match(THIS);
				setState(272);
				match(DOT);
				setState(273);
				match(ID);
				setState(274);
				match(ASSIGN);
				setState(275);
				expression(0);
				setState(276);
				match(SEMICOLON);
				setState(278);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(277);
					returnStatment();
					}
					break;
				}
				}
				break;
			case 3:
				_localctx = new MethodExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(280);
				expression(0);
				setState(281);
				match(SEMICOLON);
				setState(283);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(282);
					returnStatment();
					}
					break;
				}
				}
				break;
			case 4:
				_localctx = new MethodReturnOnlyContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(285);
				returnStatment();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStatmentContext extends ParserRuleContext {
		public ReturnStatmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatment; }
	 
		public ReturnStatmentContext() { }
		public void copyFrom(ReturnStatmentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReturnExpressionContext extends ReturnStatmentContext {
		public TerminalNode RETURN() { return getToken(typescriptparser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(typescriptparser.SEMICOLON, 0); }
		public ReturnExpressionContext(ReturnStatmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterReturnExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitReturnExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitReturnExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReturnVoidContext extends ReturnStatmentContext {
		public TerminalNode RETURN() { return getToken(typescriptparser.RETURN, 0); }
		public TerminalNode SEMICOLON() { return getToken(typescriptparser.SEMICOLON, 0); }
		public ReturnVoidContext(ReturnStatmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterReturnVoid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitReturnVoid(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitReturnVoid(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReturnBooleanContext extends ReturnStatmentContext {
		public TerminalNode RETURN() { return getToken(typescriptparser.RETURN, 0); }
		public IsbooleanContext isboolean() {
			return getRuleContext(IsbooleanContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(typescriptparser.SEMICOLON, 0); }
		public ReturnBooleanContext(ReturnStatmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterReturnBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitReturnBoolean(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitReturnBoolean(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReturnIdentifierContext extends ReturnStatmentContext {
		public TerminalNode RETURN() { return getToken(typescriptparser.RETURN, 0); }
		public TerminalNode ID() { return getToken(typescriptparser.ID, 0); }
		public TerminalNode SEMICOLON() { return getToken(typescriptparser.SEMICOLON, 0); }
		public ReturnIdentifierContext(ReturnStatmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterReturnIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitReturnIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitReturnIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatmentContext returnStatment() throws RecognitionException {
		ReturnStatmentContext _localctx = new ReturnStatmentContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_returnStatment);
		try {
			setState(301);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				_localctx = new ReturnExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(288);
				match(RETURN);
				setState(289);
				expression(0);
				setState(290);
				match(SEMICOLON);
				}
				break;
			case 2:
				_localctx = new ReturnIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(292);
				match(RETURN);
				setState(293);
				match(ID);
				setState(294);
				match(SEMICOLON);
				}
				break;
			case 3:
				_localctx = new ReturnBooleanContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(295);
				match(RETURN);
				setState(296);
				isboolean();
				setState(297);
				match(SEMICOLON);
				}
				break;
			case 4:
				_localctx = new ReturnVoidContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(299);
				match(RETURN);
				setState(300);
				match(SEMICOLON);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InterfaceDeclarationContext extends ParserRuleContext {
		public TerminalNode INTERFACE() { return getToken(typescriptparser.INTERFACE, 0); }
		public TerminalNode ID() { return getToken(typescriptparser.ID, 0); }
		public TerminalNode LBRACE() { return getToken(typescriptparser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(typescriptparser.RBRACE, 0); }
		public List<InterfaceMemberContext> interfaceMember() {
			return getRuleContexts(InterfaceMemberContext.class);
		}
		public InterfaceMemberContext interfaceMember(int i) {
			return getRuleContext(InterfaceMemberContext.class,i);
		}
		public InterfaceDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterInterfaceDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitInterfaceDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitInterfaceDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterfaceDeclarationContext interfaceDeclaration() throws RecognitionException {
		InterfaceDeclarationContext _localctx = new InterfaceDeclarationContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_interfaceDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			match(INTERFACE);
			setState(304);
			match(ID);
			setState(305);
			match(LBRACE);
			setState(309);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(306);
				interfaceMember();
				}
				}
				setState(311);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(312);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InterfaceMemberContext extends ParserRuleContext {
		public InterfaceMemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceMember; }
	 
		public InterfaceMemberContext() { }
		public void copyFrom(InterfaceMemberContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InterfacePropertyMemberContext extends InterfaceMemberContext {
		public PropertyDeclarationContext propertyDeclaration() {
			return getRuleContext(PropertyDeclarationContext.class,0);
		}
		public InterfacePropertyMemberContext(InterfaceMemberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterInterfacePropertyMember(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitInterfacePropertyMember(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitInterfacePropertyMember(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InterfaceMethodMemberContext extends InterfaceMemberContext {
		public MethodDeclarationContext methodDeclaration() {
			return getRuleContext(MethodDeclarationContext.class,0);
		}
		public InterfaceMethodMemberContext(InterfaceMemberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterInterfaceMethodMember(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitInterfaceMethodMember(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitInterfaceMethodMember(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterfaceMemberContext interfaceMember() throws RecognitionException {
		InterfaceMemberContext _localctx = new InterfaceMemberContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_interfaceMember);
		try {
			setState(316);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				_localctx = new InterfacePropertyMemberContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(314);
				propertyDeclaration();
				}
				break;
			case 2:
				_localctx = new InterfaceMethodMemberContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(315);
				methodDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterContext extends ParserRuleContext {
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
	 
		public ParameterContext() { }
		public void copyFrom(ParameterContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParameterRuleContext extends ParameterContext {
		public TerminalNode ID() { return getToken(typescriptparser.ID, 0); }
		public TerminalNode COLON() { return getToken(typescriptparser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ParameterRuleContext(ParameterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterParameterRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitParameterRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitParameterRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_parameter);
		try {
			_localctx = new ParameterRuleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
			match(ID);
			setState(319);
			match(COLON);
			setState(320);
			type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterListContext extends ParserRuleContext {
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
	 
		public ParameterListContext() { }
		public void copyFrom(ParameterListContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParameterListRuleContext extends ParameterListContext {
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(typescriptparser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(typescriptparser.COMMA, i);
		}
		public ParameterListRuleContext(ParameterListContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterParameterListRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitParameterListRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitParameterListRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_parameterList);
		int _la;
		try {
			_localctx = new ParameterListRuleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(322);
			parameter();
			setState(327);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(323);
				match(COMMA);
				setState(324);
				parameter();
				}
				}
				setState(329);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclarationContext extends ParserRuleContext {
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
	 
		public VariableDeclarationContext() { }
		public void copyFrom(VariableDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarDeclarationContext extends VariableDeclarationContext {
		public TerminalNode VAR() { return getToken(typescriptparser.VAR, 0); }
		public TerminalNode ID() { return getToken(typescriptparser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(typescriptparser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VarDeclarationContext(VariableDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterVarDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitVarDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitVarDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LetDeclarationContext extends VariableDeclarationContext {
		public TerminalNode LET() { return getToken(typescriptparser.LET, 0); }
		public TerminalNode ID() { return getToken(typescriptparser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(typescriptparser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LetDeclarationContext(VariableDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterLetDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitLetDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitLetDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConstDeclarationContext extends VariableDeclarationContext {
		public TerminalNode CONST() { return getToken(typescriptparser.CONST, 0); }
		public TerminalNode ID() { return getToken(typescriptparser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(typescriptparser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ConstDeclarationContext(VariableDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterConstDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitConstDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitConstDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_variableDeclaration);
		try {
			setState(348);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONST:
				_localctx = new ConstDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(330);
				match(CONST);
				setState(331);
				match(ID);
				setState(334);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
				case 1:
					{
					setState(332);
					match(ASSIGN);
					setState(333);
					expression(0);
					}
					break;
				}
				}
				break;
			case LET:
				_localctx = new LetDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(336);
				match(LET);
				setState(337);
				match(ID);
				setState(340);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
				case 1:
					{
					setState(338);
					match(ASSIGN);
					setState(339);
					expression(0);
					}
					break;
				}
				}
				break;
			case VAR:
				_localctx = new VarDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(342);
				match(VAR);
				setState(343);
				match(ID);
				setState(346);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
				case 1:
					{
					setState(344);
					match(ASSIGN);
					setState(345);
					expression(0);
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VoidTypeContext extends TypeContext {
		public TerminalNode VOID_TYPE() { return getToken(typescriptparser.VOID_TYPE, 0); }
		public VoidTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterVoidType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitVoidType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitVoidType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumberTypeContext extends TypeContext {
		public TerminalNode NUMBER_TYPE() { return getToken(typescriptparser.NUMBER_TYPE, 0); }
		public NumberTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterNumberType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitNumberType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitNumberType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringTypeContext extends TypeContext {
		public TerminalNode STRING_TYPE() { return getToken(typescriptparser.STRING_TYPE, 0); }
		public StringTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterStringType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitStringType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitStringType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ListTypeContext extends TypeContext {
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public ListTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterListType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitListType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitListType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BooleanTypeContext extends TypeContext {
		public TerminalNode BOOLEAN_TYPE() { return getToken(typescriptparser.BOOLEAN_TYPE, 0); }
		public BooleanTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterBooleanType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitBooleanType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitBooleanType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AnyTypeContext extends TypeContext {
		public TerminalNode ANY_TYPE() { return getToken(typescriptparser.ANY_TYPE, 0); }
		public AnyTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterAnyType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitAnyType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitAnyType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdTypeContext extends TypeContext {
		public TerminalNode ID() { return getToken(typescriptparser.ID, 0); }
		public IdTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterIdType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitIdType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitIdType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_type);
		try {
			setState(357);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				_localctx = new StringTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(350);
				match(STRING_TYPE);
				}
				break;
			case 2:
				_localctx = new NumberTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(351);
				match(NUMBER_TYPE);
				}
				break;
			case 3:
				_localctx = new BooleanTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(352);
				match(BOOLEAN_TYPE);
				}
				break;
			case 4:
				_localctx = new AnyTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(353);
				match(ANY_TYPE);
				}
				break;
			case 5:
				_localctx = new VoidTypeContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(354);
				match(VOID_TYPE);
				}
				break;
			case 6:
				_localctx = new IdTypeContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(355);
				match(ID);
				}
				break;
			case 7:
				_localctx = new ListTypeContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(356);
				list();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MemberAccessContext extends ParserRuleContext {
		public MemberAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberAccess; }
	 
		public MemberAccessContext() { }
		public void copyFrom(MemberAccessContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ThisMemberAccessContext extends MemberAccessContext {
		public TerminalNode THIS() { return getToken(typescriptparser.THIS, 0); }
		public TerminalNode DOT() { return getToken(typescriptparser.DOT, 0); }
		public TerminalNode ID() { return getToken(typescriptparser.ID, 0); }
		public ThisMemberAccessContext(MemberAccessContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterThisMemberAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitThisMemberAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitThisMemberAccess(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SimpleMemberAccessContext extends MemberAccessContext {
		public TerminalNode ID() { return getToken(typescriptparser.ID, 0); }
		public SimpleMemberAccessContext(MemberAccessContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterSimpleMemberAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitSimpleMemberAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitSimpleMemberAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MemberAccessContext memberAccess() throws RecognitionException {
		MemberAccessContext _localctx = new MemberAccessContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_memberAccess);
		try {
			setState(363);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case THIS:
				_localctx = new ThisMemberAccessContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(359);
				match(THIS);
				setState(360);
				match(DOT);
				setState(361);
				match(ID);
				}
				break;
			case ID:
				_localctx = new SimpleMemberAccessContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(362);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListContext extends ParserRuleContext {
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
	 
		public ListContext() { }
		public void copyFrom(ListContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ListDeclarationContext extends ListContext {
		public TerminalNode ID() { return getToken(typescriptparser.ID, 0); }
		public TerminalNode LBRACKET() { return getToken(typescriptparser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(typescriptparser.RBRACKET, 0); }
		public ListDeclarationContext(ListContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterListDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitListDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitListDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_list);
		try {
			_localctx = new ListDeclarationContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
			match(ID);
			setState(366);
			match(LBRACKET);
			setState(367);
			match(RBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BodylistContext extends ParserRuleContext {
		public BodylistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bodylist; }
	 
		public BodylistContext() { }
		public void copyFrom(BodylistContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BodyListRuleContext extends BodylistContext {
		public List<InitvalueContext> initvalue() {
			return getRuleContexts(InitvalueContext.class);
		}
		public InitvalueContext initvalue(int i) {
			return getRuleContext(InitvalueContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(typescriptparser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(typescriptparser.COMMA, i);
		}
		public BodyListRuleContext(BodylistContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterBodyListRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitBodyListRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitBodyListRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodylistContext bodylist() throws RecognitionException {
		BodylistContext _localctx = new BodylistContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_bodylist);
		int _la;
		try {
			_localctx = new BodyListRuleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(377);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 51)) & ~0x3f) == 0 && ((1L << (_la - 51)) & 8301L) != 0)) {
				{
				setState(369);
				initvalue();
				setState(374);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(370);
					match(COMMA);
					setState(371);
					initvalue();
					}
					}
					setState(376);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ObjectContext extends ParserRuleContext {
		public ObjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_object; }
	 
		public ObjectContext() { }
		public void copyFrom(ObjectContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ObjectRuleContext extends ObjectContext {
		public TerminalNode LBRACE() { return getToken(typescriptparser.LBRACE, 0); }
		public BodyobjectContext bodyobject() {
			return getRuleContext(BodyobjectContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(typescriptparser.RBRACE, 0); }
		public TerminalNode COMMA() { return getToken(typescriptparser.COMMA, 0); }
		public ObjectRuleContext(ObjectContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterObjectRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitObjectRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitObjectRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectContext object() throws RecognitionException {
		ObjectContext _localctx = new ObjectContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_object);
		try {
			_localctx = new ObjectRuleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(379);
			match(LBRACE);
			setState(380);
			bodyobject();
			setState(381);
			match(RBRACE);
			setState(383);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				setState(382);
				match(COMMA);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BodyobjectContext extends ParserRuleContext {
		public BodyobjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bodyobject; }
	 
		public BodyobjectContext() { }
		public void copyFrom(BodyobjectContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ObjectBodyRuleContext extends BodyobjectContext {
		public List<KeyValuePairContext> keyValuePair() {
			return getRuleContexts(KeyValuePairContext.class);
		}
		public KeyValuePairContext keyValuePair(int i) {
			return getRuleContext(KeyValuePairContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(typescriptparser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(typescriptparser.COMMA, i);
		}
		public ObjectBodyRuleContext(BodyobjectContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterObjectBodyRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitObjectBodyRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitObjectBodyRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyobjectContext bodyobject() throws RecognitionException {
		BodyobjectContext _localctx = new BodyobjectContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_bodyobject);
		int _la;
		try {
			_localctx = new ObjectBodyRuleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(393);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(385);
				keyValuePair();
				setState(390);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(386);
					match(COMMA);
					setState(387);
					keyValuePair();
					}
					}
					setState(392);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class KeyValuePairContext extends ParserRuleContext {
		public KeyValuePairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyValuePair; }
	 
		public KeyValuePairContext() { }
		public void copyFrom(KeyValuePairContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class KeyValueContext extends KeyValuePairContext {
		public TerminalNode ID() { return getToken(typescriptparser.ID, 0); }
		public TerminalNode COLON() { return getToken(typescriptparser.COLON, 0); }
		public InitvalueContext initvalue() {
			return getRuleContext(InitvalueContext.class,0);
		}
		public KeyValueContext(KeyValuePairContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterKeyValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitKeyValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitKeyValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeyValuePairContext keyValuePair() throws RecognitionException {
		KeyValuePairContext _localctx = new KeyValuePairContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_keyValuePair);
		try {
			_localctx = new KeyValueContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(395);
			match(ID);
			setState(396);
			match(COLON);
			setState(397);
			initvalue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InitvalueContext extends ParserRuleContext {
		public InitvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initvalue; }
	 
		public InitvalueContext() { }
		public void copyFrom(InitvalueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BooleanInitValueContext extends InitvalueContext {
		public IsbooleanContext isboolean() {
			return getRuleContext(IsbooleanContext.class,0);
		}
		public BooleanInitValueContext(InitvalueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterBooleanInitValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitBooleanInitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitBooleanInitValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ListInitValueContext extends InitvalueContext {
		public TerminalNode LBRACKET() { return getToken(typescriptparser.LBRACKET, 0); }
		public BodylistContext bodylist() {
			return getRuleContext(BodylistContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(typescriptparser.RBRACKET, 0); }
		public ListInitValueContext(InitvalueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterListInitValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitListInitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitListInitValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumberInitValueContext extends InitvalueContext {
		public TerminalNode NUMBER_LIT() { return getToken(typescriptparser.NUMBER_LIT, 0); }
		public NumberInitValueContext(InitvalueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterNumberInitValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitNumberInitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitNumberInitValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringInitValueContext extends InitvalueContext {
		public TerminalNode STRING_LIT() { return getToken(typescriptparser.STRING_LIT, 0); }
		public StringInitValueContext(InitvalueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterStringInitValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitStringInitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitStringInitValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ObjectInitValueContext extends InitvalueContext {
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
		public ObjectInitValueContext(InitvalueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterObjectInitValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitObjectInitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitObjectInitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitvalueContext initvalue() throws RecognitionException {
		InitvalueContext _localctx = new InitvalueContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_initvalue);
		try {
			setState(407);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER_LIT:
				_localctx = new NumberInitValueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(399);
				match(NUMBER_LIT);
				}
				break;
			case STRING_LIT:
				_localctx = new StringInitValueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(400);
				match(STRING_LIT);
				}
				break;
			case TRUE:
			case FALSE:
				_localctx = new BooleanInitValueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(401);
				isboolean();
				}
				break;
			case LBRACKET:
				_localctx = new ListInitValueContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(402);
				match(LBRACKET);
				setState(403);
				bodylist();
				setState(404);
				match(RBRACKET);
				}
				break;
			case LBRACE:
				_localctx = new ObjectInitValueContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(406);
				object();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumberLiteralExprContext extends ExpressionContext {
		public TerminalNode NUMBER_LIT() { return getToken(typescriptparser.NUMBER_LIT, 0); }
		public NumberLiteralExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterNumberLiteralExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitNumberLiteralExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitNumberLiteralExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclarationExprContext extends ExpressionContext {
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public VariableDeclarationExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterVariableDeclarationExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitVariableDeclarationExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitVariableDeclarationExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallExprContext extends ExpressionContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public FunctionCallExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterFunctionCallExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitFunctionCallExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitFunctionCallExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierExprContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(typescriptparser.ID, 0); }
		public IdentifierExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterIdentifierExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitIdentifierExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitIdentifierExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BooleanLiteralExprContext extends ExpressionContext {
		public IsbooleanContext isboolean() {
			return getRuleContext(IsbooleanContext.class,0);
		}
		public BooleanLiteralExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterBooleanLiteralExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitBooleanLiteralExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitBooleanLiteralExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BinaryExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public BinaryExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterBinaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitBinaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitBinaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringLiteralExprContext extends ExpressionContext {
		public TerminalNode STRING_LIT() { return getToken(typescriptparser.STRING_LIT, 0); }
		public StringLiteralExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterStringLiteralExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitStringLiteralExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitStringLiteralExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenthesizedExprContext extends ExpressionContext {
		public TerminalNode LPAREN() { return getToken(typescriptparser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(typescriptparser.RPAREN, 0); }
		public ParenthesizedExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterParenthesizedExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitParenthesizedExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitParenthesizedExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MemberAccessExprContext extends ExpressionContext {
		public MemberAccessContext memberAccess() {
			return getRuleContext(MemberAccessContext.class,0);
		}
		public MemberAccessExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterMemberAccessExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitMemberAccessExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitMemberAccessExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 66;
		enterRecursionRule(_localctx, 66, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(421);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				{
				_localctx = new StringLiteralExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(410);
				match(STRING_LIT);
				}
				break;
			case 2:
				{
				_localctx = new NumberLiteralExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(411);
				match(NUMBER_LIT);
				}
				break;
			case 3:
				{
				_localctx = new IdentifierExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(412);
				match(ID);
				}
				break;
			case 4:
				{
				_localctx = new BooleanLiteralExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(413);
				isboolean();
				}
				break;
			case 5:
				{
				_localctx = new FunctionCallExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(414);
				functionCall();
				}
				break;
			case 6:
				{
				_localctx = new VariableDeclarationExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(415);
				variableDeclaration();
				}
				break;
			case 7:
				{
				_localctx = new MemberAccessExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(416);
				memberAccess();
				}
				break;
			case 8:
				{
				_localctx = new ParenthesizedExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(417);
				match(LPAREN);
				setState(418);
				expression(0);
				setState(419);
				match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(429);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_expression);
					setState(423);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(424);
					operator();
					setState(425);
					expression(3);
					}
					} 
				}
				setState(431);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OperatorContext extends ParserRuleContext {
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
	 
		public OperatorContext() { }
		public void copyFrom(OperatorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MinusOpContext extends OperatorContext {
		public TerminalNode MINUS() { return getToken(typescriptparser.MINUS, 0); }
		public MinusOpContext(OperatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterMinusOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitMinusOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitMinusOp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StarOpContext extends OperatorContext {
		public TerminalNode STAR() { return getToken(typescriptparser.STAR, 0); }
		public StarOpContext(OperatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterStarOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitStarOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitStarOp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SlashOpContext extends OperatorContext {
		public TerminalNode SLASH() { return getToken(typescriptparser.SLASH, 0); }
		public SlashOpContext(OperatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterSlashOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitSlashOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitSlashOp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PlusOpContext extends OperatorContext {
		public TerminalNode PLUS() { return getToken(typescriptparser.PLUS, 0); }
		public PlusOpContext(OperatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterPlusOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitPlusOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitPlusOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_operator);
		try {
			setState(436);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
				_localctx = new PlusOpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(432);
				match(PLUS);
				}
				break;
			case MINUS:
				_localctx = new MinusOpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(433);
				match(MINUS);
				}
				break;
			case STAR:
				_localctx = new StarOpContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(434);
				match(STAR);
				}
				break;
			case SLASH:
				_localctx = new SlashOpContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(435);
				match(SLASH);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallContext extends ParserRuleContext {
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
	 
		public FunctionCallContext() { }
		public void copyFrom(FunctionCallContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StandardFunctionCallContext extends FunctionCallContext {
		public TerminalNode ID() { return getToken(typescriptparser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(typescriptparser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(typescriptparser.RPAREN, 0); }
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public StandardFunctionCallContext(FunctionCallContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterStandardFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitStandardFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitStandardFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_functionCall);
		int _la;
		try {
			_localctx = new StandardFunctionCallContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(438);
			match(ID);
			setState(439);
			match(LPAREN);
			setState(443);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 279786676609875968L) != 0)) {
				{
				{
				setState(440);
				argument();
				}
				}
				setState(445);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(446);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentContext extends ParserRuleContext {
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
	 
		public ArgumentContext() { }
		public void copyFrom(ArgumentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionArgumentContext extends ArgumentContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionArgumentContext(ArgumentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterExpressionArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitExpressionArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitExpressionArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_argument);
		try {
			_localctx = new ExpressionArgumentContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(448);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElementContext extends ParserRuleContext {
		public ElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_element; }
	 
		public ElementContext() { }
		public void copyFrom(ElementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InterpolationElementContext extends ElementContext {
		public InterpolationContext interpolation() {
			return getRuleContext(InterpolationContext.class,0);
		}
		public InterpolationElementContext(ElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterInterpolationElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitInterpolationElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitInterpolationElement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TagElementContext extends ElementContext {
		public TagContext tag() {
			return getRuleContext(TagContext.class,0);
		}
		public TagElementContext(ElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterTagElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitTagElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitTagElement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HtmlNameElementContext extends ElementContext {
		public TerminalNode NAME_HTML() { return getToken(typescriptparser.NAME_HTML, 0); }
		public TerminalNode COLON_HTML() { return getToken(typescriptparser.COLON_HTML, 0); }
		public HtmlNameElementContext(ElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterHtmlNameElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitHtmlNameElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitHtmlNameElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementContext element() throws RecognitionException {
		ElementContext _localctx = new ElementContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_element);
		int _la;
		try {
			setState(456);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TAG_OPEN_START_HTML:
				_localctx = new TagElementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(450);
				tag();
				}
				break;
			case NAME_HTML:
				_localctx = new HtmlNameElementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(451);
				match(NAME_HTML);
				setState(453);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLON_HTML) {
					{
					setState(452);
					match(COLON_HTML);
					}
				}

				}
				break;
			case INTERPOLATION_START_HTML:
				_localctx = new InterpolationElementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(455);
				interpolation();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TagContext extends ParserRuleContext {
		public TagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tag; }
	 
		public TagContext() { }
		public void copyFrom(TagContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OpenCloseTagContext extends TagContext {
		public OpeningTagContext openingTag() {
			return getRuleContext(OpeningTagContext.class,0);
		}
		public ClosingTagContext closingTag() {
			return getRuleContext(ClosingTagContext.class,0);
		}
		public List<ElementContext> element() {
			return getRuleContexts(ElementContext.class);
		}
		public ElementContext element(int i) {
			return getRuleContext(ElementContext.class,i);
		}
		public OpenCloseTagContext(TagContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterOpenCloseTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitOpenCloseTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitOpenCloseTag(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SelfClosingTagElementContext extends TagContext {
		public SelfClosingTagContext selfClosingTag() {
			return getRuleContext(SelfClosingTagContext.class,0);
		}
		public SelfClosingTagElementContext(TagContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterSelfClosingTagElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitSelfClosingTagElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitSelfClosingTagElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TagContext tag() throws RecognitionException {
		TagContext _localctx = new TagContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_tag);
		int _la;
		try {
			setState(468);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				_localctx = new OpenCloseTagContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(458);
				openingTag();
				setState(462);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & 18433L) != 0)) {
					{
					{
					setState(459);
					element();
					}
					}
					setState(464);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(465);
				closingTag();
				}
				break;
			case 2:
				_localctx = new SelfClosingTagElementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(467);
				selfClosingTag();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OpeningTagContext extends ParserRuleContext {
		public OpeningTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_openingTag; }
	 
		public OpeningTagContext() { }
		public void copyFrom(OpeningTagContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OpeningTagRuleContext extends OpeningTagContext {
		public TerminalNode TAG_OPEN_START_HTML() { return getToken(typescriptparser.TAG_OPEN_START_HTML, 0); }
		public TerminalNode TAG_CLOSE_END_HTML() { return getToken(typescriptparser.TAG_CLOSE_END_HTML, 0); }
		public List<AttributesContext> attributes() {
			return getRuleContexts(AttributesContext.class);
		}
		public AttributesContext attributes(int i) {
			return getRuleContext(AttributesContext.class,i);
		}
		public OpeningTagRuleContext(OpeningTagContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterOpeningTagRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitOpeningTagRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitOpeningTagRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpeningTagContext openingTag() throws RecognitionException {
		OpeningTagContext _localctx = new OpeningTagContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_openingTag);
		int _la;
		try {
			_localctx = new OpeningTagRuleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(470);
			match(TAG_OPEN_START_HTML);
			setState(474);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & 263L) != 0)) {
				{
				{
				setState(471);
				attributes();
				}
				}
				setState(476);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(477);
			match(TAG_CLOSE_END_HTML);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClosingTagContext extends ParserRuleContext {
		public ClosingTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_closingTag; }
	 
		public ClosingTagContext() { }
		public void copyFrom(ClosingTagContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ClosingTagRuleContext extends ClosingTagContext {
		public TerminalNode TAG_CLOSE_START_HTML() { return getToken(typescriptparser.TAG_CLOSE_START_HTML, 0); }
		public TerminalNode NAME_HTML() { return getToken(typescriptparser.NAME_HTML, 0); }
		public TerminalNode TAG_CLOSE_END_HTML() { return getToken(typescriptparser.TAG_CLOSE_END_HTML, 0); }
		public ClosingTagRuleContext(ClosingTagContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterClosingTagRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitClosingTagRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitClosingTagRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClosingTagContext closingTag() throws RecognitionException {
		ClosingTagContext _localctx = new ClosingTagContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_closingTag);
		try {
			_localctx = new ClosingTagRuleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(479);
			match(TAG_CLOSE_START_HTML);
			setState(480);
			match(NAME_HTML);
			setState(481);
			match(TAG_CLOSE_END_HTML);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SelfClosingTagContext extends ParserRuleContext {
		public SelfClosingTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selfClosingTag; }
	 
		public SelfClosingTagContext() { }
		public void copyFrom(SelfClosingTagContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SelfClosingTagRuleContext extends SelfClosingTagContext {
		public TerminalNode TAG_OPEN_START_HTML() { return getToken(typescriptparser.TAG_OPEN_START_HTML, 0); }
		public TerminalNode TAG_END_HTML() { return getToken(typescriptparser.TAG_END_HTML, 0); }
		public List<AttributesContext> attributes() {
			return getRuleContexts(AttributesContext.class);
		}
		public AttributesContext attributes(int i) {
			return getRuleContext(AttributesContext.class,i);
		}
		public SelfClosingTagRuleContext(SelfClosingTagContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterSelfClosingTagRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitSelfClosingTagRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitSelfClosingTagRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelfClosingTagContext selfClosingTag() throws RecognitionException {
		SelfClosingTagContext _localctx = new SelfClosingTagContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_selfClosingTag);
		int _la;
		try {
			_localctx = new SelfClosingTagRuleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(483);
			match(TAG_OPEN_START_HTML);
			setState(487);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & 263L) != 0)) {
				{
				{
				setState(484);
				attributes();
				}
				}
				setState(489);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(490);
			match(TAG_END_HTML);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttributesContext extends ParserRuleContext {
		public AttributesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributes; }
	 
		public AttributesContext() { }
		public void copyFrom(AttributesContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EventBindingAttributeContext extends AttributesContext {
		public TerminalNode EVENT_BINDING_HTML() { return getToken(typescriptparser.EVENT_BINDING_HTML, 0); }
		public TerminalNode ATTRIBUTE_EQUALS_HTML() { return getToken(typescriptparser.ATTRIBUTE_EQUALS_HTML, 0); }
		public TerminalNode STRING_HTML() { return getToken(typescriptparser.STRING_HTML, 0); }
		public EventBindingAttributeContext(AttributesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterEventBindingAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitEventBindingAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitEventBindingAttribute(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StructuralDirectiveAttributeContext extends AttributesContext {
		public TerminalNode STRUCTURAL_DIR_HTML() { return getToken(typescriptparser.STRUCTURAL_DIR_HTML, 0); }
		public TerminalNode ATTRIBUTE_EQUALS_HTML() { return getToken(typescriptparser.ATTRIBUTE_EQUALS_HTML, 0); }
		public TerminalNode STRING_HTML() { return getToken(typescriptparser.STRING_HTML, 0); }
		public StructuralDirectiveAttributeContext(AttributesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterStructuralDirectiveAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitStructuralDirectiveAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitStructuralDirectiveAttribute(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BindingAttributeContext extends AttributesContext {
		public TerminalNode BINDING_HTML() { return getToken(typescriptparser.BINDING_HTML, 0); }
		public TerminalNode ATTRIBUTE_EQUALS_HTML() { return getToken(typescriptparser.ATTRIBUTE_EQUALS_HTML, 0); }
		public TerminalNode STRING_HTML() { return getToken(typescriptparser.STRING_HTML, 0); }
		public BindingAttributeContext(AttributesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterBindingAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitBindingAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitBindingAttribute(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HtmlAttributeContext extends AttributesContext {
		public TerminalNode NAME_HTML() { return getToken(typescriptparser.NAME_HTML, 0); }
		public TerminalNode ATTRIBUTE_EQUALS_HTML() { return getToken(typescriptparser.ATTRIBUTE_EQUALS_HTML, 0); }
		public TerminalNode STRING_HTML() { return getToken(typescriptparser.STRING_HTML, 0); }
		public HtmlAttributeContext(AttributesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterHtmlAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitHtmlAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitHtmlAttribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributesContext attributes() throws RecognitionException {
		AttributesContext _localctx = new AttributesContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_attributes);
		try {
			setState(504);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME_HTML:
				_localctx = new HtmlAttributeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(492);
				match(NAME_HTML);
				setState(493);
				match(ATTRIBUTE_EQUALS_HTML);
				setState(494);
				match(STRING_HTML);
				}
				break;
			case STRUCTURAL_DIR_HTML:
				_localctx = new StructuralDirectiveAttributeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(495);
				match(STRUCTURAL_DIR_HTML);
				setState(496);
				match(ATTRIBUTE_EQUALS_HTML);
				setState(497);
				match(STRING_HTML);
				}
				break;
			case BINDING_HTML:
				_localctx = new BindingAttributeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(498);
				match(BINDING_HTML);
				setState(499);
				match(ATTRIBUTE_EQUALS_HTML);
				setState(500);
				match(STRING_HTML);
				}
				break;
			case EVENT_BINDING_HTML:
				_localctx = new EventBindingAttributeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(501);
				match(EVENT_BINDING_HTML);
				setState(502);
				match(ATTRIBUTE_EQUALS_HTML);
				setState(503);
				match(STRING_HTML);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InterpolationContext extends ParserRuleContext {
		public InterpolationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interpolation; }
	 
		public InterpolationContext() { }
		public void copyFrom(InterpolationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InterpolationRuleContext extends InterpolationContext {
		public TerminalNode INTERPOLATION_START_HTML() { return getToken(typescriptparser.INTERPOLATION_START_HTML, 0); }
		public TerminalNode NAME_HTML() { return getToken(typescriptparser.NAME_HTML, 0); }
		public TerminalNode INTERPOLATION_END_HTML() { return getToken(typescriptparser.INTERPOLATION_END_HTML, 0); }
		public InterpolationRuleContext(InterpolationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterInterpolationRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitInterpolationRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitInterpolationRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterpolationContext interpolation() throws RecognitionException {
		InterpolationContext _localctx = new InterpolationContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_interpolation);
		try {
			_localctx = new InterpolationRuleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(506);
			match(INTERPOLATION_START_HTML);
			setState(507);
			match(NAME_HTML);
			setState(508);
			match(INTERPOLATION_END_HTML);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssBodyContext extends ParserRuleContext {
		public CssBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssBody; }
	 
		public CssBodyContext() { }
		public void copyFrom(CssBodyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssBodyRuleContext extends CssBodyContext {
		public List<TerminalNode> BACKTICK_CSS() { return getTokens(typescriptparser.BACKTICK_CSS); }
		public TerminalNode BACKTICK_CSS(int i) {
			return getToken(typescriptparser.BACKTICK_CSS, i);
		}
		public CssObjectsContext cssObjects() {
			return getRuleContext(CssObjectsContext.class,0);
		}
		public TerminalNode COMMA_CSS() { return getToken(typescriptparser.COMMA_CSS, 0); }
		public CssBodyRuleContext(CssBodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterCssBodyRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitCssBodyRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitCssBodyRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssBodyContext cssBody() throws RecognitionException {
		CssBodyContext _localctx = new CssBodyContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_cssBody);
		int _la;
		try {
			_localctx = new CssBodyRuleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(510);
			match(BACKTICK_CSS);
			setState(511);
			cssObjects();
			setState(512);
			match(BACKTICK_CSS);
			setState(514);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA_CSS) {
				{
				setState(513);
				match(COMMA_CSS);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssObjectsContext extends ParserRuleContext {
		public CssObjectsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssObjects; }
	 
		public CssObjectsContext() { }
		public void copyFrom(CssObjectsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssObjectsRuleContext extends CssObjectsContext {
		public List<CsselementContext> csselement() {
			return getRuleContexts(CsselementContext.class);
		}
		public CsselementContext csselement(int i) {
			return getRuleContext(CsselementContext.class,i);
		}
		public List<TerminalNode> COMMA_CSS() { return getTokens(typescriptparser.COMMA_CSS); }
		public TerminalNode COMMA_CSS(int i) {
			return getToken(typescriptparser.COMMA_CSS, i);
		}
		public CssObjectsRuleContext(CssObjectsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterCssObjectsRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitCssObjectsRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitCssObjectsRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssObjectsContext cssObjects() throws RecognitionException {
		CssObjectsContext _localctx = new CssObjectsContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_cssObjects);
		int _la;
		try {
			_localctx = new CssObjectsRuleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(517);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				{
				setState(516);
				csselement();
				}
				break;
			}
			setState(525);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA_CSS || _la==DOT_CSS) {
				{
				{
				setState(520);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA_CSS) {
					{
					setState(519);
					match(COMMA_CSS);
					}
				}

				setState(522);
				csselement();
				}
				}
				setState(527);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CsselementContext extends ParserRuleContext {
		public CsselementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_csselement; }
	 
		public CsselementContext() { }
		public void copyFrom(CsselementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssElementRuleContext extends CsselementContext {
		public TerminalNode DOT_CSS() { return getToken(typescriptparser.DOT_CSS, 0); }
		public TerminalNode LBRACE_CSS() { return getToken(typescriptparser.LBRACE_CSS, 0); }
		public TerminalNode RBRACE_CSS() { return getToken(typescriptparser.RBRACE_CSS, 0); }
		public List<TerminalNode> ID_CSS() { return getTokens(typescriptparser.ID_CSS); }
		public TerminalNode ID_CSS(int i) {
			return getToken(typescriptparser.ID_CSS, i);
		}
		public List<BodyelementContext> bodyelement() {
			return getRuleContexts(BodyelementContext.class);
		}
		public BodyelementContext bodyelement(int i) {
			return getRuleContext(BodyelementContext.class,i);
		}
		public CssElementRuleContext(CsselementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterCssElementRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitCssElementRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitCssElementRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CsselementContext csselement() throws RecognitionException {
		CsselementContext _localctx = new CsselementContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_csselement);
		int _la;
		try {
			_localctx = new CssElementRuleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(528);
			match(DOT_CSS);
			setState(530); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(529);
				match(ID_CSS);
				}
				}
				setState(532); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID_CSS );
			setState(534);
			match(LBRACE_CSS);
			setState(536); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(535);
				bodyelement();
				}
				}
				setState(538); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID_CSS );
			setState(540);
			match(RBRACE_CSS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BodyelementContext extends ParserRuleContext {
		public BodyelementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bodyelement; }
	 
		public BodyelementContext() { }
		public void copyFrom(BodyelementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssDeclarationContext extends BodyelementContext {
		public TerminalNode ID_CSS() { return getToken(typescriptparser.ID_CSS, 0); }
		public TerminalNode COLON_CSS() { return getToken(typescriptparser.COLON_CSS, 0); }
		public CssValueContext cssValue() {
			return getRuleContext(CssValueContext.class,0);
		}
		public TerminalNode SEMICOLON_CSS() { return getToken(typescriptparser.SEMICOLON_CSS, 0); }
		public CssDeclarationContext(BodyelementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterCssDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitCssDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitCssDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyelementContext bodyelement() throws RecognitionException {
		BodyelementContext _localctx = new BodyelementContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_bodyelement);
		try {
			_localctx = new CssDeclarationContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(542);
			match(ID_CSS);
			setState(543);
			match(COLON_CSS);
			setState(544);
			cssValue();
			setState(545);
			match(SEMICOLON_CSS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssValueContext extends ParserRuleContext {
		public CssValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssValue; }
	 
		public CssValueContext() { }
		public void copyFrom(CssValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdValueContext extends CssValueContext {
		public List<TerminalNode> ID_CSS() { return getTokens(typescriptparser.ID_CSS); }
		public TerminalNode ID_CSS(int i) {
			return getToken(typescriptparser.ID_CSS, i);
		}
		public IdValueContext(CssValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterIdValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitIdValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitIdValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PercentValueContext extends CssValueContext {
		public TerminalNode PERCENT() { return getToken(typescriptparser.PERCENT, 0); }
		public List<TerminalNode> ID_CSS() { return getTokens(typescriptparser.ID_CSS); }
		public TerminalNode ID_CSS(int i) {
			return getToken(typescriptparser.ID_CSS, i);
		}
		public PercentValueContext(CssValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterPercentValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitPercentValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitPercentValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssValueContext cssValue() throws RecognitionException {
		CssValueContext _localctx = new CssValueContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_cssValue);
		int _la;
		try {
			setState(561);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PERCENT:
				_localctx = new PercentValueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(547);
				match(PERCENT);
				setState(552);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID_CSS) {
					{
					setState(548);
					match(ID_CSS);
					setState(550);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ID_CSS) {
						{
						setState(549);
						match(ID_CSS);
						}
					}

					}
				}

				}
				break;
			case ID_CSS:
				_localctx = new IdValueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(554);
				match(ID_CSS);
				setState(559);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID_CSS) {
					{
					setState(555);
					match(ID_CSS);
					setState(557);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ID_CSS) {
						{
						setState(556);
						match(ID_CSS);
						}
					}

					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 33:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001h\u0234\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u0001\u0000\u0004\u0000"+
		"d\b\u0000\u000b\u0000\f\u0000e\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001p\b"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002v\b"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0005"+
		"\u0004\u0083\b\u0004\n\u0004\f\u0004\u0086\t\u0004\u0003\u0004\u0088\b"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0005\u0007\u0096\b\u0007\n\u0007\f\u0007\u0099\t\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00a3"+
		"\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0003\t\u00b7\b\t\u0001\t\u0003\t\u00ba\b\t\u0001\n\u0001\n\u0001\n"+
		"\u0001\n\u0001\n\u0003\n\u00c1\b\n\u0001\u000b\u0001\u000b\u0003\u000b"+
		"\u00c5\b\u000b\u0001\f\u0003\f\u00c8\b\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\r\u0003\r\u00d1\b\r\u0005\r\u00d3\b\r\n\r\f\r"+
		"\u00d6\t\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e"+
		"\u00dd\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0003\u000f\u00e5\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u00ee\b\u000f"+
		"\u0001\u000f\u0003\u000f\u00f1\b\u000f\u0003\u000f\u00f3\b\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u00f8\b\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0003\u0010\u00fd\b\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0011\u0005\u0011\u0104\b\u0011\n\u0011\f\u0011"+
		"\u0107\t\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0003\u0012\u010e\b\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u0117\b\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0003\u0012\u011c\b\u0012\u0001\u0012\u0003\u0012"+
		"\u011f\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0003\u0013\u012e\b\u0013\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0005\u0014\u0134\b\u0014\n\u0014\f\u0014\u0137"+
		"\t\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0003\u0015\u013d"+
		"\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0005\u0017\u0146\b\u0017\n\u0017\f\u0017\u0149\t\u0017"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u014f\b\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u0155\b\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u015b\b\u0018"+
		"\u0003\u0018\u015d\b\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u0166\b\u0019\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u016c\b\u001a\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0005\u001c\u0175\b\u001c\n\u001c\f\u001c\u0178\t\u001c\u0003\u001c\u017a"+
		"\b\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0003\u001d\u0180"+
		"\b\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0005\u001e\u0185\b\u001e"+
		"\n\u001e\f\u001e\u0188\t\u001e\u0003\u001e\u018a\b\u001e\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0001 \u0001 \u0001"+
		" \u0001 \u0001 \u0003 \u0198\b \u0001!\u0001!\u0001!\u0001!\u0001!\u0001"+
		"!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0003!\u01a6\b!\u0001!\u0001"+
		"!\u0001!\u0001!\u0005!\u01ac\b!\n!\f!\u01af\t!\u0001\"\u0001\"\u0001\""+
		"\u0001\"\u0003\"\u01b5\b\"\u0001#\u0001#\u0001#\u0005#\u01ba\b#\n#\f#"+
		"\u01bd\t#\u0001#\u0001#\u0001$\u0001$\u0001%\u0001%\u0001%\u0003%\u01c6"+
		"\b%\u0001%\u0003%\u01c9\b%\u0001&\u0001&\u0005&\u01cd\b&\n&\f&\u01d0\t"+
		"&\u0001&\u0001&\u0001&\u0003&\u01d5\b&\u0001\'\u0001\'\u0005\'\u01d9\b"+
		"\'\n\'\f\'\u01dc\t\'\u0001\'\u0001\'\u0001(\u0001(\u0001(\u0001(\u0001"+
		")\u0001)\u0005)\u01e6\b)\n)\f)\u01e9\t)\u0001)\u0001)\u0001*\u0001*\u0001"+
		"*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0003"+
		"*\u01f9\b*\u0001+\u0001+\u0001+\u0001+\u0001,\u0001,\u0001,\u0001,\u0003"+
		",\u0203\b,\u0001-\u0003-\u0206\b-\u0001-\u0003-\u0209\b-\u0001-\u0005"+
		"-\u020c\b-\n-\f-\u020f\t-\u0001.\u0001.\u0004.\u0213\b.\u000b.\f.\u0214"+
		"\u0001.\u0001.\u0004.\u0219\b.\u000b.\f.\u021a\u0001.\u0001.\u0001/\u0001"+
		"/\u0001/\u0001/\u0001/\u00010\u00010\u00010\u00030\u0227\b0\u00030\u0229"+
		"\b0\u00010\u00010\u00010\u00030\u022e\b0\u00030\u0230\b0\u00030\u0232"+
		"\b0\u00010\u0000\u0001B1\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\"+
		"^`\u0000\u0000\u0265\u0000c\u0001\u0000\u0000\u0000\u0002o\u0001\u0000"+
		"\u0000\u0000\u0004q\u0001\u0000\u0000\u0000\u0006w\u0001\u0000\u0000\u0000"+
		"\b\u0087\u0001\u0000\u0000\u0000\n\u0089\u0001\u0000\u0000\u0000\f\u008d"+
		"\u0001\u0000\u0000\u0000\u000e\u0091\u0001\u0000\u0000\u0000\u0010\u009c"+
		"\u0001\u0000\u0000\u0000\u0012\u00b9\u0001\u0000\u0000\u0000\u0014\u00c0"+
		"\u0001\u0000\u0000\u0000\u0016\u00c4\u0001\u0000\u0000\u0000\u0018\u00c7"+
		"\u0001\u0000\u0000\u0000\u001a\u00cd\u0001\u0000\u0000\u0000\u001c\u00dc"+
		"\u0001\u0000\u0000\u0000\u001e\u00f2\u0001\u0000\u0000\u0000 \u00f4\u0001"+
		"\u0000\u0000\u0000\"\u0105\u0001\u0000\u0000\u0000$\u011e\u0001\u0000"+
		"\u0000\u0000&\u012d\u0001\u0000\u0000\u0000(\u012f\u0001\u0000\u0000\u0000"+
		"*\u013c\u0001\u0000\u0000\u0000,\u013e\u0001\u0000\u0000\u0000.\u0142"+
		"\u0001\u0000\u0000\u00000\u015c\u0001\u0000\u0000\u00002\u0165\u0001\u0000"+
		"\u0000\u00004\u016b\u0001\u0000\u0000\u00006\u016d\u0001\u0000\u0000\u0000"+
		"8\u0179\u0001\u0000\u0000\u0000:\u017b\u0001\u0000\u0000\u0000<\u0189"+
		"\u0001\u0000\u0000\u0000>\u018b\u0001\u0000\u0000\u0000@\u0197\u0001\u0000"+
		"\u0000\u0000B\u01a5\u0001\u0000\u0000\u0000D\u01b4\u0001\u0000\u0000\u0000"+
		"F\u01b6\u0001\u0000\u0000\u0000H\u01c0\u0001\u0000\u0000\u0000J\u01c8"+
		"\u0001\u0000\u0000\u0000L\u01d4\u0001\u0000\u0000\u0000N\u01d6\u0001\u0000"+
		"\u0000\u0000P\u01df\u0001\u0000\u0000\u0000R\u01e3\u0001\u0000\u0000\u0000"+
		"T\u01f8\u0001\u0000\u0000\u0000V\u01fa\u0001\u0000\u0000\u0000X\u01fe"+
		"\u0001\u0000\u0000\u0000Z\u0205\u0001\u0000\u0000\u0000\\\u0210\u0001"+
		"\u0000\u0000\u0000^\u021e\u0001\u0000\u0000\u0000`\u0231\u0001\u0000\u0000"+
		"\u0000bd\u0003\u0002\u0001\u0000cb\u0001\u0000\u0000\u0000de\u0001\u0000"+
		"\u0000\u0000ec\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000f\u0001"+
		"\u0001\u0000\u0000\u0000gp\u0003\u0006\u0003\u0000hp\u0003\u0018\f\u0000"+
		"ip\u0003(\u0014\u0000jp\u00030\u0018\u0000kp\u0003\u0004\u0002\u0000l"+
		"p\u0003F#\u0000mp\u0003 \u0010\u0000np\u0003\u0012\t\u0000og\u0001\u0000"+
		"\u0000\u0000oh\u0001\u0000\u0000\u0000oi\u0001\u0000\u0000\u0000oj\u0001"+
		"\u0000\u0000\u0000ok\u0001\u0000\u0000\u0000ol\u0001\u0000\u0000\u0000"+
		"om\u0001\u0000\u0000\u0000on\u0001\u0000\u0000\u0000p\u0003\u0001\u0000"+
		"\u0000\u0000qr\u00057\u0000\u0000rs\u0005(\u0000\u0000su\u0003B!\u0000"+
		"tv\u0005%\u0000\u0000ut\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000"+
		"v\u0005\u0001\u0000\u0000\u0000wx\u0005=\u0000\u0000xy\u0005\u0017\u0000"+
		"\u0000yz\u00051\u0000\u0000z{\u00053\u0000\u0000{|\u0003\b\u0004\u0000"+
		"|}\u00054\u0000\u0000}~\u00052\u0000\u0000~\u0007\u0001\u0000\u0000\u0000"+
		"\u007f\u0084\u0003\u0014\n\u0000\u0080\u0081\u0005\"\u0000\u0000\u0081"+
		"\u0083\u0003\u0014\n\u0000\u0082\u0080\u0001\u0000\u0000\u0000\u0083\u0086"+
		"\u0001\u0000\u0000\u0000\u0084\u0082\u0001\u0000\u0000\u0000\u0084\u0085"+
		"\u0001\u0000\u0000\u0000\u0085\u0088\u0001\u0000\u0000\u0000\u0086\u0084"+
		"\u0001\u0000\u0000\u0000\u0087\u007f\u0001\u0000\u0000\u0000\u0087\u0088"+
		"\u0001\u0000\u0000\u0000\u0088\t\u0001\u0000\u0000\u0000\u0089\u008a\u0005"+
		"\u0018\u0000\u0000\u008a\u008b\u0005#\u0000\u0000\u008b\u008c\u00058\u0000"+
		"\u0000\u008c\u000b\u0001\u0000\u0000\u0000\u008d\u008e\u0005\u0019\u0000"+
		"\u0000\u008e\u008f\u0005#\u0000\u0000\u008f\u0090\u0003\u0016\u000b\u0000"+
		"\u0090\r\u0001\u0000\u0000\u0000\u0091\u0092\u0005\u001b\u0000\u0000\u0092"+
		"\u0093\u0005P\u0000\u0000\u0093\u0097\u0005W\u0000\u0000\u0094\u0096\u0003"+
		"J%\u0000\u0095\u0094\u0001\u0000\u0000\u0000\u0096\u0099\u0001\u0000\u0000"+
		"\u0000\u0097\u0095\u0001\u0000\u0000\u0000\u0097\u0098\u0001\u0000\u0000"+
		"\u0000\u0098\u009a\u0001\u0000\u0000\u0000\u0099\u0097\u0001\u0000\u0000"+
		"\u0000\u009a\u009b\u0005V\u0000\u0000\u009b\u000f\u0001\u0000\u0000\u0000"+
		"\u009c\u009d\u0005\u001c\u0000\u0000\u009d\u009e\u0005Y\u0000\u0000\u009e"+
		"\u009f\u0005[\u0000\u0000\u009f\u00a0\u0003X,\u0000\u00a0\u00a2\u0005"+
		"\\\u0000\u0000\u00a1\u00a3\u0005\"\u0000\u0000\u00a2\u00a1\u0001\u0000"+
		"\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3\u0011\u0001\u0000"+
		"\u0000\u0000\u00a4\u00a5\u0005\u0011\u0000\u0000\u00a5\u00a6\u00053\u0000"+
		"\u0000\u00a6\u00a7\u00057\u0000\u0000\u00a7\u00a8\u00054\u0000\u0000\u00a8"+
		"\u00a9\u0005\u0016\u0000\u0000\u00a9\u00aa\u00058\u0000\u0000\u00aa\u00ba"+
		"\u0005%\u0000\u0000\u00ab\u00ac\u0005\u0011\u0000\u0000\u00ac\u00ad\u0005"+
		"3\u0000\u0000\u00ad\u00ae\u0005\u0017\u0000\u0000\u00ae\u00af\u00054\u0000"+
		"\u0000\u00af\u00b0\u0005\u0016\u0000\u0000\u00b0\u00b1\u00058\u0000\u0000"+
		"\u00b1\u00ba\u0005%\u0000\u0000\u00b2\u00b3\u0005\u001a\u0000\u0000\u00b3"+
		"\u00b4\u0005#\u0000\u0000\u00b4\u00b6\u0005@\u0000\u0000\u00b5\u00b7\u0005"+
		"7\u0000\u0000\u00b6\u00b5\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000"+
		"\u0000\u0000\u00b7\u00b8\u0001\u0000\u0000\u0000\u00b8\u00ba\u0005A\u0000"+
		"\u0000\u00b9\u00a4\u0001\u0000\u0000\u0000\u00b9\u00ab\u0001\u0000\u0000"+
		"\u0000\u00b9\u00b2\u0001\u0000\u0000\u0000\u00ba\u0013\u0001\u0000\u0000"+
		"\u0000\u00bb\u00c1\u0003\n\u0005\u0000\u00bc\u00c1\u0003\f\u0006\u0000"+
		"\u00bd\u00c1\u0003\u0012\t\u0000\u00be\u00c1\u0003\u000e\u0007\u0000\u00bf"+
		"\u00c1\u0003\u0010\b\u0000\u00c0\u00bb\u0001\u0000\u0000\u0000\u00c0\u00bc"+
		"\u0001\u0000\u0000\u0000\u00c0\u00bd\u0001\u0000\u0000\u0000\u00c0\u00be"+
		"\u0001\u0000\u0000\u0000\u00c0\u00bf\u0001\u0000\u0000\u0000\u00c1\u0015"+
		"\u0001\u0000\u0000\u0000\u00c2\u00c5\u00055\u0000\u0000\u00c3\u00c5\u0005"+
		"6\u0000\u0000\u00c4\u00c2\u0001\u0000\u0000\u0000\u00c4\u00c3\u0001\u0000"+
		"\u0000\u0000\u00c5\u0017\u0001\u0000\u0000\u0000\u00c6\u00c8\u0005\u0012"+
		"\u0000\u0000\u00c7\u00c6\u0001\u0000\u0000\u0000\u00c7\u00c8\u0001\u0000"+
		"\u0000\u0000\u00c8\u00c9\u0001\u0000\u0000\u0000\u00c9\u00ca\u0005\u000f"+
		"\u0000\u0000\u00ca\u00cb\u00057\u0000\u0000\u00cb\u00cc\u0003\u001a\r"+
		"\u0000\u00cc\u0019\u0001\u0000\u0000\u0000\u00cd\u00d4\u00053\u0000\u0000"+
		"\u00ce\u00d0\u0003\u001c\u000e\u0000\u00cf\u00d1\u0005%\u0000\u0000\u00d0"+
		"\u00cf\u0001\u0000\u0000\u0000\u00d0\u00d1\u0001\u0000\u0000\u0000\u00d1"+
		"\u00d3\u0001\u0000\u0000\u0000\u00d2\u00ce\u0001\u0000\u0000\u0000\u00d3"+
		"\u00d6\u0001\u0000\u0000\u0000\u00d4\u00d2\u0001\u0000\u0000\u0000\u00d4"+
		"\u00d5\u0001\u0000\u0000\u0000\u00d5\u00d7\u0001\u0000\u0000\u0000\u00d6"+
		"\u00d4\u0001\u0000\u0000\u0000\u00d7\u00d8\u00054\u0000\u0000\u00d8\u001b"+
		"\u0001\u0000\u0000\u0000\u00d9\u00dd\u0003 \u0010\u0000\u00da\u00dd\u0003"+
		"\u001e\u000f\u0000\u00db\u00dd\u0003\u0018\f\u0000\u00dc\u00d9\u0001\u0000"+
		"\u0000\u0000\u00dc\u00da\u0001\u0000\u0000\u0000\u00dc\u00db\u0001\u0000"+
		"\u0000\u0000\u00dd\u001d\u0001\u0000\u0000\u0000\u00de\u00df\u00057\u0000"+
		"\u0000\u00df\u00e0\u0005#\u0000\u0000\u00e0\u00e1\u00032\u0019\u0000\u00e1"+
		"\u00e2\u0005(\u0000\u0000\u00e2\u00e4\u0003@ \u0000\u00e3\u00e5\u0005"+
		"%\u0000\u0000\u00e4\u00e3\u0001\u0000\u0000\u0000\u00e4\u00e5\u0001\u0000"+
		"\u0000\u0000\u00e5\u00f3\u0001\u0000\u0000\u0000\u00e6\u00e7\u00057\u0000"+
		"\u0000\u00e7\u00e8\u0005#\u0000\u0000\u00e8\u00ed\u00032\u0019\u0000\u00e9"+
		"\u00ea\u0005B\u0000\u0000\u00ea\u00eb\u00057\u0000\u0000\u00eb\u00ec\u0005"+
		"(\u0000\u0000\u00ec\u00ee\u00057\u0000\u0000\u00ed\u00e9\u0001\u0000\u0000"+
		"\u0000\u00ed\u00ee\u0001\u0000\u0000\u0000\u00ee\u00f0\u0001\u0000\u0000"+
		"\u0000\u00ef\u00f1\u0005%\u0000\u0000\u00f0\u00ef\u0001\u0000\u0000\u0000"+
		"\u00f0\u00f1\u0001\u0000\u0000\u0000\u00f1\u00f3\u0001\u0000\u0000\u0000"+
		"\u00f2\u00de\u0001\u0000\u0000\u0000\u00f2\u00e6\u0001\u0000\u0000\u0000"+
		"\u00f3\u001f\u0001\u0000\u0000\u0000\u00f4\u00f5\u00057\u0000\u0000\u00f5"+
		"\u00f7\u00051\u0000\u0000\u00f6\u00f8\u0003.\u0017\u0000\u00f7\u00f6\u0001"+
		"\u0000\u0000\u0000\u00f7\u00f8\u0001\u0000\u0000\u0000\u00f8\u00f9\u0001"+
		"\u0000\u0000\u0000\u00f9\u00fa\u00052\u0000\u0000\u00fa\u00fc\u0005#\u0000"+
		"\u0000\u00fb\u00fd\u00032\u0019\u0000\u00fc\u00fb\u0001\u0000\u0000\u0000"+
		"\u00fc\u00fd\u0001\u0000\u0000\u0000\u00fd\u00fe\u0001\u0000\u0000\u0000"+
		"\u00fe\u00ff\u00053\u0000\u0000\u00ff\u0100\u0003\"\u0011\u0000\u0100"+
		"\u0101\u00054\u0000\u0000\u0101!\u0001\u0000\u0000\u0000\u0102\u0104\u0003"+
		"$\u0012\u0000\u0103\u0102\u0001\u0000\u0000\u0000\u0104\u0107\u0001\u0000"+
		"\u0000\u0000\u0105\u0103\u0001\u0000\u0000\u0000\u0105\u0106\u0001\u0000"+
		"\u0000\u0000\u0106#\u0001\u0000\u0000\u0000\u0107\u0105\u0001\u0000\u0000"+
		"\u0000\u0108\u0109\u00057\u0000\u0000\u0109\u010a\u0005(\u0000\u0000\u010a"+
		"\u010b\u0003B!\u0000\u010b\u010d\u0005%\u0000\u0000\u010c\u010e\u0003"+
		"&\u0013\u0000\u010d\u010c\u0001\u0000\u0000\u0000\u010d\u010e\u0001\u0000"+
		"\u0000\u0000\u010e\u011f\u0001\u0000\u0000\u0000\u010f\u0110\u0005\'\u0000"+
		"\u0000\u0110\u0111\u0005$\u0000\u0000\u0111\u0112\u00057\u0000\u0000\u0112"+
		"\u0113\u0005(\u0000\u0000\u0113\u0114\u0003B!\u0000\u0114\u0116\u0005"+
		"%\u0000\u0000\u0115\u0117\u0003&\u0013\u0000\u0116\u0115\u0001\u0000\u0000"+
		"\u0000\u0116\u0117\u0001\u0000\u0000\u0000\u0117\u011f\u0001\u0000\u0000"+
		"\u0000\u0118\u0119\u0003B!\u0000\u0119\u011b\u0005%\u0000\u0000\u011a"+
		"\u011c\u0003&\u0013\u0000\u011b\u011a\u0001\u0000\u0000\u0000\u011b\u011c"+
		"\u0001\u0000\u0000\u0000\u011c\u011f\u0001\u0000\u0000\u0000\u011d\u011f"+
		"\u0003&\u0013\u0000\u011e\u0108\u0001\u0000\u0000\u0000\u011e\u010f\u0001"+
		"\u0000\u0000\u0000\u011e\u0118\u0001\u0000\u0000\u0000\u011e\u011d\u0001"+
		"\u0000\u0000\u0000\u011f%\u0001\u0000\u0000\u0000\u0120\u0121\u0005\b"+
		"\u0000\u0000\u0121\u0122\u0003B!\u0000\u0122\u0123\u0005%\u0000\u0000"+
		"\u0123\u012e\u0001\u0000\u0000\u0000\u0124\u0125\u0005\b\u0000\u0000\u0125"+
		"\u0126\u00057\u0000\u0000\u0126\u012e\u0005%\u0000\u0000\u0127\u0128\u0005"+
		"\b\u0000\u0000\u0128\u0129\u0003\u0016\u000b\u0000\u0129\u012a\u0005%"+
		"\u0000\u0000\u012a\u012e\u0001\u0000\u0000\u0000\u012b\u012c\u0005\b\u0000"+
		"\u0000\u012c\u012e\u0005%\u0000\u0000\u012d\u0120\u0001\u0000\u0000\u0000"+
		"\u012d\u0124\u0001\u0000\u0000\u0000\u012d\u0127\u0001\u0000\u0000\u0000"+
		"\u012d\u012b\u0001\u0000\u0000\u0000\u012e\'\u0001\u0000\u0000\u0000\u012f"+
		"\u0130\u0005\u0010\u0000\u0000\u0130\u0131\u00057\u0000\u0000\u0131\u0135"+
		"\u00053\u0000\u0000\u0132\u0134\u0003*\u0015\u0000\u0133\u0132\u0001\u0000"+
		"\u0000\u0000\u0134\u0137\u0001\u0000\u0000\u0000\u0135\u0133\u0001\u0000"+
		"\u0000\u0000\u0135\u0136\u0001\u0000\u0000\u0000\u0136\u0138\u0001\u0000"+
		"\u0000\u0000\u0137\u0135\u0001\u0000\u0000\u0000\u0138\u0139\u00054\u0000"+
		"\u0000\u0139)\u0001\u0000\u0000\u0000\u013a\u013d\u0003\u001e\u000f\u0000"+
		"\u013b\u013d\u0003 \u0010\u0000\u013c\u013a\u0001\u0000\u0000\u0000\u013c"+
		"\u013b\u0001\u0000\u0000\u0000\u013d+\u0001\u0000\u0000\u0000\u013e\u013f"+
		"\u00057\u0000\u0000\u013f\u0140\u0005#\u0000\u0000\u0140\u0141\u00032"+
		"\u0019\u0000\u0141-\u0001\u0000\u0000\u0000\u0142\u0147\u0003,\u0016\u0000"+
		"\u0143\u0144\u0005\"\u0000\u0000\u0144\u0146\u0003,\u0016\u0000\u0145"+
		"\u0143\u0001\u0000\u0000\u0000\u0146\u0149\u0001\u0000\u0000\u0000\u0147"+
		"\u0145\u0001\u0000\u0000\u0000\u0147\u0148\u0001\u0000\u0000\u0000\u0148"+
		"/\u0001\u0000\u0000\u0000\u0149\u0147\u0001\u0000\u0000\u0000\u014a\u014b"+
		"\u0005\u0013\u0000\u0000\u014b\u014e\u00057\u0000\u0000\u014c\u014d\u0005"+
		"(\u0000\u0000\u014d\u014f\u0003B!\u0000\u014e\u014c\u0001\u0000\u0000"+
		"\u0000\u014e\u014f\u0001\u0000\u0000\u0000\u014f\u015d\u0001\u0000\u0000"+
		"\u0000\u0150\u0151\u0005\u0014\u0000\u0000\u0151\u0154\u00057\u0000\u0000"+
		"\u0152\u0153\u0005(\u0000\u0000\u0153\u0155\u0003B!\u0000\u0154\u0152"+
		"\u0001\u0000\u0000\u0000\u0154\u0155\u0001\u0000\u0000\u0000\u0155\u015d"+
		"\u0001\u0000\u0000\u0000\u0156\u0157\u0005\u0015\u0000\u0000\u0157\u015a"+
		"\u00057\u0000\u0000\u0158\u0159\u0005(\u0000\u0000\u0159\u015b\u0003B"+
		"!\u0000\u015a\u0158\u0001\u0000\u0000\u0000\u015a\u015b\u0001\u0000\u0000"+
		"\u0000\u015b\u015d\u0001\u0000\u0000\u0000\u015c\u014a\u0001\u0000\u0000"+
		"\u0000\u015c\u0150\u0001\u0000\u0000\u0000\u015c\u0156\u0001\u0000\u0000"+
		"\u0000\u015d1\u0001\u0000\u0000\u0000\u015e\u0166\u0005\u001d\u0000\u0000"+
		"\u015f\u0166\u0005\u001e\u0000\u0000\u0160\u0166\u0005\u001f\u0000\u0000"+
		"\u0161\u0166\u0005 \u0000\u0000\u0162\u0166\u0005!\u0000\u0000\u0163\u0166"+
		"\u00057\u0000\u0000\u0164\u0166\u00036\u001b\u0000\u0165\u015e\u0001\u0000"+
		"\u0000\u0000\u0165\u015f\u0001\u0000\u0000\u0000\u0165\u0160\u0001\u0000"+
		"\u0000\u0000\u0165\u0161\u0001\u0000\u0000\u0000\u0165\u0162\u0001\u0000"+
		"\u0000\u0000\u0165\u0163\u0001\u0000\u0000\u0000\u0165\u0164\u0001\u0000"+
		"\u0000\u0000\u01663\u0001\u0000\u0000\u0000\u0167\u0168\u0005\'\u0000"+
		"\u0000\u0168\u0169\u0005$\u0000\u0000\u0169\u016c\u00057\u0000\u0000\u016a"+
		"\u016c\u00057\u0000\u0000\u016b\u0167\u0001\u0000\u0000\u0000\u016b\u016a"+
		"\u0001\u0000\u0000\u0000\u016c5\u0001\u0000\u0000\u0000\u016d\u016e\u0005"+
		"7\u0000\u0000\u016e\u016f\u0005@\u0000\u0000\u016f\u0170\u0005A\u0000"+
		"\u0000\u01707\u0001\u0000\u0000\u0000\u0171\u0176\u0003@ \u0000\u0172"+
		"\u0173\u0005\"\u0000\u0000\u0173\u0175\u0003@ \u0000\u0174\u0172\u0001"+
		"\u0000\u0000\u0000\u0175\u0178\u0001\u0000\u0000\u0000\u0176\u0174\u0001"+
		"\u0000\u0000\u0000\u0176\u0177\u0001\u0000\u0000\u0000\u0177\u017a\u0001"+
		"\u0000\u0000\u0000\u0178\u0176\u0001\u0000\u0000\u0000\u0179\u0171\u0001"+
		"\u0000\u0000\u0000\u0179\u017a\u0001\u0000\u0000\u0000\u017a9\u0001\u0000"+
		"\u0000\u0000\u017b\u017c\u00053\u0000\u0000\u017c\u017d\u0003<\u001e\u0000"+
		"\u017d\u017f\u00054\u0000\u0000\u017e\u0180\u0005\"\u0000\u0000\u017f"+
		"\u017e\u0001\u0000\u0000\u0000\u017f\u0180\u0001\u0000\u0000\u0000\u0180"+
		";\u0001\u0000\u0000\u0000\u0181\u0186\u0003>\u001f\u0000\u0182\u0183\u0005"+
		"\"\u0000\u0000\u0183\u0185\u0003>\u001f\u0000\u0184\u0182\u0001\u0000"+
		"\u0000\u0000\u0185\u0188\u0001\u0000\u0000\u0000\u0186\u0184\u0001\u0000"+
		"\u0000\u0000\u0186\u0187\u0001\u0000\u0000\u0000\u0187\u018a\u0001\u0000"+
		"\u0000\u0000\u0188\u0186\u0001\u0000\u0000\u0000\u0189\u0181\u0001\u0000"+
		"\u0000\u0000\u0189\u018a\u0001\u0000\u0000\u0000\u018a=\u0001\u0000\u0000"+
		"\u0000\u018b\u018c\u00057\u0000\u0000\u018c\u018d\u0005#\u0000\u0000\u018d"+
		"\u018e\u0003@ \u0000\u018e?\u0001\u0000\u0000\u0000\u018f\u0198\u0005"+
		"9\u0000\u0000\u0190\u0198\u00058\u0000\u0000\u0191\u0198\u0003\u0016\u000b"+
		"\u0000\u0192\u0193\u0005@\u0000\u0000\u0193\u0194\u00038\u001c\u0000\u0194"+
		"\u0195\u0005A\u0000\u0000\u0195\u0198\u0001\u0000\u0000\u0000\u0196\u0198"+
		"\u0003:\u001d\u0000\u0197\u018f\u0001\u0000\u0000\u0000\u0197\u0190\u0001"+
		"\u0000\u0000\u0000\u0197\u0191\u0001\u0000\u0000\u0000\u0197\u0192\u0001"+
		"\u0000\u0000\u0000\u0197\u0196\u0001\u0000\u0000\u0000\u0198A\u0001\u0000"+
		"\u0000\u0000\u0199\u019a\u0006!\uffff\uffff\u0000\u019a\u01a6\u00058\u0000"+
		"\u0000\u019b\u01a6\u00059\u0000\u0000\u019c\u01a6\u00057\u0000\u0000\u019d"+
		"\u01a6\u0003\u0016\u000b\u0000\u019e\u01a6\u0003F#\u0000\u019f\u01a6\u0003"+
		"0\u0018\u0000\u01a0\u01a6\u00034\u001a\u0000\u01a1\u01a2\u00051\u0000"+
		"\u0000\u01a2\u01a3\u0003B!\u0000\u01a3\u01a4\u00052\u0000\u0000\u01a4"+
		"\u01a6\u0001\u0000\u0000\u0000\u01a5\u0199\u0001\u0000\u0000\u0000\u01a5"+
		"\u019b\u0001\u0000\u0000\u0000\u01a5\u019c\u0001\u0000\u0000\u0000\u01a5"+
		"\u019d\u0001\u0000\u0000\u0000\u01a5\u019e\u0001\u0000\u0000\u0000\u01a5"+
		"\u019f\u0001\u0000\u0000\u0000\u01a5\u01a0\u0001\u0000\u0000\u0000\u01a5"+
		"\u01a1\u0001\u0000\u0000\u0000\u01a6\u01ad\u0001\u0000\u0000\u0000\u01a7"+
		"\u01a8\n\u0002\u0000\u0000\u01a8\u01a9\u0003D\"\u0000\u01a9\u01aa\u0003"+
		"B!\u0003\u01aa\u01ac\u0001\u0000\u0000\u0000\u01ab\u01a7\u0001\u0000\u0000"+
		"\u0000\u01ac\u01af\u0001\u0000\u0000\u0000\u01ad\u01ab\u0001\u0000\u0000"+
		"\u0000\u01ad\u01ae\u0001\u0000\u0000\u0000\u01aeC\u0001\u0000\u0000\u0000"+
		"\u01af\u01ad\u0001\u0000\u0000\u0000\u01b0\u01b5\u0005)\u0000\u0000\u01b1"+
		"\u01b5\u0005*\u0000\u0000\u01b2\u01b5\u0005+\u0000\u0000\u01b3\u01b5\u0005"+
		",\u0000\u0000\u01b4\u01b0\u0001\u0000\u0000\u0000\u01b4\u01b1\u0001\u0000"+
		"\u0000\u0000\u01b4\u01b2\u0001\u0000\u0000\u0000\u01b4\u01b3\u0001\u0000"+
		"\u0000\u0000\u01b5E\u0001\u0000\u0000\u0000\u01b6\u01b7\u00057\u0000\u0000"+
		"\u01b7\u01bb\u00051\u0000\u0000\u01b8\u01ba\u0003H$\u0000\u01b9\u01b8"+
		"\u0001\u0000\u0000\u0000\u01ba\u01bd\u0001\u0000\u0000\u0000\u01bb\u01b9"+
		"\u0001\u0000\u0000\u0000\u01bb\u01bc\u0001\u0000\u0000\u0000\u01bc\u01be"+
		"\u0001\u0000\u0000\u0000\u01bd\u01bb\u0001\u0000\u0000\u0000\u01be\u01bf"+
		"\u00052\u0000\u0000\u01bfG\u0001\u0000\u0000\u0000\u01c0\u01c1\u0003B"+
		"!\u0000\u01c1I\u0001\u0000\u0000\u0000\u01c2\u01c9\u0003L&\u0000\u01c3"+
		"\u01c5\u0005T\u0000\u0000\u01c4\u01c6\u0005P\u0000\u0000\u01c5\u01c4\u0001"+
		"\u0000\u0000\u0000\u01c5\u01c6\u0001\u0000\u0000\u0000\u01c6\u01c9\u0001"+
		"\u0000\u0000\u0000\u01c7\u01c9\u0003V+\u0000\u01c8\u01c2\u0001\u0000\u0000"+
		"\u0000\u01c8\u01c3\u0001\u0000\u0000\u0000\u01c8\u01c7\u0001\u0000\u0000"+
		"\u0000\u01c9K\u0001\u0000\u0000\u0000\u01ca\u01ce\u0003N\'\u0000\u01cb"+
		"\u01cd\u0003J%\u0000\u01cc\u01cb\u0001\u0000\u0000\u0000\u01cd\u01d0\u0001"+
		"\u0000\u0000\u0000\u01ce\u01cc\u0001\u0000\u0000\u0000\u01ce\u01cf\u0001"+
		"\u0000\u0000\u0000\u01cf\u01d1\u0001\u0000\u0000\u0000\u01d0\u01ce\u0001"+
		"\u0000\u0000\u0000\u01d1\u01d2\u0003P(\u0000\u01d2\u01d5\u0001\u0000\u0000"+
		"\u0000\u01d3\u01d5\u0003R)\u0000\u01d4\u01ca\u0001\u0000\u0000\u0000\u01d4"+
		"\u01d3\u0001\u0000\u0000\u0000\u01d5M\u0001\u0000\u0000\u0000\u01d6\u01da"+
		"\u0005F\u0000\u0000\u01d7\u01d9\u0003T*\u0000\u01d8\u01d7\u0001\u0000"+
		"\u0000\u0000\u01d9\u01dc\u0001\u0000\u0000\u0000\u01da\u01d8\u0001\u0000"+
		"\u0000\u0000\u01da\u01db\u0001\u0000\u0000\u0000\u01db\u01dd\u0001\u0000"+
		"\u0000\u0000\u01dc\u01da\u0001\u0000\u0000\u0000\u01dd\u01de\u0005H\u0000"+
		"\u0000\u01deO\u0001\u0000\u0000\u0000\u01df\u01e0\u0005G\u0000\u0000\u01e0"+
		"\u01e1\u0005T\u0000\u0000\u01e1\u01e2\u0005H\u0000\u0000\u01e2Q\u0001"+
		"\u0000\u0000\u0000\u01e3\u01e7\u0005F\u0000\u0000\u01e4\u01e6\u0003T*"+
		"\u0000\u01e5\u01e4\u0001\u0000\u0000\u0000\u01e6\u01e9\u0001\u0000\u0000"+
		"\u0000\u01e7\u01e5\u0001\u0000\u0000\u0000\u01e7\u01e8\u0001\u0000\u0000"+
		"\u0000\u01e8\u01ea\u0001\u0000\u0000\u0000\u01e9\u01e7\u0001\u0000\u0000"+
		"\u0000\u01ea\u01eb\u0005I\u0000\u0000\u01ebS\u0001\u0000\u0000\u0000\u01ec"+
		"\u01ed\u0005T\u0000\u0000\u01ed\u01ee\u0005J\u0000\u0000\u01ee\u01f9\u0005"+
		"K\u0000\u0000\u01ef\u01f0\u0005L\u0000\u0000\u01f0\u01f1\u0005J\u0000"+
		"\u0000\u01f1\u01f9\u0005K\u0000\u0000\u01f2\u01f3\u0005M\u0000\u0000\u01f3"+
		"\u01f4\u0005J\u0000\u0000\u01f4\u01f9\u0005K\u0000\u0000\u01f5\u01f6\u0005"+
		"N\u0000\u0000\u01f6\u01f7\u0005J\u0000\u0000\u01f7\u01f9\u0005K\u0000"+
		"\u0000\u01f8\u01ec\u0001\u0000\u0000\u0000\u01f8\u01ef\u0001\u0000\u0000"+
		"\u0000\u01f8\u01f2\u0001\u0000\u0000\u0000\u01f8\u01f5\u0001\u0000\u0000"+
		"\u0000\u01f9U\u0001\u0000\u0000\u0000\u01fa\u01fb\u0005Q\u0000\u0000\u01fb"+
		"\u01fc\u0005T\u0000\u0000\u01fc\u01fd\u0005R\u0000\u0000\u01fdW\u0001"+
		"\u0000\u0000\u0000\u01fe\u01ff\u0005X\u0000\u0000\u01ff\u0200\u0003Z-"+
		"\u0000\u0200\u0202\u0005X\u0000\u0000\u0201\u0203\u0005Z\u0000\u0000\u0202"+
		"\u0201\u0001\u0000\u0000\u0000\u0202\u0203\u0001\u0000\u0000\u0000\u0203"+
		"Y\u0001\u0000\u0000\u0000\u0204\u0206\u0003\\.\u0000\u0205\u0204\u0001"+
		"\u0000\u0000\u0000\u0205\u0206\u0001\u0000\u0000\u0000\u0206\u020d\u0001"+
		"\u0000\u0000\u0000\u0207\u0209\u0005Z\u0000\u0000\u0208\u0207\u0001\u0000"+
		"\u0000\u0000\u0208\u0209\u0001\u0000\u0000\u0000\u0209\u020a\u0001\u0000"+
		"\u0000\u0000\u020a\u020c\u0003\\.\u0000\u020b\u0208\u0001\u0000\u0000"+
		"\u0000\u020c\u020f\u0001\u0000\u0000\u0000\u020d\u020b\u0001\u0000\u0000"+
		"\u0000\u020d\u020e\u0001\u0000\u0000\u0000\u020e[\u0001\u0000\u0000\u0000"+
		"\u020f\u020d\u0001\u0000\u0000\u0000\u0210\u0212\u0005]\u0000\u0000\u0211"+
		"\u0213\u0005h\u0000\u0000\u0212\u0211\u0001\u0000\u0000\u0000\u0213\u0214"+
		"\u0001\u0000\u0000\u0000\u0214\u0212\u0001\u0000\u0000\u0000\u0214\u0215"+
		"\u0001\u0000\u0000\u0000\u0215\u0216\u0001\u0000\u0000\u0000\u0216\u0218"+
		"\u0005_\u0000\u0000\u0217\u0219\u0003^/\u0000\u0218\u0217\u0001\u0000"+
		"\u0000\u0000\u0219\u021a\u0001\u0000\u0000\u0000\u021a\u0218\u0001\u0000"+
		"\u0000\u0000\u021a\u021b\u0001\u0000\u0000\u0000\u021b\u021c\u0001\u0000"+
		"\u0000\u0000\u021c\u021d\u0005`\u0000\u0000\u021d]\u0001\u0000\u0000\u0000"+
		"\u021e\u021f\u0005h\u0000\u0000\u021f\u0220\u0005Y\u0000\u0000\u0220\u0221"+
		"\u0003`0\u0000\u0221\u0222\u0005^\u0000\u0000\u0222_\u0001\u0000\u0000"+
		"\u0000\u0223\u0228\u0005a\u0000\u0000\u0224\u0226\u0005h\u0000\u0000\u0225"+
		"\u0227\u0005h\u0000\u0000\u0226\u0225\u0001\u0000\u0000\u0000\u0226\u0227"+
		"\u0001\u0000\u0000\u0000\u0227\u0229\u0001\u0000\u0000\u0000\u0228\u0224"+
		"\u0001\u0000\u0000\u0000\u0228\u0229\u0001\u0000\u0000\u0000\u0229\u0232"+
		"\u0001\u0000\u0000\u0000\u022a\u022f\u0005h\u0000\u0000\u022b\u022d\u0005"+
		"h\u0000\u0000\u022c\u022e\u0005h\u0000\u0000\u022d\u022c\u0001\u0000\u0000"+
		"\u0000\u022d\u022e\u0001\u0000\u0000\u0000\u022e\u0230\u0001\u0000\u0000"+
		"\u0000\u022f\u022b\u0001\u0000\u0000\u0000\u022f\u0230\u0001\u0000\u0000"+
		"\u0000\u0230\u0232\u0001\u0000\u0000\u0000\u0231\u0223\u0001\u0000\u0000"+
		"\u0000\u0231\u022a\u0001\u0000\u0000\u0000\u0232a\u0001\u0000\u0000\u0000"+
		"@eou\u0084\u0087\u0097\u00a2\u00b6\u00b9\u00c0\u00c4\u00c7\u00d0\u00d4"+
		"\u00dc\u00e4\u00ed\u00f0\u00f2\u00f7\u00fc\u0105\u010d\u0116\u011b\u011e"+
		"\u012d\u0135\u013c\u0147\u014e\u0154\u015a\u015c\u0165\u016b\u0176\u0179"+
		"\u017f\u0186\u0189\u0197\u01a5\u01ad\u01b4\u01bb\u01c5\u01c8\u01ce\u01d4"+
		"\u01da\u01e7\u01f8\u0202\u0205\u0208\u020d\u0214\u021a\u0226\u0228\u022d"+
		"\u022f\u0231";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}