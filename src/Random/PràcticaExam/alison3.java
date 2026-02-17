package Random.PràcticaExam;

import java.util.*;

class Canco {

    String titol;
    String artista;
    int reproduccions;

    public Canco(String titol, String artista, int reproduccions) {
        this.titol = titol;
        this.artista = artista;
        this.reproduccions = reproduccions;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getReproduccions() {
        return reproduccions;
    }

    public void setReproduccions(int reproduccions) {
        this.reproduccions = reproduccions;
    }

    @Override
    public String toString() {
        return "Canco{" + "titol=" + titol + ", artista=" + artista + ", reproduccions=" + reproduccions + '}';
    }
    
    

}

public class alison3 {

    public static void main(String[] args) {
        List<Canco> llistaCancons = List.of(
                new Canco("Flowers", "Miley Cyrus", 1500),
                new Canco("Stay", "The Kid LAROI", 800),
                new Canco("Blinding Lights", "The Weeknd", 3000),
                new Canco("Shivers", "Ed Sheeran", 1200),
                new Canco("Bad Guy", "Billie Eilish", 950)
        );
        
        List <Canco> songs = llistaCancons.stream()
                .filter(p -> p.getReproduccions() < 1000)
                .sorted(Comparator.comparing(Canco::getReproduccions).reversed())
                .toList();
        
        System.out.println(songs);
                
    }
}
