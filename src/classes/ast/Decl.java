package src.classes.ast;
import java.util.HashMap;

import src.classes.beaver.Symbol;
public class Decl extends Node {
    
    public Decl(String a, Symbol b) {
	}

	public int interpret(HashMap<String,Integer> m){
          System.out.println(this.toString());

           return 0;
      } 
}
