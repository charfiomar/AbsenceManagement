<script>
	
	$(document).ready(function() {
		$.getJSON('http://omar-api.tn:8080/AbsenceManagement/fullcalendarbuild', function (data) {
			$('#calendar').fullCalendar({
				defaultView : 'agendaWeek',
				defaultDate : '2018-05-27',
				editable : true,
				eventLimit : true,
				events : data
			});
		});
		//LOGOUT Listener
		$('#logout').click(function() {
			$('#logoutForm').submit();
		});
	});
</script>