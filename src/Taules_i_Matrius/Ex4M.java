package Taules_i_Matrius;

/*
Fes un programa que donada una matriu d’enters de 2 files i 3 columnes
(amb els valors introduïts per codi), escrigui el valor màxim de cada una de
les files i de les columnes.
*/
 
public class Ex4M {
    
    public static void main(String[] args) {
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int[][] matriu = {{7,5,8}, {8,9,47}};

        for (int i = 0; i < matriu.length; i++) {
            for (int j = 0; j < matriu[i].length; j++) {
                if (matriu[i][j] < min) {
                    min = matriu[i][j];
                }
                if (matriu[i][j] > max) {
                    max = matriu[i][j];
                }
            }
        }
        System.out.println("Màxim; " + max + "\nMínim; " + min);
    }
}
