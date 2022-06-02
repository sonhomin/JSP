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
	
	String sql = "select UserID, Passworld, NickName, admin from member";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery();
	 
	try(conn; pstmt; rs){
		while(rs.next()) {
			Member m = new Member();
			m.setUserID(rs.getString("UserID"));
			m.setPassworld(rs.getString("Passworld"));
			m.setNickName(rs.getString("NickName"));
			memberList.add(m);
			}
		return memberList;
		}
	}
 
 
  public Member getMember(String UserID) throws SQLException{
	  Connection conn = open();
	  Member m = new Member();
	  String sql = "select UserID, Passworld, NickName, admin from Member where UserID=?";
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
 
  public void addMember(Member m) throws Exception{
	  Connection conn = open();
	  String sql = "insert into Member(UserID, Passworld, NickName, admin) values(?,?,?,0)";
	  PreparedStatement pstmt = conn.prepareStatement(sql);
	  
	  try(conn; pstmt){
		  pstmt.setString(1, m.getUserID());
		  pstmt.setString(2, m.getPassworld());
		  pstmt.setString(3, m.getNickName());
		  pstmt.executeUpdate();
	  }
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
}
