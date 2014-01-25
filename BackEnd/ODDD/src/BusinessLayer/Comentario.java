package BusinessLayer;

import java.util.GregorianCalendar;
import java.util.Objects;

public class Comentario {

    private int id;
    private String user; // ???
    private int idReceita;
    private String coment;
    private int removido;
    private GregorianCalendar create;
    private GregorianCalendar update;
    
    public Comentario (int id, String user, int idRec, String coment, int rm, GregorianCalendar g, GregorianCalendar u){
        this.id = id;
        this.user = user;
        this.idReceita = idRec;
        this.coment = coment;
        this.removido = rm;
        this.create = g;
        this.update = u;
    }
    
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

    public int getIdReceita() {
        return idReceita;
    }

    public void setIdReceita(int id) {
        this.idReceita = id;
    }
    
    public String getComent() {
        return coment;
    }

    public void setComent(String coment) {
        this.coment = coment;
    }

    public int getRemovido() {
        return removido;
    }

    public void setRemovido(int removido) {
        this.removido = removido;
    }

    public GregorianCalendar getCreate(){
        return this.create;
    }
    
    public GregorianCalendar getUpdate(){
        return this.update;
    }

    public void setCreate(GregorianCalendar g){
        this.create = g;
    }
    
    public void setUpdate(GregorianCalendar g){
        this.update = g;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.user);
        hash = 97 * hash + Objects.hashCode(this.coment);
        hash = 97 * hash + this.removido;
        hash = 97 * hash + Objects.hashCode(this.create);
        hash = 97 * hash + Objects.hashCode(this.update);
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
        if (!Objects.equals(this.create, other.create)) {
            return false;
        }
        if (!Objects.equals(this.update, other.update)) {
            return false;
        }
        return this.removido == other.removido;
    }
    
}
