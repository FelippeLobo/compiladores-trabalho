package src.classes.parsers;

import src.classes.ast.*;
import src.classes.beaver.Parser.Exception;
import src.classes.parsers.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Parser implements ParseAdaptor {
    public Parser() {

    }

    @Override
    public Node parseFile(String path) throws IOException, Exception {

        try {
            LangLex input = new LangLex(new FileReader(path));
            CmdList result = (CmdList) new LangParser().parse(input);

            if (result != null) {
                return result;
            }

          
        } catch (IOException e) {
            System.err.println("Failed to read Expession: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Invalid Expession: " + e.getMessage());
        }
        return null; 

    }

}
