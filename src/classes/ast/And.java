package src.classes.ast;

/*
 * Esta classe representa uma Expessão de soma.
 * Exp + Exp
 */
 
import java.util.HashMap; 
public class And extends BinOP {

      public And(Exp l, Exp r){
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
         return   s + " && " + ss;
      }
      
      public int interpret(HashMap<String,Integer> m){

            int left =  getLeft().interpret(m);
            int right = getRight().interpret(m);

            if(left == 1 && right == 1){
                return 1;
            }else {
               return 0;
            }
      }
      
}