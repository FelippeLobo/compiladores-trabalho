package ast;

/*
 * Esta classe representa um comando de atribuição.
 * Stmt ; StmtList
 */
import java.util.HashMap; 

public class CmdList extends Node {
      
      private Node cmd1;
      private Node cmd2; 
      
      public CmdList(Node c1, Node c2){
           this.cmd1 =  c1;
           this.cmd2 =  c2;
      }
      
      public CmdList(Node cmd1){
           this.cmd1 =  cmd1;
           this.cmd2 =  null;
      }
      
      public Node getCmd1(){ return cmd1;} 
      public Node getCmd2(){ return cmd2; }
      
      //@Override
      public String toString(){
         if(cmd2 !=  null && !(cmd2 instanceof CmdList)){
              return   cmd1.toString() + ";\n" + cmd2.toString() +  ";" ;
         }
         return  cmd1.toString() + ";\n" + (cmd2 != null ? cmd2.toString()  : "") ;
      }
      
      public int interpret(HashMap<String,Integer> m){
           cmd1.interpret(m);
           return cmd2.interpret(m);
      }
}
