package com.raulcnunes.workshopmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raulcnunes.workshopmongodb.domain.User;
import com.raulcnunes.workshopmongodb.dto.UserDTO;
import com.raulcnunes.workshopmongodb.repository.UserRepository;
import com.raulcnunes.workshopmongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){	
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User user) {
		return repo.insert(user);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User userUpdate(User user) {
		Optional<User> newObj = repo.findById(user.getId());
		User obj = newObj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado"));
		updateData(obj, user);
		return repo.save(obj);
	}
	
	private void updateData(User obj, User user) {
		obj.setName(user.getName());
		obj.setEmail(user.getEmail());
	}

	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(),userDTO.getEmail());
	}
}
