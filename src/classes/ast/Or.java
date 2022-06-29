package src.classes.ast;

import java.util.HashMap;

public class Or extends Node {
    public Or(Exp a, Exp b){

    }

    public int interpret(HashMap<String,Integer> m){
          System.out.println(this.toString());

           return 0;
      } 
}
