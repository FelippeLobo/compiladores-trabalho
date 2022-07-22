package src.ast;
import src.visitors.Visitor;

public class Lvalue extends Node {

    private String id;
    private Exp exp;
    private Lvalue lvalue;

    public Lvalue(Lvalue lvalue, Exp exp){
        this.id = null;
        this.exp = exp;
        this.lvalue = lvalue;
    }

    public Lvalue(String id){
        this.id = id;
        this.exp = null;
        this.lvalue = null;
    }
    
    public Lvalue(Lvalue Lvalue){
        this.id = null;
        this.exp = null;
        this.lvalue = Lvalue;
    }

    public Lvalue(Lvalue lvalue, String id){
        this.id = id;
        this.exp = null;
        this.lvalue = lvalue;
    }

    public Exp getCtx(){return this.exp;}
    public String getIdentifier(){return this.id;}
    public Lvalue getLvalue(){return this.lvalue;}

    @Override
    public String toString() {
        if(this.lvalue != null){
            if(this.exp != null){
                String result = (this.lvalue.toString() + "[ " + this.exp.toString() + " ]");
                return result;
            }else{
                String result = (this.lvalue.toString() + "." + this.id);
                return result;
            }
        }

        return this.id;
    }
    public void accept(Visitor v) {
        v.visit(this);
  }
    
}
