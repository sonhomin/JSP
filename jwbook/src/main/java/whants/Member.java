package whants;

public class Member {
	private String UserID;
	private String Passworld;
	private String NickName;
	private Boolean Admin;
	
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getPassworld() {
		return Passworld;
	}
	public void setPassworld(String passworld) {
		Passworld = passworld;
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
