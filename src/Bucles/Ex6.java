package Bucles;

class Ex6 {
    public static void main(String[] args) {
        
        int prod = 0, factorial = 1;
        
        for (int i = 2; i <= 10; i++){
            factorial *= i;
            
            
        }
        System.out.println("El producte és: " + factorial);
    }
    
}
