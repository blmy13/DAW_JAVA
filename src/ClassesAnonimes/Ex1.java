package ClassesAnonimes;

public class Ex1 {

    public void vinga() {
        System.out.println("Superclasse");
    }

    public static void main(String[] args) {
        Ex1 ex1 = new Ex1() {
            @Override
            public void vinga() {
                System.out.println("Classe anònima");
            }
        };
    }
}
