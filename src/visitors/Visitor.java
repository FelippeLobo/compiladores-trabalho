package src.visitors;

import src.ast.*;

public abstract class Visitor {

     public abstract void visit(Add add);

     public abstract void visit(Sub sub);

     public abstract void visit(Mult mult);

     public abstract void visit(Div div);

     public abstract void visit(Mod mod);

     public abstract void visit(Greater greater);

     public abstract void visit(Lesser lesser);

     public abstract void visit(GreaterEqual greaterEqual);

     public abstract void visit(LesserEqual lesserEqual);

     public abstract void visit(Equal equal);

     public abstract void visit(Dif dif);

     public abstract void visit(And and);

     public abstract void visit(Prog prog);

     public abstract void visit(Attr attr);

     public abstract void visit(Exp exp);

     public abstract void visit(Print print);

     public abstract void visit(Type type);

     public abstract void visit(Num num);

     public abstract <T> void visit(LiteralValue<T> literalValue);

     public abstract void visit(StmtList stmtList);

     public abstract void visit(IfElse ifelse);

     public abstract void visit(Iterate iterate);

     public abstract void visit(GenRet genret);

     public abstract void visit(Ret ret);
     
     public abstract void visit(Decl decl);

     public abstract void visit(Data data);

     public abstract void visit(Func func);

     public abstract void visit(Param param);

     public abstract void visit(ParamList paramList);

     public abstract void visit(Return returnl);

     public abstract void visit(Lvalue lvalue);

     public abstract void visit(Read read);

     public abstract void visit(Inst inst);
}
