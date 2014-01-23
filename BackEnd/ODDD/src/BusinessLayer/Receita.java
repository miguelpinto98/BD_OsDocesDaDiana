package BusinessLayer;

import DataLayer.AvaliacoesUtilizadorDAO;
import DataLayer.ComentariosDAO;
import DataLayer.ReceitaIngredienteDAO;
import DataLayer.ReceitaSeguidaDAO;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.Objects;

public class Receita {

    private int id;
    private String nome;
    private String desc;
    private int nimgs;
    private Imagem img; // private Map<Integer,Imagem> imgs; // <IDRECEITAS,IMAGENS>
    private GregorianCalendar datapub;
    private String user; // private Utilizador u ???
    private int totalCal; // NAO DEVERIA SER DOUBLE??
    private Map<Integer, Ingrediente> ingrs;
    private int vavaliacoes; // NAO DEVERIA SER DOUBLE??
    private int navaliacoes;
    private Map<Integer, Comentario> coments;
    private Map<Integer, String> seguidores; // idreceita -> nomeutilizador ou  private Map<Integer,Utilizador> seguidores;  ??IDRECEITA??
    private Map<Integer, Avaliacao> avaliacoes;
    private int removido;

    public Receita() {
        this.id = 0; //NECESSARIO CRIAR ID INCREMENTO
        this.nome = "";
        this.nimgs = 0;
        this.img = new Imagem();
        this.datapub = new GregorianCalendar();
        this.user = ""; 
        this.totalCal = 0;
        this.ingrs = new ReceitaIngredienteDAO(this.id);
        this.vavaliacoes = 0;
        this.navaliacoes = 0;
        this.coments = new ComentariosDAO(this.id);
        this.seguidores = new ReceitaSeguidaDAO(this.id);
        this.avaliacoes = new AvaliacoesUtilizadorDAO(this.id);
        this.removido = 0;
    }
    
    public Receita(int id, String nm, String desc, int nrI, GregorianCalendar g, String user, String cetegoria, int valorA, int nrAvaliacoes, int totalCal, int rm){
        this.id = id;
        this.nome = nm;
        this.desc = desc;
        this.nimgs = nrI;
        this.datapub = g;
        this.user = user;
        this.vavaliacoes = valorA;
        this.navaliacoes = nrAvaliacoes;
        this.totalCal = totalCal;
        this.removido = rm;
        this.ingrs = new ReceitaIngredienteDAO(this.id);
        this.coments = new ComentariosDAO(this.id);
        this.seguidores = new ReceitaSeguidaDAO(this.id);
        this.avaliacoes = new AvaliacoesUtilizadorDAO(this.id);
    }
    
    public Map<Integer, Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getNimgs() {
        return nimgs;
    }

    public void setNimgs(int nimgs) {
        this.nimgs = nimgs;
    }

    public Imagem getImg() {
        return img;
    }

    public void setImg(Imagem img) {
        this.img = img;
    }

    public GregorianCalendar getDatapub() {
        return datapub;
    }

    public void setDatapub(GregorianCalendar datapub) {
        this.datapub = datapub;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getTotalCal() {
        return totalCal;
    }

    public void setTotalCal(int totalCal) {
        this.totalCal = totalCal;
    }

    public Map<Integer, Ingrediente> getIngrs() {
        return ingrs;
    }

    public void setIngrs(Map<Integer, Ingrediente> ingrs) {
        this.ingrs = ingrs;
    }

    public int getVavaliacoes() {
        return vavaliacoes;
    }

    public void setVavaliacoes(int vavaliacoes) {
        this.vavaliacoes = vavaliacoes;
    }

    public int getNavaliacoes() {
        return navaliacoes;
    }

    public void setNavaliacoes(int navaliacoes) {
        this.navaliacoes = navaliacoes;
    }

    public Map<Integer, Comentario> getComents() {
        return coments;
    }

    public void setComents(Map<Integer, Comentario> coments) {
        this.coments = coments;
    }

    public Map<Integer, String> getSeguidores() {
        return seguidores;
    }

    public void setSeguidores(Map<Integer, String> seguidores) {
        this.seguidores = seguidores;
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
        hash = 13 * hash + this.id;
        hash = 13 * hash + Objects.hashCode(this.nome);
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
        final Receita other = (Receita) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.desc, other.desc)) {
            return false;
        }
        if (this.nimgs != other.nimgs) {
            return false;
        }
        if (!Objects.equals(this.img, other.img)) {
            return false;
        }
        if (!Objects.equals(this.datapub, other.datapub)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (this.totalCal != other.totalCal) {
            return false;
        }
        if (!Objects.equals(this.ingrs, other.ingrs)) {
            return false;
        }
        if (this.vavaliacoes != other.vavaliacoes) {
            return false;
        }
        if (this.navaliacoes != other.navaliacoes) {
            return false;
        }
        if (!Objects.equals(this.coments, other.coments)) {
            return false;
        }
        if (!Objects.equals(this.seguidores, other.seguidores)) {
            return false;
        }
        return this.removido == other.removido;
    }
}
