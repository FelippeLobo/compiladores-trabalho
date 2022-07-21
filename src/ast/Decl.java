package src.ast;

import java.util.ArrayList;
import java.util.List;

import src.visitors.Visitor;

public class Decl extends Node{
    
    private Var id;
    private Node type;
    private Node decl;

    public Decl(Var id, Node type){
   
        this.id = id;
        this.type = type;
        this.decl = null;
    }

    public Decl(Var id, Node type, Node decl){
   
        this.id = id;
        this.type = type;
        this.decl = decl;
    }

    public Var getIdentifier(){
        return this.id;
    }
    public Node getType(){
        return this.type;
    }

    public Node getDecl(){
        return this.decl;
    }

    @Override
    public String toString(){
        if(decl !=  null){
            return   id.toString() + " :: " + type.toString() + ";" + "\n" + decl.toString() ;
       }
       return  id.toString() + " :: " + type.toString() + ";" + "\n";
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);

    }



}
