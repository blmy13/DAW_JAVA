package Reps.MotorAntifrau.Entitats.Processadors;

import Reps.MotorAntifrau.Entitats.TipusTransaccio;

import java.util.HashMap;
import java.util.Map;

public class FabricaProcessadors {
    private final Map<TipusTransaccio, ProcessadorEspecific> registreProcessadors;

    public FabricaProcessadors() {
        this.registreProcessadors = new HashMap<>();
        registreProcessadors.put(TipusTransaccio.TARGETA, new ProcessadorTargeta());
        registreProcessadors.put(TipusTransaccio.TRANSFERENCIA, new ProcessadorTransferencia());
        registreProcessadors.put(TipusTransaccio.CRIPTOMONEDA, new ProcessadorCripto());
    }

    public ProcessadorEspecific obtenirProcessador(TipusTransaccio tipus)  {
        ProcessadorEspecific processador = registreProcessadors.get(tipus);
        if (processador == null) {
            throw new IllegalArgumentException(">> ERROR: No hi ha cap processador registrat per al tipus " + tipus);
        }
        return processador;
    }
}
