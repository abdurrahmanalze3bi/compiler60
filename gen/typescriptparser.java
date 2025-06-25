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
		RULE_bodyobject = 30, RULE_initvalue = 31, RULE_expression = 32, RULE_operator = 33, 
		RULE_functionCall = 34, RULE_argument = 35, RULE_element = 36, RULE_tag = 37, 
		RULE_openingTag = 38, RULE_closingTag = 39, RULE_selfClosingTag = 40, 
		RULE_attributes = 41, RULE_interpolation = 42, RULE_cssBody = 43, RULE_cssObjects = 44, 
		RULE_csselement = 45, RULE_bodyelement = 46, RULE_cssValue = 47;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "assignmentStatement", "componentDeclaration", 
			"componentDeclarationBody", "selector", "standalone", "template", "styles", 
			"importDeclaration", "componentBodyElement", "isboolean", "classDeclaration", 
			"classDeclarationBody", "classMember", "propertyDeclaration", "methodDeclaration", 
			"methodBody", "statementMethod", "returnStatment", "interfaceDeclaration", 
			"interfaceMember", "parameter", "parameterList", "variableDeclaration", 
			"type", "memberAccess", "list", "bodylist", "object", "bodyobject", "initvalue", 
			"expression", "operator", "functionCall", "argument", "element", "tag", 
			"openingTag", "closingTag", "selfClosingTag", "attributes", "interpolation", 
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
			setState(97); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(96);
				statement();
				}
				}
				setState(99); 
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
			setState(109);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new ComponentStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(101);
				componentDeclaration();
				}
				break;
			case 2:
				_localctx = new ClassStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(102);
				classDeclaration();
				}
				break;
			case 3:
				_localctx = new InterfaceStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(103);
				interfaceDeclaration();
				}
				break;
			case 4:
				_localctx = new VariableDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(104);
				variableDeclaration();
				}
				break;
			case 5:
				_localctx = new AssignmentStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(105);
				assignmentStatement();
				}
				break;
			case 6:
				_localctx = new FunctionCallStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(106);
				functionCall();
				}
				break;
			case 7:
				_localctx = new MethodStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(107);
				methodDeclaration();
				}
				break;
			case 8:
				_localctx = new ImportStmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(108);
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
			setState(111);
			match(ID);
			setState(112);
			match(ASSIGN);
			setState(113);
			expression(0);
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(114);
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
			setState(117);
			match(DECORATOR);
			setState(118);
			match(COMPONENT);
			setState(119);
			match(LPAREN);
			setState(120);
			match(LBRACE);
			setState(121);
			componentDeclarationBody();
			setState(122);
			match(RBRACE);
			setState(123);
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
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 520224768L) != 0)) {
				{
				setState(125);
				componentBodyElement();
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(126);
					match(COMMA);
					setState(127);
					componentBodyElement();
					}
					}
					setState(132);
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
			setState(135);
			match(SELECTOR);
			setState(136);
			match(COLON);
			setState(137);
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
			setState(139);
			match(STANDALONE);
			setState(140);
			match(COLON);
			setState(141);
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
			setState(143);
			match(TEMPLATE);
			setState(144);
			match(COLON_HTML);
			setState(145);
			match(BACKTICK_HTML);
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & 18433L) != 0)) {
				{
				{
				setState(146);
				element();
				}
				}
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(152);
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
			setState(154);
			match(STYLES);
			setState(155);
			match(COLON_CSS);
			setState(156);
			match(OPEN_LIST);
			setState(157);
			cssBody();
			setState(158);
			match(CLOSE_LIST);
			setState(160);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(159);
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
			setState(183);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new StandardImportDeclContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(162);
				match(IMPORT);
				setState(163);
				match(LBRACE);
				setState(164);
				match(ID);
				setState(165);
				match(RBRACE);
				setState(166);
				match(FROM);
				setState(167);
				match(STRING_LIT);
				setState(168);
				match(SEMICOLON);
				}
				break;
			case 2:
				_localctx = new ComponentImportDeclContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(169);
				match(IMPORT);
				setState(170);
				match(LBRACE);
				setState(171);
				match(COMPONENT);
				setState(172);
				match(RBRACE);
				setState(173);
				match(FROM);
				setState(174);
				match(STRING_LIT);
				setState(175);
				match(SEMICOLON);
				}
				break;
			case 3:
				_localctx = new ImportArrayDeclContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(176);
				match(IMPORTS);
				setState(177);
				match(COLON);
				setState(178);
				match(LBRACKET);
				setState(180);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(179);
					match(ID);
					}
				}

				setState(182);
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
			setState(190);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SELECTOR:
				_localctx = new ComponentSelectorContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(185);
				selector();
				}
				break;
			case STANDALONE:
				_localctx = new ComponentStandaloneContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(186);
				standalone();
				}
				break;
			case IMPORT:
			case IMPORTS:
				_localctx = new ComponentImportElementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(187);
				importDeclaration();
				}
				break;
			case TEMPLATE:
				_localctx = new ComponentTemplateContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(188);
				template();
				}
				break;
			case STYLES:
				_localctx = new ComponentStylesContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(189);
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
			setState(194);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
				_localctx = new TrueBooleanContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(192);
				match(TRUE);
				}
				break;
			case FALSE:
				_localctx = new FalseBooleanContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(193);
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
			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXPORT) {
				{
				setState(196);
				match(EXPORT);
				}
			}

			setState(199);
			match(CLASS);
			setState(200);
			match(ID);
			setState(201);
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
			setState(203);
			match(LBRACE);
			setState(210);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 36028797019258880L) != 0)) {
				{
				{
				setState(204);
				classMember();
				setState(206);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(205);
					match(SEMICOLON);
					}
				}

				}
				}
				setState(212);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(213);
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
			setState(218);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new ClassMethodMemberContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(215);
				methodDeclaration();
				}
				break;
			case 2:
				_localctx = new ClassPropertyMemberContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(216);
				propertyDeclaration();
				}
				break;
			case 3:
				_localctx = new NestedClassMemberContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(217);
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
			setState(240);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				_localctx = new PropertyWithInitContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(220);
				match(ID);
				setState(221);
				match(COLON);
				setState(222);
				type();
				setState(223);
				match(ASSIGN);
				setState(224);
				initvalue();
				setState(226);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(225);
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
				setState(228);
				match(ID);
				setState(229);
				match(COLON);
				setState(230);
				type();
				setState(235);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OR) {
					{
					setState(231);
					match(OR);
					setState(232);
					match(ID);
					setState(233);
					match(ASSIGN);
					setState(234);
					match(ID);
					}
				}

				setState(238);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(237);
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
			setState(242);
			match(ID);
			setState(243);
			match(LPAREN);
			setState(245);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(244);
				parameterList();
				}
			}

			setState(247);
			match(RPAREN);
			setState(248);
			match(COLON);
			setState(250);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 36028813661962240L) != 0)) {
				{
				setState(249);
				type();
				}
			}

			setState(252);
			match(LBRACE);
			setState(253);
			methodBody();
			setState(254);
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
			setState(259);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 279786676609876224L) != 0)) {
				{
				{
				setState(256);
				statementMethod();
				}
				}
				setState(261);
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
			setState(284);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				_localctx = new MethodAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(262);
				match(ID);
				setState(263);
				match(ASSIGN);
				setState(264);
				expression(0);
				setState(265);
				match(SEMICOLON);
				setState(267);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(266);
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
				setState(269);
				match(THIS);
				setState(270);
				match(DOT);
				setState(271);
				match(ID);
				setState(272);
				match(ASSIGN);
				setState(273);
				expression(0);
				setState(274);
				match(SEMICOLON);
				setState(276);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(275);
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
				setState(278);
				expression(0);
				setState(279);
				match(SEMICOLON);
				setState(281);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(280);
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
				setState(283);
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
			setState(299);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				_localctx = new ReturnExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(286);
				match(RETURN);
				setState(287);
				expression(0);
				setState(288);
				match(SEMICOLON);
				}
				break;
			case 2:
				_localctx = new ReturnIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(290);
				match(RETURN);
				setState(291);
				match(ID);
				setState(292);
				match(SEMICOLON);
				}
				break;
			case 3:
				_localctx = new ReturnBooleanContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(293);
				match(RETURN);
				setState(294);
				isboolean();
				setState(295);
				match(SEMICOLON);
				}
				break;
			case 4:
				_localctx = new ReturnVoidContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(297);
				match(RETURN);
				setState(298);
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
			setState(301);
			match(INTERFACE);
			setState(302);
			match(ID);
			setState(303);
			match(LBRACE);
			setState(307);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(304);
				interfaceMember();
				}
				}
				setState(309);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(310);
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
			setState(314);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				_localctx = new InterfacePropertyMemberContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(312);
				propertyDeclaration();
				}
				break;
			case 2:
				_localctx = new InterfaceMethodMemberContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(313);
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
			setState(316);
			match(ID);
			setState(317);
			match(COLON);
			setState(318);
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
			setState(320);
			parameter();
			setState(325);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(321);
				match(COMMA);
				setState(322);
				parameter();
				}
				}
				setState(327);
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
			setState(346);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONST:
				_localctx = new ConstDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(328);
				match(CONST);
				setState(329);
				match(ID);
				setState(332);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
				case 1:
					{
					setState(330);
					match(ASSIGN);
					setState(331);
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
				setState(334);
				match(LET);
				setState(335);
				match(ID);
				setState(338);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
				case 1:
					{
					setState(336);
					match(ASSIGN);
					setState(337);
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
				setState(340);
				match(VAR);
				setState(341);
				match(ID);
				setState(344);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
				case 1:
					{
					setState(342);
					match(ASSIGN);
					setState(343);
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
			setState(355);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				_localctx = new StringTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(348);
				match(STRING_TYPE);
				}
				break;
			case 2:
				_localctx = new NumberTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(349);
				match(NUMBER_TYPE);
				}
				break;
			case 3:
				_localctx = new BooleanTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(350);
				match(BOOLEAN_TYPE);
				}
				break;
			case 4:
				_localctx = new AnyTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(351);
				match(ANY_TYPE);
				}
				break;
			case 5:
				_localctx = new VoidTypeContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(352);
				match(VOID_TYPE);
				}
				break;
			case 6:
				_localctx = new IdTypeContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(353);
				match(ID);
				}
				break;
			case 7:
				_localctx = new ListTypeContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(354);
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
			setState(361);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case THIS:
				_localctx = new ThisMemberAccessContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(357);
				match(THIS);
				setState(358);
				match(DOT);
				setState(359);
				match(ID);
				}
				break;
			case ID:
				_localctx = new SimpleMemberAccessContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(360);
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
			setState(363);
			match(ID);
			setState(364);
			match(LBRACKET);
			setState(365);
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
			setState(375);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 51)) & ~0x3f) == 0 && ((1L << (_la - 51)) & 8301L) != 0)) {
				{
				setState(367);
				initvalue();
				setState(372);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(368);
					match(COMMA);
					setState(369);
					initvalue();
					}
					}
					setState(374);
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
			setState(377);
			match(LBRACE);
			setState(378);
			bodyobject();
			setState(379);
			match(RBRACE);
			setState(381);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				setState(380);
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
		public List<TerminalNode> ID() { return getTokens(typescriptparser.ID); }
		public TerminalNode ID(int i) {
			return getToken(typescriptparser.ID, i);
		}
		public List<TerminalNode> COLON() { return getTokens(typescriptparser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(typescriptparser.COLON, i);
		}
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
			int _alt;
			_localctx = new ObjectBodyRuleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(398);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(383);
				match(ID);
				setState(384);
				match(COLON);
				setState(385);
				initvalue();
				setState(392);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(386);
						match(COMMA);
						setState(387);
						match(ID);
						setState(388);
						match(COLON);
						setState(389);
						initvalue();
						}
						} 
					}
					setState(394);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
				}
				setState(396);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(395);
					match(COMMA);
					}
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
		enterRule(_localctx, 62, RULE_initvalue);
		try {
			setState(408);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER_LIT:
				_localctx = new NumberInitValueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(400);
				match(NUMBER_LIT);
				}
				break;
			case STRING_LIT:
				_localctx = new StringInitValueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(401);
				match(STRING_LIT);
				}
				break;
			case TRUE:
			case FALSE:
				_localctx = new BooleanInitValueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(402);
				isboolean();
				}
				break;
			case LBRACKET:
				_localctx = new ListInitValueContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(403);
				match(LBRACKET);
				setState(404);
				bodylist();
				setState(405);
				match(RBRACKET);
				}
				break;
			case LBRACE:
				_localctx = new ObjectInitValueContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(407);
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
		int _startState = 64;
		enterRecursionRule(_localctx, 64, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(422);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				{
				_localctx = new StringLiteralExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(411);
				match(STRING_LIT);
				}
				break;
			case 2:
				{
				_localctx = new NumberLiteralExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(412);
				match(NUMBER_LIT);
				}
				break;
			case 3:
				{
				_localctx = new IdentifierExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(413);
				match(ID);
				}
				break;
			case 4:
				{
				_localctx = new BooleanLiteralExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(414);
				isboolean();
				}
				break;
			case 5:
				{
				_localctx = new FunctionCallExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(415);
				functionCall();
				}
				break;
			case 6:
				{
				_localctx = new VariableDeclarationExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(416);
				variableDeclaration();
				}
				break;
			case 7:
				{
				_localctx = new MemberAccessExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(417);
				memberAccess();
				}
				break;
			case 8:
				{
				_localctx = new ParenthesizedExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(418);
				match(LPAREN);
				setState(419);
				expression(0);
				setState(420);
				match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(430);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_expression);
					setState(424);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(425);
					operator();
					setState(426);
					expression(3);
					}
					} 
				}
				setState(432);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
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
		enterRule(_localctx, 66, RULE_operator);
		try {
			setState(437);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
				_localctx = new PlusOpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(433);
				match(PLUS);
				}
				break;
			case MINUS:
				_localctx = new MinusOpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(434);
				match(MINUS);
				}
				break;
			case STAR:
				_localctx = new StarOpContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(435);
				match(STAR);
				}
				break;
			case SLASH:
				_localctx = new SlashOpContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(436);
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
		enterRule(_localctx, 68, RULE_functionCall);
		int _la;
		try {
			_localctx = new StandardFunctionCallContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(439);
			match(ID);
			setState(440);
			match(LPAREN);
			setState(444);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 279786676609875968L) != 0)) {
				{
				{
				setState(441);
				argument();
				}
				}
				setState(446);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(447);
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
		enterRule(_localctx, 70, RULE_argument);
		try {
			_localctx = new ExpressionArgumentContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(449);
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
		enterRule(_localctx, 72, RULE_element);
		int _la;
		try {
			setState(457);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TAG_OPEN_START_HTML:
				_localctx = new TagElementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(451);
				tag();
				}
				break;
			case NAME_HTML:
				_localctx = new HtmlNameElementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(452);
				match(NAME_HTML);
				setState(454);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLON_HTML) {
					{
					setState(453);
					match(COLON_HTML);
					}
				}

				}
				break;
			case INTERPOLATION_START_HTML:
				_localctx = new InterpolationElementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(456);
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
		enterRule(_localctx, 74, RULE_tag);
		int _la;
		try {
			setState(469);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				_localctx = new OpenCloseTagContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(459);
				openingTag();
				setState(463);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & 18433L) != 0)) {
					{
					{
					setState(460);
					element();
					}
					}
					setState(465);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(466);
				closingTag();
				}
				break;
			case 2:
				_localctx = new SelfClosingTagElementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(468);
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
		enterRule(_localctx, 76, RULE_openingTag);
		int _la;
		try {
			_localctx = new OpeningTagRuleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(471);
			match(TAG_OPEN_START_HTML);
			setState(475);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & 263L) != 0)) {
				{
				{
				setState(472);
				attributes();
				}
				}
				setState(477);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(478);
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
		enterRule(_localctx, 78, RULE_closingTag);
		try {
			_localctx = new ClosingTagRuleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(480);
			match(TAG_CLOSE_START_HTML);
			setState(481);
			match(NAME_HTML);
			setState(482);
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
		enterRule(_localctx, 80, RULE_selfClosingTag);
		int _la;
		try {
			_localctx = new SelfClosingTagRuleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(484);
			match(TAG_OPEN_START_HTML);
			setState(488);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & 263L) != 0)) {
				{
				{
				setState(485);
				attributes();
				}
				}
				setState(490);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(491);
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
		enterRule(_localctx, 82, RULE_attributes);
		try {
			setState(505);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME_HTML:
				_localctx = new HtmlAttributeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(493);
				match(NAME_HTML);
				setState(494);
				match(ATTRIBUTE_EQUALS_HTML);
				setState(495);
				match(STRING_HTML);
				}
				break;
			case STRUCTURAL_DIR_HTML:
				_localctx = new StructuralDirectiveAttributeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(496);
				match(STRUCTURAL_DIR_HTML);
				setState(497);
				match(ATTRIBUTE_EQUALS_HTML);
				setState(498);
				match(STRING_HTML);
				}
				break;
			case BINDING_HTML:
				_localctx = new BindingAttributeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(499);
				match(BINDING_HTML);
				setState(500);
				match(ATTRIBUTE_EQUALS_HTML);
				setState(501);
				match(STRING_HTML);
				}
				break;
			case EVENT_BINDING_HTML:
				_localctx = new EventBindingAttributeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(502);
				match(EVENT_BINDING_HTML);
				setState(503);
				match(ATTRIBUTE_EQUALS_HTML);
				setState(504);
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
		enterRule(_localctx, 84, RULE_interpolation);
		try {
			_localctx = new InterpolationRuleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(507);
			match(INTERPOLATION_START_HTML);
			setState(508);
			match(NAME_HTML);
			setState(509);
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
		enterRule(_localctx, 86, RULE_cssBody);
		int _la;
		try {
			_localctx = new CssBodyRuleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(511);
			match(BACKTICK_CSS);
			setState(512);
			cssObjects();
			setState(513);
			match(BACKTICK_CSS);
			setState(515);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA_CSS) {
				{
				setState(514);
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
		enterRule(_localctx, 88, RULE_cssObjects);
		int _la;
		try {
			_localctx = new CssObjectsRuleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(518);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				{
				setState(517);
				csselement();
				}
				break;
			}
			setState(526);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA_CSS || _la==DOT_CSS) {
				{
				{
				setState(521);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA_CSS) {
					{
					setState(520);
					match(COMMA_CSS);
					}
				}

				setState(523);
				csselement();
				}
				}
				setState(528);
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
		enterRule(_localctx, 90, RULE_csselement);
		int _la;
		try {
			_localctx = new CssElementRuleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(529);
			match(DOT_CSS);
			setState(531); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(530);
				match(ID_CSS);
				}
				}
				setState(533); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID_CSS );
			setState(535);
			match(LBRACE_CSS);
			setState(537); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(536);
				bodyelement();
				}
				}
				setState(539); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID_CSS );
			setState(541);
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
		enterRule(_localctx, 92, RULE_bodyelement);
		try {
			_localctx = new CssDeclarationContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(543);
			match(ID_CSS);
			setState(544);
			match(COLON_CSS);
			setState(545);
			cssValue();
			setState(546);
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
		enterRule(_localctx, 94, RULE_cssValue);
		int _la;
		try {
			setState(562);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PERCENT:
				_localctx = new PercentValueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(548);
				match(PERCENT);
				setState(553);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID_CSS) {
					{
					setState(549);
					match(ID_CSS);
					setState(551);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ID_CSS) {
						{
						setState(550);
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
				setState(555);
				match(ID_CSS);
				setState(560);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID_CSS) {
					{
					setState(556);
					match(ID_CSS);
					setState(558);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ID_CSS) {
						{
						setState(557);
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
		case 32:
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
		"\u0004\u0001h\u0235\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"-\u0007-\u0002.\u0007.\u0002/\u0007/\u0001\u0000\u0004\u0000b\b\u0000"+
		"\u000b\u0000\f\u0000c\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001n\b\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002t\b\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004"+
		"\u0081\b\u0004\n\u0004\f\u0004\u0084\t\u0004\u0003\u0004\u0086\b\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0005\u0007\u0094\b\u0007\n\u0007\f\u0007\u0097\t\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00a1\b"+
		"\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0003\t\u00b5\b\t\u0001\t\u0003\t\u00b8\b\t\u0001\n\u0001\n\u0001\n"+
		"\u0001\n\u0001\n\u0003\n\u00bf\b\n\u0001\u000b\u0001\u000b\u0003\u000b"+
		"\u00c3\b\u000b\u0001\f\u0003\f\u00c6\b\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\r\u0003\r\u00cf\b\r\u0005\r\u00d1\b\r\n\r\f\r"+
		"\u00d4\t\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e"+
		"\u00db\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0003\u000f\u00e3\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u00ec\b\u000f"+
		"\u0001\u000f\u0003\u000f\u00ef\b\u000f\u0003\u000f\u00f1\b\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u00f6\b\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0003\u0010\u00fb\b\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0011\u0005\u0011\u0102\b\u0011\n\u0011\f\u0011"+
		"\u0105\t\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0003\u0012\u010c\b\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u0115\b\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0003\u0012\u011a\b\u0012\u0001\u0012\u0003\u0012"+
		"\u011d\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0003\u0013\u012c\b\u0013\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0005\u0014\u0132\b\u0014\n\u0014\f\u0014\u0135"+
		"\t\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0003\u0015\u013b"+
		"\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0005\u0017\u0144\b\u0017\n\u0017\f\u0017\u0147\t\u0017"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u014d\b\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u0153\b\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u0159\b\u0018"+
		"\u0003\u0018\u015b\b\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u0164\b\u0019\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u016a\b\u001a\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0005\u001c\u0173\b\u001c\n\u001c\f\u001c\u0176\t\u001c\u0003\u001c\u0178"+
		"\b\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0003\u001d\u017e"+
		"\b\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0005\u001e\u0187\b\u001e\n\u001e\f\u001e\u018a\t\u001e"+
		"\u0001\u001e\u0003\u001e\u018d\b\u001e\u0003\u001e\u018f\b\u001e\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0003\u001f\u0199\b\u001f\u0001 \u0001 \u0001 \u0001"+
		" \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0003 \u01a7"+
		"\b \u0001 \u0001 \u0001 \u0001 \u0005 \u01ad\b \n \f \u01b0\t \u0001!"+
		"\u0001!\u0001!\u0001!\u0003!\u01b6\b!\u0001\"\u0001\"\u0001\"\u0005\""+
		"\u01bb\b\"\n\"\f\"\u01be\t\"\u0001\"\u0001\"\u0001#\u0001#\u0001$\u0001"+
		"$\u0001$\u0003$\u01c7\b$\u0001$\u0003$\u01ca\b$\u0001%\u0001%\u0005%\u01ce"+
		"\b%\n%\f%\u01d1\t%\u0001%\u0001%\u0001%\u0003%\u01d6\b%\u0001&\u0001&"+
		"\u0005&\u01da\b&\n&\f&\u01dd\t&\u0001&\u0001&\u0001\'\u0001\'\u0001\'"+
		"\u0001\'\u0001(\u0001(\u0005(\u01e7\b(\n(\f(\u01ea\t(\u0001(\u0001(\u0001"+
		")\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001"+
		")\u0001)\u0003)\u01fa\b)\u0001*\u0001*\u0001*\u0001*\u0001+\u0001+\u0001"+
		"+\u0001+\u0003+\u0204\b+\u0001,\u0003,\u0207\b,\u0001,\u0003,\u020a\b"+
		",\u0001,\u0005,\u020d\b,\n,\f,\u0210\t,\u0001-\u0001-\u0004-\u0214\b-"+
		"\u000b-\f-\u0215\u0001-\u0001-\u0004-\u021a\b-\u000b-\f-\u021b\u0001-"+
		"\u0001-\u0001.\u0001.\u0001.\u0001.\u0001.\u0001/\u0001/\u0001/\u0003"+
		"/\u0228\b/\u0003/\u022a\b/\u0001/\u0001/\u0001/\u0003/\u022f\b/\u0003"+
		"/\u0231\b/\u0003/\u0233\b/\u0001/\u0000\u0001@0\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,."+
		"02468:<>@BDFHJLNPRTVXZ\\^\u0000\u0000\u0268\u0000a\u0001\u0000\u0000\u0000"+
		"\u0002m\u0001\u0000\u0000\u0000\u0004o\u0001\u0000\u0000\u0000\u0006u"+
		"\u0001\u0000\u0000\u0000\b\u0085\u0001\u0000\u0000\u0000\n\u0087\u0001"+
		"\u0000\u0000\u0000\f\u008b\u0001\u0000\u0000\u0000\u000e\u008f\u0001\u0000"+
		"\u0000\u0000\u0010\u009a\u0001\u0000\u0000\u0000\u0012\u00b7\u0001\u0000"+
		"\u0000\u0000\u0014\u00be\u0001\u0000\u0000\u0000\u0016\u00c2\u0001\u0000"+
		"\u0000\u0000\u0018\u00c5\u0001\u0000\u0000\u0000\u001a\u00cb\u0001\u0000"+
		"\u0000\u0000\u001c\u00da\u0001\u0000\u0000\u0000\u001e\u00f0\u0001\u0000"+
		"\u0000\u0000 \u00f2\u0001\u0000\u0000\u0000\"\u0103\u0001\u0000\u0000"+
		"\u0000$\u011c\u0001\u0000\u0000\u0000&\u012b\u0001\u0000\u0000\u0000("+
		"\u012d\u0001\u0000\u0000\u0000*\u013a\u0001\u0000\u0000\u0000,\u013c\u0001"+
		"\u0000\u0000\u0000.\u0140\u0001\u0000\u0000\u00000\u015a\u0001\u0000\u0000"+
		"\u00002\u0163\u0001\u0000\u0000\u00004\u0169\u0001\u0000\u0000\u00006"+
		"\u016b\u0001\u0000\u0000\u00008\u0177\u0001\u0000\u0000\u0000:\u0179\u0001"+
		"\u0000\u0000\u0000<\u018e\u0001\u0000\u0000\u0000>\u0198\u0001\u0000\u0000"+
		"\u0000@\u01a6\u0001\u0000\u0000\u0000B\u01b5\u0001\u0000\u0000\u0000D"+
		"\u01b7\u0001\u0000\u0000\u0000F\u01c1\u0001\u0000\u0000\u0000H\u01c9\u0001"+
		"\u0000\u0000\u0000J\u01d5\u0001\u0000\u0000\u0000L\u01d7\u0001\u0000\u0000"+
		"\u0000N\u01e0\u0001\u0000\u0000\u0000P\u01e4\u0001\u0000\u0000\u0000R"+
		"\u01f9\u0001\u0000\u0000\u0000T\u01fb\u0001\u0000\u0000\u0000V\u01ff\u0001"+
		"\u0000\u0000\u0000X\u0206\u0001\u0000\u0000\u0000Z\u0211\u0001\u0000\u0000"+
		"\u0000\\\u021f\u0001\u0000\u0000\u0000^\u0232\u0001\u0000\u0000\u0000"+
		"`b\u0003\u0002\u0001\u0000a`\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000"+
		"\u0000ca\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000d\u0001\u0001"+
		"\u0000\u0000\u0000en\u0003\u0006\u0003\u0000fn\u0003\u0018\f\u0000gn\u0003"+
		"(\u0014\u0000hn\u00030\u0018\u0000in\u0003\u0004\u0002\u0000jn\u0003D"+
		"\"\u0000kn\u0003 \u0010\u0000ln\u0003\u0012\t\u0000me\u0001\u0000\u0000"+
		"\u0000mf\u0001\u0000\u0000\u0000mg\u0001\u0000\u0000\u0000mh\u0001\u0000"+
		"\u0000\u0000mi\u0001\u0000\u0000\u0000mj\u0001\u0000\u0000\u0000mk\u0001"+
		"\u0000\u0000\u0000ml\u0001\u0000\u0000\u0000n\u0003\u0001\u0000\u0000"+
		"\u0000op\u00057\u0000\u0000pq\u0005(\u0000\u0000qs\u0003@ \u0000rt\u0005"+
		"%\u0000\u0000sr\u0001\u0000\u0000\u0000st\u0001\u0000\u0000\u0000t\u0005"+
		"\u0001\u0000\u0000\u0000uv\u0005=\u0000\u0000vw\u0005\u0017\u0000\u0000"+
		"wx\u00051\u0000\u0000xy\u00053\u0000\u0000yz\u0003\b\u0004\u0000z{\u0005"+
		"4\u0000\u0000{|\u00052\u0000\u0000|\u0007\u0001\u0000\u0000\u0000}\u0082"+
		"\u0003\u0014\n\u0000~\u007f\u0005\"\u0000\u0000\u007f\u0081\u0003\u0014"+
		"\n\u0000\u0080~\u0001\u0000\u0000\u0000\u0081\u0084\u0001\u0000\u0000"+
		"\u0000\u0082\u0080\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000"+
		"\u0000\u0083\u0086\u0001\u0000\u0000\u0000\u0084\u0082\u0001\u0000\u0000"+
		"\u0000\u0085}\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000"+
		"\u0086\t\u0001\u0000\u0000\u0000\u0087\u0088\u0005\u0018\u0000\u0000\u0088"+
		"\u0089\u0005#\u0000\u0000\u0089\u008a\u00058\u0000\u0000\u008a\u000b\u0001"+
		"\u0000\u0000\u0000\u008b\u008c\u0005\u0019\u0000\u0000\u008c\u008d\u0005"+
		"#\u0000\u0000\u008d\u008e\u0003\u0016\u000b\u0000\u008e\r\u0001\u0000"+
		"\u0000\u0000\u008f\u0090\u0005\u001b\u0000\u0000\u0090\u0091\u0005P\u0000"+
		"\u0000\u0091\u0095\u0005W\u0000\u0000\u0092\u0094\u0003H$\u0000\u0093"+
		"\u0092\u0001\u0000\u0000\u0000\u0094\u0097\u0001\u0000\u0000\u0000\u0095"+
		"\u0093\u0001\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000\u0000\u0096"+
		"\u0098\u0001\u0000\u0000\u0000\u0097\u0095\u0001\u0000\u0000\u0000\u0098"+
		"\u0099\u0005V\u0000\u0000\u0099\u000f\u0001\u0000\u0000\u0000\u009a\u009b"+
		"\u0005\u001c\u0000\u0000\u009b\u009c\u0005Y\u0000\u0000\u009c\u009d\u0005"+
		"[\u0000\u0000\u009d\u009e\u0003V+\u0000\u009e\u00a0\u0005\\\u0000\u0000"+
		"\u009f\u00a1\u0005\"\u0000\u0000\u00a0\u009f\u0001\u0000\u0000\u0000\u00a0"+
		"\u00a1\u0001\u0000\u0000\u0000\u00a1\u0011\u0001\u0000\u0000\u0000\u00a2"+
		"\u00a3\u0005\u0011\u0000\u0000\u00a3\u00a4\u00053\u0000\u0000\u00a4\u00a5"+
		"\u00057\u0000\u0000\u00a5\u00a6\u00054\u0000\u0000\u00a6\u00a7\u0005\u0016"+
		"\u0000\u0000\u00a7\u00a8\u00058\u0000\u0000\u00a8\u00b8\u0005%\u0000\u0000"+
		"\u00a9\u00aa\u0005\u0011\u0000\u0000\u00aa\u00ab\u00053\u0000\u0000\u00ab"+
		"\u00ac\u0005\u0017\u0000\u0000\u00ac\u00ad\u00054\u0000\u0000\u00ad\u00ae"+
		"\u0005\u0016\u0000\u0000\u00ae\u00af\u00058\u0000\u0000\u00af\u00b8\u0005"+
		"%\u0000\u0000\u00b0\u00b1\u0005\u001a\u0000\u0000\u00b1\u00b2\u0005#\u0000"+
		"\u0000\u00b2\u00b4\u0005@\u0000\u0000\u00b3\u00b5\u00057\u0000\u0000\u00b4"+
		"\u00b3\u0001\u0000\u0000\u0000\u00b4\u00b5\u0001\u0000\u0000\u0000\u00b5"+
		"\u00b6\u0001\u0000\u0000\u0000\u00b6\u00b8\u0005A\u0000\u0000\u00b7\u00a2"+
		"\u0001\u0000\u0000\u0000\u00b7\u00a9\u0001\u0000\u0000\u0000\u00b7\u00b0"+
		"\u0001\u0000\u0000\u0000\u00b8\u0013\u0001\u0000\u0000\u0000\u00b9\u00bf"+
		"\u0003\n\u0005\u0000\u00ba\u00bf\u0003\f\u0006\u0000\u00bb\u00bf\u0003"+
		"\u0012\t\u0000\u00bc\u00bf\u0003\u000e\u0007\u0000\u00bd\u00bf\u0003\u0010"+
		"\b\u0000\u00be\u00b9\u0001\u0000\u0000\u0000\u00be\u00ba\u0001\u0000\u0000"+
		"\u0000\u00be\u00bb\u0001\u0000\u0000\u0000\u00be\u00bc\u0001\u0000\u0000"+
		"\u0000\u00be\u00bd\u0001\u0000\u0000\u0000\u00bf\u0015\u0001\u0000\u0000"+
		"\u0000\u00c0\u00c3\u00055\u0000\u0000\u00c1\u00c3\u00056\u0000\u0000\u00c2"+
		"\u00c0\u0001\u0000\u0000\u0000\u00c2\u00c1\u0001\u0000\u0000\u0000\u00c3"+
		"\u0017\u0001\u0000\u0000\u0000\u00c4\u00c6\u0005\u0012\u0000\u0000\u00c5"+
		"\u00c4\u0001\u0000\u0000\u0000\u00c5\u00c6\u0001\u0000\u0000\u0000\u00c6"+
		"\u00c7\u0001\u0000\u0000\u0000\u00c7\u00c8\u0005\u000f\u0000\u0000\u00c8"+
		"\u00c9\u00057\u0000\u0000\u00c9\u00ca\u0003\u001a\r\u0000\u00ca\u0019"+
		"\u0001\u0000\u0000\u0000\u00cb\u00d2\u00053\u0000\u0000\u00cc\u00ce\u0003"+
		"\u001c\u000e\u0000\u00cd\u00cf\u0005%\u0000\u0000\u00ce\u00cd\u0001\u0000"+
		"\u0000\u0000\u00ce\u00cf\u0001\u0000\u0000\u0000\u00cf\u00d1\u0001\u0000"+
		"\u0000\u0000\u00d0\u00cc\u0001\u0000\u0000\u0000\u00d1\u00d4\u0001\u0000"+
		"\u0000\u0000\u00d2\u00d0\u0001\u0000\u0000\u0000\u00d2\u00d3\u0001\u0000"+
		"\u0000\u0000\u00d3\u00d5\u0001\u0000\u0000\u0000\u00d4\u00d2\u0001\u0000"+
		"\u0000\u0000\u00d5\u00d6\u00054\u0000\u0000\u00d6\u001b\u0001\u0000\u0000"+
		"\u0000\u00d7\u00db\u0003 \u0010\u0000\u00d8\u00db\u0003\u001e\u000f\u0000"+
		"\u00d9\u00db\u0003\u0018\f\u0000\u00da\u00d7\u0001\u0000\u0000\u0000\u00da"+
		"\u00d8\u0001\u0000\u0000\u0000\u00da\u00d9\u0001\u0000\u0000\u0000\u00db"+
		"\u001d\u0001\u0000\u0000\u0000\u00dc\u00dd\u00057\u0000\u0000\u00dd\u00de"+
		"\u0005#\u0000\u0000\u00de\u00df\u00032\u0019\u0000\u00df\u00e0\u0005("+
		"\u0000\u0000\u00e0\u00e2\u0003>\u001f\u0000\u00e1\u00e3\u0005%\u0000\u0000"+
		"\u00e2\u00e1\u0001\u0000\u0000\u0000\u00e2\u00e3\u0001\u0000\u0000\u0000"+
		"\u00e3\u00f1\u0001\u0000\u0000\u0000\u00e4\u00e5\u00057\u0000\u0000\u00e5"+
		"\u00e6\u0005#\u0000\u0000\u00e6\u00eb\u00032\u0019\u0000\u00e7\u00e8\u0005"+
		"B\u0000\u0000\u00e8\u00e9\u00057\u0000\u0000\u00e9\u00ea\u0005(\u0000"+
		"\u0000\u00ea\u00ec\u00057\u0000\u0000\u00eb\u00e7\u0001\u0000\u0000\u0000"+
		"\u00eb\u00ec\u0001\u0000\u0000\u0000\u00ec\u00ee\u0001\u0000\u0000\u0000"+
		"\u00ed\u00ef\u0005%\u0000\u0000\u00ee\u00ed\u0001\u0000\u0000\u0000\u00ee"+
		"\u00ef\u0001\u0000\u0000\u0000\u00ef\u00f1\u0001\u0000\u0000\u0000\u00f0"+
		"\u00dc\u0001\u0000\u0000\u0000\u00f0\u00e4\u0001\u0000\u0000\u0000\u00f1"+
		"\u001f\u0001\u0000\u0000\u0000\u00f2\u00f3\u00057\u0000\u0000\u00f3\u00f5"+
		"\u00051\u0000\u0000\u00f4\u00f6\u0003.\u0017\u0000\u00f5\u00f4\u0001\u0000"+
		"\u0000\u0000\u00f5\u00f6\u0001\u0000\u0000\u0000\u00f6\u00f7\u0001\u0000"+
		"\u0000\u0000\u00f7\u00f8\u00052\u0000\u0000\u00f8\u00fa\u0005#\u0000\u0000"+
		"\u00f9\u00fb\u00032\u0019\u0000\u00fa\u00f9\u0001\u0000\u0000\u0000\u00fa"+
		"\u00fb\u0001\u0000\u0000\u0000\u00fb\u00fc\u0001\u0000\u0000\u0000\u00fc"+
		"\u00fd\u00053\u0000\u0000\u00fd\u00fe\u0003\"\u0011\u0000\u00fe\u00ff"+
		"\u00054\u0000\u0000\u00ff!\u0001\u0000\u0000\u0000\u0100\u0102\u0003$"+
		"\u0012\u0000\u0101\u0100\u0001\u0000\u0000\u0000\u0102\u0105\u0001\u0000"+
		"\u0000\u0000\u0103\u0101\u0001\u0000\u0000\u0000\u0103\u0104\u0001\u0000"+
		"\u0000\u0000\u0104#\u0001\u0000\u0000\u0000\u0105\u0103\u0001\u0000\u0000"+
		"\u0000\u0106\u0107\u00057\u0000\u0000\u0107\u0108\u0005(\u0000\u0000\u0108"+
		"\u0109\u0003@ \u0000\u0109\u010b\u0005%\u0000\u0000\u010a\u010c\u0003"+
		"&\u0013\u0000\u010b\u010a\u0001\u0000\u0000\u0000\u010b\u010c\u0001\u0000"+
		"\u0000\u0000\u010c\u011d\u0001\u0000\u0000\u0000\u010d\u010e\u0005\'\u0000"+
		"\u0000\u010e\u010f\u0005$\u0000\u0000\u010f\u0110\u00057\u0000\u0000\u0110"+
		"\u0111\u0005(\u0000\u0000\u0111\u0112\u0003@ \u0000\u0112\u0114\u0005"+
		"%\u0000\u0000\u0113\u0115\u0003&\u0013\u0000\u0114\u0113\u0001\u0000\u0000"+
		"\u0000\u0114\u0115\u0001\u0000\u0000\u0000\u0115\u011d\u0001\u0000\u0000"+
		"\u0000\u0116\u0117\u0003@ \u0000\u0117\u0119\u0005%\u0000\u0000\u0118"+
		"\u011a\u0003&\u0013\u0000\u0119\u0118\u0001\u0000\u0000\u0000\u0119\u011a"+
		"\u0001\u0000\u0000\u0000\u011a\u011d\u0001\u0000\u0000\u0000\u011b\u011d"+
		"\u0003&\u0013\u0000\u011c\u0106\u0001\u0000\u0000\u0000\u011c\u010d\u0001"+
		"\u0000\u0000\u0000\u011c\u0116\u0001\u0000\u0000\u0000\u011c\u011b\u0001"+
		"\u0000\u0000\u0000\u011d%\u0001\u0000\u0000\u0000\u011e\u011f\u0005\b"+
		"\u0000\u0000\u011f\u0120\u0003@ \u0000\u0120\u0121\u0005%\u0000\u0000"+
		"\u0121\u012c\u0001\u0000\u0000\u0000\u0122\u0123\u0005\b\u0000\u0000\u0123"+
		"\u0124\u00057\u0000\u0000\u0124\u012c\u0005%\u0000\u0000\u0125\u0126\u0005"+
		"\b\u0000\u0000\u0126\u0127\u0003\u0016\u000b\u0000\u0127\u0128\u0005%"+
		"\u0000\u0000\u0128\u012c\u0001\u0000\u0000\u0000\u0129\u012a\u0005\b\u0000"+
		"\u0000\u012a\u012c\u0005%\u0000\u0000\u012b\u011e\u0001\u0000\u0000\u0000"+
		"\u012b\u0122\u0001\u0000\u0000\u0000\u012b\u0125\u0001\u0000\u0000\u0000"+
		"\u012b\u0129\u0001\u0000\u0000\u0000\u012c\'\u0001\u0000\u0000\u0000\u012d"+
		"\u012e\u0005\u0010\u0000\u0000\u012e\u012f\u00057\u0000\u0000\u012f\u0133"+
		"\u00053\u0000\u0000\u0130\u0132\u0003*\u0015\u0000\u0131\u0130\u0001\u0000"+
		"\u0000\u0000\u0132\u0135\u0001\u0000\u0000\u0000\u0133\u0131\u0001\u0000"+
		"\u0000\u0000\u0133\u0134\u0001\u0000\u0000\u0000\u0134\u0136\u0001\u0000"+
		"\u0000\u0000\u0135\u0133\u0001\u0000\u0000\u0000\u0136\u0137\u00054\u0000"+
		"\u0000\u0137)\u0001\u0000\u0000\u0000\u0138\u013b\u0003\u001e\u000f\u0000"+
		"\u0139\u013b\u0003 \u0010\u0000\u013a\u0138\u0001\u0000\u0000\u0000\u013a"+
		"\u0139\u0001\u0000\u0000\u0000\u013b+\u0001\u0000\u0000\u0000\u013c\u013d"+
		"\u00057\u0000\u0000\u013d\u013e\u0005#\u0000\u0000\u013e\u013f\u00032"+
		"\u0019\u0000\u013f-\u0001\u0000\u0000\u0000\u0140\u0145\u0003,\u0016\u0000"+
		"\u0141\u0142\u0005\"\u0000\u0000\u0142\u0144\u0003,\u0016\u0000\u0143"+
		"\u0141\u0001\u0000\u0000\u0000\u0144\u0147\u0001\u0000\u0000\u0000\u0145"+
		"\u0143\u0001\u0000\u0000\u0000\u0145\u0146\u0001\u0000\u0000\u0000\u0146"+
		"/\u0001\u0000\u0000\u0000\u0147\u0145\u0001\u0000\u0000\u0000\u0148\u0149"+
		"\u0005\u0013\u0000\u0000\u0149\u014c\u00057\u0000\u0000\u014a\u014b\u0005"+
		"(\u0000\u0000\u014b\u014d\u0003@ \u0000\u014c\u014a\u0001\u0000\u0000"+
		"\u0000\u014c\u014d\u0001\u0000\u0000\u0000\u014d\u015b\u0001\u0000\u0000"+
		"\u0000\u014e\u014f\u0005\u0014\u0000\u0000\u014f\u0152\u00057\u0000\u0000"+
		"\u0150\u0151\u0005(\u0000\u0000\u0151\u0153\u0003@ \u0000\u0152\u0150"+
		"\u0001\u0000\u0000\u0000\u0152\u0153\u0001\u0000\u0000\u0000\u0153\u015b"+
		"\u0001\u0000\u0000\u0000\u0154\u0155\u0005\u0015\u0000\u0000\u0155\u0158"+
		"\u00057\u0000\u0000\u0156\u0157\u0005(\u0000\u0000\u0157\u0159\u0003@"+
		" \u0000\u0158\u0156\u0001\u0000\u0000\u0000\u0158\u0159\u0001\u0000\u0000"+
		"\u0000\u0159\u015b\u0001\u0000\u0000\u0000\u015a\u0148\u0001\u0000\u0000"+
		"\u0000\u015a\u014e\u0001\u0000\u0000\u0000\u015a\u0154\u0001\u0000\u0000"+
		"\u0000\u015b1\u0001\u0000\u0000\u0000\u015c\u0164\u0005\u001d\u0000\u0000"+
		"\u015d\u0164\u0005\u001e\u0000\u0000\u015e\u0164\u0005\u001f\u0000\u0000"+
		"\u015f\u0164\u0005 \u0000\u0000\u0160\u0164\u0005!\u0000\u0000\u0161\u0164"+
		"\u00057\u0000\u0000\u0162\u0164\u00036\u001b\u0000\u0163\u015c\u0001\u0000"+
		"\u0000\u0000\u0163\u015d\u0001\u0000\u0000\u0000\u0163\u015e\u0001\u0000"+
		"\u0000\u0000\u0163\u015f\u0001\u0000\u0000\u0000\u0163\u0160\u0001\u0000"+
		"\u0000\u0000\u0163\u0161\u0001\u0000\u0000\u0000\u0163\u0162\u0001\u0000"+
		"\u0000\u0000\u01643\u0001\u0000\u0000\u0000\u0165\u0166\u0005\'\u0000"+
		"\u0000\u0166\u0167\u0005$\u0000\u0000\u0167\u016a\u00057\u0000\u0000\u0168"+
		"\u016a\u00057\u0000\u0000\u0169\u0165\u0001\u0000\u0000\u0000\u0169\u0168"+
		"\u0001\u0000\u0000\u0000\u016a5\u0001\u0000\u0000\u0000\u016b\u016c\u0005"+
		"7\u0000\u0000\u016c\u016d\u0005@\u0000\u0000\u016d\u016e\u0005A\u0000"+
		"\u0000\u016e7\u0001\u0000\u0000\u0000\u016f\u0174\u0003>\u001f\u0000\u0170"+
		"\u0171\u0005\"\u0000\u0000\u0171\u0173\u0003>\u001f\u0000\u0172\u0170"+
		"\u0001\u0000\u0000\u0000\u0173\u0176\u0001\u0000\u0000\u0000\u0174\u0172"+
		"\u0001\u0000\u0000\u0000\u0174\u0175\u0001\u0000\u0000\u0000\u0175\u0178"+
		"\u0001\u0000\u0000\u0000\u0176\u0174\u0001\u0000\u0000\u0000\u0177\u016f"+
		"\u0001\u0000\u0000\u0000\u0177\u0178\u0001\u0000\u0000\u0000\u01789\u0001"+
		"\u0000\u0000\u0000\u0179\u017a\u00053\u0000\u0000\u017a\u017b\u0003<\u001e"+
		"\u0000\u017b\u017d\u00054\u0000\u0000\u017c\u017e\u0005\"\u0000\u0000"+
		"\u017d\u017c\u0001\u0000\u0000\u0000\u017d\u017e\u0001\u0000\u0000\u0000"+
		"\u017e;\u0001\u0000\u0000\u0000\u017f\u0180\u00057\u0000\u0000\u0180\u0181"+
		"\u0005#\u0000\u0000\u0181\u0188\u0003>\u001f\u0000\u0182\u0183\u0005\""+
		"\u0000\u0000\u0183\u0184\u00057\u0000\u0000\u0184\u0185\u0005#\u0000\u0000"+
		"\u0185\u0187\u0003>\u001f\u0000\u0186\u0182\u0001\u0000\u0000\u0000\u0187"+
		"\u018a\u0001\u0000\u0000\u0000\u0188\u0186\u0001\u0000\u0000\u0000\u0188"+
		"\u0189\u0001\u0000\u0000\u0000\u0189\u018c\u0001\u0000\u0000\u0000\u018a"+
		"\u0188\u0001\u0000\u0000\u0000\u018b\u018d\u0005\"\u0000\u0000\u018c\u018b"+
		"\u0001\u0000\u0000\u0000\u018c\u018d\u0001\u0000\u0000\u0000\u018d\u018f"+
		"\u0001\u0000\u0000\u0000\u018e\u017f\u0001\u0000\u0000\u0000\u018e\u018f"+
		"\u0001\u0000\u0000\u0000\u018f=\u0001\u0000\u0000\u0000\u0190\u0199\u0005"+
		"9\u0000\u0000\u0191\u0199\u00058\u0000\u0000\u0192\u0199\u0003\u0016\u000b"+
		"\u0000\u0193\u0194\u0005@\u0000\u0000\u0194\u0195\u00038\u001c\u0000\u0195"+
		"\u0196\u0005A\u0000\u0000\u0196\u0199\u0001\u0000\u0000\u0000\u0197\u0199"+
		"\u0003:\u001d\u0000\u0198\u0190\u0001\u0000\u0000\u0000\u0198\u0191\u0001"+
		"\u0000\u0000\u0000\u0198\u0192\u0001\u0000\u0000\u0000\u0198\u0193\u0001"+
		"\u0000\u0000\u0000\u0198\u0197\u0001\u0000\u0000\u0000\u0199?\u0001\u0000"+
		"\u0000\u0000\u019a\u019b\u0006 \uffff\uffff\u0000\u019b\u01a7\u00058\u0000"+
		"\u0000\u019c\u01a7\u00059\u0000\u0000\u019d\u01a7\u00057\u0000\u0000\u019e"+
		"\u01a7\u0003\u0016\u000b\u0000\u019f\u01a7\u0003D\"\u0000\u01a0\u01a7"+
		"\u00030\u0018\u0000\u01a1\u01a7\u00034\u001a\u0000\u01a2\u01a3\u00051"+
		"\u0000\u0000\u01a3\u01a4\u0003@ \u0000\u01a4\u01a5\u00052\u0000\u0000"+
		"\u01a5\u01a7\u0001\u0000\u0000\u0000\u01a6\u019a\u0001\u0000\u0000\u0000"+
		"\u01a6\u019c\u0001\u0000\u0000\u0000\u01a6\u019d\u0001\u0000\u0000\u0000"+
		"\u01a6\u019e\u0001\u0000\u0000\u0000\u01a6\u019f\u0001\u0000\u0000\u0000"+
		"\u01a6\u01a0\u0001\u0000\u0000\u0000\u01a6\u01a1\u0001\u0000\u0000\u0000"+
		"\u01a6\u01a2\u0001\u0000\u0000\u0000\u01a7\u01ae\u0001\u0000\u0000\u0000"+
		"\u01a8\u01a9\n\u0002\u0000\u0000\u01a9\u01aa\u0003B!\u0000\u01aa\u01ab"+
		"\u0003@ \u0003\u01ab\u01ad\u0001\u0000\u0000\u0000\u01ac\u01a8\u0001\u0000"+
		"\u0000\u0000\u01ad\u01b0\u0001\u0000\u0000\u0000\u01ae\u01ac\u0001\u0000"+
		"\u0000\u0000\u01ae\u01af\u0001\u0000\u0000\u0000\u01afA\u0001\u0000\u0000"+
		"\u0000\u01b0\u01ae\u0001\u0000\u0000\u0000\u01b1\u01b6\u0005)\u0000\u0000"+
		"\u01b2\u01b6\u0005*\u0000\u0000\u01b3\u01b6\u0005+\u0000\u0000\u01b4\u01b6"+
		"\u0005,\u0000\u0000\u01b5\u01b1\u0001\u0000\u0000\u0000\u01b5\u01b2\u0001"+
		"\u0000\u0000\u0000\u01b5\u01b3\u0001\u0000\u0000\u0000\u01b5\u01b4\u0001"+
		"\u0000\u0000\u0000\u01b6C\u0001\u0000\u0000\u0000\u01b7\u01b8\u00057\u0000"+
		"\u0000\u01b8\u01bc\u00051\u0000\u0000\u01b9\u01bb\u0003F#\u0000\u01ba"+
		"\u01b9\u0001\u0000\u0000\u0000\u01bb\u01be\u0001\u0000\u0000\u0000\u01bc"+
		"\u01ba\u0001\u0000\u0000\u0000\u01bc\u01bd\u0001\u0000\u0000\u0000\u01bd"+
		"\u01bf\u0001\u0000\u0000\u0000\u01be\u01bc\u0001\u0000\u0000\u0000\u01bf"+
		"\u01c0\u00052\u0000\u0000\u01c0E\u0001\u0000\u0000\u0000\u01c1\u01c2\u0003"+
		"@ \u0000\u01c2G\u0001\u0000\u0000\u0000\u01c3\u01ca\u0003J%\u0000\u01c4"+
		"\u01c6\u0005T\u0000\u0000\u01c5\u01c7\u0005P\u0000\u0000\u01c6\u01c5\u0001"+
		"\u0000\u0000\u0000\u01c6\u01c7\u0001\u0000\u0000\u0000\u01c7\u01ca\u0001"+
		"\u0000\u0000\u0000\u01c8\u01ca\u0003T*\u0000\u01c9\u01c3\u0001\u0000\u0000"+
		"\u0000\u01c9\u01c4\u0001\u0000\u0000\u0000\u01c9\u01c8\u0001\u0000\u0000"+
		"\u0000\u01caI\u0001\u0000\u0000\u0000\u01cb\u01cf\u0003L&\u0000\u01cc"+
		"\u01ce\u0003H$\u0000\u01cd\u01cc\u0001\u0000\u0000\u0000\u01ce\u01d1\u0001"+
		"\u0000\u0000\u0000\u01cf\u01cd\u0001\u0000\u0000\u0000\u01cf\u01d0\u0001"+
		"\u0000\u0000\u0000\u01d0\u01d2\u0001\u0000\u0000\u0000\u01d1\u01cf\u0001"+
		"\u0000\u0000\u0000\u01d2\u01d3\u0003N\'\u0000\u01d3\u01d6\u0001\u0000"+
		"\u0000\u0000\u01d4\u01d6\u0003P(\u0000\u01d5\u01cb\u0001\u0000\u0000\u0000"+
		"\u01d5\u01d4\u0001\u0000\u0000\u0000\u01d6K\u0001\u0000\u0000\u0000\u01d7"+
		"\u01db\u0005F\u0000\u0000\u01d8\u01da\u0003R)\u0000\u01d9\u01d8\u0001"+
		"\u0000\u0000\u0000\u01da\u01dd\u0001\u0000\u0000\u0000\u01db\u01d9\u0001"+
		"\u0000\u0000\u0000\u01db\u01dc\u0001\u0000\u0000\u0000\u01dc\u01de\u0001"+
		"\u0000\u0000\u0000\u01dd\u01db\u0001\u0000\u0000\u0000\u01de\u01df\u0005"+
		"H\u0000\u0000\u01dfM\u0001\u0000\u0000\u0000\u01e0\u01e1\u0005G\u0000"+
		"\u0000\u01e1\u01e2\u0005T\u0000\u0000\u01e2\u01e3\u0005H\u0000\u0000\u01e3"+
		"O\u0001\u0000\u0000\u0000\u01e4\u01e8\u0005F\u0000\u0000\u01e5\u01e7\u0003"+
		"R)\u0000\u01e6\u01e5\u0001\u0000\u0000\u0000\u01e7\u01ea\u0001\u0000\u0000"+
		"\u0000\u01e8\u01e6\u0001\u0000\u0000\u0000\u01e8\u01e9\u0001\u0000\u0000"+
		"\u0000\u01e9\u01eb\u0001\u0000\u0000\u0000\u01ea\u01e8\u0001\u0000\u0000"+
		"\u0000\u01eb\u01ec\u0005I\u0000\u0000\u01ecQ\u0001\u0000\u0000\u0000\u01ed"+
		"\u01ee\u0005T\u0000\u0000\u01ee\u01ef\u0005J\u0000\u0000\u01ef\u01fa\u0005"+
		"K\u0000\u0000\u01f0\u01f1\u0005L\u0000\u0000\u01f1\u01f2\u0005J\u0000"+
		"\u0000\u01f2\u01fa\u0005K\u0000\u0000\u01f3\u01f4\u0005M\u0000\u0000\u01f4"+
		"\u01f5\u0005J\u0000\u0000\u01f5\u01fa\u0005K\u0000\u0000\u01f6\u01f7\u0005"+
		"N\u0000\u0000\u01f7\u01f8\u0005J\u0000\u0000\u01f8\u01fa\u0005K\u0000"+
		"\u0000\u01f9\u01ed\u0001\u0000\u0000\u0000\u01f9\u01f0\u0001\u0000\u0000"+
		"\u0000\u01f9\u01f3\u0001\u0000\u0000\u0000\u01f9\u01f6\u0001\u0000\u0000"+
		"\u0000\u01faS\u0001\u0000\u0000\u0000\u01fb\u01fc\u0005Q\u0000\u0000\u01fc"+
		"\u01fd\u0005T\u0000\u0000\u01fd\u01fe\u0005R\u0000\u0000\u01feU\u0001"+
		"\u0000\u0000\u0000\u01ff\u0200\u0005X\u0000\u0000\u0200\u0201\u0003X,"+
		"\u0000\u0201\u0203\u0005X\u0000\u0000\u0202\u0204\u0005Z\u0000\u0000\u0203"+
		"\u0202\u0001\u0000\u0000\u0000\u0203\u0204\u0001\u0000\u0000\u0000\u0204"+
		"W\u0001\u0000\u0000\u0000\u0205\u0207\u0003Z-\u0000\u0206\u0205\u0001"+
		"\u0000\u0000\u0000\u0206\u0207\u0001\u0000\u0000\u0000\u0207\u020e\u0001"+
		"\u0000\u0000\u0000\u0208\u020a\u0005Z\u0000\u0000\u0209\u0208\u0001\u0000"+
		"\u0000\u0000\u0209\u020a\u0001\u0000\u0000\u0000\u020a\u020b\u0001\u0000"+
		"\u0000\u0000\u020b\u020d\u0003Z-\u0000\u020c\u0209\u0001\u0000\u0000\u0000"+
		"\u020d\u0210\u0001\u0000\u0000\u0000\u020e\u020c\u0001\u0000\u0000\u0000"+
		"\u020e\u020f\u0001\u0000\u0000\u0000\u020fY\u0001\u0000\u0000\u0000\u0210"+
		"\u020e\u0001\u0000\u0000\u0000\u0211\u0213\u0005]\u0000\u0000\u0212\u0214"+
		"\u0005h\u0000\u0000\u0213\u0212\u0001\u0000\u0000\u0000\u0214\u0215\u0001"+
		"\u0000\u0000\u0000\u0215\u0213\u0001\u0000\u0000\u0000\u0215\u0216\u0001"+
		"\u0000\u0000\u0000\u0216\u0217\u0001\u0000\u0000\u0000\u0217\u0219\u0005"+
		"_\u0000\u0000\u0218\u021a\u0003\\.\u0000\u0219\u0218\u0001\u0000\u0000"+
		"\u0000\u021a\u021b\u0001\u0000\u0000\u0000\u021b\u0219\u0001\u0000\u0000"+
		"\u0000\u021b\u021c\u0001\u0000\u0000\u0000\u021c\u021d\u0001\u0000\u0000"+
		"\u0000\u021d\u021e\u0005`\u0000\u0000\u021e[\u0001\u0000\u0000\u0000\u021f"+
		"\u0220\u0005h\u0000\u0000\u0220\u0221\u0005Y\u0000\u0000\u0221\u0222\u0003"+
		"^/\u0000\u0222\u0223\u0005^\u0000\u0000\u0223]\u0001\u0000\u0000\u0000"+
		"\u0224\u0229\u0005a\u0000\u0000\u0225\u0227\u0005h\u0000\u0000\u0226\u0228"+
		"\u0005h\u0000\u0000\u0227\u0226\u0001\u0000\u0000\u0000\u0227\u0228\u0001"+
		"\u0000\u0000\u0000\u0228\u022a\u0001\u0000\u0000\u0000\u0229\u0225\u0001"+
		"\u0000\u0000\u0000\u0229\u022a\u0001\u0000\u0000\u0000\u022a\u0233\u0001"+
		"\u0000\u0000\u0000\u022b\u0230\u0005h\u0000\u0000\u022c\u022e\u0005h\u0000"+
		"\u0000\u022d\u022f\u0005h\u0000\u0000\u022e\u022d\u0001\u0000\u0000\u0000"+
		"\u022e\u022f\u0001\u0000\u0000\u0000\u022f\u0231\u0001\u0000\u0000\u0000"+
		"\u0230\u022c\u0001\u0000\u0000\u0000\u0230\u0231\u0001\u0000\u0000\u0000"+
		"\u0231\u0233\u0001\u0000\u0000\u0000\u0232\u0224\u0001\u0000\u0000\u0000"+
		"\u0232\u022b\u0001\u0000\u0000\u0000\u0233_\u0001\u0000\u0000\u0000Ac"+
		"ms\u0082\u0085\u0095\u00a0\u00b4\u00b7\u00be\u00c2\u00c5\u00ce\u00d2\u00da"+
		"\u00e2\u00eb\u00ee\u00f0\u00f5\u00fa\u0103\u010b\u0114\u0119\u011c\u012b"+
		"\u0133\u013a\u0145\u014c\u0152\u0158\u015a\u0163\u0169\u0174\u0177\u017d"+
		"\u0188\u018c\u018e\u0198\u01a6\u01ae\u01b5\u01bc\u01c6\u01c9\u01cf\u01d5"+
		"\u01db\u01e8\u01f9\u0203\u0206\u0209\u020e\u0215\u021b\u0227\u0229\u022e"+
		"\u0230\u0232";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}