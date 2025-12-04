package Herencia_i_Polimorfisme.ExEspai;

import java.util.ArrayList;

public class AEC {

    ArrayList<Candidat> candidats = new ArrayList<>();

    public void afegirCandidat(Candidat a) {
        candidats.add(a);
    }

    public void llistar() {
        for (Candidat c : candidats) {
            System.out.println(c);
        }
    }

    public int nombreQualificats() {
        int qualificats = 0;
        for (Candidat c : candidats) {
            if (c.estaQualificat()) {
                qualificats++;
            }
        }
        return qualificats;
    }
}
