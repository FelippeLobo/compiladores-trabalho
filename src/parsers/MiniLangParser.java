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
		"U9pbLrbmL4KKFU#zG8mX2H47n0n922J4g1cp9uHDWd510Ye20Y96GKCG4H4LMU8AfLRvPrb" +
		"Q#e5BbJ#MLVvOLbc082v4HHGtH5PHm1NS4F5wtfjEflkz6IR37pXLvvs#ztQVrtsx#tKFuA" +
		"p1S5IY1gKu3sKu7nTW40em63d8GYxw8OG168Wy397ryY$EzDMzH0Hfya$0Fm7JSIDkGHlQb" +
		"LxqkLppNuu8BiDro4GJbilV0OqhCKfseoxW7wzft8s874Uc77CrDFyzz1$5I2pn$DDy2hM9" +
		"nXXJaBto7VlNY55OZ2PPXug4RQeJHXBvnw4XqATBETuhC2Om6vC2cGpgNHzGyziJvJVSYQj" +
		"mjQPs0wRWmHwet#nNap#JvmyBCHT3KOmI3CE5S62ZDyx00fIZJymlQrFEtQdkz#UbbvSNlp" +
		"SzhZV3yvRZOitRYCdoFMQW6IrevHgwbMlUR7SjP$uksOTxiLJsu9f0T2dkmqgiu5hemDJ0#" +
		"ZlTRJERz#C1F8I7CI99lKUmIlu0C1RBKjBl#ZK7wfcpCijdpqvIVquFndcRLjyVdPyaVZlZ" +
		"sLgy77qDwop3Ejkm#XlMEOPrhc653IlVi0eDgyYmBZAiAiEgDwpHXZNJi6uoh7c6jKYp8ce" +
		"EcxfdymvO$BuvIFDsSphtQ0PFhKn#wRAOjHpcAfSPwiUyX5ZRNzUcBp#ElvIP6y1y3MIMed" +
		"hHvs3DFvpVb3viDzJxsWGrBCP3XD#VfMaKCmugmDE8#QizVuWPTFr#XK49nnXJAEICvh5T7" +
		"jzHGAMY4#GbKIIHtwAQlqyXUahZ#4i2cOpNWs3k$Ehv77KDHnLJ6qQVTLBguHxaBxR$t3KO" +
		"uJgluBuizlaRKyxTgUwFdvUJzzgSZJ2VLLppjhU6wWFjeZDlyGGFyVxeZxhdVI5XyMPNctG" +
		"bdMwscOqmzuIRZweazVAPgp3$FmJhdR2Tg5zI$KZ0JbO$jN7wetKfnl$FLfwQmuBksNJFdz" +
		"KTqVDqedSMmJiPtHDpDk6URgtgr9rFX8bDFF1gMQqtUImvczn2xa#UJkQfQiqbbv0NaSl9A" +
		"yXimoytx57aCd9pzBrsY#8fBgS2$ehORfPx5r0QV2yUKx6PH3Lz2yXFAT$Zj9UGfn6BMNwK" +
		"$88Ryx81$ci5NbTQp$7n2b59R2364#EqTqyYTX0l4vyJdn5lSAmRLNmdiP3ss#IHr7k9vLr" +
		"ara4diPlOHXo8rhVsChQLXMCizrK#zi$wbWKtZtjOVf9yKCLoMJuQBJlijvD1tneQxUHFYK" +
		"zORY0V8VWkYzhMFjMM$RRs4zIq7M8UqQR6FOVWNDlBQ1mdTwWsJcpirXEAdrRyeXRBKJg75" +
		"1zMtDLNLSz9LvojEAGuh7Y8uZB55LtlI0LiLw#LHyU9DvksFLMBJT3yxMOzwzLOsTippoRk" +
		"0zQfDkjz6biq$LNgdPEL$OpYvxN#p52#rpIDjIhMgcARDStjMjishSsRMjzg4$LRrUrC7BF" +
		"LEx4QSNx27I2$4zk9huWlYIy8xXRXRX6kKk4gbO#9BSH7ye5yBTjagtmedR9PtfVtv5rvHp" +
		"PvQjzuJ#ucsU2LDhhwtUzwI$4EpNT83ifE#S7equ5Otmp$aUxIOVcLpr#8ducVXFjFzhjza" +
		"1y38znbzE4l8pY6TqIBDn#RS8YkSfGhUJury9ngu4aLOJpYSRfYYx0rEFpFOH6sLwU2TxHQ" +
		"#cffrv7h6AiXrv2hoTNaUdAfTwjA8noU0nQ$kau2M3mZ70MBfuMZmUBPOHDMN9HxS8XUtfs" +
		"kdFrpxmXLB8$u3sSh9cy=");

	static final Action RETURN5 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 5];
		}
	};

	static final Action RETURN7 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 7];
		}
	};

	static final Action RETURN2 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 2];
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
			new Action() {	// [1] Prog = Stmt.l SEMI
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Node l = (Node) _symbol_l.value;
					 return new Prog(l);
				}
			},
			new Action() {	// [2] Prog = Stmt.l SEMI Prog.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Node l = (Node) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 3];
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
			new Action() {	// [10] Stmt = ID.l EQ Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final String l = (String) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 3];
					final Exp r = (Exp) _symbol_r.value;
					 return new Attr((String)l, r);
				}
			},
			RETURN5,	// [11] Stmt = IF AP Exp FP Stmt; returns 'Stmt' although none is marked
			RETURN7,	// [12] Stmt = IF AP Exp FP Stmt ELSE Stmt; returns 'Stmt' although none is marked
			RETURN5,	// [13] Stmt = ITERATE AP Exp FP Stmt; returns 'Stmt' although none is marked
			Action.RETURN,	// [14] Stmt = Exp
			new Action() {	// [15] Stmt = READ Lvalue.l
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final Lvalue l = (Lvalue) _symbol_l.value;
					return new Read(l);
				}
			},
			new Action() {	// [16] Stmt = PRINT Exp.e
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e = _symbols[offset + 2];
					final Exp e = (Exp) _symbol_e.value;
					 return new Print(e);
				}
			},
			RETURN2,	// [17] Stmt = RETURN Ret; returns 'Ret' although none is marked
			new Action() {	// [18] Stmt = Lvalue.l EQ Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Lvalue l = (Lvalue) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 3];
					final Exp r = (Exp) _symbol_r.value;
					 return new Attr(l, r);
				}
			},
			new Action() {	// [19] lst$Lvalue = Lvalue
				public Symbol reduce(Symbol[] _symbols, int offset) {
					ArrayList lst = new ArrayList(); lst.add(_symbols[offset + 1].value); return new Symbol(lst);
				}
			},
			new Action() {	// [20] lst$Lvalue = lst$Lvalue Lvalue
				public Symbol reduce(Symbol[] _symbols, int offset) {
					((ArrayList) _symbols[offset + 1].value).add(_symbols[offset + 2].value); return _symbols[offset + 1];
				}
			},
			RETURN7,	// [21] Stmt = ID AP Exps FP LESSER lst$Lvalue GREATER; returns 'GREATER' although none is marked
			new Action() {	// [22] Func = ID.a AP ParamList.b FP COLON Return.c AC StmtList.d FC
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
			new Action() {	// [23] StmtList = Stmt.l SEMI StmtList.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Node l = (Node) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 3];
					final Node r = (Node) _symbol_r.value;
					 return new StmtList(l, r);
				}
			},
			new Action() {	// [24] StmtList = Stmt.l SEMI
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Node l = (Node) _symbol_l.value;
					 return new StmtList(l);
				}
			},
			RETURN3,	// [25] Ret = Exp COMMA Ret; returns 'Ret' although none is marked
			Action.RETURN,	// [26] Ret = Exp
			new Action() {	// [27] Return = TYPE.a COMMA Return.b
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_a = _symbols[offset + 1];
					final String a = (String) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 3];
					final Node b = (Node) _symbol_b.value;
					return new Return(new Type(a), b);
				}
			},
			new Action() {	// [28] Return = TYPE.a
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_a = _symbols[offset + 1];
					final String a = (String) _symbol_a.value;
					return new Return(new Type(a));
				}
			},
			new Action() {	// [29] ParamList = Param.a COMMA ParamList.b
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_a = _symbols[offset + 1];
					final Node a = (Node) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 3];
					final Node b = (Node) _symbol_b.value;
					return new ParamList(a, b);
				}
			},
			new Action() {	// [30] ParamList = Param.a
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_a = _symbols[offset + 1];
					final Node a = (Node) _symbol_a.value;
					return new ParamList(a);
				}
			},
			new Action() {	// [31] Param = ID.a DBCOLON TYPE.b
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_a = _symbols[offset + 1];
					final String a = (String) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 3];
					final String b = (String) _symbol_b.value;
					return new Param(new Lvalue(a), new Type(b));
				}
			},
			new Action() {	// [32] Lvalue = ID.l
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final String l = (String) _symbol_l.value;
					return new Lvalue(l);
				}
			},
			new Action() {	// [33] Lvalue = Lvalue.l LB Exp.r RB
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Lvalue l = (Lvalue) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 3];
					final Exp r = (Exp) _symbol_r.value;
					return new Lvalue(l,r);
				}
			},
			new Action() {	// [34] Lvalue = Lvalue.l DOT ID.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Lvalue l = (Lvalue) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 3];
					final String r = (String) _symbol_r.value;
					return new Lvalue(l,r);
				}
			},
			Action.RETURN,	// [35] Exp = Rexp
			RETURN3,	// [36] Rexp = Exp GREATER Exp; returns 'Exp' although none is marked
			RETURN3,	// [37] Rexp = Exp LESSER Exp; returns 'Exp' although none is marked
			RETURN3,	// [38] Rexp = Exp GREATEREQUAL Exp; returns 'Exp' although none is marked
			RETURN3,	// [39] Rexp = Exp LESSEREQUAL Exp; returns 'Exp' although none is marked
			RETURN3,	// [40] Rexp = Exp EQUALTO Exp; returns 'Exp' although none is marked
			RETURN3,	// [41] Rexp = Exp DIF Exp; returns 'Exp' although none is marked
			Action.RETURN,	// [42] Rexp = Aexp
			new Action() {	// [43] Aexp = Exp.l PLUS Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 3];
					final Exp r = (Exp) _symbol_r.value;
					return new Add(l, r);
				}
			},
			new Action() {	// [44] Aexp = Exp.l SUB Exp.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Exp l = (Exp) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 3];
					final Exp r = (Exp) _symbol_r.value;
					return new Sub(l, r);
				}
			},
			Action.RETURN,	// [45] Aexp = Mexp
			RETURN3,	// [46] Mexp = Exp MULT Exp; returns 'Exp' although none is marked
			RETURN3,	// [47] Mexp = Exp DIV Exp; returns 'Exp' although none is marked
			RETURN3,	// [48] Mexp = Exp RES Exp; returns 'Exp' although none is marked
			Action.RETURN,	// [49] Mexp = Sexp
			RETURN2,	// [50] Sexp = Exp NOT; returns 'NOT' although none is marked
			new Action() {	// [51] Sexp = BOOL.n
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_n = _symbols[offset + 1];
					final boolean n = (boolean) _symbol_n.value;
					return new LiteralValue<Boolean>(n);
				}
			},
			Action.RETURN,	// [52] Sexp = NULL
			new Action() {	// [53] Sexp = INT.n
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_n = _symbols[offset + 1];
					final Integer n = (Integer) _symbol_n.value;
					return new LiteralValue<Integer>(n);
				}
			},
			new Action() {	// [54] Sexp = FLOAT.n
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_n = _symbols[offset + 1];
					final float n = (float) _symbol_n.value;
					return new LiteralValue<Float>(n);
				}
			},
			new Action() {	// [55] Sexp = CHAR.n
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_n = _symbols[offset + 1];
					final char n = (char) _symbol_n.value;
					return new LiteralValue<Character>(n);
				}
			},
			Action.RETURN,	// [56] Sexp = Pexp
			new Action() {	// [57] Pexp = Lvalue.l
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final Lvalue l = (Lvalue) _symbol_l.value;
					return l;
				}
			},
			RETURN3,	// [58] Pexp = AP Exp FP; returns 'FP' although none is marked
			new Action() {	// [59] Pexp = NEW TYPE.l LB Exp.r RB
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final String l = (String) _symbol_l.value;
					final Symbol _symbol_r = _symbols[offset + 4];
					final Exp r = (Exp) _symbol_r.value;
					return new Inst(new Type(l), r);
				}
			},
			new Action() {	// [60] Pexp = NEW TYPE.l
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 2];
					final String l = (String) _symbol_l.value;
					return new Inst(new Type(l));
				}
			},
			Action.RETURN,	// [61] Pexp = ID.l AP Exps FP LB Exp RB
			Action.RETURN,	// [62] Exps = Exp
			RETURN2	// [63] Exps = Exp Exps; returns 'Exps' although none is marked
		};
	}

	protected Symbol invokeReduceAction(int rule_num, int offset) {
		return actions[rule_num].reduce(_symbols, offset);
	}
}
