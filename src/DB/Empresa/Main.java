package DB.Empresa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.NoResultException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmpresaPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.createQuery("DELETE FROM Projecte").executeUpdate();
        em.createQuery("DELETE FROM Empleat").executeUpdate();
        em.createQuery("DELETE FROM Departament").executeUpdate();
        Departament dep = new Departament("Desenvolupament");
        Empleat empleat1 = new Empleat("23879254C", "Larry", 2750.00);
        Empleat empleat2 = new Empleat("78962431W", "Keith", 3500.00);
        dep.afegirEmpleat(empleat1);
        dep.afegirEmpleat(empleat2);

        Projecte proj1 = new Projecte("App Mòbil", 25000.00);
        Projecte proj2 = new Projecte("Web Corporativa", 15000.00);
        empleat1.afegirProjecte(proj1);
        empleat1.afegirProjecte(proj2);
        empleat2.afegirProjecte(proj1);

        em.persist(dep);
        em.persist(proj1);
        em.persist(proj2);
        em.getTransaction().commit();



        llistarInfoDepartaments(em);
        mostrarParticipantsProjecte(em);

        em.close();
        emf.close();
    }

    //mètode static em per paràmetre
    public static void llistarInfoDepartaments(EntityManager em) {
        TypedQuery<Departament> llistat = em.createQuery("SELECT d FROM Departament d", Departament.class);
        List<Departament> depts = llistat.getResultList();

        for (Departament d : depts) {
            System.out.println(d);
            System.out.println("\n -- MEMBRES -- \n");
            for (Empleat e : d.getEmpleats()) {
                System.out.println(e);
            }
        }
    }

    public static void mostrarParticipantsProjecte(EntityManager em) {
        TypedQuery<Projecte> query = em.createQuery("SELECT p FROM Projecte p WHERE p.nomProjecte = 'App Mòbil'", Projecte.class);

        try {
            Projecte p = query.getSingleResult();
            System.out.println("\n -- PARTICIPANTS DEL PROJECTE " + p.getNomProjecte() + " -- \n");
            List<Empleat> empleats = p.getEmpleats();
            empleats.forEach(System.out::println);
        } catch (NoResultException ex) {
            System.out.println("No s'ha trobat cap projecte amb aquest nom.");
        }
    }
}