package BusinessLayer;

import DataLayer.ChefesSeguidosDAO;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import DataLayer.ReceitaSeguidaDAO;
import java.util.GregorianCalendar;
import java.util.Map;

public class Utilizador {
    private int tipo; /* TIPO 0 = NORMAL TIPO 1 = ADMIN  */
    private String nick;
    private String nome;
    private String email;
    private String passw;
    private String descricao;
    private String img;
    private int nreceitas;
    private int valorav;
    private int navaliacoes;
    private int dadoscomp;
    private Map<String,Integer> receitasSeguidas;
    private Map<String,String> chefesseg;
    private int removido;
    private GregorianCalendar create;
    private GregorianCalendar update;
    private String localidade;
    
    

    Utilizador(int tipo, String nickname, String nome, String password, String email, GregorianCalendar g, GregorianCalendar d) {
        this.tipo = tipo;
        this.nick = nickname;
        this.nome = nome;
        this.passw = password;
        this.email = email;
        this.create = g;
        this.update = d;
    }

    public Utilizador(int tipo, String nick, String nome, String email, String pw,
              String desc, String img, int numrec, int valaval, int numaval, int dadoscomp, int rm, GregorianCalendar c, GregorianCalendar u, String l) {
        this.tipo = tipo;
        this.nick = nick;
        this.nome = nome;
        this.email = email;
        this.passw = pw;
        this.descricao = desc;
        this.img = img; // !!! ATIVAR ISTO, MUDAR OBJECT PARA IMAGEM
        this.nreceitas = numrec;
        this.valorav = valaval;
        this.navaliacoes = numaval;
        this.dadoscomp = dadoscomp;
        this.receitasSeguidas = new ReceitaSeguidaDAO(this.nick);
        this.chefesseg = new ChefesSeguidosDAO(this.nick);
        this.removido = rm;
        this.create = c;
        this.update = u;
        this.localidade = l;
    }
    
    public Map<String,String> getChefesSeguidos() {
        return this.chefesseg;
    }
    
    public Map<String,Integer> getReceitasSeguidas() {
        return this.receitasSeguidas;
    }
    
    public String getLocalidade() {
        return this.localidade;
    }

    public void setLocalidade(String l) {
        this.localidade = l;
    }
    
    public int getTipo() {
        return this.tipo;
    }
    
    public void setTipo(int t) {
        this.tipo = t;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNreceitas() {
        return nreceitas;
    }

    public void setNreceitas(int nreceitas) {
        this.nreceitas = nreceitas;
    }

    public int getValorav() {
        return valorav;
    }

    public void setValorav(int valorav) {
        this.valorav = valorav;
    }

    public int getNavaliacoes() {
        return navaliacoes;
    }

    public void setNavaliacoes(int navaliacoes) {
        this.navaliacoes = navaliacoes;
    }

    public int getDadosCompletos() {
        return dadoscomp;
    }

    public void setDadosCompletos(int dadoscomp) {
        this.dadoscomp = dadoscomp;
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
    
    public static String encriptarPassword(String pw) {
        byte[] pwB = pw.getBytes();
        byte[] pwEnc = null;
        String res = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            pwEnc = md.digest(pwB);
            BigInteger big = new BigInteger(1, pwEnc);
            res = big.toString(16);
        } catch (NoSuchAlgorithmException e) {
            throw new NullPointerException(e.getMessage());
        }
        return res;
    }

    public boolean passwordCorresponde(String pw) {
        return this.passw.equals(encriptarPassword(pw));
    }
}
