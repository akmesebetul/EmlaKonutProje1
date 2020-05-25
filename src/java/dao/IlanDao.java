package dao;

import entity.Emlak;
import entity.Ilan;
import entity.IlanTipi;
import entity.Ilce;
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

public class IlanDao {

    private DBconnection connector;
    private Connection connection;

    IlanTipiDao ilanTipiDao;
    KullaniciDao kullaniciDao;
    IlceDao ilceDao;
    EmlakDao emlakDao;

    IlanTipi ilantipi;
    Kullanici kullanici;
    Ilce ilce;
    Emlak emlak;

    public List<Ilan> findAll() {
        List<Ilan> clist = new ArrayList<>();
        //DBconnection db = new DBconnection();
        //Connection c = db.connect();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from ilan");

            while (rs.next()) {
                Ilan ilan = new Ilan(rs.getInt("ilan_id"), rs.getString("ilan_baslik"), rs.getString("ilan_aciklama"),
                        rs.getInt("fiyat"), this.getIlantipi(rs.getInt("ilan_tip_id")), this.getKullanici(rs.getInt("kullanici_id")),
                        this.getIlce(rs.getLong("ilce_id")), this.getEmlak(rs.getLong("emlak_id")), rs.getString("iletisim_no"));
                clist.add(ilan);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return clist;

    }

    public Ilan find(int id) {
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from ilan where ilan_id = " + id);

            if (rs.next()) {
                Ilan ilan = new Ilan(rs.getInt("ilan_id"), rs.getString("ilan_baslik"), rs.getString("ilan_aciklama"),
                        rs.getInt("fiyat"), this.getIlantipi(rs.getInt("ilan_tip_id")), this.getKullanici(rs.getInt("kullanici_id")),
                        this.getIlce(rs.getLong("ilce_id")), this.getEmlak(rs.getLong("emlak_id")), rs.getString("iletisim_no"));
                return ilan;

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        Ilan hataliIlan = new Ilan();
        return hataliIlan;
    }

    public void insert(Ilan ilan) {

        try {
            int ilceId = this.getIlceDao().findIdbyName(ilan.getIlce().getIlce_adi());
            int ilanTipId = ilan.getIlan_tipi().getTip_id();
            int emlakId = this.getEmlakDao().insert(ilan.getEmlak());
            String ilanBaslik = ilan.getIlan_baslik();
            String ilanAciklama = ilan.getIlan_aciklama();
            int fiyat = ilan.getFiyat();
            int kullaniciId = ilan.getKullanici().getKullaniciId();
            String iletisimNo = ilan.getIletisim_no();

            if (emlakId == 0 || ilanTipId == 0) {
                return;
            }

            Statement st = this.getConnection().createStatement();
            String query = "insert into ilan (ilan_baslik, ilan_aciklama, fiyat, ilan_tip_id, kullanici_id, ilce_id, emlak_id, iletisim_no) values ('" + ilanBaslik + "'" + ", " + "'" + ilanAciklama + "'" + ", " + fiyat + ", " + ilanTipId + ", " + kullaniciId + ", " + ilceId + ", " + emlakId + ", '" + iletisimNo + "')";
            st.executeUpdate(query);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

    }

    public void delete(Ilan ilan) {

        try {
            Statement st = this.getConnection().createStatement();

            st.executeUpdate("delete from ilan where ilan_id=" + ilan.getIlan_id());

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

    public void update(Ilan ilan) {
        try {
            Statement st = this.getConnection().createStatement();

            //st.executeUpdate("update kullanici set ad_soyad='" + kullanici.getAdSoyad() + "' where kullanici_id= " + kullanici.getKullaniciId());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    public IlanTipiDao getIlanTipiDao() {
        if (this.ilanTipiDao == null) {
            this.ilanTipiDao = new IlanTipiDao();
        }
        return ilanTipiDao;
    }

    public void setIlanTipiDao(IlanTipiDao ilanTipiDao) {
        this.ilanTipiDao = ilanTipiDao;
    }

    public KullaniciDao getKullaniciDao() {
        if (this.kullaniciDao == null) {
            this.kullaniciDao = new KullaniciDao();
        }
        return kullaniciDao;
    }

    public void setKullaniciDao(KullaniciDao kullaniciDao) {
        this.kullaniciDao = kullaniciDao;
    }

    public IlceDao getIlceDao() {
        if (this.ilceDao == null) {
            this.ilceDao = new IlceDao();
        }
        return ilceDao;
    }

    public void setIlceDao(IlceDao ilceDao) {
        this.ilceDao = ilceDao;
    }

    public EmlakDao getEmlakDao() {
        if (this.emlakDao == null) {
            this.emlakDao = new EmlakDao();
        }
        return emlakDao;
    }

    public void setEmlakDao(EmlakDao emlakDao) {
        this.emlakDao = emlakDao;
    }

    public IlanTipi getIlantipi(int id) {
        return this.getIlanTipiDao().find(id);
    }

    public void setIlantipi(IlanTipi ilantipi) {
        this.ilantipi = ilantipi;
    }

    public Kullanici getKullanici(int id) {
        return this.getKullaniciDao().find(id);
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    public Ilce getIlce(Long id) {
        return this.getIlceDao().find(id);
    }

    public void setIlce(Ilce ilce) {
        this.ilce = ilce;
    }

    public Emlak getEmlak(Long id) {
        return this.getEmlakDao().find(id);
    }

    public void setEmlak(Emlak emlak) {
        this.emlak = emlak;
    }

}
