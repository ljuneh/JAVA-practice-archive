package springjdbc.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import springjdbc.dao.OrderToBasketDao;
import springjdbc.dao.rowmapper.RetIntRowMapper;
import springjdbc.dto.OrderToBasketDto;

@Component("ordertobasketdao")
public class OrderToBasketDaoImpl implements OrderToBasketDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int currentSeq() {
		String sql = "select max(seq)\r\n"
				+ "from orderinfo";
		int quantity = 0;
		
		quantity = jdbcTemplate.queryForObject(sql, new RetIntRowMapper());
		return quantity;
	}

	@Override
	public int insertOrderInfo(OrderToBasketDto orderToBasketDto, String id) {
		String sql = "INSERT INTO orderinfo(seq, goodscode, orderquantity, id) VALUES(?, ?, ?, ?)";
		int currentSeq = currentSeq();
		
		int cnt = jdbcTemplate.update(sql, ++currentSeq, orderToBasketDto.getCode(), orderToBasketDto.getQuantity(), id);
		
		return cnt;
	}

	@Override
	public int updateConfirmedByCode(String code, String confirmed, String id) {
		String sql = "update orderinfo\r\n" + 
				"set orderconfirmed = ?\r\n" + 
				"where goodscode = ? and id = ?";
		
		int cnt = jdbcTemplate.update(sql, confirmed, code, id);
		
		return cnt;
	}

	@Override
	public int updateConfirmedBySeq(int seq, String confirmed) {
		String sql = "update orderinfo\r\n" + 
				"set orderconfirmed = ?\r\n" + 
				"where seq = ?";
		int cnt = jdbcTemplate.update(sql, confirmed, seq);
		
		return cnt;
	}

}
