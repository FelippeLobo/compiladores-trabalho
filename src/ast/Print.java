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

      public Print(){
        this.e = null;
      }
      
      public Exp getExp(){ return e;}
      
      //@Override
      public String toString(){
        if(this.e != null){
            return  ("print " + e.toString() + ";"); 
        }else{
            return ("print '\\" + "n';");
        }
        
      }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
        
    }
      
      
}
