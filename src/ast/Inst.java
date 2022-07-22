package src.ast;


import java.util.HashMap; 
import src.visitors.Visitor;
 
public class Inst extends Exp {
      
      private Lvalue i ;
      private Type t;
      private Exp s;
      
      public Inst(Type t, Exp s ){
           this.i = null;
           this.t = t;
           this.s = s;
      }
      
      public Inst(Type t){
            this.i = null;
            this.t = t;
            this.s = null;
       }

      public Type getType(){ return t;}
      public String getID(){ return i.getIdentifier();}
      public Exp getSize(){ return s;}
      
      public void setLvalue(Lvalue i){
            this.i = i;
      }
      //@Override
      public String toString(){
         return   ("new " + t.toString() + " [" + s.toString() + "]"); 
      }
      
      public void accept(Visitor v){ v.visit(this); }
}
