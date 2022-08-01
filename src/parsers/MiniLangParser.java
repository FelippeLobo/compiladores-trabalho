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
		"U9pjMGjqLDKLtJEJcKafWgBbLqn25D0Wb8H0I28KGGLgHQJIgaNhhshzLLeKQbMWfBPeeSN" +
		"I2aJvWo22Y14453JAJr5GL2e84WL4vAFyGV1spvqJvjutxyP1rq9TAxFMlkViVSuzxzttth" +
		"tllWH8pyT0$1P$ngsu4ttm1$mHVN4NCj4OPw0sJi8fE1K$GZqqm8znkXgbliGFalFL4JyLJ" +
		"og5JNW9o$0ctiOQgVeSNiHkhwgEOX1sgyE#TMhu7lCBr527aghlmht9rN5Vh3eM#TJsqtQe" +
		"2fJWKwFAXpY8mNXGZJIqLAlDH9awWAUDdizWBYem3$E$HhNdiHZbM6hqN8xNKOQtyDHNL2j" +
		"ntLKqIxfUoJbbwYDdR3PgOfqpUeupakkCj7L6YfsHZix81Sx8pvoHIvoHovoHAvoHgvsHwv" +
		"sHcvoHtpiZBlqztECtpzKc33ZkMaFnW3FsBsVatyx8VvsHKSx8eyx8M6TaWZCosHcPwenCT" +
		"qPUSKPUSqOgiCeP#mZlEjVZ3x4Hwx4ID#1c$0wtu6w4i0L1X155F$mmeQj7Zli#VrjwBro9" +
		"tw05pa8U2d0kpiE5k0WzdFdUyMz3cXw$Lz#AYA##4#bQ$zndpHo8QKbpPYFVCHypCiKdUwA" +
		"FDiv7Uyn76#sZFUAZZV3HXljemtoqXtoq9ZwQtvN8IJ7l9odcvQUOLvXYNeSKypgdcDSrnR" +
		"oBKyphcMBUhrBCwvrYthKfvlbfjt#3ljMQdzOFVpDMd$xu37lO3i4Cp66xWRlExzBPsclb2" +
		"rYGf2nCKbOaAMyaAPkJb4#Ihin1xCK#NfE$U2Fg0np2VaR#xeaSm65yWIFOpgjfrr$2pBK6" +
		"jvZQZ$$1$BtFU2qh#sIBrR7OQHQhQx7w5cjeiKOMox1ObiMoBNQcnPfQx6oBDRTOIukribX" +
		"hYxMnM3kB5LcilSL#Qh5E5ZlVObqirirYFxTOTujTQh5VMEoN5hlSOh#ss5KMkyPYrrdiHe" +
		"lTPh4xBFOdYzrliRzQx1yM#wV57hROVomsqcAb5XjZiV4McsInnotsXCLUjjYh5dl7OXyOR" +
		"3MUFJPp#eiT0kzl5WBSbuRqtYp2tLOwl#bhS8TQa$kvMjpLdSnTNHtkwqxZpgukztRmpVTN" +
		"WzGpkHjioFrW8#u8urNFedv6aWgj#jTfwZXcKy9RfudUZNhL35tThugVLi2ppk2CIbHfnhn" +
		"w6WajrMgnVbdSfILwrgVMcFCtysjKosAl8Dj4po1Nbm3hr$gAQXbLt5NlzKhE2V2iNR7QZ3" +
		"Mhedfrv4H5N7fzlftydecOVhorwbNHvzk$0j$FIECgPbUxAcAPZELmFt4ElyjRyWkl5NAvD" +
		"hJcDrmRZzx#kE$pzqLFRVonlsdwwm7HKr$Fc#WrFRNiQgrQgzQgjKhDNdqokF8tPfkDjjnr" +
		"PdD7M$GTFjjSv9qm9OFdaubYVMMyaTWAdEKJgQ$VeyNSYteZkHvkiomKAkE7mYgpgrargsR" +
		"chCivDdCon6Ohpm$dyblzwC3utnmk9LeIiRycT2QoYTx4XSJLH7CWi8Ue4SyF3GM2dz2Efj" +
		"r7Eua843E9auZdY0P4ET64M47a4k#oSmxjHjesjDkatbwnNyPjMZeRYQNL4Tk8nsyWVbEnh" +
		"QXL#aLYpwVMMlpkOY#drb7ywyJUHkrYyUyMInEuKlm7nOwWTfFuOzXSGJkLMb$HPhEvWVPv" +
		"QeD4Mo9s5RLXugyLkubQgVWxnHwaDZNcntauIFuihqVxIatqcjIwqTPblDoC#O5v4uaivgw" +
		"CStGXBgF6Un1O9reVydpQ#uZRwNTWR5yiffyIO00nGkfrvVqEYD#JVctn#Qm46ub$8$spnR" +
		"#JVblnxw7VMVmI#Zt47qR$Al57qhz5$0dq#ud$9FsIk1yQp6OK4NkMPl5Swm2H5lJ79yOTA" +
		"MB3iVEx1E0pYjXzwqlCbJ7VBxQ0jPVIhg5zaySOJdyUKKhCbvmDZArZB5PZCi5d6#NnM72w" +
		"v5G0wUbohfkfpnD$5yzFxZkEa1yYtq8xZkSOOjvIYTrAVponY3xdId2PZBKNczWywohZwaI" +
		"VzoCqYE1umcEaF$NmMCOvXoCN4SM4FDiHphF81SGb90$JNYldFaUE8VSdr4bizyHr39Od$C" +
		"WrOcKkHEuGUvVOUyKE5Ylp9p9Sx4YnOyLE4Jj3R9bnh0LYpUCl5xlAqDQ8tM1ecyLkDxGzO" +
		"WydjAWynz5qGvFdELhNq4uNUwQXDHURPsY5OZiQMXUnnZMDzXBRkr8JVht93LtcGxIFNzpH" +
		"fx#FDi3caOP6x053R#RfDzJmHnX#gU5FCFnfXZ$ByESQ$aB3NspuAmn$TS8Fc#TmWCsGgiU" +
		"F4kctoQYnmnXZljHQQsZdUSPT8VtsYrMUOympShSQTRhPUP4UHjukEnQid1FfdZwdU8xLi#" +
		"hnHawj8jP2QXn5qa#jrotVxEezuXs2gw1wdLXEB2PU8lXcKrprr3F4KyHqtMiQeVyRgBWIg" +
		"xUrznQnIdjl42kqzognJ7jBY5Uqnts1Ub5x2ua5skEwg#PgZsy#DLjxND$LJEtn3Q2UqDvK" +
		"jLRE$WLLfXwddQBPP3L9JLGJr7WrJerLOzHZMdsVADNUe$7HIj$HOjVfTePkdzRj7DtEr#q" +
		"YtRwiswMwVKstAtMxMhThZAfSgzLMjLvjiwxonsglscSUNQkxZtcV4PyJkpJRgTiTkjqk6V" +
		"6nV6hqtY9siw5ji4Puq3hSpMYl$wuMGp39jk4NPZ6$D8lvhPb7daSzbpoNtvrnX8aW4JAGn" +
		"ZraW8ZfwSZdzsa#S$DPgv3nGiRQqRQZBQ0je2sYpT7$6qaZGjnN1hXl3H5XGVG4y01toY4Y" +
		"B8Zwy03tmo4YB8Ycm0FSVGU9D2BWH2kDC14aelmo3X11TFW$Cewnh0==");

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
					return new Decl(l, new Type(t));
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
					return new Decl(l, new Type(t), r);
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
			new Action() {	// [13] Stmt = ITERATE AP Exp.l FP AC Stmt.r FC
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 3];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 6];
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
			new Action() {	// [25] Func = ID.a AP ParamList.b FP AC StmtList.c FC
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_a = _symbols[offset + 1];
					final String a = (String) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 3];
					final Node b = (Node) _symbol_b.value;
					final Symbol _symbol_c = _symbols[offset + 6];
					final Node c = (Node) _symbol_c.value;
					return new Func(new Lvalue(a), b, c);
				}
			},
			new Action() {	// [26] Func = ID.a AP FP AC StmtList.b FC
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_a = _symbols[offset + 1];
					final String a = (String) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 5];
					final Node b = (Node) _symbol_b.value;
					return new Func(new Lvalue(a), b);
				}
			},
			RETURN3,	// [27] Ret = Exp COMMA Ret; returns 'Ret' although none is marked
			Action.RETURN,	// [28] Ret = Exp
			new Action() {	// [29] Return = TYPE.a COMMA Return.b
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_a = _symbols[offset + 1];
					final String a = (String) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 3];
					final Node b = (Node) _symbol_b.value;
					return new Return(new Type(a), b);
				}
			},
			new Action() {	// [30] Return = TYPE.a
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_a = _symbols[offset + 1];
					final String a = (String) _symbol_a.value;
					return new Return(new Type(a));
				}
			},
			new Action() {	// [31] ParamList = Param.a COMMA ParamList.b
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_a = _symbols[offset + 1];
					final Node a = (Node) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 3];
					final Node b = (Node) _symbol_b.value;
					return new ParamList(a, b);
				}
			},
			new Action() {	// [32] ParamList = Param.a
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_a = _symbols[offset + 1];
					final Node a = (Node) _symbol_a.value;
					return new ParamList(a);
				}
			},
			new Action() {	// [33] Param = ID.a DBCOLON TYPE.b
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_a = _symbols[offset + 1];
					final String a = (String) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 3];
					final String b = (String) _symbol_b.value;
					return new Param(new Lvalue(a), new Type(b));
				}
			},
			new Action() {	// [34] Lvalue = ID.l
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final String l = (String) _symbol_l.value;
					return new Lvalue(l);
				}
			},
			new Action() {	// [35] Lvalue = Lvalue.l LB Exp.r RB
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Lvalue l = (Lvalue) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 3];
					final Exp r = (Exp) _symbol_r.value;
					return new Lvalue(l,r);
				}
			},
			new Action() {	// [36] Lvalue = Lvalue.l DOT ID.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Lvalue l = (Lvalue) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 3];
					final String r = (String) _symbol_r.value;
					return new Lvalue(l,r);
				}
			},
			Action.RETURN,	// [37] Exp = Rexp
			new Action() {	// [38] Rexp = Exp.l GREATER Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 3];
					final Exp r = (Exp) _symbol_r.value;
					return new Greater(l, r, 0);
				}
			},
			new Action() {	// [39] Rexp = AP Exp.l FP GREATER Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 5];
					final Exp r = (Exp) _symbol_r.value;
					return new Greater(l, r, 1);
				}
			},
			new Action() {	// [40] Rexp = Exp.l GREATER AP Exp.r FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 4];
					final Exp r = (Exp) _symbol_r.value;
					return new Greater(l, r, 2);
				}
			},
			new Action() {	// [41] Rexp = AP Exp.l FP GREATER AP Exp.r FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 6];
					final Exp r = (Exp) _symbol_r.value;
					return new Greater(l, r, 3);
				}
			},
			new Action() {	// [42] Rexp = Exp.l LESSER Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 3];
					final Exp r = (Exp) _symbol_r.value;
					return new Lesser(l, r, 0);
				}
			},
			new Action() {	// [43] Rexp = AP Exp.l FP LESSER Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 5];
					final Exp r = (Exp) _symbol_r.value;
					return new Lesser(l, r, 1);
				}
			},
			new Action() {	// [44] Rexp = Exp.l LESSER AP Exp.r FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 4];
					final Exp r = (Exp) _symbol_r.value;
					return new Lesser(l, r, 2);
				}
			},
			new Action() {	// [45] Rexp = AP Exp.l FP LESSER AP Exp.r FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 6];
					final Exp r = (Exp) _symbol_r.value;
					return new Lesser(l, r, 3);
				}
			},
			new Action() {	// [46] Rexp = Exp.l GREATEREQUAL Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 3];
					final Exp r = (Exp) _symbol_r.value;
					return new GreaterEqual(l, r, 0);
				}
			},
			new Action() {	// [47] Rexp = AP Exp.l FP GREATEREQUAL Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 5];
					final Exp r = (Exp) _symbol_r.value;
					return new GreaterEqual(l, r, 1);
				}
			},
			new Action() {	// [48] Rexp = Exp.l GREATEREQUAL AP Exp.r FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 4];
					final Exp r = (Exp) _symbol_r.value;
					return new GreaterEqual(l, r, 2);
				}
			},
			new Action() {	// [49] Rexp = AP Exp.l FP GREATEREQUAL AP Exp.r FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 6];
					final Exp r = (Exp) _symbol_r.value;
					return new GreaterEqual(l, r, 3);
				}
			},
			new Action() {	// [50] Rexp = Exp.l LESSEREQUAL Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 3];
					final Exp r = (Exp) _symbol_r.value;
					return new LesserEqual(l, r, 0);
				}
			},
			new Action() {	// [51] Rexp = AP Exp.l FP LESSEREQUAL Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 5];
					final Exp r = (Exp) _symbol_r.value;
					return new LesserEqual(l, r, 1);
				}
			},
			new Action() {	// [52] Rexp = Exp.l LESSEREQUAL AP Exp.r FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 4];
					final Exp r = (Exp) _symbol_r.value;
					return new LesserEqual(l, r, 2);
				}
			},
			new Action() {	// [53] Rexp = AP Exp.l FP LESSEREQUAL AP Exp.r FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 6];
					final Exp r = (Exp) _symbol_r.value;
					return new LesserEqual(l, r, 3);
				}
			},
			new Action() {	// [54] Rexp = Exp.l EQUALTO Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 3];
					final Exp r = (Exp) _symbol_r.value;
					return new Equal(l, r, 0);
				}
			},
			new Action() {	// [55] Rexp = AP Exp.l FP EQUALTO Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 5];
					final Exp r = (Exp) _symbol_r.value;
					return new Equal(l, r, 1);
				}
			},
			new Action() {	// [56] Rexp = Exp.l EQUALTO AP Exp.r FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 4];
					final Exp r = (Exp) _symbol_r.value;
					return new Equal(l, r, 2);
				}
			},
			new Action() {	// [57] Rexp = AP Exp.l FP EQUALTO AP Exp.r FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 6];
					final Exp r = (Exp) _symbol_r.value;
					return new Equal(l, r, 3);
				}
			},
			new Action() {	// [58] Rexp = Exp.l DIF Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 3];
					final Exp r = (Exp) _symbol_r.value;
					return new Dif(l, r, 0);
				}
			},
			new Action() {	// [59] Rexp = AP Exp.l FP DIF Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 5];
					final Exp r = (Exp) _symbol_r.value;
					return new Dif(l, r, 1);
				}
			},
			new Action() {	// [60] Rexp = Exp.l DIF AP Exp.r FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 4];
					final Exp r = (Exp) _symbol_r.value;
					return new Dif(l, r, 2);
				}
			},
			new Action() {	// [61] Rexp = AP Exp.l FP DIF AP Exp.r FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 6];
					final Exp r = (Exp) _symbol_r.value;
					return new Dif(l, r, 3);
				}
			},
			new Action() {	// [62] Rexp = Exp.l AND Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 3];
					final Exp r = (Exp) _symbol_r.value;
					return new And(l, r, 0);
				}
			},
			new Action() {	// [63] Rexp = AP Exp.l FP AND Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 5];
					final Exp r = (Exp) _symbol_r.value;
					return new And(l, r, 1);
				}
			},
			new Action() {	// [64] Rexp = Exp.l AND AP Exp.r FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 4];
					final Exp r = (Exp) _symbol_r.value;
					return new And(l, r, 2);
				}
			},
			new Action() {	// [65] Rexp = AP Exp.l FP AND AP Exp.r FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 6];
					final Exp r = (Exp) _symbol_r.value;
					return new And(l, r, 3);
				}
			},
			Action.RETURN,	// [66] Rexp = Aexp
			new Action() {	// [67] Aexp = Exp.l PLUS Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 3];
					final Exp r = (Exp) _symbol_r.value;
					return new Add(l, r, 0);
				}
			},
			new Action() {	// [68] Aexp = AP Exp.l FP PLUS Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 5];
					final Exp r = (Exp) _symbol_r.value;
					return new Add(l, r, 1);
				}
			},
			new Action() {	// [69] Aexp = Exp.l PLUS AP Exp.r FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 4];
					final Exp r = (Exp) _symbol_r.value;
					return new Add(l, r, 2);
				}
			},
			new Action() {	// [70] Aexp = AP Exp.l FP PLUS AP Exp.r FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 6];
					final Exp r = (Exp) _symbol_r.value;
					return new Add(l, r, 3);
				}
			},
			new Action() {	// [71] Aexp = Exp.l SUB Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 3];
					final Exp r = (Exp) _symbol_r.value;
					return new Sub(l, r, 0);
				}
			},
			new Action() {	// [72] Aexp = AP Exp.l FP SUB Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 5];
					final Exp r = (Exp) _symbol_r.value;
					return new Sub(l, r, 1);
				}
			},
			new Action() {	// [73] Aexp = Exp.l SUB AP Exp.r FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 4];
					final Exp r = (Exp) _symbol_r.value;
					return new Sub(l, r, 2);
				}
			},
			new Action() {	// [74] Aexp = AP Exp.l FP SUB AP Exp.r FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 6];
					final Exp r = (Exp) _symbol_r.value;
					return new Sub(l, r, 3);
				}
			},
			Action.RETURN,	// [75] Aexp = Mexp
			new Action() {	// [76] Mexp = Exp.l MULT Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 3];
					final Exp r = (Exp) _symbol_r.value;
					return new Mult(l, r, 0);
				}
			},
			new Action() {	// [77] Mexp = AP Exp.l FP MULT Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 5];
					final Exp r = (Exp) _symbol_r.value;
					return new Mult(l, r, 1);
				}
			},
			new Action() {	// [78] Mexp = Exp.l MULT AP Exp.r FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 4];
					final Exp r = (Exp) _symbol_r.value;
					return new Mult(l, r, 2);
				}
			},
			new Action() {	// [79] Mexp = AP Exp.l FP MULT AP Exp.r FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 6];
					final Exp r = (Exp) _symbol_r.value;
					return new Mult(l, r, 3);
				}
			},
			new Action() {	// [80] Mexp = Exp.l DIV Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 3];
					final Exp r = (Exp) _symbol_r.value;
					return new Div(l, r, 0);
				}
			},
			new Action() {	// [81] Mexp = AP Exp.l FP DIV Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 5];
					final Exp r = (Exp) _symbol_r.value;
					return new Div(l, r, 1);
				}
			},
			new Action() {	// [82] Mexp = Exp.l DIV AP Exp.r FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 4];
					final Exp r = (Exp) _symbol_r.value;
					return new Div(l, r, 2);
				}
			},
			new Action() {	// [83] Mexp = AP Exp.l FP DIV AP Exp.r FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 6];
					final Exp r = (Exp) _symbol_r.value;
					return new Div(l, r, 3);
				}
			},
			new Action() {	// [84] Mexp = Exp.l MOD Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 3];
					final Exp r = (Exp) _symbol_r.value;
					return new Mod(l, r, 0);
				}
			},
			new Action() {	// [85] Mexp = AP Exp.l FP MOD Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 5];
					final Exp r = (Exp) _symbol_r.value;
					return new Mod(l, r, 1);
				}
			},
			new Action() {	// [86] Mexp = Exp.l MOD AP Exp.r FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 4];
					final Exp r = (Exp) _symbol_r.value;
					return new Mod(l, r, 2);
				}
			},
			new Action() {	// [87] Mexp = AP Exp.l FP MOD AP Exp.r FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 6];
					final Exp r = (Exp) _symbol_r.value;
					return new Mod(l, r, 3);
				}
			},
			Action.RETURN,	// [88] Mexp = Sexp
			new Action() {	// [89] Sexp = NOT Exp.l
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Exp l = (Exp) _symbol_l.value;
					return new Not(l, 0);
				}
			},
			new Action() {	// [90] Sexp = NOT AP Exp.l FP
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 3];
					final Exp l = (Exp) _symbol_l.value;
					return new Not(l, 1);
				}
			},
			new Action() {	// [91] Sexp = BOOL.n
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_n = _symbols[offset + 1];
					final boolean n = (boolean) _symbol_n.value;
					return new LiteralValue<Boolean>(n);
				}
			},
			new Action() {	// [92] Sexp = NULL.n
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_n = _symbols[offset + 1];
					final String n = (String) _symbol_n.value;
					return new LiteralValue<String>(n);
				}
			},
			new Action() {	// [93] Sexp = CHARESCAPE.n
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_n = _symbols[offset + 1];
					final String n = (String) _symbol_n.value;
					return new LiteralValue<String>(n);
				}
			},
			new Action() {	// [94] Sexp = INT.n
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_n = _symbols[offset + 1];
					final Integer n = (Integer) _symbol_n.value;
					return new LiteralValue<Integer>(n);
				}
			},
			new Action() {	// [95] Sexp = FLOAT.n
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_n = _symbols[offset + 1];
					final float n = (float) _symbol_n.value;
					return new LiteralValue<Float>(n);
				}
			},
			new Action() {	// [96] Sexp = CHAR.n
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_n = _symbols[offset + 1];
					final Character n = (Character) _symbol_n.value;
					return new LiteralValue<Character>(n);
				}
			},
			Action.RETURN,	// [97] Sexp = Pexp
			new Action() {	// [98] Pexp = Lvalue.l
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Lvalue l = (Lvalue) _symbol_l.value;
					return l;
				}
			},
			new Action() {	// [99] Pexp = NEW TYPE.l LB Exp.r RB
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final String l = (String) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 4];
					final Exp r = (Exp) _symbol_r.value;
					return new Inst(new Type(l), r);
				}
			},
			new Action() {	// [100] Pexp = NEW TYPE.l
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final String l = (String) _symbol_l.value;
					return new Inst(new Type(l));
				}
			},
			Action.RETURN,	// [101] Pexp = ID.l AP Exps FP LB Exp RB
			Action.RETURN,	// [102] Exps = Exp
			RETURN2	// [103] Exps = Exp Exps; returns 'Exps' although none is marked
		};
	}

	protected Symbol invokeReduceAction(int rule_num, int offset) {
		return actions[rule_num].reduce(_symbols, offset);
	}
}
