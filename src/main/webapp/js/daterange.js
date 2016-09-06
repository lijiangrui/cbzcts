$(function() {
	$("#startTime").datepicker( {
		defaultDate : "+1w",
		changeMonth : true,
		onClose : function(selectedDate) {
			$("#endTime").datepicker("option", "minDate", selectedDate);
		}
	});
	$("#endTime").datepicker( {
		defaultDate : "+1w",
		changeMonth : true,
		onClose : function(selectedDate) {
			$("#startTime").datepicker("option", "maxDate", selectedDate);
		}
	});
});