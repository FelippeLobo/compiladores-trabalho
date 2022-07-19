package src.ast;

import java.util.HashMap;

import src.visitors.Visitor;

/*
 * Esta classe representa um comando de Impressão.
 * Exp
 */
public class Exp extends Node {
      
      public Exp(){
      }

      @Override
      public void accept(Visitor v) {
            v.visit(this);          
      }

      
      

      
}
