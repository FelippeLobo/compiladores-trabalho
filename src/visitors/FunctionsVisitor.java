package src.visitors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import src.ast.*;

public class FunctionsVisitor extends Visitor {

    private Stack<Object> envLocal;
    private HashMap<String, Object> variablesValues;
    private List<String> variables;

    public FunctionsVisitor() {
        variablesValues = new HashMap<>();
        variables = new ArrayList<>();
        envLocal = new Stack<>();
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

        if (envLocal.peek() instanceof Integer) {
            leftInt = (int) envLocal.pop();

        } else if (envLocal.peek() instanceof Float) {
            leftFloat = (float) envLocal.pop();

        } else if (variablesValues.get((String) (envLocal.peek())) instanceof Integer) {
            leftInt = (int) variablesValues.get((String) (envLocal.pop()));

        } else if (variablesValues.get((String) (envLocal.peek())) instanceof Float) {
            leftFloat = (float) variablesValues.get((String) (envLocal.pop()));
        }

        e.getRight().accept(this);
        if (envLocal.peek() instanceof Integer) {
            rightInt = (int) envLocal.pop();

        } else if (envLocal.peek() instanceof Float) {
            rightFloat = (float) envLocal.pop();

        } else if (variablesValues.get((String) (envLocal.peek())) instanceof Integer) {
            rightInt = (int) variablesValues.get((String) (envLocal.pop()));

        } else if (variablesValues.get((String) (envLocal.peek())) instanceof Float) {
            rightFloat = (float) variablesValues.get((String) (envLocal.pop()));
        }

        if (leftInt != null && rightInt != null) {
            envLocal.push(leftInt + rightInt);
        } else if (leftInt != null && rightFloat != null) {
            envLocal.push(leftInt + rightFloat);
        } else if (leftFloat != null && rightInt != null) {
            envLocal.push(leftFloat + rightInt);
        } else if (leftFloat != null && rightFloat != null) {
            envLocal.push(leftFloat + rightFloat);
        }

    }

    public void visit(Attr e) {
        System.out.println(e.toString());
        e.getExp().accept(this);
        
        if (variables.size() == 0) {
            e.getVar().accept(this);
            String variableName = (String) envLocal.pop();
            System.out.println("Valor removido da pilha: " + variableName);
            Integer valueInt=null;
            Float valueFloat=null;
            if (envLocal.peek() instanceof Integer) {
                valueInt = (int) envLocal.pop();
                System.out.println("Valor removido da pilha: " + valueInt);
                variablesValues.put(variableName, valueInt);
            } else if (envLocal.peek() instanceof Float) {
               valueFloat = (float) envLocal.pop(); 
               System.out.println("Valor removido da pilha: " + valueFloat);
               variablesValues.put(variableName, valueFloat);
            }

        } else {
            boolean flag = false;
            for (int i = 0; i < variables.size(); i++) {
                if (variables.get(i).equals(e.getVar().getName())) {
                    e.getVar().accept(this);
                    variablesValues.put(e.getVar().getName(), envLocal.pop());
                    flag = true;
                }
            }
            if (!flag) {
                e.getVar().accept(this);
                String variableName = (String) envLocal.pop();
                System.out.println("Valor removido da pilha: " + variableName);
                Integer valueInt=null;
                Float valueFloat=null;
                if (envLocal.peek() instanceof Integer) {
                    valueInt = (int) envLocal.pop();
                    System.out.println("Valor removido da pilha: " + valueInt);
                    variablesValues.put(variableName, valueInt);
                } else if (envLocal.peek() instanceof Float) {
                   valueFloat = (float) envLocal.pop(); 
                   System.out.println("Valor removido da pilha: " + valueFloat);
                   variablesValues.put(variableName, valueFloat);
                }


              
            }
        }

    }

    public <T> void visit(LiteralValue<T> e) {
        System.out.println("Valor adicionado a pilha: " + e.getValue());
        envLocal.push(e.getValue());

    }

    public void visit(Print e) {
        e.getExp().accept(this);
        System.out.println(variablesValues.get(envLocal.pop()));
    }

    @Override
    public void visit(Var e) {

        boolean flag = false;
        for (int i = 0; i < variables.size(); i++) {
            if (variables.get(i).equals(e.getName())) {

                flag = true;
                System.out.println("Valor adicionado a pilha: " + e.getName());
                envLocal.push(e.getName());

            }
        }
        if (!flag) {
            variables.add(e.getName());
            System.out.println("Valor adicionado a pilha: " + e.getName());
            envLocal.push(e.getName());

        }

    }

    @Override
    public void visit(Num e) {
        System.out.println("Valor adicionado a pilha: " + e.getValue());
        envLocal.push(e.getValue());

    }

    @Override
    public void visit(Exp e) {

    }

}