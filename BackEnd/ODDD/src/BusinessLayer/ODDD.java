package BusinessLayer;

import DataLayer.CategoriaDAO;
import DataLayer.ConexaoBD;
import DataLayer.UtilizadorDAO;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public class ODDD {

    private Map<String, Categoria> categorias;
    private Map<String, Utilizador> users;
    private Utilizador emSessao;

    public ODDD() {
        this.categorias = new CategoriaDAO();
        this.users = new UtilizadorDAO();
        this.emSessao = null;
        ConexaoBD.iniciarConexao();
    }

    public Map<String, Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(Map<String, Categoria> categorias) {
        this.categorias = categorias;
    }

    public Map<String, Utilizador> getUsers() {
        return users;
    }

    public void setUsers(Map<String, Utilizador> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ODDD other = (ODDD) obj;
        if (!Objects.equals(this.categorias, other.categorias)) {
            return false;
        }
        return Objects.equals(this.users, other.users);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.categorias);
        hash = 19 * hash + Objects.hashCode(this.users);
        return hash;
    }

    /* Metodos Utilizadores */
    public boolean existeEmail(String e) {
        boolean res = false;
        Iterator<String> it = this.users.keySet().iterator();
        while (it.hasNext() && !res) {
            String u = it.next();
            if (this.users.get(u).getEmail().equals(e)) {
                res = true;
            }
        }
        return res;
    }

    public boolean existeNickname(String nickname) {
        return (this.users.containsKey(nickname));
    }

    public boolean existeUtilizador(String nickname, String email) {
        return (existeNickname(nickname) || existeEmail(email));
    }

    public boolean validaPassword(String pw) {
        boolean res = true;
        int i = 0;
        if (pw.length() < 5) {
            return false;
        }
        for (; i < pw.length() && res; i++) {
            char c = pw.charAt(i);
            if (!(Character.isDigit(c) || Character.isLetter(c) || (c == '_') || (c == '.'))) {
                res = false;
            }
        }
        return res;
    }

    public boolean registarUser(String nickname, String nome, String password, String email, int tipo) {
        GregorianCalendar g = new GregorianCalendar();
        boolean inserido = false;

        if (validaPassword(password)) {
            Utilizador user = new Utilizador(tipo, nickname, nome, password, email, g);
            String pw = Utilizador.encriptarPassword(password);
            user.setPassw(pw);
            inserido = inserirUtilizador(user);
        }
        return inserido;
    }

    public boolean inserirUtilizador(Utilizador user) {
        boolean ins = false;
        if (!(existeUtilizador(user.getNick(), user.getEmail()))) {
            this.users.put(user.getNick(), user);
            ins = true;
        }
        return ins;
    }

    public void actualizarUtilizador(Utilizador user) {
        this.users.put(user.getNick(), user);
    }

    public void removerUtilizador(Utilizador user) {
        this.users.remove(user.getNick());
    }

    public boolean validaLogin(String nickname, String password) {
        return (existeNickname(nickname) && this.users.get(nickname).passwordCorresponde(password));
    }

    /* Ainda Falta Fazer Uma Verificação */
    public boolean login(String nickname, String password) {
        boolean lg;
        if (validaLogin(nickname, password)) {
            this.emSessao = this.users.get(nickname);
            lg = true;
            if (this.users.get(nickname).getDadosCompletos() == 1) {
                /**
                 * metodo prencher campos
                 */
                lg = true;
            }
        } else {
            //System.out.println("LOGIN INVALIDO");
            lg = false;
        }
        return lg;
    }

    public void logout() {
        this.emSessao = null;
    }
}
