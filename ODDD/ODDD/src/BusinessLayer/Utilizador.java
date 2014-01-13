package BusinessLayer;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.GregorianCalendar;

public class Utilizador {

    private int tipo;
    private String nick;
    private String nome;
    private String email;
    private String passw;
    private String descricao;
    private GregorianCalendar datareg;
    private Imagem img;
    private int nreceitas;
    private int valorav;
    private int navaliacoes;
    private int ativo;
    private int dadoscomp;
    private int removido;

    Utilizador(int tipo, String nickname, String password, String email, GregorianCalendar g) {
        this.tipo = tipo;
        this.nick = nickname;
        this.passw = password;
        this.email = email;
        this.datareg = g;
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

    public Imagem getImg() {
        return img;
    }

    public void setImg(Imagem img) {
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
    
    public int getAtivo() {
        return this.ativo;
    }
    
    public void setAtivo(int atv) {
        this.ativo = atv;
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
