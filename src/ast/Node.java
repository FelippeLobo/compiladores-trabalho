package src.ast;

import java.util.HashMap;

import src.visitors.Visitable;

public abstract class Node extends src.beaver.Symbol implements Visitable{
      
      
      public Node(){

      }
      
      public int getLine(){ return super.getLine(getStart()); }
      public int getCol(){ return super.getColumn(getStart());}  
      
      //public abstract int interpret(HashMap<String,Integer> m);
      
}
