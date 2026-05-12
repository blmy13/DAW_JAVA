package DB.Alumne;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlumneMain {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("AlumnesPU");
    static EntityManager em = emf.createEntityManager();
    static List<Alumne> alumnes = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

    }

    public void omplirAlumnes() {
        if (!alumnes.isEmpty()) {
            alumnes.clear();
            em.getTransaction().begin();
        }
        System.out.println("Id Alumne:");
        
        em.getTransaction().begin();
        alumnes.forEach(a -> em.persist(a));
    }
}
