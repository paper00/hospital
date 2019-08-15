package hfut.se.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hfut.se.bean.Section;
import hfut.se.mapper.SectionMapper;

@Service
public class SectionService {
	
	@Autowired
	private SectionMapper mapper;
	

	public Section findById(Integer id) {
		return mapper.findById(id);
	}
	
	public Section findByName(String name) {
		return mapper.findByName(name);
	}
	
	@Transactional
	public void add(Section section) {
		mapper.save(section);
	}

	@Transactional
	public void delete(Integer id) {
		mapper.delete(id);
	}

	@Transactional
	public void update(Section section) {
		mapper.update(section);
	}
	
	public List<Section> findAll() {
		return mapper.findAll();
	}
	
	@Transactional
	public Integer getCount() {
		return mapper.getCount();
	}
}
