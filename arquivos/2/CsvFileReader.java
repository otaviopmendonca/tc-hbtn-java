import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvFileReader {

    public static void main(String[] args) {
        String csvFile = "funcionarios.csv";
        String line = "";
        String cvsSplitBy = ","; // Separador CSV

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            // Pular a linha do cabeçalho
            br.readLine();

            while ((line = br.readLine()) != null) {
                // Usa vírgula como separador
                String[] funcionario = line.split(cvsSplitBy);

                System.out.println("Funcionário: " + funcionario[0]);
                System.out.println("Idade: " + funcionario[1]);
                System.out.println("Departamento: " + funcionario[2]);
                System.out.println("Salarial: " + funcionario[3]);
                System.out.println("------------------------");
            }
            System.out.println("Leitura do arquivo concluída.");

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo CSV: " + e.getMessage());
        }
    }
}