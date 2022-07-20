package src.visitors;

import src.ast.*;

public abstract class Visitor {

     public abstract void visit(Add add);

     public abstract void visit(Sub sub);

     public abstract void visit(Prog prog);

     public abstract void visit(Attr attr);

     public abstract void visit(Exp exp);

     public abstract void visit(Print print);

     public abstract void visit(Var var);

     public abstract void visit(Num num);
}
