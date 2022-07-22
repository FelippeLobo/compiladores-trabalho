
//Nathan Toschi Reis / 201865064C
//Felippe Rocha Lobo de Abreu / 201765185AC

 /*  Esta seção é copiada antes da declaração da classe do analisador léxico.
  *  É nesta seção que se deve incluir imports e declaração de pacotes.
  *  Neste exemplo não temos nada a incluir nesta seção.
  */
  
package src.parsers;

import src.beaver.Symbol;
import src.beaver.Scanner;
import java.math.BigDecimal;

%%
%public
%class MiniLangLex
%extends Scanner
%function nextToken
%type Symbol
%yylexthrow Scanner.Exception
%eofval{
	return newToken(Terminals.EOF, "end-of-file");
%eofval}
%unicode
%line
%column
%{
	private Symbol newToken(short id)
	{
		return new Symbol(id, yyline + 1, yycolumn + 1, yylength());
	}

	private Symbol newToken(short id, Object value)
	{
		return new Symbol(id, yyline + 1, yycolumn + 1, yylength(), value);
	}
%}
LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]
  
  /* Agora vamos definir algumas macros */
  FimDeLinha  = \r|\n|\r\n
  Brancos     = {FimDeLinha} | [ \t\f]
  type = [:uppercase:] ( [:letter:] | [:digit:] | "_" )*
  float      = [:digit:]*[.] [:digit:]*
  inteiro = [:digit:] [:digit:]*
  char = "'" [:lowercase:] "'" | "'" [:uppercase:] "'" 
  boolean = "true" | "false"
  identificador = [:lowercase:] ([:lowercase:] | [:uppercase:] | [:digit:] | "_")*
  Literal = "'" (.)  "'" | "'" "\\n" "'" | "'" "\\r" "'" | "'" "\\t" "'" | "'" "\\b" "'" | "'" "\\\\" "'"
  LineComment = "//" (.)* {FimDeLinha}

%state COMMENT

%%

<YYINITIAL>{
    "print"         { return newToken(Terminals.PRINT);}
    "read"          { return newToken(Terminals.READ);}
    "return"        { return newToken(Terminals.RETURN);}
    "if"            { return newToken(Terminals.IF);}
    "else"          { return newToken(Terminals.ELSE);}
    "new"           { return newToken(Terminals.NEW);}
    "null"          { return newToken(Terminals.NULL, null);}
    "iterate"       { return newToken(Terminals.ITERATE);}
    "data"          { return newToken(Terminals.DATA);}
    "="             { return newToken(Terminals.EQ);   }
    ";"             { return newToken(Terminals.SEMI); }
    "("             { return newToken(Terminals.AP);   }
    ")"             { return newToken(Terminals.FP);   }
    "["             { return newToken(Terminals.LB);   }
    "]"             { return newToken(Terminals.RB);   }
    "{"             { return newToken(Terminals.AC);   }
    "}"             { return newToken(Terminals.FC);   }
    "*"             { return newToken(Terminals.MULT); }
    "/"             { return newToken(Terminals.DIV);  }
    "%"             { return newToken(Terminals.MOD);  }
    "+"             { return newToken(Terminals.PLUS); }
    "-"             { return newToken(Terminals.SUB); }
    ">"             { return newToken(Terminals.GREATER); }
    "<"             { return newToken(Terminals.LESSER);}
    ">="            { return newToken(Terminals.GREATEREQUAL);}
    "<="            { return newToken(Terminals.LESSEREQUAL);}
    "=="            { return newToken(Terminals.EQUALTO);}
    "!="            { return newToken(Terminals.DIF);}
    "&&"            { return newToken(Terminals.AND);}
    "!"             { return newToken(Terminals.NOT);}
    "."             { return newToken(Terminals.DOT);}
    "::"            { return newToken(Terminals.DBCOLON);}
    ":"             { return newToken(Terminals.COLON);}
    ","             { return newToken(Terminals.COMMA);}
    {Brancos}       { /* Não faz nada  */             }
    {type}          { return newToken(Terminals.TYPE, yytext()); }
    {boolean}       { return newToken(Terminals.BOOL, Boolean.parseBoolean(yytext()));}
    {identificador} { return newToken(Terminals.ID, yytext());   }
    {inteiro}       { return newToken(Terminals.INT, Integer.parseInt(yytext()) );  }
    {float}         { return newToken(Terminals.FLOAT, Float.parseFloat(yytext()) );  }
    {char}          { return newToken(Terminals.CHAR, yytext().charAt(1)); }
    "/*"            { yybegin(COMMENT);               }
    {LineComment}   {                       }

}

<COMMENT>{
   "*/"     { yybegin(YYINITIAL); } 
   [^"*/"]* {                     }
}

[^]                 { throw new RuntimeException("Illegal character <"+yytext()+">"); }



