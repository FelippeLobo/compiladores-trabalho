package src.ast;

import java.util.ArrayList;
import java.util.List;

import src.visitors.Visitor;

public class Param extends Node{
    
    private String id;
    private Type type;

    public Param(String id, Type type){
   
        this.id = id;
        this.type = type;
    }

    public String getIdentifier(){
        return this.id;
    }

    public Node getType(){
        return this.type;
    }

    @Override
    public String toString(){
            return  (this.id.toString() + " :: " + this.type.toString());      
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }



}
