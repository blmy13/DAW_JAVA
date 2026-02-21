package Format;

public class Ex3 {
    public static void main(String[] args) {

        String nom = "Agapito Lindo";
        String curs = "1r DAW";
        double nota = 8.4565;

        String alumne = String.format("Nom: %13s Curs: %6s Nota Final: %4.2f", nom, curs, nota);
        System.out.println(alumne);
    }
}
