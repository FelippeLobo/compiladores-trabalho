package src.classes.ast;

/*
 * Esta classe representa um comando de Impressão.
 * Exp
 */
import java.util.HashMap; 
 
public class Print extends Node {
      
      private Exp e; 
      
      public Print( Exp e){
           this.e  = e;
      }
      
      public Exp getExp(){ return e;}
      
      //@Override
      public String toString(){
         return   "" + e.toString(); 
      }
      
      public int interpret(HashMap<String,Integer> m){
        System.Out.Println(this.toString());

          int n = e.interpret(m);
          System.out.println("" + n);
          return n;
      }
}
