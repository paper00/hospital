package hfut.se.mapper;

import java.util.List;

import hfut.se.bean.Doctor;
import hfut.se.bean.Section;

// 不写 @Repository
public interface SectionMapper {

	public Section findById(Integer id);
	public Section findByName(String name);
	public Integer save(Section section);
	public Integer update(Section section);
	public Integer delete(Integer id);
	public List<Section> findAll();
	public Integer getCount();
	
}