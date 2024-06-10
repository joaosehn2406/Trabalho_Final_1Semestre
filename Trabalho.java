package TrabalhoFinal;

import java.util.Scanner;

public class Trabalho {
    
    public Trabalho(){
        Scanner in = new Scanner(System.in);

        String matriz[][] = new String[8][8];
        adicionarAgua(matriz);
        imprimirTabuleiro(matriz);
        in.close();
    }


    public void adicionarAgua(String matriz[][]){
        for(int linha = 0; linha < matriz.length; linha++){
            for(int coluna = 0; coluna < matriz[linha].length; coluna++){
                matriz[linha][coluna] = "~";
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
