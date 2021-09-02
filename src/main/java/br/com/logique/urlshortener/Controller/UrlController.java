package br.com.logique.urlshortener.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import br.com.logique.urlshortener.Connection.ConnectionFactory;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import br.com.logique.urlshortener.Model.UrlModel;
import java.util.List;



public class UrlController {
	
	public static Boolean create(String url) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO tb_url(url, CODE, insert_date) VALUES(?, (SELECT SUBSTR(TO_BASE64((SELECT COUNT(1) AS total FROM tb_url u)),1,7)), SYSDATE())");
            stmt.setString(1, url);
            return stmt.execute();
            
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
	
	public String dateFormat(Timestamp data) {
		String dataFormatFinal = new SimpleDateFormat("dd/MM/yyyy").format(data);
		return dataFormatFinal;
	}
	
	
	public List<UrlModel> findAll() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<UrlModel> listurl = new ArrayList<>();
        

        try {
            stmt = con.prepareStatement("select id, url, code, insert_date, custom FROM tb_url");
            rs = stmt.executeQuery();
            while(rs.next()) {
            	UrlModel urlmodel = new UrlModel();
            	urlmodel.setId(rs.getInt("id")); 
            	urlmodel.setUrl(rs.getString("url"));
            	urlmodel.setCode(rs.getString("code"));
            	urlmodel.setCustom(rs.getString("custom"));
            	urlmodel.setInsert_date(dateFormat(rs.getTimestamp("insert_date")));
            	
            	listurl.add(urlmodel);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
        return listurl;
        
    }
	
	public UrlModel getUrlByCode(String  code) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        UrlModel urlmodel = new UrlModel();
        try {
            stmt = con.prepareStatement("select id, url, code, custom FROM tb_url where code = ?");
            stmt.setString(1, code);
            rs = stmt.executeQuery();
            if(rs.next()) {
            	urlmodel.setId(rs.getInt("id")); 
            	urlmodel.setUrl(rs.getString("url"));
            	urlmodel.setCode(rs.getString("code"));
            	urlmodel.setCustom(rs.getString("custom"));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return urlmodel;
    }
    
    
    public static boolean update(String custom, int id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
                stmt = con.prepareStatement("UPDATE tb_url SET custom=? WHERE id=?");
                stmt.setString(1, custom);
                stmt.setInt(2, id);
                return stmt.executeUpdate()>0 ? true: false;
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                ConnectionFactory.closeConnection(con, stmt);
            }
		return false;
    }
    
    public static void main(String[] args) {
        
        ConnectionFactory.getConnection();
        //System.out.println(update("WG", 1));
        
      //  String urlTest = "https://test.jar-download.com/download-handling.php.testeeeeeeeeeeeee";
       // System.out.println(urlTest);
       // create(urlTest);
       // System.out.println(urlTest);
        //findAll();
        
    }
	
	

}
