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
		"U9pjMGkOLLCR$iuviyy9bHGpn5owQgPeCZLJKo5o#Tt2Z$xSxo4YTzA5N9Bh$uS$T54f92L" +
		"5fJjAfNGHHLJ6fD9LA8JbFMj$EUlRUw$pxF6u$3t$d7c#zNxl#ttxssljVTOwQpr3b9XDlU" +
		"WAkfEwq0tKZMwac#XcogKwL8$sfMgq7zMY0oYB3gA3ALizgtwXlNpPuzLFVbKfUfd6qMoQI" +
		"U$J4bhcrbG$qmpQv5DtKM$Qf7uCgF83xHrmn#vGx$9MeGt9AZxr7jeETRglXb#vZHwaFggC" +
		"#XerLgkT6DypXXAkqYlqAhqcAgsZDsWChKrRgO$joTEXld7vSoQgyi2#JA9LD0jzMK6Vq0A" +
		"wdAwYg#aQkeNU2L5pCbMrnffO8ysiaM9hfBKrShGrSfmrSf8rqi4QESiQwMIDN6YDN6QDTB" +
		"P6hhT6RFeKkYDW$iwX#TIpmhKUflkiiSUiaVzO8qzQ8mEiaMUjaS7Mo51hv7bhv0LhP9Gry" +
		"hOrCjSQ6KyBhR55z84rzX5zvfcjCRMMekHGWcwbVLAwUhh2x$dlqi#cS#aYEemQqH5KGcse" +
		"7HrF9zFfrdpF#6aDPUZnU$LL50$IrHTKHUiRVRygQ$0CxpToosYz#fpAwNCQJQ$JL$Gbrkb" +
		"UzA9dLlMY4Jvbc4yPubC6#fIdVSfJFgM$JtdSfppYK$hvb0O#nRjQzAA243bDG#Gq3v7JAa" +
		"JEaI5oZWsHSsA8d5D3v9mP8gTZY9ppG#HS4YB7hrptkwxw$rNaMZ6LtlGfq$wWolDyodj$s" +
		"YY#yAnh6sWpThzRQ2lTxObiew$f6$gMlgC7F94TQWTDeEHdD2BBZOXaO#b3CZyV8rvTPDSG" +
		"hAPW#mkMATY1WjKMx131SWJB4wokOFK5QoXOlc2D1JjSi4B1YWHh8LXBmKe5QolOKO8T8rX" +
		"xmKuGx1#2dIBOQOAT8TW$1Jj7i7y9TfvW5mXsiM2N2dQbODSArbMmsmNh8TYzWZqasAE2$L" +
		"km9mJxhs3F23P8iES46oxOIC5U4kmjmTuLRAbWdnfiCSvbxgSlUolXHR33Y#bTJXpxbYeu#" +
		"UwDlLvLx8ogOtzK0$kZcjWXxOyzKYQky6T70bM2KXspwY3CfOCnWzoQIRMkHGskqY10pO6Q" +
		"xQjIFx1s9gwl6zXhhv8DpTr7fceqnFoEe4PA2LSf4$CxIrGgXbOD#v1qbRBJF7dlkFmvX#A" +
		"EGJLByBoYw4j3zAa0AqqJx8OFnywgC4JDNDIqzwaoybT5R7eUpZ3#Tnx5QQTUXMjbfhdcxt" +
		"y2UsOaacR#vAU9PU7FErkpS88jmcb7wcqg$9xt5Dqx$fB0yHTYTGlMSrdtpuzCJswkNkFpO" +
		"2smJkTWfMmLQfslL2gLIcLFLBnhHRC0vN#jSiNlLHzhMGIhModMDHd9mwz9CfhbYvGYbg$m" +
		"yKKaQqqjbV71sJDTTYMhP9KinR8ec#TD7TV3YROEJhixUxldymwmnh3aYRiObeorWxM7dGO" +
		"hm65vDV1xDp$M3qVeZu3zWMN0WS0jm1707u5ZO77OH5XDs4nO3cmUBiu7BWKs1wxaUkMCcn" +
		"bte9dAld8nemhw46T$FyRQq6gnNu#n2RGyzbim7WdjCFPFO3mTMYdxdHWlXROxteNnPcXdi" +
		"Ty3JKVW$T0kOUqnDBWkOm2qhgmDPHm5hJlxuncdGklB$cp6zw4zcVIPBmSVXh4NxDPONmCD" +
		"xoTZ0#9ZpPZNyEcClEt8u#U85PG8po5Z5xIvh5r6v6G0Ey6kXbyDiR9aJ7z7YBh3xdLp7Nm" +
		"t8blOpuN$4$kDyCxtOhyP$4psI#7pEt6EXL$8$Ydmsx9$DloJsByGVaVsqVVevUpV0B#Rwy" +
		"UkH$C4x4LOyhcZ7$Gmp7XsbFnk3OPDWtq0smhhXlvEv$YTZ2rG#o7WDY1gHdl2VygDHTP16" +
		"mGj6Hy2$XPmYXkB3c1yXIWndFiu2Nma#xFWyxicl5TdFZZwaa2V7FGdEe5ZLs4yny1EXU7x" +
		"Gsk1FEOOtaliRjXrk0Pp9dODNtCq#6BO4XZcc$C9h9plkmA6EUgWxuJdvApdVd8VO$mkOaq" +
		"PMwUUMNHiodTskHYFClAxZTTWp6BCOMp0s8InY97dLhmTuucC7LBtYf$3U86XyJE8Tp6q6n" +
		"dlCBJUZ0yOsgECnlSXFf1nkA6DOXndQ9COPnZQ7CQ5XhQCSQMXbJ5kCBHjZ3jtQyn$CNbAJ" +
		"pYCLOFY0Vcr0hJQaZlJZ5WTGv$lkQwHuJSr$6B3RsluxGt$PCC$q$0x6Vx5Xj$PyBkc$DWP" +
		"Hl$MeBd7DdOtXoPphddTkOQ$dEzn2#SlCEvx5#VqPFpjE#JoQ7yZjuzHirpcEHkDl7uo5ii" +
		"syYPu#juZ$TYSYMbY2xd6Jl9zr2hTVWF3og3m2wsm6YgiGWgha9e3mqgci1gfoR09i5TXe$" +
		"LL#ArI7siFlpvA$zzBORrIIxIt2BPGU#$1vcdlNTXixRqDcwMz6R2fsdiJDabxRy36QsySR" +
		"Apsi7ggbxNtabh9lP#kNbTOsTKBcerK8zJpQhWQfeQgvzGGhNq66wIzmUvO#Sg1Z9$gTenk" +
		"NzFjHDrEqUrCtRwZsxcwNQ3RnRfTfjiLHbNyoghrQfNwIZpZTUfRzPsu#$RVFFoMgAzXMpN" +
		"RejlDkjt46UuuDegANnh#Qb7vUpEFhgGsE5yTeItgm#OufvNYl5QA4ripyEIvhn2y4BmG9p" +
		"WNex2OOHdO5qHWIRqA5U6KLuGwBH5h2Rq4M08i1XO3Mm7pWVcuBXz#0Vp6mCQexLhYB#0Hx" +
		"6jZC8Sj4S0ZsFd6O0vR8WIFOAySXMN08e7ML9i3Yy8Is4D4O55g#oiCubUO");

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
			new Action() {	// [14] Stmt = IF AP Exp.l FP StmtList.r ELSE StmtList.s
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
			new Action() {	// [15] Stmt = IF AP Exp.l FP StmtList.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 3];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 5];
					final Node r = (Node) _symbol_r.value;
					 return new IfElse(l, r);
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
					return new Greater(l, r, 0);
				}
			},
			new Action() {	// [38] Rexp = AP Exp.l FP GREATER Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 5];
					final Exp r = (Exp) _symbol_r.value;
					return new Greater(l, r, 1);
				}
			},
			new Action() {	// [39] Rexp = Exp.l GREATER AP Exp.r FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 4];
					final Exp r = (Exp) _symbol_r.value;
					return new Greater(l, r, 2);
				}
			},
			new Action() {	// [40] Rexp = AP Exp.l FP GREATER AP Exp.r FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 6];
					final Exp r = (Exp) _symbol_r.value;
					return new Greater(l, r, 3);
				}
			},
			new Action() {	// [41] Rexp = Exp.l LESSER Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 3];
					final Exp r = (Exp) _symbol_r.value;
					return new Lesser(l, r, 0);
				}
			},
			new Action() {	// [42] Rexp = AP Exp.l FP LESSER Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 5];
					final Exp r = (Exp) _symbol_r.value;
					return new Lesser(l, r, 1);
				}
			},
			new Action() {	// [43] Rexp = Exp.l LESSER AP Exp.r FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 4];
					final Exp r = (Exp) _symbol_r.value;
					return new Lesser(l, r, 2);
				}
			},
			new Action() {	// [44] Rexp = AP Exp.l FP LESSER AP Exp.r FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 6];
					final Exp r = (Exp) _symbol_r.value;
					return new Lesser(l, r, 3);
				}
			},
			new Action() {	// [45] Rexp = Exp.l GREATEREQUAL Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 3];
					final Exp r = (Exp) _symbol_r.value;
					return new GreaterEqual(l, r, 0);
				}
			},
			new Action() {	// [46] Rexp = AP Exp.l FP GREATEREQUAL Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 5];
					final Exp r = (Exp) _symbol_r.value;
					return new GreaterEqual(l, r, 1);
				}
			},
			new Action() {	// [47] Rexp = Exp.l GREATEREQUAL AP Exp.r FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 4];
					final Exp r = (Exp) _symbol_r.value;
					return new GreaterEqual(l, r, 2);
				}
			},
			new Action() {	// [48] Rexp = AP Exp.l FP GREATEREQUAL AP Exp.r FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 6];
					final Exp r = (Exp) _symbol_r.value;
					return new GreaterEqual(l, r, 3);
				}
			},
			new Action() {	// [49] Rexp = Exp.l LESSEREQUAL Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 3];
					final Exp r = (Exp) _symbol_r.value;
					return new LesserEqual(l, r, 0);
				}
			},
			new Action() {	// [50] Rexp = AP Exp.l FP LESSEREQUAL Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 5];
					final Exp r = (Exp) _symbol_r.value;
					return new LesserEqual(l, r, 1);
				}
			},
			new Action() {	// [51] Rexp = Exp.l LESSEREQUAL AP Exp.r FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 4];
					final Exp r = (Exp) _symbol_r.value;
					return new LesserEqual(l, r, 2);
				}
			},
			new Action() {	// [52] Rexp = AP Exp.l FP LESSEREQUAL AP Exp.r FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 6];
					final Exp r = (Exp) _symbol_r.value;
					return new LesserEqual(l, r, 3);
				}
			},
			new Action() {	// [53] Rexp = Exp.l EQUALTO Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 3];
					final Exp r = (Exp) _symbol_r.value;
					return new Equal(l, r, 0);
				}
			},
			new Action() {	// [54] Rexp = AP Exp.l FP EQUALTO Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 5];
					final Exp r = (Exp) _symbol_r.value;
					return new Equal(l, r, 1);
				}
			},
			new Action() {	// [55] Rexp = Exp.l EQUALTO AP Exp.r FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 4];
					final Exp r = (Exp) _symbol_r.value;
					return new Equal(l, r, 2);
				}
			},
			new Action() {	// [56] Rexp = AP Exp.l FP EQUALTO AP Exp.r FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 6];
					final Exp r = (Exp) _symbol_r.value;
					return new Equal(l, r, 3);
				}
			},
			new Action() {	// [57] Rexp = Exp.l DIF Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 3];
					final Exp r = (Exp) _symbol_r.value;
					return new Dif(l, r, 0);
				}
			},
			new Action() {	// [58] Rexp = AP Exp.l FP DIF Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 5];
					final Exp r = (Exp) _symbol_r.value;
					return new Dif(l, r, 1);
				}
			},
			new Action() {	// [59] Rexp = Exp.l DIF AP Exp.r FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 4];
					final Exp r = (Exp) _symbol_r.value;
					return new Dif(l, r, 2);
				}
			},
			new Action() {	// [60] Rexp = AP Exp.l FP DIF AP Exp.r FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 6];
					final Exp r = (Exp) _symbol_r.value;
					return new Dif(l, r, 3);
				}
			},
			new Action() {	// [61] Rexp = Exp.l AND Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 3];
					final Exp r = (Exp) _symbol_r.value;
					return new And(l, r, 0);
				}
			},
			new Action() {	// [62] Rexp = AP Exp.l FP AND Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 5];
					final Exp r = (Exp) _symbol_r.value;
					return new And(l, r, 1);
				}
			},
			new Action() {	// [63] Rexp = Exp.l AND AP Exp.r FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 4];
					final Exp r = (Exp) _symbol_r.value;
					return new And(l, r, 2);
				}
			},
			new Action() {	// [64] Rexp = AP Exp.l FP AND AP Exp.r FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 6];
					final Exp r = (Exp) _symbol_r.value;
					return new And(l, r, 3);
				}
			},
			Action.RETURN,	// [65] Rexp = Aexp
			new Action() {	// [66] Aexp = Exp.l PLUS Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 3];
					final Exp r = (Exp) _symbol_r.value;
					return new Add(l, r, 0);
				}
			},
			new Action() {	// [67] Aexp = AP Exp.l FP PLUS Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 5];
					final Exp r = (Exp) _symbol_r.value;
					return new Add(l, r, 1);
				}
			},
			new Action() {	// [68] Aexp = Exp.l PLUS AP Exp.r FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 4];
					final Exp r = (Exp) _symbol_r.value;
					return new Add(l, r, 2);
				}
			},
			new Action() {	// [69] Aexp = AP Exp.l FP PLUS AP Exp.r FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 6];
					final Exp r = (Exp) _symbol_r.value;
					return new Add(l, r, 3);
				}
			},
			new Action() {	// [70] Aexp = Exp.l SUB Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 3];
					final Exp r = (Exp) _symbol_r.value;
					return new Sub(l, r, 0);
				}
			},
			new Action() {	// [71] Aexp = AP Exp.l FP SUB Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 5];
					final Exp r = (Exp) _symbol_r.value;
					return new Sub(l, r, 1);
				}
			},
			new Action() {	// [72] Aexp = Exp.l SUB AP Exp.r FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 4];
					final Exp r = (Exp) _symbol_r.value;
					return new Sub(l, r, 2);
				}
			},
			new Action() {	// [73] Aexp = AP Exp.l FP SUB AP Exp.r FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 6];
					final Exp r = (Exp) _symbol_r.value;
					return new Sub(l, r, 3);
				}
			},
			Action.RETURN,	// [74] Aexp = Mexp
			new Action() {	// [75] Mexp = Exp.l MULT Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 3];
					final Exp r = (Exp) _symbol_r.value;
					return new Mult(l, r, 0);
				}
			},
			new Action() {	// [76] Mexp = AP Exp.l FP MULT Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 5];
					final Exp r = (Exp) _symbol_r.value;
					return new Mult(l, r, 1);
				}
			},
			new Action() {	// [77] Mexp = Exp.l MULT AP Exp.r FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 4];
					final Exp r = (Exp) _symbol_r.value;
					return new Mult(l, r, 2);
				}
			},
			new Action() {	// [78] Mexp = AP Exp.l FP MULT AP Exp.r FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 6];
					final Exp r = (Exp) _symbol_r.value;
					return new Mult(l, r, 3);
				}
			},
			new Action() {	// [79] Mexp = Exp.l DIV Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 3];
					final Exp r = (Exp) _symbol_r.value;
					return new Div(l, r, 0);
				}
			},
			new Action() {	// [80] Mexp = AP Exp.l FP DIV Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 5];
					final Exp r = (Exp) _symbol_r.value;
					return new Div(l, r, 1);
				}
			},
			new Action() {	// [81] Mexp = Exp.l DIV AP Exp.r FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 4];
					final Exp r = (Exp) _symbol_r.value;
					return new Div(l, r, 2);
				}
			},
			new Action() {	// [82] Mexp = AP Exp.l FP DIV AP Exp.r FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 6];
					final Exp r = (Exp) _symbol_r.value;
					return new Div(l, r, 3);
				}
			},
			new Action() {	// [83] Mexp = Exp.l MOD Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 3];
					final Exp r = (Exp) _symbol_r.value;
					return new Mod(l, r, 0);
				}
			},
			new Action() {	// [84] Mexp = AP Exp.l FP MOD Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 5];
					final Exp r = (Exp) _symbol_r.value;
					return new Mod(l, r, 1);
				}
			},
			new Action() {	// [85] Mexp = Exp.l MOD AP Exp.r FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 4];
					final Exp r = (Exp) _symbol_r.value;
					return new Mod(l, r, 2);
				}
			},
			new Action() {	// [86] Mexp = AP Exp.l FP MOD AP Exp.r FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 6];
					final Exp r = (Exp) _symbol_r.value;
					return new Mod(l, r, 3);
				}
			},
			Action.RETURN,	// [87] Mexp = Sexp
			new Action() {	// [88] Sexp = NOT Exp.l
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					return new Not(l, 0);
				}
			},
			new Action() {	// [89] Sexp = NOT AP Exp.l FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 3];
					final Exp l = (Exp) _symbol_l.value;
					return new Not(l, 1);
				}
			},
			new Action() {	// [90] Sexp = BOOL.n
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_n = _symbols[offset + 1];
					final boolean n = (boolean) _symbol_n.value;
					return new LiteralValue<Boolean>(n);
				}
			},
			new Action() {	// [91] Sexp = NULL.n
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_n = _symbols[offset + 1];
					final String n = (String) _symbol_n.value;
					return new LiteralValue<String>(n);
				}
			},
			new Action() {	// [92] Sexp = INT.n
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_n = _symbols[offset + 1];
					final Integer n = (Integer) _symbol_n.value;
					return new LiteralValue<Integer>(n);
				}
			},
			new Action() {	// [93] Sexp = FLOAT.n
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_n = _symbols[offset + 1];
					final float n = (float) _symbol_n.value;
					return new LiteralValue<Float>(n);
				}
			},
			new Action() {	// [94] Sexp = CHAR.n
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_n = _symbols[offset + 1];
					final Character n = (Character) _symbol_n.value;
					return new LiteralValue<Character>(n);
				}
			},
			Action.RETURN,	// [95] Sexp = Pexp
			new Action() {	// [96] Pexp = Lvalue.l
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Lvalue l = (Lvalue) _symbol_l.value;
					return l;
				}
			},
			new Action() {	// [97] Pexp = NEW TYPE.l LB Exp.r RB
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final String l = (String) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 4];
					final Exp r = (Exp) _symbol_r.value;
					return new Inst(new Type(l), r);
				}
			},
			new Action() {	// [98] Pexp = NEW TYPE.l
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final String l = (String) _symbol_l.value;
					return new Inst(new Type(l));
				}
			},
			Action.RETURN,	// [99] Pexp = ID.l AP Exps FP LB Exp RB
			Action.RETURN,	// [100] Exps = Exp
			RETURN2	// [101] Exps = Exp Exps; returns 'Exps' although none is marked
		};
	}

	protected Symbol invokeReduceAction(int rule_num, int offset) {
		return actions[rule_num].reduce(_symbols, offset);
	}
}
