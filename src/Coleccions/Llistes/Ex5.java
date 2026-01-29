package Llistes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Persona {

    private final String nom;
    private final int edat;

    public Persona(String nom, int edat) {
        this.nom = nom;
        this.edat = edat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Persona persona = (Persona) o;
        return edat == persona.edat && Objects.equals(nom, persona.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, edat);
    }
}

public class Ex5 {

    public static void main(String[] args) {
        List<Persona> persones = new ArrayList<>(List.of(
                new Persona("Joan", 56),
                new Persona("Manolo", 87),
                new Persona("Enric", 356)
        ));

        Persona repe = new Persona("Joan", 56);

        System.out.println("Comprovació contains: " + persones.contains(repe));
        System.out.println("Posició: " + persones.indexOf(repe));
        //ABANS DE FER ELS OVERRIDE RETORNAVA FALSE I -1
    }
}
