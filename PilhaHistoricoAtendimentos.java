import java.util.Stack;

/**
 * Gerencia o histórico de pacientes já atendidos usando uma Stack.
 * Segue o princípio de LIFO (Last-In, First-Out).
 */
public class PilhaHistoricoAtendimentos {

    private Stack<Paciente> historico;

    /**
     * Construtor da classe, inicializa a pilha.
     */
    public PilhaHistoricoAtendimentos() {
        historico = new Stack<>();
    }

    /**
     * Adiciona um paciente atendido ao topo da pilha de histórico.
     * @param p O paciente que foi atendido.
     */
    public void adicionarAoHistorico(Paciente p) {
        historico.push(p);
    }

    /**
     * Retorna o último paciente atendido (o que está no topo da pilha) sem removê-lo.
     * @return O último paciente atendido, ou null se o histórico estiver vazio.
     */
    public Paciente verUltimoAtendido() {
        if (!historico.isEmpty()) {
            return historico.peek();
        }
        return null;
    }
    
    /**
     * Verifica se a pilha de histórico está vazia.
     * @return true se a pilha estiver vazia, false caso contrário.
     */
    public boolean estaVazio() {
        return historico.isEmpty();
    }

    /**
     * Imprime no console o histórico de atendimentos, do mais recente para o mais antigo.
     * A iteração é feita com um laço for tradicional, conforme solicitado no requisito.
     */
    public void mostrarHistorico() {
        if (estaVazio()) {
            System.out.println("Nenhum paciente foi atendido ainda.");
        } else {
            System.out.println("\n--- Histórico de Atendimentos (do mais recente ao mais antigo) ---");
            // Itera do topo da pilha (último elemento adicionado) até a base.
            for (int i = historico.size() - 1; i >= 0; i--) {
                Paciente p = historico.get(i);
                System.out.println(p.exibirInfo());
            }
            System.out.println("-----------------------------------------------------------------");
        }
    }
}
