package com.civleadercreator.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.civleadercreator.entity.User;

public class UserDto implements UserDetails {

	private static final long serialVersionUID = 1L;
	private int id;
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private Collection<GrantedAuthority> authorities;
	
	public UserDto() {
	}
	
	public UserDto(User user) {
		this.id = user.getId();
		this.email = user.getEmail();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
	}
	
	public UserDto(String email, String firstName, String lastName, String password) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}
	
	public UserDto(String email, String firstName, String lastName, String password, Collection<GrantedAuthority> authorities) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.authorities = authorities;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String getUsername() {
		return this.email;
	}
	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return this.authorities;
	}
	public void setAuthorities(Collection<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	
	public static UserDto.UserBuilder userDtoBuilder() {
		return new UserBuilder();
	}
	
	@Override
	public String toString() {
		return "User ----> Name: " + this.firstName + " " + this.lastName + " ----- ID: " + this.id + " ----- Email: " + this.email + " ----- Password: " + this.password;
	}
	
	@Override
	public boolean isEnabled() {
		return true;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public static final class UserBuilder {
		
		private String email;
		private String password;
		private String firstName;
		private String lastName;
		private Collection<GrantedAuthority> authorities;
		
	
		
		protected UserBuilder() {
		}
		
		public UserBuilder email(String email) {
			this.email = email;
			return this;
		}
		public UserBuilder password(String password) {
			this.password = password;
			return this;
		}
		public UserBuilder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}
		public UserBuilder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}
		public UserBuilder authorities(String... authorities) {
			
			this.authorities = getAuthorities(authorities);
			return this;
		}
		public UserDto build() {
			UserDto userDto = new UserDto(email, firstName, lastName, password, authorities);
			return userDto;
		}
		
		private static Collection<GrantedAuthority> getAuthorities(String... authorities){
			UserDetails holderDetails = org.springframework.security.core.userdetails.User.builder().authorities(authorities).username("holder").password("holder").build();
			org.springframework.security.core.userdetails.User holder = new org.springframework.security.core.userdetails.User("holder", "holder", holderDetails.getAuthorities());
			return holder.getAuthorities();
		}
		
	}

}
