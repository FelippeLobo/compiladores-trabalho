package src.visitors;

import src.ast.*;

public abstract class Visitor {

     public abstract void visit(Add add);

     public abstract void visit(Sub sub);

     public abstract void visit(Mult mult);

     public abstract void visit(Div div);

     public abstract void visit(Res res);

     public abstract void visit(Greater greater);

     public abstract void visit(Lesser lesser);

     public abstract void visit(GreaterEqual greaterEqual);

     public abstract void visit(LesserEqual lesserEqual);

     public abstract void visit(Equal equal);

     public abstract void visit(Dif dif);

     public abstract void visit(Prog prog);

     public abstract void visit(Attr attr);

     public abstract void visit(Exp exp);

     public abstract void visit(Print print);

     public abstract void visit(Var var);

     public abstract void visit(Num num);
     
     public abstract <T> void visit(LiteralValue<T> literalValue);

     public abstract void visit(StmtList stmtList);

     public abstract void visit(IfElse ifelse);
}
