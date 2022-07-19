package src.ast;

/*
 * Esta classe representa um comando de atribuição.
 * ID = Exp
 */
 
import java.util.HashMap;

import src.visitors.Visitor; 

public class Attr extends Node {
      
      private Var id;
      private Exp e; 
      
      public Attr(String id, Exp e){
           this.id = new Var(id);
           this.e  = e;
      }

      public Attr(Var id, Exp e){
          this.id = id;
          this.e  = e;
     }
      
      public Var getVar(){ return id;} 
      public Exp getExp(){   return e; }
      
      public String toString(){
          return id.toString() + " = " + e.toString();
      }

     @Override
     public void accept(Visitor v) {
          v.visit(this);
          
     }
      
      
}
