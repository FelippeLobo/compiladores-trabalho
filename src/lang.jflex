
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
  type = [:uppercase:] [:uppercase:]*
  float      = [:digit:] [:digit:]* "." [:digit:] [:digit:]*
  inteiro = [:digit:] [:digit:]*
  char = [:lowercase:] | [:uppercase:]
  boolean = true | false
  op = "="| "+"| "*" | "/" | "-"| "%"| "<"| ">"| "=="| "!="| "&&"| "||"| "!"
  defOp = "::" | ":"
  sep = ";"| "("| ")"| "["| "]"| "{"| "}"| "."| ","
  identificador = {char} {char}*
  LineComment = "//" (.)* {FimDeLinha}
  nulo = NULL
  
  
%state COMMENT

%%

<YYINITIAL>{
    "print"         { return symbol(TOKEN_TYPE.PRINT);}
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

