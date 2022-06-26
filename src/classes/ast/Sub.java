package ast;

/*
 * Esta classe representa uma expressão de subtração.
 * Expr - Expr
 */
 
import java.util.HashMap; 
public class Sub extends BinOP {

      public Sub(Expr l, Expr r){
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
          return getLeft().interpret(m) - getRight().interpret(m);
      }
      
}