package tn.api.omar.users.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import tn.api.omar.users.dao.UserDAO;
import tn.api.omar.users.model.UserRole;

public class AppUserDetailService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

		System.out.println("loadUserByUsername");
		tn.api.omar.users.model.User user = UserDAO.findByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException(username+" is not found on the database.");
		}
		List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());
		return buildUserForAuthentication(user, authorities);

	}

	// Converts tn.api.omar.users.model.User user to
	// org.springframework.security.core.userdetails.User
	private User buildUserForAuthentication(tn.api.omar.users.model.User user, List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
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