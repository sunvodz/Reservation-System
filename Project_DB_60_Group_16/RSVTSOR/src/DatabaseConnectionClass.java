import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;
public class DatabaseConnectionClass {
private Connection myDBCon;
private Statement st;
public DatabaseConnectionClass() {
}public void connectDB() {
try {
Class.forName("oracle.jdbc.driver.OracleDriver");
} catch (ClassNotFoundException e) {
System.out.println("Cannot find classoracle.jdbc.driver.OracleDriver");
System.exit(1);
}
try {
myDBCon = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","prodata", "1234");
st = myDBCon.createStatement();
System.out.println("Connected success");
} catch (Exception e) {
System.out.println("ERROR " + e.getMessage());
}
}

public void setMyDBcon(Connection cn){
     this.myDBCon = cn;
}
public Connection getMyDBcon(){
      return this.myDBCon;
}
public void setst(Connection cn){
     this.st = st;
}
public Statement getst(){
      return this.st;
}

}