package Random.PràcticaExam;

import java.util.*;

public class arrays2 {
    public static void main(String[] args) {
        
        int[][] tauler = {{5, 10, 15}, {20, 25, 30}};
        int suma = 0;
        
        //Que retornen?
        System.out.println(tauler.length);
        System.out.println(tauler[0].length);
        
        for (int j = 0; j < tauler.length; j++) {
            suma += tauler[1][j];
            
        }
        System.out.println(suma);
        tauler[1][2] = 0;
    }
}
