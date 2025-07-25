public class Tarefa {

    private String descricao;
    private boolean estahFeita;
    private int identificador;

    public Tarefa(String descricao, int identificador) {
        this.descricao = descricao;
        this.estahFeita = estahFeita;
        this.identificador = identificador;
    }
    
    public void modificarDescricao(String novaDescricao) {
        if (descricao != null && !descricao.isEmpty()) {
            throw new IllegalArgumentException("Descricao de tarefa invalida");
        }
        this.descricao = novaDescricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean getEstahfeita() {
        return estahFeita;
    }

    public void setEstahFeita(boolean estahFeita) {
        this.estahFeita = estahFeita;
    }

    public boolean isEstahFeita() {
        return estahFeita;
    }
    
    public int getIdentificador() {
        return identificador;
    }
}
