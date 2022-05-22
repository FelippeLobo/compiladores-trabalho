/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladores.trabalho.analisadorlexico;

/**
 *
 * @author felip
 */
public class Token {
    public int l, c;
    public TOKEN_TYPE t;
    public String lexeme;
    public Object info;
    
    public Token(TOKEN_TYPE t, String lex, Object o, int l, int c){
        this.t = t;
        lexeme = lex;
        info = o;
        this.l = l;
        this.c = c;
                
    }
    
    public Token(TOKEN_TYPE t, String lex, int l, int c){
        this.t = t;
        lexeme = lex;
        info = null;
        this.l = l;
        this.c = c;
        
    }
    
    public Token(TOKEN_TYPE t, Object o, int l, int c){
        this.t = t;
        lexeme = "";
        info = o;
        this.l = l;
        this.c = c;
        
    }
    
    @Override
    public String toString(){
        return "[("+l+","+ c+ ") \"" + lexeme + "\" : <" + (info == null ? "" : info.toString()) + ">]";
    }
}
