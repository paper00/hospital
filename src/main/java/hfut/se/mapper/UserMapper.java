package hfut.se.mapper;

import java.util.List;

import hfut.se.bean.User;

// 不写 @Repository
public interface UserMapper {

	public User findById(Integer id);
	public User findByUsername(String username);
	public Integer save(User user);
	public Integer update(User user);
	public Integer delete(Integer id);
	public List<User> findAll();

}