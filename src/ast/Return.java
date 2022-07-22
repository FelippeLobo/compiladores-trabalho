package src.ast;

/*
 * Esta classe representa um comando de Impressão.
 * Exp
 */
 
import java.util.HashMap;

import src.visitors.Visitor; 

public class Return extends Exp {
      
      private Type type;
      private Node returnL;
     
      public Return(Type type, Node returnL){
           this.type = type;
           this.returnL = returnL;
      }

      public Return(Type type){
        this.type = type;
        this.returnL = null;
   }
      
      public Type getType(){ return type;}
      public Node getReturn(){ return returnL;}
      //@Override
      public String toString(){
          if(returnL != null){
            return   (type.toString() + ", " + returnL.toString()); 
          }
         return   (type.toString()); 
      }
      
      public void accept(Visitor v){v.visit(this);}
      
}
