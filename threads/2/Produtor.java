import java.util.Random;

public class Produtor extends Thread {
        private final Random random = new Random();
        private final Fila fila;
    
    public Produtor(Fila fila) {
        this.fila = fila;
    }

    //método run() para gerar números aleatórios e adicioná-los à fila.
    @Override
    public void run() {
        try {
            while (true) {
                int item = random.nextInt(100) + 1; // gera numero de 1 a 100
                fila.adicionar(item);
                Thread.sleep(500); 
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}