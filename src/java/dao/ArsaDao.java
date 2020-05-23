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
import entity.Arsa;
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

public class ArsaDao {

    private DBconnection connector;
    private Connection connection;

    public List<Arsa> findAll() {
        List<Arsa> clist = new ArrayList<>();
        //DBconnection db = new DBconnection();
        //Connection c = db.connect();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from arsa");

            while (rs.next()) {
                //System.out.println(rs.getString("name"));
                Arsa tmp = new Arsa(rs.getInt("arsa_id"), rs.getInt("alan"), rs.getString("adres"));
                clist.add(tmp);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return clist;

    }

    public int insert(Arsa arsa) {
        int key = 0;
        try {
            Statement st = this.getConnection().createStatement();

            st.executeUpdate("insert into arsa (alan,adres) values ('" + arsa.getAlan()+ "', '" + arsa.getAdres()+ "')" , Statement.RETURN_GENERATED_KEYS);

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

    public void delete(Arsa arsa) {

        try {
            Statement st = this.getConnection().createStatement();

            st.executeUpdate("delete from arsa where arsa_id=" + arsa.getArsaId());

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

    public void update(Arsa arsa) {
        try {
            Statement st = this.getConnection().createStatement();

            st.executeUpdate("update arsa set alan='" + arsa.getAlan()+ "' where arsa_id= " + arsa.getArsaId());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

}
