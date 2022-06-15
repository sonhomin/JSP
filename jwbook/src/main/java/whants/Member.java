package whants;

public class Member {
	private String UserID;
	private String Password;
	private String NickName;
	private Boolean Admin;
	
	public Member(String userID, String password, String nickName) {
		this.UserID = userID;
		this.Password = password;
		this.NickName = nickName;
	}
	
	public Member() {
		
	}
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String Password) {
		Password = Password;
	}
	public String getNickName() {
		return NickName;
	}
	public void setNickName(String nickName) {
		NickName = nickName;
	}
	public Boolean getAdmin() {
		return Admin;
	}
	public void setAdmin(Boolean admin) {
		Admin = admin;
	}
}
