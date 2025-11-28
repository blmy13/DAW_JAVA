package Herencia_i_Polimorfisme.Pràctica;

public abstract class Joc {

    private int vides;
    private final int videsInicials;
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
        boolean quedenVides = true;

        vides -= 1;
        if (vides == 0) {
            return false;
        }

        return quedenVides;
    }

    public void reiniciarPartida() {
        vides = videsInicials;
    }

    public void actualitzaRecord() {
        if (heGuanyat()) {
            int puntuacio = videsInicials - vides;
            if (puntuacio == record) {
                System.out.println("Has igualat el rècord");
            } else if (puntuacio > record) {
                record = puntuacio;
                System.out.println("Enhorabona!!!\nHas superat el teu rècord. El nou rècord és: " + record);
            }
        }

    }

    abstract void juga();

    abstract boolean heGuanyat();

    
}
