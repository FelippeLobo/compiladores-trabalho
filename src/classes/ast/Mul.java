package src.classes.ast;

/*
 * Esta classe representa uma Expessão de multiplicação.
 * Exp * Exp
 */
 
import java.util.HashMap; 
public class Mul extends BinOP {

      public Mul(Exp l, Exp r){
           super(l,r);
      }
      
      public String toString(){
         String s = getLeft().toString();
         String ss = getRight().toString();
         if(getLeft() instanceof Add || getLeft() instanceof Sub || getLeft() instanceof Mul || getLeft() instanceof Div){
            s = "(" + s + ")";
         } 
         if( getRight() instanceof Add || getRight() instanceof Sub){
            ss = "(" + ss+ ")";
         }
         return   s + " + " + ss;
      }
      
      public int interpret(HashMap<String,Integer> m){
         System.out.println(this.toString());
         
          return getLeft().interpret(m) * getRight().interpret(m);
      }
      
}



