package ExGimnas;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

class Client {

    private final String nom;
    private final int edat;
    private final String email;

    public Client(String nom, int edat, String email) {
        this.nom = nom;
        this.edat = edat;
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public int getEdat() {
        return edat;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "CLIENT: " + "NOM: " + nom + " | EDAT: " + edat + " | EMAIL: " + email;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Client other = (Client) obj;
        if (this.edat != other.edat) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        return Objects.equals(this.email, other.email);
    }

}

public class ExGimnas {

    public static void main(String[] args) {
        TreeSet<Client> clients = new TreeSet<>(Comparator.comparing(Client::getNom,
                String.CASE_INSENSITIVE_ORDER));
        Scanner sc = new Scanner(System.in);
        boolean finalitzat = false;

        while (!finalitzat) {
            System.out.println("=== MENÚ ===");
            System.out.println("1. AFEGIR CLIENT:");
            System.out.println("2. ELIMINAR CLIENT PEL NOM");
            System.out.println("3. BUSCAR CLIENT PEL NOM");
            System.out.println("4. MOSTRAR CLIENTS REGISTRATS");
            System.out.println("5. CONSULTAR PRIMER I ÚLTIM CLIENT");
            System.out.println("6. OBTENIR CLIENTS DINS D'UN RANG DE NOMS");
            System.out.println("7. OBTENIR CLIENTS ANTERIORS A UN DETERMINAT NOM");
            System.out.println("8. OBTENIR CLIENTS POSTERIORS A UN DETERMINAT NOM");
            System.out.println("9. TROBA EL CLIENT SEGUENT O ANTERIOR A UN NOM DONAT");
            System.out.println("10. SORTIR");
            System.out.println("TRIA LA OPERACIÓ QUE VOLS REALITZAR");
            int tria = sc.nextInt();

            switch (tria) {
                case 1:
                    System.out.println("Nom:");
                    String nom = sc.nextLine();
                    System.out.println("Edat:");
                    int edat = sc.nextInt();
                    System.out.println("Email:");
                    String email = sc.nextLine();

                    Client client = new Client(nom, edat, email);
                    clients.add(client);
                    System.out.println("Client afegit correctament");
                    break;

                case 2:
                    System.out.println("Nom del client que vols eliminar:");
                    String nomElim = sc.nextLine();
                    clients.removeIf(c -> c.getNom().equals(nomElim));
                    System.out.println("Client eliminat");
                    break;

                case 3:
                    System.out.println("Nom del client que vols buscar");
                    String nomBuscar = sc.nextLine();
                    Iterator<Client> it = clients.iterator();
                    boolean trobat = false;

                    while (it.hasNext() && !trobat) {
                        if (it.next().getNom().equals(nomBuscar)) {
                            trobat = true;
                        }
                    }
                    if (trobat) {
                        System.out.println("S'ha trobat el client " + nomBuscar);

                    } else {
                        System.out.println("No s'ha trobat el client " + nomBuscar);
                    }
                    break;

                case 4:
                    Iterator<Client> it1 = clients.iterator();
                    System.out.println("CLIENTS REGIRSTRATS:");
                    while (it1.hasNext()) {
                        System.out.println(it1.next());
                    }
                    break;
                    
                case 5:
                    clients.pollFirst();
                    clients.pollLast();
                    break;

                case 6:
                    System.out.println("Primer client del rang");
                    String c1 = sc.nextLine();
                    System.out.println("Segon client del rang");
                    String c2 = sc.nextLine();

                    SortedSet<Client> Rang = clients.subSet(
                            new Client(c1, 0, ""),
                            new Client(c2, 0, "")
                    );
                    break;
                    
                case 7:
                    System.out.println("Nom del client");
                    String cAnterior = sc.nextLine();
                    SortedSet<Client> anterior = clients.headSet(new Client (cAnterior, 0, ""));
                    System.out.println(anterior);
                    break;
                    
                case 8:
                    System.out.println("Nom del client");
                    String cPosterior = sc.nextLine();
                    SortedSet<Client> posterior = clients.tailSet(new Client(cPosterior, 0, ""));
                    System.out.println(posterior);
                    break;
                    
                case 9:
                    System.out.println("Nom del client");
                    String nomClient = sc.nextLine();
                    System.out.println("Client previ o posterior (1 / 2)");
                    int triaClient = sc.nextInt();
                    if (triaClient == 1) {
                        clients.lower(new Client(nomClient, 0, ""));
                    } else {
                        clients.higher(new Client(nomClient, 0, ""));
                    }
                    break;
                    
                case 10:
                    finalitzat = true;
                    System.out.println("PROGRAMA FINALITZAT");

            }
        }
    }

}
