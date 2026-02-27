package Test;

import java.util.List;

class Capsa<T> {
    private T contingut;

    public Capsa(T contingut) {
        this.contingut = contingut;
    }

    public T getContingut() {
        return contingut;
    }

    public void setContingut(T contingut) {
        this.contingut = contingut;
    }
}
public class Generic4 {
    public static void main(String[] args) {
        Capsa<String> c1 = new Capsa<>("Yves Tumor");
        Capsa<Integer> c2 = new Capsa<>(444);

        System.out.println(c1.getContingut());
        System.out.println(c2.getContingut());

        List<String> llista1 = List.of("Oklou", "AG Cook");
        List<Integer> llista2 = List.of(13, 444);

        imprimirLlista(llista1);
        imprimirLlista(llista2);
    }

    public static void imprimirLlista(List<?> llista) {
        for (Object o : llista) {
            System.out.println(o);
        }
    }
}
