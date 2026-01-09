package Excepcions;

public class Exemple {

    public static void main(String[] args) {
        
        int d, a;
        try {
            d = 0;
            a = 42 / d;
            System.out.println("Això no s'imprimirà");
        }
        
        catch (ArithmeticException e) {
            System.out.println("Excepció: " + e);
        }
        
        System.out.println("Això sí s'mimprimirà");
       
    }

}
