# compiladores-trabalho

# COMANDOS


compilar classes:
	javac -d src\bin  src\classes\*.java 

compilar Jflex: 
	java -jar jflex-1.8.2\lib\jflex-full-1.8.2.jar src\lang.jflex

executar teste: 
	java -cp src\bin\ Teste src\testes\testeLexico.txt


