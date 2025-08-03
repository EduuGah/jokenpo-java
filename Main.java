import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int pontoJogador = 0;
        int pontoComputador = 0;

        while (true){
            System.out.println("Digite 'pedra', 'papel' ou 'tesoura' (ou 'sair' para encerrar):");
            String jogada = sc.nextLine().toLowerCase();  // ignora maiúsculas

            if (jogada.equals("sair")) {
                System.out.println("Jogo encerrado.");
                break;
            }

            if (!jogada.equals("pedra") && !jogada.equals("papel") && !jogada.equals("tesoura")) {
                System.out.println("Jogada inválida. Tente novamente.");
                continue;
            }

            String jogadaComputador = "";
            int numero = random.nextInt(3) + 1;

            if (numero == 1){
                jogadaComputador = "tesoura";
            } else if (numero == 2) {
                jogadaComputador = "papel";
            } else {
                jogadaComputador = "pedra";
            }

            System.out.printf("Jogador escolheu %s, e computador %s.\n", jogada, jogadaComputador);

            if (jogada.equals(jogadaComputador)) {
                System.out.println("Empate!");
            } else if (
                    (jogada.equals("pedra") && jogadaComputador.equals("tesoura")) ||
                            (jogada.equals("tesoura") && jogadaComputador.equals("papel")) ||
                            (jogada.equals("papel") && jogadaComputador.equals("pedra"))
            ) {
                pontoJogador += 1;
                System.out.println("Você venceu esta rodada!");
            } else {
                pontoComputador += 1;
                System.out.println("Computador venceu esta rodada!");
            }

            System.out.printf("Placar: Jogador %d x %d Computador\n\n", pontoJogador, pontoComputador);
        }

        sc.close();
    }
}
