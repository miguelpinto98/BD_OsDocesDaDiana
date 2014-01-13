package BusinessLayer;

import java.util.GregorianCalendar;
import java.util.Objects;

public class Comentario {

    private int id;
    private String user; // ???
    private String coment;
    private GregorianCalendar datacoment;
    private int removido;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getComent() {
        return coment;
    }

    public void setComent(String coment) {
        this.coment = coment;
    }

    public GregorianCalendar getDatacoment() {
        return datacoment;
    }

    public void setDatacoment(GregorianCalendar datacoment) {
        this.datacoment = datacoment;
    }

    public int getRemovido() {
        return removido;
    }

    public void setRemovido(int removido) {
        this.removido = removido;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.user);
        hash = 97 * hash + Objects.hashCode(this.coment);
        hash = 97 * hash + Objects.hashCode(this.datacoment);
        hash = 97 * hash + this.removido;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Comentario other = (Comentario) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.coment, other.coment)) {
            return false;
        }
        if (!Objects.equals(this.datacoment, other.datacoment)) {
            return false;
        }
        return this.removido == other.removido;
    }
    
}
