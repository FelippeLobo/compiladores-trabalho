package src.ast;


import java.util.HashMap; 
import src.visitors.Visitor;
 
public class Inst extends Exp {
      
      private Lvalue i ;
      private Type t;
      private Exp s;
      private Exp exp2;
      private Boolean mat;

      public Inst(Type t, Exp s, Boolean mat){
            this.i = null;
            this.t = t;
            this.s = s;
            this.exp2 = null;
            this.mat = mat;
      }

      public Inst(Type t, Exp s, Exp exp2){
            this.i = null;
            this.t = t;
            this.s = s;
            this.exp2 = exp2;
            this.mat = false;
      }
      
      public Inst(Type t, Exp s ){
           this.i = null;
           this.t = t;
           this.s = s;
           this.exp2 = null;
           this.mat = false;
      }
      
      public Inst(Type t){
            this.i = null;
            this.t = t;
            this.s = null;
            this.exp2 = null;
            this.mat = false;
       }

      public Type getType(){ return t;}
      public String getID(){ return i.getIdentifier();}
      public Exp getSize(){ return s;}
      public Exp getSize2(){ return exp2;}
      
      public void setLvalue(Lvalue i){
            this.i = i;
      }
      //@Override
      public String toString(){
            if(s != null){
                  if(exp2 != null){
                        return   ("new " + t.toString() + " [" + s.toString() + "][" + exp2.toString() + "]"); 
                  }else{
                        if(mat){
                              return ("new " + t.toString() + " [" + s.toString() + "][]");
                        }else{
                              return   ("new " + t.toString() + " [" + s.toString() + "]");
                        }
                         
                  }
                  
            }
         return   ("new " + t.toString() ); 
      }
      
      public void accept(Visitor v){ v.visit(this); }
}
