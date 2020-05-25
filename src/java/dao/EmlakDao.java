package dao;

import entity.Arsa;
import entity.Emlak;
import entity.Isyeri;
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

public class EmlakDao {

    private DBconnection connector;
    private Connection connection;

    public List<Emlak> findAll() {
        List<Emlak> clist = new ArrayList<>();
        //DBconnection db = new DBconnection();
        //Connection c = db.connect();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from emlak");

            while (rs.next()) {
                //System.out.println(rs.getString("name"));
               // Emlak tmp = new Emlak(rs.getInt("kullanici_id"), rs.getString("kullanici_adi"), rs.getString("sifre"), rs.getString("ad_soyad"), rs.getInt("admin_mi"));
               // clist.add(tmp);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return clist;

    }
    
    public Emlak find(Long id){
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from emlak where emlak_id = " + id);

            if (rs.next()) {
                //System.out.println(rs.getString("name"));
               Emlak emlak = new Emlak(rs.getLong("emlak_id"),rs.getInt("arsa_id"),rs.getInt("isyeri_id"),rs.getInt("konut_id"),rs.getInt("proje_il_id"));
               return emlak;
                    
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
       Emlak hataliEmlak = new Emlak();
       return hataliEmlak;
    }

    public int insert(Emlak emlak) {
        int eklenenArsaId = 0;
        int eklenenIsyeriId = 0;
        int eklenenKonutId = 0;
        int emlakId = 0;
        try {
            Statement st = this.getConnection().createStatement();
            
            ArsaDao arsaDao = new ArsaDao();
            KonutDao konutDao = new KonutDao();
            IsyeriDao isyeriDao = new IsyeriDao();
            
            switch(emlak.getEmlakTipi()){
                case "Arsa":
                    //new Arsa() ve diğerleri boş olmayacak arayüzde seçilip doldurulan bilgiler yapılandırıcıya gönderilecek
                   eklenenArsaId = arsaDao.insert(new Arsa(emlak.getAlan(),emlak.getAdres()));
                   st.executeUpdate("insert into emlak (konut_id,proje_il_id,isyeri_id,arsa_id) values ( null, null, null, " + Integer.toString(eklenenArsaId)+ ")", Statement.RETURN_GENERATED_KEYS);
                   break;
                case "Konut":
                   eklenenKonutId = konutDao.insert(new Konut(emlak.getAlan(),emlak.getAdres(),emlak.getOdaSayisi()));
                   st.executeUpdate("insert into emlak (arsa_id,proje_il_id,isyeri_id,konut_id) values ( null, null, null, " + Integer.toString(eklenenKonutId)+ ")", Statement.RETURN_GENERATED_KEYS);
                   break;
                case "Isyeri":
                   eklenenIsyeriId =  isyeriDao.insert(new Isyeri(emlak.getAlan(),emlak.getAdres()));
                   st.executeUpdate("insert into emlak (konut_id,proje_il_id,arsa_id,isyeri_id) values ( null, null, null, " + Integer.toString(eklenenIsyeriId)+ ")", Statement.RETURN_GENERATED_KEYS);
                   break;
            }
            
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                emlakId = rs.getInt(1);
                
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        
        return emlakId;

    }

    public void delete(Emlak emlak) {

        try {
            Statement st = this.getConnection().createStatement();

           // st.executeUpdate("delete from kullanici where kullanici_id=" + kullanici.getKullaniciId());

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

    public void update(Emlak emlak) {
        try {
            Statement st = this.getConnection().createStatement();

           // st.executeUpdate("update kullanici set ad_soyad='" + kullanici.getAdSoyad() + "' where kullanici_id= " + kullanici.getKullaniciId());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

}
