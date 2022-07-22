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

    public void visit(Prog prog) {

        prog.getCommand1().accept(this);
        if (prog.getCommand2() != null) {
            prog.getCommand2().accept(this);
        }
    }

    public void visit(Add e) {
        System.out.println("Entrei ADD");

        Object left = null, right = null;

        Integer leftInt = null, rightInt = null;
        Float leftFloat = null, rightFloat = null;

        e.getLeft().accept(this);

        System.out.println("Valor left : " + (operands.peek()));
        if (operands.peek() instanceof Integer || operands.peek() instanceof Float) {
            left = operands.pop();

        } else if (globalCtx.get((operands.peek())) instanceof Integer
                || globalCtx.get((operands.peek())) instanceof Float) {
            left = globalCtx.get((String) (operands.pop()));

        } else if (env.peek().get((operands.peek())) instanceof Integer
                || env.peek().get((operands.peek())) instanceof Float) {
            left = env.peek().get((String) (operands.pop()));
        }

        e.getRight().accept(this);
        System.out.println("Valor right : " + (operands.peek()));
        if (operands.peek() instanceof Integer || operands.peek() instanceof Float) {
            right = operands.pop();

        } else if (globalCtx.get((operands.peek())) instanceof Integer
                || globalCtx.get((operands.peek())) instanceof Float) {
            right = globalCtx.get((String) (operands.pop()));

        } else if (env.peek().get((operands.peek())) instanceof Integer
                || env.peek().get((operands.peek())) instanceof Float) {
            right = env.peek().get((String) (operands.pop()));
        }

        if (left instanceof Integer && right instanceof Integer) {
            System.out.println("Valor add : " + ((Integer) left + (Integer) right));
            operands.push((Integer) left + (Integer) right);
        } else if (left instanceof Integer && rightFloat instanceof Float) {
            System.out.println("Valor add : " + ((Integer) left + (Float) right));
            operands.push((Integer) left + (Float) right);
        } else if (left instanceof Float && right instanceof Integer) {
            System.out.println("Valor add : " + ((Float) left + (Integer) right));
            operands.push((Float) left + (Integer) right);
        } else if (left instanceof Float && right instanceof Float) {
            System.out.println("Valor add : " + ((Float) left + (Float) right));
            operands.push((Float) left + (Float) right);
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

    public void visit(Print print) {
        print.getExp().accept(this);

        Object exp = operands.pop();

        if (this.isBlock) {
            if (env.peek().get(exp) != null) {
                Object var = env.peek().get(exp);
                if (env.peek().get(var) != null) {
                    System.out.println(env.peek().get(var));
                } else {
                    System.out.println(env.peek().get(exp));
                }
            } else {
                System.out.println(exp);
            }

        } else {
            if (globalCtx.get(exp) != null) {
                Object var = globalCtx.get(exp);
                if (globalCtx.get(var) != null) {
                    System.out.println(globalCtx.get(var));
                } else {
                    System.out.println(globalCtx.get(exp));
                }
            } else {
                System.out.println(exp);
            }
        }
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
    public void visit(Exp e) {

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

        e.getParam().accept(this);

        e.getBody().accept(this);
        env.pop();
        this.isBlock = false;

    }

    @Override
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

    public void visit(StmtList e) {
        System.out.println("Entrou no StmtList");

        if (this.isBlock) {
            e.getStmt().accept(this);

            if (e.getStmtList() != null) {
                e.getStmtList().accept(this);
            }
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