package src.ast;

/*
 * Esta classe representa um comando de Impressão.
 * Exp
 */
 
import java.util.HashMap;

import src.visitors.Visitor; 

public class Return extends Exp {
      
      private Type type;
      
     
      public Return(String name){
           this.l = name;
      }
      
      public String getName(){ return l;}
      
      //@Override
      public String toString(){
         return   l; 
      }
      
      public void accept(Visitor v){v.visit(this);}
      
}
