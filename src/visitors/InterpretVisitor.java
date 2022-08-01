package src.visitors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import javax.sound.sampled.SourceDataLine;

import java.util.Scanner;
import java.util.Set;

import src.ast.*;

public class InterpretVisitor extends Visitor {

    private Stack<Object> operands;
    private Stack<HashMap<String, Object>> env;
    private HashMap<String, Object> globalCtx;
    private HashMap<String, Object> datas;
    private HashMap<String, Object> funcs;
    private boolean isBlock;
    private String lastData;

    public InterpretVisitor() {
        env = new Stack<>();
        globalCtx = new HashMap<>();
        datas = new HashMap<>();
        funcs = new HashMap<>();
        operands = new Stack<>();
        isBlock = false;
        lastData = "";
    }

    @Override
    public void visit(Prog prog) {

        prog.getCommand1().accept(this);
        if (prog.getCommand2() != null) {
            prog.getCommand2().accept(this);
        }
    }

    public Object returnValue(Object exp) {

        if (this.isBlock) {
            Object var = env.peek().get(exp);
            Object global = globalCtx.get(exp);

            if (var != null) {
                if (env.peek().get(var) != null) {
                    return env.peek().get(var);
                } else {
                    return env.peek().get(exp);
                }

            } else {
                if (globalCtx.get(exp) != null) {
                    if (globalCtx.get(global) != null) {
                        return globalCtx.get(global);
                    } else {
                        return globalCtx.get(exp);
                    }
                }
            }

        } else {
            if (globalCtx.get(exp) != null) {
                Object var = globalCtx.get(exp);
                if (globalCtx.get(var) != null) {
                    return globalCtx.get(var);
                } else {
                    return globalCtx.get(exp);
                }
            } else {
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

        if (left instanceof Integer) {
            if (right instanceof Integer) {
                operands.push((Integer) left + (Integer) right);
            } else {
                operands.push((Integer) left + (Float) right);
            }
        } else {
            if (right instanceof Integer) {
                operands.push((Float) left + (Integer) right);
            } else {
                operands.push((Float) left + (Float) right);
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

        if (left instanceof Integer) {
            if (right instanceof Integer) {
                operands.push((Integer) left - (Integer) right);
            } else {
                operands.push((Integer) left - (Float) right);
            }
        } else {
            if (right instanceof Integer) {
                operands.push((Float) left - (Integer) right);
            } else {
                operands.push((Float) left - (Float) right);
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

        if (left instanceof Integer) {
            if (right instanceof Integer) {
                operands.push((Integer) left * (Integer) right);
            } else {
                operands.push((Integer) left * (Float) right);
            }
        } else {
            if (right instanceof Integer) {
                operands.push((Float) left * (Integer) right);
            } else {
                operands.push((Float) left * (Float) right);
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

        if (left instanceof Integer) {
            if (right instanceof Integer) {
                operands.push((Integer) left / (Integer) right);
            } else {
                operands.push((Integer) left / (Float) right);
            }
        } else {
            if (right instanceof Integer) {
                operands.push((Float) left / (Integer) right);
            } else {
                operands.push((Float) left / (Float) right);
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

        if (left instanceof Integer) {
            if (right instanceof Integer) {
                operands.push((Integer) left % (Integer) right);
            } else {
                operands.push((Integer) left % (Float) right);
            }
        } else {
            if (right instanceof Integer) {
                operands.push((Float) left % (Integer) right);
            } else {
                operands.push((Float) left % (Float) right);
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

        if (left instanceof Integer) {
            if (right instanceof Integer) {
                operands.push((Integer) left > (Integer) right);
            } else {
                operands.push((Integer) left > (Float) right);
            }
        } else {
            if (right instanceof Integer) {
                operands.push((Float) left > (Integer) right);
            } else {
                operands.push((Float) left > (Float) right);
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

        if (left instanceof Integer) {
            if (right instanceof Integer) {
                operands.push((Integer) left < (Integer) right);
            } else {
                operands.push((Integer) left < (Float) right);
            }
        } else {
            if (right instanceof Integer) {
                operands.push((Float) left < (Integer) right);
            } else {
                operands.push((Float) left < (Float) right);
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

        if (left instanceof Integer) {
            if (right instanceof Integer) {
                operands.push((Integer) left >= (Integer) right);
            } else {
                operands.push((Integer) left >= (Float) right);
            }
        } else {
            if (right instanceof Integer) {
                operands.push((Float) left >= (Integer) right);
            } else {
                operands.push((Float) left >= (Float) right);
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

        if (left instanceof Integer) {
            if (right instanceof Integer) {
                operands.push((Integer) left <= (Integer) right);
            } else {
                operands.push((Integer) left <= (Float) right);
            }
        } else {
            if (right instanceof Integer) {
                operands.push((Float) left <= (Integer) right);
            } else {
                operands.push((Float) left <= (Float) right);
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

        if (left instanceof Integer) {
            operands.push((Integer) left == (Integer) right);
        } else if (left instanceof Float) {
            operands.push((Float) left == (Float) right);
        } else if (left instanceof Boolean) {
            operands.push((Boolean) left == (Boolean) right);
        } else {
            operands.push((Character) left == (Character) right);
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

        if (left instanceof Integer) {
            operands.push((Integer) left != (Integer) right);
        } else if (left instanceof Float) {
            operands.push((Float) left != (Float) right);
        } else if (left instanceof Boolean) {
            operands.push((Boolean) left != (Boolean) right);
        } else {
            operands.push((Character) left != (Character) right);
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

        operands.push((Boolean) left == (Boolean) right);
    }

    @Override
    public void visit(Attr e) {
        System.out.println(e.toString());

        e.getExp().accept(this);
        e.getVar().accept(this);

        Object variableName = operands.pop();
        // System.out.println("Valor removido da pilha operands: " + variableName);

        Object value = null;
        value = operands.pop();

        if (this.isBlock) {

            // System.out.println("Valor removido da pilha operands e adicionada ao env " +
            // value);
            if (env.peek().get(value) != null) {

                if (env.peek().get(value) instanceof Tupla) {

                    String atribute = (String) variableName; // ATRIBUTO QUE EU QUERO MEXER !!!
                    String lvalue = (String) value; // Lvalue com o atribute
                    value = operands.pop();

                    Object tupla = env.peek().get(lvalue);
                    if (tupla instanceof Tupla) {
                        if (((Tupla) tupla).getObjectData() instanceof HashMap<?, ?>) {
                            System.out.println("Sou Hash");
                            ((Tupla) tupla).putObjectData(atribute, value);
                        } else {
                            System.out.println("Value: " + value);
                            ((Tupla) tupla).setObjectData(value);
                        }
                    }

                } else if (env.peek().get(value) instanceof Tupla[]) {
                    int index = (int) variableName;
                    String lvalue = (String) value;
                    value = operands.pop();

                    Tupla[] tuplas = (Tupla[]) env.peek().get(lvalue);
                    tuplas[index].setObjectData(value);
                    for (int i = 0; i < tuplas.length; i++) {
                        System.out.println(tuplas[i].toString());
                    }
                    env.peek().put(lvalue, tuplas);
                } else {

                    env.peek().put((String) variableName, value);

                }

            } else {

                if (operands.size() > 0 && env.peek().get(operands.peek()) != null) {
                    if (env.peek().get(operands.peek()) instanceof Tupla[]) {

                        String atribute = (String) variableName;
                        int index = (int) value;
                        String lvalue = (String) operands.pop();
                        value = operands.pop();
                        Tupla[] tuplas = (Tupla[]) globalCtx.get(lvalue);

                        for (int i = 0; i < tuplas.length; i++) {
                            System.out.println(tuplas[i].toString());
                        }
                        env.peek().put(lvalue, tuplas);
                    } else {
                        env.peek().put((String) variableName, value);
                    }
                } else {

                    env.peek().put((String) variableName, value);
                }

            }

        } else {

            
            if (globalCtx.get(value) != null) {
                if (globalCtx.get(value) instanceof Tupla) {
                    String atribute = (String) variableName; // ATRIBUTO QUE EU QUERO MEXER !!!
                    String lvalue = (String) value; // Lvalue com o atribute
                    value = operands.pop();

                    Object tupla = globalCtx.get(lvalue);
                    if (tupla instanceof Tupla) {
                        if (((Tupla) tupla).getObjectData() instanceof HashMap<?, ?>) {
                            System.out.println("Sou Hash");
                            ((Tupla) tupla).putObjectData(atribute, value);
                        } else {
                            ((Tupla) tupla).setObjectData(value);
                        }
                    }

                } else if (globalCtx.get(value) instanceof Tupla[]) {

                    int index = (int) variableName;
                    String lvalue = (String) value;
                    value = operands.pop();

                    Tupla[] tuplas = (Tupla[]) globalCtx.get(lvalue);
                    tuplas[index].setObjectData(value);
                    for (int i = 0; i < tuplas.length; i++) {
                        System.out.println(tuplas[i].toString());
                    }
                    globalCtx.put(lvalue, tuplas);
                } else {

                    globalCtx.put((String) variableName, value);

                }

            } else {
                if (operands.size() > 0 && globalCtx.get(operands.peek()) != null) {

                    if (globalCtx.get(operands.peek()) instanceof Tupla[]) {

                        String atribute = (String) variableName;
                        int index = (int) value;
                        String lvalue = (String) operands.pop();
                        value = operands.pop();

                        Tupla[] tuplas = (Tupla[]) globalCtx.get(lvalue);
                        tuplas[0].putObjectData(atribute, value);
                        for (int i = 0; i < tuplas.length; i++) {
                            System.out.println(tuplas[i].toString());
                        }
                        globalCtx.put(lvalue, tuplas);
                    } else {

                        globalCtx.put((String) variableName, value);

                    }
                } else {

                    globalCtx.put((String) variableName, value);
                }
            }
            
        }
    }

    public <T> void visit(LiteralValue<T> e) {

        operands.push(e.getValue());

    }

    @Override
    public void visit(Type e) {

        Object type;

        if (isBlock) {

            operands.push(e.getName());
        } else {

            type = globalCtx.get(e.getName());

            if (type != null) {

                operands.push(e.getName());

            } else {

                operands.push(e.getName());
            }

        }

    }

    @Override
    public void visit(Num e) {

        operands.push(e.getValue());

    }

    @Override
    public void visit(StmtList stmtList) {
        stmtList.getStmt().accept(this);

        if (stmtList.getStmtList() != null) {
            stmtList.getStmtList().accept(this);
        }
    }

    @Override
    public void visit(IfElse ifelse) {
        boolean interior = false;

        if (this.isBlock) {
            interior = true;
            HashMap<String, Object> localEnv = new HashMap<>();
            env.peek().put("if", localEnv);
        } else {
            this.isBlock = true;
            HashMap<String, Object> localEnv = new HashMap<>();
            env.push(localEnv);
            this.isBlock = true;
        }

        ifelse.getExp().accept(this);
        Object exp = operands.pop();
        System.out.println("Pop: " + exp.getClass());
        if (globalCtx.get(exp) != null) {
            exp = globalCtx.get(exp);
        } else if (env.peek().get(exp) != null) {
            exp = env.peek().get(exp);
        }

        System.out.println(exp);
        System.out.println(ifelse.getStmtList1().toString());
        if ((boolean) exp) {

            ifelse.getStmtList1().accept(this);
        } else {
            if (ifelse.getStmtList2() != null) {
                System.out.println(ifelse.getStmtList2().toString());
                ifelse.getStmtList2().accept(this);
            }
        }

        if (interior) {
            env.peek().remove("if");
        } else {
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
    public void visit(Ret ret) {
        // System.out.println("Entrou no ret");

        ret.getExp().accept(this);

        if (ret.getRet() != null) {
            ret.getRet().accept(this);
        }

    }

    @Override
    public void visit(GenRet genret) {
        // System.out.println("Entrou no gen ret");

        if (this.isBlock) {
            genret.getRet().accept(this);
        } else {
            // System.out.println("Erro: return chamado fora de um bloco");
        }
    }

    @Override
    public void visit(Print print) {

        print.getExp().accept(this);

        Object exp = operands.pop();

        Object toPrint;
        
        if(this.isBlock){
            if(env.peek().get(exp) != null){
                Object var = env.peek().get(exp);
                if(env.peek().get(var) != null){
                    toPrint = env.peek().get(var);
                }else{
                    toPrint = env.peek().get(exp);
                }
            }else{
                toPrint = exp;
            }

        } else {
            if (globalCtx.get(exp) != null) {
                Object var = globalCtx.get(exp);
                if(globalCtx.get(var) != null){
                    toPrint = globalCtx.get(var);
                }else{
                    toPrint = globalCtx.get(exp);
                }
            }else{
                toPrint = exp;
            }
        }

        if(toPrint instanceof String){
            String s = ((String)toPrint).replaceAll("\'","");
            if(s.contains("\\n")){
                System.out.println("\n");
            }else{
                System.out.println(s);
            }
        }else{
            System.out.println(toPrint);
        }
    }

    @Override
    public void visit(Decl e) {
        if (this.isBlock) {
            e.getType().accept(this);

            String variableName = e.getIdentifier();
            Object type = operands.pop();

            if (datas.get(this.lastData) != null) {
                ((HashMap<String, Object>) datas.get(this.lastData)).put(variableName, type);
                env.peek().put(variableName, type);
            }

            if (e.getDecl() != null) {
                e.getDecl().accept(this);
            }
        }
    }

    @Override
    public void visit(Data e) {
        System.out.println(e);
        this.isBlock = true;
        this.lastData = e.getIdentifier().getName();
        HashMap<String, Object> localEnv = new HashMap<>();

        datas.put(e.getIdentifier().getName(), localEnv);
        env.push(localEnv);

        e.getDecl().accept(this);

        env.pop();
        System.out.println(datas);
        this.isBlock = false;

    }

    @Override
    public void visit(Func e) {
        System.out.println(e);
        this.isBlock = true;

        HashMap<String, Object> localEnv = new HashMap<>();

        funcs.put(e.getIdentifier().getIdentifier(), e);
        env.push(localEnv);
        System.out.println("Func " + e.getIdentifier().getIdentifier() + " adicionado ao escopo Global");

        if (e.getParam() != null) {
            e.getParam().accept(this);
        }

        e.getBody().accept(this);
        env.pop();
        this.isBlock = false;
    }

    @Override
    public void visit(Exp e) {
    }

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

        if (e.getIdentifier() != null && e.getLvalue() == null && e.getCtx() == null) {

            if (isBlock) {
                lvalue = env.peek().get(e.getIdentifier());

                if (lvalue != null) {
                    
                    operands.push(e.getIdentifier());

                } else {
                   
                    env.peek().put(e.getIdentifier(), e);
                    operands.push(e.getIdentifier());
                }
            } else {
                lvalue = globalCtx.get(e.getIdentifier());

                if (lvalue != null) {
                   
                    operands.push(e.getIdentifier());

                } else {
                    
                    globalCtx.put(e.getIdentifier(), e);
                    operands.push(e.getIdentifier());
                }
            }
        }

        if (e.getLvalue() != null) {

            e.getLvalue().accept(this);

            if (e.getIdentifier() != null) {
                operands.push(e.getIdentifier());
            }

        }

        if (e.getCtx() != null) {

            e.getCtx().accept(this);

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

                    env.peek().put((String) var, read);
                } else {

                    Scanner myObj = new Scanner(System.in);
                    System.out.println("Digite valor de ");
                    String read = myObj.nextLine();

                    env.peek().put((String) exp, read);
                }
            }
        } else {
            if (globalCtx.get(exp) != null) {
                Object var = globalCtx.get(exp);
                if (globalCtx.get(var) != null) {
                    Scanner myObj = new Scanner(System.in);
                    System.out.println("Digite valor de ");
                    String read = myObj.nextLine();
                    globalCtx.put((String) var, read);
                } else {
                    Scanner myObj = new Scanner(System.in);
                    System.out.println("Digite valor de ");
                    String read = myObj.nextLine();
                    globalCtx.put((String) exp, read);
                }
            }
        }
    }

    public void visit(Inst e) {
        e.getType().accept(this);

        Object type = operands.pop();

        if (datas.get((String) type) != null) {

            HashMap<String, Object> data = (HashMap<String, Object>) datas.get((String) type);
            HashMap<String, Object> objectData = new HashMap<>();
            Set<String> atributes = data.keySet();

            for (String atribute : atributes) {
                objectData.put(atribute, null);
            }

            if (e.getSize() != null) {
                e.getSize().accept(this);
                Object size = operands.pop();
                Tupla[] tuplas = new Tupla[(int) size];

                for (int i = 0; i < tuplas.length; i++) {
                    HashMap<String, Object> objectDataAr = new HashMap<>();
                    for (String atribute : atributes) {
                        objectDataAr.put(atribute, null);
                    }
                    tuplas[i] = new Tupla(type.toString(), objectDataAr);

                }
                operands.push(tuplas);

                for (int i = 0; i < tuplas.length; i++) {
                    System.out.println(tuplas[i]);
                }
            } else {

                Tupla tupla = new Tupla(type.toString(), objectData);
                operands.push(tupla);
                System.out.println(tupla);

            }

        } else if (((String) type).equals("Int")) {
            if (e.getSize() != null) {
                e.getSize().accept(this);
                Object size = operands.pop();
                Tupla[] tuplas = new Tupla[(int) size];

                for (int i = 0; i < tuplas.length; i++) {
                    Integer objectDataAr = null;
                    tuplas[i] = new Tupla(type.toString(), objectDataAr);

                }
                operands.push(tuplas);
                System.out.println("Tamanho da Tupla: " + tuplas.length);
                for (int i = 0; i < tuplas.length; i++) {
                    System.out.println(tuplas[i]);
                }
            } else {
                Integer objectData = null;
                Tupla tupla = new Tupla(type.toString(), objectData);
                operands.push(tupla);
                System.out.println(tupla);

            }
        } else if (((String) type).equals("Float")) {
            if (e.getSize() != null) {
                e.getSize().accept(this);
                Object size = operands.pop();
                Tupla[] tuplas = new Tupla[(int) size];

                for (int i = 0; i < tuplas.length; i++) {
                    Float objectDataAr = null;
                    tuplas[i] = new Tupla(type.toString(), objectDataAr);

                }
                operands.push(tuplas);
                System.out.println("Tamanho da Tupla: " + tuplas.length);
                for (int i = 0; i < tuplas.length; i++) {
                    System.out.println(tuplas[i]);
                }
            } else {
                Integer objectData = null;
                Tupla tupla = new Tupla(type.toString(), objectData);
                operands.push(tupla);
                System.out.println(tupla);

            }
        } else if (((String) type).equals("Char")) {
            if (e.getSize() != null) {
                e.getSize().accept(this);
                Object size = operands.pop();
                Tupla[] tuplas = new Tupla[(int) size];

                for (int i = 0; i < tuplas.length; i++) {
                    Character objectDataAr = null;
                    tuplas[i] = new Tupla(type.toString(), objectDataAr);

                }
                operands.push(tuplas);
                System.out.println("Tamanho da Tupla: " + tuplas.length);
                for (int i = 0; i < tuplas.length; i++) {
                    System.out.println(tuplas[i]);
                }
            } else {
                Integer objectData = null;
                Tupla tupla = new Tupla(type.toString(), objectData);
                operands.push(tupla);
                System.out.println(tupla);

            }
        }
    }

    private class Tupla {

        private String type;
        private Object objectData;

        public Tupla(String type, Object objectData) {
            this.type = type;
            this.objectData = objectData;
        }

        public String getType() {
            return this.type;
        }

        public Object getObjectData() {
            return this.objectData;
        }

        public void putObjectData(String key, Object value) {
            ((HashMap<String, Object>) this.objectData).put(key, value);
        }

        public void setObjectData(Object value) {
            this.objectData = value;
        }

        @Override
        public String toString() {
            return ("(Data: " + type + " | Values: " + objectData + ")");
        }
    }

}