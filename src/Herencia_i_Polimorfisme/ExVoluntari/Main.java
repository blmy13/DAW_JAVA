package Herencia_i_Polimorfisme.ExVoluntari;


public class Main {
    public static void main(String[] args) {

        Personatge Dumbo = new Personatge(100, 100);
        Personatge FelipeVI = new Personatge (200, 250);

        Dumbo.afegirArma(new Escut());
        Dumbo.afegirArma(new Armadura());
        Dumbo.afegirArma(new Arc());
  
        FelipeVI.afegirArma(new Armadura());
        FelipeVI.afegirArma(new Espasa());
        FelipeVI.afegirArma(new Escut());


    }

}

