package BusinessLayer;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Utilizador {
    private String username;
    private String nome;
    private String email;
    private String password;
    private String avatar;
    private String descricao;
    private int numreceitas;
    private int valavaliacoes;
    private int numavaliacoes;
    private int dadoscompletos;
    private int apagado;
    private int tipo;
    private GregorianCalendar created;
    private GregorianCalendar updated;
    private String localidade;
    
    public Utilizador() {
        this.username = new String();
        this.nome = new String();
        this.email = new String();
        this.password = new String();
        this.avatar = new String();
        this.descricao = new String();
        this.numreceitas = 0;
        this.valavaliacoes = 0;
        this.numavaliacoes = 0;
        this.dadoscompletos = 0;
        this.apagado = 0;
        this.tipo = 0;
        this.created = new GregorianCalendar();
        this.updated = new GregorianCalendar();
        this.localidade = new String();
    }

    public Utilizador(String username, String nome, String email, String password, String avatar, String descricao, int numreceitas, int valavaliacoes, int numavaliacoes, int dadoscompletos, int apagado, int tipo, GregorianCalendar created, GregorianCalendar updated, String localidade) {
        this.username = username;
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.descricao = descricao;
        this.numreceitas = numreceitas;
        this.valavaliacoes = valavaliacoes;
        this.numavaliacoes = numavaliacoes;
        this.dadoscompletos = dadoscompletos;
        this.apagado = apagado;
        this.tipo = tipo;
        this.created = created;
        this.updated = updated;
        this.localidade = localidade;
    }

    Utilizador(int t, String nick, String nom, String pw, String mail) {
        this.username = nick;
        this.nome = nom;
        this.email = mail;
        this.password = pw;
        this.avatar = "";
        this.descricao = "";
        this.numreceitas = 0;
        this.valavaliacoes = 0;
        this.numavaliacoes = 0;
        this.dadoscompletos = 0;
        this.apagado = 0;
        this.tipo = t;
        this.created = new GregorianCalendar();
        this.updated = new GregorianCalendar();
        this.localidade = "";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNumReceitas() {
        return numreceitas;
    }

    public void setNumReceitas(int numreceitas) {
        this.numreceitas = numreceitas;
    }

    public int getValAvaliacoes() {
        return valavaliacoes;
    }

    public void setValAvaliacoes(int valavaliacoes) {
        this.valavaliacoes = valavaliacoes;
    }

    public int getNumAvaliacoes() {
        return numavaliacoes;
    }

    public void setNumAvaliacoes(int numavaliacoes) {
        this.numavaliacoes = numavaliacoes;
    }

    public int getDadosCompletos() {
        return dadoscompletos;
    }

    public void setDadosCompletos(int dadoscompletos) {
        this.dadoscompletos = dadoscompletos;
    }

    public int getApagado() {
        return apagado;
    }

    public void setApagado(int apagado) {
        this.apagado = apagado;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public GregorianCalendar getCreated() {
        return created;
    }

    public void setCreated(GregorianCalendar created) {
        this.created = created;
    }

    public GregorianCalendar getUpdated() {
        return updated;
    }

    public void setUpdated(GregorianCalendar updated) {
        this.updated = updated;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.username);
        hash = 67 * hash + Objects.hashCode(this.nome);
        hash = 67 * hash + Objects.hashCode(this.email);
        hash = 67 * hash + Objects.hashCode(this.password);
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
        final Utilizador other = (Utilizador) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }
  
    public static String encriptarPassword (String pw) {
        byte[] pwB = pw.getBytes() ;
        byte[] pwEnc = null ;
        String res = null ;        
        try {
            MessageDigest md = MessageDigest.getInstance("MD5") ;
            pwEnc = md.digest(pwB) ;
            BigInteger big = new BigInteger(1, pwEnc) ;
            res = big.toString(16) ;            
        } catch (NoSuchAlgorithmException e) {throw new NullPointerException(e.getMessage()) ;}
        return res ;
    }

    public boolean passwordCorresponde(String pw) {
        return this.password.equals(encriptarPassword(pw));
    }
}
