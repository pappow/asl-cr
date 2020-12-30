package com.asl.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.asl.entity.Xusers;

/**
 * @author Zubayer Ahamed
 * @since Dec 30, 2020
 */
@Component
public interface UserService {

	public List<Xusers> findBByUsernameAndPassword(String username, String password);
	public Xusers findBByUsernameAndBusinessId(String username, String businessId);
}
