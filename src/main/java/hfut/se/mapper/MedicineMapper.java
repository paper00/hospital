package hfut.se.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import hfut.se.bean.EntryDelivery;
import hfut.se.bean.Medicine;

public interface MedicineMapper {
	
	public Medicine findById(String id);
	public Integer save(Medicine medicine);
	public Integer update(Medicine medicine);
	public Integer delete(String id);
	public List<Medicine> findAll();
	public Integer getCount();
	public void addMedicine(Medicine medicine);
	public Double findPriceById(String id);
	public String findNameById(String id);
	public String findTypeById(String id);
	public List<Medicine> findDeliveryList();
	public void insertEntry(@Param("id")String id,
			@Param("number")Integer number);
	public void insertDelivery(@Param("id")String id,
			@Param("number")Integer number);
	public void add_number(@Param("id")String id, 
			@Param("number")Integer number);
	public void reduce_number(@Param("id")String id, 
			@Param("number")Integer number);
	public List<EntryDelivery> findEntry();
	public List<EntryDelivery> findDelivery();
	public Integer findNumberById(String id);

}
