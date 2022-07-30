package src.visitors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.Scanner;

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
    public void visit(Not e){
        e.getExp().accept(this);
        Object exp = operands.pop();
        exp = returnValue(exp);

        if(exp instanceof Boolean){
            operands.push(!(boolean)exp);
        }else{
            System.out.println("Erro: a operação Not só aceita um valor booleano");
        }
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
                operands.push((Integer)left - (Integer)right);
            }else{
                operands.push((Integer)left - (Float)right);
            }
        }else{
            if(right instanceof Integer){
                operands.push((Float)left - (Integer)right);
            }else{
                operands.push((Float)left - (Float)right);
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
        System.out.println(e.toString());

        e.getExp().accept(this);
        e.getVar().accept(this);

        String variableName = (String) operands.pop();
        //System.out.println("Valor removido da pilha operands: " + variableName);

        Object value = null;
        value = operands.pop();

        if (this.isBlock) {

            //System.out.println("Valor removido da pilha operands e adicionada ao  env " + value);
            env.peek().put(variableName, value);

        } else {

            //System.out.println("Valor removido da pilha operands e adicionada ao globalCtx: " + value);
            globalCtx.put(variableName, value);

        }

    }

    public <T> void visit(LiteralValue<T> e) {
        System.out.println("Valor adicionado a pilha: " + e.getValue());
        operands.push(e.getValue());

    }

    @Override
    public void visit(Type e) {

        Object type;

        if (isBlock) {
            System.out.println("Tipo adicionado a pilha operands: " + e.getName());
            env.peek().put(e.getName(), e);
            operands.push(e.getName());
        } else {

            type = globalCtx.get(e.getName());

            if (type != null) {

                System.out.println("Tipo adicionado a pilha operands: " + e.getName());
                operands.push(e.getName());

            } else {
                System.out.println("Tipo adicionado a pilha operands e ao global: " + e.getName());
                globalCtx.put(e.getName(), e);
                operands.push(e.getName());
            }

        }

    }

    @Override
    public void visit(Num e) {
        System.out.println("Valor adicionado a pilha: " + e.getValue());
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
        System.out.println("Pop: " + exp.getClass());
        if(globalCtx.get(exp) != null){
            exp = globalCtx.get(exp);
        }else if(env.peek().get(exp) != null){
            exp = env.peek().get(exp);
        }
        

        System.out.println(exp);
        System.out.println(ifelse.getStmtList1().toString());
        if((boolean)exp){
           
            
            ifelse.getStmtList1().accept(this);
        }else{
            if(ifelse.getStmtList2() != null){
                System.out.println(ifelse.getStmtList2().toString());
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
    public void visit(Iterate e){
        //System.out.println("Entrou no iterate");
        this.isBlock = true;

        e.getExp().accept(this);
        Object exp = operands.pop();
        exp = returnValue(exp);

        System.out.println("Valor do exp: " + exp);

        if(!(exp instanceof Integer)){
            System.out.println("O parâmetro de um iterate deve ser um Int");
            return;
        }
        System.out.println("Passou do if");

        HashMap<String, Object> localEnv = new HashMap<>();
        env.push(localEnv);

        int x = (Integer)exp;
        System.out.println("O valor de X é igual a: " + x);
        int i = 0;
        while(i < x){
            e.getStmt().accept(this);

            i++;
        }

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

        if(print.getExp() == null){
            System.out.println("\n");
            return;
        }

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
    public void visit(Decl e) {
        if (this.isBlock) {
            e.getType().accept(this);
            e.getIdentifier().accept(this);

            String variableName = (String) operands.pop();
            System.out.println("Var removido da pilha operands: " + variableName);

            Object value = null;
            value = operands.pop();
            System.out.println("Tipo removido da pilha operands: " + value);
            env.peek().put(variableName, value);

            if (e.getDecl() != null) {
                e.getDecl().accept(this);
            }
        }
    }

    @Override
    public void visit(Data e) {
        System.out.println(e);
        this.isBlock = true;

        HashMap<String, Object> localEnv = new HashMap<>();

        globalCtx.put(e.getIdentifier().getName(), e);
        env.push(localEnv);
        System.out.println("Data " + e.getIdentifier().getName() + " adicionado ao escopo Global");

        e.getDecl().accept(this);

        env.pop();
        this.isBlock = false;

    }

    @Override
    public void visit(Func e) {
        System.out.println(e);
        this.isBlock = true;

        HashMap<String, Object> localEnv = new HashMap<>();

        globalCtx.put(e.getIdentifier().getIdentifier(), e);
        env.push(localEnv);
        System.out.println("Func " + e.getIdentifier().getIdentifier() + " adicionado ao escopo Global");

        if(e.getParam() != null){
            e.getParam().accept(this);
        }
        
        e.getBody().accept(this);
        env.pop();
        this.isBlock = false;
    }

    @Override
    public void visit(Exp e) {}

    public void visit(Param e) {

        System.out.println("parametro adicionado a pilha operands e ao envLocal: " + e.getIdentifier().getIdentifier());
        env.peek().put(e.getIdentifier().getIdentifier(), e);
    }

    @Override
    public void visit(ParamList e) {

        e.getParam().accept(this);
        if (e.getParamList() != null) {
            e.getParamList().accept(this);
        }

    }

    @Override
    public void visit(Return e) {
        e.getType().accept(this);
        if (e.getReturn() != null) {
            e.getReturn().accept(this);
        }

    }

    @Override
    public void visit(Lvalue e) {
        Object lvalue;

        if (e.getLvalue() != null) {
            e.getLvalue().accept(this);
        }

        if (e.getIdentifier() != null) {

            if (isBlock) {
                lvalue = env.peek().get(e.getIdentifier());

                if (lvalue != null) {
                    System.out.println("Lvalue adicionado a pilha operands: " + e.getIdentifier());
                    operands.push(e.getIdentifier());

                } else {
                    System.out.println("Lvalue adicionado a pilha operands e ao envLocal: " + e.getIdentifier());
                    env.peek().put(e.getIdentifier(), e);
                    operands.push(e.getIdentifier());
                }
            } else {
                lvalue = globalCtx.get(e.getIdentifier());

                if (lvalue != null) {
                    System.out.println("Lvalue adicionado a pilha operands: " + e.getIdentifier());
                    operands.push(e.getIdentifier());

                } else {
                    System.out.println("Lvalue adicionado a pilha operands e ao global: " + e.getIdentifier());
                    globalCtx.put(e.getIdentifier(), e);
                    operands.push(e.getIdentifier());
                }

            }
        }

        if (e.getCtx() != null) {
            e.getCtx().accept(this);

            Object tam = null;

            if (operands.peek() instanceof Integer || operands.peek() instanceof Float) {
                tam = operands.pop();

            } else if (globalCtx.get((operands.peek())) instanceof Integer
                    ) {
                tam = globalCtx.get((operands.pop()));

            } else if (env.peek().get((operands.peek())) instanceof Integer
                    ) {
                tam = env.peek().get((String) (operands.pop()));
            }

            Object lvalueName = operands.pop();
            System.out.println("LvalueName " + lvalueName);
            System.out.println("TAM " + tam);
            if (lvalueName instanceof String) {
                if (isBlock) {                 
                   
                    Object[] list = new Object[(Integer)tam];
                    env.peek().get(lvalueName);
                    env.peek().put((String)lvalueName, env.peek().get(lvalueName));

                } else {
                    Object[] list = new Object[(Integer)tam];
                    globalCtx.put((String) lvalueName, list);
                }
            }

        }

    }

    @Override
    public void visit(Read e) {
        e.getLvalue().accept(this);

        Object exp = operands.pop();

        if (this.isBlock) {
            if (env.peek().get(exp) != null) {
                Object var = env.peek().get(exp);
                if (env.peek().get(var) != null) {
                    
                    Scanner myObj = new Scanner(System.in);  
                    System.out.println("Digite valor de ");
                    String read = myObj.nextLine();  

                    env.peek().put((String)var, read);
                } else {

                    Scanner myObj = new Scanner(System.in);  
                    System.out.println("Digite valor de ");
                    String read = myObj.nextLine();  

                    env.peek().put((String)exp, read);
                }
            }
        } else {
            if (globalCtx.get(exp) != null) {
                Object var = globalCtx.get(exp);
                if (globalCtx.get(var) != null) {
                    Scanner myObj = new Scanner(System.in);  
                    System.out.println("Digite valor de ");
                    String read = myObj.nextLine();  
                    globalCtx.put((String)var, read);
                } else {
                    Scanner myObj = new Scanner(System.in);  
                    System.out.println("Digite valor de ");
                    String read = myObj.nextLine();  
                    globalCtx.put((String)exp, read);
                }
            }
        }
    }

    @Override
    public void visit(Inst e) {
        System.out.println(e.toString());
        e.getType().accept(this);
       
    }

}