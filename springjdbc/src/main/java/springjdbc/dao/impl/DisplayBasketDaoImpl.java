package springjdbc.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import springjdbc.dao.DisplayBasketDao;
import springjdbc.dao.rowmapper.OrderInfoEntityRowMapper;
import springjdbc.dao.rowmapper.RetIntRowMapper;
import springjdbc.dao.rowmapper.RetStringRowMapper;
import springjdbc.entity.OrderInfoEntity;

@Component("displaybasketdao")
public class DisplayBasketDaoImpl implements DisplayBasketDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<OrderInfoEntity> retOrderInfoEntity(String id, String confirmed) {
		String sql = "select seq, goodscode, orderquantity, orderconfirmed, orderdate, id\r\n" + 
				"from orderinfo\r\n" + 
				"where id = ?\r\n" + 
				"and orderconfirmed = ?\r\n" + 
				"ORDER BY seq asc";
		
		OrderInfoEntityRowMapper mapper = new OrderInfoEntityRowMapper();
		List<OrderInfoEntity> orderInfoEntityList = jdbcTemplate.query(sql, mapper, id, confirmed);
		
		return orderInfoEntityList;
	}

	@Override
	public String retGoodsNameByCode(String code) {
		String name = "";
		String sql = "select goodsname\r\n" + 
				"from ordergoods\r\n" + 
				"where goodscode = ?";
		
		name = jdbcTemplate.queryForObject(sql, new RetStringRowMapper(), code);
		
		return name;
	}

	@Override
	public int retPriceByCode(String code) {
		int price = 0;
		String sql = "select price\r\n" + 
				"from ordergoods\r\n" + 
				"where goodscode = ?";
		
		price = jdbcTemplate.queryForObject(sql, new RetIntRowMapper(), code);
		
		return price;
	}

}
