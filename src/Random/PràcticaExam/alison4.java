package Random.PràcticaExam;

public class alison4 {

    @FunctionalInterface
    interface Validador {

        boolean esValid(String text);
    }
    public static void main(String[] args) {
        Validador enric = ((String i) -> i.length()> 8);
            
          System.out.println(enric.esValid("ppppppppppppppppppp"));
        
    }

}
