//Nathan Toschi Reis / 201865064C
//Felippe Rocha Lobo de Abreu / 201765185AC

package src.visitors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import javax.management.openmbean.OpenDataException;
import javax.sound.sampled.SourceDataLine;

import java.util.Scanner;
import java.util.Set;

import src.ast.*;

public class InterpretVisitor extends Visitor {

    private Stack<Object> operands;
    private Stack<HashMap<String, Object>> env;
    private HashMap<String, Object> globalCtx;
    private HashMap<String, Object> datas;
    private HashMap<String, Object> funcDefinitions;
    private List<Object> returnList;
    private boolean asReturn;
    private boolean asParameters;
    private boolean isBlock;
    private boolean analyseFunc;
    private Node actualFunc;
    private boolean isReturn;
    private String lastData;
    private boolean canFuncs;
    private boolean entrouMain;

    public InterpretVisitor() {
        env = new Stack<>();
        globalCtx = new HashMap<>();
        datas = new HashMap<>();
        funcDefinitions = new HashMap<>();
        operands = new Stack<>();
        isBlock = false;
        analyseFunc = false;
        returnList = new ArrayList<>();
        lastData = "";
        asReturn = false;
        asParameters = false;
        canFuncs = false;
        entrouMain = false;
    }

    @Override
    public void visit(Prog prog) {
        this.analyseFunc = false;
        prog.getCommand1().accept(this);
        if (prog.getCommand2() != null) {
            prog.getCommand2().accept(this);
        }

        if (this.funcDefinitions.get("main") != null && !entrouMain) {
            this.analyseFunc = true;
            entrouMain = true;
            ((Func) this.funcDefinitions.get("main")).accept(this);
        }

    }

    public Boolean match(Object exp, String type) {
        switch (type) {
            case "Integer":
                if (exp instanceof Integer) {
                    return true;
                } else {
                    System.out.println("Erro: o valor esperado era de Int, mas foi encontrado um: "
                            + exp.getClass().getSimpleName());
                }
                break;

            case "Float":
                if (exp instanceof Float) {
                    return true;
                } else {
                    System.out.println("Erro: o valor esperado era de Float, mas foi encontrado um: "
                            + exp.getClass().getSimpleName());
                }
                break;

            case "Boolean":
                if (exp instanceof Boolean) {
                    return true;
                } else {
                    System.out.println("Erro: o valor esperado era de Boolean, mas foi encontrado um: "
                            + exp.getClass().getSimpleName());
                }
                break;

            case "Character":
                if (exp instanceof Character) {
                    return true;
                } else {
                    System.out.println("Erro: o valor esperado era de Char, mas foi encontrado um: "
                            + exp.getClass().getSimpleName());
                }
                break;

            case "String":
                if (exp instanceof String) {
                    return true;
                } else {
                    System.out.println("Erro: o valor esperado era de String, mas foi encontrado um: "
                            + exp.getClass().getSimpleName());
                }
                break;
            default:
                System.out.println("Erro: o valor esperado não é um valor possível: " + type);
                break;
        }

        return false;
    }

    public Object returnValue(Object exp) {
           
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

     
        
        return exp;
    }

    @Override
    public void visit(Not e) {
        e.getExp().accept(this);
        Object exp = operands.pop();
        exp = returnValue(exp);

        if (exp instanceof Boolean) {
            operands.push(!(boolean) exp);
        } else {
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

        e.getExp().accept(this);
        e.getVar().accept(this);

        Object variableName = operands.pop();

        Object value = null;
        value = operands.pop();

        if (this.isBlock) {

            if (env.peek().get(value) != null) {

                if (env.peek().get(value) instanceof Tupla) {

                    String atribute = (String) variableName; // ATRIBUTO QUE EU QUERO MEXER !!!
                    String lvalue = (String) value; // Lvalue com o atribute
                    value = operands.pop();

                    Object tupla = env.peek().get(lvalue);
                    if (tupla instanceof Tupla) {
                        if (((Tupla) tupla).getObjectData() instanceof HashMap<?, ?>) {

                            ((Tupla) tupla).putObjectData(atribute, value);
                        } else {
                            ((Tupla) tupla).setObjectData(value);
                        }
                    }

                } else if (env.peek().get(value) instanceof Tupla[]) {
                    int index = (int) variableName;
                    String lvalue = (String) value;
                    value = operands.pop();

                    Tupla[] tuplas = (Tupla[]) env.peek().get(lvalue);
                    tuplas[index].setObjectData(value);
            
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

        if (isReturn) {
            return;
        }
        stmtList.getStmt().accept(this);
        if (isReturn) {
            return;
        }
        if (stmtList.getStmtList() != null) {
            stmtList.getStmtList().accept(this);
        }
    }

    @Override
    public void visit(IfElse ifelse) {
        ifelse.getExp().accept(this);
        Object exp = operands.pop();

        exp = returnValue(exp);

        if ((boolean) exp) {
            ifelse.getStmtList1().accept(this);
        } else {
            if (ifelse.getStmtList2() != null) {
                ifelse.getStmtList2().accept(this);
            }
        }
    }

    @Override
    public void visit(Iterate e) {
        e.getExp().accept(this);
        Object exp = operands.pop();
        exp = returnValue(exp);

        if (!(match(exp, "Integer"))) {
            return;
        }

        int x = (Integer) exp;
        int i = 0;
        while (i < x) {
            e.getStmtList().accept(this);

            i++;
        }
    }

    @Override
    public void visit(Ret ret) {
        ret.getExp().accept(this);
        Object returnV = operands.pop();

        if (returnValue(returnV) == returnV) {
            this.returnList.add(returnV);
        } else {
            this.returnList.add(returnValue(returnV));
        }
  
        if (ret.getRet() != null) {
            ret.getRet().accept(this);
        }
    }

    @Override
    public void visit(GenRet genret) {
        if (this.isBlock) {
            genret.getRet().accept(this);
            this.isReturn = true;
        } 
    }

    @Override
    public void visit(Print print) {

        print.getExp().accept(this);
        Object toPrint = null;

        Object exp = operands.pop();
       
        if(!operands.isEmpty()){
            if ((env.peek().get(operands.peek()) != null) && env.peek().get(operands.peek()) instanceof Tupla) {
                Tupla tupla = (Tupla) env.peek().get(operands.peek());
                if (((HashMap) tupla.getObjectData()).get(exp) != null) {
                    toPrint = ((HashMap) tupla.getObjectData()).get(exp);
                    operands.pop();
                }
            }else {
   
                toPrint = returnValue(exp);
                
            }
        
        }else{

            toPrint = returnValue(exp);
        }
      
       
        if (toPrint instanceof String) {
            String s = ((String) toPrint).replaceAll("\'", "");
            if (s.contains("\\n")) {
                System.out.print("\n");
            } else {
                System.out.print(s);
            }
        } else {
            System.out.print(toPrint);
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
        this.isBlock = true;
        this.lastData = e.getIdentifier().getName();
        HashMap<String, Object> localEnv = new HashMap<>();

        datas.put(e.getIdentifier().getName(), localEnv);
        env.push(localEnv);

        e.getDecl().accept(this);

        env.pop();
        this.isBlock = false;

    }

    @Override
    public void visit(Func e) {

        if (this.analyseFunc) {
           
            int returnIndex = -1;
            this.isBlock = true;
            actualFunc = e;
            if (e.getReturn() != null) {
                this.asReturn = true;
            } else {
                this.asReturn = false;
            }
            HashMap<String, Object> localEnv = new HashMap<>();
            env.push(localEnv);

            if (e.getParam() != null && this.asParameters) {

                env.peek().put("parameters", new ArrayList<Tupla>());
                e.getParam().accept(this);

                if (this.analyseFunc) {
                    Object ret = null;
                    boolean flag = false;
                    if (this.asReturn) {

                        ret = operands.pop();

                        if (!(ret instanceof String)) {

                            returnIndex = (int) ret;
                            flag = true;
                        }

                    }

                    HashMap<String, Object> parametersValueID = new HashMap<>();

                    List<Object> parametersValues = new ArrayList<>();

                    while (!(operands.peek() instanceof List<?>)) {
                        Object value = operands.pop();
                        parametersValues.add(value);
                    }
                    List<Tupla> parametersID = ((List<Tupla>) (env.peek().get("parameters")));
                    int i = parametersID.size() - 1;
                    for (Tupla parameterID : parametersID) {
                        if (i >= 0) {
                            Object value = parametersValues.get(i);
                            if (!(returnValue(value) != value)) {
                                parametersValueID.put((String) parameterID.getObjectData(), returnValue(value));
                                env.peek().put((String) parameterID.getObjectData(), returnValue(value));
                            } else {
                                parametersValueID.put((String) parameterID.getObjectData(), value);
                                env.peek().put((String) parameterID.getObjectData(), value);
                            }

                            i--;
                        }
                    }

                    if (this.asReturn && !flag) {

                        if (returnValue(ret) != ret) {
                            returnIndex = (int) returnValue(ret);

                        }

                    }
                    List<Object> funcCallObjects = (List) operands.pop();
                    funcCallObjects.add(parametersValueID);
                    if (this.asReturn) {
                        funcCallObjects.add(returnIndex);
                    }

                    operands.push(funcCallObjects);

                }
                this.asParameters = false;
            }

            e.getBody().accept(this);

            if (e.getReturn() != null) {
                this.asReturn = true;
            } else {
                this.asReturn = false;
            }

            if (this.asReturn) {

                if (returnValue(this.returnList.get((int) returnIndex)) == this.returnList.get((int) returnIndex)) {
                    operands.push(this.returnList.get((int) returnIndex));
                } else {
                    operands.push(returnValue(this.returnList.get((int) returnIndex)));
                }
                this.returnList = new ArrayList<>();
                this.asReturn = false;

            }
            env.pop();
            this.isBlock = false;
            this.isReturn = false;
        } else {
            funcDefinitions.put(e.getIdentifier().toString(), e);
        }
    }

    @Override
    public void visit(Exp e) {
    }

    public void visit(Param e) {

        if (this.isBlock) {
            e.getType().accept(this);

            String variableName = e.getIdentifier();
            Object type = operands.pop();

            ((List) env.peek().get("parameters")).add(new Tupla((String) type, variableName));

        }
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

        if(e.getSctx() != null) {
            e.getSctx().accept(this);
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
                    String read = myObj.nextLine();

                    env.peek().put((String) var, read);
                } else {

                    Scanner myObj = new Scanner(System.in);
                    String read = myObj.nextLine();

                    env.peek().put((String) exp, read);
                }
            }
        } else {
            if (globalCtx.get(exp) != null) {
                Object var = globalCtx.get(exp);
                if (globalCtx.get(var) != null) {
                    Scanner myObj = new Scanner(System.in);
                    String read = myObj.nextLine();
                    globalCtx.put((String) var, read);
                } else {
                    Scanner myObj = new Scanner(System.in);
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

            } else {

                Tupla tupla = new Tupla(type.toString(), objectData);
                operands.push(tupla);

            }

        } else if (((String) type).equals("Int")) {
            if (e.getSize() != null) {
                e.getSize().accept(this);
                Object size = operands.pop();
                if (returnValue(size) != size) {
                    size = returnValue(size);
                }

                Tupla[] tuplas = new Tupla[(int) size];

                for (int i = 0; i < tuplas.length; i++) {
                    Integer objectDataAr = null;
                    tuplas[i] = new Tupla(type.toString(), objectDataAr);

                }
                operands.push(tuplas);

            } else {
                Integer objectData = null;
                Tupla tupla = new Tupla(type.toString(), objectData);
                operands.push(tupla);

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

                for (int i = 0; i < tuplas.length; i++) {

                }
            } else {
                Integer objectData = null;
                Tupla tupla = new Tupla(type.toString(), objectData);
                operands.push(tupla);

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

            } else {
                Integer objectData = null;
                Tupla tupla = new Tupla(type.toString(), objectData);
                operands.push(tupla);

            }
        }
    }

    @Override
    public void visit(Exps e) {

        e.getExp().accept(this);

        if (!(returnValue(operands.peek()) == operands.peek())) {
            Object value = operands.pop();
            operands.push(returnValue(value));
        }
        if (e.getExps() != null) {
            e.getExps().accept(this);
        }

    }

    @Override
    public void visit(FuncCall e) {

        String function = e.getIdentifier();
        List<Object> funcCallInputs = new ArrayList<>();
        operands.push(funcCallInputs);

        Object func = funcDefinitions.get(function);
        if (e.getParamaters() != null) {
            this.asParameters = true;
            e.getParamaters().accept(this);
        }

        if (e.getReturnId() != null) {

            e.getReturnId().accept(this);
            if (returnValue(operands.peek()) != operands.peek()) {
                Object index = returnValue(operands.pop());
                operands.push(index);
            }

        }
        this.analyseFunc = true;

        ((Func) func).accept(this);

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

        // DATA
        public void putObjectData(String key, Object value) {
            if (objectData instanceof HashMap) {
                ((HashMap<String, Object>) this.objectData).put(key, value);
            }

        }
        // FIM DATA

        // FUNC
        public void addParameters(HashMap<String, Object> parameters) {
            if (objectData instanceof ArrayList) {
                ((ArrayList) objectData).add(0, parameters);
            }
        }

        public void addReturnId(int returnId) {
            if (objectData instanceof ArrayList) {
                ((ArrayList) objectData).add(1, returnId);
            }
        }

        public void addLocalEnv(HashMap<String, Object> localEnv) {
            if (objectData instanceof ArrayList) {
                ((ArrayList) objectData).add(2, localEnv);
            }
        }
        // FIM FUNC

        public void setObjectData(Object value) {
            this.objectData = value;
        }

        @Override
        public String toString() {
            return ("(Data: " + type + " | Values: " + objectData + ")");
        }
    }

}