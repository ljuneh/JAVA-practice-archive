package springjdbc.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import springjdbc.dao.UserInfoDao;
import springjdbc.dao.rowmapper.UserInfoRowMapper;
import springjdbc.dto.UserInfoDto;

@Component("userinfodao")
public class UserInfoDaoImpl implements UserInfoDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int create(UserInfoDto userInfoDto) {
		String sql = "insert into userinfo(userid, userpassword, role) values(?,?,?)";
		
		int cnt = jdbcTemplate.update(sql, userInfoDto.getUserid(), userInfoDto.getUserpassword(), userInfoDto.getRole());
		
		return cnt;
	}

	@Override
	public int updateRole(UserInfoDto userInfoDto, String role) {
		String sql = "update userinfo set role=? where userid=?";
		
		int cnt = jdbcTemplate.update(sql, role, userInfoDto.getUserid());
		
		return cnt;
	}

	@Override
	public int delete(UserInfoDto userInfoDto) {
		String sql = "delete from userinfo where userid=? and userpassword=?";
		
		int cnt = jdbcTemplate.update(sql, userInfoDto.getUserid(), userInfoDto.getUserpassword());
		
		return cnt;
	}

	@Override
	public UserInfoDto read(String userid) {
		String sql = "select userid, userpassword, role from userinfo where userid=?";
		
		UserInfoRowMapper userInfoRowMapper = new UserInfoRowMapper();
		
		UserInfoDto userInfoDto = null;
		
		try {
			userInfoDto = jdbcTemplate.queryForObject(sql, userInfoRowMapper, userid);
		} catch (EmptyResultDataAccessException e) {
			// TODO: handle exception
		}
		
		
		return userInfoDto;
	}

	@Override
	public List<UserInfoDto> read() {
		String sql = "select userid, userpassword, role from userinfo";
		
		UserInfoRowMapper userInfoRowMapper = new UserInfoRowMapper();
		
		List<UserInfoDto> userInfoDtoList = jdbcTemplate.query(sql, userInfoRowMapper);
		
		
		return userInfoDtoList;
	}

	@Override
	public List<UserInfoDto> readByRole(String role) {
		String sql = "select userid, userpassword, role from userinfo where role=?";
		
		UserInfoRowMapper userInfoRowMapper = new UserInfoRowMapper();
		
		List<UserInfoDto> userInfoDtoList = jdbcTemplate.query(sql, userInfoRowMapper, role);
		
		return userInfoDtoList;
	}

}
