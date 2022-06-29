package src.classes.parsers;

import java.io.*;
import java.util.List;
import src.classes.ast.*;
import src.classes.beaver.Parser.Exception;


// Adaptador para classe de parser. a Função parseFile deve retornar null caso o parser resulte em erro. 

public interface ParseAdaptor{
   public abstract Node parseFile(String path) throws FileNotFoundException, IOException, Exception;
   
}



