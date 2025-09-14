import java.util.LinkedList;

/**
 * Gerencia a fila de espera de pacientes usando uma LinkedList.
 * Segue o princípio de FIFO (First-In, First-Out).
 */
public class FilaDeAtendimento {

    private LinkedList<Paciente> fila;

    /**
     * Construtor da classe, inicializa a lista encadeada.
     */
    public FilaDeAtendimento() {
        this.fila = new LinkedList<>();
    }

    /**
     * Adiciona um paciente ao final da fila de atendimento.
     * @param p O paciente a ser adicionado.
     */
    public void adicionarPaciente(Paciente p) {
        fila.addLast(p);
    }

    /**
     * Remove e retorna o primeiro paciente da fila (o próximo a ser atendido).
     * @return O paciente atendido, ou null se a fila estiver vazia.
     */
    public Paciente atenderPaciente() {
        if (!estaVazia()) {
            return fila.removeFirst();
        }
        return null;
    }

    /**
     * Verifica se a fila de atendimento está vazia.
     * @return true se a fila estiver vazia, false caso contrário.
     */
    public boolean estaVazia() {
        return fila.isEmpty();
    }

    /**
     * Imprime no console a lista de todos os pacientes na fila de espera.
     */
    public void mostrarFila() {
        if (estaVazia()) {
            System.out.println("A fila de atendimento está vazia.");
        } else {
            System.out.println("\n--- Fila de Atendimento Atual ---");
            for (Paciente p : fila) {
                // Chama o método exibirInfo() para obter os dados formatados do paciente.
                System.out.println(p.exibirInfo());
            }
            System.out.println("---------------------------------");
        }
    }
}
