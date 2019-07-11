
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTextField;

public class DatabaseData {

    private Statement st;

    public DatabaseData() {
    }

    public DatabaseData(Statement st) {
        this.st = st;
    }

    public ResultSet getData(String str) {
        try {
            String query = "select * from PRODATA." + str;
            ResultSet rs = st.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            return null;
        }
    }

    public boolean insertCustomer(String id, String name, String phone) throws SQLException {
        int i = st.executeUpdate("INSERT INTO customer values ('" + id + "','" + name + "','" + phone + "')");
        System.out.println("Insert Customer Success");
        if (i > -1) {
            return true;
        } else {
            return false;
        }
    }
    public boolean DBill(String tt) throws SQLException {
        int a = st.executeUpdate("UPDATE TABLEA SET TABLE_STATUS = 'Empty' WHERE TABLE_STATUS = 'Full' And TABLE_ID = '"  + tt + "'");
        if (a > -1) {
            return true;
        } else {
            return false;
        }
    }
    public boolean insertBill(String tt, String ss,String ti) throws SQLException {

        int i = st.executeUpdate("INSERT INTO BILL (bill_id,queue,table_id,customer_id,time) VALUES (BILL_SEQ.nextval , RESERVATION_SEQ.nextval , '" + tt + "' , '" + ss + "' , '" +ti+ "' )");
        
        System.out.println("Insert Bill success");
        
        int a = st.executeUpdate("UPDATE TABLEA SET TABLE_STATUS = 'Full' WHERE TABLE_STATUS = 'Empty' And TABLE_ID = '"  + tt + "'");
        if (i > -1 && a > -1) {
            return true;
        } else {
            return false;
        }
    }

    public ResultSet getSearch(String str, String tsn) {
        try {
            String query = "select * from PRODATA." + str + " WHERE store_name = '" + tsn + "' ";
            System.out.println("Select Information  success");
            ResultSet rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }

    public ResultSet getSearchs(String kuy, String nid, String kuyy) {
        try {
            String query = "select PRODATA." + kuy + ".table_status, PRODATA." + kuy + ".table_id, PRODATA." + kuy + ".store_id from PRODATA." + kuy + ",PRODATA." + kuyy + " WHERE PRODATA." + kuy + ".store_id = PRODATA." + kuyy + ".store_id and PRODATA." + kuyy + ".store_name = '" + nid + "' and PRODATA.TABLEA.TABLE_STATUS = 'Empty'";
            System.out.println("Select Table success");
            ResultSet rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }
    public ResultSet getAdmin(String kuy, String nid, String kuyy) {
        try {
            String query = "select PRODATA." + kuy + ".table_status, PRODATA." + kuy + ".table_id, PRODATA." + kuy + ".store_id from PRODATA." + kuy + ",PRODATA." + kuyy + " WHERE PRODATA." + kuy + ".store_id = PRODATA." + kuyy + ".store_id and PRODATA." + kuyy + ".store_name = '" + nid + "' and PRODATA.TABLEA.TABLE_STATUS = 'Full'";
            System.out.println("Select Table success");
            ResultSet rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }
    

    public ResultSet getBill(String str) {
        try {
            String query = "select * from PRODATA." + str;
            System.out.println("Select Bill success");
            ResultSet rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }

    }

    

}
