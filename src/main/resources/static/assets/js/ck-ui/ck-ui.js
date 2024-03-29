var ck = ck || {};
ck.ui = ck.ui || {};
ck.ui.config = ck.ui.config || {};

/**
 * SECTION TOGGLE
 */
ck.ui.config.sectionToggle = function(){
	$('.sectionbartoggle').off('click').on('click', function(e){
		$(this).find('i').toggleClass('fa-chevron-right');
		$(this).siblings('.togglebox').slideToggle();
	});
}

/**
 * CK-BIGMENU
 */
ck.ui.config.ckBigMenu = function(){
	// Stop bigmenu propagation
	$('ul.ckbigmenu').off('click').on('click', function(e){
		e.stopPropagation();
	})

	// Event for bigmenu show all button
	$('.ckbigmenu-showall').off('click').on('click', function(e){
		e.preventDefault();

		// Change text
		if($(this).html() == "Show all"){
			$(this).html('Hide all');
		} else {
			$(this).html('Show all');
		}

		// Display all hided menu or hide displayed menu
		$('.hidable-menu').toggleClass('nodisplay');

		// Ul size calculation depends on height and add or remove scrollbar
		var viewportHeight = $(window).height();
		var headerHeight = $('div.header-section').height();
		var navbarHeight = $('div.menu-section').height();
		var availableheight = viewportHeight - (navbarHeight + headerHeight) - 10;
		if($('.ckbigmenu').height() > 291){
			$('.ckbigmenu').css({
				'width': '419px',
				'max-height' : availableheight,
				'overflow-x' : 'hidden',
				'overflow-y' : 'scroll'
			});
		} else {
			$('.ckbigmenu').css({
				'width': '402px',
				'overflow' : 'inherit'
			});
		}
	});
}

/**
 * Trigger form edit-mode
 */
ck.ui.config.editmode = function(){
	// Disable action buttons list item propagation
	$('ul.navbar-action-buttons').find('li').off('click').on('click', function(e){
		e.stopPropagation();
	});

	var editmodetriggered = false;
	if($('li.add-btn.editmode').length > 0 && !editmodetriggered){
		editmodetriggered = true;
		$('#mainform .form-control, #mainform .form-control-input2').attr('disabled','true');
	}
	if($('li.update-btn.editmode').length > 0 && !editmodetriggered){
		editmodetriggered = true;
		$('#mainform .form-control, #mainform .form-control-input2').attr('disabled','true');
	}
	if($('li.archive-btn.editmode').length > 0 && !editmodetriggered){
		editmodetriggered = true;
		$('#mainform .form-control, #mainform .form-control-input2').attr('disabled','true');
	}
	if($('li.copy-btn.editmode').length > 0 && !editmodetriggered){
		editmodetriggered = true;
		$('#mainform .form-control, #mainform .form-control-input2').attr('disabled','true');
	}
	if(editmodetriggered) console.log("Edit mode triggered ...");

	// Bind update button event if available
	if($('li.update-btn.editmode').length > 0){
		$('li.update-btn.editmode').off('click').on('click', function(e){
			e.preventDefault();
			triggerUpdateButton();
		})
	}

	// Bind cancel button event if available
	if($('li.cancel-btn.viewmode').length > 0){
		$('li.cancel-btn.viewmode').off('click').on('click', function(e){
			e.preventDefault();
			triggerCancelButton();
		})
	}

	// Bind confirm button event
	if($('li.confirm-btn.viewmode').length > 0){
		$('li.confirm-btn.viewmode').off('click').on('click', function(e){
			e.preventDefault();
			submitMainForm();
		})
	}

	// Bind archive button event
	if($('li.archive-btn.editmode').length > 0){
		$('a.archive-btn-link').off('click').on('click', function(e){
			e.preventDefault();
			submitMainForm($(this).attr('href'));
		})
	}

	// Bind archive button event
	if($('li.restore-btn.editmode').length > 0){
		$('a.restore-btn-link').off('click').on('click', function(e){
			e.preventDefault();
			submitMainForm($(this).attr('href'));
		})
	}
}




/**
 * CK-ALERT positionting
 */
ck.ui.config.alert = function(){
	if($('.ck-alert').length < 1) return;

	var headerHeight = $('div.header-section').height();
	var navbarHeight = $('div.menu-section').height();
	var top = (headerHeight + navbarHeight) + 10;

	var left = (window.innerWidth - $('.ck-alert').width()) / 2;
	$('.ck-alert').css({
		'left' : left,
		'top' : top
	});
}


/**
 * CK Input element 
 */
ck.ui.config.inputelement = function(){

	// Add placeholder required
	$('form#mainform').find('input').each(function(){
		if($(this).prop('required')){
			$(this).attr('placeholder', 'Required');
		}
	});
}

/**
 * Button event bindings
 */
ck.ui.config.buttonevent = function(){
	// Modal confirm button to submit modal form
	$('button.confirm-btn-modal').off('click').on('click', function(e){
		e.preventDefault();
		submitModalForm();
	})
}

/**
 * Data table initialization
 */
ck.ui.config.datatable = function(){
	dataTableInit();
}

/**
 * Date picker & Time picker init
 */
ck.ui.config.dateAndTimepicker = function(){
	$(".datepicker").datetimepicker({
		useCurrent: false,
		format: "ddd, DD-MMM-YYYY",  // L, LL
		showTodayButton: true,
		icons: {
			next: "fa fa-chevron-right",
			previous: "fa fa-chevron-left",
			today: 'todayText',
		}
	});
	$(".timepicker").datetimepicker({
		format: "HH:mm",   // LT, LTS
		icons: {
			up: "fa fa-chevron-up",
			down: "fa fa-chevron-down"
		}
	});
}

ck.ui.config.reportForm = function(){
	if($('button.confirm-rpt-btn').length > 0){
		$('button.confirm-rpt-btn').off('click').on('click', function(e){
			e.preventDefault();
			submitReportForm();
		})
	}
}


/**
 * CK UI INITIALIZATION
 */
ck.ui.init = function(){
	ck.ui.config.editmode();
	ck.ui.config.inputelement();
	ck.ui.config.sectionToggle();
	ck.ui.config.ckBigMenu();
	ck.ui.config.alert();
	ck.ui.config.buttonevent();
	ck.ui.config.datatable();
	ck.ui.config.dateAndTimepicker();
	ck.ui.config.reportForm();
}




$(document).ready(function(){
	ck.ui.init();
});