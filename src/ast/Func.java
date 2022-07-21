package src.ast;

import java.util.ArrayList;
import java.util.List;

import src.visitors.Visitor;

public class Func extends Node{

    private Var id;
    private Node param;
    private Node returnL;
    private Node body;

    public Func(Var id, Node param, Node returnL, Node body){

        this.id = id;
        this.param = param;
        this.returnL = returnL;
        this.body = body;
    }

    public Func(Var id, Node body){

        this.id = id;
        this.body = body;
        this.param = null;
        this.returnL = null;
    }

    public Var getIdentifier(){
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

        if(this.param != null){
            return  (id.toString() + " ( " + this.param.toString() + " ) : " + this.returnL.toString() + " { " + "\n" + this.body.toString() + "\n" + " } ");
        }else{
            return  (id.toString() + " ( ) { " + "\n" + this.body.toString() + "\n" + " } ");
        }   
       
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}