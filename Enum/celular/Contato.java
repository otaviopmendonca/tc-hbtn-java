public class Contato {

    private String nome;
    private String numeroTelefone;
    private TipoNumero tipo;

    public Contato(String nome, String numeroTelefone, TipoNumero tipo) {
        this.nome = nome;
        this.numeroTelefone = numeroTelefone;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public TipoNumero getTipo() {
        return tipo;
    }

    public void setTipo(TipoNumero tipo) {
        this.tipo = tipo;
    }

}

