package Herencia_i_Polimorfisme.Examen;

public interface Aprovable {

    default boolean aprova() {
        return false;
    }

}
