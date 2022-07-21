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
		"U9pbbrbm5KKKXl#PYKGY84OGI48MYAX80YINX40qYhW1AWg8AAxWpkA24GK5gYnyq3UhVAK" +
		"ijNoGSgcYIXyi2iCcgxY06wA00cwuW1kWxJTpEwJlt7j9Rk4JpDH$$zFdz3dTVRgdkwyKp3" +
		"N$ga13LQrpTPu6wdmDKgCnQZ97qlGJTADkqnsQhkjKgRCrGEUeIirjUhDRUQhN9PgfyMesX" +
		"z8YZ51VbQdY697loXpP#jsf6ir7VtNC$rR7wru5EaMTTAg6Eptxq$nZzjeefwkhpj2PwgbU" +
		"wgDYzLSZRnDZFgmXMUjaquyoVwj1YRG#NQnH6gaBDIphMBD4DE$g8bsgopH3rwT5ZPSlDmV" +
		"DJbtXHBr1O$H0#wredDcdYRg9NjxSRZxpetpUte6eSKy$ycpKW#JtRaOqIxDrd$d6hCWvpo" +
		"URFfx9pb4ctI$l8RDB3siE6Ar7DPSlRpxP7H$p7Al7zBZcwGazgIlJR0krG39$IBegRQMUQ" +
		"EL7ZjC$DNUJO#KfxTI$vRZxx#wDNHmv#ToZRewkkoCNEd8FHpxBaNixSf4ZbpXogIENEt8$" +
		"HnxioBMEV84ZN#l8annvgYDFS#Jx7RbEroY7ntoLV6tnD5x9OrSAEAd2KoAVRweONTyC#fv" +
		"ag1UPwKFBRRDGxkZBoCamUjMViwOyGuGHVBK5j9bxvAHV7NtpqCVzNQygriXWpgsXp5kRVm" +
		"czAR5Hkh2tT6E7wSuEKyWUquEenOmu77DHrZhPz1vUuUgBzwahcgeC#lYOqYCMuLF43FkHb" +
		"EeTBzUIyIBotXPr0EFitu5MIgaNy7ePMicSpweEHCtiMSmzfI#zykblFTz76JU1NFDyikap" +
		"PzBLXZDNGKuhoAvFJeUXgUVBYtisCDEbKSr41bifjziIa6XthPtivNZkukNswl#VxJkoYHx" +
		"snYps4qfcnp8vFAqxkotruvKMBKoUVWsW07Isf#6SQ2UN5eFm5l6254oK$3mEibeOczS4zu" +
		"37mfmftcIu4fu63u9dmmbu7jn8Z6fuD3m67fTirvzeUMh8kG2VwVpCjFqdlZy3Nk3Omp5C0" +
		"C#3fM09mzwFVZxoCzPlNMfC$eT8Ru9Nm0Qm4hm8Dbdx3Z05x2GVauZr5FBhZF5fy1poONJF" +
		"mil0Pj02jbdV8zXUWlTIrqlgl2NXHKJX3Kq#Fjwhy3lMLeYyoigza3V2Rr78XyEyXdUJjV1" +
		"si0ei1pji$HM0FdghmRTW6zXgRH#10s0N1URCssFrRXv6MjvjRIyxULrcURbbsqT$lUKjbk" +
		"su$UsMTrdUPtc$vOEM3xMsqL4m1$5ofzIozqQhpDoJ$zRr7dJfM7mjjN5QOd6tE779PL0Ow" +
		"qTlEwPPbfiTMwdLBNRQiJa9AcsvlCtcl#Ru3dJwaEV8th77uRrz3DiQs#OYPNWCAyly3hu0" +
		"duFFmAVW4y2gCXy3LfJv06m1xvjDPhlPQZuqcyr6iy6iD#lCUsPj56kDZRawZ7gqXH#YNxu" +
		"iywNvdXlvZodjVzVM3tvRpCeKwu6Zqc$cLtv$0J#3$OPLR$P4bf$InlHrIlj$fHYRk8zvt3" +
		"1y481MESb3ENyQE8SQE8cgiLT7d6$P0xw3W5k#1$oepX1srmIw1EKwk0vRBLmBry0rqPqbO" +
		"ByDRyjv862$zzZnWopmE0i22uzJ8N3WSKRumCk8yFGOH1lXpMbu13#wCpN#1uayDVq=");

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

	static final Action RETURN8 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 8];
		}
	};

	static final Action RETURN4 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 4];
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
					return new Decl(new Var(l), new Type(t));
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
					return new Decl(new Var(l), new Type(t), r);
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
			RETURN2,	// [15] Stmt = READ Lvalue; returns 'Lvalue' although none is marked
			new Action() {	// [16] Stmt = PRINT Exp.e
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e = _symbols[offset + 2];
					final Exp e = (Exp) _symbol_e.value;
					 return new Print(e);
				}
			},
			RETURN2,	// [17] Stmt = RETURN Ret; returns 'Ret' although none is marked
			RETURN3,	// [18] Stmt = Lvalue EQ Exp; returns 'Exp' although none is marked
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
			RETURN8,	// [22] Func = ID.a AP ParamList.b FP COLON Return AC StmtList.c FC; returns 'c' although more are marked
			RETURN3,	// [23] StmtList = Stmt SEMI StmtList; returns 'StmtList' although none is marked
			RETURN2,	// [24] StmtList = Stmt SEMI; returns 'SEMI' although none is marked
			RETURN3,	// [25] Ret = Exp COMMA Ret; returns 'Ret' although none is marked
			Action.RETURN,	// [26] Ret = Exp
			RETURN3,	// [27] Return = TYPE COMMA Return; returns 'Return' although none is marked
			Action.RETURN,	// [28] Return = TYPE
			RETURN3,	// [29] ParamList = Param COMMA ParamList; returns 'ParamList' although none is marked
			Action.RETURN,	// [30] ParamList = Param
			RETURN3,	// [31] Param = ID DBCOLON TYPE; returns 'TYPE' although none is marked
			Action.RETURN,	// [32] Lvalue = ID.l
			RETURN4,	// [33] Lvalue = Lvalue LB Exp RB; returns 'RB' although none is marked
			RETURN3,	// [34] Lvalue = Lvalue DOT ID; returns 'ID' although none is marked
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
			RETURN3,	// [57] Pexp = AP Exp FP; returns 'FP' although none is marked
			RETURN4,	// [58] Pexp = TYPE LB Exp RB; returns 'RB' although none is marked
			new Action() {	// [59] Pexp = ID.l
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 1];
					final String l = (String) _symbol_l.value;
					return new Var(l);
				}
			},
			new Action() {	// [60] lst$Exp = Exp
				public Symbol reduce(Symbol[] _symbols, int offset) {
					ArrayList lst = new ArrayList(); lst.add(_symbols[offset + 1].value); return new Symbol(lst);
				}
			},
			new Action() {	// [61] lst$Exp = lst$Exp Exp
				public Symbol reduce(Symbol[] _symbols, int offset) {
					((ArrayList) _symbols[offset + 1].value).add(_symbols[offset + 2].value); return _symbols[offset + 1];
				}
			},
			Action.RETURN	// [62] Exps = lst$Exp
		};
	}

	protected Symbol invokeReduceAction(int rule_num, int offset) {
		return actions[rule_num].reduce(_symbols, offset);
	}
}
