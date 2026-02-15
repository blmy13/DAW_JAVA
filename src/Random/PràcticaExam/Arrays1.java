package Random.PràcticaExam;

import java.util.Arrays;

public class Arrays1 {
    public static void main(String[] args) {
        int notes[] = {7, 4, 9, 2, 5};

        //Ordenar de menor a major
        Arrays.sort(notes);
        System.out.println(Arrays.toString(notes));

        //Cerca posició num 9
        int pos = Arrays.binarySearch(notes, 9);

        //Declarar i omplir Array
        int[]dades = new int[10];
        Arrays.fill(dades, -1);
        System.out.println(Arrays.toString(dades));

        //Copia Array
        int[] copia = Arrays.copyOf(notes, notes.length);
        System.out.println(Arrays.toString(copia));
    }
}
