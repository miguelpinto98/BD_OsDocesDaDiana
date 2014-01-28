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
    public static int CUSTO = 9;
    public static int APAGADO = 10;
    public static int TEMPO_PREPARACAO = 11;
    public static int DOSE = 12;
    public static int CREATE = 13;
    public static int UPDATE = 14;
    public static int INGREDIENTES = 15;
    public static int VALOR_NUTRI = 16;
    
    public ReceitaDAO(String nCat) {
        this.nomeCategoria = nCat;
    }

    @Override
    public int size() {
        int res = 0;
        try {
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM RECEITAS r WHERE r.CATEGORIA = '"+this.nomeCategoria+"'";
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
            String sql = "SELECT * FROM RECEITAS r WHERE r.CATEGORIA = '"+this.nomeCategoria+"'";
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
            String sql = "SELECT * FROM RECEITAS r WHERE r.IDRECEITA = "+id+" and r.CATEGORIA = '"+this.nomeCategoria+"'";
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
            String sql = "SELECT * FROM RECEITAS r WHERE r.CATEGORIA = '"+this.nomeCategoria+"' and r.IDRECEITA = "+id+" and r.APAGADO = "+0;
            ResultSet rs = stm.executeQuery(sql);
            
            if(rs.next()) {
                String nomeReceita = rs.getString(NOME);
                String descricao = rs.getString(DESCRICAO);
                int nrImagens = rs.getInt(NR_IMAGENS);
                String user = rs.getString(NOME_UTILIZADOR);
                int valorAvaliacoes = rs.getInt(VALOR_AVALIACOES); // ALTERAR CASO MUDE NA CLASSE RECEITA
                int nrAvaliacoes = rs.getInt(NR_AVALIACOES);
                int custo = rs.getInt(CUSTO); //CUSTO
                int rm = rs.getInt(APAGADO);
                int tempo = rs.getInt(TEMPO_PREPARACAO);
                int dose = rs.getInt(DOSE);
                Calendar create = GregorianCalendar.getInstance();
                create.setTime(rs.getTimestamp(CREATE));
                Calendar update = GregorianCalendar.getInstance();
                update.setTime(rs.getTimestamp(UPDATE));
                String ingr = rs.getString(INGREDIENTES);
                int vnut = rs.getInt(VALOR_NUTRI); //PASSAR
                
                rec = new Receita(id, nomeReceita, descricao, nrImagens, this.nomeCategoria, user, valorAvaliacoes, nrAvaliacoes, custo, rm, tempo, dose, (GregorianCalendar) create, (GregorianCalendar) update, ingr, vnut);
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
            PreparedStatement pstm;
            String sql = null;
            if(!this.containsKey(key)) {
               GregorianCalendar c = value.getCreate();
               String cr = c.get(c.YEAR)+"-"+(c.get(c.MONTH)+1)+"-"+c.get(c.DAY_OF_MONTH)+" "+c.get(c.HOUR_OF_DAY)+":"+c.get(c.MINUTE)+":"+c.get(c.SECOND);
               c = value.getUpdate();
               String up = c.get(c.YEAR)+"-"+(c.get(c.MONTH)+1)+"-"+c.get(c.DAY_OF_MONTH)+" "+c.get(c.HOUR_OF_DAY)+":"+c.get(c.MINUTE)+":"+c.get(c.SECOND);
               
                sql = "INSERT INTO Receitas (nome, descricao, nrImagens, categoria, username, valorAvaliacoes, nrAvaliacoes, custo, apagado, tempoPreparacao, dose, created_at, updated_at, ingredientes, vnutricional)"
                        + "VALUES ('"+value.getNome()+"', '"+value.getDesc()+"', '"+value.getNimgs()+"', '"+this.nomeCategoria+"', '"+value.getUser()
                        +"', '"+value.getVavaliacoes()+"', '"+value.getNavaliacoes()+"', '"+value.getCusto()+"', '"+value.getRemovido()+"', '"+value.getTempo()
                        +"', '"+value.getDose()+"', TO_DATE('"+cr+"', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('"+up+"', 'YYYY-MM-DD HH24:MI:SS'), '"+value.getIngredientes()
                        +"', '"+value.getValorNutricional()+"')";
                
            } else {
                sql = "";
            }
            System.out.println(sql);
            pstm = ConexaoBD.getConexao().prepareStatement(sql);
            pstm.executeQuery();
             pstm.close();
            
         
        } catch (SQLException e) {
            e.printStackTrace();
           
        }   rec = value;
            
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
            String sql = "SELECT IDRECEITA FROM RECEITAS r WHERE r.APAGADO = 0 and r.CATEGORIA = '"+this.nomeCategoria+"'";
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
            String sql = "SELECT IDRECEITA FROM RECEITAS r WHERE r.APAGADO = 0 and r.CATEGORIA = '"+this.nomeCategoria+"'";
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
