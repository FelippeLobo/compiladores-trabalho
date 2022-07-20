package src.ast;

/*
 * Esta classe representa uma Expessão de subtração.
 * Exp - Exp
 */
 
import java.util.HashMap;

import src.visitors.Visitor; 
public class Sub extends BinOP {

      public Sub(Exp l, Exp r){
           super(l,r);
      }
      
      public String toString(){
         String s = getLeft().toString();
         String ss = getRight().toString();
        
         return   s + " - " + ss;
      }
      
      public void accept(Visitor v){v.visit(this);}
      
}