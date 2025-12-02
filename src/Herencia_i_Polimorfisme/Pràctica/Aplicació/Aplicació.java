package Herencia_i_Polimorfisme.Pràctica.Aplicació;

import Herencia_i_Polimorfisme.Pràctica.Interfícies.Jugable;
import Herencia_i_Polimorfisme.Pràctica.JocNumeros.JocEndevinaMultiplicacio;
import Herencia_i_Polimorfisme.Pràctica.JocNumeros.JocEndevinaNumero;
import Herencia_i_Polimorfisme.Pràctica.JocNumeros.JocEndevinaParell;
import Herencia_i_Polimorfisme.Pràctica.JocNumeros.JocEndevinaSenar;

import java.util.Scanner;
import java.util.ArrayList;

public class Aplicació {

    static Scanner tec = new Scanner(System.in);

    public static Jugable triaJoc() {

        ArrayList<Jugable> jocs = new ArrayList<>();
        jocs.add(new JocEndevinaNumero(7, 5));
        jocs.add(new JocEndevinaMultiplicacio(10, 3));
        jocs.add(new JocEndevinaSenar(3, 5));
        jocs.add(new JocEndevinaParell(8, 5));

        for (Jugable j : jocs) {
            System.out.println(j.mostraNom());
        }
        System.out.println("Introdueix un número del 0 al 3 per triar un joc.");
        int num = tec.nextInt();

        while (num < 0 || num > jocs.size() - 1) {
            System.out.println("Introdueix un número del 0 al 3 per triar un joc.");
            num = tec.nextInt();
        }

        return jocs.get(num);
    }

    public static void main(String[] args) {

        boolean seguirJugant = true;
        while (seguirJugant) {
            Jugable jocTriat = triaJoc();
            System.out.println(jocTriat.mostraNom());
            System.out.println(jocTriat.mostraInfo());

            jocTriat.juga();
            System.out.println("Vols seguir jugant? (s/n)");
            String resposta = "";
            boolean entradaValida = false;

            while (!entradaValida) {
                if (tec.hasNext()) {
                    resposta = tec.next().trim().toLowerCase();
                    if (resposta.equals("s") || resposta.equals("n")) {
                        entradaValida = true;
                    } else {
                        System.out.print("Caràcter de resposta no vàlid. Ha de ser 's' o 'n'.");
                    }
                }
            }
            if (resposta.equals("n")) {
                seguirJugant = false;
            }
        }
        System.out.println("Gràcies per jugar!!!");
        tec.close();

    }
}
