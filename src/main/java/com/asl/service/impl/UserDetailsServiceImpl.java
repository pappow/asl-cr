package com.asl.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.asl.entity.User;
import com.asl.model.MyUserDetails;

/**
 * @author Zubayer Ahamed
 * @since Dec 28, 2020
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Value("${default.business.id}")
	private String businessId;

	@Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if(StringUtils.isBlank(username) || !"admin".equalsIgnoreCase(username)) throw new UsernameNotFoundException("User not found with username : " + username);
		User user = new User();
		user.setUserId(Long.valueOf(1));
		user.setUsername("admin");
		user.setPassword(bCryptPasswordEncoder.encode("admin"));
		user.setActive(true);
		user.setBusinessId(businessId);
		user.setRoles("SYSTEM_ADMIN");
		return new MyUserDetails(user);
	}

}
