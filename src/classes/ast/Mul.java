package ast;

/*
 * Esta classe representa uma expressão de multiplicação.
 * Expr * Expr
 */
 
import java.util.HashMap; 
public class Mul extends BinOP {

      public Mul(Expr l, Expr r){
           super(l,r);
      }
      
      public String toString(){
         String s = getLeft().toString();
         String ss = getRight().toString();
         if(getLeft() instanceof Add || getLeft() instanceof Sub || getLeft() instanceof Mul || getLeft() instanceof Div){
            s = "(" + s + ")";
         } 
         String ss = getRight().toString();
         if( getRight() instanceof Add || getRight() instanceof Sub){
            ss = "(" + ss+ ")";
         }
         return   s + " + " + ss;
      }
      
      public int interpret(HashMap<String,Integer> m){
          return getLeft().interpret(m) * getRight().interpret(m);
      }
      
}



