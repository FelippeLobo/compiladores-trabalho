package src.ast;

/*
 * Esta classe representa uma negação NOT".
 * ! Exp
 */
 
import java.util.HashMap;

import src.visitors.Visitor; 
public class Not extends Exp {

      private Exp e;
      private int x;

      public Not(Exp e, int x){
           this.e = e;
           this.x = x;
      }

      public Exp getExp()
      {
            return this.e;
      }
      
      public String toString(){

            if(x == 1){
                  return ("!(" + e.toString() + ")");
            }else{
                  return ("!" + e.toString());
            }
            
      }
      
      @Override
      public void accept(Visitor v){v.visit(this);}
      
}