package Herencia_i_Polimorfisme.ExCompteBancari;

public interface Rentable {

    static final double MIN_LIMIT = 1000000;
    static final double MID_LIMIT = 5000000;
    static final double MAX_LIMIT = 10000000;

    default double bonus() {
        return 0.00;
    }

}
