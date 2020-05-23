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
import entity.IlanTipi;
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

public class IlanTipiDao {

    private DBconnection connector;
    private Connection connection;

    public List<IlanTipi> findAll() {
        List<IlanTipi> clist = new ArrayList<>();
        //DBconnection db = new DBconnection();
        //Connection c = db.connect();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from ilan_tipi");

            while (rs.next()) {
                
               IlanTipi tmp = new IlanTipi(rs.getInt("ilantip_id"), rs.getString("tip_adi"));
               clist.add(tmp);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return clist;

    }
    
    public IlanTipi find(int id){
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from ilan_tipi where ilantip_id = " + id);

            if (rs.next()) {
                //System.out.println(rs.getString("name"));
                IlanTipi ilantipi = new IlanTipi(rs.getInt("ilantip_id"), rs.getString("tip_adi"));
                return ilantipi;

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
       IlanTipi hataliIlan = new IlanTipi(0,"Hatalı İlan Tipi Kodu");
       return hataliIlan;
    }
    
     public IlanTipi find(String typeName){
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from ilan_tipi where tip_adi = '" + typeName + "'");

            if (rs.next()) {
                //System.out.println(rs.getString("name"));
                IlanTipi ilantipi = new IlanTipi(rs.getInt("ilantip_id"), rs.getString("tip_adi"));
                return ilantipi;

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
       IlanTipi hataliIlan = new IlanTipi(0,"Hatalı İlan Tipi Kodu");
       return hataliIlan;
    }


    public void insert(IlanTipi ilanTipi) {

        try {
            Statement st = this.getConnection().createStatement();

            //st.executeUpdate("insert into kullanici (kullanici_adi,sifre,ad_soyad,admin_mi) values ('" + kullanici.getKullanciAdi() + "', '" + kullanici.getSifre() + "', '" + kullanici.getAdSoyad() + "', 0)" , Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                int key = rs.getInt(1);
                System.out.println("Auto Generated Primary Key " + key);
                
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

    }

    public void delete(IlanTipi ilanTipi) {

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

    public void update(IlanTipi ilanTipi) {
        try {
            Statement st = this.getConnection().createStatement();

            //st.executeUpdate("update kullanici set ad_soyad='" + kullanici.getAdSoyad() + "' where kullanici_id= " + kullanici.getKullaniciId());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

}