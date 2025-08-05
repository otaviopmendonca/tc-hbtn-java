import java.util.LinkedList;
import java.util.Random;

public class Fila { //A fila é representada por um LinkedList e tem uma capacidade limitada.
    private final LinkedList<Integer> fila = new LinkedList<>();
    private final int capacidadeMax;
    
    public Fila(int capacidadeMax) {
        this.capacidadeMax = capacidadeMax;
    }

    //método que adiciona um item à fila.
    public synchronized void adicionar(int item) throws InterruptedException {
        while (fila.size() == capacidadeMax) {  
            wait(); //enquanto a fila estiver cheia, o produtor chama wait()
        }
        fila.add(item);
        System.out.println("O item" + item + "foi adicionado");
        notifyAll(); // Notifica os consumidores que tem um item na fila
    }

    //método que retira um item da fila. 
    public synchronized int retirar() throws InterruptedException {
        while (fila.isEmpty()) {  
            wait(); //enquanto a fila estiver vazia, o consumidor chama wait()
        }
        int item = fila.remove();
        System.out.println("O item" + item + "foi removido");
        notifyAll(); // Notifica os produtores que há espaço na fila
        return item;
    }
}
