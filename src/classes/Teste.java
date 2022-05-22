/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladores.trabalho.analisadorlexico;

import java.io.FileReader;
import java.io.IOException;

public class Teste {

    public static void main(String args[]) throws IOException {
        {
            LextTest lx;
            lx = new LextTest(new FileReader("C:\\Users\\felip\\Documents\\NetBeansProjects\\analisadorLexico\\src\\main\\java\\compiladores\\trabalho\\analisadorlexico\\testeLexico.txt"));
            Token t = lx.nextToken();
            while (t != null) {
                System.out.println(t.toString());
                t = lx.nextToken();
            }
            System.out.println("Total de tokens lidos " + lx.readedTokens());
        }
    }

}
