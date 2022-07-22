package src.visitors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import src.ast.*;

public class InterpretVisitor extends Visitor {

    private Stack<Object> operands;
    private Stack<HashMap<String, Object>> env;
    private HashMap<String, Object> globalCtx;
    private boolean isBlock;

    public InterpretVisitor() {
        env = new Stack<>();
        globalCtx = new HashMap<>();
        operands = new Stack<>();
        isBlock = false;
    }

    @Override
    public void visit(Prog prog) {

        prog.getCommand1().accept(this);
        if (prog.getCommand2() != null) {
            prog.getCommand2().accept(this);
        }
    }

    public Object returnValue(Object exp){

        if(this.isBlock){
            Object var = env.peek().get(exp);
            Object global = globalCtx.get(exp);

            if(var != null){
                if(env.peek().get(var) != null){
                    return env.peek().get(var);
                }else{
                    return env.peek().get(exp);
                }

            }else{
                if(globalCtx.get(exp) != null){
                if(globalCtx.get(global) != null){
                    return globalCtx.get(global);
                }else{
                    return globalCtx.get(exp);
                }
                } 
            }
            
        }else{
            if(globalCtx.get(exp) != null){
                Object var = globalCtx.get(exp);
                if(globalCtx.get(var) != null){
                    return globalCtx.get(var);
                }else{
                    return globalCtx.get(exp);
                }
            }else{
                return exp;
            }
        }

        return exp;
    }

    @Override
    public void visit(Add e) {
        e.getLeft().accept(this);
        Object exp = operands.pop();
        Object left = returnValue(exp);

        e.getRight().accept(this);
        Object exp2 = operands.pop();
        Object right = returnValue(exp2);
        
        if(left instanceof Integer){
            if(right instanceof Integer){
                operands.push((Integer)left + (Integer)right);
            }else{
                operands.push((Integer)left + (Float)right);
            }
        }else{
            if(right instanceof Integer){
                operands.push((Float)left + (Integer)right);
            }else{
                operands.push((Float)left + (Float)right);
            }
        }
    }

    @Override
    public void visit(Sub e) {
        e.getLeft().accept(this);
        Object exp = operands.pop();
        Object left = returnValue(exp);

        e.getRight().accept(this);
        Object exp2 = operands.pop();
        Object right = returnValue(exp2);
        
        if(left instanceof Integer){
            if(right instanceof Integer){
                operands.push((Integer)left < (Integer)right);
            }else{
                operands.push((Integer)left < (Float)right);
            }
        }else{
            if(right instanceof Integer){
                operands.push((Float)left < (Integer)right);
            }else{
                operands.push((Float)left < (Float)right);
            }
        }
    }

    @Override
    public void visit(Mult e) {
        e.getLeft().accept(this);
        Object exp = operands.pop();
        Object left = returnValue(exp);

        e.getRight().accept(this);
        Object exp2 = operands.pop();
        Object right = returnValue(exp2);
        
        if(left instanceof Integer){
            if(right instanceof Integer){
                operands.push((Integer)left * (Integer)right);
            }else{
                operands.push((Integer)left * (Float)right);
            }
        }else{
            if(right instanceof Integer){
                operands.push((Float)left * (Integer)right);
            }else{
                operands.push((Float)left * (Float)right);
            }
        }
    }

    @Override
    public void visit(Div e) {
        e.getLeft().accept(this);
        Object exp = operands.pop();
        Object left = returnValue(exp);

        e.getRight().accept(this);
        Object exp2 = operands.pop();
        Object right = returnValue(exp2);
        
        if(left instanceof Integer){
            if(right instanceof Integer){
                operands.push((Integer)left / (Integer)right);
            }else{
                operands.push((Integer)left / (Float)right);
            }
        }else{
            if(right instanceof Integer){
                operands.push((Float)left / (Integer)right);
            }else{
                operands.push((Float)left / (Float)right);
            }
        }
    }

    @Override
    public void visit(Mod e) {
        e.getLeft().accept(this);
        Object exp = operands.pop();
        Object left = returnValue(exp);

        e.getRight().accept(this);
        Object exp2 = operands.pop();
        Object right = returnValue(exp2);
        
        if(left instanceof Integer){
            if(right instanceof Integer){
                operands.push((Integer)left % (Integer)right);
            }else{
                operands.push((Integer)left % (Float)right);
            }
        }else{
            if(right instanceof Integer){
                operands.push((Float)left % (Integer)right);
            }else{
                operands.push((Float)left % (Float)right);
            }
        }
    }

    @Override
    public void visit(Greater e) {
        e.getLeft().accept(this);
        Object exp = operands.pop();
        Object left = returnValue(exp);

        e.getRight().accept(this);
        Object exp2 = operands.pop();
        Object right = returnValue(exp2);
        
        if(left instanceof Integer){
            if(right instanceof Integer){
                operands.push((Integer)left > (Integer)right);
            }else{
                operands.push((Integer)left > (Float)right);
            }
        }else{
            if(right instanceof Integer){
                operands.push((Float)left > (Integer)right);
            }else{
                operands.push((Float)left > (Float)right);
            }
        }
    }

    @Override
    public void visit(Lesser e) {
        e.getLeft().accept(this);
        Object exp = operands.pop();
        Object left = returnValue(exp);

        e.getRight().accept(this);
        Object exp2 = operands.pop();
        Object right = returnValue(exp2);
        
        if(left instanceof Integer){
            if(right instanceof Integer){
                operands.push((Integer)left < (Integer)right);
            }else{
                operands.push((Integer)left < (Float)right);
            }
        }else{
            if(right instanceof Integer){
                operands.push((Float)left < (Integer)right);
            }else{
                operands.push((Float)left < (Float)right);
            }
        }
    }

    @Override
    public void visit(GreaterEqual e) {
        e.getLeft().accept(this);
        Object exp = operands.pop();
        Object left = returnValue(exp);

        e.getRight().accept(this);
        Object exp2 = operands.pop();
        Object right = returnValue(exp2);
        
        if(left instanceof Integer){
            if(right instanceof Integer){
                operands.push((Integer)left >= (Integer)right);
            }else{
                operands.push((Integer)left >= (Float)right);
            }
        }else{
            if(right instanceof Integer){
                operands.push((Float)left >= (Integer)right);
            }else{
                operands.push((Float)left >= (Float)right);
            }
        }
    }

    @Override
    public void visit(LesserEqual e) {
        e.getLeft().accept(this);
        Object exp = operands.pop();
        Object left = returnValue(exp);

        e.getRight().accept(this);
        Object exp2 = operands.pop();
        Object right = returnValue(exp2);
        
        if(left instanceof Integer){
            if(right instanceof Integer){
                operands.push((Integer)left <= (Integer)right);
            }else{
                operands.push((Integer)left <= (Float)right);
            }
        }else{
            if(right instanceof Integer){
                operands.push((Float)left <= (Integer)right);
            }else{
                operands.push((Float)left <= (Float)right);
            }
        }
    }

    @Override
    public void visit(Equal e) {
        e.getLeft().accept(this);
        Object exp = operands.pop();
        Object left = returnValue(exp);

        e.getRight().accept(this);
        Object exp2 = operands.pop();
        Object right = returnValue(exp2);
        
        if(left instanceof Integer){
            operands.push((Integer)left == (Integer)right);
        }else if(left instanceof Float){
            operands.push((Float)left == (Float)right);
        }else if(left instanceof Boolean){
            operands.push((Boolean)left == (Boolean)right);
        }else{
            operands.push((Character)left == (Character)right);
        }
    }

    @Override
    public void visit(Dif e) {
        e.getLeft().accept(this);
        Object exp = operands.pop();
        Object left = returnValue(exp);

        e.getRight().accept(this);
        Object exp2 = operands.pop();
        Object right = returnValue(exp2);
        
        if(left instanceof Integer){
            operands.push((Integer)left != (Integer)right);
        }else if(left instanceof Float){
            operands.push((Float)left != (Float)right);
        }else if(left instanceof Boolean){
            operands.push((Boolean)left != (Boolean)right);
        }else{
            operands.push((Character)left != (Character)right);
        }
    }

    @Override
    public void visit(And e) {
        e.getLeft().accept(this);
        Object exp = operands.pop();
        Object left = returnValue(exp);

        e.getRight().accept(this);
        Object exp2 = operands.pop();
        Object right = returnValue(exp2);
        
        operands.push((Boolean)left == (Boolean)right);
    }

    @Override
    public void visit(Attr e) {

        e.getExp().accept(this);
        e.getVar().accept(this);

        String variableName = (String) operands.pop();

        Object value = null;
        value = operands.pop();
        if (this.isBlock) {

            env.peek().put(variableName, value);

        } else {

            globalCtx.put(variableName, value);

        }

    }

    @Override
    public <T> void visit(LiteralValue<T> e) {
        operands.push(e.getValue());

    }

    @Override
    public void visit(StmtList stmtList){
        stmtList.getStmt().accept(this);

        if(stmtList.getStmtList() != null){
            stmtList.getStmtList().accept(this);
        }
    }

    @Override
    public void visit(IfElse ifelse){
        boolean interior = false;

        if(this.isBlock){
            interior = true;
            HashMap<String, Object> localEnv = new HashMap<>();
            env.peek().put("if",localEnv);
        }else{
            this.isBlock = true;
            HashMap<String, Object> localEnv = new HashMap<>();
            env.push(localEnv);
            this.isBlock = true;
        }

        ifelse.getExp().accept(this);
        Object exp = operands.pop();

        if(env.peek().get(exp) != null){
            exp = env.peek().get(exp);
        }else if(globalCtx.get(exp) != null){
            exp = globalCtx.get(exp);
        }

        if((boolean)exp){
            ifelse.getStmtList1().accept(this);
        }else{
            if(ifelse.getStmtList2() != null){
                ifelse.getStmtList2().accept(this);
            }
        }

        if(interior){
            env.peek().remove("if");
        }else{
            this.isBlock = false;
            env.pop();
        }
    }

    @Override
    public void visit(Iterate iterate){
        //System.out.println("Entrou no iterate");
        this.isBlock = true;

        HashMap<String, Object> localEnv = new HashMap<>();
        env.push(localEnv);

        iterate.getExp().accept(this);
        iterate.getStmt().accept(this);

        env.pop();
        this.isBlock = false;
    }

    @Override
    public void visit(Ret ret){
        //System.out.println("Entrou no ret");

        ret.getExp().accept(this);

        if(ret.getRet() != null){
            ret.getRet().accept(this);
        }

    }

    @Override
    public void visit(GenRet genret){
        //System.out.println("Entrou no gen ret");

        if(this.isBlock){
            genret.getRet().accept(this);
        }else{
            //System.out.println("Erro: return chamado fora de um bloco");
        }
    }

    @Override
    public void visit(Print print) {
        print.getExp().accept(this);

        Object exp = operands.pop();
        
        if(this.isBlock){
            if(env.peek().get(exp) != null){
                Object var = env.peek().get(exp);
                if(env.peek().get(var) != null){
                    System.out.println(env.peek().get(var));
                }else{
                    System.out.println(env.peek().get(exp));
                }
            }else{
                System.out.println(exp);
            }
            
        }else{
            if(globalCtx.get(exp) != null){
                Object var = globalCtx.get(exp);
                if(globalCtx.get(var) != null){
                    System.out.println(globalCtx.get(var));
                }else{
                    System.out.println(globalCtx.get(exp));
                }
            }else{
                System.out.println(exp);
            }
        }
    }

    @Override
    public void visit(Var e) {

        Object var;

        if (isBlock) {
            var = env.peek().get(e.getName());

            if (var != null) {
                //System.out.println("Valor adicionado a pilha operands: " + e.getName());
                operands.push(e.getName());

            } else {
                //System.out.println("Valor adicionado a pilha operands e ao envLocal: " + e.getName());
                env.peek().put(e.getName(), null);
                operands.push(e.getName());
            }
        } else {
            var = globalCtx.get(e.getName());

            if (var != null) {
                //System.out.println("Var adicionado a pilha operands: " + e.getName());
                operands.push(e.getName());

            } else {
                //System.out.println("Var adicionado a pilha operands e ao global: " + e.getName());
                globalCtx.put(e.getName(), null);
                operands.push(e.getName());
            }

        }

    }

    @Override
    public void visit(Func e) {
        System.out.println(e);
        this.isBlock = true;

        HashMap<String, Object> localEnv = new HashMap<>();

        globalCtx.put(e.getIdentifier().getName(), e);
        env.push(localEnv);
        //System.out.println("Func " + e.getIdentifier().getName() + " adicionado ao escopo Global");

        if(e.getParam() != null){
            e.getParam().accept(this);
        }
        
        e.getBody().accept(this);
        env.pop();
        this.isBlock = false;
    }

    @Override
    public void visit(Num e) {
        //System.out.println("Valor adicionado a pilha: " + e.getValue());
        operands.push(e.getValue());

    }

    @Override
    public void visit(Exp e) {

    }

}