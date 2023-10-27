package springmvc_ctrltoui.dtos;

public class UserInfoDto {
	String userid;
	String userpassword;
	String role;

	public UserInfoDto() {
	}

	public UserInfoDto(String userid, String userpassword, String role) {
		this.userid = userid;
		this.userpassword = userpassword;
		this.role = role;
	}

	public String getUserid() {
		return userid;
	}

	public UserInfoDto setUserid(String userid) {
		this.userid = userid;
		return this;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public UserInfoDto setUserpassword(String userpassword) {
		this.userpassword = userpassword;
		return this;
	}

	public String getRole() {
		return role;
	}

	public UserInfoDto setRole(String role) {
		this.role = role;
		return this;
	}
		
	@Override
	public String toString() {
		return getUserid() 
				+ ":" + getUserpassword() 
				+ ":" + getRole();
	}
}