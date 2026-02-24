package Files.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Competicio {

    public static void main(String[] args) {

        List<String> equips = List.of("Alison", "Marc", "Enric", "Satan", "Mochi");
        String nom = "resultats.txt"; 

    }
    
    public static void escriureResultatsAleatoris(String nom, List<String> equips) {
        
        Random gol = new Random();
        gol.nextInt(8);
        
        try (Formatter f = new Formatter(nom)) {
            //escriure a resultat.txt els partits 
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }
}
