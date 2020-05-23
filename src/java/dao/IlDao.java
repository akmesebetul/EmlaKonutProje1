/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author tr
 */
import entity.Il;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.resource.spi.Connector;
import util.DBconnection;

public class IlDao {

    private DBconnection connector;
    private Connection connection;

    public List<Il> findAll() {
        List<Il> clist = new ArrayList<>();
        //DBconnection db = new DBconnection();
        //Connection c = db.connect();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from il");

            while (rs.next()) {
                //System.out.println(rs.getString("name"));
                Il tmp = new Il(rs.getInt("il_id"), rs.getString("il_adi"));
                clist.add(tmp);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return clist;

    }
    
    public Il find(int id){
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from il where il_id = " + id);

            if (rs.next()) {
                //System.out.println(rs.getString("name"));
                Il il = new Il(rs.getInt("il_id"), rs.getString("il_adi"));
                return il;

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
       Il hataliIl = new Il(0,"Hatalı İl Kodu");
       return hataliIl;
    }
    
     int findIdbyName(String ilName) {
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from il where il_adi = '" + ilName + "'");

            if (rs.next()) {
                //System.out.println(rs.getString("name"));
                Il il = new Il(rs.getInt("il_id"), rs.getString("il_adi"));
                return il.getIl_id();

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return 0;
    }

    public void insert(Il il) {

        try {
            Statement st = this.getConnection().createStatement();

           // st.executeUpdate("insert into il (kullanici_adi,sifre,ad_soyad,admin_mi) values ('" + kullanici.getKullanciAdi() + "', '" + kullanici.getSifre() + "', '" + kullanici.getAdSoyad() + "', 0)" , Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                int key = rs.getInt(1);
                System.out.println("Auto Generated Primary Key " + key);
                
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

    }

    public void delete(Il il) {

        try {
            Statement st = this.getConnection().createStatement();

            st.executeUpdate("delete from il where il_id=" + il.getIl_id());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

    }

    public DBconnection getConnector() {
        if (this.connector == null) {
            this.connector = new DBconnection();
        }
        return connector;
    }

    public Connection getConnection() {
        if (this.connection == null) {
            this.connection = this.getConnector().connect();
        }

        return connection;
    }

    public void update(Il il) {
        try {
            Statement st = this.getConnection().createStatement();

           // st.executeUpdate("update il set ad_soyad='" + kullanici.getAdSoyad() + "' where kullanici_id= " + kullanici.getKullaniciId());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

   

}