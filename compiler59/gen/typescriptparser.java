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
		RULE_program = 0, RULE_statement = 1, RULE_componentDeclaration = 2, RULE_componentDeclarationBody = 3, 
		RULE_componentBodyElement = 4, RULE_selector = 5, RULE_standalone = 6, 
		RULE_template = 7, RULE_styles = 8, RULE_isboolean = 9, RULE_classDeclaration = 10, 
		RULE_classDeclarationBody = 11, RULE_classMember = 12, RULE_propertyDeclaration = 13, 
		RULE_methodDeclaration = 14, RULE_methodBody = 15, RULE_statementMethod = 16, 
		RULE_interfaceDeclaration = 17, RULE_interfaceMember = 18, RULE_parameter = 19, 
		RULE_parameterList = 20, RULE_variableDeclaration = 21, RULE_importDeclaration = 22, 
		RULE_type = 23, RULE_memberAccess = 24, RULE_list = 25, RULE_bodylist = 26, 
		RULE_object = 27, RULE_bodyobject = 28, RULE_initvalue = 29, RULE_expression = 30, 
		RULE_operator = 31, RULE_functionCall = 32, RULE_argument = 33, RULE_element = 34, 
		RULE_tag = 35, RULE_openingTag = 36, RULE_closingTag = 37, RULE_selfClosingTag = 38, 
		RULE_attributes = 39, RULE_interpolation = 40, RULE_cssBody = 41, RULE_cssObjects = 42, 
		RULE_csselement = 43, RULE_bodyelement = 44, RULE_cssValue = 45;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "componentDeclaration", "componentDeclarationBody", 
			"componentBodyElement", "selector", "standalone", "template", "styles", 
			"isboolean", "classDeclaration", "classDeclarationBody", "classMember", 
			"propertyDeclaration", "methodDeclaration", "methodBody", "statementMethod", 
			"interfaceDeclaration", "interfaceMember", "parameter", "parameterList", 
			"variableDeclaration", "importDeclaration", "type", "memberAccess", "list", 
			"bodylist", "object", "bodyobject", "initvalue", "expression", "operator", 
			"functionCall", "argument", "element", "tag", "openingTag", "closingTag", 
			"selfClosingTag", "attributes", "interpolation", "cssBody", "cssObjects", 
			"csselement", "bodyelement", "cssValue"
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
			setState(93); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(92);
				statement();
				}
				}
				setState(95); 
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
		public MethodDeclarationContext methodDeclaration() {
			return getRuleContext(MethodDeclarationContext.class,0);
		}
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
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
			setState(103);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DECORATOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				componentDeclaration();
				}
				break;
			case CLASS:
			case EXPORT:
				enterOuterAlt(_localctx, 2);
				{
				setState(98);
				classDeclaration();
				}
				break;
			case INTERFACE:
				enterOuterAlt(_localctx, 3);
				{
				setState(99);
				interfaceDeclaration();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 4);
				{
				setState(100);
				methodDeclaration();
				}
				break;
			case CONST:
			case LET:
			case VAR:
				enterOuterAlt(_localctx, 5);
				{
				setState(101);
				variableDeclaration();
				}
				break;
			case IMPORT:
			case IMPORTS:
				enterOuterAlt(_localctx, 6);
				{
				setState(102);
				importDeclaration();
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
		enterRule(_localctx, 4, RULE_componentDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(DECORATOR);
			setState(106);
			match(COMPONENT);
			setState(107);
			match(LPAREN);
			setState(108);
			match(LBRACE);
			setState(109);
			componentDeclarationBody();
			setState(110);
			match(RBRACE);
			setState(111);
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
		enterRule(_localctx, 6, RULE_componentDeclarationBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			componentBodyElement();
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(114);
				match(COMMA);
				setState(115);
				componentBodyElement();
				}
				}
				setState(120);
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
		enterRule(_localctx, 8, RULE_componentBodyElement);
		try {
			setState(126);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SELECTOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(121);
				selector();
				}
				break;
			case STANDALONE:
				enterOuterAlt(_localctx, 2);
				{
				setState(122);
				standalone();
				}
				break;
			case IMPORT:
			case IMPORTS:
				enterOuterAlt(_localctx, 3);
				{
				setState(123);
				importDeclaration();
				}
				break;
			case TEMPLATE:
				enterOuterAlt(_localctx, 4);
				{
				setState(124);
				template();
				}
				break;
			case STYLES:
				enterOuterAlt(_localctx, 5);
				{
				setState(125);
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
		enterRule(_localctx, 10, RULE_selector);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(SELECTOR);
			setState(129);
			match(COLON);
			setState(130);
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
		enterRule(_localctx, 12, RULE_standalone);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(STANDALONE);
			setState(133);
			match(COLON);
			setState(134);
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
		enterRule(_localctx, 14, RULE_template);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(TEMPLATE);
			setState(137);
			match(COLON_HTML);
			setState(138);
			match(BACKTICK_HTML);
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & 18433L) != 0)) {
				{
				{
				setState(139);
				element();
				}
				}
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(145);
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
		public TerminalNode STYLES() { return getToken(typescriptparser.STYLES, 0); }
		public TerminalNode COLON_CSS() { return getToken(typescriptparser.COLON_CSS, 0); }
		public TerminalNode OPEN_LIST() { return getToken(typescriptparser.OPEN_LIST, 0); }
		public CssBodyContext cssBody() {
			return getRuleContext(CssBodyContext.class,0);
		}
		public TerminalNode CLOSE_LIST() { return getToken(typescriptparser.CLOSE_LIST, 0); }
		public TerminalNode COMMA() { return getToken(typescriptparser.COMMA, 0); }
		public StylesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_styles; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterStyles(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitStyles(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitStyles(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StylesContext styles() throws RecognitionException {
		StylesContext _localctx = new StylesContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_styles);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(STYLES);
			setState(148);
			match(COLON_CSS);
			setState(149);
			match(OPEN_LIST);
			setState(150);
			cssBody();
			setState(151);
			match(CLOSE_LIST);
			setState(153);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(152);
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
		enterRule(_localctx, 18, RULE_isboolean);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
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
		enterRule(_localctx, 20, RULE_classDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXPORT) {
				{
				setState(157);
				match(EXPORT);
				}
			}

			setState(160);
			match(CLASS);
			setState(161);
			match(ID);
			setState(162);
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
		enterRule(_localctx, 22, RULE_classDeclarationBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(LBRACE);
			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(165);
				classMember();
				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(166);
					match(SEMICOLON);
					}
				}

				}
				}
				setState(173);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(174);
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
		enterRule(_localctx, 24, RULE_classMember);
		try {
			setState(178);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(176);
				methodDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(177);
				propertyDeclaration();
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
		enterRule(_localctx, 26, RULE_propertyDeclaration);
		int _la;
		try {
			setState(200);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(180);
				match(ID);
				setState(181);
				match(COLON);
				setState(182);
				type();
				setState(183);
				match(ASSIGN);
				setState(184);
				initvalue();
				setState(186);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(185);
					match(SEMICOLON);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(188);
				match(ID);
				setState(189);
				match(COLON);
				setState(190);
				type();
				setState(195);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OR) {
					{
					setState(191);
					match(OR);
					setState(192);
					match(ID);
					setState(193);
					match(ASSIGN);
					setState(194);
					match(ID);
					}
				}

				setState(198);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(197);
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
		enterRule(_localctx, 28, RULE_methodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			match(ID);
			setState(203);
			match(LPAREN);
			setState(205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(204);
				parameterList();
				}
			}

			setState(207);
			match(RPAREN);
			setState(208);
			match(COLON);
			setState(210);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 36028813661962240L) != 0)) {
				{
				setState(209);
				type();
				}
			}

			setState(212);
			match(LBRACE);
			setState(213);
			methodBody();
			setState(214);
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
		enterRule(_localctx, 30, RULE_methodBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 279786676609875968L) != 0)) {
				{
				{
				setState(216);
				statementMethod();
				}
				}
				setState(221);
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
		enterRule(_localctx, 32, RULE_statementMethod);
		try {
			setState(237);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(222);
				match(ID);
				setState(223);
				match(ASSIGN);
				setState(224);
				expression(0);
				setState(225);
				match(SEMICOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(227);
				match(THIS);
				setState(228);
				match(DOT);
				setState(229);
				match(ID);
				setState(230);
				match(ASSIGN);
				setState(231);
				expression(0);
				setState(232);
				match(SEMICOLON);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(234);
				expression(0);
				setState(235);
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
		enterRule(_localctx, 34, RULE_interfaceDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			match(INTERFACE);
			setState(240);
			match(ID);
			setState(241);
			match(LBRACE);
			setState(245);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(242);
				interfaceMember();
				}
				}
				setState(247);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(248);
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
		enterRule(_localctx, 36, RULE_interfaceMember);
		try {
			setState(252);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(250);
				propertyDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(251);
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
		enterRule(_localctx, 38, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			match(ID);
			setState(255);
			match(COLON);
			setState(256);
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
		enterRule(_localctx, 40, RULE_parameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			parameter();
			setState(263);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(259);
				match(COMMA);
				setState(260);
				parameter();
				}
				}
				setState(265);
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
		enterRule(_localctx, 42, RULE_variableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3670016L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(267);
			match(ID);
			setState(270);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(268);
				match(ASSIGN);
				setState(269);
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
		enterRule(_localctx, 44, RULE_importDeclaration);
		int _la;
		try {
			setState(293);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(272);
				match(IMPORT);
				setState(273);
				match(LBRACE);
				setState(274);
				match(ID);
				setState(275);
				match(RBRACE);
				setState(276);
				match(FROM);
				setState(277);
				match(STRING_LIT);
				setState(278);
				match(SEMICOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(279);
				match(IMPORT);
				setState(280);
				match(LBRACE);
				setState(281);
				match(COMPONENT);
				setState(282);
				match(RBRACE);
				setState(283);
				match(FROM);
				setState(284);
				match(STRING_LIT);
				setState(285);
				match(SEMICOLON);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(286);
				match(IMPORTS);
				setState(287);
				match(COLON);
				setState(288);
				match(LBRACKET);
				setState(290);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(289);
					match(ID);
					}
				}

				setState(292);
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
		enterRule(_localctx, 46, RULE_type);
		try {
			setState(302);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(295);
				match(STRING_TYPE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(296);
				match(NUMBER_TYPE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(297);
				match(BOOLEAN_TYPE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(298);
				match(ANY_TYPE);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(299);
				match(VOID_TYPE);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(300);
				match(ID);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(301);
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
		enterRule(_localctx, 48, RULE_memberAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			match(THIS);
			setState(305);
			match(DOT);
			setState(306);
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
		enterRule(_localctx, 50, RULE_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			match(ID);
			setState(309);
			match(LBRACKET);
			setState(310);
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
		enterRule(_localctx, 52, RULE_bodylist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 51)) & ~0x3f) == 0 && ((1L << (_la - 51)) & 8301L) != 0)) {
				{
				setState(312);
				initvalue();
				setState(317);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(313);
					match(COMMA);
					setState(314);
					initvalue();
					}
					}
					setState(319);
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
		enterRule(_localctx, 54, RULE_object);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322);
			match(LBRACE);
			setState(323);
			bodyobject();
			setState(324);
			match(RBRACE);
			setState(326);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(325);
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
		enterRule(_localctx, 56, RULE_bodyobject);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(328);
				match(ID);
				setState(329);
				match(COLON);
				setState(330);
				initvalue();
				setState(340);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(331);
					match(COMMA);
					setState(332);
					match(ID);
					setState(333);
					match(COLON);
					setState(334);
					initvalue();
					setState(336);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
					case 1:
						{
						setState(335);
						match(COMMA);
						}
						break;
					}
					}
					}
					setState(342);
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
		enterRule(_localctx, 58, RULE_initvalue);
		try {
			setState(353);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER_LIT:
				enterOuterAlt(_localctx, 1);
				{
				setState(345);
				match(NUMBER_LIT);
				}
				break;
			case STRING_LIT:
				enterOuterAlt(_localctx, 2);
				{
				setState(346);
				match(STRING_LIT);
				}
				break;
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 3);
				{
				setState(347);
				isboolean();
				}
				break;
			case LBRACKET:
				enterOuterAlt(_localctx, 4);
				{
				setState(348);
				match(LBRACKET);
				setState(349);
				bodylist();
				setState(350);
				match(RBRACKET);
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 5);
				{
				setState(352);
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
		int _startState = 60;
		enterRecursionRule(_localctx, 60, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(367);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(356);
				match(STRING_LIT);
				}
				break;
			case 2:
				{
				setState(357);
				match(NUMBER_LIT);
				}
				break;
			case 3:
				{
				setState(358);
				match(ID);
				}
				break;
			case 4:
				{
				setState(359);
				isboolean();
				}
				break;
			case 5:
				{
				setState(360);
				functionCall();
				}
				break;
			case 6:
				{
				setState(361);
				variableDeclaration();
				}
				break;
			case 7:
				{
				setState(362);
				memberAccess();
				}
				break;
			case 8:
				{
				setState(363);
				match(LPAREN);
				setState(364);
				expression(0);
				setState(365);
				match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(375);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expression);
					setState(369);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(370);
					operator();
					setState(371);
					expression(3);
					}
					} 
				}
				setState(377);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
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
		enterRule(_localctx, 62, RULE_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
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
		enterRule(_localctx, 64, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(380);
			match(ID);
			setState(381);
			match(LPAREN);
			setState(385);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 279786676609875968L) != 0)) {
				{
				{
				setState(382);
				argument();
				}
				}
				setState(387);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(388);
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
		enterRule(_localctx, 66, RULE_argument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(390);
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
		enterRule(_localctx, 68, RULE_element);
		int _la;
		try {
			setState(398);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TAG_OPEN_START_HTML:
				enterOuterAlt(_localctx, 1);
				{
				setState(392);
				tag();
				}
				break;
			case NAME_HTML:
				enterOuterAlt(_localctx, 2);
				{
				setState(393);
				match(NAME_HTML);
				setState(395);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLON_HTML) {
					{
					setState(394);
					match(COLON_HTML);
					}
				}

				}
				break;
			case INTERPOLATION_START_HTML:
				enterOuterAlt(_localctx, 3);
				{
				setState(397);
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
		enterRule(_localctx, 70, RULE_tag);
		int _la;
		try {
			setState(410);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(400);
				openingTag();
				setState(404);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & 18433L) != 0)) {
					{
					{
					setState(401);
					element();
					}
					}
					setState(406);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(407);
				closingTag();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(409);
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
		enterRule(_localctx, 72, RULE_openingTag);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(412);
			match(TAG_OPEN_START_HTML);
			setState(416);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & 263L) != 0)) {
				{
				{
				setState(413);
				attributes();
				}
				}
				setState(418);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(419);
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
		enterRule(_localctx, 74, RULE_closingTag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(421);
			match(TAG_CLOSE_START_HTML);
			setState(422);
			match(NAME_HTML);
			setState(423);
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
		enterRule(_localctx, 76, RULE_selfClosingTag);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(425);
			match(TAG_OPEN_START_HTML);
			setState(429);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & 263L) != 0)) {
				{
				{
				setState(426);
				attributes();
				}
				}
				setState(431);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(432);
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
		enterRule(_localctx, 78, RULE_attributes);
		try {
			setState(446);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME_HTML:
				enterOuterAlt(_localctx, 1);
				{
				setState(434);
				match(NAME_HTML);
				setState(435);
				match(ATTRIBUTE_EQUALS_HTML);
				setState(436);
				match(STRING_HTML);
				}
				break;
			case STRUCTURAL_DIR_HTML:
				enterOuterAlt(_localctx, 2);
				{
				setState(437);
				match(STRUCTURAL_DIR_HTML);
				setState(438);
				match(ATTRIBUTE_EQUALS_HTML);
				setState(439);
				match(STRING_HTML);
				}
				break;
			case BINDING_HTML:
				enterOuterAlt(_localctx, 3);
				{
				setState(440);
				match(BINDING_HTML);
				setState(441);
				match(ATTRIBUTE_EQUALS_HTML);
				setState(442);
				match(STRING_HTML);
				}
				break;
			case EVENT_BINDING_HTML:
				enterOuterAlt(_localctx, 4);
				{
				setState(443);
				match(EVENT_BINDING_HTML);
				setState(444);
				match(ATTRIBUTE_EQUALS_HTML);
				setState(445);
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
		enterRule(_localctx, 80, RULE_interpolation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(448);
			match(INTERPOLATION_START_HTML);
			setState(449);
			match(NAME_HTML);
			setState(450);
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
		public List<TerminalNode> BACKTICK_CSS() { return getTokens(typescriptparser.BACKTICK_CSS); }
		public TerminalNode BACKTICK_CSS(int i) {
			return getToken(typescriptparser.BACKTICK_CSS, i);
		}
		public CssObjectsContext cssObjects() {
			return getRuleContext(CssObjectsContext.class,0);
		}
		public TerminalNode COMMA_CSS() { return getToken(typescriptparser.COMMA_CSS, 0); }
		public CssBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterCssBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitCssBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitCssBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssBodyContext cssBody() throws RecognitionException {
		CssBodyContext _localctx = new CssBodyContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_cssBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(452);
			match(BACKTICK_CSS);
			setState(453);
			cssObjects();
			setState(454);
			match(BACKTICK_CSS);
			setState(456);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA_CSS) {
				{
				setState(455);
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
		public CssObjectsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssObjects; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterCssObjects(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitCssObjects(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitCssObjects(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssObjectsContext cssObjects() throws RecognitionException {
		CssObjectsContext _localctx = new CssObjectsContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_cssObjects);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(459);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				{
				setState(458);
				csselement();
				}
				break;
			}
			setState(467);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA_CSS || _la==DOT_CSS) {
				{
				{
				setState(462);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA_CSS) {
					{
					setState(461);
					match(COMMA_CSS);
					}
				}

				setState(464);
				csselement();
				}
				}
				setState(469);
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
		public CsselementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_csselement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterCsselement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitCsselement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitCsselement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CsselementContext csselement() throws RecognitionException {
		CsselementContext _localctx = new CsselementContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_csselement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(470);
			match(DOT_CSS);
			setState(472); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(471);
				match(ID_CSS);
				}
				}
				setState(474); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID_CSS );
			setState(476);
			match(LBRACE_CSS);
			setState(478); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(477);
				bodyelement();
				}
				}
				setState(480); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID_CSS );
			setState(482);
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
		public TerminalNode ID_CSS() { return getToken(typescriptparser.ID_CSS, 0); }
		public TerminalNode COLON_CSS() { return getToken(typescriptparser.COLON_CSS, 0); }
		public CssValueContext cssValue() {
			return getRuleContext(CssValueContext.class,0);
		}
		public TerminalNode SEMICOLON_CSS() { return getToken(typescriptparser.SEMICOLON_CSS, 0); }
		public BodyelementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bodyelement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterBodyelement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitBodyelement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitBodyelement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyelementContext bodyelement() throws RecognitionException {
		BodyelementContext _localctx = new BodyelementContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_bodyelement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(484);
			match(ID_CSS);
			setState(485);
			match(COLON_CSS);
			setState(486);
			cssValue();
			setState(487);
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
		public TerminalNode PERCENT() { return getToken(typescriptparser.PERCENT, 0); }
		public List<TerminalNode> ID_CSS() { return getTokens(typescriptparser.ID_CSS); }
		public TerminalNode ID_CSS(int i) {
			return getToken(typescriptparser.ID_CSS, i);
		}
		public CssValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).enterCssValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typescriptparserListener ) ((typescriptparserListener)listener).exitCssValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typescriptparserVisitor ) return ((typescriptparserVisitor<? extends T>)visitor).visitCssValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssValueContext cssValue() throws RecognitionException {
		CssValueContext _localctx = new CssValueContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_cssValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(489);
			_la = _input.LA(1);
			if ( !(_la==PERCENT || _la==ID_CSS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(494);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID_CSS) {
				{
				setState(490);
				match(ID_CSS);
				setState(492);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID_CSS) {
					{
					setState(491);
					match(ID_CSS);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 30:
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
		"\u0004\u0001h\u01f1\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"-\u0007-\u0001\u0000\u0004\u0000^\b\u0000\u000b\u0000\f\u0000_\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"h\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0005\u0003u\b\u0003\n\u0003\f\u0003x\t\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u007f\b\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007"+
		"\u008d\b\u0007\n\u0007\f\u0007\u0090\t\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u009a\b\b\u0001\t\u0001"+
		"\t\u0001\n\u0003\n\u009f\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0003\u000b\u00a8\b\u000b\u0005\u000b\u00aa\b"+
		"\u000b\n\u000b\f\u000b\u00ad\t\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0003\f\u00b3\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003"+
		"\r\u00bb\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003"+
		"\r\u00c4\b\r\u0001\r\u0003\r\u00c7\b\r\u0003\r\u00c9\b\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0003\u000e\u00ce\b\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0003\u000e\u00d3\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000f\u0005\u000f\u00da\b\u000f\n\u000f\f\u000f\u00dd\t\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u00ee\b\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u00f4\b\u0011\n\u0011"+
		"\f\u0011\u00f7\t\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012"+
		"\u0003\u0012\u00fd\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0005\u0014\u0106\b\u0014\n\u0014"+
		"\f\u0014\u0109\t\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0003\u0015\u010f\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0003\u0016\u0123\b\u0016\u0001\u0016\u0003\u0016"+
		"\u0126\b\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0003\u0017\u012f\b\u0017\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0005\u001a\u013c\b\u001a\n\u001a"+
		"\f\u001a\u013f\t\u001a\u0003\u001a\u0141\b\u001a\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0003\u001b\u0147\b\u001b\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0003\u001c\u0151\b\u001c\u0005\u001c\u0153\b\u001c\n\u001c\f\u001c\u0156"+
		"\t\u001c\u0003\u001c\u0158\b\u001c\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0003\u001d"+
		"\u0162\b\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0003\u001e\u0170\b\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0005\u001e\u0176\b\u001e\n\u001e\f\u001e\u0179\t\u001e\u0001"+
		"\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0005 \u0180\b \n \f \u0183\t"+
		" \u0001 \u0001 \u0001!\u0001!\u0001\"\u0001\"\u0001\"\u0003\"\u018c\b"+
		"\"\u0001\"\u0003\"\u018f\b\"\u0001#\u0001#\u0005#\u0193\b#\n#\f#\u0196"+
		"\t#\u0001#\u0001#\u0001#\u0003#\u019b\b#\u0001$\u0001$\u0005$\u019f\b"+
		"$\n$\f$\u01a2\t$\u0001$\u0001$\u0001%\u0001%\u0001%\u0001%\u0001&\u0001"+
		"&\u0005&\u01ac\b&\n&\f&\u01af\t&\u0001&\u0001&\u0001\'\u0001\'\u0001\'"+
		"\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001"+
		"\'\u0003\'\u01bf\b\'\u0001(\u0001(\u0001(\u0001(\u0001)\u0001)\u0001)"+
		"\u0001)\u0003)\u01c9\b)\u0001*\u0003*\u01cc\b*\u0001*\u0003*\u01cf\b*"+
		"\u0001*\u0005*\u01d2\b*\n*\f*\u01d5\t*\u0001+\u0001+\u0004+\u01d9\b+\u000b"+
		"+\f+\u01da\u0001+\u0001+\u0004+\u01df\b+\u000b+\f+\u01e0\u0001+\u0001"+
		"+\u0001,\u0001,\u0001,\u0001,\u0001,\u0001-\u0001-\u0001-\u0003-\u01ed"+
		"\b-\u0003-\u01ef\b-\u0001-\u0000\u0001<.\u0000\u0002\u0004\u0006\b\n\f"+
		"\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:"+
		"<>@BDFHJLNPRTVXZ\u0000\u0004\u0001\u000056\u0001\u0000\u0013\u0015\u0001"+
		"\u0000),\u0002\u0000aahh\u020e\u0000]\u0001\u0000\u0000\u0000\u0002g\u0001"+
		"\u0000\u0000\u0000\u0004i\u0001\u0000\u0000\u0000\u0006q\u0001\u0000\u0000"+
		"\u0000\b~\u0001\u0000\u0000\u0000\n\u0080\u0001\u0000\u0000\u0000\f\u0084"+
		"\u0001\u0000\u0000\u0000\u000e\u0088\u0001\u0000\u0000\u0000\u0010\u0093"+
		"\u0001\u0000\u0000\u0000\u0012\u009b\u0001\u0000\u0000\u0000\u0014\u009e"+
		"\u0001\u0000\u0000\u0000\u0016\u00a4\u0001\u0000\u0000\u0000\u0018\u00b2"+
		"\u0001\u0000\u0000\u0000\u001a\u00c8\u0001\u0000\u0000\u0000\u001c\u00ca"+
		"\u0001\u0000\u0000\u0000\u001e\u00db\u0001\u0000\u0000\u0000 \u00ed\u0001"+
		"\u0000\u0000\u0000\"\u00ef\u0001\u0000\u0000\u0000$\u00fc\u0001\u0000"+
		"\u0000\u0000&\u00fe\u0001\u0000\u0000\u0000(\u0102\u0001\u0000\u0000\u0000"+
		"*\u010a\u0001\u0000\u0000\u0000,\u0125\u0001\u0000\u0000\u0000.\u012e"+
		"\u0001\u0000\u0000\u00000\u0130\u0001\u0000\u0000\u00002\u0134\u0001\u0000"+
		"\u0000\u00004\u0140\u0001\u0000\u0000\u00006\u0142\u0001\u0000\u0000\u0000"+
		"8\u0157\u0001\u0000\u0000\u0000:\u0161\u0001\u0000\u0000\u0000<\u016f"+
		"\u0001\u0000\u0000\u0000>\u017a\u0001\u0000\u0000\u0000@\u017c\u0001\u0000"+
		"\u0000\u0000B\u0186\u0001\u0000\u0000\u0000D\u018e\u0001\u0000\u0000\u0000"+
		"F\u019a\u0001\u0000\u0000\u0000H\u019c\u0001\u0000\u0000\u0000J\u01a5"+
		"\u0001\u0000\u0000\u0000L\u01a9\u0001\u0000\u0000\u0000N\u01be\u0001\u0000"+
		"\u0000\u0000P\u01c0\u0001\u0000\u0000\u0000R\u01c4\u0001\u0000\u0000\u0000"+
		"T\u01cb\u0001\u0000\u0000\u0000V\u01d6\u0001\u0000\u0000\u0000X\u01e4"+
		"\u0001\u0000\u0000\u0000Z\u01e9\u0001\u0000\u0000\u0000\\^\u0003\u0002"+
		"\u0001\u0000]\\\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_]\u0001"+
		"\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000`\u0001\u0001\u0000\u0000"+
		"\u0000ah\u0003\u0004\u0002\u0000bh\u0003\u0014\n\u0000ch\u0003\"\u0011"+
		"\u0000dh\u0003\u001c\u000e\u0000eh\u0003*\u0015\u0000fh\u0003,\u0016\u0000"+
		"ga\u0001\u0000\u0000\u0000gb\u0001\u0000\u0000\u0000gc\u0001\u0000\u0000"+
		"\u0000gd\u0001\u0000\u0000\u0000ge\u0001\u0000\u0000\u0000gf\u0001\u0000"+
		"\u0000\u0000h\u0003\u0001\u0000\u0000\u0000ij\u0005=\u0000\u0000jk\u0005"+
		"\u0017\u0000\u0000kl\u00051\u0000\u0000lm\u00053\u0000\u0000mn\u0003\u0006"+
		"\u0003\u0000no\u00054\u0000\u0000op\u00052\u0000\u0000p\u0005\u0001\u0000"+
		"\u0000\u0000qv\u0003\b\u0004\u0000rs\u0005\"\u0000\u0000su\u0003\b\u0004"+
		"\u0000tr\u0001\u0000\u0000\u0000ux\u0001\u0000\u0000\u0000vt\u0001\u0000"+
		"\u0000\u0000vw\u0001\u0000\u0000\u0000w\u0007\u0001\u0000\u0000\u0000"+
		"xv\u0001\u0000\u0000\u0000y\u007f\u0003\n\u0005\u0000z\u007f\u0003\f\u0006"+
		"\u0000{\u007f\u0003,\u0016\u0000|\u007f\u0003\u000e\u0007\u0000}\u007f"+
		"\u0003\u0010\b\u0000~y\u0001\u0000\u0000\u0000~z\u0001\u0000\u0000\u0000"+
		"~{\u0001\u0000\u0000\u0000~|\u0001\u0000\u0000\u0000~}\u0001\u0000\u0000"+
		"\u0000\u007f\t\u0001\u0000\u0000\u0000\u0080\u0081\u0005\u0018\u0000\u0000"+
		"\u0081\u0082\u0005#\u0000\u0000\u0082\u0083\u00058\u0000\u0000\u0083\u000b"+
		"\u0001\u0000\u0000\u0000\u0084\u0085\u0005\u0019\u0000\u0000\u0085\u0086"+
		"\u0005#\u0000\u0000\u0086\u0087\u0003\u0012\t\u0000\u0087\r\u0001\u0000"+
		"\u0000\u0000\u0088\u0089\u0005\u001b\u0000\u0000\u0089\u008a\u0005P\u0000"+
		"\u0000\u008a\u008e\u0005W\u0000\u0000\u008b\u008d\u0003D\"\u0000\u008c"+
		"\u008b\u0001\u0000\u0000\u0000\u008d\u0090\u0001\u0000\u0000\u0000\u008e"+
		"\u008c\u0001\u0000\u0000\u0000\u008e\u008f\u0001\u0000\u0000\u0000\u008f"+
		"\u0091\u0001\u0000\u0000\u0000\u0090\u008e\u0001\u0000\u0000\u0000\u0091"+
		"\u0092\u0005V\u0000\u0000\u0092\u000f\u0001\u0000\u0000\u0000\u0093\u0094"+
		"\u0005\u001c\u0000\u0000\u0094\u0095\u0005Y\u0000\u0000\u0095\u0096\u0005"+
		"[\u0000\u0000\u0096\u0097\u0003R)\u0000\u0097\u0099\u0005\\\u0000\u0000"+
		"\u0098\u009a\u0005\"\u0000\u0000\u0099\u0098\u0001\u0000\u0000\u0000\u0099"+
		"\u009a\u0001\u0000\u0000\u0000\u009a\u0011\u0001\u0000\u0000\u0000\u009b"+
		"\u009c\u0007\u0000\u0000\u0000\u009c\u0013\u0001\u0000\u0000\u0000\u009d"+
		"\u009f\u0005\u0012\u0000\u0000\u009e\u009d\u0001\u0000\u0000\u0000\u009e"+
		"\u009f\u0001\u0000\u0000\u0000\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0"+
		"\u00a1\u0005\u000f\u0000\u0000\u00a1\u00a2\u00057\u0000\u0000\u00a2\u00a3"+
		"\u0003\u0016\u000b\u0000\u00a3\u0015\u0001\u0000\u0000\u0000\u00a4\u00ab"+
		"\u00053\u0000\u0000\u00a5\u00a7\u0003\u0018\f\u0000\u00a6\u00a8\u0005"+
		"%\u0000\u0000\u00a7\u00a6\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000"+
		"\u0000\u0000\u00a8\u00aa\u0001\u0000\u0000\u0000\u00a9\u00a5\u0001\u0000"+
		"\u0000\u0000\u00aa\u00ad\u0001\u0000\u0000\u0000\u00ab\u00a9\u0001\u0000"+
		"\u0000\u0000\u00ab\u00ac\u0001\u0000\u0000\u0000\u00ac\u00ae\u0001\u0000"+
		"\u0000\u0000\u00ad\u00ab\u0001\u0000\u0000\u0000\u00ae\u00af\u00054\u0000"+
		"\u0000\u00af\u0017\u0001\u0000\u0000\u0000\u00b0\u00b3\u0003\u001c\u000e"+
		"\u0000\u00b1\u00b3\u0003\u001a\r\u0000\u00b2\u00b0\u0001\u0000\u0000\u0000"+
		"\u00b2\u00b1\u0001\u0000\u0000\u0000\u00b3\u0019\u0001\u0000\u0000\u0000"+
		"\u00b4\u00b5\u00057\u0000\u0000\u00b5\u00b6\u0005#\u0000\u0000\u00b6\u00b7"+
		"\u0003.\u0017\u0000\u00b7\u00b8\u0005(\u0000\u0000\u00b8\u00ba\u0003:"+
		"\u001d\u0000\u00b9\u00bb\u0005%\u0000\u0000\u00ba\u00b9\u0001\u0000\u0000"+
		"\u0000\u00ba\u00bb\u0001\u0000\u0000\u0000\u00bb\u00c9\u0001\u0000\u0000"+
		"\u0000\u00bc\u00bd\u00057\u0000\u0000\u00bd\u00be\u0005#\u0000\u0000\u00be"+
		"\u00c3\u0003.\u0017\u0000\u00bf\u00c0\u0005B\u0000\u0000\u00c0\u00c1\u0005"+
		"7\u0000\u0000\u00c1\u00c2\u0005(\u0000\u0000\u00c2\u00c4\u00057\u0000"+
		"\u0000\u00c3\u00bf\u0001\u0000\u0000\u0000\u00c3\u00c4\u0001\u0000\u0000"+
		"\u0000\u00c4\u00c6\u0001\u0000\u0000\u0000\u00c5\u00c7\u0005%\u0000\u0000"+
		"\u00c6\u00c5\u0001\u0000\u0000\u0000\u00c6\u00c7\u0001\u0000\u0000\u0000"+
		"\u00c7\u00c9\u0001\u0000\u0000\u0000\u00c8\u00b4\u0001\u0000\u0000\u0000"+
		"\u00c8\u00bc\u0001\u0000\u0000\u0000\u00c9\u001b\u0001\u0000\u0000\u0000"+
		"\u00ca\u00cb\u00057\u0000\u0000\u00cb\u00cd\u00051\u0000\u0000\u00cc\u00ce"+
		"\u0003(\u0014\u0000\u00cd\u00cc\u0001\u0000\u0000\u0000\u00cd\u00ce\u0001"+
		"\u0000\u0000\u0000\u00ce\u00cf\u0001\u0000\u0000\u0000\u00cf\u00d0\u0005"+
		"2\u0000\u0000\u00d0\u00d2\u0005#\u0000\u0000\u00d1\u00d3\u0003.\u0017"+
		"\u0000\u00d2\u00d1\u0001\u0000\u0000\u0000\u00d2\u00d3\u0001\u0000\u0000"+
		"\u0000\u00d3\u00d4\u0001\u0000\u0000\u0000\u00d4\u00d5\u00053\u0000\u0000"+
		"\u00d5\u00d6\u0003\u001e\u000f\u0000\u00d6\u00d7\u00054\u0000\u0000\u00d7"+
		"\u001d\u0001\u0000\u0000\u0000\u00d8\u00da\u0003 \u0010\u0000\u00d9\u00d8"+
		"\u0001\u0000\u0000\u0000\u00da\u00dd\u0001\u0000\u0000\u0000\u00db\u00d9"+
		"\u0001\u0000\u0000\u0000\u00db\u00dc\u0001\u0000\u0000\u0000\u00dc\u001f"+
		"\u0001\u0000\u0000\u0000\u00dd\u00db\u0001\u0000\u0000\u0000\u00de\u00df"+
		"\u00057\u0000\u0000\u00df\u00e0\u0005(\u0000\u0000\u00e0\u00e1\u0003<"+
		"\u001e\u0000\u00e1\u00e2\u0005%\u0000\u0000\u00e2\u00ee\u0001\u0000\u0000"+
		"\u0000\u00e3\u00e4\u0005\'\u0000\u0000\u00e4\u00e5\u0005$\u0000\u0000"+
		"\u00e5\u00e6\u00057\u0000\u0000\u00e6\u00e7\u0005(\u0000\u0000\u00e7\u00e8"+
		"\u0003<\u001e\u0000\u00e8\u00e9\u0005%\u0000\u0000\u00e9\u00ee\u0001\u0000"+
		"\u0000\u0000\u00ea\u00eb\u0003<\u001e\u0000\u00eb\u00ec\u0005%\u0000\u0000"+
		"\u00ec\u00ee\u0001\u0000\u0000\u0000\u00ed\u00de\u0001\u0000\u0000\u0000"+
		"\u00ed\u00e3\u0001\u0000\u0000\u0000\u00ed\u00ea\u0001\u0000\u0000\u0000"+
		"\u00ee!\u0001\u0000\u0000\u0000\u00ef\u00f0\u0005\u0010\u0000\u0000\u00f0"+
		"\u00f1\u00057\u0000\u0000\u00f1\u00f5\u00053\u0000\u0000\u00f2\u00f4\u0003"+
		"$\u0012\u0000\u00f3\u00f2\u0001\u0000\u0000\u0000\u00f4\u00f7\u0001\u0000"+
		"\u0000\u0000\u00f5\u00f3\u0001\u0000\u0000\u0000\u00f5\u00f6\u0001\u0000"+
		"\u0000\u0000\u00f6\u00f8\u0001\u0000\u0000\u0000\u00f7\u00f5\u0001\u0000"+
		"\u0000\u0000\u00f8\u00f9\u00054\u0000\u0000\u00f9#\u0001\u0000\u0000\u0000"+
		"\u00fa\u00fd\u0003\u001a\r\u0000\u00fb\u00fd\u0003\u001c\u000e\u0000\u00fc"+
		"\u00fa\u0001\u0000\u0000\u0000\u00fc\u00fb\u0001\u0000\u0000\u0000\u00fd"+
		"%\u0001\u0000\u0000\u0000\u00fe\u00ff\u00057\u0000\u0000\u00ff\u0100\u0005"+
		"#\u0000\u0000\u0100\u0101\u0003.\u0017\u0000\u0101\'\u0001\u0000\u0000"+
		"\u0000\u0102\u0107\u0003&\u0013\u0000\u0103\u0104\u0005\"\u0000\u0000"+
		"\u0104\u0106\u0003&\u0013\u0000\u0105\u0103\u0001\u0000\u0000\u0000\u0106"+
		"\u0109\u0001\u0000\u0000\u0000\u0107\u0105\u0001\u0000\u0000\u0000\u0107"+
		"\u0108\u0001\u0000\u0000\u0000\u0108)\u0001\u0000\u0000\u0000\u0109\u0107"+
		"\u0001\u0000\u0000\u0000\u010a\u010b\u0007\u0001\u0000\u0000\u010b\u010e"+
		"\u00057\u0000\u0000\u010c\u010d\u0005(\u0000\u0000\u010d\u010f\u0003<"+
		"\u001e\u0000\u010e\u010c\u0001\u0000\u0000\u0000\u010e\u010f\u0001\u0000"+
		"\u0000\u0000\u010f+\u0001\u0000\u0000\u0000\u0110\u0111\u0005\u0011\u0000"+
		"\u0000\u0111\u0112\u00053\u0000\u0000\u0112\u0113\u00057\u0000\u0000\u0113"+
		"\u0114\u00054\u0000\u0000\u0114\u0115\u0005\u0016\u0000\u0000\u0115\u0116"+
		"\u00058\u0000\u0000\u0116\u0126\u0005%\u0000\u0000\u0117\u0118\u0005\u0011"+
		"\u0000\u0000\u0118\u0119\u00053\u0000\u0000\u0119\u011a\u0005\u0017\u0000"+
		"\u0000\u011a\u011b\u00054\u0000\u0000\u011b\u011c\u0005\u0016\u0000\u0000"+
		"\u011c\u011d\u00058\u0000\u0000\u011d\u0126\u0005%\u0000\u0000\u011e\u011f"+
		"\u0005\u001a\u0000\u0000\u011f\u0120\u0005#\u0000\u0000\u0120\u0122\u0005"+
		"@\u0000\u0000\u0121\u0123\u00057\u0000\u0000\u0122\u0121\u0001\u0000\u0000"+
		"\u0000\u0122\u0123\u0001\u0000\u0000\u0000\u0123\u0124\u0001\u0000\u0000"+
		"\u0000\u0124\u0126\u0005A\u0000\u0000\u0125\u0110\u0001\u0000\u0000\u0000"+
		"\u0125\u0117\u0001\u0000\u0000\u0000\u0125\u011e\u0001\u0000\u0000\u0000"+
		"\u0126-\u0001\u0000\u0000\u0000\u0127\u012f\u0005\u001d\u0000\u0000\u0128"+
		"\u012f\u0005\u001e\u0000\u0000\u0129\u012f\u0005\u001f\u0000\u0000\u012a"+
		"\u012f\u0005 \u0000\u0000\u012b\u012f\u0005!\u0000\u0000\u012c\u012f\u0005"+
		"7\u0000\u0000\u012d\u012f\u00032\u0019\u0000\u012e\u0127\u0001\u0000\u0000"+
		"\u0000\u012e\u0128\u0001\u0000\u0000\u0000\u012e\u0129\u0001\u0000\u0000"+
		"\u0000\u012e\u012a\u0001\u0000\u0000\u0000\u012e\u012b\u0001\u0000\u0000"+
		"\u0000\u012e\u012c\u0001\u0000\u0000\u0000\u012e\u012d\u0001\u0000\u0000"+
		"\u0000\u012f/\u0001\u0000\u0000\u0000\u0130\u0131\u0005\'\u0000\u0000"+
		"\u0131\u0132\u0005$\u0000\u0000\u0132\u0133\u00057\u0000\u0000\u01331"+
		"\u0001\u0000\u0000\u0000\u0134\u0135\u00057\u0000\u0000\u0135\u0136\u0005"+
		"@\u0000\u0000\u0136\u0137\u0005A\u0000\u0000\u01373\u0001\u0000\u0000"+
		"\u0000\u0138\u013d\u0003:\u001d\u0000\u0139\u013a\u0005\"\u0000\u0000"+
		"\u013a\u013c\u0003:\u001d\u0000\u013b\u0139\u0001\u0000\u0000\u0000\u013c"+
		"\u013f\u0001\u0000\u0000\u0000\u013d\u013b\u0001\u0000\u0000\u0000\u013d"+
		"\u013e\u0001\u0000\u0000\u0000\u013e\u0141\u0001\u0000\u0000\u0000\u013f"+
		"\u013d\u0001\u0000\u0000\u0000\u0140\u0138\u0001\u0000\u0000\u0000\u0140"+
		"\u0141\u0001\u0000\u0000\u0000\u01415\u0001\u0000\u0000\u0000\u0142\u0143"+
		"\u00053\u0000\u0000\u0143\u0144\u00038\u001c\u0000\u0144\u0146\u00054"+
		"\u0000\u0000\u0145\u0147\u0005\"\u0000\u0000\u0146\u0145\u0001\u0000\u0000"+
		"\u0000\u0146\u0147\u0001\u0000\u0000\u0000\u01477\u0001\u0000\u0000\u0000"+
		"\u0148\u0149\u00057\u0000\u0000\u0149\u014a\u0005#\u0000\u0000\u014a\u0154"+
		"\u0003:\u001d\u0000\u014b\u014c\u0005\"\u0000\u0000\u014c\u014d\u0005"+
		"7\u0000\u0000\u014d\u014e\u0005#\u0000\u0000\u014e\u0150\u0003:\u001d"+
		"\u0000\u014f\u0151\u0005\"\u0000\u0000\u0150\u014f\u0001\u0000\u0000\u0000"+
		"\u0150\u0151\u0001\u0000\u0000\u0000\u0151\u0153\u0001\u0000\u0000\u0000"+
		"\u0152\u014b\u0001\u0000\u0000\u0000\u0153\u0156\u0001\u0000\u0000\u0000"+
		"\u0154\u0152\u0001\u0000\u0000\u0000\u0154\u0155\u0001\u0000\u0000\u0000"+
		"\u0155\u0158\u0001\u0000\u0000\u0000\u0156\u0154\u0001\u0000\u0000\u0000"+
		"\u0157\u0148\u0001\u0000\u0000\u0000\u0157\u0158\u0001\u0000\u0000\u0000"+
		"\u01589\u0001\u0000\u0000\u0000\u0159\u0162\u00059\u0000\u0000\u015a\u0162"+
		"\u00058\u0000\u0000\u015b\u0162\u0003\u0012\t\u0000\u015c\u015d\u0005"+
		"@\u0000\u0000\u015d\u015e\u00034\u001a\u0000\u015e\u015f\u0005A\u0000"+
		"\u0000\u015f\u0162\u0001\u0000\u0000\u0000\u0160\u0162\u00036\u001b\u0000"+
		"\u0161\u0159\u0001\u0000\u0000\u0000\u0161\u015a\u0001\u0000\u0000\u0000"+
		"\u0161\u015b\u0001\u0000\u0000\u0000\u0161\u015c\u0001\u0000\u0000\u0000"+
		"\u0161\u0160\u0001\u0000\u0000\u0000\u0162;\u0001\u0000\u0000\u0000\u0163"+
		"\u0164\u0006\u001e\uffff\uffff\u0000\u0164\u0170\u00058\u0000\u0000\u0165"+
		"\u0170\u00059\u0000\u0000\u0166\u0170\u00057\u0000\u0000\u0167\u0170\u0003"+
		"\u0012\t\u0000\u0168\u0170\u0003@ \u0000\u0169\u0170\u0003*\u0015\u0000"+
		"\u016a\u0170\u00030\u0018\u0000\u016b\u016c\u00051\u0000\u0000\u016c\u016d"+
		"\u0003<\u001e\u0000\u016d\u016e\u00052\u0000\u0000\u016e\u0170\u0001\u0000"+
		"\u0000\u0000\u016f\u0163\u0001\u0000\u0000\u0000\u016f\u0165\u0001\u0000"+
		"\u0000\u0000\u016f\u0166\u0001\u0000\u0000\u0000\u016f\u0167\u0001\u0000"+
		"\u0000\u0000\u016f\u0168\u0001\u0000\u0000\u0000\u016f\u0169\u0001\u0000"+
		"\u0000\u0000\u016f\u016a\u0001\u0000\u0000\u0000\u016f\u016b\u0001\u0000"+
		"\u0000\u0000\u0170\u0177\u0001\u0000\u0000\u0000\u0171\u0172\n\u0002\u0000"+
		"\u0000\u0172\u0173\u0003>\u001f\u0000\u0173\u0174\u0003<\u001e\u0003\u0174"+
		"\u0176\u0001\u0000\u0000\u0000\u0175\u0171\u0001\u0000\u0000\u0000\u0176"+
		"\u0179\u0001\u0000\u0000\u0000\u0177\u0175\u0001\u0000\u0000\u0000\u0177"+
		"\u0178\u0001\u0000\u0000\u0000\u0178=\u0001\u0000\u0000\u0000\u0179\u0177"+
		"\u0001\u0000\u0000\u0000\u017a\u017b\u0007\u0002\u0000\u0000\u017b?\u0001"+
		"\u0000\u0000\u0000\u017c\u017d\u00057\u0000\u0000\u017d\u0181\u00051\u0000"+
		"\u0000\u017e\u0180\u0003B!\u0000\u017f\u017e\u0001\u0000\u0000\u0000\u0180"+
		"\u0183\u0001\u0000\u0000\u0000\u0181\u017f\u0001\u0000\u0000\u0000\u0181"+
		"\u0182\u0001\u0000\u0000\u0000\u0182\u0184\u0001\u0000\u0000\u0000\u0183"+
		"\u0181\u0001\u0000\u0000\u0000\u0184\u0185\u00052\u0000\u0000\u0185A\u0001"+
		"\u0000\u0000\u0000\u0186\u0187\u0003<\u001e\u0000\u0187C\u0001\u0000\u0000"+
		"\u0000\u0188\u018f\u0003F#\u0000\u0189\u018b\u0005T\u0000\u0000\u018a"+
		"\u018c\u0005P\u0000\u0000\u018b\u018a\u0001\u0000\u0000\u0000\u018b\u018c"+
		"\u0001\u0000\u0000\u0000\u018c\u018f\u0001\u0000\u0000\u0000\u018d\u018f"+
		"\u0003P(\u0000\u018e\u0188\u0001\u0000\u0000\u0000\u018e\u0189\u0001\u0000"+
		"\u0000\u0000\u018e\u018d\u0001\u0000\u0000\u0000\u018fE\u0001\u0000\u0000"+
		"\u0000\u0190\u0194\u0003H$\u0000\u0191\u0193\u0003D\"\u0000\u0192\u0191"+
		"\u0001\u0000\u0000\u0000\u0193\u0196\u0001\u0000\u0000\u0000\u0194\u0192"+
		"\u0001\u0000\u0000\u0000\u0194\u0195\u0001\u0000\u0000\u0000\u0195\u0197"+
		"\u0001\u0000\u0000\u0000\u0196\u0194\u0001\u0000\u0000\u0000\u0197\u0198"+
		"\u0003J%\u0000\u0198\u019b\u0001\u0000\u0000\u0000\u0199\u019b\u0003L"+
		"&\u0000\u019a\u0190\u0001\u0000\u0000\u0000\u019a\u0199\u0001\u0000\u0000"+
		"\u0000\u019bG\u0001\u0000\u0000\u0000\u019c\u01a0\u0005F\u0000\u0000\u019d"+
		"\u019f\u0003N\'\u0000\u019e\u019d\u0001\u0000\u0000\u0000\u019f\u01a2"+
		"\u0001\u0000\u0000\u0000\u01a0\u019e\u0001\u0000\u0000\u0000\u01a0\u01a1"+
		"\u0001\u0000\u0000\u0000\u01a1\u01a3\u0001\u0000\u0000\u0000\u01a2\u01a0"+
		"\u0001\u0000\u0000\u0000\u01a3\u01a4\u0005H\u0000\u0000\u01a4I\u0001\u0000"+
		"\u0000\u0000\u01a5\u01a6\u0005G\u0000\u0000\u01a6\u01a7\u0005T\u0000\u0000"+
		"\u01a7\u01a8\u0005H\u0000\u0000\u01a8K\u0001\u0000\u0000\u0000\u01a9\u01ad"+
		"\u0005F\u0000\u0000\u01aa\u01ac\u0003N\'\u0000\u01ab\u01aa\u0001\u0000"+
		"\u0000\u0000\u01ac\u01af\u0001\u0000\u0000\u0000\u01ad\u01ab\u0001\u0000"+
		"\u0000\u0000\u01ad\u01ae\u0001\u0000\u0000\u0000\u01ae\u01b0\u0001\u0000"+
		"\u0000\u0000\u01af\u01ad\u0001\u0000\u0000\u0000\u01b0\u01b1\u0005I\u0000"+
		"\u0000\u01b1M\u0001\u0000\u0000\u0000\u01b2\u01b3\u0005T\u0000\u0000\u01b3"+
		"\u01b4\u0005J\u0000\u0000\u01b4\u01bf\u0005K\u0000\u0000\u01b5\u01b6\u0005"+
		"L\u0000\u0000\u01b6\u01b7\u0005J\u0000\u0000\u01b7\u01bf\u0005K\u0000"+
		"\u0000\u01b8\u01b9\u0005M\u0000\u0000\u01b9\u01ba\u0005J\u0000\u0000\u01ba"+
		"\u01bf\u0005K\u0000\u0000\u01bb\u01bc\u0005N\u0000\u0000\u01bc\u01bd\u0005"+
		"J\u0000\u0000\u01bd\u01bf\u0005K\u0000\u0000\u01be\u01b2\u0001\u0000\u0000"+
		"\u0000\u01be\u01b5\u0001\u0000\u0000\u0000\u01be\u01b8\u0001\u0000\u0000"+
		"\u0000\u01be\u01bb\u0001\u0000\u0000\u0000\u01bfO\u0001\u0000\u0000\u0000"+
		"\u01c0\u01c1\u0005Q\u0000\u0000\u01c1\u01c2\u0005T\u0000\u0000\u01c2\u01c3"+
		"\u0005R\u0000\u0000\u01c3Q\u0001\u0000\u0000\u0000\u01c4\u01c5\u0005X"+
		"\u0000\u0000\u01c5\u01c6\u0003T*\u0000\u01c6\u01c8\u0005X\u0000\u0000"+
		"\u01c7\u01c9\u0005Z\u0000\u0000\u01c8\u01c7\u0001\u0000\u0000\u0000\u01c8"+
		"\u01c9\u0001\u0000\u0000\u0000\u01c9S\u0001\u0000\u0000\u0000\u01ca\u01cc"+
		"\u0003V+\u0000\u01cb\u01ca\u0001\u0000\u0000\u0000\u01cb\u01cc\u0001\u0000"+
		"\u0000\u0000\u01cc\u01d3\u0001\u0000\u0000\u0000\u01cd\u01cf\u0005Z\u0000"+
		"\u0000\u01ce\u01cd\u0001\u0000\u0000\u0000\u01ce\u01cf\u0001\u0000\u0000"+
		"\u0000\u01cf\u01d0\u0001\u0000\u0000\u0000\u01d0\u01d2\u0003V+\u0000\u01d1"+
		"\u01ce\u0001\u0000\u0000\u0000\u01d2\u01d5\u0001\u0000\u0000\u0000\u01d3"+
		"\u01d1\u0001\u0000\u0000\u0000\u01d3\u01d4\u0001\u0000\u0000\u0000\u01d4"+
		"U\u0001\u0000\u0000\u0000\u01d5\u01d3\u0001\u0000\u0000\u0000\u01d6\u01d8"+
		"\u0005]\u0000\u0000\u01d7\u01d9\u0005h\u0000\u0000\u01d8\u01d7\u0001\u0000"+
		"\u0000\u0000\u01d9\u01da\u0001\u0000\u0000\u0000\u01da\u01d8\u0001\u0000"+
		"\u0000\u0000\u01da\u01db\u0001\u0000\u0000\u0000\u01db\u01dc\u0001\u0000"+
		"\u0000\u0000\u01dc\u01de\u0005_\u0000\u0000\u01dd\u01df\u0003X,\u0000"+
		"\u01de\u01dd\u0001\u0000\u0000\u0000\u01df\u01e0\u0001\u0000\u0000\u0000"+
		"\u01e0\u01de\u0001\u0000\u0000\u0000\u01e0\u01e1\u0001\u0000\u0000\u0000"+
		"\u01e1\u01e2\u0001\u0000\u0000\u0000\u01e2\u01e3\u0005`\u0000\u0000\u01e3"+
		"W\u0001\u0000\u0000\u0000\u01e4\u01e5\u0005h\u0000\u0000\u01e5\u01e6\u0005"+
		"Y\u0000\u0000\u01e6\u01e7\u0003Z-\u0000\u01e7\u01e8\u0005^\u0000\u0000"+
		"\u01e8Y\u0001\u0000\u0000\u0000\u01e9\u01ee\u0007\u0003\u0000\u0000\u01ea"+
		"\u01ec\u0005h\u0000\u0000\u01eb\u01ed\u0005h\u0000\u0000\u01ec\u01eb\u0001"+
		"\u0000\u0000\u0000\u01ec\u01ed\u0001\u0000\u0000\u0000\u01ed\u01ef\u0001"+
		"\u0000\u0000\u0000\u01ee\u01ea\u0001\u0000\u0000\u0000\u01ee\u01ef\u0001"+
		"\u0000\u0000\u0000\u01ef[\u0001\u0000\u0000\u00002_gv~\u008e\u0099\u009e"+
		"\u00a7\u00ab\u00b2\u00ba\u00c3\u00c6\u00c8\u00cd\u00d2\u00db\u00ed\u00f5"+
		"\u00fc\u0107\u010e\u0122\u0125\u012e\u013d\u0140\u0146\u0150\u0154\u0157"+
		"\u0161\u016f\u0177\u0181\u018b\u018e\u0194\u019a\u01a0\u01ad\u01be\u01c8"+
		"\u01cb\u01ce\u01d3\u01da\u01e0\u01ec\u01ee";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}