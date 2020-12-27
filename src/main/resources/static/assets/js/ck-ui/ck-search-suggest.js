$(document).ready(function(){
	console.log("%cSearch Sugget Init...", "color:green");
	var countries = new Bloodhound({
		datumTokenizer: Bloodhound.tokenizers.whitespace,
		queryTokenizer: Bloodhound.tokenizers.whitespace,
		// url points to a json file that contains an array of country names, see
		// https://github.com/twitter/typeahead.js/blob/gh-pages/data/countries.json
		remote: {
			url: getBasepath() + '/search/countries',
			wildcard: '%QUERY'
		}
	});
	
//	$('.searchsuggest').typeahead(null, {
//		name: 'countries',
//		limit: 10,
//		source: countries
//	});
	$(".searchsuggest").on('keyup', function(e) {
		var hint = $(this).val();
		var targetElement = $(this);
		var serachUrl = $(this).attr('search-url');

		$.ajax({
			url : getBasepath() + '/' + serachUrl,
			type : 'GET',
			beforeSend : loadingMask2.show(),
			success : function(data) {
				loadingMask2.hide();
				generateSearchResult(targetElement, data);
			}, 
			error : function(jqXHR, status, errorThrown){
				loadingMask2.hide();
				showMessage(status, "Something went wrong .... ");
			}
		});

		
	});
	
	function generateSearchResult(uielement, data){
		console.log(uielement);
		// create search suggest div
		var parent = $(uielement).parent();
		var ssr = '<div class="search-suggest-result"></div>';
		$(parent).append(ssr);
		$(ssr).css({
			'display':'block',
			'height' : '100px',
			'width' : $(uielement).width() + 20,
			'top' : $(uielement).height("px")
		});

		// clreate list items
		//$(ssr).html("");
		$.each(data, function(index, item){
			console.log({item});
			var listitem = '<li value="'+ item.value +'">'+ item.prompt +'</li>';
			$(ssr).append(listitem);
		})

	}
});