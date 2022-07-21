package src.ast;

/*
 * Esta classe representa o if e if e else.
 * If (Exp) { StmList } else { StmtList }
 */
 
import java.util.HashMap;

import src.visitors.Visitor; 

public class IfElse extends Node {
      
     private Exp e;
     private Node stmtList1;
     private Node stmtList2;

     public IfElse(Exp e, Node stmtList1){
          this.e  = e;
          this.stmtList1 = stmtList1;
          this.stmtList2 = null;
     }
      
     public IfElse(Exp e, Node stmtList1, Node stmtList2){
          this.e  = e;
          this.stmtList1 = stmtList1;
          this.stmtList2 = stmtList2;
     }

     public Exp getExp(){
          return this.e;
     }

     public Node getStmtList1(){
          return this.stmtList1;
     }

     public Node getStmtList2(){
          return this.stmtList2;
     }
      
     public String toString(){
          if(stmtList2 != null){
               return ("if(" + e.toString() + ") " + stmtList1.toString() + " else " + stmtList2.toString());
          }else{
               return ("if(" + e.toString() + ")" + stmtList1.toString());
          }    
     }

     @Override
     public void accept(Visitor v) {
          v.visit(this);
          
     }
}