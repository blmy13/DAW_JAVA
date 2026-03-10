package Files.RandomAccesFile;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Ex2 {
    public static void main(String[] args) {

        String ruta = "reals.dat";
        generarFitxer(ruta);

        try (RandomAccessFile raf = new RandomAccessFile(ruta, "rw")) {
            System.out.println("Fitxer Desordenat:");
            mostrarFitxer(raf);

            long numElements = raf.length() / 8;

            for (long i = 0; i < numElements; i++) {
                for (long j = i + 1; j < numElements; j++) {

                    raf.seek(i * 8);
                    double valorI = raf.readDouble();

                    raf.seek(j * 8);
                    double valorJ = raf.readDouble();

                    if (valorJ < valorI) {
                        raf.seek(i * 8);
                        raf.writeDouble(valorJ);

                        raf.seek(j * 8);
                        raf.writeDouble(valorI);
                    }
                }
            }
            System.out.println("Fitxer Ordenat:");
            mostrarFitxer(raf);

        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public static void mostrarFitxer(RandomAccessFile raf) throws IOException {
        raf.seek(0);

        long numElements = raf.length() / 8;
        for (long i = 0; i < numElements; i++) {
            System.out.println(raf.readDouble());
        }
        System.out.println();
    }

    public static void generarFitxer(String ruta) {
        try (RandomAccessFile raf = new RandomAccessFile(ruta, "rw")) {
            raf.setLength(0);
            raf.writeDouble(7.88);
            raf.writeDouble(89.3);
            raf.writeDouble(7.89);
            raf.writeDouble(8.88);
            raf.writeDouble(4.44);

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
