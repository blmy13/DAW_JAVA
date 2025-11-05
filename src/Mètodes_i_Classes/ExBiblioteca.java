package Mètodes_i_Classes;


public class ExBiblioteca {

    public static void main(String[] args) {

        // Creació de llibres
        Llibre llibre1 = new Llibre("El Quixot", "Miguel de Cervantes", 1605, "Ficció");
        Llibre llibre2 = new Llibre("1984", "George Orwell", 1949, "Ciència-ficció");

        // Creació d'usuaris
        Usuari usuari1 = new Usuari("Joan", "U001");

        // Creació de la biblioteca
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.afegirLlibre(llibre1);
        biblioteca.afegirLlibre(llibre2);
        biblioteca.afegirUsuari(usuari1);

        // Operacions
        biblioteca.mostrarLlibresPerCategoria("Ficció");
        biblioteca.prestarLlibre("1984", usuari1);
        biblioteca.retornarLlibre("1984", usuari1);

    }
}
