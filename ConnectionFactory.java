import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class ConnectionFactory{
   static{
      try{
         Class.forName("com.mysql.jdbc.Driver");
      } catch (ClassNotFoundException e){
         e.printStackTrace();
         throw new RuntimeException(e);
      }
   }
   
   public Connection getConnection() throws SQLException{
      return DriverManager.getConnection(
         "jdbc:mysql://localhost/bancodeteste?user=root&"
         + "password=jv88888489");
   }
   

}