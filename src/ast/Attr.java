package src.ast;

/*
 * Esta classe representa um comando de atribuição.
 * ID = Exp
 */
 
import java.util.HashMap;

import src.visitors.Visitor; 

public class Attr extends Node {
      
      private ID id;
      private Exp e; 
      
      public Attr(String id, Exp e){
           System.out.println("ID:" + id);
           this.id = new ID(id);
           this.e  = e;
      }

      public Attr(ID id, Exp e){
          System.out.println("segundo const/ID:" + id.toString());
          this.id = id;
          this.e  = e;
     }
      
      public ID getID(){ return id;} 
      public Exp getExp(){   return e; }
      
      public String toString(){
          return id.toString() + " = " + e.toString();
      }

     @Override
     public void accept(Visitor v) {
          v.visit(this);
          
     }
      
      
}
