import java.sql.*;
import java.util.ArrayList;

public class Cliente{
   private int id;
   private String nome;
   private String fone;
   
   public Cliente(){
   }
   
   public Cliente(int id){
      this.id = id;
   }
   
   public Cliente(int id, String nome, String fone){
      this.id = id;
      this.nome = nome;
      this.fone = fone;
   }
   
   public int getId(){
      return id;
   }
   
   public void setId(int id){
      this.id = id;
   }
   public String getNome(){
      return nome;
   }
   
   public void setNome(String nome){
      this.nome = nome;
   }
   public String getFone(){
      return fone;
   }
   
   public void setFone(String fone){
      this.fone = fone;
   }
   
   public void inserir(Connection conn) throws SQLException{
      String sqlInsert = 
         "INSERT INTO CLIENTE (id, nome, fone) VALUES (?,?,?)";
      try(PreparedStatement stm = conn.prepareStatement(sqlInsert);){
         stm.setInt(1, id);
         stm.setString(2, nome);
         stm.setString(3, fone);
         stm.execute();
      } 
      catch (SQLException e){
         e.printStackTrace();
         conn.rollback();
      }
   }
   
   public void alterar(Connection conn) throws SQLException{
      String sqlUpdate = 
         "UPDATE CLIENTE SET nome=?, fone=? WHERE id=?";
      try(PreparedStatement stm = conn.prepareStatement(sqlUpdate);){
         stm.setInt(3, id);
         stm.setString(1, nome);
         stm.setString(2, fone);
         stm.execute();
      } 
      catch (SQLException e){
         e.printStackTrace();
         conn.rollback();
      }
   }
   
   public void excluir(Connection conn) throws SQLException{
      String sqlDelete = 
         "DELETE FROM CLIENTE WHERE id=?";
      try(PreparedStatement stm = conn.prepareStatement(sqlDelete);){
         stm.setInt(1, id);
         stm.execute();
      } 
      catch (SQLException e){
         e.printStackTrace();
         conn.rollback();
      }
   }
   
   public void carregar(Connection conn) throws SQLException{
      String sqlSelect = 
         "SELECT nome, fone FROM CLIENTE WHERE id=?";
      try(PreparedStatement stm = conn.prepareStatement(sqlSelect);){
         stm.setInt(1, id);
         try(ResultSet rs = stm.executeQuery();){
            if(rs.next()){
               nome = rs.getString(1);
               fone = rs.getString(2);
            } 
            else {
               nome = null;
               fone = null;
            }
         } 
         catch (SQLException e){
            e.printStackTrace();
         }
      } 
      catch (SQLException e){
         e.printStackTrace();
      }
   }
   
   public ArrayList<Cliente> listarClientes(Connection conn) throws SQLException{
      String sqlSelect = 
         "SELECT id, nome, fone FROM CLIENTE";
      ArrayList<Cliente> lista = new ArrayList<>();
      try(PreparedStatement stm = conn.prepareStatement(sqlSelect);
          ResultSet rs = stm.executeQuery();){
         while(rs.next()){
            Cliente cliente = new Cliente();
            cliente.setId(rs.getInt("id"));
            cliente.setNome(rs.getString("nome"));
            cliente.setFone(rs.getString("fone"));
            lista.add(cliente);
         }
      } 
      catch (SQLException e){
         e.printStackTrace();
      }
      return lista;
   }


   public String toString(){
      return "id="+id+";nome="+nome+"; fone="+fone;
   }

} 
