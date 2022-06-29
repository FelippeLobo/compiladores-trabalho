package src.classes.ast;

/*
 * Esta classe representa um comando de atribuição.
 * ID = Exp
 */
 
import java.util.HashMap; 

public class Attr extends Node {
      
      private ID id;
      private Exp e; 
      
      public Attr(String id, Exp e){
           this.id = new ID(id);
           this.e  = e;
      }
           
      public Attr(ID id, Exp e){
        this.id = id;
        this.e  = e;
   }

   
      public ID getID(){ return id;} 
      public Exp getExp(){   return e; }
      
      public String toString(){
          return id.toString() + " = " + e.toString();
      }
      
      public int interpret(HashMap<String,Integer> m){
          System.out.println(this.toString());

           int x = e.interpret(m);
           m.put(id.getName(), x);
           return x;
      }   
}
