public class SistemaFilas {
    
    public static void main(String args[]) throws InterruptedException {
        Fila fila = new Fila(10); 
    

    // 2 threads de produtores e 2 threads de consumidores.
    Thread produtor1 = new Produtor(fila);
    Thread produtor2 = new Produtor(fila);
    Thread consumidor1 = new Consumidor(fila);
    Thread consumidor2 = new Consumidor(fila);

    produtor1.start();
    produtor2.start();
    consumidor1.start();
    consumidor2.start();

    // O programa executa por 20 segundos para simular a operação e depois encerra o processo com System.exit(0).
    Thread.sleep(20000); 
    System.exit(0); 

    }
}
