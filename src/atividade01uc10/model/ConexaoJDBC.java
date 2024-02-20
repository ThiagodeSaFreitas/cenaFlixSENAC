package atividade01uc10.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoJDBC {

    private Connection conexao;

    public void conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/cenaflix", "root", "tll051227");
            System.out.println("Sucesso de conexão!!!");
        } catch (ClassNotFoundException e) {
            System.out.println("Falha ao carregar a classe de conexão. Classe não encontarda!");
        } catch (SQLException e) {
            System.out.println("Falha ao conectar com o banco. Erro de SQL");
        }

    }

    public Connection getConexao() {
        return conexao;
    }
    
    public void desconectar(){
        try {
            if(conexao != null && !conexao.isClosed()){
                conexao.close();
                System.out.println("Desconectado com sucesso!");
            }
            } catch (SQLException e){
               System.out.println("Erro ao desconectar!");
            }
        
    }

}

    
