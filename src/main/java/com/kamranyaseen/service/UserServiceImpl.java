package com.kamranyaseen.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.kamranyaseen.dao.UserDao;
import com.kamranyaseen.model.User;

@Service(value="userService")
public class UserServiceImpl implements UserDetailsService, UserService{
	
	@Autowired 
	public UserDao userDao;
	
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException{
		User user = userDao.findByUsername(userId);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username / password");
		}
		return new org.springframework.security.core.userdetails.User(String.valueOf(user.getId()),user.getPassword(),getAuthority());
	}
	
	public List<SimpleGrantedAuthority> getAuthority(){
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}
	
	public List<User> findAll(){
		List<User> userlist = new ArrayList<>();
		userDao.findAll().iterator().forEachRemaining(userlist::add);
		return userlist;
	}
	
	@Override
	public void delete(long id) {
		userDao.delete(id);
	}
	
	@Override
	public User save(User user) {
		return userDao.save(user);
	}
}
