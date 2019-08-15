package hfut.se.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import hfut.se.bean.EntryDelivery;
import hfut.se.bean.Medicine;
import hfut.se.mapper.MedicineMapper;

@Service
public class MedicineService {

	@Autowired
	private MedicineMapper mapper;
	
	public Medicine findById(String id) {
		return mapper.findById(id);
	}
	
	@Transactional
	public Integer add(Medicine medicine) {
		return mapper.save(medicine);
	}
	
	@Transactional
	public Integer update(Medicine medicine) {
		return mapper.update(medicine);
	}
	
	@Transactional
	public Integer delete(String id) {
		return mapper.delete(id);
	}
	
	public List<Medicine> findAll() {
		return mapper.findAll();
	}
	
	@Transactional
	public Integer getCount() {
		return mapper.getCount();
	}
	
	public Double findPriceById(String id) {
		return mapper.findPriceById(id);
	}
	
	public String findNameById(String id) {
		return mapper.findNameById(id);
	}
	public String findTypeById(String id) {
		return mapper.findTypeById(id);
	}
	
	@Transactional
	public void  addMedicine(Medicine medicine ) {	 
		 mapper.addMedicine(medicine);	
	}
	
	@Transactional
	public void  entry(String id,String name,Integer number,String med_type,Double price ) {
		 if(mapper.findById(id) == null) {
			 Medicine medicine = new Medicine(id, name, number,med_type, price);
			 mapper.addMedicine(medicine);	
		 }else 
			 	mapper.add_number(id,number);
		mapper.insertEntry(id,number);		
	}
	@Transactional
	public void  delivery(String id,Integer number) {	
		 if(mapper.findNumberById(id) >= number) {
			 mapper.reduce_number(id, number);
		 }	
		 mapper.insertDelivery(id, number);
	}
	
	@Transactional
	public void  add_number(String id,Integer number ) {	 
		 mapper.add_number(id, number);
	}
	@Transactional
	public void  reduce_number(String id,Integer number ) {	 
		 mapper.reduce_number(id, number);
	}
	@Transactional
	public void  insertEntry(String id,Integer number ) {	 
		 mapper.insertEntry(id, number);
	}
	
	@Transactional
	public void  insertDelivery(String id,Integer number ) {	 
		 mapper.insertDelivery(id, number);
	}
	
	public List<EntryDelivery> findEntry() {
		return mapper.findEntry();
	}
	public List<EntryDelivery> findDelivery() {
		return mapper.findDelivery();
	}
	
}
