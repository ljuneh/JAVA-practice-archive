package springjdbc.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import springjdbc.dao.StockInfoDao;
import springjdbc.dao.rowmapper.RetStringRowMapper;
import springjdbc.dao.rowmapper.StockInfoDtoRowMapper;
import springjdbc.dto.StockInfoDto;

@Component("stockinfodao")
public class StockInfoDaoImpl implements StockInfoDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public String retRawCodeByCode(String code) {
		String sql = "select rawmaterialcode\r\n"
				+ "from ordergoods\r\n"
				+ "where goodscode = ?";
		String rawCode = "";
		
		rawCode = jdbcTemplate.queryForObject(sql, new RetStringRowMapper(), code);
		
		return rawCode;
	}

	@Override
	public int updateStockInfoByGoodsCode(String code, int quantity) {
		String sql = "update stockinfo set rawmaterialquantity = ?\r\n"
				+ "where rawmaterialcode = ?";
		String rawCode = retRawCodeByCode(code);
		int cnt = jdbcTemplate.update(sql, quantity, rawCode);
		
		return cnt;
	}

	@Override
	public List<StockInfoDto> retStockInfoDto() {
		String sql = "select r.rawmaterialname, s.rawmaterialquantity\r\n" + 
				"from rawmaterial r, stockinfo s\r\n" + 
				"where r.rawmaterialcode = s.rawmaterialcode";
		StockInfoDtoRowMapper mapper = new StockInfoDtoRowMapper();
		
		List<StockInfoDto> stockInfoDtoList = jdbcTemplate.query(sql, mapper);
		
		return stockInfoDtoList;
	}

	@Override
	public int initStock() {
		String sql = "update stockinfo\r\n" + 
				"set rawmaterialquantity = 50";
		
		int cnt = jdbcTemplate.update(sql);
		
		return cnt;
	}

}
