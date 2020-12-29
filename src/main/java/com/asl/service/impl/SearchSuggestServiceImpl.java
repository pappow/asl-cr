package com.asl.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.asl.service.SearchSuggestService;

/**
 * @author Zubayer Ahamed
 * @since Dec 29, 2020
 */
@Service
public class SearchSuggestServiceImpl implements SearchSuggestService {

	@Autowired protected JdbcTemplate jdbcTemplate;

	@Override
	public List<Map<String, Object>> queryForList(String sql) {
		if(StringUtils.isBlank(sql)) return Collections.emptyList();
		return jdbcTemplate.queryForList(sql);
	}
}
