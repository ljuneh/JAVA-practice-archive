package springjdbc.jdbctemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Test {
	private static ApplicationContext ctx = null;
	
	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext("classpath:/springjdbc/jdbctemplate/config.xml");
		
		String sql = "insert into userinfo(userid, userpassword, role) values(?,?,?)";
		
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbctemplate");
		
		int cnt = jdbcTemplate.update(sql, "user0", "user0"	, "u");
		
		System.out.println("입력된 갯수: " + cnt);
	}
}
