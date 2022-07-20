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
        int left, right;
        if (envLocal.peek() instanceof Integer) {
            left = (int) envLocal.pop();

        } else {
            left = (int) variablesValues.get((String) (envLocal.pop()));
        }

        e.getRight().accept(this);
        if(envLocal.peek() instanceof Integer){
            right = (int) envLocal.pop();
        }else{
            right = (int) variablesValues.get((String) (envLocal.pop()));
        }
        
        envLocal.push(left + right);
    }

    public void visit(Sub e) {
        System.out.println("Entrei Sub");
        e.getLeft().accept(this);
        int left, right;
        if (envLocal.peek() instanceof Integer) {
            left = (int) envLocal.pop();

        } else {
            left = (int) variablesValues.get((String) (envLocal.pop()));
        }

        e.getRight().accept(this);
        if(envLocal.peek() instanceof Integer){
            right = (int) envLocal.pop();
        }else{
            right = (int) variablesValues.get((String) (envLocal.pop()));
        }
        
        envLocal.push(left - right);
    }

    public void visit(Mult e) {
        System.out.println("Entrei Mult");
        e.getLeft().accept(this);
        int left, right;
        if (envLocal.peek() instanceof Integer) {
            left = (int) envLocal.pop();

        } else {
            left = (int) variablesValues.get((String) (envLocal.pop()));
        }

        e.getRight().accept(this);
        if(envLocal.peek() instanceof Integer){
            right = (int) envLocal.pop();
        }else{
            right = (int) variablesValues.get((String) (envLocal.pop()));
        }
        
        envLocal.push(left * right);
    }

    public void visit(Div e) {
        System.out.println("Entrei Div");
        e.getLeft().accept(this);
        int left, right;
        if (envLocal.peek() instanceof Integer) {
            left = (int) envLocal.pop();

        } else {
            left = (int) variablesValues.get((String) (envLocal.pop()));
        }

        e.getRight().accept(this);
        if(envLocal.peek() instanceof Integer){
            right = (int) envLocal.pop();
        }else{
            right = (int) variablesValues.get((String) (envLocal.pop()));
        }
        
        envLocal.push(left / right);
    }

    public void visit(Res e) {
        System.out.println("Entrei Res");
        e.getLeft().accept(this);
        int left, right;
        if (envLocal.peek() instanceof Integer) {
            left = (int) envLocal.pop();

        } else {
            left = (int) variablesValues.get((String) (envLocal.pop()));
        }

        e.getRight().accept(this);
        if(envLocal.peek() instanceof Integer){
            right = (int) envLocal.pop();
        }else{
            right = (int) variablesValues.get((String) (envLocal.pop()));
        }
        
        envLocal.push(left % right);
    }

    public void visit(Greater e) {
        System.out.println("Entrei Greater");
        e.getLeft().accept(this);
        int left, right;
        if (envLocal.peek() instanceof Integer) {
            left = (int) envLocal.pop();

        } else {
            left = (int) variablesValues.get((String) (envLocal.pop()));
        }

        e.getRight().accept(this);
        if(envLocal.peek() instanceof Integer){
            right = (int) envLocal.pop();
        }else{
            right = (int) variablesValues.get((String) (envLocal.pop()));
        }
        
        envLocal.push(left > right);
    }

    public void visit(Lesser e) {
        System.out.println("Entrei Lesser");
        e.getLeft().accept(this);
        int left, right;
        if (envLocal.peek() instanceof Integer) {
            left = (int) envLocal.pop();

        } else {
            left = (int) variablesValues.get((String) (envLocal.pop()));
        }

        e.getRight().accept(this);
        if(envLocal.peek() instanceof Integer){
            right = (int) envLocal.pop();
        }else{
            right = (int) variablesValues.get((String) (envLocal.pop()));
        }
        
        envLocal.push(left < right);
    }

    public void visit(GreaterEqual e) {
        System.out.println("Entrei GreaterEqual");
        e.getLeft().accept(this);
        int left, right;
        if (envLocal.peek() instanceof Integer) {
            left = (int) envLocal.pop();

        } else {
            left = (int) variablesValues.get((String) (envLocal.pop()));
        }

        e.getRight().accept(this);
        if(envLocal.peek() instanceof Integer){
            right = (int) envLocal.pop();
        }else{
            right = (int) variablesValues.get((String) (envLocal.pop()));
        }
        
        envLocal.push(left >= right);
    }

    public void visit(LesserEqual e) {
        System.out.println("Entrei LesserEqual");
        e.getLeft().accept(this);
        int left, right;
        if (envLocal.peek() instanceof Integer) {
            left = (int) envLocal.pop();

        } else {
            left = (int) variablesValues.get((String) (envLocal.pop()));
        }

        e.getRight().accept(this);
        if(envLocal.peek() instanceof Integer){
            right = (int) envLocal.pop();
        }else{
            right = (int) variablesValues.get((String) (envLocal.pop()));
        }
        
        envLocal.push(left <= right);
    }

    public void visit(Equal e) {
        System.out.println("Entrei Equal");
        e.getLeft().accept(this);
        int left, right;
        if (envLocal.peek() instanceof Integer) {
            left = (int) envLocal.pop();

        } else {
            left = (int) variablesValues.get((String) (envLocal.pop()));
        }

        e.getRight().accept(this);
        if(envLocal.peek() instanceof Integer){
            right = (int) envLocal.pop();
        }else{
            right = (int) variablesValues.get((String) (envLocal.pop()));
        }
        
        envLocal.push(left == right);
    }

    public void visit(Dif e) {
        System.out.println("Entrei Dif");
        e.getLeft().accept(this);
        int left, right;
        if (envLocal.peek() instanceof Integer) {
            left = (int) envLocal.pop();

        } else {
            left = (int) variablesValues.get((String) (envLocal.pop()));
        }

        e.getRight().accept(this);
        if(envLocal.peek() instanceof Integer){
            right = (int) envLocal.pop();
        }else{
            right = (int) variablesValues.get((String) (envLocal.pop()));
        }
        
        envLocal.push(left != right);
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
        boolean flag = false;

        if(envLocal.peek() instanceof Boolean || envLocal.peek() instanceof Integer || envLocal.peek() instanceof Float){
            System.out.println(envLocal.pop());

        }else if(envLocal.peek() instanceof String){

            for(int i = 0; i < variables.size(); i++){
                if(variables.get(i).equals(envLocal.peek())) {
                    System.out.println(variablesValues.get(envLocal.pop()));
                    flag = true;
                }
            }

            if(!flag){
                System.out.println(envLocal.pop());
            }
        }
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