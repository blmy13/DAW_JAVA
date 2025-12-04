package Herencia_i_Polimorfisme.ExEspai;

import java.time.LocalDate;
import java.util.ArrayList;

public class main {

    public static void main(String[] args) {

        AEC agencia = new AEC();

        LocalDate dataProva1 = LocalDate.of(2025, 11, 25);
        LocalDate dataProva2 = LocalDate.of(2025, 12, 01);
        LocalDate dataProva3 = LocalDate.of(2025, 12, 04);

        // Proves - 100% Superades (Qualificat)
        ArrayList<Qualificable> provesAptes = new ArrayList<>();
        provesAptes.add(new SimuladorTecnic(95, dataProva1));
        provesAptes.add(new AvaluacioPsicologica(dataProva2, NivellEstabilitat.EXCEL_LENT));
        provesAptes.add(new SimuladorTecnic(80, dataProva3));

        // Proves - Una Suspesa (No Qualificat)
        ArrayList<Qualificable> provesNoAptes = new ArrayList<>();
        provesNoAptes.add(new SimuladorTecnic(90, dataProva1));
        provesNoAptes.add(new AvaluacioPsicologica(dataProva2, NivellEstabilitat.TENSIONAT));
        provesNoAptes.add(new SimuladorTecnic(100, dataProva3));

        // Proves - Una altra Suspesa (No Qualificat)
        ArrayList<Qualificable> provesMixtes = new ArrayList<>();
        provesMixtes.add(new SimuladorTecnic(79, dataProva1));
        provesMixtes.add(new AvaluacioPsicologica(dataProva2, NivellEstabilitat.ACCEPTABLE));


        // 3. Crear Candidats
        Candidat c1 = new Candidat("41414141A", "Font", "Helena", provesAptes);
        Candidat c2 = new Candidat("12345678B", "Riera", "Marc", provesNoAptes);
        Candidat c3 = new Candidat("87654321C", "Puig", "Laura", provesMixtes);
        Candidat c4 = new Candidat("98765432D", "Serra", "Jordi", provesAptes);


        // 4. Afegir candidats a l'agència
        agencia.afegirCandidat(c1);
        agencia.afegirCandidat(c2);
        agencia.afegirCandidat(c3);
        agencia.afegirCandidat(c4);

        // 5. Mostrar la llista de resultats i el total d'aprovats
        System.out.println("--- RESULTATS DE LA SELECCIÓ ESPACIAL ---");
        agencia.llistar();

        // 6. Mostrar el recompte final
        System.out.println("\nResum de la selecció: " + agencia.nombreQualificats() + " candidats qualificats per a la missió.");
    }
}
