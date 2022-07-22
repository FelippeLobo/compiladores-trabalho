package src.ast;

import java.util.ArrayList;
import java.util.List;

import src.visitors.Visitor;

public class Func extends Node{
    
    private Lvalue id;
    private Node param;
    private Node returnL;
    private Node body;

    public Func(Lvalue id, Node param, Node returnL, Node body){
   
        this.id = id;
        this.param = param;
        this.returnL = returnL;
        this.body = body;

    }


    public Lvalue getIdentifier(){
        return this.id;
    }
    public Node getParam(){
        return this.param;
    }
    public Node getReturn(){
        return this.returnL;
    }  
    public Node getBody(){
        return this.body;
    }

    @Override
    public String toString(){
       
       return  (id.toString() + " ( " + this.param.toString() + " ) : " + this.returnL.toString() + " { " + "\n" + this.body.toString() + "\n" + " } ");
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }



}
