package DB.Institut;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class InsercioMassiva {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InstitutPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Random rand = new Random();
        List<Modul> moduls = new ArrayList<>();
        List<Ra> rasTotals = new ArrayList<>();

        // PRIMER: crear mòduls i RA
        for (int m = 1; m <= 5; m++) {
            Modul modul = new Modul(m, "Mòdul " + m, 180);
            List<Ra> raList = new ArrayList<>();

            for (int r = 1; r <= 3; r++) {
                Ra ra = new Ra(r, "RA " + r + " del Mòdul " + m, 60, 100.0 / 3, modul);
                em.persist(ra);
                raList.add(ra);
                rasTotals.add(ra);
            }

            modul.setRas(raList);
            em.persist(modul);
            moduls.add(modul);
        }

        // SEGON: crear alumnes i assignar-los RAs aleatoris
        for (int i = 1; i <= 50; i++) {
            String dni = String.format("%08dA", i);
            Alumne alumne = new Alumne(dni, "Alumne " + i, 18 + rand.nextInt(5));
            List<Nota> notes = new ArrayList<>();

            Collections.shuffle(rasTotals);
            for (int j = 0; j < 5; j++) {
                Ra ra = rasTotals.get(j);
                double valor = 4.0 + rand.nextDouble() * 6.0;
                Nota n = new Nota(Math.round(valor * 10.0) / 10.0, alumne, ra);
                em.persist(n);
                notes.add(n);
            }

            alumne.setNotes(notes);
            em.persist(alumne);
        }

        em.getTransaction().commit();

        System.out.println("<< MÒDULS I RA's >>");

        // tots els moduls
        TypedQuery<Modul> queryModuls = em.createQuery("SELECT m FROM Modul m", Modul.class);
        List<Modul> llistaModuls = queryModuls.getResultList();

        for (Modul m : llistaModuls) {
            System.out.println("Mòdul: " + m.getNom() + " (Durada: " + m.getDurada() + "h)");

            for (Ra ra : m.getRas()) {
                System.out.printf("  -> %s | Durada: %dh | Pes: %.2f%%\n",
                        ra.getNom(), ra.getDurada(), ra.getPes());
            }
            System.out.println();
        }

        System.out.println("<< ALUMNES I NOTES >>");

        // tots els alumnes
        TypedQuery<Alumne> queryAlumnes = em.createQuery("SELECT a FROM Alumne a", Alumne.class);
        List<Alumne> llistaAlumnes = queryAlumnes.getResultList();

        for (Alumne a : llistaAlumnes) {
            System.out.println("Alumne: " + a.getNom() + " (DNI: " + a.getDniA() + ")");
            System.out.println("  Notes individuals dels RA:");

            for (Nota n : a.getNotes()) {
                System.out.println("    - " + n.getRa().getNom() + ": " + n.getNota());
            }

            System.out.println("  Notes FINALS calculades per mòdul:");
            for (Modul m : llistaModuls) {
                double notaFinal = a.calcularNotaFinalModul(m);

                if (notaFinal > 0) {
                    System.out.printf("    => %s: %.2f\n", m.getNom(), notaFinal);
                }
            }
        }

        em.close();
        emf.close();
    }
}