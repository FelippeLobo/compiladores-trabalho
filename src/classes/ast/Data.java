package src.classes.ast;
import java.util.HashMap;

import src.classes.beaver.Symbol;
public class Data extends Node {

    public Data(String a, Symbol b) {
    }

    public int interpret(HashMap<String,Integer> m){
          System.out.println(this.toString());

           return 0;
 } 
}
