package com.asl.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.asl.entity.Xusers;

import lombok.ToString;

/**
 * @author Zubayer Ahamed
 * @since 27-11-2020
 *
 */
@ToString
public class MyUserDetails implements UserDetails {

	private static final long serialVersionUID = 112410652033677128L;

	private String username;
	private String password;
	private String emailAddress;
	private String businessId;
	private boolean accountExpired;
	private boolean credentialExpired;
	private boolean accountLocked;
	private boolean enabled;
	private String roles;
	private List<GrantedAuthority> authorities;

	public MyUserDetails(Xusers user) {
		this.username = user.getZemail();
		this.password = user.getXpassword();
		this.businessId = String.valueOf(user.getZid());
		this.accountExpired = false;
		this.credentialExpired = false;
		this.accountLocked = false;
		this.enabled = true;
		this.roles = user.getRoles();
		this.authorities = Arrays.stream(user.getRoles().split(","))
									.map(SimpleGrantedAuthority::new)
									.collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	public String getBusinessId() {
		return businessId;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	@Override
	public boolean isAccountNonExpired() {
		return !accountExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return !accountLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return !credentialExpired;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	public String getRoles() {
		return roles;
	}
}
