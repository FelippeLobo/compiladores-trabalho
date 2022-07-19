package src.ast;

import java.util.ArrayList;
import java.util.List;

import src.visitors.Visitor;

public class Prog extends Node{
    
    private Node command1;
    private Node command2;

    public Prog(Node command1){
        this.command1 = command1;
        this.command2 = null;
    }

    public Prog(Node command1, Node command2){
        this.command1 = command1;
        this.command2 = command2;
    }

    public Node getCommand1(){
        return this.command1;
    }
    public Node getCommand2(){
        return this.command2;
    }

    @Override
    public String toString(){
        if(command2 !=  null && !(command2 instanceof Prog)){
            return   command1.toString() + "\n" + command2.toString() ;
       }
       return  command1.toString() + "\n" + (command2 != null ? command2.toString()  : "") ;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);

    }



}
