package Random.PràcticaExam;

import java.util.Arrays;

public class Regex1 {
    public static void main(String[] args) {
        String text = "  Programacio_2026  ";
        String colors = "blau;vermell;groc";
        String s = "Java2026";

        //Eliminar espais
        System.out.println(text.trim());

        //Divisió
        String[] colors1 = colors.split(";");
        System.out.println(Arrays.toString(colors1));

        //Subcadena
        System.out.println(s.substring(0,4));

        //Validació codi ABC-123
        String codi = "KHS-444";
        String pattern = "[A-Z]{3}-\\d{3}";
        System.out.println(codi.matches(pattern) ? "Codi vàlid" : "Codi no vàlid");
    }
}
