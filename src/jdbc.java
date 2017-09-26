
import java.sql.*;

public class jdbc {

    private static final String MYURL = "jdbc:mysql://localhost:3306/ooad";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    Connection con = null;

    public static void main(String[] args) {
        new jdbc().getConnection();

    }

    public static Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(MYURL, USERNAME, PASSWORD);

            if (con != null) {
                //System.out.println("Database Connected.");
            } else {
               // System.out.println("Database Connect Failed.");
            }
            return con;
        } catch (Exception e) {

            e.printStackTrace();
        }

        // Close
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }

}
