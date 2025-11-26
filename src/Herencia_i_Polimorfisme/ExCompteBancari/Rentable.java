package Herencia_i_Polimorfisme.ExCompteBancari;

public interface Rentable {

    double MIN_LIMIT = 1000000;
    double MID_LIMIT = 5000000;
    double MAX_LIMIT = 10000000;

    default double bonus() {
        return 0.00;
    }

}
