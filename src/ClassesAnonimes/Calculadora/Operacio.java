package ClassesAnonimes.Calculadora;

public interface Operacio {

    double calcular(double a, double b);
}

class main {

    public static void main(String[] args) {

        Operacio suma = new Operacio() {
            @Override
            public double calcular(double a, double b) {
                return a + b;
            }
        };
        Operacio resta = new Operacio() {
            @Override
            public double calcular(double a, double b) {
                return a - b;
            }
        };
        Operacio producte = new Operacio() {
            @Override
            public double calcular(double a, double b) {
                return a * b;
            }
        };
        Operacio divisio = new Operacio() {
            @Override
            public double calcular(double a, double b) {
                return a / b;
            }
        };
        System.out.println("SUMA: " + suma.calcular(5, 8));
        System.out.println("RESTA: " +resta.calcular(45, 6));
        System.out.println("PRODUCTE: " + producte.calcular(5, 8));
        System.out.println("DIVISIÓ: " + divisio.calcular(40, 5));
    }
}
