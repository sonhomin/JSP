package whants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import whants.Contents;

public class ContentsDAO {
	final String JDBC_DRIVER = "org.h2.Driver";
	final String JDBC_URL = "jdbc:h2:tcp://localhost/~/whants";
	
	public Connection open() {
		Connection conn = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_URL,"sa","1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public List<Contents> getAll() throws Exception{
		Connection conn = open();
		List<Contents> contentList = new ArrayList<>();
	
		String sql = "select ContentID, Title, View, PARSEDATETIME(StartDate,'yyyy-MM-dd') as sdate, PARSEDATETIME(EndDate,'yyyy-MM-dd') as edate, Director, Actor, img from Contents";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
	 
		try(conn; pstmt; rs){
			while(rs.next()) {
				Contents c = new Contents();
				c.setContentID(rs.getInt("ContentID"));
				c.setTitle(rs.getString("Title"));
				c.setView(rs.getInt("View"));
				c.setStartDate(rs.getString("sdate"));
				c.setEndDate(rs.getString("edate"));
				c.setDirector(rs.getString("Director"));
				c.setActor(rs.getString("Actor"));
				c.setImg(rs.getString("img"));
				contentList.add(c);
			}
			return contentList;
		}
	} 	
 
  	public Contents getContents(int ContentID) throws SQLException{
  		Connection conn = open();
  		Contents c = new Contents();
  		String sql = "select ContentID, Title, View, PARSEDATETIME(StartDate,'yyyy-MM-dd hh:mm:ss') as sdate, PARSEDATETIME(EndDate,'yyyy-MM-dd hh:mm:ss') as edate, Director, Actor, img from Contents where ContentID=?";
  		PreparedStatement pstmt = conn.prepareStatement(sql);
  		pstmt.setInt(1,  ContentID);
  		ResultSet rs = pstmt.executeQuery();
  		rs.next();
	  
  		try(conn; pstmt; rs){
  			c.setContentID(rs.getInt("ContentID"));
		  	c.setTitle(rs.getString("Title"));
			c.setView(rs.getInt("View"));
			c.setStartDate(rs.getString("sdate"));
			c.setEndDate(rs.getString("edate"));
			c.setDirector(rs.getString("Director"));
			c.setActor(rs.getString("Actor"));
			c.setImg(rs.getString("img"));
		pstmt.executeQuery();
		return c;
  		}
  	}
 
  	public void addContents(Contents c) throws Exception{
  		Connection conn = open();
  		String sql = "insert into Contents (Title, View, StartDate, EndDate, Director, Actor, img) values(?,?,?,?,?,?,?)";
  		PreparedStatement pstmt = conn.prepareStatement(sql);
	  
  		try(conn; pstmt){
  			pstmt.setString(1, c.getTitle());
  			pstmt.setInt(2, c.getView());
  			pstmt.setString(3, c.getStartDate());
  			pstmt.setString(4, c.getEndDate());
  			pstmt.setString(5, c.getDirector());
  			pstmt.setString(6, c.getActor());
  			pstmt.setString(7, c.getImg());
  			pstmt.executeUpdate();
  		}
  	}
  	
  	public List<Contents> getBasket(String ID) throws Exception {
  		Connection conn = open();
  		List<Contents> contentList = new ArrayList<>();
  		
  		String sql = "SELECT  Title, img FROM Contents WHERE ContentID IN (SELECT ContentID FROM CART WHERE UserID = ? )";
  		 
  		PreparedStatement pstmt = conn.prepareStatement(sql);
  		pstmt.setString(1, ID);
  		ResultSet rs = pstmt.executeQuery();
	  
  		try(conn; pstmt; rs){
  			while(rs.next()) {
  				Contents c = new Contents();
  				c.setTitle(rs.getString("title"));
  				c.setImg(rs.getString("img"));
  				contentList.add(c);
  			}
  			return contentList;
  		}
  	}
  	
  	public void addPrice(Price p) throws Exception{
  		Connection conn = open();
  		String sql = "insert into PRICE (CONTENTID, PLATFORM, PRICE) values(?,?,?)";
  		PreparedStatement pstmt = conn.prepareStatement(sql);
	  
  		try(conn; pstmt){
  			pstmt.setInt(1, p.getContentID());
  			pstmt.setString(2, p.getPlatform());
  			pstmt.setString(3, p.getPrice());
  			pstmt.executeUpdate();
  		}
  	}
  	public void addCart(String CID, String UID) throws Exception{
  		Connection conn = open();
  		String sql = "insert into CART (USERID, CONTENTID) values(?,?)";
  		PreparedStatement pstmt = conn.prepareStatement(sql);
	  
  		try(conn; pstmt){
  			pstmt.setString(1, UID);
  			pstmt.setString(2, CID);
  			pstmt.executeUpdate();
  		}
  	}
  	
  	public void delContents(String ContentID) throws SQLException{
  		Connection conn = open();
  		String sql = "delete from Contents where ContentID=?";
  		PreparedStatement pstmt = conn.prepareStatement(sql);
	  
  		try(conn;pstmt){
  			pstmt.setString(1, ContentID);
  			if(pstmt.executeUpdate() == 0) {
  				throw new SQLException("DB에러");
  			}
  		}
  	}
}
