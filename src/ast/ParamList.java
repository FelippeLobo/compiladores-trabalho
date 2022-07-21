package src.ast;

import java.util.ArrayList;
import java.util.List;

import src.visitors.Visitor;

public class ParamList extends Node {

    private Node param;
    private Node paramList;

    public ParamList(Node param, Node paramList) {

        this.param = param;
        this.paramList = paramList;
    }

    public ParamList(Node param) {

        this.param = param;
        this.paramList = null;
    }

    public Node getParam() {
        return this.param;
    }

    public Node getParamList() {
        return this.paramList;
    }

    @Override
    public String toString() {

        if (this.paramList != null) {
            return (this.param.toString() + ", " + this.paramList.toString());
        } else {
            return (this.param.toString());
        }

    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

}
