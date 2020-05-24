package dao;

import entity.Proje;
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

public class ProjeDao {

    private DBconnection connector;
    private Connection connection;

    public List<Proje> findAll() {
        List<Proje> clist = new ArrayList<>();
        //DBconnection db = new DBconnection();
        //Connection c = db.connect();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from proje");

            while (rs.next()) {
                //System.out.println(rs.getString("name"));
                Proje tmp = new Proje(rs.getInt("proje_id"), rs.getString("proje_adi"), rs.getString("proje_sahibi"), rs.getInt("alt_fiyat"), rs.getInt("ust_fiyat"),rs.getString("proje_adresi"));
                clist.add(tmp);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return clist;

    }

    public void insert(Proje proje) {

        try {
            Statement st = this.getConnection().createStatement();

           // st.executeUpdate("insert into proje (kullanici_adi,sifre,ad_soyad,admin_mi) values ('" + kullanici.getKullanciAdi() + "', '" + kullanici.getSifre() + "', '" + kullanici.getAdSoyad() + "', 0)" , Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                int key = rs.getInt(1);
                System.out.println("Auto Generated Primary Key " + key);
                
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

    }

    public void delete(Proje proje) {

        try {
            Statement st = this.getConnection().createStatement();

            //st.executeUpdate("delete from kullanici where kullanici_id=" + kullanici.getKullaniciId());

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

    public void update(Proje proje) {
        try {
            Statement st = this.getConnection().createStatement();

            //st.executeUpdate("update kullanici set ad_soyad='" + kullanici.getAdSoyad() + "' where kullanici_id= " + kullanici.getKullaniciId());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

}
