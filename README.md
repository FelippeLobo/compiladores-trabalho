# compiladores-trabalho

# COMANDOS


compilar classes:
	javac -d src\bin  src\classes\*.java 
	javac -d bin  classes\ast\*.java classes\parsers\*.java classes\tests\*.java

compilar Jflex: 
	java -jar jflex-1.8.2\lib\jflex-full-1.8.2.jar src\lang.jflex

executar teste: 
	java -cp src\bin\ Teste src\testes\testeLexico.txt

compilar grammar:
	java -jar beaver-cc-0.9.11.jar -T lang.grammar