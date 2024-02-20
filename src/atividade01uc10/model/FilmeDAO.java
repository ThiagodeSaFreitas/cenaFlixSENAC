
package atividade01uc10.model;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FilmeDAO {
    
    public static void cadastrar( Filme f){
        try{
            ConexaoJDBC conexao = new ConexaoJDBC();
            conexao.conectar();
            
            String sql = "INSERT INTO filmes (nome, dataLancamento, categoria, ativo) values(?,?,?,?);";
            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);
            consulta.setString(1, f.getNome());
            consulta.setString(2, f.getDataLancamento());
            consulta.setString(3, f.getCategoria());
            consulta.setBoolean(4, true);
            consulta.execute();
            conexao.desconectar();
            
            
                }catch (SQLException e){
            System.out.println("Erro ao cadastrar no banco de dados");
            
        }
        
   
    }
    
     public static List<Filme> listarTodos(){
         
         List<Filme> lista = new ArrayList<Filme>();
        try{
            ConexaoJDBC conexao = new ConexaoJDBC();
            conexao.conectar();
            
            String sql = "SELECT * FROM filmes WHERE ativo = 1";
            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);
            
            ResultSet resposta = consulta.executeQuery();
            
            while(resposta.next()){
                Filme f = new Filme();
                f.setId(resposta.getInt("id"));
                f.setNome(resposta.getString("nome"));
                f.setDataLancamento(resposta.getString("dataLancamento"));
                f.setCategoria(resposta.getString("categoria"));
                
                lista.add(f);
            }
            
            conexao.desconectar();
            
            
                }catch (SQLException e){
            System.out.println("Erro ao listar os banco de dados");
            
        }
        
        return lista;
    }
     
     public static Filme buscarId(int id){
         
        Filme f = new Filme();
        
        try{
            ConexaoJDBC conexao = new ConexaoJDBC();
            conexao.conectar();
            
            String sql = "SELECT * FROM filmes WHERE id = ? AND ativo = 1";
            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);
            consulta.setInt(1, id);
            ResultSet resposta = consulta.executeQuery();
            
            if (resposta.next()){
               
                f.setId(resposta.getInt("id"));
                f.setNome(resposta.getString("nome"));
                f.setDataLancamento(resposta.getString("dataLancamento"));
                f.setCategoria(resposta.getString("categoria"));
              
            }
            
            conexao.desconectar();
            
            
                }catch (SQLException e){
            System.out.println("Erro ao buscar o registro " + id + " no banco de dados");
            
        }
        
        return f; 
     }
    
     public static boolean atualizar(Filme f){
           try{
            ConexaoJDBC conexao = new ConexaoJDBC();
            conexao.conectar();

            String sql = "UPDATE filmes SET nome = ?, dataLancamento = ?, categoria = ? WHERE id = ? AND ativo = 1;";
            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);
            
            
            consulta.setString(1, f.getNome());
            consulta.setString(2, f.getDataLancamento());
            consulta.setString(3, f.getCategoria());
            consulta.setInt(4, f.getId());
            
            consulta.execute();
            conexao.desconectar();
            return true;
            
            
                }catch (SQLException e){
            System.out.println("Erro ao atualizar registro no banco de dados");
            return false;
        }
     }
     
     public static boolean excluir (int id){
            try{
            ConexaoJDBC conexao = new ConexaoJDBC();
            conexao.conectar();

            String sql = "UPDATE filmes SET ativo = 0 WHERE id = ?;";
            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);
            
            
           
            consulta.setInt(1, id);
            
            consulta.execute();
            conexao.desconectar();
            return true;
            
            
                }catch (SQLException e){
            System.out.println("Erro ao excluir registro no banco de dados");
            return false;
        }
                
} 
     
     public static List<Filme> filtrarPorCategoria(String textoPesquisa){
         
         List<Filme> lista = new ArrayList<Filme>();
         
        try{
            ConexaoJDBC conexao = new ConexaoJDBC();
            conexao.conectar();
            
            String sql = "SELECT * FROM filmes WHERE ativo = 1 AND categoria LIKE ?";
            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);
            consulta.setString(1, "%" + textoPesquisa + "%");
            ResultSet resposta = consulta.executeQuery();
            
            while(resposta.next()){
                Filme f = new Filme();
                f.setId(resposta.getInt("id"));
                f.setNome(resposta.getString("nome"));
                f.setDataLancamento(resposta.getString("dataLancamento"));
                f.setCategoria(resposta.getString("categoria"));
                
                lista.add(f);
            }
            
            conexao.desconectar();
            
            
                }catch (SQLException e){
            System.out.println("Erro ao listar os banco de dados");
            
        }
        
        return lista;
     }
}
