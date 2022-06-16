package whants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import whants.Member;

public class MemberDAO {
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

 public List<Member> getAll() throws Exception{
	Connection conn = open();
	List<Member> memberList = new ArrayList<>();
	
	String sql = "select UserID, Password, NickName, admin from member";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery();
	 
	try(conn; pstmt; rs){
		while(rs.next()) {
			Member m = new Member();
			m.setUserID(rs.getString("UserID"));
			m.setPassword(rs.getString("Password"));
			m.setNickName(rs.getString("NickName"));
			memberList.add(m);
			}
		return memberList;
		}
	}
 
 
  public Member getMember(String UserID) throws SQLException{
	  Connection conn = open();
	  Member m = new Member();
	  String sql = "select UserID, Password, NickName, admin from Member where UserID=?";
	  PreparedStatement pstmt = conn.prepareStatement(sql);
	  pstmt.setString(1,  UserID);
	  ResultSet rs = pstmt.executeQuery();
	  rs.next();
	  
	  try(conn; pstmt; rs){
		m.setUserID(rs.getString("UserID"));
		m.setPassword(rs.getString("Password"));
		m.setNickName(rs.getString("NickName"));
		pstmt.executeQuery();
		return m;
	  }
  }
 
  public int addMember(Member m) throws Exception{
	  if(!ID_Check(m.getUserID())) return 0;
	  Connection conn = open();
	  String sql = "insert into Member(UserID, Password, NickName, admin) values(?,?,?,1)";
	  PreparedStatement pstmt = conn.prepareStatement(sql);
	  
	  try(conn; pstmt){
		  pstmt.setString(1, m.getUserID());
		  pstmt.setString(2, m.getPassword());
		  pstmt.setString(3, m.getNickName());
		  
		  return pstmt.executeUpdate();
	  } catch (Exception e) {
			e.printStackTrace();
			return -1;
	  }
  }
  
  public boolean ID_Check(String userID) {
	  Connection conn = open();
		try {
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Member WHERE UserID = ?");
			pstmt.setString(1, userID);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
  
  public void delMember(String Userid) throws SQLException{
	  Connection conn = open();
	  String sql = "delete from Member where Userid=?";
	  PreparedStatement pstmt = conn.prepareStatement(sql);
	  
	  try(conn;pstmt){
		  pstmt.setString(1, Userid);
		  if(pstmt.executeUpdate() == 0) {
			  throw new SQLException("DB에러");
		  }
	  }
  }
  
  public int login(String userID, String userPassword) {
	  Connection conn = open();	  
	  try(conn;){
			PreparedStatement pstmt = conn.prepareStatement("SELECT Password, Admin FROM Member WHERE userID = ?");
			pstmt.setString(1, userID);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getString(1).equals(userPassword) ? rs.getInt("Admin") : 0;
			} else {
				return -2;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
}
