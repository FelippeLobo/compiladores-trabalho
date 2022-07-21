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

    public void visit(Prog prog) {

        prog.getCommand1().accept(this);
        if (prog.getCommand2() != null) {
            prog.getCommand2().accept(this);
        }
    }

    public void visit(Add e) {
        System.out.println("Entrei ADD");
        e.getLeft().accept(this);
        Integer leftInt = null, rightInt = null;
        Float leftFloat = null, rightFloat = null;

        if (operands.peek() instanceof Integer) {
            leftInt = (int) operands.pop();

        } else if (operands.peek() instanceof Float) {
            leftFloat = (float) operands.pop();

        } else if (globalCtx.get((String) (operands.peek())) instanceof Integer) {
            leftInt = (int) globalCtx.get((String) (operands.pop()));

        } else if (globalCtx.get((String) (operands.peek())) instanceof Float) {
            leftFloat = (float) globalCtx.get((String) (operands.pop()));
        }

        e.getRight().accept(this);
        if (operands.peek() instanceof Integer) {
            rightInt = (int) operands.pop();

        } else if (operands.peek() instanceof Float) {
            rightFloat = (float) operands.pop();

        } else if (globalCtx.get((String) (operands.peek())) instanceof Integer) {
            rightInt = (int) globalCtx.get((String) (operands.pop()));

        } else if (globalCtx.get((String) (operands.peek())) instanceof Float) {
            rightFloat = (float) globalCtx.get((String) (operands.pop()));
        }

        if (leftInt != null && rightInt != null) {
            operands.push(leftInt + rightInt);
        } else if (leftInt != null && rightFloat != null) {
            operands.push(leftInt + rightFloat);
        } else if (leftFloat != null && rightInt != null) {
            operands.push(leftFloat + rightInt);
        } else if (leftFloat != null && rightFloat != null) {
            operands.push(leftFloat + rightFloat);
        }

    }

    public void visit(Sub e) {
        System.out.println("Entrei Sub");
        e.getLeft().accept(this);
        int left, right;
        if (operands.peek() instanceof Integer) {
            left = (int) operands.pop();

        } else {
            left = (int) globalCtx.get((String) (operands.pop()));
        }

        e.getRight().accept(this);
        if (operands.peek() instanceof Integer) {
            right = (int) operands.pop();
        } else {
            right = (int) globalCtx.get((String) (operands.pop()));
        }

        operands.push(left - right);
    }

    public void visit(Attr e) {
        System.out.println(e.toString());

        e.getExp().accept(this);
        e.getVar().accept(this);

        String variableName = (String) operands.pop();
        System.out.println("Valor removido da pilha operands: " + variableName);

        Object value = null;
        value = operands.pop();
        if (this.isBlock) {

            System.out.println("Valor removido da pilha operands e adicionada ao  env " + value);
            env.peek().put(variableName, value);

        } else {

            System.out.println("Valor removido da pilha operands e adicionada ao globalCtx: " + value);
            globalCtx.put(variableName, value);

        }

    }

    public <T> void visit(LiteralValue<T> e) {
        System.out.println("Valor adicionado a pilha: " + e.getValue());
        operands.push(e.getValue());

    }

    public void visit(Print e) {
        e.getExp().accept(this);
        System.out.println(globalCtx.get(operands.pop()));
    }

    @Override
    public void visit(Var e) {

        Object var;

        if (isBlock) {
            var = env.peek().get(e.getName());

            if (var != null) {
                System.out.println("Valor adicionado a pilha operands: " + e.getName());
                operands.push(e.getName());

            } else {
                System.out.println("Valor adicionado a pilha operands e ao envLocal: " + e.getName());
                env.peek().put(e.getName(), null);
                operands.push(e.getName());
            }
        } else {
            var = globalCtx.get(e.getName());

            if (var != null) {
                System.out.println("Var adicionado a pilha operands: " + e.getName());
                operands.push(e.getName());

            } else {
                System.out.println("Var adicionado a pilha operands e ao global: " + e.getName());
                globalCtx.put(e.getName(), null);
                operands.push(e.getName());
            }

        }

    }

    @Override
    public void visit(Type e) {

        Object type;
        
        type = globalCtx.get(e.getName());

            if (type != null) {
                System.out.println("Tipo adicionado a pilha operands: " + e.getName());
                operands.push(e.getName());

            } else {
                System.out.println("Tipo adicionado a pilha operands e ao global: " + e.getName());
                globalCtx.put(e.getName(), null);
                operands.push(e.getName());
            }
        
    }

    @Override
    public void visit(Num e) {
        System.out.println("Valor adicionado a pilha: " + e.getValue());
        operands.push(e.getValue());

    }

    @Override
    public void visit(Exp e) {

    }

    @Override
    public void visit(Decl decl) {
        if (this.isBlock) {
            decl.getType().accept(this);
            decl.getIdentifier().accept(this);

            String variableName = (String) operands.pop();
            System.out.println("Var removido da pilha operands: " + variableName);

            Object value = null;
            value = operands.pop();
            System.out.println("Tipo removido da pilha operands: " + value);
            env.peek().put(variableName, value);

            if(decl.getDecl() != null){
                decl.getDecl().accept(this);
            }
        }
    }

    @Override
    public void visit(Data data) {
        System.out.println(data);
        this.isBlock = true;

        HashMap<String, Object> localEnv = new HashMap<>();

        globalCtx.put(data.getIdentifier().getName(), data);
        env.push(localEnv);
        System.out.println("Data " + data.getIdentifier().getName() +" adicionado ao escopo Global");

        data.getDecl().accept(this);

        env.pop();
        this.isBlock = false;

    }



}