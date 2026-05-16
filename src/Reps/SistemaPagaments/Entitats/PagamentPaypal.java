package Reps.SistemaPagaments.Entitats;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PagamentPaypal implements EstrategiaPagament {
    private String correuElectronic;
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
    private static final Pattern VALID = Pattern.compile(EMAIL_REGEX);


    public PagamentPaypal(String correuElectronic) {
        if (!esValid(correuElectronic)) {
            throw new MailInvalidException(" >> ERROR: Format de e-mail no vàlid");
        }
        this.correuElectronic = correuElectronic;
    }

    @Override
    public void processarPagament(double quantitat) throws PagamentInvalidException {
        System.out.println("Processant pagament de " + quantitat + "€ via PayPal pel compte " + this.correuElectronic);
    }

    @Override
    public String obtenirDadesPersistencia() {
        return "PAYPAL;" + this.correuElectronic;
    }

    public String getCorreuElectronic() {
        return correuElectronic;
    }

    public void setCorreuElectronic(String correuElectronic) {
        this.correuElectronic = correuElectronic;
    }

    @Override
    public String toString() {
        return String.format(" >> PAGAMENT PayPal: -20s", this.correuElectronic);
    }

    public boolean esValid(String email) {
        if (email == null) {
            return false;
        }
        Matcher matcher = VALID.matcher(email);
        return matcher.matches();
    }
}
