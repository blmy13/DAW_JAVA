package Mètodes_i_Classes.ExBiblio;

public class ExBiblioteca {

    public static void main(String[] args) {

        // Creació de llibres
        Llibre llibre1 = new Llibre("El Quixot", "Miguel de Cervantes", 1605, "Ficció");
        Llibre llibre2 = new Llibre("1984", "George Orwell", 1949, "Ciència-ficció");
        Llibre llibre3 = new Llibre("L'estrany", "Albert Camus", 1942, "Filosofia de l'absurd");
        Llibre llibre4 = new Llibre("Els Germans Karàmazov", "Fiódor Dostoievski", 1880, "Fulletó");

        // Creació d'usuaris
        Usuari usuari1 = new Usuari("Joan", "U001");
        Usuari usuari2 = new Usuari("Messi", "U002");
        Usuari usuari3 = new Usuari("Eustaqui", "U003");

        // Creació de la biblioteca
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.afegirLlibre(llibre1);
        biblioteca.afegirLlibre(llibre2);
        biblioteca.afegirLlibre(llibre3);
        biblioteca.afegirLlibre(llibre4);
        biblioteca.afegirUsuari(usuari1);
        biblioteca.afegirUsuari(usuari2);
        biblioteca.afegirUsuari(usuari3);

        // Operacions
        biblioteca.mostrarLlibresPerCategoria("Ficció");
        biblioteca.prestarLlibre("1984", usuari1);
        biblioteca.retornarLlibre("1984", usuari1);
        biblioteca.prestarLlibre("L'estrany", usuari3);
        biblioteca.prestarLlibre("Els Germans Karàmazov", usuari3);
        biblioteca.mostrarLlibresEnPrestec();
        biblioteca.mostrarLlibresDisponibles();

    }
}
