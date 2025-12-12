package Taules_i_Matrius;

/**
 * Fes un programa que sumi dos matrius quadrades (mateix nombre de files que de
 * columnes) de mida de les mateixes mides. El resultat es guardarà en una altra
 * matriu. Cal recordar que la suma de les matrius funciona de la següent forma
 * : a la posició [x][y] de la matriu resultat se li assigna la suma de les
 * posicions [x][y] de les dues matrius originals. És per això que la matriu
 * resultat haurà de ser de les mateixes dimensions que les altres.
 */
public class Ex1M {

    public static void main(String[] args) {
        int[][] matriu1 = {{2, 3,}, {8, 9}};
        int[][] matriu2 = {{7, 5}, {6, 7}};

        int[][] matriu3 = new int[matriu1.length][matriu1.length];

        for (int i = 0; i < matriu3.length; i++) {
            for (int j = 0; j < matriu3.length; j++) {
                matriu3[i][j] = matriu1[i][j] + matriu2[i][j];
            }
        }

        for (int i = 0; i < matriu3.length; i++) {
            for (int j = 0; j < matriu3.length; j++) {
                System.out.print(matriu3[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
