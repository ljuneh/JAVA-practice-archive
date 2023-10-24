package springjdbc.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import springjdbc.entity.OrderInfoEntity;

public class OrderInfoEntityRowMapper implements RowMapper<OrderInfoEntity> {

	@Override
	public OrderInfoEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderInfoEntity orderInfoEntity = new OrderInfoEntity();
		
		
		orderInfoEntity.setSeq(rs.getInt(1));
		orderInfoEntity.setGoodsCode(rs.getString(2));
		orderInfoEntity.setOrderQuantity(rs.getInt(3));
		orderInfoEntity.setOrderConfirmed(rs.getString(4));
		orderInfoEntity.setOrderDate(rs.getDate(5));
		orderInfoEntity.setId(rs.getString(6));
		return orderInfoEntity;
	}

}
