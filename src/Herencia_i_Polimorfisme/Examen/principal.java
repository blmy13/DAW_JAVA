package Herencia_i_Polimorfisme.Examen;

import java.time.LocalDate;

public class principal {

    public static void main(String[] args) {
        CentreEducatiu c = new CentreEducatiu();

        Alumne anastasio = new Alumne("123L", "Sort", "Anastasio");
        Alumne indalecia = new Alumne("124M", "Canela", "Indalecia");
        Alumne hermenegildo = new Alumne("125N", "Arimany", "Hermenegildo");

        anastasio.agregarExamen(new ExamenEscrit(7, LocalDate.now()));
        anastasio.agregarExamen(new ExamenOral(NivellSatisfaccio.SUFICIENT, LocalDate.now()));

        indalecia.agregarExamen(new ExamenEscrit(4, LocalDate.now()));
        indalecia.agregarExamen(new ExamenEscrit(8, LocalDate.now()));
        indalecia.agregarExamen(new ExamenOral(NivellSatisfaccio.EXCELENT, LocalDate.now()));

        hermenegildo.agregarExamen(new ExamenEscrit(9, LocalDate.now()));
        hermenegildo.agregarExamen(new ExamenOral(NivellSatisfaccio.INSUFICIENT, LocalDate.now()));
        hermenegildo.agregarExamen(new ExamenOral(NivellSatisfaccio.EXCELENT, LocalDate.now()));

        c.agregarAlumne(anastasio);
        c.agregarAlumne(indalecia);
        c.agregarAlumne(hermenegildo);

        System.out.println("Quantitat d'aprovats: " + c.nombreAprovats());
        c.llistar();
    }

}
