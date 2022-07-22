package src.ast;

import javafx.animation.KeyValue;
import src.visitors.Visitor;

public class Read extends Node {

    private Lvalue lvalue;

    public Read(Lvalue lvalue){
        this.lvalue = lvalue;
    }

    public Lvalue getLvalue(){
        return this.lvalue;
    }

    @Override
    public String toString() {
        return ("READ " + this.lvalue.toString());
    }

   
    @Override
    public void accept(Visitor v) {
        v.visit(this);

    }
}
