package hfut.se.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import hfut.se.bean.Patient;
import hfut.se.bean.Prescription;

public interface PatientMapper {
	
	public Patient findByCardid(String cardid);
	public Integer save(Patient patient);
	public Integer update(Patient patient);
	public Integer delete(String cardid);
	public List<Patient> findAll();
	public List<Patient> findAllByDid(String did);
	public void update_phone(@Param("cardid")String cardid,@Param("phone")String phone);
	
}
