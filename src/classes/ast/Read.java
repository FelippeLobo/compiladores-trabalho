package src.classes.ast;

/*
 * Esta classe representa um comando de Impressão.
 * Exp
 */
import java.util.HashMap; 
import java.util.Scanner;
 
public class Read extends Node {
      
      private ID id; 
      
      public Read(String id){
           this.id  = new ID(id);
      }
      
    
      
      //@Override
      public String toString(){
         return   "" + id.toString(); 
      }
      
      public int interpret(HashMap<String,Integer> m){
        System.out.println(this.toString());

        try (Scanner myObj = new Scanner(System.in)) {
          String x;
          x = myObj.nextLine();
          m.put(id.getName(), Integer.parseInt(x));
          return Integer.parseInt(x);
        } catch (NumberFormatException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        return 0;
      }
       
 
}
