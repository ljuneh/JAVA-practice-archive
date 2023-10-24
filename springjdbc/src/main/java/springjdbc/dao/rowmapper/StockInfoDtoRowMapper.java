package springjdbc.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import springjdbc.dto.StockInfoDto;

public class StockInfoDtoRowMapper implements RowMapper<StockInfoDto> {

	@Override
	public StockInfoDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		StockInfoDto stockInfoDto = new StockInfoDto();
		stockInfoDto.setRawMaterialName(rs.getString(1));
		stockInfoDto.setRawMaterialQuantity(rs.getInt(2));
		return stockInfoDto;
	}

}
