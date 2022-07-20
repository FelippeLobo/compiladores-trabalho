package src.ast;

/*
 * Esta classe representa uma comparição de "Menor ou igual".
 * Exp <= Exp
 */
 
import java.util.HashMap;

import src.visitors.Visitor; 
public class LesserEqual extends BinOP {

      public LesserEqual(Exp l, Exp r){
           super(l,r);
      }
      
      public String toString(){
         String s = getLeft().toString();
         String ss = getRight().toString();
        
         return   s + " <= " + ss;
      }
      
      public void accept(Visitor v){v.visit(this);}
      
}