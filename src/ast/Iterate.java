package src.ast;

/*
 * Esta classe representa o iterate
 * ITERATE AP Exp FP Stmt
 */
 
import java.util.HashMap;

import src.visitors.Visitor; 

public class Iterate extends Node {
      
     private Exp e;
     private StmtList stmtList;

     public Iterate(Exp e, StmtList stmtList){
          this.e  = e;
          this.stmtList = stmtList;
     }

     public Exp getExp(){
          return this.e;
     }

     public Node getStmtList(){
          return this.stmtList;
     }
      
     public String toString(){
          return ("iterate(" + e.toString() + "){" + stmtList.toString() + "}");    
     }

     @Override
     public void accept(Visitor v) {
          v.visit(this);
          
     }
}