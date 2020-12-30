package com.asl.service.impl;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.asl.entity.Xusers;
import com.asl.service.UserService;

/**
 * @author Zubayer Ahamed
 * @since Dec 30, 2020
 */
@Service
public class UserServiceImpl implements UserService {

	protected static final String ERROR_LOG = "Error is {}, {}";

	@PersistenceContext protected EntityManager em;
	@Autowired protected JdbcTemplate jdbcTemplate;

	@Override
	public List<Xusers> findBByUsernameAndPassword(String username, String password) {
		if(StringUtils.isBlank(username) || StringUtils.isBlank(password)) return null;

		List<Xusers> list = em.createQuery("SELECT u FROM Xusers u WHERE u.zemail=:username AND u.xpassword=:pass", Xusers.class)
							.setParameter("username", username)
							.setParameter("pass", password)
							.getResultList();
		
		return list == null || list.isEmpty() ? Collections.emptyList() : list;
	}

	@Override
	public Xusers findBByUsernameAndBusinessId(String username, String businessId) {
		if(StringUtils.isBlank(username) || StringUtils.isBlank(businessId)) return null;
	
		List<Xusers> list = em.createQuery("SELECT u FROM Xusers u WHERE u.zemail=:username AND u.zid=:zid", Xusers.class)
				.setParameter("username", username)
				.setParameter("zid", Integer.valueOf(businessId))
				.getResultList();

		return list == null ? null : list.stream().findFirst().orElse(null);
	}

	

}
