package src.ast;

/*
 * Esta classe representa o iterate
 * ITERATE AP Exp FP Stmt
 */
 
import java.util.HashMap;

import src.visitors.Visitor; 

public class Iterate extends Node {
      
     private Exp e;
     private Node stmt;

     public Iterate(Exp e, Node stmt){
          this.e  = e;
          this.stmt = stmt;
     }

     public Exp getExp(){
          return this.e;
     }

     public Node getStmt(){
          return this.stmt;
     }
      
     public String toString(){
          return ("iterate(" + e.toString() + ")" + stmt.toString());    
     }

     @Override
     public void accept(Visitor v) {
          v.visit(this);
          
     }
}