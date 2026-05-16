package Reps.SistemaPagaments.DAO;


import Reps.SistemaPagaments.Entitats.PagamentPaypal;
import Reps.SistemaPagaments.Entitats.PagamentTargeta;
import Reps.SistemaPagaments.Entitats.Transaccio;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TransaccioFitxerDAO implements TransaccioDAO {

    @Override
    public void guardarTransaccio(Transaccio t) throws PersistenciaException { //true -> append, permet afegir text sense esborrar
        try (PrintWriter out = new PrintWriter(new FileWriter("transaccions_completades.txt", true))) {
            out.printf(" >> Transacció OK: %10.2f€ processada correctament.%n", t.getImportTransaccio());
        } catch (IOException e) {
            throw new PersistenciaException(" >> ERROR: No s'ha pogut accedir al disc per guardar la transacció.");
        }
    }

    @Override
    public List<Transaccio> obtenirTransaccions() throws PersistenciaException {
        List<Transaccio> transaccions = new ArrayList<>();

        // BufferedReader màxim rendiment lectura
        try (BufferedReader reader = new BufferedReader(new FileReader("transaccions_completades.txt"))) {
            String linia;

            while ((linia = reader.readLine()) != null) {
                String[] parts = linia.split(";");
                double importTransaccio = Double.parseDouble(parts[0]);
                String tipusPagament = parts[1];

                if (tipusPagament.equalsIgnoreCase("PAYPAL")) {
                    String email = parts[2];
                    PagamentPaypal paypal = new PagamentPaypal(email);
                    transaccions.add(new Transaccio(importTransaccio, paypal));

                } else if (tipusPagament.equalsIgnoreCase("TARGETA")) {
                    String numTargeta = parts[2];
                    String titular = parts[3];
                    PagamentTargeta targeta = new PagamentTargeta(numTargeta, titular);
                    transaccions.add(new Transaccio(importTransaccio, targeta));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(" >> INFO: Encara no hi ha cap fitxer de transaccions creat.");
        } catch (IOException e) {
            throw new PersistenciaException(" >> ERROR: Fallada de disc al llegir les transaccions.");
        } catch (Exception e) {
            throw new PersistenciaException(" >> ERROR: Fitxer corrupte o dades invàlides.");
        }

        return transaccions;
    }
}
