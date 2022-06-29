# compiladores-trabalho

# COMANDOS


compilar classes java (trab1)
	javac -d src\bin  src\classes\*.java 
	javac -d bin  classes\ast\*.java classes\parsers\*.java classes\tests\*.java

compilar Jflex: 
	java -jar jflex-1.8.2\lib\jflex-full-1.8.2.jar src\lang.jflex

executar teste lexico: 
	java -cp src\bin\ Teste src\testes\testeLexico.txt

compilar grammar:
	java -jar beaver-cc-0.9.11.jar -T lang.grammar

compilar classes java (trab2)
javac -cp .:beaver-rt-0.9.11.jar classes\beaver\*.java classes\ast\*.java classes\parsers\*.java classes\*.java

executar teste sintatico
java src.classes.TesteSin src\testes\exemplo1.txt