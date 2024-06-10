package TrabalhoFinal;

import java.util.Scanner;

public class Trabalho {
    
    public Trabalho(){
        Scanner in = new Scanner(System.in);

        String tabuleiroJogador[][] = new String[8][8];
        String tabuleiro[][] = new String[8][8];



        
        in.close();
    }


    public void adicionarAgua(String tabuleiro[][], String tabuleiroJogador[][]) {
        for(int l = 0; l < tabuleiro.length; l++ ) {
            for(int c = 0; c < tabuleiro[l].length; c++) {
                tabuleiro[l][c] = " ~ ";
                tabuleiroJogador[l][c] = " ~ ";
            }
        }
    }

    public void imprimirTabuleiro(String matriz[][]){
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[i].length; j++){
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void escolherAleatorio(){

    }

    
    
    public static void main(String[] args) {
        new Trabalho();
    }
}
