package com.civleadercreator.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.civleadercreator.dto.UserDto;
import com.civleadercreator.entity.User;
import com.civleadercreator.exceptions.UserAlreadyExistException;
import com.civleadercreator.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public User saveUser(UserDto userDto) {
		User user = populateUserData(userDto);
		return userRepository.save(user);
	}
	
	private User populateUserData(final UserDto userDto) {
		User user = new User();
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());
		encodePassword(user, userDto);
		return user;
	}
	
	
	@Override
	public void register(UserDto userDto) throws UserAlreadyExistException {
		if(checkIfUserExist(userDto.getEmail())) {
			 throw new UserAlreadyExistException("User already exists for this email");
		}
		User user = populateUserData(userDto);
		userRepository.save(user);
	}
	
	@Override
    public boolean checkIfUserExist(String email) {
        return userRepository.findByEmail(email) !=null ? true : false;
    }
	
    private void encodePassword(User user, UserDto userDto){
    	user.setPassword(passwordEncoder.encode(userDto.getPassword()));
    }

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(email);
        }
        UserDetails userDetails = UserDto.userDtoBuilder()
        		.email(email)
        		.password(user.getPassword())
        		.firstName(user.getLastName())
        		.lastName(user.getLastName())
        		.authorities("USER")
        		.build();
        return userDetails;
	}
	
	@Override
	public User getUserByUsername(String email) {
		User user = userRepository.findByEmail(email);
		return user;
	}
	
	
}
