package src.ast;

/*
 * Esta classe representa o if e if e else.
 * If (Exp) { StmList } else { StmtList }
 */
 
import java.util.HashMap;

import src.visitors.Visitor; 

public class IfElse extends Node {
      
     private Exp e;
     private StmtList sl1;
     private StmtList sl2;
      
     public IfElse(Exp e, StmtList sl1, StmtList sl2){
          this.e  = e;
          this.sl1 = sl1;
          this.sl2 = sl2;
     }

     public Exp getExp(){
          return this.e;
     }

     public StmtList getStmtList1(){
          return this.sl1;
     }

     public StmtList getStmtList2(){
          return this.sl2;
     }
      
     public String toString(){
          if(sl2 != null){
               return ("if(" + e.toString() + "){" + sl1.toString() + "} else{" + sl2.toString() + "}");
          }else{
               return ("if(" + e.toString() + "){" + sl1.toString() + "}");
          }    
     }

     @Override
     public void accept(Visitor v) {
          v.visit(this);
          
     }
}
