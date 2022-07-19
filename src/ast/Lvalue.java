package src.ast;

public class Lvalue extends Exp {

    private String id;
    private Exp[] ctx;

    public Lvalue(String id, Exp[] ctx){
        this.id = id;
        this.ctx = ctx;
    }

    public Lvalue(String id){
        this.id = id;
        this.ctx = null;
    }

    //public Exp[] getCtx(){}

    
}
