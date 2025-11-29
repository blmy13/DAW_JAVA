package Herencia_i_Polimorfisme.Pràctica.ClasseJoc;

public abstract class Joc {

    protected int vides;
    protected final int videsInicials;
    private static int record = 0;

    public Joc(int videsInicials) {
        
        if (videsInicials > 10 || videsInicials < 1) {
            vides=0;
            System.out.println("Vides no vàlides. El màxim és 10.");
        } else {
            vides = videsInicials;
        }
         this.videsInicials = videsInicials;
        
    }

    public int mostraVidesRestants() {
        return vides;
    }

    public boolean treuVida() {
        if (vides > 0) {
            vides--;
        }
        return vides > 0;
    }

    public void reiniciarPartida() {
        vides = videsInicials;
    }

    public void actualitzaRecord() {
        if (heGuanyat()) {
            int vGastades = videsInicials - vides;
            int puntuacio = 10 - vGastades;
            System.out.println("Puntuació Obtinguda: " + puntuacio);
            if (puntuacio == record) {
                System.out.println("Has igualat el rècord");
            } else if (puntuacio > record) {
                record = puntuacio;
                System.out.println("Enhorabona!!!\nHas superat el teu rècord. El nou rècord és: " + record);
            }
        }
    }

    protected abstract boolean heGuanyat();

    
}
