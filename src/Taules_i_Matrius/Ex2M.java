package Taules_i_Matrius;

/**
 * Fes un programa que ens digui si dos matrius són exactament iguals, o sigui
 * que per tot i,j, matriu1[i][j] = matriu2[i][j]
 */
public class Ex2M {

    public static void main(String[] args) {

        int[][] matriu1 = {{3, 8, 9, 1, 47, 5, 2}, {3, 8, 9, 1, 47, 5, 2}, {3, 8, 9, 1, 47, 5, 2}};
        int[][] matriu2 = {{3, 8, 9, 1, 47, 5, 2}, {3, 8, 9, 1, 48, 5, 2}, {3, 8, 9, 1, 47, 5, 2}};
        
        boolean iguals = true;
        int i, j;
        i = 0;
        while (i < matriu1.length && iguals) {
            j = 0;
            while (j < matriu2[i].length && iguals) {
                if (matriu1[i][j] != matriu2[i][j]) {
                    iguals = false;
                }
                j++;
            }
            i++;
        }
        String result = iguals ? "Son iguals." : "No son iguals";
        System.out.println(result);
    }

}
