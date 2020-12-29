package com.asl.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * @author Zubayer Ahamed
 * @since Dec 29, 2020
 */
@Component
public interface SearchSuggestService {

	/**
	 * Get result list
	 * @param sql
	 * @return
	 */
	public List<Map<String, Object>> queryForList(String sql);
}
