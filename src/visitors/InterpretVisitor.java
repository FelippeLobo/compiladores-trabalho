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
            operands.push(leftInt - rightInt);
        } else if (leftInt != null && rightFloat != null) {
            operands.push(leftInt - rightFloat);
        } else if (leftFloat != null && rightInt != null) {
            operands.push(leftFloat - rightInt);
        } else if (leftFloat != null && rightFloat != null) {
            operands.push(leftFloat - rightFloat);
        }
    }

    public void visit(Mult e) {
        System.out.println("Entrei Mult");
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
            operands.push(leftInt * rightInt);
        } else if (leftInt != null && rightFloat != null) {
            operands.push(leftInt * rightFloat);
        } else if (leftFloat != null && rightInt != null) {
            operands.push(leftFloat * rightInt);
        } else if (leftFloat != null && rightFloat != null) {
            operands.push(leftFloat * rightFloat);
        }
    }

    public void visit(Div e) {
        System.out.println("Entrei Div");
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
            operands.push(leftInt / rightInt);
        } else if (leftInt != null && rightFloat != null) {
            operands.push(leftInt / rightFloat);
        } else if (leftFloat != null && rightInt != null) {
            operands.push(leftFloat / rightInt);
        } else if (leftFloat != null && rightFloat != null) {
            operands.push(leftFloat / rightFloat);
        }
    }

    public void visit(Res e) {
        System.out.println("Entrei Res");
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
            operands.push(leftInt % rightInt);
        } else if (leftInt != null && rightFloat != null) {
            operands.push(leftInt % rightFloat);
        } else if (leftFloat != null && rightInt != null) {
            operands.push(leftFloat % rightInt);
        } else if (leftFloat != null && rightFloat != null) {
            operands.push(leftFloat % rightFloat);
        }
    }

    public void visit(Greater e) {
        System.out.println("Entrei Greater");
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
            operands.push(leftInt > rightInt);
        } else if (leftInt != null && rightFloat != null) {
            operands.push(leftInt > rightFloat);
        } else if (leftFloat != null && rightInt != null) {
            operands.push(leftFloat > rightInt);
        } else if (leftFloat != null && rightFloat != null) {
            operands.push(leftFloat > rightFloat);
        }
    }

    public void visit(Lesser e) {
        System.out.println("Entrei Lesser");
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
            operands.push(leftInt < rightInt);
        } else if (leftInt != null && rightFloat != null) {
            operands.push(leftInt < rightFloat);
        } else if (leftFloat != null && rightInt != null) {
            operands.push(leftFloat < rightInt);
        } else if (leftFloat != null && rightFloat != null) {
            operands.push(leftFloat < rightFloat);
        }
    }

    public void visit(GreaterEqual e) {
        System.out.println("Entrei GreaterEqual");
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
            operands.push(leftInt >= rightInt);
        } else if (leftInt != null && rightFloat != null) {
            operands.push(leftInt >= rightFloat);
        } else if (leftFloat != null && rightInt != null) {
            operands.push(leftFloat >= rightInt);
        } else if (leftFloat != null && rightFloat != null) {
            operands.push(leftFloat >= rightFloat);
        }
    }

    public void visit(LesserEqual e) {
        System.out.println("Entrei LesserEqual");
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
            operands.push(leftInt <= rightInt);
        } else if (leftInt != null && rightFloat != null) {
            operands.push(leftInt <= rightFloat);
        } else if (leftFloat != null && rightInt != null) {
            operands.push(leftFloat <= rightInt);
        } else if (leftFloat != null && rightFloat != null) {
            operands.push(leftFloat <= rightFloat);
        }
    }

    public void visit(Equal e) {
        System.out.println("Entrei Equal");
        e.getLeft().accept(this);
        Integer leftInt = null, rightInt = null;
        Float leftFloat = null, rightFloat = null;
        Boolean leftBool = null, rightBool = null;
        Character leftChar = null, rightChar = null;

        if (operands.peek() instanceof Integer) {
            leftInt = (int) operands.pop();

        } else if (operands.peek() instanceof Float) {
            leftFloat = (float) operands.pop();

        } else if (operands.peek() instanceof Boolean) {
            leftBool = (boolean) operands.pop();

        } else if (operands.peek() instanceof Character) {
            leftChar = (char) operands.pop();

        } else if (globalCtx.get((String) (operands.peek())) instanceof Integer) {
            leftInt = (int) globalCtx.get((String) (operands.pop()));

        } else if (globalCtx.get((String) (operands.peek())) instanceof Float) {
            leftFloat = (float) globalCtx.get((String) (operands.pop()));

        } else if (globalCtx.get((String) (operands.peek())) instanceof Boolean) {
            leftBool = (boolean) globalCtx.get((String) (operands.pop()));

        } else if (globalCtx.get((String) (operands.peek())) instanceof Character) {
            leftChar = (char) globalCtx.get((String) (operands.pop()));
        }
    
        e.getRight().accept(this);
        if (operands.peek() instanceof Integer) {
            rightInt = (int) operands.pop();

        } else if (operands.peek() instanceof Float) {
            rightFloat = (float) operands.pop();

        } else if (operands.peek() instanceof Boolean) {
            rightBool = (boolean) operands.pop();

        } else if (operands.peek() instanceof Character) {
            rightChar = (char) operands.pop();

        } else if (globalCtx.get((String) (operands.peek())) instanceof Integer) {
            rightInt = (int) globalCtx.get((String) (operands.pop()));

        } else if (globalCtx.get((String) (operands.peek())) instanceof Float) {
            rightFloat = (float) globalCtx.get((String) (operands.pop()));

        } else if (globalCtx.get((String) (operands.peek())) instanceof Boolean) {
            rightBool = (boolean) globalCtx.get((String) (operands.pop()));

        } else if (globalCtx.get((String) (operands.peek())) instanceof Character) {
            rightChar = (char) globalCtx.get((String) (operands.pop()));
        }

        if (leftInt != null && rightInt != null) {
            operands.push(leftInt == rightInt);
        } else if (leftFloat != null && rightFloat != null) {
            operands.push(leftFloat == rightFloat);
        } else if (leftBool != null && rightBool != null) {
            operands.push(leftBool == rightBool);
        } else if (leftChar != null && rightChar != null) {
            operands.push(leftChar== rightChar);
        }
    }

    public void visit(Dif e) {
        System.out.println("Entrei Dif");
        e.getLeft().accept(this);
        Integer leftInt = null, rightInt = null;
        Float leftFloat = null, rightFloat = null;
        Boolean leftBool = null, rightBool = null;
        Character leftChar = null, rightChar = null;

        if (operands.peek() instanceof Integer) {
            leftInt = (int) operands.pop();

        } else if (operands.peek() instanceof Float) {
            leftFloat = (float) operands.pop();

        } else if (operands.peek() instanceof Boolean) {
            leftBool = (boolean) operands.pop();

        } else if (operands.peek() instanceof Character) {
            leftChar = (char) operands.pop();

        } else if (globalCtx.get((String) (operands.peek())) instanceof Integer) {
            leftInt = (int) globalCtx.get((String) (operands.pop()));

        } else if (globalCtx.get((String) (operands.peek())) instanceof Float) {
            leftFloat = (float) globalCtx.get((String) (operands.pop()));

        } else if (globalCtx.get((String) (operands.peek())) instanceof Boolean) {
            leftBool = (boolean) globalCtx.get((String) (operands.pop()));

        } else if (globalCtx.get((String) (operands.peek())) instanceof Character) {
            leftChar = (char) globalCtx.get((String) (operands.pop()));
        }
    
        e.getRight().accept(this);
        if (operands.peek() instanceof Integer) {
            rightInt = (int) operands.pop();

        } else if (operands.peek() instanceof Float) {
            rightFloat = (float) operands.pop();

        } else if (operands.peek() instanceof Boolean) {
            rightBool = (boolean) operands.pop();

        } else if (operands.peek() instanceof Character) {
            rightChar = (char) operands.pop();

        } else if (globalCtx.get((String) (operands.peek())) instanceof Integer) {
            rightInt = (int) globalCtx.get((String) (operands.pop()));

        } else if (globalCtx.get((String) (operands.peek())) instanceof Float) {
            rightFloat = (float) globalCtx.get((String) (operands.pop()));

        } else if (globalCtx.get((String) (operands.peek())) instanceof Boolean) {
            rightBool = (boolean) globalCtx.get((String) (operands.pop()));

        } else if (globalCtx.get((String) (operands.peek())) instanceof Character) {
            rightChar = (char) globalCtx.get((String) (operands.pop()));
        }

        if (leftInt != null && rightInt != null) {
            operands.push(leftInt != rightInt);
        } else if (leftFloat != null && rightFloat != null) {
            operands.push(leftFloat != rightFloat);
        } else if (leftBool != null && rightBool != null) {
            operands.push(leftBool != rightBool);
        } else if (leftChar != null && rightChar != null) {
            operands.push(leftChar != rightChar);
        }
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

    public void visit(StmtList stmtList){
        System.out.println("Entrou no StmtList");

        if (this.isBlock) {
            stmtList.getStmt().accept(this);

            if(stmtList.getStmtList() != null){
                stmtList.getStmtList().accept(this);
            }
        }
    }

    public void visit(IfElse ifelse){
        System.out.println("Entrou no ifelse");
        this.isBlock = true;

        HashMap<String, Object> localEnv = new HashMap<>();
        env.push(localEnv);

        ifelse.getExp().accept(this);
        boolean exp = (boolean)operands.pop();

        if(exp){
            ifelse.getStmtList1().accept(this);
        }else{
            if(ifelse.getStmtList2() != null){
                ifelse.getStmtList2().accept(this);
            }
        }

        env.pop();
        this.isBlock = false;
    }

    public void visit(Print print) {
        print.getExp().accept(this);

        Object exp = operands.pop();
        
        if(this.isBlock){
            if(env.peek().get(exp) != null){
                System.out.println(env.peek().get(exp));
            }else{
                System.out.println(exp);
            }
            
        }else{
            if(globalCtx.get(exp) != null){
                System.out.println(globalCtx.get(exp));
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
    public void visit(Num e) {
        System.out.println("Valor adicionado a pilha: " + e.getValue());
        operands.push(e.getValue());

    }

    @Override
    public void visit(Exp e) {

    }

}