package src.classes.ast;

import java.util.HashMap;

public class Prog extends Node {
    public Prog(){

    }

    public int interpret(HashMap<String,Integer> m){
          System.out.println(this.toString());

           return 0;
      } 
}
