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
        int left = (int) variablesValues.get((String) (envLocal.pop()));
        e.getRight().accept(this);
        int right = (int) variablesValues.get((String) (envLocal.pop()));

        envLocal.push(left + right);

    }

    public void visit(Attr e) {
        System.out.println(e.toString());
        e.getExp().accept(this);

        if (variables.size() == 0) {
            e.getVar().accept(this);
            String variableName = (String) envLocal.pop();
            System.out.println("Valor removido da pilha: " + variableName);
            int value = (int) envLocal.pop();
            System.out.println("Valor removido da pilha: " + value);

            variablesValues.put(variableName, value);

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
                int value = (int) envLocal.pop();
                System.out.println("Valor removido da pilha: " + value);
                variablesValues.put(variableName, value);
            }
        }

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
