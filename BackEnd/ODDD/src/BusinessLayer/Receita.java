package BusinessLayer;

import DataLayer.AvaliacoesUtilizadorDAO;
import DataLayer.ComentariosDAO;
import DataLayer.ReceitaIngredienteDAO;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.Objects;

public class Receita {

    private int id;
    private String nome;
    private String desc;
    private int nimgs;
    private Imagem img; // private Map<Integer,Imagem> imgs; // <IDRECEITAS,IMAGENS>
    private String user; // private Utilizador u ???
    private int totalCal; // NAO DEVERIA SER DOUBLE??
    private Map<Integer, Ingrediente> ingrs;
    private int vavaliacoes; // NAO DEVERIA SER DOUBLE??
    private int navaliacoes;
    private Map<Integer, Comentario> coments;
    private Map<String, Integer> avaliacoes;
    private int removido;
    private int tempoPreparacao;
    private int dose;
    private GregorianCalendar create;
    private GregorianCalendar update;
    private String ingredientes;

    public Receita() {
        this.id = 0; //NECESSARIO CRIAR ID INCREMENTO
        this.nome = "";
        this.nimgs = 0;
        this.img = new Imagem();
        this.user = ""; 
        this.totalCal = 0;
        this.ingrs = new ReceitaIngredienteDAO(this.id);
        this.vavaliacoes = 0;
        this.navaliacoes = 0;
        this.coments = new ComentariosDAO(this.id);
        this.avaliacoes = new AvaliacoesUtilizadorDAO(this.id);
        this.removido = 0;
        this.tempoPreparacao = 0;
        this.dose = 0;
        this.create = new GregorianCalendar();
        this.update = new GregorianCalendar();
        this.ingredientes = "";
    }
    
    public Receita(int id, String nm, String desc, int nrI, String user, String cetegoria, int valorA, int nrAvaliacoes, int totalCal, int rm, int tempoPreparacao, int dose, GregorianCalendar g, GregorianCalendar u, String in){
        this.id = id;
        this.nome = nm;
        this.desc = desc;
        this.nimgs = nrI;
        this.user = user;
        this.vavaliacoes = valorA;
        this.navaliacoes = nrAvaliacoes;
        this.totalCal = totalCal;
        this.removido = rm;
        this.ingrs = new ReceitaIngredienteDAO(this.id);
        this.coments = new ComentariosDAO(this.id);
        this.avaliacoes = new AvaliacoesUtilizadorDAO(this.id);
        this.tempoPreparacao = tempoPreparacao;
        this.dose = dose;
        this.create = g;
        this.update = u;
        this.ingredientes = in;
    }
    
    public Map<String, Integer> getAvaliacoes() {
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

    public int getRemovido() {
        return removido;
    }

    public void setRemovido(int removido) {
        this.removido = removido;
    }
    
    public int getTempo(){
        return this.tempoPreparacao;
    }
    
    public void setTempo(int t){
        this.tempoPreparacao = t;
    }
    
    public int getDose(){
        return this.dose;
    }
    
    public void setDose(int d){
        this.dose = d;
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
    
    public String getIngredientes(){
        return this.ingredientes;
    }
    
    public void setIngredientes(String in){
        this.ingredientes = in;
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
        if (!Objects.equals(this.create, other.create)) {
            return false;
        }
        if (!Objects.equals(this.update, other.update)) {
            return false;
        }
        return this.removido == other.removido;
    }
}
