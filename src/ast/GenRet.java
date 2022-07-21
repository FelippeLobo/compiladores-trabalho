package src.ast;

/*
 * Esta classe representa o Return de Stmt
 * RETURN Ret
 */
 
import java.util.HashMap;

import src.visitors.Visitor; 

public class GenRet extends Node {
      
     private Node ret;

     public GenRet(Node ret){
          this.ret = ret;
     }

     public Node getRet(){
          return this.ret;
     }
      
     public String toString(){
          return ("return " + ret.toString());    
     }

     @Override
     public void accept(Visitor v) {
          v.visit(this);
          
     }
}