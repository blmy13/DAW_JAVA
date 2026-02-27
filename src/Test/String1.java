package Test;

public class String1 {
    public static void main(String[] args) {
        String missatge = "   Aprendre Java és genial!   ";
        String missatgeCorregit = missatge.strip();

        System.out.println("Longitud de l'String: " + missatgeCorregit.length());
        boolean carFinal = missatgeCorregit.endsWith("!");

        System.out.println(carFinal ? "Acaba en !" : "No acaba en !");
    }
}
