package Taules_i_Matrius;

/*
Fes un programa que donades dues taules inicialitzades amb els valors
 {-3, 5, 1, -4, 8, 20, -9, 2, 11, -1}, posi a una tercera taula, per a cada posició, la
suma dels elements de les altres taules.
*/

public class Ex1 {
    public static void main(String[] args) {

        int taula1[] = {-3, 5, 1, -4, 8, 20, -9, 2, 11, -1};
        int taula2[] = {-3, 5, 1, -4, 8, 20, -9, 2, 11, -1};
        int taula3[] = new int[taula2.length];
        for (int i = 0; i < taula2.length; i++) {
            taula3[i] = taula2[i] + taula1[i];
        }
    }
}
