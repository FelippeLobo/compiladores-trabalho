package src.classes.ast;

import java.util.HashMap;

import src.classes.beaver.Symbol;

public class Btype extends Exp {
    Btype(String a){

    }

    public Btype(Integer a) {
    }

    public Btype(Float a) {
    }

    public Btype(char a) {
    }

    public Btype(boolean a) {
    }

    public Btype(Symbol a) {
    }

    @Override
    public int interpret(HashMap<String, Integer> m) {
        // TODO Auto-generated method stub
        return 0;
    }
}
