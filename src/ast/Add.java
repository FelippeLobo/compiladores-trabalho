package src.ast;

/*
 * Esta classe representa uma Expessão de soma.
 * Exp + Exp
 */
 
import java.util.HashMap;

import src.visitors.Visitor; 
public class Add extends BinOP {

      private int x;

      public Add(Exp l, Exp r, int x){
           super(l,r);
           this.x = x;
      }
      
      public String toString(){
         String s = getLeft().toString();
         String ss = getRight().toString();
        
         switch(x){
            case 0:
                  return   s + " + " + ss;
            case 1:
                  return  "(" + s +")  + " + ss;
            case 2:
                  return  s + " + (" + ss + ")";
            case 3:
                  return  "(" + s +")  + (" + ss + ")";
         }

         return "Erro: valor inválido";
      }
      
      public void accept(Visitor v){v.visit(this);}
      
}