package dao;

import entity.Ilce;
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

public class IlceDao {

    private DBconnection connector;
    private Connection connection;
    private IlDao ilDao;

    public List<Ilce> findAll() {
        List<Ilce> clist = new ArrayList<>();
        //DBconnection db = new DBconnection();
        //Connection c = db.connect();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from ilce");

            while (rs.next()) {
                //System.out.println(rs.getString("name"));
                //Ilce constructor 3. paramtre olarak il nesnesi beklediği için veritabanından il idye gelen il nesnesini ildaodan aldık
                Ilce ilce = new Ilce(rs.getLong("ilce_id"), rs.getString("ilce_adi"), this.getIlDao().find(rs.getInt("il_id")));
                clist.add(ilce);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return clist;

    }

    int findIdbyName(String ilceName) {
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from ilce where ilce_adi = '" + ilceName + "'");

            if (rs.next()) {
                return rs.getInt("ilce_id");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return 0;
    }

    public List<Ilce> findByIl(String ilName) {
        List<Ilce> clist = new ArrayList<>();
        //DBconnection db = new DBconnection();
        //Connection c = db.connect();
        int plaka = this.getIlDao().findIdbyName(ilName);
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from ilce where il_id=" + plaka);

            while (rs.next()) {
                //System.out.println(rs.getString("name"));
                //Ilce constructor 3. paramtre olarak il nesnesi beklediği için veritabanından il idye gelen il nesnesini ildaodan aldık
                Ilce ilce = new Ilce(rs.getLong("ilce_id"), rs.getString("ilce_adi"), this.getIlDao().find(rs.getInt("il_id")));
                clist.add(ilce);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return clist;

    }

    public Ilce find(Long id) {
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from ilce where ilce_id = " + id);

            if (rs.next()) {
                //System.out.println(rs.getString("name"));
                Ilce ilce = new Ilce(rs.getLong("ilce_id"), rs.getString("ilce_adi"), this.getIlDao().find(rs.getInt("il_id")));
                return ilce;

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        Ilce hataliIlce = new Ilce();
        return hataliIlce;
    }

    public void insert(Ilce ilce) {

        try {
            Statement st = this.getConnection().createStatement();

            // st.executeUpdate("insert into ilce (kullanici_adi,sifre,ad_soyad,admin_mi) values ('" + ilce.getKullanciAdi() + "', '" + ilce.getSifre() + "', '" + ilce.getAdSoyad() + "', 0)" , Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                int key = rs.getInt(1);
                System.out.println("Auto Generated Primary Key " + key);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

    }

    public void delete(Ilce ilce) {

        try {
            Statement st = this.getConnection().createStatement();

            //st.executeUpdate("delete from ilce where kullanici_id=" + ilce.getKullaniciId());
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

    public void update(Ilce ilce) {
        try {
            Statement st = this.getConnection().createStatement();

            // st.executeUpdate("update ilce set ad_soyad='" + ilce.getAdSoyad() + "' where kullanici_id= " + ilce.getKullaniciId());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    public IlDao getIlDao() {
        if (this.ilDao == null) {
            this.ilDao = new IlDao();
        }

        return ilDao;
    }

    public void setIlDao(IlDao ilDao) {
        this.ilDao = ilDao;

    }

}
