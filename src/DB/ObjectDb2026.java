package DB;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class ObjectDb2026 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PuntsPU"); //ruta bbdd

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Double> q2 = em.createQuery("SELECT AVG(p.x) FROM Punt p", double.class); //consulta
        TypedQuery<Punt> query = em.createQuery("SELECT p FROM Punt p", Punt.class);
        List<Punt> resultats = query.getResultList();

        System.out.println("Mitjana X : " + q2.getSingleResult());
        resultats.forEach(System.out::println);

//        for (int i = 0; i < 1000; i++) {
//            Punt p = new Punt(i, i);
//            em.persist(p);
//        }
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
