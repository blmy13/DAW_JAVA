package Herencia_i_Polimorfisme.Pràctica;

import java.util.Scanner;

public abstract class JocNumeros extends Joc {

    public JocNumeros(int videsInicials) {
        super(videsInicials);
    }

    @Override
    public void juga() {
        reiniciarPartida();
        Scanner tec = new Scanner(System.in);
        
        System.out.println("Introdueix un número: ");   
        int num = tec.nextInt();
        while (!validaNumero(num)) {
            System.out.println("Introdueix un número: ");
            num = tec.nextInt();
        }
        while (mostraVidesRestants() > 0 || !heGuanyat()) {

            if (heGuanyat()) {
                System.out.println("Enhorabona!!! Has guanyat!!!");
                actualitzaRecord();
            } else {
                treuVida();
            }
        }

    }

    public boolean validaNumero(int x) {
        return true;
    }

}
