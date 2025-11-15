package Mètodes_i_Classes.PracticaT2;

public class SubhastaMain {

    public static void main(String[] args) {

        //Creació Usuaris
        Usuari Joan = new Usuari("24869412Q", "Joan", 100.00);
        Usuari Pere = new Usuari("93712864N", "Pere", 150.00);
        Usuari Enric = new Usuari("91732846F", "Enric", 300.00);
        
        //Creació Subhasta
        Subhasta subhasta1 = new Subhasta(Joan, "Telèfon Mòbil");
        Joan.afegirSubhastaEnPropietat(subhasta1);
        System.out.println("L'article subhastat és: " + subhasta1.getArticle());

        //Creació Licitació Pere
        Licitacio licitacioPere = new Licitacio(subhasta1,Pere,100.00);
        System.out.println("L'usuari Pere licita: " + licitacioPere.getQuantitat() + "€.");
        subhasta1.licitar(Pere, 100.00);

        //Comprovació licitació major
        Licitacio max = subhasta1.getLicitacioMax();
        if (max != null) {
            System.out.println("La licitació major pel producte: " + max.getSubhasta().getArticle() + " feta per: " + max.getUsuari().getNom() + " és de: " + max.getQuantitat() + "€.");
        } else {
            System.out.println("No s'ha acceptat cap licitació.");
        }
        //Creació Licitació Enric
        Licitacio licitacioEnric = new Licitacio(subhasta1,Enric,50.00);
        System.out.println("L'usuari Enric licita: " + licitacioEnric.getQuantitat() + "€.");
        //Comprovació licitació Enric
        subhasta1.licitar(Enric,50);
        //Comprovació licitació major
        Licitacio max2 = subhasta1.getLicitacioMax();
        if (max2 != null) {
            System.out.println("La licitació major pel producte: " + max2.getSubhasta().getArticle() + " feta per: " + max2.getUsuari().getNom() + " és de: " + max2.getQuantitat() + "€.");
        } else {
            System.out.println("No s'ha acceptat cap licitació.");
        }
        //Tancar subhasta1
        subhasta1.setTancada(true);
        //Nova licitació Enric
        Licitacio licitacioEnric2 = new Licitacio(subhasta1,Enric,200.00);
        System.out.println("L'usuari Enric licita: " + licitacioEnric2.getQuantitat() + "€.");
        //Comprovació 2a licitació Enric
        subhasta1.licitar(Enric,200);
        //Execució Subhasta
        subhasta1.executar(subhasta1);
        //Mostra crèdits de cada usuari
        System.out.println("El crèdit dels usuaris és el següent: Joan: " + Joan.getCredit() + "€ || Pere: " + Pere.getCredit() + "€ || Enric: " + Enric.getCredit() + "€");
        //Mostra subhastes de les quals són propietaris, guanyades i licitacions realitzades de cada usuari:
        System.out.println("JOAN:");
        Joan.mostrarUsuari();
        System.out.println("PERE:");
        Pere.mostrarUsuari();
        System.out.println("ENRIC");
        Enric.mostrarUsuari();

    }

}
