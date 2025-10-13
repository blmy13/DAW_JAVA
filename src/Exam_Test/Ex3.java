package Exam_Test;

public class Ex3 {
    public static void main(String[] args) {

        String missatge = "Aquesta és una prova amb la seqüència XY a dins.";

        boolean found = false;
        int llargada = missatge.length();

        // for només fins a length-1 perquè comprovem 2 caràcters
        for (int i = 0; i < llargada - 1; i++) {

            if (missatge.charAt(i) == 'X') {
                if (missatge.charAt(i + 1) == 'Y') {
                    found = true;
                    break;
                }
            }
        }


        if (found) {
            System.out.println("La seqüència 'XY' SÍ que apareix en el missatge.");
        } else {
            System.out.println("La seqüència 'XY' NO apareix en el missatge.");
        }
    }
}