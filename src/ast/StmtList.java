package src.ast;

/*
 * Esta classe representa o StmtList.
 * Stmt Semi
 * Stmt Semi StmtList
 */
 
import java.util.HashMap;

import src.visitors.Visitor; 

public class StmtList extends Node {
      
     private Node stmt;
     private Node stmtList;

     public StmtList(Node stmt){
          this.stmt = stmt;
          this.stmtList = null;
     }
      
     public StmtList(Node stmt, Node stmtList){
          this.stmt = stmt;
          this.stmtList = stmtList;
     }

     public Node getStmt(){
          return this.stmt;
     }

     public Node getStmtList(){
          return this.stmtList;
     }

     public String toString(){
          if(stmtList != null){
               return (stmt.toString() + ";\n" + stmtList.toString());
          }else{
               return (stmt.toString() + ";\n");
          }    
     }

     @Override
     public void accept(Visitor v) {
          v.visit(this);
          
     }
}