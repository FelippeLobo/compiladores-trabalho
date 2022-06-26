import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap; 
import LangLex.java;
public class TesteSin{
      public static void main(String[] args){
        HashMap<String,Integer> h = new HashMap<String,Integer>();
        try{
            LangLex input = new LangLex(new FileReader(args[0]));
            CmdList result = (CmdList)new LangParser().parse(input);
            System.out.println("Parsado !");
            System.out.println(result.toString());
            
            System.out.println("--------- Executando ---------");
            result.interpret(h);
        }
        catch (IOException e){
            System.err.println("Failed to read expression: " + e.getMessage());
        }
        catch (beaver.Parser.Exception e){
            System.err.println("Invalid expression: " + e.getMessage());
        }
        catch (Exception e){
            System.err.println("Exceção: " + e.getMessage());
        } 
     }
}
