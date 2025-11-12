package Mètodes_i_Classes.ExNotes;

import java.util.ArrayList;

public class NotesMain {
    public static void imprimirNotes(ArrayList<Nota> notes){
        for (Nota nota : notes) {
            System.out.println(nota.getAlumne().getNom());
            System.out.println(nota.getModul().getNom());
            System.out.println(nota.getNota());  
        }
    }

    public static void main(String[] args) {

        //Creació mòduls
        Modul modul1 = new Modul(001, "Literatura Moldava", 2);
        Modul modul2 = new Modul(404, "Adoctrinament", 1);
        Modul modul3 = new Modul(602, "Budisme Contemporani", 2);

        //Creació alumnes
        Alumne alumne1 = new Alumne("24875492C", "Àlex", 86);
        Alumne alumne2 = new Alumne("54872234Q", "Ghandi", 12);
        Alumne alumne3 = new Alumne("78412563H", "Miles Davis", 54);

        //Creació notes
        Nota nota1 = new Nota(modul1, alumne1, 9.87);
        Nota nota2 = new Nota(modul2, alumne1, 10);
        Nota nota3 = new Nota(modul3, alumne1, 6.76);
        Nota nota4 = new Nota(modul1, alumne2, 8.34);
        Nota nota5 = new Nota(modul2, alumne2, 9.88);
        Nota nota6 = new Nota(modul3, alumne2, 7.81);
        Nota nota7 = new Nota(modul1, alumne3, 8.12);
        Nota nota8 = new Nota(modul2, alumne3, 4.07);
        Nota nota9 = new Nota(modul3, alumne3, 2.07);

        //Assignació notes
        ArrayList<Nota> notes = new ArrayList<>();
       
        notes.add(nota1);
        notes.add(nota2);
        notes.add(nota3);
        notes.add(nota4);
        notes.add(nota5);
        notes.add(nota6);
        notes.add(nota7);
        notes.add(nota8);
        notes.add(nota9);
        
        //Print
        imprimirNotes(notes);
        

    }

}
