package com.asl.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asl.model.SearchSuggestResult;

/**
 * @author Zubayer Ahamed
 * @since Dec 27, 2020
 */
@Controller
@RequestMapping("/search")
public class SearchSuggestController extends ASLAbstractController {

	@GetMapping("/countries")
	public @ResponseBody List<SearchSuggestResult> getCountries() {
		List<SearchSuggestResult> list = new ArrayList<>();
		list.add(new SearchSuggestResult("BD", "Bangladesh"));
		list.add(new SearchSuggestResult("PK", "Pakistan"));
		list.add(new SearchSuggestResult("IN", "India"));
		return list;
	}
}
