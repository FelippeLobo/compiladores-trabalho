package src.ast;

/*
 * Esta classe representa uma comparição de "Maior".
 * Exp > Exp
 */
 
import java.util.HashMap;

import src.visitors.Visitor; 
public class Greater extends BinOP {

      public Greater(Exp l, Exp r){
           super(l,r);
      }
      
      public String toString(){
         String s = getLeft().toString();
         String ss = getRight().toString();
        
         return   s + " > " + ss;
      }
      
      public void accept(Visitor v){v.visit(this);}
      
}