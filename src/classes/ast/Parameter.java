package src.classes.ast;
import java.util.HashMap;

import src.classes.beaver.Symbol;
public class Parameter extends Node {
    
    public Parameter(String a, ID b) {
	}
    public Parameter(String a, Btype b) {
	}
    public Parameter(String a, Symbol b) {
	}
	public int interpret(HashMap<String,Integer> m){
          System.out.println(this.toString());

           return 0;
      } 
}
