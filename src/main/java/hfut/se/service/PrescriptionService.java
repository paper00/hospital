package hfut.se.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hfut.se.bean.Prescription;
import hfut.se.bean.Section;
import hfut.se.mapper.PrescriptionMapper;

@Service
public class PrescriptionService {
	
	@Autowired
	private PrescriptionMapper mapper;
	
	public Prescription findById(Integer id) {
		return mapper.findById(id);
	}
	
	@Transactional
	public Integer add(Prescription prescription) {
		return mapper.save(prescription);
	}
	
	@Transactional
	public Integer update(Prescription prescription) {
		return mapper.update(prescription);
	}
	
	@Transactional
	public Integer delete(Integer id) {
		return mapper.delete(id);
	}
	
	public List<Prescription> findAll() {
		return mapper.findAll();
	}
	
	public List<Prescription> findBySid(Integer sid) {
		return mapper.findBySid(sid);
	}
	
	public List<Prescription> findByDate(Date begin, Date end) {
		return mapper.findByDate(begin, end);
	}
	
	public List<Prescription> findBySidAndDate(Date begin, Date end, Integer sid) {
		return mapper.findBySidAndDate(begin, end, sid);
	}
	
	public Integer getPatientCount(Date today) {
		return mapper.getPatientCount(today);
	}
	
	public List<Prescription> findNowPrescription(String cardid, String did, Integer ispaid) {
		return mapper.findNowPrescription(cardid, did, ispaid);
	}
	
	public List<Prescription> findAllPatient(String did){
		return mapper.findAllPatient(did);
	}

	public List<Prescription> findByCardId(String id) {		
		return mapper.findByCardId(id);
	}

}
