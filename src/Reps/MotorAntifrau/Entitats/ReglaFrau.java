package Reps.MotorAntifrau.Entitats;

@FunctionalInterface
public interface ReglaFrau<T> {
    boolean avaluar(T t);
}
