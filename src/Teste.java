package src;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import src.ast.Node;
import src.ast.StmtList;
import src.parsers.*;

public class Teste {

    public static void main(String[] args) throws IOException, src.beaver.Parser.Exception {
        HashMap<String, Integer> h = new HashMap<String, Integer>();
        try {

            StmtList result = (StmtList) (new ParseBuild()).parseFile(args[0]);

            if (result != null) {
                System.out.println("Parsado !");

                System.out.println(result.toString());

                System.out.println("--------- Executando ---------");

                result.interpret(h);
            }

            System.out.println("--------- Result NULL ---------");

          
        } catch (Exception e) {
            System.err.println("Excecao: " + e.getMessage());
        }
    }

}
