package src.ast;

/*
 * Esta classe representa o StmtList.
 * Stmt Semi
 * Stmt Semi StmtList
 */
 
import java.util.HashMap;

import src.visitors.Visitor; 

public class Exps extends Node {
      
     private Node exp;
     private Node exps;

     public Exps(Node exp){
          this.exp = exp;
          this.exps = null;
     }
      
     public Exps(Node exp, Node exps){
          this.exp = exp;
          this.exps = exps;
     }

     public Node getExp(){
          return this.exp;
     }

     public Node getExps(){
          return this.exps;
     }

     @Override
     public String toString(){
          if(exps != null){
               return (exp.toString() + " " + exps.toString());
          }else{
               return (exp.toString() + " ");
          }    
     }

     @Override
     public void accept(Visitor v) {
          v.visit(this);
          
     }
}