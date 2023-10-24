package springjdbc.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import springjdbc.dto.UserInfoDto;

public class UserInfoRowMapper implements RowMapper<UserInfoDto>{

	@Override
	public UserInfoDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		UserInfoDto userInfoDto = new UserInfoDto();
		userInfoDto
			.setUserid(rs.getString(1))
			.setUserpassword(rs.getString(2))
			.setRole(rs.getString(3));
		
		return userInfoDto;
	}

}
