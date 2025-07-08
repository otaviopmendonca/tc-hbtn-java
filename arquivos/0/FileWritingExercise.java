import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class FileWritingExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        // Solicita o nome do arquivo
        System.out.print("Digite o nome do arquivo (com extensão .txt): ");
        String fileName = scanner.nextLine();


    // implemente o codigo aqui
    try {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

        System.out.println("Digite o texto (digite 'sair' para encerrar):");

        while (true) {
            String linha = scanner.nextLine(); // lê uma linha do usuário

            if (linha.equalsIgnoreCase("sair")) { // ignora maiúsculas/minúsculas
                break; // Encerra o loop
            }

            writer.write(linha); // escreve a linha no arquivo
            writer.newLine();    // adiciona uma quebra de linha
        }

        writer.close(); 
        System.out.println("Arquivo salvo com sucesso!");

    } catch (IOException e) {
        System.out.println("Ocorreu um erro ao escrever no arquivo: " + e.getMessage());
    }

        scanner.close();
    }
}