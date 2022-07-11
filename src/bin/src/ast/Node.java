package src.ast;

import java.util.HashMap;

public abstract class Node extends src.beaver.Symbol {
      
      
      public Node(){

      }
      
      public int getLine(){ return super.getLine(getStart()); }
      public int getCol(){ return super.getColumn(getStart());}  
      
      public abstract int interpret(HashMap<String,Integer> m);
      
}
