package src.ast;

/*
 * Esta classe representa o if e if e else.
 * If (Exp) { StmList } else { StmtList }
 */
 
import java.util.HashMap;

import src.visitors.Visitor; 

public class IfElse extends Node {
      
     private Exp e;
     private StmtList stmtList1;
     private StmtList stmtList2;

     public IfElse(Exp e, StmtList stmtList1){
          this.e  = e;
          this.stmtList1 = stmtList1;
          this.stmtList2 = null;
     }
      
     public IfElse(Exp e, StmtList stmtList1, StmtList stmtList2){
          this.e  = e;
          this.stmtList1 = stmtList1;
          this.stmtList2 = stmtList2;
     }

     public Exp getExp(){
          return this.e;
     }

     public StmtList getStmtList1(){
          return this.stmtList1;
     }

     public StmtList getStmtList2(){
          return this.stmtList2;
     }
      
     public String toString(){
          if(stmtList2 != null){
               return ("if(" + e.toString() + ")\n{" + stmtList1.toString() + "\n} else\n{" + stmtList2.toString() + "\n}");
          }else{
               return ("if(" + e.toString() + ")\n{" + stmtList1.toString() + "\n}");
          }    
     }

     @Override
     public void accept(Visitor v) {
          v.visit(this);
          
     }
}