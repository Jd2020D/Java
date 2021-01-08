		  $("button").click(function(e){
			    e.preventDefault()
			  $.ajax({
			    url: 'reset',
			    method: 'post',
			    data: "",
			    success: function(serverResponse){
			    	$("p").text("You have visited our website 0 times.")		    
			    	}
			  })

			    }); 
