package src.ast;

/*
 * Esta classe representa um comando de Impressão.
 * Exp
 */
import java.util.HashMap;

import src.visitors.Visitor; 
 
public class Print extends Node {
      
      private Exp e; 
      
      public Print( Exp e){
           this.e  = e;
      }
      
      public Exp getExp(){ return e;}
      
      //@Override
      public String toString(){
         return  ("" + e.toString() + ";"); 
      }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
        
    }
      
      
}
