//Nathan Toschi Reis / 201865064C
//Felippe Rocha Lobo de Abreu / 201765185AC

package src;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import src.ast.Prog;
import src.beaver.*;
import src.parsers.MiniLangLex;
import src.parsers.MiniLangParser;
import src.visitors.FunctionsVisitor;

public class Teste{
      public static void main(String[] args){
        HashMap<String,Integer> h = new HashMap<String,Integer>();
        try{
            MiniLangLex input = new MiniLangLex(new FileReader(args[0]));
            Prog result = (Prog)new MiniLangParser().parse(input);
            System.out.println("Parsado !");
            FunctionsVisitor v = new FunctionsVisitor();
            result.accept(v);
            //System.out.println(result.toString());
           
            //System.out.println("--------- Executando ---------");
            //result.interpret(h);
        }
        catch (IOException e){
            System.err.println("Failed to read expression: " + e.getMessage());
        }
        catch (src.beaver.Parser.Exception e){
            System.err.println("Invalid expression: " + e.getMessage());
        }
        catch (Exception e){
            System.err.println("Exceção: " + e.getMessage());
        } 
     }
}
