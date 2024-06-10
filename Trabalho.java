package TrabalhoFinal;

import java.util.Random;
import java.util.Scanner;

public class Trabalho {

    public Trabalho() {
        Scanner in = new Scanner(System.in);

        String tabuleiroJogador[][] = new String[8][8]; // vai aparecer no terminal
        String tabuleiro[][] = new String[8][8];

        inicializacaoTabuleiro(tabuleiro, tabuleiroJogador);
        posicaoNavios(tabuleiro);
        interacaoJogador(tabuleiro, tabuleiroJogador, in);

        in.close();
    }

    public void inicializacaoTabuleiro(String tabuleiro[][], String tabuleiroJogador[][]) { // vai preencher tudo com agua
                                                                                 
        for (int l = 0; l < tabuleiro.length; l++) {
            for (int c = 0; c < tabuleiro[l].length; c++) {
                tabuleiro[l][c] = "~ ";
                tabuleiroJogador[l][c] = "~ ";
            }
        }
    }

    public void posicaoNavios(String tabuleiro[][]) {
        int contadorNavios = 0;
        Random random = new Random();

        while (contadorNavios != 10) {
            int linha = random.nextInt(8); 
            int coluna = random.nextInt(8); 

            if (!tabuleiro[linha][coluna].equals("N")) {
                tabuleiro[linha][coluna] = "N"; // coloca navio
                contadorNavios++;
            }
        }
    }

    public void interacaoJogador(String tabuleiro[][], String tabuleiroJogador[][], Scanner in) {
        int jogadas = 0; // acaba com 30
        int naviosDestruidos = 0; // acaba com 10

        while (jogadas < 30 && naviosDestruidos < 10) { 

            System.out.println("Digite as coordenadas para atacar(linha e coluna):");
            int x = in.nextInt(); // linha
            int y = in.nextInt(); // coluna

            if(x >= 0 && x < 8 && y >= 0 && y < 8) { 
                if (tabuleiro[x][y].equals("N")) {
                    tabuleiroJogador[x][y] = " X ";
                    naviosDestruidos++;
                } else {
                    tabuleiroJogador[x][y] = " O ";
                }
                jogadas++;
                
                for (int linha = 0; linha < tabuleiro.length; linha++) {
                    for (int coluna = 0; coluna < tabuleiro[linha].length; coluna++) {
                        System.out.print(tabuleiroJogador[linha][coluna] + " ");
                    }
                    System.out.println();
                }
            }
        }
    }

    public static void main(String[] args) {
        new Trabalho();
    }
}
