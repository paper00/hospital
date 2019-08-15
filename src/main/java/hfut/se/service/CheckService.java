package hfut.se.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hfut.se.bean.CheckInfo;
import hfut.se.bean.Prescription;
import hfut.se.mapper.CheckMapper;

@Service
public class CheckService {
	
	@Autowired
	private CheckMapper checkmapper;
	
	public List<Prescription> findPreByCardId(String cardId){
		
		return checkmapper.findPreByCardId(cardId);
		
	}
	
	//保存收费信息并修改处方付款状态
	@Transactional
	public Double check(String cardId, String username){
		List<Prescription> allPre= checkmapper.findPreByCardId(cardId);
		List<Double> prices = checkmapper.findPriceByCardId(cardId);
		double price = 0;
		for(int i = 0; i < prices.size(); i++) {
			price += prices.get(i) * allPre.get(i).getNumber();
		}
		
		checkmapper.saveCheckInfo(cardId, username, (Double)price);
		
		for(int i = 0; i < allPre.size(); i++) {
			checkmapper.updatePreStatus(allPre.get(i).getId());	
		}
		
		return (Double)price;
	}
	
	public void updataPreStatus(String cardId) {
		List<Prescription> allPre= checkmapper.findPreByCardId(cardId);
		for(int i = 0; i < allPre.size(); i++) {
			checkmapper.updatePreStatus(allPre.get(i).getId());	
		}	
	}
	
	//查询病人收费情况
	public Double findRecentPrices() {
		return checkmapper.findPrices();
	}
	
}
