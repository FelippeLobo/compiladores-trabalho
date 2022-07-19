package src.ast;

/*
 * Esta classe representa um comando de Impressão.
 * Exp
 */ 
import java.util.HashMap;

import src.visitors.Visitor; 

public class Num extends Exp {
      
      private int l;
     
      public  Num(int v){
           this.l = v;
      }
      
      public int getValue(){ return l;}
      
      //@Override
      public String toString(){
         return   "" + l ; 
      }
      
      public void accept(Visitor v){v.visit(this);}
}
