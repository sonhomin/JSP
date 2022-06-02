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
	//DB 연결 가져오는 메서드
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
	
	String sql = "select ContentID, Title, View, PARSEDATETIME(StartDate,'yyyy-MM-dd hh:mm:ss') as sdate, PARSEDATETIME(EndDate,'yyyy-MM-dd hh:mm:ss') as edate, Director, Actor, img from Contents";
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
 
 	
 //------------------------------------------------------------------------------------------------------------------------------------------------------
  public Contents getContents(String UserID) throws SQLException{
	  Connection conn = open();
	  Contents m = new Contents();
	  String sql = "select UserID, Passworld, NickName, admin from Contents where UserID=?";
	  PreparedStatement pstmt = conn.prepareStatement(sql);
	  pstmt.setString(1,  UserID);
	  ResultSet rs = pstmt.executeQuery();
	  rs.next();
	  
	  try(conn; pstmt; rs){
		m.setUserID(rs.getString("UserID"));
		m.setPassworld(rs.getString("Passworld"));
		m.setNickName(rs.getString("NickName"));
		pstmt.executeQuery();
		return m;
	  }
  }
 
  public void addContents(Contents m) throws Exception{
	  Connection conn = open();
	  String sql = "insert into Contents(UserID, Passworld, NickName, admin) values(?,?,?,0)";
	  PreparedStatement pstmt = conn.prepareStatement(sql);
	  
	  try(conn; pstmt){
		  pstmt.setString(1, m.getUserID());
		  pstmt.setString(2, m.getPassworld());
		  pstmt.setString(3, m.getNickName());
		  pstmt.executeUpdate();
	  }
  }
  
  public void delContents(String Userid) throws SQLException{
	  Connection conn = open();
	  String sql = "delete from Contents where Userid=?";
	  PreparedStatement pstmt = conn.prepareStatement(sql);
	  
	  try(conn;pstmt){
		  pstmt.setString(1, Userid);
		  if(pstmt.executeUpdate() == 0) {
			  throw new SQLException("DB에러");
		  }
	  }
  }
}
