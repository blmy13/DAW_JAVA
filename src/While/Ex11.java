package While;

/*L'empresa vol un programa que li demani al treballador la
capacitat del camió i el pes dels sacs, indicant si ha de carregar el sac o enviar-lo
al seu destí i començar a carregar un altre. El procés continua fins que s'hagin
omplert els 20 camions.*/

import java.util.Scanner;

public class Ex11 {

    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);

        System.out.println("Introdueix la capacitat del camió.");
        int capCamio = tec.nextInt();
        int pesSac = 0;
        int numCamio = 0;
        int sumaSac = 0;

        while (numCamio <= 20) {

            sumaSac = 0;

            while (sumaSac < capCamio) {

                System.out.println("Introdueix el pes del sac");
                pesSac = tec.nextInt();
                sumaSac += pesSac;
            }
            if (sumaSac > capCamio) {
                sumaSac -= pesSac;
                System.out.println("El camió està ple. Es procedirà amb l'enviament.");
                numCamio++;
            }
            System.out.println("Introdueix la capacitat del camió.");
            capCamio = tec.nextInt();

        }
        if (numCamio == 20) {
            System.out.println("Finalitzada la càrrega del dia");
        }
    }

}
