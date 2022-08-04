package src.ast;

import java.util.ArrayList;
import java.util.List;

import src.visitors.Visitor;

public class Param extends Node{
    
    private String id;
    private Type type;
    private Exp e;

    public Param(String id, Type type){
   
        this.id = id;
        this.type = type;
        this.e = null;
    }

    public Param(String id, Type type, Exp e){
   
        this.id = id;
        this.type = type;
        this.e = e;
    }

    public String getIdentifier(){
        return this.id;
    }

    public Node getType(){
        return this.type;
    }

    public Exp getExp(){
        return this.e;
    }

    @Override
    public String toString(){
        if(this.e != null){
            return  (this.id.toString() + " :: " + this.type.toString() + "[" + this.e.toString() + "]"); 
        }else{
            return  (this.id.toString() + " :: " + this.type.toString());      
        }
            
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }



}
