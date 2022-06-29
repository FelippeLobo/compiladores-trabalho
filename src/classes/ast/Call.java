package src.classes.ast;

/*
 * Esta classe representa uma Expessão de soma.
 * Exp + Exp
 */
 
import java.util.HashMap; 
public class Call extends Node  {


      public Call(String v, Exp i){
           
      }

      public Call(String v, String i){
           
    }
      
      public int interpret(HashMap<String,Integer> m){
       System.Out.Println(this.toString());

        return 0;
     }
    
      
}