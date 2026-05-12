package DB.Alumne;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AlumneMain {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("AlumnesPU");
    static EntityManager em = emf.createEntityManager();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        AlumneMain programa = new AlumneMain();
        programa.mostrarMenu();
    }

    public void afegirAlumne() {

        System.out.println("\n<<< REGISTRE D'ALUMNES >>>");

        System.out.println("NOM ALUMNE: ");
        String nom = sc.nextLine();
        System.out.println("EDAT ALUMNE: ");
        int edat = sc.nextInt();
        sc.nextLine();
        System.out.println("NOTA FINAL ALUMNE:");
        double nota = sc.nextDouble();
        sc.nextLine();

        Alumne a = new Alumne(null, nom, edat, nota);
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        System.out.println("Alumne afegit correctament");

    }

    public void llistarAlumnes() {
        System.out.println("\n <<< Alumnes Registrats >>>");
        TypedQuery<Alumne> query = em.createNamedQuery("Alumne.findAll", Alumne.class);
        List<Alumne> llista = query.getResultList();

        if (llista.isEmpty()) {
            System.out.println("No hi ha alumnes registrats.");
        } else {
            llista.forEach(a -> System.out.println(a.toString()));
        }
    }

    public void eliminarAlumne() {
        System.out.println("\n <<< ELIMINACIÓ DE DADES >>>");
        System.out.println("Id de l'alumne: ");
        long id = sc.nextLong();
        sc.nextLine();

        Alumne a = em.find(Alumne.class, id);
        if (a != null) {
            em.getTransaction().begin();
            em.remove(a);
            em.getTransaction().commit();
            System.out.println("Alumne eliminat amb èxit.");
        } else {
            System.out.println("L'alumne que intentes eliminar no existeix.");
        }
    }

    public void actualitzarAlumne() {
        System.out.println("\n <<< MODIFICACIÓ DE DADES >>>");
        System.out.println("ID de l'alumne a actualitzar:");
        long id = sc.nextLong();
        sc.nextLine();

        Alumne a = em.find(Alumne.class, id);

        if (a != null) {
            System.out.println("Nova nota per a " + a.getNom() + ":");
            double novaNota = sc.nextDouble();
            sc.nextLine();

            em.getTransaction().begin();
            a.setNotaFinal(novaNota);
            em.getTransaction().commit();
            System.out.println("Nota actualitzada amb èxit.");
        } else {
            System.out.println("L'alumne que intentes actualitzar no existeix.");
        }
    }

    public void mostrarMenu() {
        int opc = 0;
        do {
            System.out.println("\n\t <<< GESTIÓ DE DADES >>>");
            System.out.println("1. AFEGIR ALUMNE");
            System.out.println("2. LLISTAR ALUMNES");
            System.out.println("3. ACTUALITZAR ALUMNE");
            System.out.println("4. ESBORRAR ALUMNE");
            System.out.println("5. SORTIR");
            System.out.println(">> Quina operació vols realitzar?");
            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1:
                    afegirAlumne();
                    break;
                case 2:
                    llistarAlumnes();
                    break;
                case 3:
                    actualitzarAlumne();;
                    break;
                case 4:
                    eliminarAlumne();
                    break;
                case 5:
                    System.out.println("Programa finalitzat");
                    em.close();
                    emf.close();
                    break;
                default:
                    System.out.println("Opció no vàlida");

            }
        } while (opc != 5);
    }
}
