package src.ast;
import src.visitors.Visitor;

public class Lvalue extends Exp {

    private String id;
    private Exp exp;
    private Exp exp2;
    private Lvalue lvalue;

    public Lvalue(Lvalue lvalue, Exp exp, Exp exp2){
        this.id = null;
        this.exp = exp;
        this.lvalue = lvalue;
        this.exp2 = exp2;
    }

    public Lvalue(Lvalue lvalue, Exp exp){
        this.id = null;
        this.exp = exp;
        this.lvalue = lvalue;
        this.exp2 = null;
    }

    public Lvalue(String id){
        this.id = id;
        this.exp = null;
        this.lvalue = null;
        this.exp2 = null;
    }
    
    public Lvalue(Lvalue Lvalue){
        this.id = null;
        this.exp = null;
        this.lvalue = Lvalue;
        this.exp2 = null;
    }

    public Lvalue(Lvalue lvalue, String id){
        this.id = id;
        this.exp = null;
        this.lvalue = lvalue;
        this.exp2 = null;
    }

    public Exp getCtx(){return this.exp;}
    public String getIdentifier(){return this.id;}
    public Lvalue getLvalue(){return this.lvalue;}
    public Exp getSctx(){return this.exp2;}

    @Override
    public String toString() {
        if(this.lvalue != null){
            if(this.exp != null){
                if(this.exp2 != null){
                    String result = (this.lvalue.toString() + "[ " + this.exp.toString() + " ][" + this.exp.toString() + "]");
                    return result;
                }else{
                    String result = (this.lvalue.toString() + "[ " + this.exp.toString() + " ]");
                    return result;
                }
                
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