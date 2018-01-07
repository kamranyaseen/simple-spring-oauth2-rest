package com.kamranyaseen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kamranyaseen.dao.UserDao;
import com.kamranyaseen.model.User;

@SpringBootApplication
public class SimpleSpringOauth2RestApplication implements CommandLineRunner {
	
	@Autowired
	private UserDao userDao;

	public static void main(String[] args) {
		SpringApplication.run(SimpleSpringOauth2RestApplication.class, args);
	}
	
	@Override
	 public void run(String... args) throws Exception {
        User user = new User("test","$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu",5000);
        User user1 = new User("test1","$2a$04$PCIX2hYrve38M7eOcqAbCO9UqjYg7gfFNpKsinAxh99nms9e.8HwK",4000);
        User user2 = new User("test2","$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu",4500);
        
        userDao.save(user);
        userDao.save(user1);
        userDao.save(user2);
    }
	
}
