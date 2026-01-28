package ExAlumnes;

import java.util.*;


class Alumne {

    private String nom;
    private String cognoms;
    private String nif;
    private int edat;
    private double nota;

    public Alumne(String nom, String cognoms, String nif, int edat, double nota) throws AlumneExcepcio {

        setNom(nom);
        setCognoms(cognoms);
        this.nif = nif;
        setEdat(edat);
        setNota(nota);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws AlumneExcepcio {
        if (!Character.isUpperCase(nom.charAt(0))) {
            throw new AlumneExcepcio("El nom ha de començar per majúscula.");
        }
        this.nom = nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) throws AlumneExcepcio {
        if (!Character.isUpperCase(cognoms.charAt(0))) {
            throw new AlumneExcepcio("Els cognoms han de començar per majúscula.");
        }
        this.cognoms = cognoms;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) throws AlumneExcepcio {
        if (edat < 18 || edat > 100) {
            throw new AlumneExcepcio("L'edat ha d'estar entre 18 i 100 anys.");
        }
        this.edat = edat;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) throws AlumneExcepcio {
        if (nota < 0 || nota > 10) {
            throw new AlumneExcepcio("La nota ha d'estar entre 0 i 10.");
        }
        this.nota = nota;

    }

    @Override
    public String toString() {
        return "ALUMNE -->" + "NOM: " + nom + " | COGNOMS: " + cognoms + " | NIF: " + nif + " | EDAT: " + edat + " | NOTA: " + nota;


    }

    public class Main {

        public static void main(String[] args) {

            boolean finalitzat = false;
            HashMap<String, Alumne> alumnes = new HashMap<>();
            Scanner sc = new Scanner(System.in);

            while (!finalitzat) {
                System.out.println("=== MENÚ ====");
                System.out.println("1. AFEGIR ALUMNE");
                System.out.println("2. BUSCAR PER NIF");
                System.out.println("3. LLISTAR ORDENAT PER NIF");
                System.out.println("4. SORTIR");
                System.out.println("TRIA UNA OPCIÓ");
                int tria = sc.nextInt();
                switch (tria) {
                    case 1:
                        try {
                            System.out.println("Introdueix el nom de l'alumne:");
                            String nom = sc.nextLine();
                            System.out.println("Introdueix el cognoms:");
                            String cognoms = sc.nextLine();
                            System.out.println("Introdueix el NIF:");
                            String nif = sc.nextLine();
                            System.out.println("Introdueix l' edat:");
                            int edat = sc.nextInt();
                            System.out.println("Introdueix l'nota:");
                            double nota = sc.nextDouble();

                            Alumne alumne = new Alumne(nom, cognoms, nif, edat, nota);
                            alumnes.put(nif, alumne);
                            System.out.println("Alumne afegit correctament.");

                        } catch (AlumneExcepcio e) {
                            System.out.println("ERROR: " + e.getMessage());
                        } catch (NumberFormatException e) {
                            System.out.println("ERROR: L'edat i la nota han de ser números");
                        }
                        break;
                    case 2:
                        System.out.println("Introdueix el NIF de l'alumne que vols buscar:");
                        String nifIntroduit = sc.nextLine();

                        Alumne trobat = alumnes.get(nifIntroduit);

                        if (trobat != null) {
                            System.out.println("Alumne trobat: " + trobat);
                        } else {
                            System.out.println("L'alumne amb NIF: " + nifIntroduit + " no existeix.");
                        }
                        break;
                    case 3:
                        List<String> nifsOrdenats = new ArrayList<>(alumnes.keySet());
                        Collections.sort(nifsOrdenats);
                        System.out.println("NIFS ORDENATS:");
                        for (String nif : nifsOrdenats) {
                            System.out.println(alumnes.get(nif));
                        }
                        break;
                    case 4:
                        finalitzat = true;
                        break;
                    default:
                        System.out.println("Opció no vàlida.");
                }

            }

        }

    }

}
