package ExpressionsRegulars;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex5 {
    public static void main(String[] args) {
        String text = """
        Avui, 15/09/2023, s'ha fet una reunió molt important. Ens han informat que la
        següent sessió serà el 01/10/2023, just abans del congrés del 05/11/2023.
        Recordeu que l'any passat, el 25/12/2022, vam tenir un esdeveniment especial.
        Aquest any, el 31/12/2023, celebrarem el cap d'any de nou.
        Les dates de l'examen final són les següents:
        - Primera convocatòria: 10/06/2024
        - Segona convocatòria: 20/07/2024
        - Recuperació: 15/09/2024
        A més, l'empresa va ser fundada el 08/03/1999 i des d'aleshores ha tingut grans
        èxits. Un dels moments més destacats va ser el 23/05/2010, quan vam obrir la nostra
        nova seu.
        Cal estar atents també al festival d'estiu, que començarà el 01/07/2025 i acabarà el
        20/08/2025. L'última edició va tenir lloc el 15/07/2023 i va ser tot un èxit!
        Si necessites ajuda amb el calendari d'activitats, consulta la web. Última
        actualització: 30/01/2024.
        """;

        Pattern pattern = Pattern.compile("\\d{2}/\\d{2}/\\d{4}");
        Matcher matcher = pattern.matcher(text);

        while  (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
