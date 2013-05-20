package br.com.bs.estoque.model.produto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.bs.estoque.model.database.mysql.ConnectionFactory;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    public static final String  SALVA_OK = "Produto CADASTRADO com sucesso.";
    public static final String  ATUALIZA_OK = "Produto ATUALIZADO com sucesso.";
    public static final String  EXCLUI_OK = "Produto EXCLUÍDO com sucesso.";
    public static final String  DEFAULT_ERROR_MSG = "ERRO ao cadastrar produto.";
    public static final String  DUPLICATE_ENTRY_ERROR = "ERRO ao cadastrar produto:\nJá existe"
            + " um produto cadastrado com este código.";
    
    public String salva(Produto produto) {
        String sql = "insert into produto(id,nome, descricao,preco,quantidade,dataAtualizacao) values(?,?,?,?,?,?"
                + ");";
        try {
            PreparedStatement stmt = ConnectionFactory.getConn().prepareStatement(sql);
            int i = 0;
            stmt.setString(++i, produto.getId());
            stmt.setString(++i, produto.getNome());
            stmt.setString(++i, produto.getDescricao());
            stmt.setDouble(++i, Double.valueOf(produto.getPreco()));
            stmt.setString(++i, produto.getQuantidade());
            stmt.setString(++i, produto.getDataAtualizacao());
            if(!stmt.execute())
                return SALVA_OK;
        }catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException exc){
            return DUPLICATE_ENTRY_ERROR;
        } catch (SQLException e) {
                e.printStackTrace();
        }
        return DEFAULT_ERROR_MSG;
    }

    public Produto buscaPorNome(String nome) {
        Produto resultado = null;
        try {
            String sql = "select id,nome,descricao,preco,quantidade,dataAtualizacao from cliente where nome like '%" + nome + "%'";
            Statement stmt = ConnectionFactory.getConn().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.first()) {
                resultado = new Produto();
                resultado.setId(rs.getString(1));
                resultado.setNome(rs.getString(2));
                resultado.setDescricao(rs.getString(3));
                resultado.setPreco(rs.getString(4));
                resultado.setQuantidade(rs.getString(5));
                resultado.setDataAtualizacao(rs.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public String atualiza(Produto produto) {
        String sqlUpdate = "update produto set nome = ?, descricao = ?,"
                + "preco = ?, quantidade = ?,dataAtualizacao = ? where id = ?";
        try {
            PreparedStatement stmt = ConnectionFactory.getConn().prepareStatement(sqlUpdate);
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, Double.valueOf(produto.getPreco()));
            stmt.setInt(4, Integer.valueOf(produto.getQuantidade()));
            stmt.setString(5, produto.getDataAtualizacao());
            stmt.setString(6, produto.getId()); 
            System.out.println(stmt);
            int res = stmt.executeUpdate();
            if(res > 0)
                return ATUALIZA_OK;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();            
        }
        return DEFAULT_ERROR_MSG;
    }

    public List<Produto> lista() {
        List<Produto> result = new ArrayList();

        String sql = "select * from produto";
        try {
            Statement stmt = ConnectionFactory.getConn().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            Produto tmpProd;
            while (rs.next()) {
                tmpProd = new Produto();
                tmpProd.setId(rs.getString("id"));
                tmpProd.setNome(rs.getString("nome"));
                tmpProd.setDescricao(rs.getString("descricao"));
                tmpProd.setPreco(rs.getString("preco"));
                tmpProd.setQuantidade(rs.getString("quantidade"));
                tmpProd.setDataAtualizacao(rs.getString("dataAtualizacao"));
                result.add(tmpProd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean exclui(long id) {
        String sql = "delete from produto where id = ?";
        try {
            PreparedStatement stmt = ConnectionFactory.getConn().prepareStatement(sql);
            stmt.setLong(1, id);
            return stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
