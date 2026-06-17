package DB.Examen;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExamenPU");
        EntityManager em = emf.createEntityManager();

        mostrarMenu(sc, em, emf);

    }

    public static void mostrarMenu(Scanner sc, EntityManager em, EntityManagerFactory emf) {
        int opcio = 0;
        do {
            System.out.println("--- MENÚ ---");
            System.out.println("1. AFEGIR CLIENT");
            System.out.println("2. AFEGIR ACTIVITAT");
            System.out.println("3. INSCRIURE CLIENT A ACTIVITAT");
            System.out.println("4. LLISTAR ACTIVITATS CLIENT (DNI C)");
            System.out.println("5. LLISTAR CLIENTS ACTIVITATS (NOM A)");
            System.out.println("6. LLISTAR INFO");
            System.out.println("0. SORTIR");
            System.out.println("  >> TRIA UNA OPCIÓ:");

            opcio = sc.nextInt();
            sc.nextLine();

            switch (opcio) {
                case 1:
                    inserirClient(em, sc);
                    break;
                case 2:
                    inserirActivitat(em, sc);
                    break;
                case 3:
                    System.out.println("DNI CLIENT:");
                    String dni = sc.nextLine();
                    System.out.println("NOM ACTIVITAT:");
                    String nom = sc.nextLine();
                    inscriureClient(dni, nom, em);
                    break;
                case 4:
                    System.out.println("DNI CLIENT:");
                    String dniClient = sc.nextLine();
                    llistarActivitatsClient(dniClient, em);
                    break;
                case 5:
                    System.out.println("NOM ACTIVITAT:");
                    String act = sc.nextLine();
                    llistarClientsActivitat(act, em);
                    break;
                case 6:
                    mostrarInfo(em);
                    break;
                case 0:
                    System.out.println("Programa finalitzat.");
                    em.close();
                    emf.close();
                    break;
                default:
                    System.out.println("OPCIÓ NO VÀLIDA.");
            }


        } while (opcio != 0);
        sc.close();
    }

    public static void inserirClient(EntityManager em, Scanner sc) {
        System.out.println("-- INSERCIÓ CLIENT --");
        System.out.println("DNI CLIENT:");
        String dni = sc.nextLine();

        Client existent = em.find(Client.class, dni);

        if (existent == null) {
            System.out.println("NOM CLIENT:");
            String nom = sc.nextLine();
            System.out.println("EDAT CLIENT:");
            int edat = sc.nextInt();
            sc.nextLine();
            System.out.println("CORREU CLIENT:");
            String correu = sc.nextLine();

            Client c = new Client(dni, nom, edat, correu);

            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
            System.out.println(">> CLIENT AFEGIT CORRECTAMENT.");
        } else {
            System.out.println(">> ERROR: Ja existeix un client amb aquest DNI.");
        }
    }

    public static void inserirActivitat(EntityManager em, Scanner sc) {
        System.out.println("-- INSERCIÓ ACTIVITAT --");
        System.out.println("NOM ACTIVITAT");
        String nom = sc.nextLine();

        Activitat existent = em.find(Activitat.class, nom);

        if (existent == null) {
            String nivell = "";
            boolean nivellValid = false;

            do {
                System.out.println("NIVELL ACTIVITAT (inicial, mitjà, avançat):");
                nivell = sc.nextLine();
                try {
                    new Activitat(nom, nivell, 0);
                    nivellValid = true;
                } catch (NivellNoValidException e) {
                    System.out.println(e.getMessage() + " Torna-ho a provar.");
                }
            } while (!nivellValid);
            System.out.println("PLACES ACTIVITAT:");
            int places = sc.nextInt();
            sc.nextLine();

            Activitat a = new Activitat(nom, nivell, places);

            em.getTransaction().begin();
            em.persist(a);
            em.getTransaction().commit();
            System.out.println(">> ACTIVITAT AFEGIDA CORRECTAMENT.");
        } else {
            System.out.println(">> ERROR: Ja existeix una activitat amb aquest nom.");
        }

    }

    public static void inscriureClient(String dni, String nom, EntityManager em) {
        System.out.println("-- INSCRIPCIÓ A " + nom.toUpperCase() + " --");
        if (em.find(Client.class, dni) != null && em.find(Activitat.class, nom) != null) {
            Client c = em.find(Client.class, dni);
            Activitat a = em.find(Activitat.class, nom);

            em.getTransaction().begin();
            c.afegirActivitat(a);
            em.getTransaction().commit();
            System.out.println(">> INSCRIPCIÓ REALITZADA AMB ÈXIT");
        } else {
            System.out.println(">> ERROR: O el client o l'activitat no existeixen");
        }
    }

    public static void llistarActivitatsClient(String dni, EntityManager em) {
        TypedQuery<Activitat> query = em.createQuery("SELECT a FROM Client c JOIN c.activitats a WHERE c.dni = :dni", Activitat.class);
        query.setParameter("dni", dni);
        List<Activitat> activitats = query.getResultList();
        if (!activitats.isEmpty()) {
            System.out.println("-- ACTIVITATS CLIENT DNI " + dni.toUpperCase() + " --");
            activitats.forEach(System.out::println);
        } else {
            System.out.println("Aquest client no està registrat a cap activitat.");
        }
    }

    public static void llistarClientsActivitat(String nom, EntityManager em) {
        TypedQuery<Client> query = em.createQuery("SELECT c FROM Activitat a JOIN a.clients c WHERE a.nom = :nom", Client.class);
        query.setParameter("nom", nom);
        List<Client> clients = query.getResultList();
        if (!clients.isEmpty()) {
            System.out.println("-- CLIENTS REGISTRATS A L'ACTIVITAT " + nom.toUpperCase() + " --");
            clients.forEach(System.out::println);
        } else {
            System.out.println("Cap client està inscrit a aquesta activitat.");
        }

    }

    public static void mostrarInfo(EntityManager em) {
        TypedQuery<Client> query = em.createQuery("SELECT c FROM Client c", Client.class);
        List<Client> clients = query.getResultList();
        if (!clients.isEmpty()) {
            clients.forEach(c -> {
                System.out.println("\n" + c);
                if (!c.getActivitats().isEmpty()) {
                    c.getActivitats().forEach(System.out::println);
                } else {
                    System.out.println(">> Sense Activitats Assignades");
                }
            });
        } else {
            System.out.println("No hi ha clients registrats");
        }
    }
}
