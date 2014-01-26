package DataLayer;

import BusinessLayer.Receita;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class ReceitaDAO implements Map<Integer, Receita>{

    private String nomeCategoria;
    
    public static int ID_RECEITA = 1;
    public static int NOME = 2;
    public static int DESCRICAO = 3;
    public static int NR_IMAGENS = 4;
    public static int CATEGORIA = 5;
    public static int NOME_UTILIZADOR = 6;
    public static int VALOR_AVALIACOES = 7;
    public static int NR_AVALIACOES = 8;
    public static int TOTAL_CALORIAS = 9;
    public static int APAGADO = 10;
    public static int TEMPO_PREPARACAO = 11;
    public static int DOSE = 12;
    public static int CREATE = 13;
    public static int UPDATE = 14;
    public static int INGREDIENTES = 15;
    
    public ReceitaDAO(){
    }
    
    public ReceitaDAO(String nCat) {
        this.nomeCategoria = nCat;
    }

    @Override
    public int size() {
        int res = 0;
        try {
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM RECEITAS";
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next())
                res++;
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }

    @Override
    public boolean isEmpty() {
        boolean res = false;
        try {
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM RECEITAS";
            ResultSet rs = stm.executeQuery(sql);
            res = rs.next();
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }

    @Override
    public boolean containsKey(Object key) {
        boolean res = false;
        try {
            int id = (Integer) key;
            String sql = "SELECT * FROM RECEITAS r WHERE r.IDRECEITA = "+id;
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            res = rs.next();
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }

    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Receita get(Object key) {
        Receita rec = null;
        try {
            int id = (Integer) key;
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM RECEITAS r WHERE r.IDRECEITA = "+id+" and u.APAGADO = "+0;
            ResultSet rs = stm.executeQuery(sql);
            
            if(rs.next()) {
                String nomeReceita = rs.getString(NOME);
                String descricao = rs.getString(DESCRICAO);
                int nrImagens = rs.getInt(NR_IMAGENS);
                String user = rs.getString(NOME_UTILIZADOR);
                int valorAvaliacoes = rs.getInt(VALOR_AVALIACOES); // ALTERAR CASO MUDE NA CLASSE RECEITA
                int nrAvaliacoes = rs.getInt(NR_AVALIACOES);
                int totalCalorias = rs.getInt(TOTAL_CALORIAS); // ALTERAR CASO MUDE NA CLASSE RECEITA
                int rm = rs.getInt(APAGADO);
                int tempo = rs.getInt(TEMPO_PREPARACAO);
                int dose = rs.getInt(DOSE);
                Calendar create = GregorianCalendar.getInstance();
                create.setTime(rs.getTimestamp(CREATE));
                Calendar update = GregorianCalendar.getInstance();
                update.setTime(rs.getTimestamp(UPDATE));
                String ingr = rs.getString(INGREDIENTES);
                
                rec = new Receita(id, nomeReceita, descricao, nrImagens, this.nomeCategoria, user, valorAvaliacoes, nrAvaliacoes, totalCalorias, rm, tempo, dose, (GregorianCalendar) create, (GregorianCalendar) update, ingr);
            }            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return rec;
    }

    @Override
    public Receita put(Integer key, Receita value) {
        Receita rec = null;
        try {
            String sql = null;
            if(!this.containsKey(key)) {
                sql = "INSERT INTO Receita(idReceita, nome, descricao, nrImagens, categoria, username, valorAvaliacoes, nrAvaliacoes, totalCalorias, apagado, tempoPreparacao, dose, created_at, updated_at, ingredientes)"
                        + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                
            } else {
                sql = "";
            }
            PreparedStatement pstm = ConexaoBD.getConexao().prepareStatement(sql);
            pstm.setInt(ID_RECEITA, value.getId());
            pstm.setString(NOME, value.getNome());
            pstm.setString(DESCRICAO, value.getDesc());
            pstm.setInt(NR_IMAGENS, value.getNimgs());
            pstm.setString(CATEGORIA, this.nomeCategoria);
            pstm.setString(NOME_UTILIZADOR, value.getUser());
            pstm.setInt(VALOR_AVALIACOES, value.getVavaliacoes());
            pstm.setInt(NR_AVALIACOES, value.getNavaliacoes());
            pstm.setInt(TOTAL_CALORIAS, value.getTotalCal());
            pstm.setInt(APAGADO, value.getRemovido());
            pstm.setInt(TEMPO_PREPARACAO, value.getTempo());
            pstm.setInt(DOSE, value.getDose());
            Timestamp create = new Timestamp(value.getCreate().getTimeInMillis());
            pstm.setTimestamp(CREATE, create);
            Timestamp update = new Timestamp(value.getUpdate().getTimeInMillis());
            pstm.setTimestamp(UPDATE, update);
            pstm.setString(INGREDIENTES, value.getIngredientes());
            pstm.execute();
            
            rec = value;
            pstm.close();
        } catch (SQLException e) {
        }
        return rec;
    }

    @Override
    public Receita remove(Object key) {
        Receita rec = null;
        try {
            int id = (Integer) key;
            String sql = "UPDATE Receitas SET apagado = 1 WHERE idReceita = "+id;
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return rec;
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Receita> m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Integer> keySet() {
        Set<Integer> res = new TreeSet<>();
        try {
            String sql = "SELECT IDRECEITA FROM RECEITAS r WHERE r.APAGADO = 0";
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next())
                res.add(rs.getInt(ID_RECEITA));
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }

    @Override
    public Collection<Receita> values() {
        Collection<Receita> res = new HashSet<>();
        try {
            String sql = "SELECT IDRECEITA FROM RECEITAS r WHERE r.APAGADO = 0";
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next())
                res.add(this.get(rs.getInt(ID_RECEITA)));
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }

    @Override
    public Set<Entry<Integer, Receita>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   
}
