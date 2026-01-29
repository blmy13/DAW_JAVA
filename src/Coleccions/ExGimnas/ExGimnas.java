package Coleccions.ExGimnas;

import java.util.*;

class Client {
    private final String nom;
    private final int edat;
    private final String email;

    public Client(String nom, int edat, String email) {
        this.nom = nom;
        this.edat = edat;
        this.email = email;
    }

    public String getNom() { return nom; }
    public int getEdat() { return edat; }
    public String getEmail() { return email; }

    @Override
    public String toString() {
        return String.format("NOM: %-15s | EDAT: %-3d | EMAIL: %s", nom, edat, email);
    }
}

public class ExGimnas {

    private static final Comparator<Client> COMP_NOM = Comparator
            .comparing(Client::getNom, String.CASE_INSENSITIVE_ORDER)
            .thenComparing(Client::getEmail);

    private static final Comparator<Client> COMP_EDAT = Comparator
            .comparingInt(Client::getEdat)
            .thenComparing(Client::getNom)
            .thenComparing(Client::getEmail);

    public static void main(String[] args) {
        TreeSet<Client> clients = new TreeSet<>(COMP_NOM);
        Scanner sc = new Scanner(System.in);
        boolean finalitzat = false;

        while (!finalitzat) {
            System.out.println("\n\t\t\t=== GESTIÓ GIMNÀS ===\n");
            System.out.println("1. AFEGIR CLIENT          6. RANG DE NOMS");
            System.out.println("2. ELIMINAR PER NOM       7. CLIENTS ANTERIORS A...");
            System.out.println("3. BUSCAR PER NOM         8. CLIENTS POSTERIORS A...");
            System.out.println("4. MOSTRAR TOTS           9. CLIENT ANTERIOR/SEGÜENT");
            System.out.println("5. PRIMER I ÚLTIM        10. CANVIAR CRITERI (Nom/Edat)");
            System.out.println("\t\t\t\t0. SORTIR");
            System.out.print("Tria: ");

            int tria = sc.nextInt();
            sc.nextLine();

            switch (tria) {
                case 1:
                    System.out.print("Nom: "); String n = sc.nextLine();
                    System.out.print("Edat: "); int e = sc.nextInt(); sc.nextLine();
                    System.out.print("Email: "); String em = sc.nextLine();
                    clients.add(new Client(n, e, em));
                    System.out.println("Client afegit correctament");
                    break;

                case 4:
                    if (clients.isEmpty()) System.out.println("Gimnàs buit.");
                    else clients.forEach(System.out::println);
                    break;

                case 5:
                    if (!clients.isEmpty()) {
                        System.out.println("PRIMER: " + clients.first());
                        System.out.println("ÚLTIM: " + clients.last());
                    }
                    break;

                case 6:
                    System.out.print("Des de quin nom: "); String d = sc.nextLine();
                    System.out.print("Fins a quin nom: "); String f = sc.nextLine();
                    System.out.println(clients.subSet(new Client(d,0,""), new Client(f,0,"")));
                    break;

                case 7:
                    System.out.print("Mostra els clients anteriors a (nom): ");
                    String nomAbans = sc.nextLine();


                    SortedSet<Client> anteriors = clients.headSet(new Client(nomAbans, 0, ""));

                    System.out.println("Clients anteriors a '" + nomAbans + "':");
                    if (anteriors.isEmpty()) System.out.println("Cap client anterior.");
                    else anteriors.forEach(System.out::println);
                    break;

                case 8:
                    System.out.print("Mostra els clients posteriors a (nom): ");
                    String nomDespres = sc.nextLine();

                    SortedSet<Client> posteriors = clients.tailSet(new Client(nomDespres, 0, ""));

                    System.out.println("Clients posteriors a '" + nomDespres + "':");
                    if (posteriors.isEmpty()) System.out.println("Cap client posterior.");
                    else posteriors.forEach(System.out::println);
                    break;

                case 9:
                    System.out.print("Nom referència: "); String ref = sc.nextLine();
                    Client dummy = new Client(ref, 0, "");
                    System.out.println("Anterior: " + clients.lower(dummy));
                    System.out.println("Següent: " + clients.higher(dummy));
                    break;

                case 10:
                    System.out.println("1. Ordenar per NOM | 2. Ordenar per EDAT");
                    int opcio = sc.nextInt();
                    TreeSet<Client> nouSet;
                    if (opcio == 2) {
                        nouSet = new TreeSet<>(COMP_EDAT);
                        System.out.println("Ordenant per edat...");
                    } else {
                        nouSet = new TreeSet<>(COMP_NOM);
                        System.out.println("Ordenant per nom...");
                    }
                    nouSet.addAll(clients);
                    clients = nouSet;
                    break;

                case 0:
                    finalitzat = true;
                    System.out.println("PROGRAMA FINALITZAT");
                    break;
                default:
                    System.out.println("Opció no vàlida.");
            }
        }
    }
}