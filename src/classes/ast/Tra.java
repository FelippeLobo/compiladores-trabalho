
package src.classes.ast;

/*
 * Esta classe representa uma Expessão de soma.
 * Exp + Exp
 */
 
import java.util.HashMap; 
public class Tra extends Node {

    private Exp l;
      public Tra(Exp l){
           this.l = l;
      }
      
      
      public int interpret(HashMap<String,Integer> m){
        if(l.interpret(m) == 1){
           return 0;
        }
         return 1;
     }
      
}