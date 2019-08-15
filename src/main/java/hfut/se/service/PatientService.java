package hfut.se.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hfut.se.bean.Patient;
import hfut.se.bean.User;
import hfut.se.mapper.DoctorMapper;
import hfut.se.mapper.PatientMapper;
import hfut.se.mapper.UserMapper;
import hfut.se.service.exception.UsernameAlreadyExistException;

@Service
public class PatientService {
	
	@Autowired
	private PatientMapper mapper;
	@Autowired
	private UserMapper userMapper;
	
	public Patient findByCardid(String cardid) {
		return mapper.findByCardid(cardid);
	}
	
	@Transactional
	public Integer add(Patient patient) {
		return mapper.save(patient);
	}
	
	@Transactional
	public Integer update(Patient patient) {
		return mapper.update(patient);
	}
	
	@Transactional
	public Integer delete(String cardid) {
		return mapper.delete(cardid);
	}
	
	public List<Patient> findAll() {
		return mapper.findAll();
	}
	
	public List<Patient> findAllByDid(String did){
		return mapper.findAllByDid(did);
	}


	public void register(User user) {
		User user1 = userMapper.findByUsername(user.getUsername());
		//用户名不存在
		if(user1 == null){
			userMapper.save(user);
		} else {
			//用户名存在,抛出异常
			throw new UsernameAlreadyExistException("用户名已经存在,请重新输入!");
		}
	}
	
	@Transactional
	public void update_phone(String cardid,String phone) {
		mapper.update_phone(cardid,phone);
	}
}
