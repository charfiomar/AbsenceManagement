package tn.api.omar.users.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.api.omar.users.dao.UserDAO;
import tn.api.omar.users.model.UserRole;



@Service("userDetailsService")
public class AppUserDetailService implements UserDetailsService {

	//get user from the database, via Hibernate
	@Autowired
	private UserDAO userDao;

	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(final String username) 
		throws UsernameNotFoundException {
	
		tn.api.omar.users.model.User user = userDao.findByUserName(username);
		List<GrantedAuthority> authorities = 
                                      buildUserAuthority(user.getUserRole());

		return buildUserForAuthentication(user, authorities);
		
	}

	// Converts tn.api.omar.users.model.User user to
	// org.springframework.security.core.userdetails.User
	private User buildUserForAuthentication(tn.api.omar.users.model.User user, 
		List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), user.getPassword(), 
			user.isEnabled(), true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
		for (UserRole userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}

}