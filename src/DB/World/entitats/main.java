package DB.World.entitats;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class main {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("world.odb");
    static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {

    }

    public void llistarPaisos() {
        TypedQuery<Country> query = em.createNamedQuery("Country.findAll", Country.class);
        List<Country> paisos = query.getResultList();
        paisos.forEach(p -> System.out.println(p.toString()));
    }

    public void buscarPaisPerNom(String nom) {
        TypedQuery<Country> query = em.createNamedQuery("Country.findByName", Country.class);
        try {
            query.setParameter("nom", nom);
            Country trobat = query.getSingleResult();
            System.out.println(trobat);
        } catch (NoResultException e) {
            System.out.println(" >> ERROR: El país no s'ha trobat" + e.getMessage());
        }
    }

    public String buscarCapital(String nom) {
        TypedQuery<String> query = em.createNamedQuery("Country.findCapital", String.class);
        try {
            query.setParameter("nom", nom);
            String capital = query.getSingleResult();
            return capital;
        } catch (NoResultException e) {
            System.out.println(" >> ERROR; El país no s'ha trobat" + e.getMessage());
        }
        return null;
    }
    public void calcularPoblacioMudial() {
        TypedQuery<Integer> query = em.createNamedQuery("Country.countAll", Integer.class);
        TypedQuery<Long> query2 = em.createNamedQuery("Country.sumPopulation", Long.class);
        System.out.println("Nombre de països: " + query);
        System.out.println("Població mundial: " + query2);
    }
    public void llistarIdNomPais() {
        TypedQuery<Object[]> query = em.createNamedQuery("Country.getIdAndName", Object[].class);
        List<Object[]> result = query.getResultList();
        for (Object[] fila : result) {
            String id = (String) fila[0];
            String nom = (String) fila[1];
            
            System.out.println("ID: " + id + " | NOM: " + nom);
        }
        
    }
    public void ordenarPoblacioEuropa() {
        TypedQuery<Country> query = em.createNamedQuery("Country.getEuropePopulationRank", Country.class);
        List<Country> paisos = query.getResultList();
        paisos.forEach(p -> System.out.println(">> PAÍS: " + p.getName() + " | POBLACIÓ: " + p.getPopulation()));
    }
    
    public void llistarRegionsGrans(){
        TypedQuery<RegionsFiveCountriesDTO> query = em.createNamedQuery("Country.getRegionsFiveCountries", RegionsFiveCountriesDTO.class);
        List<RegionsFiveCountriesDTO> paisos = query.getResultList();
        
        System.out.println("Regions amb més de 5 països");
        paisos.forEach(p -> System.out.println(">> " + p.getName()));
    }
   
}
