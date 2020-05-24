package dao;

import entity.Isyeri;
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

public class IsyeriDao {
    
    private DBconnection connector;
    private Connection connection;

    public List<Isyeri> findAll() {
        List<Isyeri> clist = new ArrayList<>();
        //DBconnection db = new DBconnection();
        //Connection c = db.connect();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from isyeri");

            while (rs.next()) {
                //System.out.println(rs.getString("name"));
                Isyeri tmp = new Isyeri(rs.getInt("isyeri_id"), rs.getString("adres"), rs.getInt("alan"));
                clist.add(tmp);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return clist;

    }

    public int insert(Isyeri isyeri) {
        int key = 0;
        try {
            Statement st = this.getConnection().createStatement();

            st.executeUpdate("insert into isyeri (adres,alan) values ('" + isyeri.getAdres()+ "', '" + isyeri.getAlan() + "',)" , Statement.RETURN_GENERATED_KEYS);

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

    public void delete(Isyeri isyeri) {

        try {
            Statement st = this.getConnection().createStatement();

            st.executeUpdate("delete from isyeri where isyeri_id=" + isyeri.getIsyeri_id());

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

    public void update(Isyeri isyeri) {
        try {
            Statement st = this.getConnection().createStatement();

           // st.executeUpdate("update isyeri set ad_soyad='" + isyeri.getAdSoyad() + "' where isyeri_id= " + isyeri.getIsyeri_Id());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

}
