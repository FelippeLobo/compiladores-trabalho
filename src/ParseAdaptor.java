package src;

import java.io.*;
import src.ast.Node;
import src.beaver.Parser.Exception;
import src.parsers.*;
import java.util.List;


// Adaptador para classe de parser. a Função parseFile deve retornar null caso o parser resulte em erro. 

public interface ParseAdaptor{
   public abstract Node parseFile(String path) throws IOException, Exception;
   

   
}



