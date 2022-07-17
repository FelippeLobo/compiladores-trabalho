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
		"U9pbLtkKZLKK$ttVTpMCHqDco61cl3CpeZ5Z39Lt4pta5ULHGkb592KLUaafeLBAQgdLKgr" +
		"MrgfL2X4LlLIQaCghGj5BBrHEl#$S8$j#ZxbtSlkZvSxwVR#zzzbddtFsUGuGcQeE8HL5Q8" +
		"$MQ8DJK82swa#l1KtH72UX9wRX6boFcp75MCuyOb47VN4KwY3TU9w8J3H05dBG6BaYJeY7s" +
		"kphGpUSWTjH0#VZL4z9$6YRr194y83w7SDG7DghiDfbgWn3q1630teq6psy$L5$gQzn6Ux4" +
		"JDmN6lEhq5xKHXxoqGeden1NO8odJO#k$a0lTK1jPLwEPC7jLvVuMK66QEdQU2tfg2wgULg" +
		"gda1BTKLBD$eY7v$0Ead335#zcaUnlhQ5bcm9BVa2Dubnt0O7Dev3PTzwhAL#KozNT9KbpU" +
		"vTfIMXdftYhTAasRrvgwJpvhMc15ghQEkbmjeBFTK6TEPvD1AduonqnJoCm2KenKEuH$ZTx" +
		"z4Undau1sTZ4ERIyrnSYDxeGyqxV$yt$R7$EBxCVJ$r6VhZ0WndxY$oUSREtPKU$Uho8gkT" +
		"k9WpsbLzhcUr$CWJFFh4EFwJavwJsFXtn$KV8FobF5hjm3Zr9VggNt03ntyBfcDWJCQlKjj" +
		"n7KlknQse9#prXTnGoDb2RYJa9a9k9kGMGcufv7P2xY3axa8UAkHHGhvSoEE5F4d8KqFgtY" +
		"7akuGyIyXpX7mQ7iHSzId6uX6r4VFnA17dfs$q4r3LC63n97VuGd3FfHIUDdvBLTvxrMdDu" +
		"1bNbwTRFMD95PQWE5Ne4VMimNikZNTMBRPOMzGAyqZtHQlF4xKXhOry9V6ZPV4yJcVDRDRC" +
		"3FKAiqTRRXBI8xyT2OqlhAGPRv0Ml4DQykR8zCNsjvL7fCVCZTklTWdqeM8jkL5Tb7XQoZx" +
		"gbd8IM2TEGBtm71vD$iihaUCul0TR#$fLmfnqgF0gIvRTFszXdfbnivGiUt3U$htLqhlOCl" +
		"TB7dTsAbUynJidrYzMA#1vsPGrYvcVzhoL2dakP52Bj$AFTLrcCPr$sNgFkBalpzETEwzUd" +
		"d#6tk5vZ9tio47boSn98l6blvHjZjT5aMPt$3PbwT6O9OrrIPlGACUoR7CdEzp9jZuLSYZd" +
		"g3W$StDd6GOMJ8a#ZNeH#SGmyrHwMhzXWAr44s8x41bAtk4#Tg9rh6oYDr5APG1v1lbneYb" +
		"bijKViEbgFK6UJdwUF8kyb3oFl8Ri#drCNiHwAUJ5v3JoacWRzah3Qrsk25ZdGtw6cBwMKT" +
		"z4OQmetqOxnsFt9GRJK9lOJtatURBn6H4R4mTf6qBq8IOIp9UrYpoQ#15mRF81urj4cV4SX" +
		"wX4VIwv5Na2sIr$YintZDEIg4Lqf$yWSW7B1Z8k#s4TeBwSQ43R2yGwoi#HDv2VvPmC9nSI" +
		"AuYUjBjrtFQOQwjgj1$EQe9#5cDOnMPSx8$p9dNsrnb7lIPv4Z6DXSLapgLDV#SjOZRzsXF" +
		"zA2yZZoAlfz$xv8NKnrEUIlaPocvuvZF2l4IwCKOdyWY2wolIWnWPRJzIQkP5paSrmtKCDn" +
		"9vtn8ynzOOKxxGy4PZDx6SnOPVChpCy2h3QmslCrncUBFXRK7jbWVMsUdHzyRgThuOrulK2" +
		"utVliJYsoPtTcTJRsP07#Pu$Orzlx7jaVsXFTEK7ugD4uaO##7wbKMikiOdrUZvXWj5$JHZ" +
		"woxgpJTb6KP$ad9zOnDp7cbXoYU8kejCMIlXrrR88hTs5pcM8tOiGC1FlQA$#sDiln8yHTG" +
		"717UUuefNxn7l4cyJQmdk4CMTfDvGgzH7wXsrHgrMhwkLQeLwJIrNotISfIRUgz5MZFQD$l" +
		"BqK#lLRlvF#cr0htRv##Zn#4vz7pGIeV$yZxHF$SGlpodr0x5Ns$O4PIFufpxHiKlvnhVuE" +
		"hK9XpWiHxarx$uIZKgyKHp2vHJ35c5hjD6lMDleZdx5jjDo2j#zrVX6TGXRlrcBMRUOzYXR" +
		"X6tWQ7iHkOXszpviIouW5#XNiQFVp7diJnxbPfIRauDXyMPr32pUiOw0nHlN9gn0vD8dbst" +
		"aKdPVS1t$1cS0gJi=");

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

	static final Action RETURN4 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 4];
		}
	};

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

	static final Action RETURN12 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 12];
		}
	};

	private final Action[] actions;

	public MiniLangParser() {
		super(PARSING_TABLES);
		actions = new Action[] {
			Action.RETURN,	// [0] $goal = Prog
			RETURN2,	// [1] Prog = Stmt SEMI; returns 'SEMI' although none is marked
			RETURN3,	// [2] Prog = Stmt SEMI Prog; returns 'Prog' although none is marked
			Action.RETURN,	// [3] Prog = Func
			RETURN2,	// [4] Prog = Func Prog; returns 'Prog' although none is marked
			Action.RETURN,	// [5] Prog = Data
			RETURN2,	// [6] Prog = Data Prog; returns 'Prog' although none is marked
			RETURN4,	// [7] Data = ID AC Decl FC; returns 'FC' although none is marked
			RETURN4,	// [8] Decl = ID DBCOLON TYPE SEMI; returns 'SEMI' although none is marked
			RETURN5,	// [9] Decl = ID DBCOLON TYPE SEMI Decl; returns 'Decl' although none is marked
			RETURN3,	// [10] Stmt = ID EQ Exp; returns 'Exp' although none is marked
			RETURN5,	// [11] Stmt = IF AP Exp FP Stmt; returns 'Stmt' although none is marked
			RETURN7,	// [12] Stmt = IF AP Exp FP Stmt ELSE Stmt; returns 'Stmt' although none is marked
			RETURN5,	// [13] Stmt = ITERATE AP Exp FP Stmt; returns 'Stmt' although none is marked
			Action.RETURN,	// [14] Stmt = Exp
			RETURN2,	// [15] Stmt = READ Lvalue; returns 'Lvalue' although none is marked
			RETURN2,	// [16] Stmt = PRINT Exp; returns 'Exp' although none is marked
			new Action() {	// [17] lst$Exp = Exp
				public Symbol reduce(Symbol[] _symbols, int offset) {
					ArrayList lst = new ArrayList(); lst.add(_symbols[offset + 1].value); return new Symbol(lst);
				}
			},
			new Action() {	// [18] lst$Exp = lst$Exp Exp
				public Symbol reduce(Symbol[] _symbols, int offset) {
					((ArrayList) _symbols[offset + 1].value).add(_symbols[offset + 2].value); return _symbols[offset + 1];
				}
			},
			RETURN2,	// [19] Stmt = RETURN lst$Exp; returns 'lst$Exp' although none is marked
			RETURN3,	// [20] Stmt = Lvalue EQ Exp; returns 'Exp' although none is marked
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
			RETURN7,	// [23] Stmt = ID AP Exps FP LESSER lst$Lvalue GREATER; returns 'GREATER' although none is marked
			RETURN12,	// [24] Func = ID AP ParamList FP COLON Return AC FuncStmtList RETURN Ret SEMI FC; returns 'FC' although none is marked
			RETURN3,	// [25] FuncStmtList = FuncStmt SEMI FuncStmtList; returns 'FuncStmtList' although none is marked
			RETURN2,	// [26] FuncStmtList = FuncStmt SEMI; returns 'SEMI' although none is marked
			RETURN3,	// [27] FuncStmt = ID EQ Exp; returns 'Exp' although none is marked
			RETURN5,	// [28] FuncStmt = IF AP Exp FP Stmt; returns 'Stmt' although none is marked
			RETURN7,	// [29] FuncStmt = IF AP Exp FP Stmt ELSE Stmt; returns 'Stmt' although none is marked
			RETURN5,	// [30] FuncStmt = ITERATE AP Exp FP Stmt; returns 'Stmt' although none is marked
			Action.RETURN,	// [31] FuncStmt = Exp
			RETURN2,	// [32] FuncStmt = READ Lvalue; returns 'Lvalue' although none is marked
			RETURN2,	// [33] FuncStmt = PRINT Exp; returns 'Exp' although none is marked
			RETURN3,	// [34] FuncStmt = Lvalue EQ Exp; returns 'Exp' although none is marked
			RETURN7,	// [35] FuncStmt = ID AP Exps FP LESSER lst$Lvalue GREATER; returns 'GREATER' although none is marked
			RETURN3,	// [36] Ret = Exp COMMA Ret; returns 'Ret' although none is marked
			Action.RETURN,	// [37] Ret = Exp
			RETURN3,	// [38] Return = TYPE COMMA Return; returns 'Return' although none is marked
			Action.RETURN,	// [39] Return = TYPE
			RETURN3,	// [40] ParamList = Param COMMA ParamList; returns 'ParamList' although none is marked
			Action.RETURN,	// [41] ParamList = Param
			RETURN3,	// [42] Param = ID DBCOLON TYPE; returns 'TYPE' although none is marked
			Action.RETURN,	// [43] Lvalue = ID
			RETURN4,	// [44] Lvalue = Lvalue LB Exp RB; returns 'RB' although none is marked
			RETURN3,	// [45] Lvalue = Lvalue DOT ID; returns 'ID' although none is marked
			Action.RETURN,	// [46] Exp = Rexp
			RETURN3,	// [47] Rexp = Exp GREATER Exp; returns 'Exp' although none is marked
			RETURN3,	// [48] Rexp = Exp LESSER Exp; returns 'Exp' although none is marked
			RETURN3,	// [49] Rexp = Exp GREATEREQUAL Exp; returns 'Exp' although none is marked
			RETURN3,	// [50] Rexp = Exp LESSEREQUAL Exp; returns 'Exp' although none is marked
			RETURN3,	// [51] Rexp = Exp EQUALTO Exp; returns 'Exp' although none is marked
			RETURN3,	// [52] Rexp = Exp DIF Exp; returns 'Exp' although none is marked
			Action.RETURN,	// [53] Rexp = Aexp
			RETURN3,	// [54] Aexp = Exp PLUS Exp; returns 'Exp' although none is marked
			RETURN3,	// [55] Aexp = Exp SUB Exp; returns 'Exp' although none is marked
			Action.RETURN,	// [56] Aexp = Mexp
			RETURN3,	// [57] Mexp = Exp MULT Exp; returns 'Exp' although none is marked
			RETURN3,	// [58] Mexp = Exp DIV Exp; returns 'Exp' although none is marked
			RETURN3,	// [59] Mexp = Exp RES Exp; returns 'Exp' although none is marked
			Action.RETURN,	// [60] Mexp = Sexp
			RETURN2,	// [61] Sexp = Exp NOT; returns 'NOT' although none is marked
			Action.RETURN,	// [62] Sexp = BOOL
			Action.RETURN,	// [63] Sexp = NULL
			Action.RETURN,	// [64] Sexp = INT
			Action.RETURN,	// [65] Sexp = FLOAT
			Action.RETURN,	// [66] Sexp = CHAR
			Action.RETURN,	// [67] Sexp = Pexp
			RETURN3,	// [68] Pexp = AP Exp FP; returns 'FP' although none is marked
			RETURN4,	// [69] Pexp = TYPE LB Exp RB; returns 'RB' although none is marked
			Action.RETURN,	// [70] Pexp = ID
			Action.RETURN	// [71] Exps = lst$Exp
		};
	}

	protected Symbol invokeReduceAction(int rule_num, int offset) {
		return actions[rule_num].reduce(_symbols, offset);
	}
}
