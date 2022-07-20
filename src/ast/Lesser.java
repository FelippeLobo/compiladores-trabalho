package src.ast;

/*
 * Esta classe representa uma comparição de "Menor".
 * Exp < Exp
 */
 
import java.util.HashMap;

import src.visitors.Visitor; 
public class Lesser extends BinOP {

      public Lesser(Exp l, Exp r){
           super(l,r);
      }
      
      public String toString(){
         String s = getLeft().toString();
         String ss = getRight().toString();
        
         return   s + " < " + ss;
      }
      
      public void accept(Visitor v){v.visit(this);}
      
}