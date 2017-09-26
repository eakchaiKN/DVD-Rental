package util;
import java.sql.*;
public class ConnectDB {
    private static final String MYURL = "jdbc:mysql://127.0.0.1:3306/dvd_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    static Connection con = null;
    
    public static Connection getConnection (){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(MYURL,USERNAME,PASSWORD);
            if (con != null){
                System.out.println("Succesfully connected!");
            }else {
                System.out.println("Connection fail!");
            }
     
        }catch(Exception e){
            e.printStackTrace();
        }
        return con; 
    }
    public static Connection closeConnection (){
        try {
        con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;    
    }
}
