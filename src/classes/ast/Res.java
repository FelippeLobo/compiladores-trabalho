package ast;

/*
 * Esta classe representa uma expressão de Resto.
 * Expr / Expr
 */
import java.util.HashMap; 

public class Res extends BinOP {
      public Res(Expr l, Expr r){
           super(l,r);
      }
      
      //@Override
      public String toString(){
         String s = getLeft().toString();
         if(getLeft() instanceof Div || getLeft() instanceof Add || getLeft() instanceof Sub || getLeft() instanceof Mul){
            s = "(" + s + ")";
         }
         String ss = getRight().toString();
         if( getRight() instanceof Add || getLeft() instanceof Sub){
            ss = "(" + ss+ ")";
         }
         return   s + " % " + ss;
      }
      
      public int interpret(HashMap<String,Integer> m){
          return getLeft().interpret(m) % getRight().interpret(m);
      }
}
