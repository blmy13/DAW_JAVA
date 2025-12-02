package Herencia_i_Polimorfisme.ExVoluntari;

public abstract class ArmaAtac implements Armable {

    private final double percentatgeAtac;

    public ArmaAtac(double percentatgeAtac) {
        this.percentatgeAtac = percentatgeAtac;
    }

    public abstract void activarAtac(Personatge personatge);

    public double getPercentatgeAtac() {
        return percentatgeAtac;
    }

    @Override
    public void equiparPersonatge(Personatge personatge) {
        personatge.setPuntsAtac(personatge.getPuntsAtac() * percentatgeAtac);
        activarAtac(personatge);
    }
}
