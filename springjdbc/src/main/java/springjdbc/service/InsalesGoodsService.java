package springjdbc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springjdbc.dao.InsalesGoodsDao;
import springjdbc.dto.InsalesGoodsDto;
import springjdbc.entity.InsalesGoodsEntity;

@Component
public class InsalesGoodsService {
	@Autowired
	@Qualifier("insalesgoodsdao")
	private InsalesGoodsDao insalesGoodsDao;

	public void setInsalesGoodsDao(InsalesGoodsDao insalesGoodsDao) {
		this.insalesGoodsDao = insalesGoodsDao;
	}



	public List<InsalesGoodsDto> retGoods() {
		List<InsalesGoodsEntity> insalesGoodsEntityList = insalesGoodsDao.retInsalesGoodsEntity();
		
		List<InsalesGoodsDto> insalesGoodsDtoList = new ArrayList<InsalesGoodsDto>();
		
		for(InsalesGoodsEntity insalesGoodsEntity : insalesGoodsEntityList) {
			int quantity = insalesGoodsDao.retCurrentRawQuantity(insalesGoodsEntity.getGoodsCode());
			
			InsalesGoodsDto insalesGoodsDto = new InsalesGoodsDto();
			
			insalesGoodsDto.setGoodsCode(insalesGoodsEntity.getGoodsCode());
			insalesGoodsDto.setGoodsName(insalesGoodsEntity.getGoodsName());
			insalesGoodsDto.setPrice(insalesGoodsEntity.getPrice());
			insalesGoodsDto.setRawmaterialquantity(insalesGoodsEntity.getRawMaterialQuantity());
			insalesGoodsDto.setCurrentrawquantity(quantity);
			
			insalesGoodsDtoList.add(insalesGoodsDto);
		}
		
		return insalesGoodsDtoList;
	}
}
