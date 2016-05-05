//client javascript code

$(function() {

	// test
	// alert("jquery go!!");

	// ajax question
	var question = {
		send : function(data) {
			var defer = $.Deferred();
			$.ajax({
				type : 'POST',
				url : 'webapi/myresource/question',
				dataType : 'json',
				data : data,
				async : false,
				success : defer.resolve,
				error   : defer.reject
				});
				return defer.promise();
		}
	};

	// question send ajax
	$('#qsend').click(function() {
		var qstr = $('#question').val();

		if (qstr === '') {
			return true;
		}
		var data = {
			question : qstr
		};

		var answer;
		// var jsondata = jQuery.parseJSON(data)
		question.send(data).then(
				function(d){
					//console.log(d)
					answer = d;
				}
			,
				function(message){
					alert(message);
				}
		);
		
		


	});

	// question input text clear
	$('#question').click(function() {
		$(this).val('');
	});

});