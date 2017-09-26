
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JOptionPane;
import util.ConnectDB;

public class Member {

    int cus_id;
    int cus_age;
    String cus_gender;
    String cus_fname;
    String cus_lname;
    String cus_address;
    String img_path;

    void newMember(String fname, String lname, String img, int age, String gender, String addr) {
        //cus_id = id;
        Connection con;
        cus_fname = fname;
        cus_lname = lname;
        img_path = img;
        cus_age = age;
        cus_gender = gender;
        cus_address = addr;
        try {
            con = ConnectDB.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into customers(cus_fname,cus_lname,img,cus_age,cus_gender,cus_address) values(?,?,?,?,?,?)");
            //InputStream is = new FileInputStream(new File(img));
            //ps.setInt(1, id);
            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, img);
            ps.setInt(4, age);
            ps.setString(5, gender);
            ps.setString(6, addr);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Inserted");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con = ConnectDB.closeConnection();
        }
    }

    void UpdateMember(String fname, String lname, String img, int age, String gender, String addr, int selectRow, int selectId) {
        Connection con;

        try {
            con = ConnectDB.getConnection();
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE customers SET cus_fname='" + fname + "',cus_lname='" + lname + "',img='" + img + "',cus_age='" + age + "',cus_gender='" + gender + "',cus_address='" + addr + "'" + " WHERE cus_id = " + selectId + "");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con = ConnectDB.closeConnection();
        }

    }

    void DeleteMember(int selectId) {
        Connection con = ConnectDB.getConnection();
        try {
            Statement stmt = con.createStatement();
            //System.out.println("w");
            stmt.executeUpdate("DELETE FROM customers WHERE cus_id = " + selectId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con = ConnectDB.closeConnection();
        }
    }

}
