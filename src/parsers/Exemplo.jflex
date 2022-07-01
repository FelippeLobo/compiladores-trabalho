
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
  char = [:lowercase:] | [:uppercase:]
  boolean = "true" | "false"
  identificador = [:lowercase:] ( [:letter:] | [:digit:] | "_" )*
  Literal = "'" (.)  "'" | "'" "\\n" "'" | "'" "\\r" "'" | "'" "\\t" "'" | "'" "\\b" "'" | "'" "\\\\" "'"
  LineComment = "//" (.)* {FimDeLinha}

%state COMMENT

%%

<YYINITIAL>{
    {identificador} { return newToken(Terminals.ID, yytext());   }
    "="             { return newToken(Terminals.EQ);   }
    ";"             { return newToken(Terminals.SEMI); }
    ":"             { return newToken(Terminals.COLON);}
    "?"             { return newToken(Terminals.IF);   }
    "("             { return newToken(Terminals.AP);   }
    ")"             { return newToken(Terminals.FP);   }
    "["             { return newToken(Terminals.LB);   }
    "]"             { return newToken(Terminals.RB);   }
    "*"             { return newToken(Terminals.MULT); }
    "/"             { return newToken(Terminals.DIV);  }
    "%"             { return newToken(Terminals.DIV);  }
    "+"             { return newToken(Terminals.PLUS); }
    "-"             { return newToken(Terminals.SUB); }
    ">"             { return newToken(Terminals.GREATER); }
    {Brancos}       { /* Não faz nada  */             }
    "null"          { return newToken(Terminals.NULL, null);}
    {type}          { return newToken(Terminals.TYPE, yytext()); }
    {boolean}       { return newToken(Terminals.BOOL, Boolean.parseBoolean(yytext()));}
    {identificador} { return newToken(Terminals.ID);   }
    {inteiro}       { return newToken(Terminals.INT, Integer.parseInt(yytext()) );  }
    {float}         { return newToken(Terminals.FLOAT, Float.parseFloat(yytext()) );  }
    "/*"            { yybegin(COMMENT);               }
    {LineComment}   {                       }

}

<COMMENT>{
   "*/"     { yybegin(YYINITIAL); } 
   [^"*/"]* {                     }
}

[^]                 { throw new RuntimeException("Illegal character <"+yytext()+">"); }



