package com.asl.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asl.model.SearchSuggestResult;
import com.asl.service.SearchSuggestService;

/**
 * @author Zubayer Ahamed
 * @since Dec 27, 2020
 */
@Controller
@RequestMapping("/search")
public class SearchSuggestController extends ASLAbstractController {

	@Autowired private SearchSuggestService searchService;

	@GetMapping("/item/itemcode/{hint}")
	public @ResponseBody List<SearchSuggestResult> getCountries(@PathVariable String hint) {
		StringBuilder sql = new StringBuilder("SELECT xitem, xdesc FROM caitem WHERE zid='"+ sessionManager.getBusinessId() +"' AND (xdesc LIKE '%"+ hint +"%' OR xitem LIKE '%"+ hint +"%')");

		List<Map<String, Object>> result = searchService.queryForList(sql.toString());

		List<SearchSuggestResult> list = new ArrayList<>();
		result.stream().forEach(m -> {
			String value = (String) m.get("xitem");
			String prompt = (String) m.get("xdesc");
			list.add(new SearchSuggestResult(value, value + " - " + prompt));
		});

		return list;
	}

	
}
