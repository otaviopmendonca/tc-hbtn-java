#!/bin/bash

# Caminho para o arquivo Java
JAVA_FILE="Aritmeticos.java"
PACKAGE_DIR="holbertonschool/matematica"
BUILD_DIR="build"

# Criar diretório build se não existir
mkdir -p "$BUILD_DIR"

# Compilar o Java com saída para build/
javac -encoding UTF-8 -d "$BUILD_DIR" "$JAVA_FILE"

# Entrar no diretório build
cd "$BUILD_DIR" || exit

# Criar o arquivo JAR Matematica.jar
jar cf Matematica.jar $PACKAGE_DIR/Aritmeticos.class
