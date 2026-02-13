package Files;

import java.io.File;

public class Ex1 {
    
    public static void main(String[] args) {
        
        File temp = new File(System.getProperty("user.dir") + "/Temp");
        System.out.println(temp.getPath());
        
        if (temp.exists()) {
            if (temp.delete()) {
                System.out.println("La carpeta s'ha eliminat correctament.");
            }
                    
        } else {
            if (temp.mkdir()) {
                System.out.println("La carpeta s'ha creat correctament.");
            }
        }
        System.out.println(temp.getAbsolutePath());
    }
}
