/*
Genereu un programa anomenat ComptaAsString que compti quantes lletres a
conté una cadena de text. El text el podeu declarar com una constant en el codi
font.
 */
package Strings;

public class Ex3 {

    public static final String TEXT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    public static void main(String[] args) {

        int i = 0;
        int posicio = TEXT.indexOf('a');
        while (posicio != -1) {
            i++;
            posicio = TEXT.indexOf('a', posicio + 1);
        }
        System.out.println("a: " + i);

    }

}
