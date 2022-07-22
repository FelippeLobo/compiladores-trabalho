package src.parsers;

import src.ast.*;
import java.util.ArrayList;
import src.beaver.*;

/**
 * This class is a LALR parser generated by
 * <a href="http://beaver.sourceforge.net">Beaver</a> v0.9.6.1
 * from the grammar specification "lang.grammar".
 */
public class MiniLangParser extends Parser {

	static final ParsingTables PARSING_TABLES = new ParsingTables(
		"U9pjLrbm5KKKFJqJaX0ZIy0yCIGaa1S88dbX2yGWYo1nZRY0Mq0MHOcAeWYu4TV41Q8YMbH" +
		"P#k67bdmeLLgM2WIGJGG54L4n82BY2k92tB0zCw$nTS$a3UH95JzvKsVkFVVUljtJwUxR0U" +
		"nzA4C$bA0dJaKld8RUw88yjCM9Q8yEE0aXT48Mij4DOLal$q5hJ$GeAUNVFck5c#L2JC1Lc" +
		"8eRSRFBpvU7v5#erQnNubpv1mOZ3RNoJr#MWV77WW5QbZISWmSnY7bg0reCbL$vUYZcCuGO" +
		"oUSs8e8pKO3kw85256azb6Cqst#1UmDxk0$f0Txudhwu7TTf$Tfo6PBG2YauFQ5ymmDyumD" +
		"yamDyP#7w06y5fWLupyFiXBxZ#7kkyAmNBu#tNix01JXRuudc6O6BST4no5EEIt27nZth3P" +
		"V2SjTR12V4x7AfBsuiajquhxqIgQwznZCUC#uoZC7zc8XhkO$kzlakzrckyLcc#2npVETN2" +
		"syUDsVqwcQtZ#1MhRtNUyiH$3FeRwFv8sXdi0o3TJHOfi5EDjWf1kjii1o3vHgigy7o3TR7" +
		"OFqDLcgmOGORPx191hl9OBCqTWFhqZnKo2zPbufHXUcOIUrEkOSx#Iwv6m$W7haBrNW83pF" +
		"k4LR0H$4Ovk9nrE49F2aFoaO8xclRhIN9t9sfh7zftE7fFElQyCHhnnClWsTUHvvwcO0lsW" +
		"AQi0etIo7dknDdEOjpw$1qDxQhPhLOlS1tc5P$bfp0iSIoX1cJpzFOOfRuBR9vQdjxoEQJI" +
		"UJnAI0AjLLNfFNGdtS99t9GO0y5x26#DxwdcwTVPzNsOSNlHqzY#OBcBJ6V2FosO6zXWlDo" +
		"$3t#TMto#EibPApGnFDqFqPvIhYROjoxthgezMRQotnnkKt6HJYAg3ruF16UKGCOqOFxABC" +
		"9NsAM8yr92s$Ecedyp$PUxy1c#blOOHPYnH5ydFyyijqpDEnMgH1tSWcjZYUJEpA7ZwFdyt" +
		"wHwthp#NRqNDRK#TLkqUKT2YvtQlW08eye8KOGGubibk7nb7NHU6iANriefx4izwISISbuQ" +
		"mubsrWrbACfwoZ7KJv3MKNvl5lXORr8wRHxHULxGybwnirozAC5VnFORYtbSoh71toDLBuY" +
		"OXHjsoWNATiayfsKKmcEszfBkSRnIVueNkCOCbIkCFMdgOobTEQaa9X8$Icj$ydaRn4l4Hy" +
		"JkucvnC6eNonGSMNCjv$WF5kDvBleMwpwuPpRALJe5s#IjwVSgjeTYahxVU9rfRUbFrtf8M" +
		"AfYkLSsmN42k9LWdb5befRJBnDB26MqTv0MQ$QyUzcRoVM4Sk9bSe#XFexn2g2uxNN49jKl" +
		"jN4UeBhmDv8R53VkrcrNQZu7YKFnEPCDCHqEwHaZf9X9NifsLV9KYM7ALckP8MIOvIiL7Bo" +
		"uJwQ0xQhqlJfJVXdcrpCq7pLcdsX6OTAJK#YFpLu7699L5gjOZQhW#PNVtExHlcsQUEOfso" +
		"TbGnxlk5bJL#WvM$qnALe#hCUtmjQkzwcpnB1tsOl2l2fFO7vyFta3lVz2$4PyIdn2S7TBR" +
		"dpv5RY8#93OZF1aq1oryYDyZsvNMwHc#G6kLw#AzV9jNADN2rNkTaQt3TNkLpXQYkZlQWUb" +
		"olvkMRxblX6xf3V6MFRAt#LlnbjV$vFEq3yHEntsJxt$QFx$a55HCVolP7nQqtVQMJ#tPYM" +
		"uJnR1EzO3YoVxCTQMieLLyggMapkt8aYv17oA5BSErg4bJU69Fxl9GZ7dihRMsiYcVNO9WH" +
		"hWqq8rWgR4BonsJmR1P54s3pR1MkL7G31IcOh2DOqMuDWXRC8qIIANDX4Ay8YKdY35OI5mV" +
		"y2bMP28W==");

	static final Action RETURN2 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 2];
		}
	};

	static final Action RETURN8 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 8];
		}
	};

	static final Action RETURN3 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 3];
		}
	};

	private final Action[] actions;

	public MiniLangParser() {
		super(PARSING_TABLES);
		actions = new Action[] {
			Action.RETURN,	// [0] $goal = Prog
			new Action() {	// [1] Prog = Stmt.l
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Node l = (Node) _symbol_l.value;
					 return new Prog(l);
				}
			},
			new Action() {	// [2] Prog = Stmt.l Prog.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Node l = (Node) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 2];
					final Node r = (Node) _symbol_r.value;
					 return new Prog(l, r);
				}
			},
			new Action() {	// [3] Prog = Func.l
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Node l = (Node) _symbol_l.value;
					 return new Prog(l);
				}
			},
			new Action() {	// [4] Prog = Func.l Prog.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Node l = (Node) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 2];
					final Node r = (Node) _symbol_r.value;
					 return new Prog(l, r);
				}
			},
			new Action() {	// [5] Prog = Data.l
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Node l = (Node) _symbol_l.value;
					 return new Prog(l);
				}
			},
			new Action() {	// [6] Prog = Data.l Prog.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Node l = (Node) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 2];
					final Node r = (Node) _symbol_r.value;
					 return new Prog(l, r);
				}
			},
			new Action() {	// [7] Data = DATA TYPE.l AC Decl.t FC SEMI
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final String l = (String) _symbol_l.value;
					final Symbol _symbol_t = _symbols[offset + 4];
					final Node t = (Node) _symbol_t.value;
					return new Data(new Type(l), t);
				}
			},
			new Action() {	// [8] Decl = ID.l DBCOLON TYPE.t SEMI
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final String l = (String) _symbol_l.value;
					final Symbol _symbol_t = _symbols[offset + 3];
					final String t = (String) _symbol_t.value;
					return new Decl(new Lvalue(l), new Type(t));
				}
			},
			new Action() {	// [9] Decl = ID.l DBCOLON TYPE.t SEMI Decl.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final String l = (String) _symbol_l.value;
					final Symbol _symbol_t = _symbols[offset + 3];
					final String t = (String) _symbol_t.value;
					final Symbol _symbol_r = _symbols[offset + 5];
					final Node r = (Node) _symbol_r.value;
					return new Decl(new Lvalue(l), new Type(t), r);
				}
			},
			new Action() {	// [10] StmtList = Stmt.l StmtList.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Node l = (Node) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 2];
					final Node r = (Node) _symbol_r.value;
					 return new StmtList(l, r);
				}
			},
			new Action() {	// [11] StmtList = Stmt.l
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Node l = (Node) _symbol_l.value;
					 return new StmtList(l);
				}
			},
			new Action() {	// [12] Stmt = ID.l EQ Exp.r SEMI
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final String l = (String) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 3];
					final Exp r = (Exp) _symbol_r.value;
					 return new Attr((String)l, r);
				}
			},
			new Action() {	// [13] Stmt = ITERATE AP Exp.l FP Stmt.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 3];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 5];
					final Node r = (Node) _symbol_r.value;
					 return new Iterate(l, r);
				}
			},
			new Action() {	// [14] Stmt = IF AP Exp.l FP StmtList.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 3];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 5];
					final Node r = (Node) _symbol_r.value;
					 return new IfElse(l, r);
				}
			},
			new Action() {	// [15] Stmt = IF AP Exp.l FP StmtList.r ELSE StmtList.s
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 3];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 5];
					final Node r = (Node) _symbol_r.value;
					final Symbol _symbol_s = _symbols[offset + 7];
					final Node s = (Node) _symbol_s.value;
					 return new IfElse(l, r, s);
				}
			},
			RETURN2,	// [16] Stmt = Exp SEMI; returns 'SEMI' although none is marked
			new Action() {	// [17] Stmt = READ Lvalue.l SEMI
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Lvalue l = (Lvalue) _symbol_l.value;
					return new Read(l);
				}
			},
			new Action() {	// [18] Stmt = PRINT Exp.e SEMI
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e = _symbols[offset + 2];
					final Exp e = (Exp) _symbol_e.value;
					 return new Print(e);
				}
			},
			new Action() {	// [19] Stmt = RETURN Ret.l SEMI
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Node l = (Node) _symbol_l.value;
					 return new GenRet(l);
				}
			},
			new Action() {	// [20] Stmt = Lvalue.l EQ Exp.r SEMI
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Lvalue l = (Lvalue) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 3];
					final Exp r = (Exp) _symbol_r.value;
					 return new Attr(l, r);
				}
			},
			new Action() {	// [21] lst$Lvalue = Lvalue
				public Symbol reduce(Symbol[] _symbols, int offset) {
					ArrayList lst = new ArrayList(); lst.add(_symbols[offset + 1].value); return new Symbol(lst);
				}
			},
			new Action() {	// [22] lst$Lvalue = lst$Lvalue Lvalue
				public Symbol reduce(Symbol[] _symbols, int offset) {
					((ArrayList) _symbols[offset + 1].value).add(_symbols[offset + 2].value); return _symbols[offset + 1];
				}
			},
			RETURN8,	// [23] Stmt = ID AP Exps FP LESSER lst$Lvalue GREATER SEMI; returns 'SEMI' although none is marked
			new Action() {	// [24] Func = ID.a AP ParamList.b FP COLON Return.c AC StmtList.d FC
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_a = _symbols[offset + 1];
					final String a = (String) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 3];
					final Node b = (Node) _symbol_b.value;
					final Symbol _symbol_c = _symbols[offset + 6];
					final Node c = (Node) _symbol_c.value;
					final Symbol _symbol_d = _symbols[offset + 8];
					final Node d = (Node) _symbol_d.value;
					return new Func(new Lvalue(a), b, c, d);
				}
			},
			new Action() {	// [25] Func = ID.a AP FP AC StmtList.b FC
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_a = _symbols[offset + 1];
					final String a = (String) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 5];
					final Node b = (Node) _symbol_b.value;
					return new Func(new Lvalue(a), b);
				}
			},
			RETURN3,	// [26] Ret = Exp COMMA Ret; returns 'Ret' although none is marked
			Action.RETURN,	// [27] Ret = Exp
			new Action() {	// [28] Return = TYPE.a COMMA Return.b
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_a = _symbols[offset + 1];
					final String a = (String) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 3];
					final Node b = (Node) _symbol_b.value;
					return new Return(new Type(a), b);
				}
			},
			new Action() {	// [29] Return = TYPE.a
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_a = _symbols[offset + 1];
					final String a = (String) _symbol_a.value;
					return new Return(new Type(a));
				}
			},
			new Action() {	// [30] ParamList = Param.a COMMA ParamList.b
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_a = _symbols[offset + 1];
					final Node a = (Node) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 3];
					final Node b = (Node) _symbol_b.value;
					return new ParamList(a, b);
				}
			},
			new Action() {	// [31] ParamList = Param.a
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_a = _symbols[offset + 1];
					final Node a = (Node) _symbol_a.value;
					return new ParamList(a);
				}
			},
			new Action() {	// [32] Param = ID.a DBCOLON TYPE.b
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_a = _symbols[offset + 1];
					final String a = (String) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 3];
					final String b = (String) _symbol_b.value;
					return new Param(new Lvalue(a), new Type(b));
				}
			},
			new Action() {	// [33] Lvalue = ID.l
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final String l = (String) _symbol_l.value;
					return new Lvalue(l);
				}
			},
			new Action() {	// [34] Lvalue = Lvalue.l LB Exp.r RB
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Lvalue l = (Lvalue) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 3];
					final Exp r = (Exp) _symbol_r.value;
					return new Lvalue(l,r);
				}
			},
			new Action() {	// [35] Lvalue = Lvalue.l DOT ID.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Lvalue l = (Lvalue) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 3];
					final String r = (String) _symbol_r.value;
					return new Lvalue(l,r);
				}
			},
			Action.RETURN,	// [36] Exp = Rexp
			new Action() {	// [37] Rexp = Exp.l GREATER Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 3];
					final Exp r = (Exp) _symbol_r.value;
					return new Greater(l, r);
				}
			},
			new Action() {	// [38] Rexp = Exp.l LESSER Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 3];
					final Exp r = (Exp) _symbol_r.value;
					return new Lesser(l, r);
				}
			},
			new Action() {	// [39] Rexp = Exp.l GREATEREQUAL Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 3];
					final Exp r = (Exp) _symbol_r.value;
					return new GreaterEqual(l, r);
				}
			},
			new Action() {	// [40] Rexp = Exp.l LESSEREQUAL Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 3];
					final Exp r = (Exp) _symbol_r.value;
					return new LesserEqual(l, r);
				}
			},
			new Action() {	// [41] Rexp = Exp.l EQUALTO Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 3];
					final Exp r = (Exp) _symbol_r.value;
					return new Equal(l, r);
				}
			},
			new Action() {	// [42] Rexp = Exp.l DIF Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 3];
					final Exp r = (Exp) _symbol_r.value;
					return new Dif(l, r);
				}
			},
			new Action() {	// [43] Rexp = Exp.l AND Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 3];
					final Exp r = (Exp) _symbol_r.value;
					return new And(l, r);
				}
			},
			Action.RETURN,	// [44] Rexp = Aexp
			new Action() {	// [45] Aexp = Exp.l PLUS Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 3];
					final Exp r = (Exp) _symbol_r.value;
					return new Add(l, r);
				}
			},
			new Action() {	// [46] Aexp = Exp.l SUB Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 3];
					final Exp r = (Exp) _symbol_r.value;
					return new Sub(l, r);
				}
			},
			Action.RETURN,	// [47] Aexp = Mexp
			new Action() {	// [48] Mexp = Exp.l MULT Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 3];
					final Exp r = (Exp) _symbol_r.value;
					return new Mult(l, r);
				}
			},
			new Action() {	// [49] Mexp = Exp.l DIV Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 3];
					final Exp r = (Exp) _symbol_r.value;
					return new Div(l, r);
				}
			},
			new Action() {	// [50] Mexp = Exp.l MOD Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 3];
					final Exp r = (Exp) _symbol_r.value;
					return new Mod(l, r);
				}
			},
			Action.RETURN,	// [51] Mexp = Sexp
			RETURN2,	// [52] Sexp = Exp NOT; returns 'NOT' although none is marked
			new Action() {	// [53] Sexp = BOOL.n
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_n = _symbols[offset + 1];
					final boolean n = (boolean) _symbol_n.value;
					return new LiteralValue<Boolean>(n);
				}
			},
			new Action() {	// [54] Sexp = NULL.n
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_n = _symbols[offset + 1];
					final String n = (String) _symbol_n.value;
					return new LiteralValue<String>(n);
				}
			},
			new Action() {	// [55] Sexp = INT.n
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_n = _symbols[offset + 1];
					final Integer n = (Integer) _symbol_n.value;
					return new LiteralValue<Integer>(n);
				}
			},
			new Action() {	// [56] Sexp = FLOAT.n
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_n = _symbols[offset + 1];
					final float n = (float) _symbol_n.value;
					return new LiteralValue<Float>(n);
				}
			},
			new Action() {	// [57] Sexp = CHAR.n
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_n = _symbols[offset + 1];
					final Character n = (Character) _symbol_n.value;
					return new LiteralValue<Character>(n);
				}
			},
			Action.RETURN,	// [58] Sexp = Pexp
			new Action() {	// [59] Pexp = Lvalue.l
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Lvalue l = (Lvalue) _symbol_l.value;
					return l;
				}
			},
			RETURN3,	// [60] Pexp = AP Exp FP; returns 'FP' although none is marked
			new Action() {	// [61] Pexp = NEW TYPE.l LB Exp.r RB
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final String l = (String) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 4];
					final Exp r = (Exp) _symbol_r.value;
					return new Inst(new Type(l), r);
				}
			},
			new Action() {	// [62] Pexp = NEW TYPE.l
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final String l = (String) _symbol_l.value;
					return new Inst(new Type(l));
				}
			},
			Action.RETURN,	// [63] Pexp = ID.l AP Exps FP LB Exp RB
			Action.RETURN,	// [64] Exps = Exp
			RETURN2	// [65] Exps = Exp Exps; returns 'Exps' although none is marked
		};
	}

	protected Symbol invokeReduceAction(int rule_num, int offset) {
		return actions[rule_num].reduce(_symbols, offset);
	}
}
