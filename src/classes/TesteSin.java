package src.classes;


import java.io.IOException;
import java.util.HashMap; 

import src.classes.parsers.*;
import src.classes.ast.*;


public class TesteSin{
      public static void main(String[] args){
        HashMap<String,Integer> h = new HashMap<String,Integer>();
        try{
            
            
            Node result = (new Parser()).parseFile(args[0]);
            
            System.out.println("Parsado !");
            System.out.println(result.toString());
            
            System.out.println("--------- Executando ---------");
            
        }
        catch (Exception e){
            System.err.println("Excecao: " + e.getMessage());
        } 
     }
}
