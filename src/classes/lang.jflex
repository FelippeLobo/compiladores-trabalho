
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
    "data"          { return new Symbol(Terminals.DATA);}
    "print"         { return new Symbol(Terminals.PRINT);}
    "read"          { return new Symbol(Terminals.READ);}
    "if"            { return new Symbol(Terminals.IF);}
    "elseif"        { return new Symbol(Terminals.ELSEIF);}
    "else"          { return new Symbol(Terminals.ELSE);}
    "return"        { return new Symbol(Terminals.RETURN);}
    "new"           { return new Symbol(Terminals.NEW);}
    "iterate"       { return new Symbol(Terminals.ITERATE);}
    "["             { return new Symbol(Terminals.LBRACK);}
    "]"             { return new Symbol(Terminals.RBRACK);}
    "("             { return new Symbol(Terminals.LPAREN);}
    ")"             { return new Symbol(Terminals.RPAREN);}
    "{"             { return new Symbol(Terminals.LBRACE);}
    "}"             { return new Symbol(Terminals.RBRACE);}
    "."             { return new Symbol(Terminals.DOT);}
    "+"             { return new Symbol(Terminals.ADD);}
    "-"             { return new Symbol(Terminals.SUB);}
    "*"             { return new Symbol(Terminals.MULT);}
    "/"             { return new Symbol(Terminals.DIV);}
    "%"             { return new Symbol(Terminals.RES);}
    "="             { return new Symbol(Terminals.EQUAL);}
    "=="            { return new Symbol(Terminals.EQUALTO);}
    "!="            { return new Symbol(Terminals.DIF);}
    "!"             { return new Symbol(Terminals.NOT);}
    "-"             { return new Symbol(Terminals.TRA);}
    ">"             { return new Symbol(Terminals.GREATER);}
    "<"             { return new Symbol(Terminals.LESSER);}
    ">="            { return new Symbol(Terminals.GREATEREQUAL);}
    "<="            { return new Symbol(Terminals.LESSEREQUAL);}
    "&&"            { return new Symbol(Terminals.AND);}
    "||"            { return new Symbol(Terminals.OR);}
    ":"             { return new Symbol(Terminals.COLON);}
    "::"            { return new Symbol(Terminals.DOUBLECOLON);}
    ";"             { return new Symbol(Terminals.SEMICOLON);}
    "null"          { return new Symbol(Terminals.NULL, null);}
    {type}          { return new Symbol(Terminals.TYPE, yytext()); }
    {boolean}       { return new Symbol(Terminals.BOOL, Boolean.parseBoolean(yytext()));}
    {identificador} { return new Symbol(Terminals.ID);   }
    {inteiro}       { return new Symbol(Terminals.INT, Integer.parseInt(yytext()) );  }
    {float}         { return new Symbol(Terminals.FLOAT, Float.parseFloat(yytext()) );  }
    "/*"            { yybegin(COMMENT);               }
    {Brancos}       { /* Não faz nada  */             }
    {LineComment}   {                       }
}

<COMMENT>{
   "*/"     { yybegin(YYINITIAL); } 
   [^"*/"]* {                     }
}



[^]                 { throw new RuntimeException("Illegal character <"+yytext()+">"); }

