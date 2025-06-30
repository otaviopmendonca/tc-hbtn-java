import atividades.Atividade;

public class MaquinaWorkflow {

    public void executar(Workflow workflow) {
        if (workflow == null) {
            throw new IllegalArgumentException("Não é possível executar um Workflow nulo.");
        }

        if (workflow.estaVazio()) {
            return;
        }

        for (Atividade atividade : workflow.getAtividades()) {
            if (atividade != null) {
                atividade.executar();
            }
        }
    }
}