package src;

import java.io.FileReader;
import java.io.IOException;

import src.ast.Node;
import src.ast.StmtList;
import src.beaver.Parser.Exception;
import src.parsers.*;


public class ParseBuild implements ParseAdaptor {

    @Override
    public Node parseFile(String path) throws IOException, Exception {

        System.out.println(path);
        MiniLangLex input = new MiniLangLex(new FileReader(path));
 
        StmtList result = (StmtList) new MiniLangParser().parse(input);
        
       
        return result;
    }
    
}
