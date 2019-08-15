package hfut.se.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import hfut.se.bean.Prescription;
import hfut.se.bean.Section;

public interface PrescriptionMapper {
	
	public Prescription findById(Integer id);
	public Integer save(Prescription prescription);
	public Integer update(Prescription prescription);
	public Integer delete(Integer id);
	public List<Prescription> findAll();
	public List<Prescription> findBySid(Integer sid);
	public List<Prescription> findByDate(Date begin, Date end);
	public List<Prescription> findBySidAndDate(Date begin, Date end, Integer sid);
	public Integer getPatientCount(Date today);
	public List<Prescription> findNowPrescription(@Param("cardid")String cardid,@Param("did") String did,@Param("ispaid") Integer ispaid);
	public List<Prescription> findAllPatient(String did);
	public List<Prescription> findByCardId(String id);
}