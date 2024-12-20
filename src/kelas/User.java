/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kelas;

import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Santri IT
 */
public class User {

    String user_name, user_email, user_password, user_fullname;
    int user_status;

    private Connection conek;

    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String query;

    public User() throws SQLException {
        Koneksi Koneksi = new Koneksi();
        conek = Koneksi.konekBD();

    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_nme(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_pasword() {
        return user_password;
    }

    public void setUser_pasword(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_fullname() {
        return user_fullname;
    }

    public void setUser_fullname(String user_fullname) {
        this.user_fullname = user_fullname;
    }

    public int getUser_status() {
        return user_status;
    }

    public void setUser_status(int user_status) {
        this.user_status = user_status;
    }

    public void TambahUser() {
        query = "INSERT INTO user VALUES (?,?,MD5(?),?,?)";
        try {
            ps = conek.prepareStatement(query);
            ps.setString(1, user_name);
            ps.setString(2, user_email);
            ps.setString(3, user_password);
            ps.setString(4, user_fullname);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "User Berhasil Ditambahkan");
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "User Gagal Ditambahkan");
        }
    }
}
