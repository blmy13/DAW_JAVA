package DB.Hospital;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HospitalPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        //ESBORRAR
        em.createQuery("DELETE FROM Metge").executeUpdate();
        em.createQuery("DELETE FROM Pacient").executeUpdate();
        em.createQuery("DELETE FROM Hospital").executeUpdate();

        //DADES
        Hospital hosp1 = new Hospital("Barcelona", "Hospital Clínic");
        Metge m1 = new Metge("M001", "Dr.House", "Diagnòstic");
        Metge m2 = new Metge("M002", "Dra. Grey", "Cirurgia");
        Pacient p1 = new Pacient("1111A", "Anna", 25);
        Pacient p2 = new Pacient("2222B", "Marc", 42);
        Pacient p3 = new Pacient("333C", "Lluís", 70);

        //METGES A HOSPITAL
        hosp1.afegirMetge(m1);
        hosp1.afegirMetge(m2);
        //METGES A PACIENTS
        m1.afegirPacient(p1);
        m1.afegirPacient(p3);
        m2.afegirPacient(p2);
        m2.afegirPacient(p3);
        //PERSIST
        em.persist(hosp1);
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.getTransaction().commit();
        //LÒGICA
        mostrarMenu(emf, em);

    }

    public static void mostrarMenu(EntityManagerFactory emf, EntityManager em) {
        Scanner sc = new Scanner(System.in);
        int opcio;
        do {
            System.out.println("--- MENÚ ---");
            System.out.println("1. Llistar metges per especialitat");
            System.out.println("2. Llistar pacients d'un hospital específic");
            System.out.println("3. Llistar pacients majors d'edat d'un metge");
            System.out.println("0. Sortir");
            System.out.println("Tria una opció");
            opcio = sc.nextInt();
            sc.nextLine();

            switch (opcio){
                case 1:
                    System.out.println("Introdueix l'especialitat");
                    String esp = sc.nextLine();
                    buscarMetgesEspecialitat(esp, em);
                    break;
                case 2:
                    System.out.println("Introdueix el nom de l'Hospital");
                    String hosp = sc.nextLine();
                    llistarPacientsHospital(hosp, em);
                    break;
                case 3:
                    System.out.println("Introdueix el número de colegiat del metge");
                    String num = sc.nextLine();
                    llistarMajors(num, em);
                    break;
                case 0:
                    System.out.println("Finalitzant programa.");
                    em.close();
                    emf.close();
                default:
                    System.out.println("Operació no vàlida");

            }

        } while (opcio != 0);
        sc.close();
    }
    public static void buscarMetgesEspecialitat(String e, EntityManager em) {

        TypedQuery<Metge> query = em.createQuery("SELECT m FROM Metge m WHERE m.especialitat = :esp", Metge.class);
        query.setParameter("esp", e);
        List<Metge> especialitats = query.getResultList();
        if (!especialitats.isEmpty()) {
            especialitats.forEach(System.out::println);
        } else {
            System.out.println(" >> ERROR: No s'ha trobat cap metge amb aquesta especialitat.");
        }
    }
    public static void llistarPacientsHospital(String nom, EntityManager em) {
        TypedQuery<Pacient> query = em.createQuery("SELECT p FROM Pacient p JOIN p.metges m WHERE m.hospital.nom = :nom", Pacient.class);
        query.setParameter("nom", nom);
        List<Pacient> pacients = query.getResultList();
        pacients.forEach( p -> {
            if(!p.getMetges().isEmpty()) {
                System.out.println(p);
            }
        });
    }
    public static void llistarMajors(String num, EntityManager em) {
        TypedQuery<Pacient> query = em.createQuery("SELECT p FROM Pacient p JOIN p.metges m WHERE m.numColegiat = :num", Pacient.class);
        query.setParameter("num", num);
        List<Pacient> pacients = query.getResultList();
        pacients.stream()
                .filter(p -> p.getEdat() > 65)
                .forEach(System.out::println);
    }
}
