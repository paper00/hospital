package hfut.se.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import hfut.se.bean.Doctor;

//不写 @Repository
public interface DoctorMapper {

	public Doctor findById(String id);
	public Integer save(Doctor doctor);
	public Integer update(Doctor doctor);
	public Integer delete(String id);
	public List<Doctor> findAll();
	public Integer getCount();
	public List<Doctor> findBySection(Integer sid);
	public Integer updatePSInfo(@Param("id")String id,@Param("phone")String phone,@Param("email")String email, @Param("info") String info);
	
}