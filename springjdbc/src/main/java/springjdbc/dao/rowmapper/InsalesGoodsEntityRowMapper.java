package springjdbc.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import springjdbc.entity.InsalesGoodsEntity;

public class InsalesGoodsEntityRowMapper implements RowMapper<InsalesGoodsEntity> {

	@Override
	public InsalesGoodsEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		InsalesGoodsEntity insalesGoodsEntity = new InsalesGoodsEntity();
		insalesGoodsEntity.setSeq(rs.getInt(1));
		insalesGoodsEntity.setGoodsCode(rs.getString(2));
		insalesGoodsEntity.setGoodsName(rs.getString(3));
		insalesGoodsEntity.setRawMaterialCode(rs.getString(4));
		insalesGoodsEntity.setRawMaterialQuantity(rs.getInt(5));
		insalesGoodsEntity.setPrice(rs.getInt(6));
		return insalesGoodsEntity;
	}

}
