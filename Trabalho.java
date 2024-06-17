package TrabalhoFinal;

import java.util.Random;
import java.util.Scanner;

public class Trabalho {


    public Trabalho() {
        Scanner in = new Scanner(System.in);

        String tabuleiroJogador[][] = new String[8][8]; 
        String tabuleiro[][] = new String[8][8]; 

        inicializacaoTabuleiro(tabuleiro, tabuleiroJogador); 

        int resultado = interacaoJogador(tabuleiro, tabuleiroJogador, in); 
        
        fimDoJogo(tabuleiro, tabuleiroJogador, resultado);

        in.close();
    }

    // Método para inicializar os tabuleiros, preenchendo-os com água e posicionando navios aleatoriamente
    // Parâmetros: 
    // - tabuleiro: matriz representando o tabuleiro real com navios
    // - tabuleiroJogador: matriz representando o tabuleiro que o jogador vê
    // Funções utilizadas: Random para gerar posições aleatórias dos navios no tabuleiro
    // Retorna: não retorna valor
    public void inicializacaoTabuleiro(String tabuleiro[][], String tabuleiroJogador[][]) {                                                          
        Random random = new Random();
        
       
        for (int l = 0; l < tabuleiro.length; l++) {
            for (int c = 0; c < tabuleiro[l].length; c++) {
                tabuleiro[l][c] = "~";
                tabuleiroJogador[l][c] = "~";
            }
        }
        int contadorNavios = 0;
    
 
        while (contadorNavios != 10) {
            int linha = random.nextInt(8);
            int coluna = random.nextInt(8);

            if (!tabuleiro[linha][coluna].equals("N")) {
                tabuleiro[linha][coluna] = "N"; 
                contadorNavios++;
            }
        }
    }

    // Método para gerenciar a interação com o jogador, processando os ataques e verificando acertos e erros
    // Parâmetros:
    // - tabuleiro: matriz representando o tabuleiro real com navios
    // - tabuleiroJogador: matriz representando o tabuleiro que o jogador vê
    // - in: Scanner para ler a entrada do jogador
    // Funções utilizadas: Scanner para entrada do jogador; try-catch para verificar a integridade das respostas, não aceitando letras; if-else para verificar se as respostas estão dentro do intervalo estabelecido(limite do tabuleiro) 
    // Retorna: o número de navios destruídos pelo jogador
    public int interacaoJogador(String tabuleiro[][], String tabuleiroJogador[][], Scanner in) {
        int jogadas = 0; 
        int naviosDestruidos = 0;

        while (jogadas < 30 && naviosDestruidos < 10) {

            System.out.println("Informe uma linha para o ataque e uma coluna para o ataque");
            int x = 0; 
            int y = 0; 

            try {
                x = in.nextInt();
                y = in.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Por favor, insira números inteiros válidos.");
                in.nextLine(); 
                continue;
            }

          
            if (x >= 0 && x < 8 && y >= 0 && y < 8) {
                if (tabuleiroJogador[x][y].equals("X") || tabuleiroJogador[x][y].equals("O")) {
                    System.out.println("Esta casa já foi atacada, insira outra.");
                    continue;
                } else {
                    jogadas++;
                
                    if(tabuleiro[x][y].equals("N")) {
                        tabuleiroJogador[x][y] = "X";
                        naviosDestruidos++;
                        System.out.println("Você acertou!");
                    } else {
                        tabuleiroJogador[x][y] = "O";
                        System.out.println("Você errou!");
                    }

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
        return naviosDestruidos; 
    }

    // Método para exibir o resultado final do jogo
    // Parâmetros:
    // - tabuleiro: matriz representando o tabuleiro real com navios
    // - tabuleiroJogador: matriz representando o tabuleiro que o jogador vê
    // - naviosDestruidos: número de navios destruídos pelo jogador
    // Funções utilizadas: System.out para exibir mensagens e o tabuleiro final, atrelado com duplo laço(for) para imprimir a matriz
    // Retorna: não retorna valor
    public void fimDoJogo(String tabuleiro[][], String tabuleiroJogador[][], int naviosDestruidos) {
        System.out.println();
       
        for (int linha = 0; linha < tabuleiro.length; linha++) {
            for (int coluna = 0; coluna < tabuleiro[linha].length; coluna++) {
                System.out.print(tabuleiro[linha][coluna] + " ");
            }
            System.out.println();
        }

     
        if (naviosDestruidos == 10) {
            System.out.println("Parabéns! Você venceu o jogo.");
        } else {
            System.out.println("Que pena, você perdeu.");
        }
    }


    public static void main(String[] args) {
        new Trabalho();
    }
}
