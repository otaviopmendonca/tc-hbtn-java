public class PersonagemGame {

    private int saudeAtual;
    private String nome;
    private String status;

    PersonagemGame (int saudeAtual, String nome) {
        setSaudeAtual(saudeAtual);
        setNome(nome);
    }

    public int getSaudeAtual() {
        return saudeAtual;
    }
    public void setSaudeAtual(int saudeAtual) {
        if (saudeAtual < 0) {
            this.saudeAtual = 0;
        }

        else if (saudeAtual > 100) {
            this.saudeAtual = 100;
        }
        
        else {
            this.saudeAtual = saudeAtual;
        }
        
        if (saudeAtual > 0) {
            status = "vivo";
        }
        else {
            status ="morto";
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
         if (nome != null && !nome.isEmpty()) {
            this.nome = nome;
        }
    }

    public String getStatus() {
        return status;
    }

    public void tomarDano(int quantidadeDeDano) {
        int novaSaude = this.saudeAtual - quantidadeDeDano;
        setSaudeAtual(novaSaude);  
    }

    public void receberCura(int quantidadeDeCura) {
        int novaSaude = this.saudeAtual + quantidadeDeCura;
        setSaudeAtual(novaSaude);
    }

}
