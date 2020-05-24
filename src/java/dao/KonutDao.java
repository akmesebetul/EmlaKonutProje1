package dao;

import entity.Konut;
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

public class KonutDao {

    private DBconnection connector;
    private Connection connection;

    public List<Konut> findAll() {
        List<Konut> clist = new ArrayList<>();
        //DBconnection db = new DBconnection();
        //Connection c = db.connect();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from konut");

            while (rs.next()) {
                //System.out.println(rs.getString("name"));
                Konut tmp = new Konut(rs.getInt("konut_id"), rs.getInt("oda_sayisi"), rs.getInt("alan"), rs.getString("adres"));
                clist.add(tmp);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return clist;

    }

    public int insert(Konut konut) {
        int key = 0;
        try {
            Statement st = this.getConnection().createStatement();

            st.executeUpdate("insert into konut (oda_sayisi,alan,adres) values (" + konut.getOda_sayisi()+"," + konut.getAlan()+ ", '" + konut.getAdres()+ "')" , Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                key = rs.getInt(1);
                System.out.println("Auto Generated Primary Key " + key);
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        
        return key;

    }

    public void delete(Konut konut) {

        try {
            Statement st = this.getConnection().createStatement();

            st.executeUpdate("delete from konut where konut_id=" + konut.getKonutId());

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

    public void update(Konut konut) {
        try {
            Statement st = this.getConnection().createStatement();

           // st.executeUpdate("update konut set ad_soyad='" + kullanici.getAdSoyad() + "' where kullanici_id= " + kullanici.getKullaniciId());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

}
