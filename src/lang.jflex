
 /*  Esta seção é copiada antes da declaração da classe do analisador léxico.
  *  É nesta seção que se deve incluir imports e declaração de pacotes.
  *  Neste exemplo não temos nada a incluir nesta seção.
  */
  
%%

%unicode
%line
%column
%class LextTest
%function nextToken
%type Token

%{
    
    /* Código arbitrário pode ser inserido diretamente no analisador dessa forma. 
     * Aqui podemos declarar variáveis e métodos adicionais que julgarmos necessários. 
     */
    private int ntk;
    
    public int readedTokens(){
       return ntk;
    }
    private Token symbol(TOKEN_TYPE t) {
        ntk++;
        return new Token(t,yytext(), yyline+1, yycolumn+1);
        
    }
    private Token symbol(TOKEN_TYPE t, Object value) {
        ntk++;
        return new Token(t, value, yyline+1, yycolumn+1);
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
    "print"         { return symbol(TOKEN_TYPE.PRINT);}
    "read"          { return symbol(TOKEN_TYPE.READ);}
    "if"            { return symbol(TOKEN_TYPE.IF);}
    "elseif"        { return symbol(TOKEN_TYPE.ELSEIF);}
    "else"          { return symbol(TOKEN_TYPE.ELSE);}
    "return"        { return symbol(TOKEN_TYPE.RETURN);}
    "new"           { return symbol(TOKEN_TYPE.NEW);}
    "iterate"       { return symbol(TOKEN_TYPE.ITERATE); }
    "["             { return symbol(TOKEN_TYPE.RBRACK)}
    "]"             { return symbol(TOKEN_TYPE.RBRACK)}
    "("             { return symbol(TOKEN_TYPE.LPAREN)}
    ")"             { return symbol(TOKEN_TYPE.RPAREN)}
    "{"             { return symbol(TOKEN_TYPE.LBRACE)}
    "}"             { return symbol(TOKEN_TYPE.RBRACE)}
    "+"             { return symbol(TOKEN_TYPE.ADD)}
    "-"             { return symbol(TOKEN_TYPE.SUB)}
    "*"             { return symbol(TOKEN_TYPE.MULT)}
    "/"             { return symbol(TOKEN_TYPE.DIV)}
    "%"             { return symbol(TOKEN_TYPE.RES)}
    "="             { return symbol(TOKEN_TYPE.EQUAL)}
    "=="            { return symbol(TOKEN_TYPE.EQUALTO)}
    "!="            { return symbol(TOKEN_TYPE.DIF)}
    "!"             { return symbol(TOKEN_TYPE.NOT)}
    ">"             { return symbol(TOKEN_TYPE.GREATER)}
    "<"             { return symbol(TOKEN_TYPE.LESSER)}
    ">="            { return symbol(TOKEN_TYPE.GREATEREQUAL)}
    "<="            { return symbol(TOKEN_TYPE.LESSEREQUAL)}
    "&&"            { return symbol(TOKEN_TYPE.AND)}
    "||"            { return symbol(TOKEN_TYPE.OR)}
    ":"             { return symbol(TOKEN_TYPE.COLON)}
    "::"            { return symbol(TOKEN_TYPE.DOUBLECOLON)}
    ";"             { return symbol(TOKEN_TYPE.SEMICOLON)}
    {nulo}          { return symbol(TOKEN_TYPE.NULL, null);}
    {type}          { return symbol(TOKEN_TYPE.TYPE, yytext()); }
    {boolean}       { return symbol(TOKEN_TYPE.BOOL, Boolean.parseBoolean(yytext()));}
    {identificador} { return symbol(TOKEN_TYPE.ID);   }
    {inteiro}       { return symbol(TOKEN_TYPE.INT, Integer.parseInt(yytext()) );  }
    {float}         { return symbol(TOKEN_TYPE.FLOAT, Float.parseFloat(yytext()) );  }
    {defOp}         { return symbol(TOKEN_TYPE.DEFOP);  }
    {op}            { return symbol(TOKEN_TYPE.OP, yytext()); }    
    {sep}           {return symbol(TOKEN_TYPE.SEP, yytext());}
    "/*"            { yybegin(COMMENT);               }
    {Brancos}       { /* Não faz nada  */             }
    {LineComment}   {                       }
}

<COMMENT>{
   "*/"     { yybegin(YYINITIAL); } 
   [^"*/"]* {                     }
}



[^]                 { throw new RuntimeException("Illegal character <"+yytext()+">"); }

