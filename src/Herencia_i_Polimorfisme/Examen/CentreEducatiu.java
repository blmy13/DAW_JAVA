package Herencia_i_Polimorfisme.Examen;

import java.util.ArrayList;

public class CentreEducatiu {

   private final ArrayList <Alumne> alumnes = new ArrayList<>();

   public void agregarAlumne(Alumne alumne) {
       alumnes.add(alumne);
   }

   public int nombreAprovats() {
       int contAprovats = 0;
       for (Alumne a : alumnes) {
            if (a.aprova()) {
                contAprovats++;
            }
       }
       return contAprovats;

   }
    public void llistar() {

        for (Alumne a : alumnes) {
            System.out.print(a.toString() + "\n");
            System.out.print("Exàmens:\n");

            for (Examen e : a.getExamens()) {
                String estatExamen = e.aprova() ? "Aprovat" : "Suspès";
                System.out.print(e + " " + estatExamen + "\n");
            }
            System.out.print("\n");
        }
    }
}
