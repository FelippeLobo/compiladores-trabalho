package src.classes.ast;

/*
 * Esta classe representa um comando de Impressão.
 * Exp
 */
 
import java.util.HashMap; 

public class ID extends Exp {
      
      private String l;
     
      public ID(String name){
           this.l = name;
      }
      
      public String getName(){ return l;}
      
      //@Override
      public String toString(){
         return   l; 
      }
      
      public int interpret(HashMap<String,Integer> m){
        System.Out.Println(this.toString());
        
          return m.get(l);
      }
}
