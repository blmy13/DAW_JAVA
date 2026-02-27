package Test;
import java.util.*;
public class Maps3 {
    public static void main(String[] args) {

        Map <String, Integer> notes = new HashMap<>();

        notes.put("Leandoer", 8);
        notes.put("Bladee", 7);
        notes.put("Lorna", 10);
        notes.put("Junior", 9);

        for (Map.Entry<String, Integer> entry : notes.entrySet()) {
            String nom = entry.getKey();
            int nota = entry.getValue();

            if (nota <= 5) {
                System.out.println("Alumne: " + nom + " || Nota: " + nota);
            }
        }
        //Comportament put vs putIfAbsent
        notes.put("Leandoer", 4);
        System.out.println(notes);
        notes.putIfAbsent("Lorna", 4);
        System.out.println(notes);
        //El mètode put sobreescriu el valor que hi ha al mapa, el mètode putIfAbsent només funciona si no hi ha un valor previ.

    }
}
