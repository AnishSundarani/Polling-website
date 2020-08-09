$(document).ready(function() {
	
	$("#nav").load("/nav");
	
	console.log(disable);
	
	$('#votebtn').prop('disabled', disable);

	
});

function vote() {
	$.ajax({
		  type: "POST",
		  url: "/vote/" + name,
		  success: function(data){
			  console.log(data);
			  location.reload(true);
		  }
		});
}