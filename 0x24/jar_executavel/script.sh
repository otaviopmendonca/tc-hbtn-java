#!/bin/bash

OUTPUT_DIR="."

echo "Compilando Program.java..."
javac -cp lib/Matematica.jar com/holbertonschool/main/Program.java

if [ $? -ne 0 ]; then
    echo "Erro na compilação do Program.java. Abortando."
    exit 1
fi

echo "Gerando Executavel.jar..."
jar -cvfm ${OUTPUT_DIR}/Executavel.jar MANIFEST.MF com

if [ $? -ne 0 ]; then
    echo "Erro na criação do Executavel.jar. Abortando."
    exit 1
fi

echo "Executando Executavel.jar..."
java -jar ${OUTPUT_DIR}/Executavel.jar