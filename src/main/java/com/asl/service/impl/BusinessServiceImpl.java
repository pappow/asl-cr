package com.asl.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asl.entity.Zbusiness;
import com.asl.repository.BusinessRepository;
import com.asl.service.BusinessService;

/**
 * @author Zubayer Ahamed
 * @since Dec 30, 2020
 */
@Service
public class BusinessServiceImpl implements BusinessService{

	@Autowired private BusinessRepository businessRepo;
	@Override
	public Zbusiness findBById(Integer businessId) {
		if(businessId == null) return null;
		Optional<Zbusiness> result = businessRepo.findById(businessId);
		return result.isPresent() ? result.get() : null;
	}

}
