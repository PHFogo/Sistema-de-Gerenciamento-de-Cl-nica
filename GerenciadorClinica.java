import java.util.Scanner;

/**
 * Classe principal que contém o método main para interagir com o usuário.
 * Gerencia o menu e a lógica de controle do sistema da clínica.
 */
public class GerenciadorClinica {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FilaDeAtendimento fila = new FilaDeAtendimento();
        PilhaHistoricoAtendimentos historico = new PilhaHistoricoAtendimentos();
        int opcao = 0;

        System.out.println("Bem-vindo ao Sistema de Gerenciamento da Clínica!");

        // Loop principal do menu
        while (true) {
            exibirMenu();
            
            // Validação de entrada para a opção do menu (sem try-catch)
            while (!scanner.hasNextInt()) {
                System.out.println("\nErro: Por favor, digite um número válido.");
                scanner.next(); // Limpa a entrada inválida
                System.out.print("Escolha uma opção: ");
            }
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do scanner

            // Lógica do menu com if-else if-else (sem switch-case)
            if (opcao == 1) {
                // Adicionar novo paciente
                System.out.println("\n--- Adicionar Novo Paciente ---");
                System.out.print("Digite o nome do paciente: ");
                String nome = scanner.nextLine();

                System.out.print("Digite a idade do paciente: ");
                // Validação de entrada para a idade
                while (!scanner.hasNextInt()) {
                    System.out.println("\nErro: Idade inválida. Por favor, digite um número.");
                    scanner.next(); // Limpa a entrada inválida
                    System.out.print("Digite a idade do paciente: ");
                }
                int idade = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer

                System.out.print("Digite o sintoma do paciente: ");
                String sintoma = scanner.nextLine();

                Paciente novoPaciente = new Paciente(nome, idade, sintoma);
                fila.adicionarPaciente(novoPaciente);

                System.out.println("\nPaciente " + nome + " adicionado à fila com sucesso!");

            } else if (opcao == 2) {
                // Atender próximo paciente
                if (fila.estaVazia()) {
                    System.out.println("\nNão há pacientes na fila para atender.");
                } else {
                    Paciente pacienteAtendido = fila.atenderPaciente();
                    historico.adicionarAoHistorico(pacienteAtendido);
                    System.out.println("\n--- Paciente Atendido ---");
                    System.out.println(pacienteAtendido.exibirInfo());
                    System.out.println("-------------------------");
                }

            } else if (opcao == 3) {
                // Exibir fila de atendimento
                fila.mostrarFila();

            } else if (opcao == 4) {
                // Exibir histórico de atendimentos
                historico.mostrarHistorico();

            } else if (opcao == 5) {
                // Sair
                System.out.println("\nSaindo do sistema. Obrigado!");
                break; // Encerra o loop while

            } else {
                // Opção inválida
                System.out.println("\nOpção inválida. Por favor, escolha uma das opções do menu.");
            }
        }

        scanner.close(); // Fecha o scanner ao sair do programa
    }

    /**
     * Exibe o menu de opções para o usuário.
     */
    public static void exibirMenu() {
        System.out.println("\n===================================================");
        System.out.println("1. Adicionar novo paciente à fila");
        System.out.println("2. Atender próximo paciente");
        System.out.println("3. Exibir fila de atendimento");
        System.out.println("4. Exibir histórico de atendimentos");
        System.out.println("5. Sair");
        System.out.println("===================================================");
        System.out.print("Escolha uma opção: ");
    }
}
