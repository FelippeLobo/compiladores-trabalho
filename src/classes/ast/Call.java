package src.classes.ast;

/*
 * Esta classe representa uma Expessão de soma.
 * Exp + Exp
 */
 
import java.util.HashMap;

import src.classes.beaver.Symbol; 
public class Call extends Node  {


      public Call(String v, Exp i){
           
      }

      public Call(String v, String i){
           
    }

    public Call(String v, Symbol e, String[] x){
           
    }
      
      public Call(String x, Exp[] e, String[] v) {
    }

    public Call(String a, Exp[] b, Exp c) {
    }

   

    public int interpret(HashMap<String,Integer> m){
       System.out.println(this.toString());

        return 0;
     }
    
      
}