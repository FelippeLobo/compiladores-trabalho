
package src.classes.ast;

 
import java.util.HashMap; 
public class Iterate extends Node {
      
      private Exp teste;
      private Node cmd;

      
      public Iterate(Exp teste, Node cmd){
           this.teste = teste;
           this.cmd = cmd;

      }
      
        
      public String toString(){
         String s = teste.toString();
         String sthn =  cmd.toString();
         String iterate = "iterate ";
         iterate += " ( " + s + " ) " + sthn;
         return  iterate.replace('\n', '\0'); 
      }
      
      public int interpret(HashMap<String,Integer> m){
          int n =  teste.interpret(m);
          if(n > 0){
             for (int i = 0; i < n; i++) {
                System.out.println(cmd.toString());   
             }

             return 1;
          }
          return 0;
      }
      
}
