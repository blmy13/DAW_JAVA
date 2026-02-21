package Format;

public class Ex1 {
    public static void main(String[] args) {
        int mida = 10;
        System.out.println("TAULES DE MULTIPLICAR\n");

        for (int i = 0; i <= mida ; i++) {
            System.out.printf("%4d", i);
        }
        System.out.println();
        System.out.println("   " + "-----------------------------------------");

        for (int i = 1; i <= mida; i++) {
            System.out.printf("%2d |", i);
            for (int j = 1; j <= mida; j++) {
                System.out.printf("%4d", i * j);
            }
            System.out.println();
        }
    }
}
