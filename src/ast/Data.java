package src.ast;

import java.util.ArrayList;
import java.util.List;

import src.visitors.Visitor;

public class Data extends Node{
    
    private Type id;
    private Node decl;

    public Data(Type id, Node decl){
   
        this.id = id;
        this.decl = decl;
    }


    public Type getIdentifier(){
        return this.id;
    }
    public Node getDecl(){
        return this.decl;
    }

    @Override
    public String toString(){
       
       return  ("data " + id.toString() + " { " + "\n" + decl.toString() + " } ");
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }



}
