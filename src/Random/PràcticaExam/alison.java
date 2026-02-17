package Random.PràcticaExam;

import java.util.*;

public class alison {

    public static void main(String[] args) {
        Map<String, Integer> socis = new HashMap<>();
        socis.put("12345678A", 25);
        socis.put("87654321B", 17);
        socis.put("11223344C", 40);
        socis.put("55667788D", 16);
        
        //Consulta simple: Escriu una línia de codi per obtenir l'edat del soci amb DNI "11223344C" i guarda-la en una variable.
        Integer edat = socis.get("11223344C");
        System.out.println(edat);
        
        //Recorregut de claus: Escriu un bucle for-each que només recorri les claus (keySet) i les imprimeixi per pantalla.
        Set<String> dnis = new TreeSet(socis.keySet());
        for (String d : dnis) {
            System.out.println(d);
        }
  

        //Escriu un bucle for-each que recorri tot el mapa i sumi +1 any a tots els socis que siguin menors d'edat (edat < 18)
        for (String s : dnis){
            if (socis.get(s) < 18) {
                socis.put(s, socis.get(s) + 1);
            }
        }
    }
}
