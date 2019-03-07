import java.sql.*;
import java.util.*;

public class Teste{
   public static void main(String[] args){
   
      ConnectionFactory cf = new ConnectionFactory();
      try{
         Connection conn = cf.getConnection();
         conn.setAutoCommit(false); 
         Cliente cliente = new Cliente(4526, "Pedro Augusto", "24712536");
         cliente.inserir(conn);
         cliente.carregar(conn);
         System.out.println(cliente);
         cliente.setNome("Bruno");
         cliente.setFone("");
         cliente.alterar(conn);
         cliente.carregar(conn);
         System.out.println(cliente);
        // cliente.excluir(conn);
        // cliente.carregar(conn);
         //System.out.println(cliente);
         
         conn.commit();
         ArrayList<Cliente> lista = cliente.listarClientes(conn);
         for(Cliente cli:lista){
            System.out.println(cli);
         }
      } catch (SQLException e){
         e.printStackTrace();
      }  
   }
}
