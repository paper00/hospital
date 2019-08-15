package hfut.se.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hfut.se.bean.Doctor;
import hfut.se.bean.Section;
import hfut.se.mapper.DoctorMapper;
import hfut.se.service.exception.NotNullException;

@Service
public class DoctorService {

	@Autowired
	private DoctorMapper mapper;

	public Doctor findById(String id) {
		return mapper.findById(id);
	}
	
	@Transactional
	public void add(Doctor doctor) {
		mapper.save(doctor);
	}

	@Transactional
	public void delete(String id) {
		mapper.delete(id);
	}

	@Transactional
	public void update(Doctor doctor) {
		mapper.update(doctor);
	}
	
	public List<Doctor> findAll() {
		return mapper.findAll();
	}
	
	public List<Doctor> findBySection(Integer sid) {
		return mapper.findBySection(sid);
	}
	
	@Transactional
	public Integer getCount() {
		return mapper.getCount();
	}
	
	@Transactional
	public void updatePSInfo(String id,String phone,String email,String info) {
		mapper.updatePSInfo(id,phone, email, info);
	}
	
}
