package DB.Esports;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
@Entity
public class Jugador implements Serializable {
    @Id
    private String nick;
    private int edat;
    private String rol;

    @ManyToOne
    private Equip equip;

    public Jugador() {
    }

    public Jugador(String nick, int edat, String rol) {
        this.nick = nick;
        this.edat = edat;
        this.rol = rol;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Equip getEquip() {
        return equip;
    }

    public void setEquip(Equip equip) {
        this.equip = equip;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nick='" + nick + '\'' +
                ", edat=" + edat +
                ", rol='" + rol + '\'' +
                '}';
    }
}
