package src.visitors;

import src.ast.*;

public class FunctionsVisitor extends Visitor {
     
     public FunctionsVisitor(){
     }

     
     public void visit(Prog prog){
        
        prog.getCommand1().accept(this);
        if(prog.getCommand2() != null){
            prog.getCommand2().accept(this);
        }
     }
     
     public void visit(Add e){
         System.out.println(e.toString());
     }
     

     
     public void visit(Attr e){
         System.out.println(e.toString());
     }
     
     
     public void visit(Print e){
         System.out.println(e.toString());
     }


    @Override
    public void visit(Exp exp) {
       
        
    }


}
