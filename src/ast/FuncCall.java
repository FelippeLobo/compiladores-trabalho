package src.ast;

import src.visitors.Visitor; 

public class FuncCall extends Exp {

    private String id;
    private Exps parameters;
    private Exp returnId;

    public FuncCall(String id, Exps parameters, Exp returnId){
        this.id = id;
        this.parameters = parameters;
        this.returnId = returnId;
    }

    public FuncCall(String id, Exps parameters){
        this.id = id;
        this.parameters = parameters;
        this.returnId = null;
    }

    public FuncCall(String id, Exp returnId){
        this.id = id;
        this.parameters = null;
        this.returnId = returnId;
    }


    public FuncCall(String id){
        this.id = id;
        this.parameters = null;
        this.returnId = null;
    }

    public String toString(){
        if(returnId != null){
            if(parameters != null){
                return (this.id.toString() + "(" + this.parameters.toString() + ")[" + returnId.toString() + "]");
            }else{
                return (this.id.toString() + "()[" + returnId.toString() + "]");
            }
           
        }else{
            if(parameters != null){
                return (this.id.toString() + "(" + this.parameters.toString() + ")");
            }else{
                return (this.id.toString() + "()");
            }
        }
        
    }

    public String getIdentifier(){
        return this.id;
    }

    public Exps getParamaters(){
        return this.parameters;
    }
    
    public Exp getReturnId(){
        return this.returnId;
    }

    @Override
    public void accept(Visitor v) {
         v.visit(this);
         
    }
}
