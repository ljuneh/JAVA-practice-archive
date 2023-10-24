package springjdbc.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import springjdbc.dao.SalesInfoDao;
import springjdbc.dao.rowmapper.SalesInfoEntityRowMapper;
import springjdbc.entity.OrderInfoEntity;
import springjdbc.entity.SalesInfoEntity;

@Component("salesinfodao")
public class SalesInfoDaoImpl implements SalesInfoDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public SalesInfoEntity retSearchedSalesInfoByCode(String code) {
		String sql = "select goodscode, orderquantity, salesdate\r\n"
				+ "from salesinfo\r\n"
				+ "where goodscode = ?";
		SalesInfoEntityRowMapper mapper = new SalesInfoEntityRowMapper();
		SalesInfoEntity salesInfoEntity = null;
		try {
			salesInfoEntity = jdbcTemplate.queryForObject(sql, mapper, code);
		} catch (EmptyResultDataAccessException e) {
			// TODO: handle exception
		}
		
		return salesInfoEntity;
	}

	@Override
	public int insertSalesInfo(OrderInfoEntity orderInfo) {
		String sql = "INSERT INTO salesinfo(goodscode, orderquantity) VALUES(?, ?)";
		int cnt = jdbcTemplate.update(sql, orderInfo.getGoodsCode(), orderInfo.getOrderQuantity());
		
		return cnt;
	}

	@Override
	public int updateSalesInfoByCode(String code, int quantity) {
		String sql = "update salesinfo\r\n"
				+ "set orderquantity = ?, salesdate = sysdate\r\n"
				+ "where goodscode = ?";
		int cnt = jdbcTemplate.update(sql, quantity, code);
		
		return cnt;
	}

}
