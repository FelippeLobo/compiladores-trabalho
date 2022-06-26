
 /*  Esta seção é copiada antes da declaração da classe do analisador léxico.
  *  É nesta seção que se deve incluir imports e declaração de pacotes.
  *  Neste exemplo não temos nada a incluir nesta seção.
  */

import beaver.Symbol;
import beaver.Scanner;

  
%%

%unicode
%line
%column
%public
%class LangLex
%extends Scanner
%function nextToken
%type Symbol
%yylexthrow Scanner.Exception
%eofval{
return newToken(Terminals.EOF, "end−of−file") ;
%eofval}

%{
    
    /* Código arbitrário pode ser inserido diretamente no analisador dessa forma. 
     * Aqui podemos declarar variáveis e métodos adicionais que julgarmos necessários. 
     */
    private int ntk;
    
    public int readedTokens(){
       return ntk;
    }

    private Symbol newToken(short id) {
        return new Symbol(id, yyline+1, yycolumn+1, yylength() ) ;
    }

    private Symbol newToken(short id, Object value) {
        return new Symbol(id, yyline+1, yycolumn+1, yylength() , value) ;
    }
%}

%init{
    ntk = 0; // Isto é copiado direto no construtor do lexer. 
%init}

  
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
    "data"          { return symbol(Terminals.DATA);}
    "print"         { return symbol(Terminals.PRINT);}
    "read"          { return symbol(Terminals.READ);}
    "if"            { return symbol(Terminals.IF);}
    "elseif"        { return symbol(Terminals.ELSEIF);}
    "else"          { return symbol(Terminals.ELSE);}
    "return"        { return symbol(Terminals.RETURN);}
    "new"           { return symbol(Terminals.NEW);}
    "iterate"       { return symbol(Terminals.ITERATE);}
    "["             { return symbol(Terminals.RBRACK)}
    "]"             { return symbol(Terminals.RBRACK)}
    "("             { return symbol(Terminals.LPAREN)}
    ")"             { return symbol(Terminals.RPAREN)}
    "{"             { return symbol(Terminals.LBRACE)}
    "}"             { return symbol(Terminals.RBRACE)}
    "+"             { return symbol(Terminals.ADD)}
    "-"             { return symbol(Terminals.SUB)}
    "*"             { return symbol(Terminals.MULT)}
    "/"             { return symbol(Terminals.DIV)}
    "%"             { return symbol(Terminals.RES)}
    "="             { return symbol(Terminals.EQUAL)}
    "=="            { return symbol(Terminals.EQUALTO)}
    "!="            { return symbol(Terminals.DIF)}
    "!"             { return symbol(Terminals.NOT)}
    "-"             { return symbol(Terminals.TRA)}
    ">"             { return symbol(Terminals.GREATER)}
    "<"             { return symbol(Terminals.LESSER)}
    ">="            { return symbol(Terminals.GREATEREQUAL)}
    "<="            { return symbol(Terminals.LESSEREQUAL)}
    "&&"            { return symbol(Terminals.AND)}
    "||"            { return symbol(Terminals.OR)}
    ":"             { return symbol(Terminals.COLON)}
    "::"            { return symbol(Terminals.DOUBLECOLON)}
    ";"             { return symbol(Terminals.SEMICOLON)}
    {nulo}          { return symbol(Terminals.NULL, null);}
    {type}          { return symbol(Terminals.TYPE, yytext()); }
    {boolean}       { return symbol(Terminals.BOOL, Boolean.parseBoolean(yytext()));}
    {identificador} { return symbol(Terminals.ID);   }
    {inteiro}       { return symbol(Terminals.INT, Integer.parseInt(yytext()) );  }
    {float}         { return symbol(Terminals.FLOAT, Float.parseFloat(yytext()) );  }
    {sep}           {return symbol(Terminals.SEP, yytext());}
    "/*"            { yybegin(COMMENT);               }
    {Brancos}       { /* Não faz nada  */             }
    {LineComment}   {                       }
}

<COMMENT>{
   "*/"     { yybegin(YYINITIAL); } 
   [^"*/"]* {                     }
}



[^]                 { throw new RuntimeException("Illegal character <"+yytext()+">"); }

