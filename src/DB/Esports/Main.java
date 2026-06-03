package DB.Esports;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EsportsPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.createQuery("DELETE FROM Torneig").executeUpdate();
        em.createQuery("DELETE FROM Jugador").executeUpdate();
        em.createQuery("DELETE FROM Equip").executeUpdate();

        // DADES
        Equip e1 = new Equip("Fnatic", "UK", 50000.0);
        Equip e2 = new Equip("G2 Esports", "Spain", 75000.0);

        Jugador j1 = new Jugador("Rekkles", 26, "ADC");
        Jugador j2 = new Jugador("Razork", 22, "Jungle");
        Jugador j3 = new Jugador("Caps", 23, "Mid");
        Jugador j4 = new Jugador("Jankos", 27, "Jungle");

        Torneig t1 = new Torneig("LEC", 200000.0);
        Torneig t2 = new Torneig("Worlds", 1000000.0);

        // AFEGIR EQUIPS A TORNEIGS
        t1.afegirEquip(e1);
        t1.afegirEquip(e2);
        t2.afegirEquip(e2);

        // AFEGIR JUGADORS A EQUIPS
        e1.afegirJugador(j1);
        e1.afegirJugador(j2);
        e2.afegirJugador(j3);
        e2.afegirJugador(j4);

        // PERSIST
        em.persist(t1);
        em.persist(t2);
        em.persist(e1);
        em.persist(e2);

        em.getTransaction().commit();

        // LÒGICA
        mostrarMenu(emf, em);
    }

    public static void mostrarMenu(EntityManagerFactory emf, EntityManager em) {
        Scanner sc = new Scanner(System.in);
        int opcio = 0;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Llistar jugadors per rol");
            System.out.println("2. Llistar jugadors d'un torneig");
            System.out.println("3. Llistar equips rics per País");
            System.out.println("0. Sortir");
            System.out.print("Tria una opció: ");
            opcio = sc.nextInt();
            sc.nextLine();

            switch (opcio) {
                case 1:
                    System.out.print("Introdueix un rol: ");
                    String rol = sc.nextLine();
                    llistarPerRol(rol, em);
                    break;
                case 2:
                    System.out.print("Introdueix el nom del torneig: ");
                    String nom = sc.nextLine();
                    llistarJugadorsTorneig(nom, em);
                    break;
                case 3:
                    System.out.print("Introdueix el país: ");
                    String pais = sc.nextLine();
                    System.out.print("Introdueix el pressupost mínim: ");
                    Double pressupost = sc.nextDouble();
                    sc.nextLine();
                    llistarEquipsSegonsPressupost(pais, pressupost, em);
                    break;
                case 0:
                    System.out.println("Programa finalitzat.");
                    em.close();
                    emf.close();
                    break;
                default:
                    System.out.println("Operació no vàlida");
            }
        } while (opcio != 0);
        sc.close();
    }

    public static void llistarPerRol(String rol, EntityManager em) {
        TypedQuery<Jugador> query = em.createQuery("SELECT j FROM Jugador j WHERE j.rol = :rol", Jugador.class);
        query.setParameter("rol", rol);

        List<Jugador> resultats = query.getResultList();
        if (!resultats.isEmpty()) {
            resultats.forEach(System.out::println);
        } else {
            System.out.println("No s'han trobat jugadors d'aquest rol.");
        }
    }

    public static void llistarJugadorsTorneig(String nom, EntityManager em) {
        TypedQuery<Jugador> query = em.createQuery(
                "SELECT j FROM Jugador j JOIN j.equip e JOIN e.torneigs t WHERE t.nom = :nom", Jugador.class);
        query.setParameter("nom", nom); // CORREGIT: T'havies deixat el setParameter!

        List<Jugador> resultats = query.getResultList();
        if (!resultats.isEmpty()) {
            resultats.forEach(System.out::println);
        } else {
            System.out.println("No hi ha jugadors registrats a aquest torneig.");
        }
    }

    public static void llistarEquipsSegonsPressupost(String nom, Double pressupost, EntityManager em) {
        TypedQuery<Equip> query = em.createQuery(
                "SELECT e FROM Equip e WHERE e.pressupost > :pre AND e.pais = :nom", Equip.class);
        query.setParameter("pre", pressupost);
        query.setParameter("nom", nom);

        List<Equip> resultats = query.getResultList();
        if (!resultats.isEmpty()) {
            resultats.forEach(System.out::println);
        } else {
            System.out.println("No s'ha trobat cap equip amb aquests requisits.");
        }
    }
}