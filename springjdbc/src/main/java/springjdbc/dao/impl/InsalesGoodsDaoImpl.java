package springjdbc.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import springjdbc.dao.InsalesGoodsDao;
import springjdbc.dao.rowmapper.InsalesGoodsEntityRowMapper;
import springjdbc.dao.rowmapper.RetIntRowMapper;
import springjdbc.entity.InsalesGoodsEntity;

@Component("insalesgoodsdao")
public class InsalesGoodsDaoImpl implements InsalesGoodsDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<InsalesGoodsEntity> retInsalesGoodsEntity() {
		String sql_insalesgoods = "select seq, goodscode, goodsname, rawmaterialcode, rawmaterialquantity, price\r\n" + 
				"from insalesgoods";
		
		InsalesGoodsEntityRowMapper rowMapper = new InsalesGoodsEntityRowMapper();
		List<InsalesGoodsEntity> insalesGoodsEntityList = jdbcTemplate.query(sql_insalesgoods, rowMapper);
		return insalesGoodsEntityList;
	}

	@Override
	public int retCurrentRawQuantity(String code) {
		String sql = "select s.rawmaterialquantity\r\n" + 
				"from stockinfo s, insalesgoods i\r\n" + 
				"where s.rawmaterialcode = i.rawmaterialcode\r\n" + 
				"and i.goodscode = ?";
		int quantity = 0;
		
		quantity = jdbcTemplate.queryForObject(sql, new RetIntRowMapper(), code);
		
		
		return quantity;
	}

	@Override
	public int retNeededRawQuantity(String code) {
		String sql = "select rawmaterialquantity\r\n"
				+ "from ordergoods\r\n"
				+ "where goodscode = ?";
		int quantity = 0;
		
		quantity = jdbcTemplate.queryForObject(sql, new RetIntRowMapper(), code);
		return quantity;
	}

}
