package src.classes.ast;

/*
 * Esta classe representa uma Expessão de subtração.
 * Exp - Exp
 */
 
import java.util.HashMap; 
public class Sub extends BinOP {

      public Sub(Exp l, Exp r){
           super(l,r);
      }
      
      public String toString(){
         String s = getLeft().toString();
         String ss = getRight().toString();
         if(getRight() instanceof Add || getRight() instanceof Sub){
            ss = "(" + ss + ")";
         }  
         return   s + " - " + ss;
      }
      
      public int interpret(HashMap<String,Integer> m){
         System.out.println(this.toString());
         
          return getLeft().interpret(m) - getRight().interpret(m);
      }
      
}