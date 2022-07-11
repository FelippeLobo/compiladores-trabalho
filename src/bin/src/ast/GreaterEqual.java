package src.classes.ast;

/*
 * Esta classe representa uma Expessão de soma.
 * Exp + Exp
 */
 
import java.util.HashMap; 
public class GreaterEqual extends BinOP {

      public GreaterEqual(Exp l, Exp r){
           super(l,r);
      }
      
      public String toString(){
         String s = getLeft().toString();
         String ss = getRight().toString();
         if(getLeft() instanceof Div || getLeft() instanceof Add || getLeft() instanceof Sub || getLeft() instanceof Mul){
            s = "(" + s + ")";
         }
         if(getRight() instanceof Div || getRight() instanceof Add || getRight() instanceof Sub || getRight() instanceof Mul){
            ss = "(" + ss + ")";
         }
         return   s + " >= " + ss;
      }
      
      public int interpret(HashMap<String,Integer> m){
         if(getLeft().interpret(m) >= getRight().interpret(m)){
            return 1;
         }else
          return 0;
      }
      
}