package src;

import java.io.FileReader;
import java.io.IOException;

import src.ast.Node;
import src.ast.StmtList;
import src.beaver.Parser.Exception;
import src.parsers.LangLex;
import src.parsers.LangParser;

public class ParseBuild implements ParseAdaptor {

    @Override
    public Node parseFile(String path) throws IOException, Exception {

        System.out.println(path);
        LangLex input = new LangLex(new FileReader(path));
 
        StmtList result = (StmtList) new LangParser().parse(input);
        
       
        return result;
    }
    
}
