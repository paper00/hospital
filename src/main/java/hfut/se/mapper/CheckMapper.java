package hfut.se.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import hfut.se.bean.CheckInfo;
import hfut.se.bean.Prescription;

public interface CheckMapper {
	
	//查询病人处方信息
	public List<Prescription> findPreByCardId(String cardId);
	
	//得到病人所有药品的单价
	public List<Double> findPriceByCardId(String cardId);
	
	//修改处方付款状态
	public void updatePreStatus(@Param("preid")Integer preid);
	
	//收费
	public void saveCheckInfo(@Param("cardId")String cardId, @Param("username")String username, @Param("price")Double price);
	
	//查询病人收费情况
	public <List>Double findPrices();
	
}
