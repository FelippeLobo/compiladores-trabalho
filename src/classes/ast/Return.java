package src.classes.ast;

/*
 * Esta classe representa uma Expessão de soma.
 * Exp + Exp
 */
 
import java.util.HashMap; 
public class Return extends Node  {

      private Exp l;
      public Return(Exp[] l){
           
      }
      
      public String toString(){
        System.out.println(l.toString());  
        
        return l.toString();
      }

      public int interpret(HashMap<String,Integer> m){
        System.Out.Println(this.toString());
        
        System.out.println(l.toString());  
        return 0;
     }
      

      
}