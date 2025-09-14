/**
 * Representa um paciente na clínica.
 * O ID é gerenciado automaticamente de forma sequencial e única.
 */
public class Paciente {
    // Contador estático para garantir que cada paciente tenha um ID único.
    private static int proximoId = 1;

    private int id;
    private String nome;
    private int idade;
    private String sintoma;

    /**
     * Construtor para criar um novo paciente.
     * O ID é atribuído automaticamente.
     * @param nome O nome do paciente.
     * @param idade A idade do paciente.
     * @param sintoma A descrição do sintoma do paciente.
     */
    public Paciente(String nome, int idade, String sintoma) {
        this.id = proximoId++;
        this.nome = nome;
        this.idade = idade;
        this.sintoma = sintoma;
    }

    // --- Getters e Setters ---

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSintoma() {
        return sintoma;
    }

    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }

    /**
     * Retorna uma String formatada com todas as informações do paciente.
     * Este método substitui a necessidade de sobrescrever o toString().
     * @return String com os dados do paciente.
     */
    public String exibirInfo() {
        return "ID: " + this.id + " | Nome: " + this.nome + " | Idade: " + this.idade + " | Sintoma: " + this.sintoma;
    }
}
