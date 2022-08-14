package visitors;

import ast.*;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import langUtil.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class PhpVisitor extends Visitor {
    private STGroup groupTemplate;
    private ST type, stmt, expr;
    private List<ST> funcs, params;

    private String fileName;

    TyEnv<LocalEnv<SType>> env;

    public PhpVisitor(String fileName, TyEnv<LocalEnv<SType>> env) {
        groupTemplate = new STGroupFile("./template/php.stg");
        this.fileName = fileName;
    }

    public void visit(Prog p) {
        ST template = groupTemplate.getInstanceOf("program");
    
        template.add("name", fileName);
        funcs = new ArrayList<ST>();
        for(Func f : p.getFuncs()) {
            f.accept(this);
        }
        template.add("funcs", funcs);
    
        System.out.println(template.render());
    
    }

    public void visit(Func f) {
        ST fun = groupTemplate.getInstanceOf("func");
        fun.add("name", f.getID());
    
        LocalEnv<SType> local = env.get(f.getID());
        Set<String> keys = local.getKeys();
    
        params = new ArrayList<ST>();
        for(Param p : f.getParams()) {
            keys.remove(p.getID());
            p.accept(this);
        }
        fun.add("params", params);
    
        for(String key : keys) {
            ST decl = groupTemplate.getInstanceOf("param");
            decl.add("name", key);
            SType t = local.get(key);
            processSType(t);
            decl.add("type", type);
            fun.add("decl", decl);
        }
        
        f.getBody().accept(this);
        fun.add("stmt", stmt);
    
        funcs.add(fun);
    }

    public void visit(Add e) {
        ST aux = groupTemplate.getInstanceOf("add_expr");
        e.getLeft().accept(this);
        aux.add("left_expr", expr);
        e.getRight().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }

    public void visit(Sub e) {
        ST aux = groupTemplate.getInstanceOf("sub_expr");
        e.getLeft().accept(this);
        aux.add("left_expr", expr);
        e.getRight().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }
            
    public void visit(Mul e) {
        ST aux = groupTemplate.getInstanceOf("mul_expr");
        e.getLeft().accept(this);
        aux.add("left_expr", expr);
        e.getRight().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }
            
    public void visit(Div e) {
        ST aux = groupTemplate.getInstanceOf("div_expr");
        e.getLeft().accept(this);
        aux.add("left_expr", expr);
        e.getRight().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }
            
    public void visit(Mod e) {
        ST aux = groupTemplate.getInstanceOf("mod_expr");
        e.getLeft().accept(this);
        aux.add("left_expr", expr);
        e.getRight().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }

    public void visit(Greater e) {
        ST aux = groupTemplate.getInstanceOf("greater_expr");
        e.getLeft().accept(this);
        aux.add("left_expr", expr);
        e.getRight().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }

    public void visit(Lesser e) {
        ST aux = groupTemplate.getInstanceOf("lesser_expr");
        e.getLeft().accept(this);
        aux.add("left_expr", expr);
        e.getRight().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }

    public void visit(GreaterEqual e) {
        ST aux = groupTemplate.getInstanceOf("greaterequal_expr");
        e.getLeft().accept(this);
        aux.add("left_expr", expr);
        e.getRight().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }

    public void visit(LesserEqual e) {
        ST aux = groupTemplate.getInstanceOf("lesserequal_expr");
        e.getLeft().accept(this);
        aux.add("left_expr", expr);
        e.getRight().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }

    public void visit(And e) {
        ST aux = groupTemplate.getInstanceOf("and_expr");
        e.getLeft().accept(this);
        aux.add("left_expr", expr);
        e.getRight().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }

    public void visit(Eq e) {
        ST aux = groupTemplate.getInstanceOf("eq_expr");
        e.getLeft().accept(this);
        aux.add("left_expr", expr);
        e.getRight().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }

    public void visit(Dif e) {
        ST aux = groupTemplate.getInstanceOf("dif_expr");
        e.getLeft().accept(this);
        aux.add("left_expr", expr);
        e.getRight().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }
                
    public void visit(Not e) {
        ST aux = groupTemplate.getInstanceOf("not_expr");
        e.getExpr().accept(this);
        aux.add("expr", expr);
        expr = aux;
    }

    public void visit(Return e) {
        stmt = groupTemplate.getInstanceOf("return");
        e.getExpr().accept(this);
        stmt.add("expr", expr);
    }
             
    public void visit(Print e) {
        stmt = groupTemplate.getInstanceOf("print");
        e.getExpr().accept(this);
        stmt.add("expr", expr);
    }

    public void visit(TyInt t) {
        type = groupTemplate.getInstanceOf("int_type");
    }
        
    public void visit(TyFloat t) {
        type = groupTemplate.getInstanceOf("float_type");
    }
        
    public void visit(TyBool t) {
        type = groupTemplate.getInstanceOf("boolean_type");
    }
        
    public void visit(TyArr t) {
        ST aux = groupTemplate.getInstanceOf("array_type");
        t.getTyArg().accept(this);
        aux.add("type", type);
        type = aux;
    }

    public void visit(Iterate e) {
        ST aux = groupTemplate.getInstanceOf("iterate");
        e.getTeste().accept(this);
        aux.add("expr", expr);
        e.getBody().accept(this);
        aux.add("stmt", stmt);
        stmt = aux;
    }

    public void visit(If e) {
        if(n != null){
            ST aux = groupTemplate.getInstanceOf("ifelse");
        }else{
            ST aux = groupTemplate.getInstanceOf("if");
        }
        
        e.getTeste().accept(this);
        aux.add("expr", expr);
        e.getThen().accept(this);
        aux.add("thn", stmt);
        Node n = e.getElse();
        if(n != null) {
            n.accept(this);
            aux.add("els", stmt);
        }
        stmt = aux;
    }

}