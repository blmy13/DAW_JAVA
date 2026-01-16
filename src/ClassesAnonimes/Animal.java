package ClassesAnonimes;

public interface Animal {
    int MIDA = 0;
    void menja();
    void crida();
    int creix(int centimetres);
        
}

class main {
    public static void main(String[] args) {
        
        Animal gat = new Animal() {
          @Override
          public void menja() {
              System.out.println("NYAM NYAM");
          }  
          @Override
          public void crida() {
              System.out.println("MIAU");
          }
          @Override
          public int creix(int centimetres) {
              System.out.print("Aquests son els centímetres que he crescut: ");
              return centimetres;     
          }
        };
    }
}
