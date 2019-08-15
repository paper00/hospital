package hfut.se.service;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.tomcat.util.digester.Digester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hfut.se.bean.User;
import hfut.se.mapper.UserMapper;
import hfut.se.service.exception.NotNullException;

@Service
public class UserService {

	@Autowired
	private UserMapper mapper;

	public User login(String username, String password) {

		if(username==null || username.equals("") || password==null || password.equals("")) {
			throw new NotNullException("用户名或密码不能为空");
		}
		
		String pw = DigestUtils.md5Hex(password);
		User user = mapper.findByUsername(username);
		
		if (user != null && (user.getPassword().equals(pw))) {
			return user;
		} else {
			return null;
		}
	}

	public User findById(Integer id) {
		return mapper.findById(id);
	}
	
	public User findByUsername(String username) {
		return mapper.findByUsername(username);
	}
	
	@Transactional
	public void add(User user) {
		mapper.save(user);
	}

	@Transactional
	public void delete(Integer id) {
		mapper.delete(id);
	}

	@Transactional
	public void update(User user) {
		mapper.update(user);
	}
	
	public List<User> findAll() {
		return mapper.findAll();
	}
	
}
