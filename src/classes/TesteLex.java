/*
    Felippe Rocha Lôbo de Abreu - 201765185AC 
    Nathan Toschi Reis - 201865064C 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package src.classes;

import java.io.FileReader;
import java.io.IOException;
import src.classes.parsers.*;
import src.classes.beaver.*;
import src.classes.beaver.Scanner.Exception;

public class TesteLex {

    public static void main(String args[]) throws IOException, Exception {
        {
            LangLex lx;
            lx = new LangLex(new FileReader(args[0]));
          
            while (lx.nextToken() != null) {
                System.out.println(lx.yytext());
                lx.nextToken();
            }
            System.out.println("Total de tokens lidos " + lx.readedTokens());
        }
    }

}
