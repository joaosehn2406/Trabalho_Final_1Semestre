package TrabalhoFinal;

import java.util.Random;
import java.util.Scanner;

public class Trabalho {

    // Construtor da classe Trabalho
    public Trabalho() {
        Scanner in = new Scanner(System.in);

        String tabuleiroJogador[][] = new String[8][8]; // Tabuleiro que será mostrado ao jogador
        String tabuleiro[][] = new String[8][8]; // Tabuleiro oculto que contém a posição dos navios

        inicializacaoTabuleiro(tabuleiro, tabuleiroJogador); // Inicializa os tabuleiros

        int resultado = interacaoJogador(tabuleiro, tabuleiroJogador, in); // Realiza a interação com o jogador e retorna o número de navios destruídos
        
        fimDoJogo(tabuleiro, tabuleiroJogador, resultado); // Exibe o resultado final do jogo

        in.close();
    }

    // Método para inicializar os tabuleiros, preenchendo-os com água e posicionando navios aleatoriamente
    public void inicializacaoTabuleiro(String tabuleiro[][], String tabuleiroJogador[][]) {                                                          
        Random random = new Random();
        
        // Preenche ambos os tabuleiros com "~" que representa água
        for (int l = 0; l < tabuleiro.length; l++) {
            for (int c = 0; c < tabuleiro[l].length; c++) {
                tabuleiro[l][c] = "~";
                tabuleiroJogador[l][c] = "~";
            }
        }
        int contadorNavios = 0;
    
        // Posiciona 10 navios (representados por "N") aleatoriamente no tabuleiro
        while (contadorNavios != 10) {
            int linha = random.nextInt(8);
            int coluna = random.nextInt(8);

            if (!tabuleiro[linha][coluna].equals("N")) {
                tabuleiro[linha][coluna] = "N"; // Coloca um navio
                contadorNavios++;
            }
        }
    }

    // Método para gerenciar a interação com o jogador, processando os ataques e verificando acertos e erros
    public int interacaoJogador(String tabuleiro[][], String tabuleiroJogador[][], Scanner in) {
        int jogadas = 0; // Contador de jogadas, limite de 30
        int naviosDestruidos = 0; // Contador de navios destruídos, objetivo é 10

        while (jogadas < 30 && naviosDestruidos < 10) {

            System.out.println("Informe uma linha para o ataque e uma coluna para o ataque");
            int x = 0; // linha
            int y = 0; // coluna

            try {
                x = in.nextInt();
                y = in.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Por favor, insira números inteiros válidos.");
                in.nextLine(); // Limpar o buffer do scanner
                continue;
            }

            // Verifica se as coordenadas estão dentro do tabuleiro
            if (x >= 0 && x < 8 && y >= 0 && y < 8) {
                // Verifica se a posição já foi atacada
                if (tabuleiroJogador[x][y].equals("X") || tabuleiroJogador[x][y].equals("O")) {
                    System.out.println("Esta casa já foi atacada, insira outra.");
                    continue;
                } else {
                    jogadas++;
                    // Verifica se o ataque acertou um navio
                    if(tabuleiro[x][y].equals("N")) {
                        tabuleiroJogador[x][y] = "X"; // Marca acerto com "X"
                        naviosDestruidos++;
                        System.out.println("Você acertou!");
                    } else {
                        tabuleiroJogador[x][y] = "O"; // Marca erro com "O"
                        System.out.println("Você errou!");
                    }

                    // Exibe o tabuleiro atualizado do jogador
                    for (int linha = 0; linha < tabuleiro.length; linha++) {
                        for (int coluna = 0; coluna < tabuleiro[linha].length; coluna++) {
                            System.out.print(tabuleiroJogador[linha][coluna] + " ");
                        }
                        System.out.println();
                    }
                }
            } else {
                System.out.println("Coordenadas indisponíveis. Insira valores entre 0-7.");
            }
        }
        return naviosDestruidos; // Retorna o número de navios destruídos pelo jogador
    }

    // Método para exibir o resultado final do jogo
    public void fimDoJogo(String tabuleiro[][], String tabuleiroJogador[][], int naviosDestruidos) {
        System.out.println();
        // Exibe o tabuleiro real com a posição dos navios
        for (int linha = 0; linha < tabuleiro.length; linha++) {
            for (int coluna = 0; coluna < tabuleiro[linha].length; coluna++) {
                System.out.print(tabuleiro[linha][coluna] + " ");
            }
            System.out.println();
        }

        // Exibe a mensagem de vitória ou derrota
        if (naviosDestruidos == 10) {
            System.out.println("Parabéns! Você venceu o jogo.");
        } else {
            System.out.println("Que pena, você perdeu.");
        }
    }

    // Método main para iniciar o jogo
    public static void main(String[] args) {
        new Trabalho();
    }
}
