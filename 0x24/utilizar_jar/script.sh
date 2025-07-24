#!/bin/bash

# Compila Program.java, incluindo Matematica.jar no classpath
javac -cp lib/Matematica.jar com/holbertonschool/main/Program.java

# Verifica se a compilação foi bem-sucedida
if [ $? -eq 0 ]; then
    # Executa Program, incluindo Matematica.jar e o diretório atual no classpath
    java -cp lib/Matematica.jar:. com.holbertonschool.main.Program
else
    echo "Erro na compilação do Program.java."
fi