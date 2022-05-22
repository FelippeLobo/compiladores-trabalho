/*
    Felippe Rocha Lôbo de Abreu - 201765185AC 
    Nathan Toschi Reis - 201865064C 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author felip
 */
public class Token {
    public int l, c;
    public TOKEN_TYPE t;
    public String lexeme;
    public Object info;

    public Token(TOKEN_TYPE t, String lex, Object o, int l, int c) {
        this.t = t;
        lexeme = lex;
        info = o;
        this.l = l;
        this.c = c;

    }

    public Token(TOKEN_TYPE t, String lex, int l, int c) {
        this.t = t;
        lexeme = lex;
        info = null;
        this.l = l;
        this.c = c;

    }

    public Token(TOKEN_TYPE t, Object o, int l, int c) {
        this.t = t;
        lexeme = "";
        info = o;
        this.l = l;
        this.c = c;

    }

    @Override
    public String toString() {
        return this.t + (((this.lexeme == "") || (this.lexeme == null)) ? "" : ":" + this.lexeme)
                + (((this.info == "") || (this.info == null)) ? "" : ":" + this.info.toString());
    }
}
