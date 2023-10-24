package springjdbc.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import springjdbc.entity.SalesInfoEntity;

public class SalesInfoEntityRowMapper implements RowMapper<SalesInfoEntity> {

	@Override
	public SalesInfoEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		SalesInfoEntity salesInfoEntity = new SalesInfoEntity();
		salesInfoEntity.setGoodsCode(rs.getString(1));
		salesInfoEntity.setOrderQuantity(rs.getInt(2));
		salesInfoEntity.setSalesDate(rs.getDate(3));
		
		return salesInfoEntity;
	}

}
