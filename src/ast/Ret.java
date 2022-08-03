package src.ast;

/*
 * Esta classe representa o Ret
 * Ret = Exp COMMA Ret
     | Exp
     ;
 */
 
import java.util.HashMap;

import src.visitors.Visitor; 

public class Ret extends Node {
      
     private Exp e;
     private Node ret;

     public Ret(Exp e){
          this.e  = e;
          this.ret = null;
     }

     public Ret(Exp e, Node ret){
          this.e = e;
          this.ret = ret;
     }

     public Exp getExp(){
          return this.e;
     }

     public Node getRet(){
          return this.ret;
     }
      
     public String toString(){
          if(ret != null){
               return (e.toString() + ", " + ret.toString());
          }else{
               return e.toString();
          }
              
     }

     @Override
     public void accept(Visitor v) {
          v.visit(this);
          
     }
}