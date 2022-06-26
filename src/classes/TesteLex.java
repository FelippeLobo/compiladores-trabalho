/*
    Felippe Rocha Lôbo de Abreu - 201765185AC 
    Nathan Toschi Reis - 201865064C 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileReader;
import java.io.IOException;

public class TesteLex {

    public static void main(String args[]) throws IOException {
        {
            LextTest lx;
            lx = new LextTest(new FileReader(args[0]));
            Token t = lx.nextToken();
            while (t != null) {
                System.out.println(t.toString());
                t = lx.nextToken();
            }
            System.out.println("Total de tokens lidos " + lx.readedTokens());
        }
    }

}
