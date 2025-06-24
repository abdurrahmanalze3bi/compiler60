// Generated from D:/my_projects/compiler60/typescriptparser.g4 by ANTLR 4.13.2
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
		RULE_componentDeclarationBody = 4, RULE_componentBodyElement = 5, RULE_selector = 6, 
		RULE_standalone = 7, RULE_template = 8, RULE_styles = 9, RULE_isboolean = 10, 
		RULE_classDeclaration = 11, RULE_classDeclarationBody = 12, RULE_classMember = 13, 
		RULE_propertyDeclaration = 14, RULE_methodDeclaration = 15, RULE_methodBody = 16, 
		RULE_statementMethod = 17, RULE_return = 18, RULE_interfaceDeclaration = 19, 
		RULE_interfaceMember = 20, RULE_parameter = 21, RULE_parameterList = 22, 
		RULE_variableDeclaration = 23, RULE_importDeclaration = 24, RULE_type = 25, 
		RULE_memberAccess = 26, RULE_list = 27, RULE_bodylist = 28, RULE_object = 29, 
		RULE_bodyobject = 30, RULE_initvalue = 31, RULE_expression = 32, RULE_operator = 33, 
		RULE_functionCall = 34, RULE_argument = 35, RULE_element = 36, RULE_tag = 37, 
		RULE_openingTag = 38, RULE_closingTag = 39, RULE_selfClosingTag = 40, 
		RULE_attributes = 41, RULE_interpolation = 42, RULE_cssBody = 43, RULE_cssObjects = 44, 
		RULE_csselement = 45, RULE_bodyelement = 46, RULE_cssValue = 47;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "assignmentStatement", "componentDeclaration", 
			"componentDeclarationBody", "componentBodyElement", "selector", "standalone", 
			"template", "styles", "isboolean", "classDeclaration", "classDeclarationBody", 
			"classMember", "propertyDeclaration", "methodDeclaration", "methodBody", 
			"statementMethod", "return", "interfaceDeclaration", "interfaceMember", 
			"parameter", "parameterList", "variableDeclaration", "importDeclaration", 
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
		public ComponentDeclarationContext componentDeclaration() {
			return getRuleContext(ComponentDeclarationContext.class,0);
		}
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public InterfaceDeclarationContext interfaceDeclaration() {
			return getRuleContext(InterfaceDeclarationContext.class,0);
		}
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public AssignmentStatementContext assignmentStatement() {
			return getRuleContext(AssignmentStatementContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public MethodDeclarationContext methodDeclaration() {
			return getRuleContext(MethodDeclarationContext.class,0);
		}
		public ImportDeclarationContext importDeclaration() {
			return getRuleContext(ImportDeclarationContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitStatement(this);
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
				enterOuterAlt(_localctx, 1);
				{
				setState(101);
				componentDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(102);
				classDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(103);
				interfaceDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(104);
				variableDeclaration();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(105);
				assignmentStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(106);
				functionCall();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(107);
				methodDeclaration();
				}
				break;
			case 8:
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
		public TerminalNode ID() { return getToken(typescriptparser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(typescriptparser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(typescriptparser.SEMICOLON, 0); }
		public AssignmentStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterAssignmentStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitAssignmentStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitAssignmentStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentStatementContext assignmentStatement() throws RecognitionException {
		AssignmentStatementContext _localctx = new AssignmentStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_assignmentStatement);
		int _la;
		try {
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
		public TerminalNode DECORATOR() { return getToken(typescriptparser.DECORATOR, 0); }
		public TerminalNode COMPONENT() { return getToken(typescriptparser.COMPONENT, 0); }
		public TerminalNode LPAREN() { return getToken(typescriptparser.LPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(typescriptparser.LBRACE, 0); }
		public ComponentDeclarationBodyContext componentDeclarationBody() {
			return getRuleContext(ComponentDeclarationBodyContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(typescriptparser.RBRACE, 0); }
		public TerminalNode RPAREN() { return getToken(typescriptparser.RPAREN, 0); }
		public ComponentDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_componentDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterComponentDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitComponentDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitComponentDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComponentDeclarationContext componentDeclaration() throws RecognitionException {
		ComponentDeclarationContext _localctx = new ComponentDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_componentDeclaration);
		try {
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
		public ComponentDeclarationBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_componentDeclarationBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterComponentDeclarationBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitComponentDeclarationBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitComponentDeclarationBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComponentDeclarationBodyContext componentDeclarationBody() throws RecognitionException {
		ComponentDeclarationBodyContext _localctx = new ComponentDeclarationBodyContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_componentDeclarationBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
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
		public SelectorContext selector() {
			return getRuleContext(SelectorContext.class,0);
		}
		public StandaloneContext standalone() {
			return getRuleContext(StandaloneContext.class,0);
		}
		public ImportDeclarationContext importDeclaration() {
			return getRuleContext(ImportDeclarationContext.class,0);
		}
		public TemplateContext template() {
			return getRuleContext(TemplateContext.class,0);
		}
		public StylesContext styles() {
			return getRuleContext(StylesContext.class,0);
		}
		public ComponentBodyElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_componentBodyElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterComponentBodyElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitComponentBodyElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitComponentBodyElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComponentBodyElementContext componentBodyElement() throws RecognitionException {
		ComponentBodyElementContext _localctx = new ComponentBodyElementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_componentBodyElement);
		try {
			setState(138);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SELECTOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(133);
				selector();
				}
				break;
			case STANDALONE:
				enterOuterAlt(_localctx, 2);
				{
				setState(134);
				standalone();
				}
				break;
			case IMPORT:
			case IMPORTS:
				enterOuterAlt(_localctx, 3);
				{
				setState(135);
				importDeclaration();
				}
				break;
			case TEMPLATE:
				enterOuterAlt(_localctx, 4);
				{
				setState(136);
				template();
				}
				break;
			case STYLES:
				enterOuterAlt(_localctx, 5);
				{
				setState(137);
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
	public static class SelectorContext extends ParserRuleContext {
		public TerminalNode SELECTOR() { return getToken(typescriptparser.SELECTOR, 0); }
		public TerminalNode COLON() { return getToken(typescriptparser.COLON, 0); }
		public TerminalNode STRING_LIT() { return getToken(typescriptparser.STRING_LIT, 0); }
		public SelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterSelector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitSelector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitSelector(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectorContext selector() throws RecognitionException {
		SelectorContext _localctx = new SelectorContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_selector);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(SELECTOR);
			setState(141);
			match(COLON);
			setState(142);
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
		public TerminalNode STANDALONE() { return getToken(typescriptparser.STANDALONE, 0); }
		public TerminalNode COLON() { return getToken(typescriptparser.COLON, 0); }
		public IsbooleanContext isboolean() {
			return getRuleContext(IsbooleanContext.class,0);
		}
		public StandaloneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_standalone; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterStandalone(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitStandalone(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitStandalone(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StandaloneContext standalone() throws RecognitionException {
		StandaloneContext _localctx = new StandaloneContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_standalone);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(STANDALONE);
			setState(145);
			match(COLON);
			setState(146);
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
		public TemplateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_template; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterTemplate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitTemplate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitTemplate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemplateContext template() throws RecognitionException {
		TemplateContext _localctx = new TemplateContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_template);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(TEMPLATE);
			setState(149);
			match(COLON_HTML);
			setState(150);
			match(BACKTICK_HTML);
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & 18433L) != 0)) {
				{
				{
				setState(151);
				element();
				}
				}
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(157);
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
	public static class StylesRuleContext extends StylesContext {
		public TerminalNode STYLES() { return getToken(typescriptparser.STYLES, 0); }
		public TerminalNode COLON_CSS() { return getToken(typescriptparser.COLON_CSS, 0); }
		public TerminalNode OPEN_LIST() { return getToken(typescriptparser.OPEN_LIST, 0); }
		public CssBodyContext cssBody() {
			return getRuleContext(CssBodyContext.class,0);
		}
		public TerminalNode CLOSE_LIST() { return getToken(typescriptparser.CLOSE_LIST, 0); }
		public TerminalNode COMMA() { return getToken(typescriptparser.COMMA, 0); }
		public StylesRuleContext(StylesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterStylesRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitStylesRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitStylesRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StylesContext styles() throws RecognitionException {
		StylesContext _localctx = new StylesContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_styles);
		try {
			_localctx = new StylesRuleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(STYLES);
			setState(160);
			match(COLON_CSS);
			setState(161);
			match(OPEN_LIST);
			setState(162);
			cssBody();
			setState(163);
			match(CLOSE_LIST);
			setState(165);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(164);
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
	public static class IsbooleanContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(typescriptparser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(typescriptparser.FALSE, 0); }
		public IsbooleanContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_isboolean; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterIsboolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitIsboolean(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitIsboolean(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IsbooleanContext isboolean() throws RecognitionException {
		IsbooleanContext _localctx = new IsbooleanContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_isboolean);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
	public static class ClassDeclarationContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(typescriptparser.CLASS, 0); }
		public TerminalNode ID() { return getToken(typescriptparser.ID, 0); }
		public ClassDeclarationBodyContext classDeclarationBody() {
			return getRuleContext(ClassDeclarationBodyContext.class,0);
		}
		public TerminalNode EXPORT() { return getToken(typescriptparser.EXPORT, 0); }
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitClassDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitClassDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_classDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXPORT) {
				{
				setState(169);
				match(EXPORT);
				}
			}

			setState(172);
			match(CLASS);
			setState(173);
			match(ID);
			setState(174);
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
		public ClassDeclarationBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclarationBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterClassDeclarationBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitClassDeclarationBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitClassDeclarationBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclarationBodyContext classDeclarationBody() throws RecognitionException {
		ClassDeclarationBodyContext _localctx = new ClassDeclarationBodyContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_classDeclarationBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(LBRACE);
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 36028797019258880L) != 0)) {
				{
				{
				setState(177);
				classMember();
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(178);
					match(SEMICOLON);
					}
				}

				}
				}
				setState(185);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(186);
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
		public MethodDeclarationContext methodDeclaration() {
			return getRuleContext(MethodDeclarationContext.class,0);
		}
		public PropertyDeclarationContext propertyDeclaration() {
			return getRuleContext(PropertyDeclarationContext.class,0);
		}
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public ClassMemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classMember; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterClassMember(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitClassMember(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitClassMember(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassMemberContext classMember() throws RecognitionException {
		ClassMemberContext _localctx = new ClassMemberContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_classMember);
		try {
			setState(191);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(188);
				methodDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(189);
				propertyDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(190);
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
		public List<TerminalNode> ID() { return getTokens(typescriptparser.ID); }
		public TerminalNode ID(int i) {
			return getToken(typescriptparser.ID, i);
		}
		public TerminalNode COLON() { return getToken(typescriptparser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(typescriptparser.ASSIGN, 0); }
		public InitvalueContext initvalue() {
			return getRuleContext(InitvalueContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(typescriptparser.SEMICOLON, 0); }
		public TerminalNode OR() { return getToken(typescriptparser.OR, 0); }
		public PropertyDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterPropertyDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitPropertyDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitPropertyDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropertyDeclarationContext propertyDeclaration() throws RecognitionException {
		PropertyDeclarationContext _localctx = new PropertyDeclarationContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_propertyDeclaration);
		int _la;
		try {
			setState(213);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(193);
				match(ID);
				setState(194);
				match(COLON);
				setState(195);
				type();
				setState(196);
				match(ASSIGN);
				setState(197);
				initvalue();
				setState(199);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(198);
					match(SEMICOLON);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(201);
				match(ID);
				setState(202);
				match(COLON);
				setState(203);
				type();
				setState(208);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OR) {
					{
					setState(204);
					match(OR);
					setState(205);
					match(ID);
					setState(206);
					match(ASSIGN);
					setState(207);
					match(ID);
					}
				}

				setState(211);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
				case 1:
					{
					setState(210);
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
		public MethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitMethodDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitMethodDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_methodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			match(ID);
			setState(216);
			match(LPAREN);
			setState(218);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(217);
				parameterList();
				}
			}

			setState(220);
			match(RPAREN);
			setState(221);
			match(COLON);
			setState(223);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 36028813661962240L) != 0)) {
				{
				setState(222);
				type();
				}
			}

			setState(225);
			match(LBRACE);
			setState(226);
			methodBody();
			setState(227);
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
		public List<StatementMethodContext> statementMethod() {
			return getRuleContexts(StatementMethodContext.class);
		}
		public StatementMethodContext statementMethod(int i) {
			return getRuleContext(StatementMethodContext.class,i);
		}
		public MethodBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterMethodBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitMethodBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitMethodBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodBodyContext methodBody() throws RecognitionException {
		MethodBodyContext _localctx = new MethodBodyContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_methodBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 279786676609876224L) != 0)) {
				{
				{
				setState(229);
				statementMethod();
				}
				}
				setState(234);
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
		public TerminalNode ID() { return getToken(typescriptparser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(typescriptparser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(typescriptparser.SEMICOLON, 0); }
		public ReturnContext return_() {
			return getRuleContext(ReturnContext.class,0);
		}
		public TerminalNode THIS() { return getToken(typescriptparser.THIS, 0); }
		public TerminalNode DOT() { return getToken(typescriptparser.DOT, 0); }
		public StatementMethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementMethod; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterStatementMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitStatementMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitStatementMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementMethodContext statementMethod() throws RecognitionException {
		StatementMethodContext _localctx = new StatementMethodContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_statementMethod);
		try {
			setState(257);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(235);
				match(ID);
				setState(236);
				match(ASSIGN);
				setState(237);
				expression(0);
				setState(238);
				match(SEMICOLON);
				setState(240);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(239);
					return_();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(242);
				match(THIS);
				setState(243);
				match(DOT);
				setState(244);
				match(ID);
				setState(245);
				match(ASSIGN);
				setState(246);
				expression(0);
				setState(247);
				match(SEMICOLON);
				setState(249);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(248);
					return_();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(251);
				expression(0);
				setState(252);
				match(SEMICOLON);
				setState(254);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(253);
					return_();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(256);
				return_();
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
	public static class ReturnContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(typescriptparser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(typescriptparser.SEMICOLON, 0); }
		public TerminalNode ID() { return getToken(typescriptparser.ID, 0); }
		public IsbooleanContext isboolean() {
			return getRuleContext(IsbooleanContext.class,0);
		}
		public ReturnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitReturn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitReturn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnContext return_() throws RecognitionException {
		ReturnContext _localctx = new ReturnContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_return);
		try {
			setState(270);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(259);
				match(RETURN);
				setState(260);
				expression(0);
				setState(261);
				match(SEMICOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(263);
				match(RETURN);
				setState(264);
				match(ID);
				setState(265);
				match(SEMICOLON);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(266);
				match(RETURN);
				setState(267);
				isboolean();
				setState(268);
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
		enterRule(_localctx, 38, RULE_interfaceDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			match(INTERFACE);
			setState(273);
			match(ID);
			setState(274);
			match(LBRACE);
			setState(278);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(275);
				interfaceMember();
				}
				}
				setState(280);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(281);
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
		public PropertyDeclarationContext propertyDeclaration() {
			return getRuleContext(PropertyDeclarationContext.class,0);
		}
		public MethodDeclarationContext methodDeclaration() {
			return getRuleContext(MethodDeclarationContext.class,0);
		}
		public InterfaceMemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceMember; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterInterfaceMember(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitInterfaceMember(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitInterfaceMember(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterfaceMemberContext interfaceMember() throws RecognitionException {
		InterfaceMemberContext _localctx = new InterfaceMemberContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_interfaceMember);
		try {
			setState(285);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(283);
				propertyDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(284);
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
		public TerminalNode ID() { return getToken(typescriptparser.ID, 0); }
		public TerminalNode COLON() { return getToken(typescriptparser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			match(ID);
			setState(288);
			match(COLON);
			setState(289);
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
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_parameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			parameter();
			setState(296);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(292);
				match(COMMA);
				setState(293);
				parameter();
				}
				}
				setState(298);
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
		public TerminalNode ID() { return getToken(typescriptparser.ID, 0); }
		public TerminalNode CONST() { return getToken(typescriptparser.CONST, 0); }
		public TerminalNode LET() { return getToken(typescriptparser.LET, 0); }
		public TerminalNode VAR() { return getToken(typescriptparser.VAR, 0); }
		public TerminalNode ASSIGN() { return getToken(typescriptparser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_variableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3670016L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(300);
			match(ID);
			setState(303);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(301);
				match(ASSIGN);
				setState(302);
				expression(0);
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
		public TerminalNode IMPORT() { return getToken(typescriptparser.IMPORT, 0); }
		public TerminalNode LBRACE() { return getToken(typescriptparser.LBRACE, 0); }
		public TerminalNode ID() { return getToken(typescriptparser.ID, 0); }
		public TerminalNode RBRACE() { return getToken(typescriptparser.RBRACE, 0); }
		public TerminalNode FROM() { return getToken(typescriptparser.FROM, 0); }
		public TerminalNode STRING_LIT() { return getToken(typescriptparser.STRING_LIT, 0); }
		public TerminalNode SEMICOLON() { return getToken(typescriptparser.SEMICOLON, 0); }
		public TerminalNode COMPONENT() { return getToken(typescriptparser.COMPONENT, 0); }
		public TerminalNode IMPORTS() { return getToken(typescriptparser.IMPORTS, 0); }
		public TerminalNode COLON() { return getToken(typescriptparser.COLON, 0); }
		public TerminalNode LBRACKET() { return getToken(typescriptparser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(typescriptparser.RBRACKET, 0); }
		public ImportDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterImportDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitImportDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitImportDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportDeclarationContext importDeclaration() throws RecognitionException {
		ImportDeclarationContext _localctx = new ImportDeclarationContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_importDeclaration);
		int _la;
		try {
			setState(326);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(305);
				match(IMPORT);
				setState(306);
				match(LBRACE);
				setState(307);
				match(ID);
				setState(308);
				match(RBRACE);
				setState(309);
				match(FROM);
				setState(310);
				match(STRING_LIT);
				setState(311);
				match(SEMICOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(312);
				match(IMPORT);
				setState(313);
				match(LBRACE);
				setState(314);
				match(COMPONENT);
				setState(315);
				match(RBRACE);
				setState(316);
				match(FROM);
				setState(317);
				match(STRING_LIT);
				setState(318);
				match(SEMICOLON);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(319);
				match(IMPORTS);
				setState(320);
				match(COLON);
				setState(321);
				match(LBRACKET);
				setState(323);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(322);
					match(ID);
					}
				}

				setState(325);
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
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode STRING_TYPE() { return getToken(typescriptparser.STRING_TYPE, 0); }
		public TerminalNode NUMBER_TYPE() { return getToken(typescriptparser.NUMBER_TYPE, 0); }
		public TerminalNode BOOLEAN_TYPE() { return getToken(typescriptparser.BOOLEAN_TYPE, 0); }
		public TerminalNode ANY_TYPE() { return getToken(typescriptparser.ANY_TYPE, 0); }
		public TerminalNode VOID_TYPE() { return getToken(typescriptparser.VOID_TYPE, 0); }
		public TerminalNode ID() { return getToken(typescriptparser.ID, 0); }
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_type);
		try {
			setState(335);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(328);
				match(STRING_TYPE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(329);
				match(NUMBER_TYPE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(330);
				match(BOOLEAN_TYPE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(331);
				match(ANY_TYPE);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(332);
				match(VOID_TYPE);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(333);
				match(ID);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(334);
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
		public TerminalNode THIS() { return getToken(typescriptparser.THIS, 0); }
		public TerminalNode DOT() { return getToken(typescriptparser.DOT, 0); }
		public TerminalNode ID() { return getToken(typescriptparser.ID, 0); }
		public MemberAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterMemberAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitMemberAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitMemberAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MemberAccessContext memberAccess() throws RecognitionException {
		MemberAccessContext _localctx = new MemberAccessContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_memberAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337);
			match(THIS);
			setState(338);
			match(DOT);
			setState(339);
			match(ID);
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
		public TerminalNode ID() { return getToken(typescriptparser.ID, 0); }
		public TerminalNode LBRACKET() { return getToken(typescriptparser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(typescriptparser.RBRACKET, 0); }
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(341);
			match(ID);
			setState(342);
			match(LBRACKET);
			setState(343);
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
		public BodylistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bodylist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterBodylist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitBodylist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitBodylist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodylistContext bodylist() throws RecognitionException {
		BodylistContext _localctx = new BodylistContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_bodylist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(353);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 51)) & ~0x3f) == 0 && ((1L << (_la - 51)) & 8301L) != 0)) {
				{
				setState(345);
				initvalue();
				setState(350);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(346);
					match(COMMA);
					setState(347);
					initvalue();
					}
					}
					setState(352);
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
		public TerminalNode LBRACE() { return getToken(typescriptparser.LBRACE, 0); }
		public BodyobjectContext bodyobject() {
			return getRuleContext(BodyobjectContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(typescriptparser.RBRACE, 0); }
		public TerminalNode COMMA() { return getToken(typescriptparser.COMMA, 0); }
		public ObjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_object; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterObject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitObject(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitObject(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectContext object() throws RecognitionException {
		ObjectContext _localctx = new ObjectContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_object);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(355);
			match(LBRACE);
			setState(356);
			bodyobject();
			setState(357);
			match(RBRACE);
			setState(359);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(358);
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
		public BodyobjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bodyobject; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterBodyobject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitBodyobject(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitBodyobject(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyobjectContext bodyobject() throws RecognitionException {
		BodyobjectContext _localctx = new BodyobjectContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_bodyobject);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(376);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(361);
				match(ID);
				setState(362);
				match(COLON);
				setState(363);
				initvalue();
				setState(373);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(364);
					match(COMMA);
					setState(365);
					match(ID);
					setState(366);
					match(COLON);
					setState(367);
					initvalue();
					setState(369);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
					case 1:
						{
						setState(368);
						match(COMMA);
						}
						break;
					}
					}
					}
					setState(375);
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
	public static class InitvalueContext extends ParserRuleContext {
		public TerminalNode NUMBER_LIT() { return getToken(typescriptparser.NUMBER_LIT, 0); }
		public TerminalNode STRING_LIT() { return getToken(typescriptparser.STRING_LIT, 0); }
		public IsbooleanContext isboolean() {
			return getRuleContext(IsbooleanContext.class,0);
		}
		public TerminalNode LBRACKET() { return getToken(typescriptparser.LBRACKET, 0); }
		public BodylistContext bodylist() {
			return getRuleContext(BodylistContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(typescriptparser.RBRACKET, 0); }
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
		public InitvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initvalue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterInitvalue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitInitvalue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitInitvalue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitvalueContext initvalue() throws RecognitionException {
		InitvalueContext _localctx = new InitvalueContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_initvalue);
		try {
			setState(386);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER_LIT:
				enterOuterAlt(_localctx, 1);
				{
				setState(378);
				match(NUMBER_LIT);
				}
				break;
			case STRING_LIT:
				enterOuterAlt(_localctx, 2);
				{
				setState(379);
				match(STRING_LIT);
				}
				break;
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 3);
				{
				setState(380);
				isboolean();
				}
				break;
			case LBRACKET:
				enterOuterAlt(_localctx, 4);
				{
				setState(381);
				match(LBRACKET);
				setState(382);
				bodylist();
				setState(383);
				match(RBRACKET);
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 5);
				{
				setState(385);
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
		public TerminalNode STRING_LIT() { return getToken(typescriptparser.STRING_LIT, 0); }
		public TerminalNode NUMBER_LIT() { return getToken(typescriptparser.NUMBER_LIT, 0); }
		public TerminalNode ID() { return getToken(typescriptparser.ID, 0); }
		public IsbooleanContext isboolean() {
			return getRuleContext(IsbooleanContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public MemberAccessContext memberAccess() {
			return getRuleContext(MemberAccessContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(typescriptparser.LPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(typescriptparser.RPAREN, 0); }
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitExpression(this);
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
			setState(400);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				setState(389);
				match(STRING_LIT);
				}
				break;
			case 2:
				{
				setState(390);
				match(NUMBER_LIT);
				}
				break;
			case 3:
				{
				setState(391);
				match(ID);
				}
				break;
			case 4:
				{
				setState(392);
				isboolean();
				}
				break;
			case 5:
				{
				setState(393);
				functionCall();
				}
				break;
			case 6:
				{
				setState(394);
				variableDeclaration();
				}
				break;
			case 7:
				{
				setState(395);
				memberAccess();
				}
				break;
			case 8:
				{
				setState(396);
				match(LPAREN);
				setState(397);
				expression(0);
				setState(398);
				match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(408);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expression);
					setState(402);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(403);
					operator();
					setState(404);
					expression(3);
					}
					} 
				}
				setState(410);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
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
		public TerminalNode PLUS() { return getToken(typescriptparser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(typescriptparser.MINUS, 0); }
		public TerminalNode STAR() { return getToken(typescriptparser.STAR, 0); }
		public TerminalNode SLASH() { return getToken(typescriptparser.SLASH, 0); }
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(411);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 32985348833280L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
	public static class FunctionCallContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(typescriptparser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(typescriptparser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(typescriptparser.RPAREN, 0); }
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(413);
			match(ID);
			setState(414);
			match(LPAREN);
			setState(418);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 279786676609875968L) != 0)) {
				{
				{
				setState(415);
				argument();
				}
				}
				setState(420);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(421);
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_argument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(423);
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
		public TagContext tag() {
			return getRuleContext(TagContext.class,0);
		}
		public TerminalNode NAME_HTML() { return getToken(typescriptparser.NAME_HTML, 0); }
		public TerminalNode COLON_HTML() { return getToken(typescriptparser.COLON_HTML, 0); }
		public InterpolationContext interpolation() {
			return getRuleContext(InterpolationContext.class,0);
		}
		public ElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementContext element() throws RecognitionException {
		ElementContext _localctx = new ElementContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_element);
		int _la;
		try {
			setState(431);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TAG_OPEN_START_HTML:
				enterOuterAlt(_localctx, 1);
				{
				setState(425);
				tag();
				}
				break;
			case NAME_HTML:
				enterOuterAlt(_localctx, 2);
				{
				setState(426);
				match(NAME_HTML);
				setState(428);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLON_HTML) {
					{
					setState(427);
					match(COLON_HTML);
					}
				}

				}
				break;
			case INTERPOLATION_START_HTML:
				enterOuterAlt(_localctx, 3);
				{
				setState(430);
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
		public SelfClosingTagContext selfClosingTag() {
			return getRuleContext(SelfClosingTagContext.class,0);
		}
		public TagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TagContext tag() throws RecognitionException {
		TagContext _localctx = new TagContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_tag);
		int _la;
		try {
			setState(443);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(433);
				openingTag();
				setState(437);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & 18433L) != 0)) {
					{
					{
					setState(434);
					element();
					}
					}
					setState(439);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(440);
				closingTag();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(442);
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
		public TerminalNode TAG_OPEN_START_HTML() { return getToken(typescriptparser.TAG_OPEN_START_HTML, 0); }
		public TerminalNode TAG_CLOSE_END_HTML() { return getToken(typescriptparser.TAG_CLOSE_END_HTML, 0); }
		public List<AttributesContext> attributes() {
			return getRuleContexts(AttributesContext.class);
		}
		public AttributesContext attributes(int i) {
			return getRuleContext(AttributesContext.class,i);
		}
		public OpeningTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_openingTag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterOpeningTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitOpeningTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitOpeningTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpeningTagContext openingTag() throws RecognitionException {
		OpeningTagContext _localctx = new OpeningTagContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_openingTag);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(445);
			match(TAG_OPEN_START_HTML);
			setState(449);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & 263L) != 0)) {
				{
				{
				setState(446);
				attributes();
				}
				}
				setState(451);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(452);
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
		public TerminalNode TAG_CLOSE_START_HTML() { return getToken(typescriptparser.TAG_CLOSE_START_HTML, 0); }
		public TerminalNode NAME_HTML() { return getToken(typescriptparser.NAME_HTML, 0); }
		public TerminalNode TAG_CLOSE_END_HTML() { return getToken(typescriptparser.TAG_CLOSE_END_HTML, 0); }
		public ClosingTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_closingTag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterClosingTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitClosingTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitClosingTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClosingTagContext closingTag() throws RecognitionException {
		ClosingTagContext _localctx = new ClosingTagContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_closingTag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(454);
			match(TAG_CLOSE_START_HTML);
			setState(455);
			match(NAME_HTML);
			setState(456);
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
		public TerminalNode TAG_OPEN_START_HTML() { return getToken(typescriptparser.TAG_OPEN_START_HTML, 0); }
		public TerminalNode TAG_END_HTML() { return getToken(typescriptparser.TAG_END_HTML, 0); }
		public List<AttributesContext> attributes() {
			return getRuleContexts(AttributesContext.class);
		}
		public AttributesContext attributes(int i) {
			return getRuleContext(AttributesContext.class,i);
		}
		public SelfClosingTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selfClosingTag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterSelfClosingTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitSelfClosingTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitSelfClosingTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelfClosingTagContext selfClosingTag() throws RecognitionException {
		SelfClosingTagContext _localctx = new SelfClosingTagContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_selfClosingTag);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(458);
			match(TAG_OPEN_START_HTML);
			setState(462);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & 263L) != 0)) {
				{
				{
				setState(459);
				attributes();
				}
				}
				setState(464);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(465);
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
		public TerminalNode NAME_HTML() { return getToken(typescriptparser.NAME_HTML, 0); }
		public TerminalNode ATTRIBUTE_EQUALS_HTML() { return getToken(typescriptparser.ATTRIBUTE_EQUALS_HTML, 0); }
		public TerminalNode STRING_HTML() { return getToken(typescriptparser.STRING_HTML, 0); }
		public TerminalNode STRUCTURAL_DIR_HTML() { return getToken(typescriptparser.STRUCTURAL_DIR_HTML, 0); }
		public TerminalNode BINDING_HTML() { return getToken(typescriptparser.BINDING_HTML, 0); }
		public TerminalNode EVENT_BINDING_HTML() { return getToken(typescriptparser.EVENT_BINDING_HTML, 0); }
		public AttributesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterAttributes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitAttributes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitAttributes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributesContext attributes() throws RecognitionException {
		AttributesContext _localctx = new AttributesContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_attributes);
		try {
			setState(479);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME_HTML:
				enterOuterAlt(_localctx, 1);
				{
				setState(467);
				match(NAME_HTML);
				setState(468);
				match(ATTRIBUTE_EQUALS_HTML);
				setState(469);
				match(STRING_HTML);
				}
				break;
			case STRUCTURAL_DIR_HTML:
				enterOuterAlt(_localctx, 2);
				{
				setState(470);
				match(STRUCTURAL_DIR_HTML);
				setState(471);
				match(ATTRIBUTE_EQUALS_HTML);
				setState(472);
				match(STRING_HTML);
				}
				break;
			case BINDING_HTML:
				enterOuterAlt(_localctx, 3);
				{
				setState(473);
				match(BINDING_HTML);
				setState(474);
				match(ATTRIBUTE_EQUALS_HTML);
				setState(475);
				match(STRING_HTML);
				}
				break;
			case EVENT_BINDING_HTML:
				enterOuterAlt(_localctx, 4);
				{
				setState(476);
				match(EVENT_BINDING_HTML);
				setState(477);
				match(ATTRIBUTE_EQUALS_HTML);
				setState(478);
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
		public TerminalNode INTERPOLATION_START_HTML() { return getToken(typescriptparser.INTERPOLATION_START_HTML, 0); }
		public TerminalNode NAME_HTML() { return getToken(typescriptparser.NAME_HTML, 0); }
		public TerminalNode INTERPOLATION_END_HTML() { return getToken(typescriptparser.INTERPOLATION_END_HTML, 0); }
		public InterpolationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interpolation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterInterpolation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitInterpolation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitInterpolation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterpolationContext interpolation() throws RecognitionException {
		InterpolationContext _localctx = new InterpolationContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_interpolation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(481);
			match(INTERPOLATION_START_HTML);
			setState(482);
			match(NAME_HTML);
			setState(483);
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
			setState(485);
			match(BACKTICK_CSS);
			setState(486);
			cssObjects();
			setState(487);
			match(BACKTICK_CSS);
			setState(489);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA_CSS) {
				{
				setState(488);
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
			setState(492);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				{
				setState(491);
				csselement();
				}
				break;
			}
			setState(500);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA_CSS || _la==DOT_CSS) {
				{
				{
				setState(495);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA_CSS) {
					{
					setState(494);
					match(COMMA_CSS);
					}
				}

				setState(497);
				csselement();
				}
				}
				setState(502);
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
			setState(503);
			match(DOT_CSS);
			setState(505); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(504);
				match(ID_CSS);
				}
				}
				setState(507); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID_CSS );
			setState(509);
			match(LBRACE_CSS);
			setState(511); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(510);
				bodyelement();
				}
				}
				setState(513); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID_CSS );
			setState(515);
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
			setState(517);
			match(ID_CSS);
			setState(518);
			match(COLON_CSS);
			setState(519);
			cssValue();
			setState(520);
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
			setState(536);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PERCENT:
				_localctx = new PercentValueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(522);
				match(PERCENT);
				setState(527);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID_CSS) {
					{
					setState(523);
					match(ID_CSS);
					setState(525);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ID_CSS) {
						{
						setState(524);
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
				setState(529);
				match(ID_CSS);
				setState(534);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID_CSS) {
					{
					setState(530);
					match(ID_CSS);
					setState(532);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ID_CSS) {
						{
						setState(531);
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
		"\u0004\u0001h\u021b\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"\u0081\b\u0004\n\u0004\f\u0004\u0084\t\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u008b\b\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u0099\b\b\n\b\f\b\u009c"+
		"\t\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003"+
		"\t\u00a6\b\t\u0001\n\u0001\n\u0001\u000b\u0003\u000b\u00ab\b\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0003"+
		"\f\u00b4\b\f\u0005\f\u00b6\b\f\n\f\f\f\u00b9\t\f\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0001\r\u0003\r\u00c0\b\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00c8\b\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0003\u000e\u00d1\b\u000e\u0001\u000e\u0003\u000e\u00d4\b\u000e\u0003"+
		"\u000e\u00d6\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u00db"+
		"\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u00e0\b\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0005\u0010"+
		"\u00e7\b\u0010\n\u0010\f\u0010\u00ea\t\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u00f1\b\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003"+
		"\u0011\u00fa\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u00ff"+
		"\b\u0011\u0001\u0011\u0003\u0011\u0102\b\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u010f\b\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u0115\b\u0013\n\u0013"+
		"\f\u0013\u0118\t\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014"+
		"\u0003\u0014\u011e\b\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0005\u0016\u0127\b\u0016\n\u0016"+
		"\f\u0016\u012a\t\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0003\u0017\u0130\b\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0003\u0018\u0144\b\u0018\u0001\u0018\u0003\u0018"+
		"\u0147\b\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0003\u0019\u0150\b\u0019\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0005\u001c\u015d\b\u001c\n\u001c"+
		"\f\u001c\u0160\t\u001c\u0003\u001c\u0162\b\u001c\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0003\u001d\u0168\b\u001d\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0003\u001e\u0172\b\u001e\u0005\u001e\u0174\b\u001e\n\u001e\f\u001e\u0177"+
		"\t\u001e\u0003\u001e\u0179\b\u001e\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0003\u001f"+
		"\u0183\b\u001f\u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001"+
		" \u0001 \u0001 \u0001 \u0001 \u0003 \u0191\b \u0001 \u0001 \u0001 \u0001"+
		" \u0005 \u0197\b \n \f \u019a\t \u0001!\u0001!\u0001\"\u0001\"\u0001\""+
		"\u0005\"\u01a1\b\"\n\"\f\"\u01a4\t\"\u0001\"\u0001\"\u0001#\u0001#\u0001"+
		"$\u0001$\u0001$\u0003$\u01ad\b$\u0001$\u0003$\u01b0\b$\u0001%\u0001%\u0005"+
		"%\u01b4\b%\n%\f%\u01b7\t%\u0001%\u0001%\u0001%\u0003%\u01bc\b%\u0001&"+
		"\u0001&\u0005&\u01c0\b&\n&\f&\u01c3\t&\u0001&\u0001&\u0001\'\u0001\'\u0001"+
		"\'\u0001\'\u0001(\u0001(\u0005(\u01cd\b(\n(\f(\u01d0\t(\u0001(\u0001("+
		"\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001"+
		")\u0001)\u0001)\u0003)\u01e0\b)\u0001*\u0001*\u0001*\u0001*\u0001+\u0001"+
		"+\u0001+\u0001+\u0003+\u01ea\b+\u0001,\u0003,\u01ed\b,\u0001,\u0003,\u01f0"+
		"\b,\u0001,\u0005,\u01f3\b,\n,\f,\u01f6\t,\u0001-\u0001-\u0004-\u01fa\b"+
		"-\u000b-\f-\u01fb\u0001-\u0001-\u0004-\u0200\b-\u000b-\f-\u0201\u0001"+
		"-\u0001-\u0001.\u0001.\u0001.\u0001.\u0001.\u0001/\u0001/\u0001/\u0003"+
		"/\u020e\b/\u0003/\u0210\b/\u0001/\u0001/\u0001/\u0003/\u0215\b/\u0003"+
		"/\u0217\b/\u0003/\u0219\b/\u0001/\u0000\u0001@0\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,."+
		"02468:<>@BDFHJLNPRTVXZ\\^\u0000\u0003\u0001\u000056\u0001\u0000\u0013"+
		"\u0015\u0001\u0000),\u0243\u0000a\u0001\u0000\u0000\u0000\u0002m\u0001"+
		"\u0000\u0000\u0000\u0004o\u0001\u0000\u0000\u0000\u0006u\u0001\u0000\u0000"+
		"\u0000\b}\u0001\u0000\u0000\u0000\n\u008a\u0001\u0000\u0000\u0000\f\u008c"+
		"\u0001\u0000\u0000\u0000\u000e\u0090\u0001\u0000\u0000\u0000\u0010\u0094"+
		"\u0001\u0000\u0000\u0000\u0012\u009f\u0001\u0000\u0000\u0000\u0014\u00a7"+
		"\u0001\u0000\u0000\u0000\u0016\u00aa\u0001\u0000\u0000\u0000\u0018\u00b0"+
		"\u0001\u0000\u0000\u0000\u001a\u00bf\u0001\u0000\u0000\u0000\u001c\u00d5"+
		"\u0001\u0000\u0000\u0000\u001e\u00d7\u0001\u0000\u0000\u0000 \u00e8\u0001"+
		"\u0000\u0000\u0000\"\u0101\u0001\u0000\u0000\u0000$\u010e\u0001\u0000"+
		"\u0000\u0000&\u0110\u0001\u0000\u0000\u0000(\u011d\u0001\u0000\u0000\u0000"+
		"*\u011f\u0001\u0000\u0000\u0000,\u0123\u0001\u0000\u0000\u0000.\u012b"+
		"\u0001\u0000\u0000\u00000\u0146\u0001\u0000\u0000\u00002\u014f\u0001\u0000"+
		"\u0000\u00004\u0151\u0001\u0000\u0000\u00006\u0155\u0001\u0000\u0000\u0000"+
		"8\u0161\u0001\u0000\u0000\u0000:\u0163\u0001\u0000\u0000\u0000<\u0178"+
		"\u0001\u0000\u0000\u0000>\u0182\u0001\u0000\u0000\u0000@\u0190\u0001\u0000"+
		"\u0000\u0000B\u019b\u0001\u0000\u0000\u0000D\u019d\u0001\u0000\u0000\u0000"+
		"F\u01a7\u0001\u0000\u0000\u0000H\u01af\u0001\u0000\u0000\u0000J\u01bb"+
		"\u0001\u0000\u0000\u0000L\u01bd\u0001\u0000\u0000\u0000N\u01c6\u0001\u0000"+
		"\u0000\u0000P\u01ca\u0001\u0000\u0000\u0000R\u01df\u0001\u0000\u0000\u0000"+
		"T\u01e1\u0001\u0000\u0000\u0000V\u01e5\u0001\u0000\u0000\u0000X\u01ec"+
		"\u0001\u0000\u0000\u0000Z\u01f7\u0001\u0000\u0000\u0000\\\u0205\u0001"+
		"\u0000\u0000\u0000^\u0218\u0001\u0000\u0000\u0000`b\u0003\u0002\u0001"+
		"\u0000a`\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000ca\u0001\u0000"+
		"\u0000\u0000cd\u0001\u0000\u0000\u0000d\u0001\u0001\u0000\u0000\u0000"+
		"en\u0003\u0006\u0003\u0000fn\u0003\u0016\u000b\u0000gn\u0003&\u0013\u0000"+
		"hn\u0003.\u0017\u0000in\u0003\u0004\u0002\u0000jn\u0003D\"\u0000kn\u0003"+
		"\u001e\u000f\u0000ln\u00030\u0018\u0000me\u0001\u0000\u0000\u0000mf\u0001"+
		"\u0000\u0000\u0000mg\u0001\u0000\u0000\u0000mh\u0001\u0000\u0000\u0000"+
		"mi\u0001\u0000\u0000\u0000mj\u0001\u0000\u0000\u0000mk\u0001\u0000\u0000"+
		"\u0000ml\u0001\u0000\u0000\u0000n\u0003\u0001\u0000\u0000\u0000op\u0005"+
		"7\u0000\u0000pq\u0005(\u0000\u0000qs\u0003@ \u0000rt\u0005%\u0000\u0000"+
		"sr\u0001\u0000\u0000\u0000st\u0001\u0000\u0000\u0000t\u0005\u0001\u0000"+
		"\u0000\u0000uv\u0005=\u0000\u0000vw\u0005\u0017\u0000\u0000wx\u00051\u0000"+
		"\u0000xy\u00053\u0000\u0000yz\u0003\b\u0004\u0000z{\u00054\u0000\u0000"+
		"{|\u00052\u0000\u0000|\u0007\u0001\u0000\u0000\u0000}\u0082\u0003\n\u0005"+
		"\u0000~\u007f\u0005\"\u0000\u0000\u007f\u0081\u0003\n\u0005\u0000\u0080"+
		"~\u0001\u0000\u0000\u0000\u0081\u0084\u0001\u0000\u0000\u0000\u0082\u0080"+
		"\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083\t\u0001"+
		"\u0000\u0000\u0000\u0084\u0082\u0001\u0000\u0000\u0000\u0085\u008b\u0003"+
		"\f\u0006\u0000\u0086\u008b\u0003\u000e\u0007\u0000\u0087\u008b\u00030"+
		"\u0018\u0000\u0088\u008b\u0003\u0010\b\u0000\u0089\u008b\u0003\u0012\t"+
		"\u0000\u008a\u0085\u0001\u0000\u0000\u0000\u008a\u0086\u0001\u0000\u0000"+
		"\u0000\u008a\u0087\u0001\u0000\u0000\u0000\u008a\u0088\u0001\u0000\u0000"+
		"\u0000\u008a\u0089\u0001\u0000\u0000\u0000\u008b\u000b\u0001\u0000\u0000"+
		"\u0000\u008c\u008d\u0005\u0018\u0000\u0000\u008d\u008e\u0005#\u0000\u0000"+
		"\u008e\u008f\u00058\u0000\u0000\u008f\r\u0001\u0000\u0000\u0000\u0090"+
		"\u0091\u0005\u0019\u0000\u0000\u0091\u0092\u0005#\u0000\u0000\u0092\u0093"+
		"\u0003\u0014\n\u0000\u0093\u000f\u0001\u0000\u0000\u0000\u0094\u0095\u0005"+
		"\u001b\u0000\u0000\u0095\u0096\u0005P\u0000\u0000\u0096\u009a\u0005W\u0000"+
		"\u0000\u0097\u0099\u0003H$\u0000\u0098\u0097\u0001\u0000\u0000\u0000\u0099"+
		"\u009c\u0001\u0000\u0000\u0000\u009a\u0098\u0001\u0000\u0000\u0000\u009a"+
		"\u009b\u0001\u0000\u0000\u0000\u009b\u009d\u0001\u0000\u0000\u0000\u009c"+
		"\u009a\u0001\u0000\u0000\u0000\u009d\u009e\u0005V\u0000\u0000\u009e\u0011"+
		"\u0001\u0000\u0000\u0000\u009f\u00a0\u0005\u001c\u0000\u0000\u00a0\u00a1"+
		"\u0005Y\u0000\u0000\u00a1\u00a2\u0005[\u0000\u0000\u00a2\u00a3\u0003V"+
		"+\u0000\u00a3\u00a5\u0005\\\u0000\u0000\u00a4\u00a6\u0005\"\u0000\u0000"+
		"\u00a5\u00a4\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000"+
		"\u00a6\u0013\u0001\u0000\u0000\u0000\u00a7\u00a8\u0007\u0000\u0000\u0000"+
		"\u00a8\u0015\u0001\u0000\u0000\u0000\u00a9\u00ab\u0005\u0012\u0000\u0000"+
		"\u00aa\u00a9\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000"+
		"\u00ab\u00ac\u0001\u0000\u0000\u0000\u00ac\u00ad\u0005\u000f\u0000\u0000"+
		"\u00ad\u00ae\u00057\u0000\u0000\u00ae\u00af\u0003\u0018\f\u0000\u00af"+
		"\u0017\u0001\u0000\u0000\u0000\u00b0\u00b7\u00053\u0000\u0000\u00b1\u00b3"+
		"\u0003\u001a\r\u0000\u00b2\u00b4\u0005%\u0000\u0000\u00b3\u00b2\u0001"+
		"\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000\u0000\u0000\u00b4\u00b6\u0001"+
		"\u0000\u0000\u0000\u00b5\u00b1\u0001\u0000\u0000\u0000\u00b6\u00b9\u0001"+
		"\u0000\u0000\u0000\u00b7\u00b5\u0001\u0000\u0000\u0000\u00b7\u00b8\u0001"+
		"\u0000\u0000\u0000\u00b8\u00ba\u0001\u0000\u0000\u0000\u00b9\u00b7\u0001"+
		"\u0000\u0000\u0000\u00ba\u00bb\u00054\u0000\u0000\u00bb\u0019\u0001\u0000"+
		"\u0000\u0000\u00bc\u00c0\u0003\u001e\u000f\u0000\u00bd\u00c0\u0003\u001c"+
		"\u000e\u0000\u00be\u00c0\u0003\u0016\u000b\u0000\u00bf\u00bc\u0001\u0000"+
		"\u0000\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000\u00bf\u00be\u0001\u0000"+
		"\u0000\u0000\u00c0\u001b\u0001\u0000\u0000\u0000\u00c1\u00c2\u00057\u0000"+
		"\u0000\u00c2\u00c3\u0005#\u0000\u0000\u00c3\u00c4\u00032\u0019\u0000\u00c4"+
		"\u00c5\u0005(\u0000\u0000\u00c5\u00c7\u0003>\u001f\u0000\u00c6\u00c8\u0005"+
		"%\u0000\u0000\u00c7\u00c6\u0001\u0000\u0000\u0000\u00c7\u00c8\u0001\u0000"+
		"\u0000\u0000\u00c8\u00d6\u0001\u0000\u0000\u0000\u00c9\u00ca\u00057\u0000"+
		"\u0000\u00ca\u00cb\u0005#\u0000\u0000\u00cb\u00d0\u00032\u0019\u0000\u00cc"+
		"\u00cd\u0005B\u0000\u0000\u00cd\u00ce\u00057\u0000\u0000\u00ce\u00cf\u0005"+
		"(\u0000\u0000\u00cf\u00d1\u00057\u0000\u0000\u00d0\u00cc\u0001\u0000\u0000"+
		"\u0000\u00d0\u00d1\u0001\u0000\u0000\u0000\u00d1\u00d3\u0001\u0000\u0000"+
		"\u0000\u00d2\u00d4\u0005%\u0000\u0000\u00d3\u00d2\u0001\u0000\u0000\u0000"+
		"\u00d3\u00d4\u0001\u0000\u0000\u0000\u00d4\u00d6\u0001\u0000\u0000\u0000"+
		"\u00d5\u00c1\u0001\u0000\u0000\u0000\u00d5\u00c9\u0001\u0000\u0000\u0000"+
		"\u00d6\u001d\u0001\u0000\u0000\u0000\u00d7\u00d8\u00057\u0000\u0000\u00d8"+
		"\u00da\u00051\u0000\u0000\u00d9\u00db\u0003,\u0016\u0000\u00da\u00d9\u0001"+
		"\u0000\u0000\u0000\u00da\u00db\u0001\u0000\u0000\u0000\u00db\u00dc\u0001"+
		"\u0000\u0000\u0000\u00dc\u00dd\u00052\u0000\u0000\u00dd\u00df\u0005#\u0000"+
		"\u0000\u00de\u00e0\u00032\u0019\u0000\u00df\u00de\u0001\u0000\u0000\u0000"+
		"\u00df\u00e0\u0001\u0000\u0000\u0000\u00e0\u00e1\u0001\u0000\u0000\u0000"+
		"\u00e1\u00e2\u00053\u0000\u0000\u00e2\u00e3\u0003 \u0010\u0000\u00e3\u00e4"+
		"\u00054\u0000\u0000\u00e4\u001f\u0001\u0000\u0000\u0000\u00e5\u00e7\u0003"+
		"\"\u0011\u0000\u00e6\u00e5\u0001\u0000\u0000\u0000\u00e7\u00ea\u0001\u0000"+
		"\u0000\u0000\u00e8\u00e6\u0001\u0000\u0000\u0000\u00e8\u00e9\u0001\u0000"+
		"\u0000\u0000\u00e9!\u0001\u0000\u0000\u0000\u00ea\u00e8\u0001\u0000\u0000"+
		"\u0000\u00eb\u00ec\u00057\u0000\u0000\u00ec\u00ed\u0005(\u0000\u0000\u00ed"+
		"\u00ee\u0003@ \u0000\u00ee\u00f0\u0005%\u0000\u0000\u00ef\u00f1\u0003"+
		"$\u0012\u0000\u00f0\u00ef\u0001\u0000\u0000\u0000\u00f0\u00f1\u0001\u0000"+
		"\u0000\u0000\u00f1\u0102\u0001\u0000\u0000\u0000\u00f2\u00f3\u0005\'\u0000"+
		"\u0000\u00f3\u00f4\u0005$\u0000\u0000\u00f4\u00f5\u00057\u0000\u0000\u00f5"+
		"\u00f6\u0005(\u0000\u0000\u00f6\u00f7\u0003@ \u0000\u00f7\u00f9\u0005"+
		"%\u0000\u0000\u00f8\u00fa\u0003$\u0012\u0000\u00f9\u00f8\u0001\u0000\u0000"+
		"\u0000\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa\u0102\u0001\u0000\u0000"+
		"\u0000\u00fb\u00fc\u0003@ \u0000\u00fc\u00fe\u0005%\u0000\u0000\u00fd"+
		"\u00ff\u0003$\u0012\u0000\u00fe\u00fd\u0001\u0000\u0000\u0000\u00fe\u00ff"+
		"\u0001\u0000\u0000\u0000\u00ff\u0102\u0001\u0000\u0000\u0000\u0100\u0102"+
		"\u0003$\u0012\u0000\u0101\u00eb\u0001\u0000\u0000\u0000\u0101\u00f2\u0001"+
		"\u0000\u0000\u0000\u0101\u00fb\u0001\u0000\u0000\u0000\u0101\u0100\u0001"+
		"\u0000\u0000\u0000\u0102#\u0001\u0000\u0000\u0000\u0103\u0104\u0005\b"+
		"\u0000\u0000\u0104\u0105\u0003@ \u0000\u0105\u0106\u0005%\u0000\u0000"+
		"\u0106\u010f\u0001\u0000\u0000\u0000\u0107\u0108\u0005\b\u0000\u0000\u0108"+
		"\u0109\u00057\u0000\u0000\u0109\u010f\u0005%\u0000\u0000\u010a\u010b\u0005"+
		"\b\u0000\u0000\u010b\u010c\u0003\u0014\n\u0000\u010c\u010d\u0005%\u0000"+
		"\u0000\u010d\u010f\u0001\u0000\u0000\u0000\u010e\u0103\u0001\u0000\u0000"+
		"\u0000\u010e\u0107\u0001\u0000\u0000\u0000\u010e\u010a\u0001\u0000\u0000"+
		"\u0000\u010f%\u0001\u0000\u0000\u0000\u0110\u0111\u0005\u0010\u0000\u0000"+
		"\u0111\u0112\u00057\u0000\u0000\u0112\u0116\u00053\u0000\u0000\u0113\u0115"+
		"\u0003(\u0014\u0000\u0114\u0113\u0001\u0000\u0000\u0000\u0115\u0118\u0001"+
		"\u0000\u0000\u0000\u0116\u0114\u0001\u0000\u0000\u0000\u0116\u0117\u0001"+
		"\u0000\u0000\u0000\u0117\u0119\u0001\u0000\u0000\u0000\u0118\u0116\u0001"+
		"\u0000\u0000\u0000\u0119\u011a\u00054\u0000\u0000\u011a\'\u0001\u0000"+
		"\u0000\u0000\u011b\u011e\u0003\u001c\u000e\u0000\u011c\u011e\u0003\u001e"+
		"\u000f\u0000\u011d\u011b\u0001\u0000\u0000\u0000\u011d\u011c\u0001\u0000"+
		"\u0000\u0000\u011e)\u0001\u0000\u0000\u0000\u011f\u0120\u00057\u0000\u0000"+
		"\u0120\u0121\u0005#\u0000\u0000\u0121\u0122\u00032\u0019\u0000\u0122+"+
		"\u0001\u0000\u0000\u0000\u0123\u0128\u0003*\u0015\u0000\u0124\u0125\u0005"+
		"\"\u0000\u0000\u0125\u0127\u0003*\u0015\u0000\u0126\u0124\u0001\u0000"+
		"\u0000\u0000\u0127\u012a\u0001\u0000\u0000\u0000\u0128\u0126\u0001\u0000"+
		"\u0000\u0000\u0128\u0129\u0001\u0000\u0000\u0000\u0129-\u0001\u0000\u0000"+
		"\u0000\u012a\u0128\u0001\u0000\u0000\u0000\u012b\u012c\u0007\u0001\u0000"+
		"\u0000\u012c\u012f\u00057\u0000\u0000\u012d\u012e\u0005(\u0000\u0000\u012e"+
		"\u0130\u0003@ \u0000\u012f\u012d\u0001\u0000\u0000\u0000\u012f\u0130\u0001"+
		"\u0000\u0000\u0000\u0130/\u0001\u0000\u0000\u0000\u0131\u0132\u0005\u0011"+
		"\u0000\u0000\u0132\u0133\u00053\u0000\u0000\u0133\u0134\u00057\u0000\u0000"+
		"\u0134\u0135\u00054\u0000\u0000\u0135\u0136\u0005\u0016\u0000\u0000\u0136"+
		"\u0137\u00058\u0000\u0000\u0137\u0147\u0005%\u0000\u0000\u0138\u0139\u0005"+
		"\u0011\u0000\u0000\u0139\u013a\u00053\u0000\u0000\u013a\u013b\u0005\u0017"+
		"\u0000\u0000\u013b\u013c\u00054\u0000\u0000\u013c\u013d\u0005\u0016\u0000"+
		"\u0000\u013d\u013e\u00058\u0000\u0000\u013e\u0147\u0005%\u0000\u0000\u013f"+
		"\u0140\u0005\u001a\u0000\u0000\u0140\u0141\u0005#\u0000\u0000\u0141\u0143"+
		"\u0005@\u0000\u0000\u0142\u0144\u00057\u0000\u0000\u0143\u0142\u0001\u0000"+
		"\u0000\u0000\u0143\u0144\u0001\u0000\u0000\u0000\u0144\u0145\u0001\u0000"+
		"\u0000\u0000\u0145\u0147\u0005A\u0000\u0000\u0146\u0131\u0001\u0000\u0000"+
		"\u0000\u0146\u0138\u0001\u0000\u0000\u0000\u0146\u013f\u0001\u0000\u0000"+
		"\u0000\u01471\u0001\u0000\u0000\u0000\u0148\u0150\u0005\u001d\u0000\u0000"+
		"\u0149\u0150\u0005\u001e\u0000\u0000\u014a\u0150\u0005\u001f\u0000\u0000"+
		"\u014b\u0150\u0005 \u0000\u0000\u014c\u0150\u0005!\u0000\u0000\u014d\u0150"+
		"\u00057\u0000\u0000\u014e\u0150\u00036\u001b\u0000\u014f\u0148\u0001\u0000"+
		"\u0000\u0000\u014f\u0149\u0001\u0000\u0000\u0000\u014f\u014a\u0001\u0000"+
		"\u0000\u0000\u014f\u014b\u0001\u0000\u0000\u0000\u014f\u014c\u0001\u0000"+
		"\u0000\u0000\u014f\u014d\u0001\u0000\u0000\u0000\u014f\u014e\u0001\u0000"+
		"\u0000\u0000\u01503\u0001\u0000\u0000\u0000\u0151\u0152\u0005\'\u0000"+
		"\u0000\u0152\u0153\u0005$\u0000\u0000\u0153\u0154\u00057\u0000\u0000\u0154"+
		"5\u0001\u0000\u0000\u0000\u0155\u0156\u00057\u0000\u0000\u0156\u0157\u0005"+
		"@\u0000\u0000\u0157\u0158\u0005A\u0000\u0000\u01587\u0001\u0000\u0000"+
		"\u0000\u0159\u015e\u0003>\u001f\u0000\u015a\u015b\u0005\"\u0000\u0000"+
		"\u015b\u015d\u0003>\u001f\u0000\u015c\u015a\u0001\u0000\u0000\u0000\u015d"+
		"\u0160\u0001\u0000\u0000\u0000\u015e\u015c\u0001\u0000\u0000\u0000\u015e"+
		"\u015f\u0001\u0000\u0000\u0000\u015f\u0162\u0001\u0000\u0000\u0000\u0160"+
		"\u015e\u0001\u0000\u0000\u0000\u0161\u0159\u0001\u0000\u0000\u0000\u0161"+
		"\u0162\u0001\u0000\u0000\u0000\u01629\u0001\u0000\u0000\u0000\u0163\u0164"+
		"\u00053\u0000\u0000\u0164\u0165\u0003<\u001e\u0000\u0165\u0167\u00054"+
		"\u0000\u0000\u0166\u0168\u0005\"\u0000\u0000\u0167\u0166\u0001\u0000\u0000"+
		"\u0000\u0167\u0168\u0001\u0000\u0000\u0000\u0168;\u0001\u0000\u0000\u0000"+
		"\u0169\u016a\u00057\u0000\u0000\u016a\u016b\u0005#\u0000\u0000\u016b\u0175"+
		"\u0003>\u001f\u0000\u016c\u016d\u0005\"\u0000\u0000\u016d\u016e\u0005"+
		"7\u0000\u0000\u016e\u016f\u0005#\u0000\u0000\u016f\u0171\u0003>\u001f"+
		"\u0000\u0170\u0172\u0005\"\u0000\u0000\u0171\u0170\u0001\u0000\u0000\u0000"+
		"\u0171\u0172\u0001\u0000\u0000\u0000\u0172\u0174\u0001\u0000\u0000\u0000"+
		"\u0173\u016c\u0001\u0000\u0000\u0000\u0174\u0177\u0001\u0000\u0000\u0000"+
		"\u0175\u0173\u0001\u0000\u0000\u0000\u0175\u0176\u0001\u0000\u0000\u0000"+
		"\u0176\u0179\u0001\u0000\u0000\u0000\u0177\u0175\u0001\u0000\u0000\u0000"+
		"\u0178\u0169\u0001\u0000\u0000\u0000\u0178\u0179\u0001\u0000\u0000\u0000"+
		"\u0179=\u0001\u0000\u0000\u0000\u017a\u0183\u00059\u0000\u0000\u017b\u0183"+
		"\u00058\u0000\u0000\u017c\u0183\u0003\u0014\n\u0000\u017d\u017e\u0005"+
		"@\u0000\u0000\u017e\u017f\u00038\u001c\u0000\u017f\u0180\u0005A\u0000"+
		"\u0000\u0180\u0183\u0001\u0000\u0000\u0000\u0181\u0183\u0003:\u001d\u0000"+
		"\u0182\u017a\u0001\u0000\u0000\u0000\u0182\u017b\u0001\u0000\u0000\u0000"+
		"\u0182\u017c\u0001\u0000\u0000\u0000\u0182\u017d\u0001\u0000\u0000\u0000"+
		"\u0182\u0181\u0001\u0000\u0000\u0000\u0183?\u0001\u0000\u0000\u0000\u0184"+
		"\u0185\u0006 \uffff\uffff\u0000\u0185\u0191\u00058\u0000\u0000\u0186\u0191"+
		"\u00059\u0000\u0000\u0187\u0191\u00057\u0000\u0000\u0188\u0191\u0003\u0014"+
		"\n\u0000\u0189\u0191\u0003D\"\u0000\u018a\u0191\u0003.\u0017\u0000\u018b"+
		"\u0191\u00034\u001a\u0000\u018c\u018d\u00051\u0000\u0000\u018d\u018e\u0003"+
		"@ \u0000\u018e\u018f\u00052\u0000\u0000\u018f\u0191\u0001\u0000\u0000"+
		"\u0000\u0190\u0184\u0001\u0000\u0000\u0000\u0190\u0186\u0001\u0000\u0000"+
		"\u0000\u0190\u0187\u0001\u0000\u0000\u0000\u0190\u0188\u0001\u0000\u0000"+
		"\u0000\u0190\u0189\u0001\u0000\u0000\u0000\u0190\u018a\u0001\u0000\u0000"+
		"\u0000\u0190\u018b\u0001\u0000\u0000\u0000\u0190\u018c\u0001\u0000\u0000"+
		"\u0000\u0191\u0198\u0001\u0000\u0000\u0000\u0192\u0193\n\u0002\u0000\u0000"+
		"\u0193\u0194\u0003B!\u0000\u0194\u0195\u0003@ \u0003\u0195\u0197\u0001"+
		"\u0000\u0000\u0000\u0196\u0192\u0001\u0000\u0000\u0000\u0197\u019a\u0001"+
		"\u0000\u0000\u0000\u0198\u0196\u0001\u0000\u0000\u0000\u0198\u0199\u0001"+
		"\u0000\u0000\u0000\u0199A\u0001\u0000\u0000\u0000\u019a\u0198\u0001\u0000"+
		"\u0000\u0000\u019b\u019c\u0007\u0002\u0000\u0000\u019cC\u0001\u0000\u0000"+
		"\u0000\u019d\u019e\u00057\u0000\u0000\u019e\u01a2\u00051\u0000\u0000\u019f"+
		"\u01a1\u0003F#\u0000\u01a0\u019f\u0001\u0000\u0000\u0000\u01a1\u01a4\u0001"+
		"\u0000\u0000\u0000\u01a2\u01a0\u0001\u0000\u0000\u0000\u01a2\u01a3\u0001"+
		"\u0000\u0000\u0000\u01a3\u01a5\u0001\u0000\u0000\u0000\u01a4\u01a2\u0001"+
		"\u0000\u0000\u0000\u01a5\u01a6\u00052\u0000\u0000\u01a6E\u0001\u0000\u0000"+
		"\u0000\u01a7\u01a8\u0003@ \u0000\u01a8G\u0001\u0000\u0000\u0000\u01a9"+
		"\u01b0\u0003J%\u0000\u01aa\u01ac\u0005T\u0000\u0000\u01ab\u01ad\u0005"+
		"P\u0000\u0000\u01ac\u01ab\u0001\u0000\u0000\u0000\u01ac\u01ad\u0001\u0000"+
		"\u0000\u0000\u01ad\u01b0\u0001\u0000\u0000\u0000\u01ae\u01b0\u0003T*\u0000"+
		"\u01af\u01a9\u0001\u0000\u0000\u0000\u01af\u01aa\u0001\u0000\u0000\u0000"+
		"\u01af\u01ae\u0001\u0000\u0000\u0000\u01b0I\u0001\u0000\u0000\u0000\u01b1"+
		"\u01b5\u0003L&\u0000\u01b2\u01b4\u0003H$\u0000\u01b3\u01b2\u0001\u0000"+
		"\u0000\u0000\u01b4\u01b7\u0001\u0000\u0000\u0000\u01b5\u01b3\u0001\u0000"+
		"\u0000\u0000\u01b5\u01b6\u0001\u0000\u0000\u0000\u01b6\u01b8\u0001\u0000"+
		"\u0000\u0000\u01b7\u01b5\u0001\u0000\u0000\u0000\u01b8\u01b9\u0003N\'"+
		"\u0000\u01b9\u01bc\u0001\u0000\u0000\u0000\u01ba\u01bc\u0003P(\u0000\u01bb"+
		"\u01b1\u0001\u0000\u0000\u0000\u01bb\u01ba\u0001\u0000\u0000\u0000\u01bc"+
		"K\u0001\u0000\u0000\u0000\u01bd\u01c1\u0005F\u0000\u0000\u01be\u01c0\u0003"+
		"R)\u0000\u01bf\u01be\u0001\u0000\u0000\u0000\u01c0\u01c3\u0001\u0000\u0000"+
		"\u0000\u01c1\u01bf\u0001\u0000\u0000\u0000\u01c1\u01c2\u0001\u0000\u0000"+
		"\u0000\u01c2\u01c4\u0001\u0000\u0000\u0000\u01c3\u01c1\u0001\u0000\u0000"+
		"\u0000\u01c4\u01c5\u0005H\u0000\u0000\u01c5M\u0001\u0000\u0000\u0000\u01c6"+
		"\u01c7\u0005G\u0000\u0000\u01c7\u01c8\u0005T\u0000\u0000\u01c8\u01c9\u0005"+
		"H\u0000\u0000\u01c9O\u0001\u0000\u0000\u0000\u01ca\u01ce\u0005F\u0000"+
		"\u0000\u01cb\u01cd\u0003R)\u0000\u01cc\u01cb\u0001\u0000\u0000\u0000\u01cd"+
		"\u01d0\u0001\u0000\u0000\u0000\u01ce\u01cc\u0001\u0000\u0000\u0000\u01ce"+
		"\u01cf\u0001\u0000\u0000\u0000\u01cf\u01d1\u0001\u0000\u0000\u0000\u01d0"+
		"\u01ce\u0001\u0000\u0000\u0000\u01d1\u01d2\u0005I\u0000\u0000\u01d2Q\u0001"+
		"\u0000\u0000\u0000\u01d3\u01d4\u0005T\u0000\u0000\u01d4\u01d5\u0005J\u0000"+
		"\u0000\u01d5\u01e0\u0005K\u0000\u0000\u01d6\u01d7\u0005L\u0000\u0000\u01d7"+
		"\u01d8\u0005J\u0000\u0000\u01d8\u01e0\u0005K\u0000\u0000\u01d9\u01da\u0005"+
		"M\u0000\u0000\u01da\u01db\u0005J\u0000\u0000\u01db\u01e0\u0005K\u0000"+
		"\u0000\u01dc\u01dd\u0005N\u0000\u0000\u01dd\u01de\u0005J\u0000\u0000\u01de"+
		"\u01e0\u0005K\u0000\u0000\u01df\u01d3\u0001\u0000\u0000\u0000\u01df\u01d6"+
		"\u0001\u0000\u0000\u0000\u01df\u01d9\u0001\u0000\u0000\u0000\u01df\u01dc"+
		"\u0001\u0000\u0000\u0000\u01e0S\u0001\u0000\u0000\u0000\u01e1\u01e2\u0005"+
		"Q\u0000\u0000\u01e2\u01e3\u0005T\u0000\u0000\u01e3\u01e4\u0005R\u0000"+
		"\u0000\u01e4U\u0001\u0000\u0000\u0000\u01e5\u01e6\u0005X\u0000\u0000\u01e6"+
		"\u01e7\u0003X,\u0000\u01e7\u01e9\u0005X\u0000\u0000\u01e8\u01ea\u0005"+
		"Z\u0000\u0000\u01e9\u01e8\u0001\u0000\u0000\u0000\u01e9\u01ea\u0001\u0000"+
		"\u0000\u0000\u01eaW\u0001\u0000\u0000\u0000\u01eb\u01ed\u0003Z-\u0000"+
		"\u01ec\u01eb\u0001\u0000\u0000\u0000\u01ec\u01ed\u0001\u0000\u0000\u0000"+
		"\u01ed\u01f4\u0001\u0000\u0000\u0000\u01ee\u01f0\u0005Z\u0000\u0000\u01ef"+
		"\u01ee\u0001\u0000\u0000\u0000\u01ef\u01f0\u0001\u0000\u0000\u0000\u01f0"+
		"\u01f1\u0001\u0000\u0000\u0000\u01f1\u01f3\u0003Z-\u0000\u01f2\u01ef\u0001"+
		"\u0000\u0000\u0000\u01f3\u01f6\u0001\u0000\u0000\u0000\u01f4\u01f2\u0001"+
		"\u0000\u0000\u0000\u01f4\u01f5\u0001\u0000\u0000\u0000\u01f5Y\u0001\u0000"+
		"\u0000\u0000\u01f6\u01f4\u0001\u0000\u0000\u0000\u01f7\u01f9\u0005]\u0000"+
		"\u0000\u01f8\u01fa\u0005h\u0000\u0000\u01f9\u01f8\u0001\u0000\u0000\u0000"+
		"\u01fa\u01fb\u0001\u0000\u0000\u0000\u01fb\u01f9\u0001\u0000\u0000\u0000"+
		"\u01fb\u01fc\u0001\u0000\u0000\u0000\u01fc\u01fd\u0001\u0000\u0000\u0000"+
		"\u01fd\u01ff\u0005_\u0000\u0000\u01fe\u0200\u0003\\.\u0000\u01ff\u01fe"+
		"\u0001\u0000\u0000\u0000\u0200\u0201\u0001\u0000\u0000\u0000\u0201\u01ff"+
		"\u0001\u0000\u0000\u0000\u0201\u0202\u0001\u0000\u0000\u0000\u0202\u0203"+
		"\u0001\u0000\u0000\u0000\u0203\u0204\u0005`\u0000\u0000\u0204[\u0001\u0000"+
		"\u0000\u0000\u0205\u0206\u0005h\u0000\u0000\u0206\u0207\u0005Y\u0000\u0000"+
		"\u0207\u0208\u0003^/\u0000\u0208\u0209\u0005^\u0000\u0000\u0209]\u0001"+
		"\u0000\u0000\u0000\u020a\u020f\u0005a\u0000\u0000\u020b\u020d\u0005h\u0000"+
		"\u0000\u020c\u020e\u0005h\u0000\u0000\u020d\u020c\u0001\u0000\u0000\u0000"+
		"\u020d\u020e\u0001\u0000\u0000\u0000\u020e\u0210\u0001\u0000\u0000\u0000"+
		"\u020f\u020b\u0001\u0000\u0000\u0000\u020f\u0210\u0001\u0000\u0000\u0000"+
		"\u0210\u0219\u0001\u0000\u0000\u0000\u0211\u0216\u0005h\u0000\u0000\u0212"+
		"\u0214\u0005h\u0000\u0000\u0213\u0215\u0005h\u0000\u0000\u0214\u0213\u0001"+
		"\u0000\u0000\u0000\u0214\u0215\u0001\u0000\u0000\u0000\u0215\u0217\u0001"+
		"\u0000\u0000\u0000\u0216\u0212\u0001\u0000\u0000\u0000\u0216\u0217\u0001"+
		"\u0000\u0000\u0000\u0217\u0219\u0001\u0000\u0000\u0000\u0218\u020a\u0001"+
		"\u0000\u0000\u0000\u0218\u0211\u0001\u0000\u0000\u0000\u0219_\u0001\u0000"+
		"\u0000\u0000:cms\u0082\u008a\u009a\u00a5\u00aa\u00b3\u00b7\u00bf\u00c7"+
		"\u00d0\u00d3\u00d5\u00da\u00df\u00e8\u00f0\u00f9\u00fe\u0101\u010e\u0116"+
		"\u011d\u0128\u012f\u0143\u0146\u014f\u015e\u0161\u0167\u0171\u0175\u0178"+
		"\u0182\u0190\u0198\u01a2\u01ac\u01af\u01b5\u01bb\u01c1\u01ce\u01df\u01e9"+
		"\u01ec\u01ef\u01f4\u01fb\u0201\u020d\u020f\u0214\u0216\u0218";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}