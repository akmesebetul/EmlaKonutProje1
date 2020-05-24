package dao;

import entity.Kullanici;
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

public class KullaniciDao {

    private DBconnection connector;
    private Connection connection;

    public List<Kullanici> findAll() {
        List<Kullanici> clist = new ArrayList<>();
        //DBconnection db = new DBconnection();
        //Connection c = db.connect();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from kullanici");

            while (rs.next()) {
                //System.out.println(rs.getString("name"));
                Kullanici tmp = new Kullanici(rs.getInt("kullanici_id"), rs.getString("kullanici_adi"), rs.getString("sifre"), rs.getString("ad_soyad"), rs.getInt("admin_mi"));
                clist.add(tmp);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return clist;

    }
    
    public Kullanici find(int id){
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from kullanici where kullanici_id = " + id);

            if (rs.next()) {
                //System.out.println(rs.getString("name"));
                Kullanici kullanici = new Kullanici(rs.getInt("kullanici_id"), rs.getString("kullanici_adi"), rs.getString("sifre"), rs.getString("ad_soyad"), rs.getInt("admin_mi"));
                return kullanici;

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
       Kullanici hataliKullanici = new Kullanici();
       return hataliKullanici;
    }

    public void insert(Kullanici kullanici) {

        try {
            Statement st = this.getConnection().createStatement();

            st.executeUpdate("insert into kullanici (kullanici_adi,sifre,ad_soyad,admin_mi) values ('" + kullanici.getKullanciAdi() + "', '" + kullanici.getSifre() + "', '" + kullanici.getAdSoyad() + "', 0)");


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

    }

    public void delete(Kullanici kullanici) {

        try {
            Statement st = this.getConnection().createStatement();

            st.executeUpdate("delete from kullanici where kullanici_id=" + kullanici.getKullaniciId());

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

    public void update(Kullanici kullanici) {
        try {
            Statement st = this.getConnection().createStatement();

            st.executeUpdate("update kullanici set ad_soyad='" + kullanici.getAdSoyad() + "' where kullanici_id= " + kullanici.getKullaniciId());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    public Kullanici kullaniciBilgileriGecerliMi(String kullanciAdi, String sifre) {
    try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from kullanici where kullanici_adi = '" + kullanciAdi + "' AND sifre = '" + sifre+"'");

            if (rs.next()) {
                //System.out.println(rs.getString("name"));
                Kullanici kullanici = new Kullanici(rs.getInt("kullanici_id"), rs.getString("kullanici_adi"), rs.getString("sifre"), rs.getString("ad_soyad"), rs.getInt("admin_mi"));
                return kullanici;

            }
            
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
           return null;
    }

    public boolean checkUserAddable(Kullanici kullanici) {
         try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from kullanici where kullanici_adi = '" + kullanici.getKullanciAdi() + "'");

            if (rs.next()) {
                return false;
            }
            
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
           return true;
    }

}
