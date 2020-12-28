package com.asl.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping("/item/itemcode/{hint}")
	public @ResponseBody List<SearchSuggestResult> getCountries(@PathVariable String hint) {
		List<SearchSuggestResult> list = new ArrayList<>();
		list.add(new SearchSuggestResult("BD", "Bangladesh"));
		list.add(new SearchSuggestResult("PK", "Pakistan"));
		list.add(new SearchSuggestResult("IN", "India"));
		list.add(new SearchSuggestResult("US", "United State"));
		list.add(new SearchSuggestResult("UK", "United Kingdom"));
		list.add(new SearchSuggestResult("SR", "Srilonka"));
		list.add(new SearchSuggestResult("CH", "China"));

		return list.stream().filter(f -> f.getPrompt().toLowerCase().contains(hint.toLowerCase())).collect(Collectors.toList());
	}
}
