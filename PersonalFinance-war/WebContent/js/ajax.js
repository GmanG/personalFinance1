//function getXmlHttpRequestObject(){
//    var xmlhttp = false;
//    if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
//         xmlhttp=new XMLHttpRequest();
//      } else {// code for IE6, IE5
//         xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
//      }
//      return xmlhttp;
//}
//
//var xmlhttp = new getXmlHttpRequestObject();
//
///*function servletPost(){
//    if(xmlhttp){
//        var txtName = document.getElementById("txtName");
//        xmlhttp.onreadystatechange = handleServletPost;
//        xmlhttp.open("POST", "ShowMessageServlet", true);
//        xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
//        xmlhttp.send("txtName=" + txtName.value);
//    } else {
//        alert('No xmlhttp');
//    }
//}
//
//function handleServletPost(){
//    if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
//          document.getElementById("message").innerHTML = xmlhttp.responseText;
//    }
//}
//
//function showSelected(){
//	if(xmlhttp){
//		var category = document.getElementById("categoryOut").value;
//		var amount = document.getElementById("amount").value;
//		var sendPost = "category="+category+" amount="+amount+" category="+category+" category="+category;
//		xmlhttp.onreadystatechange = handleServletShowSelected;
//		xmlhttp.open("POST", "ShowSelectedServlet", true);
//		xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
//		xmlhttp.send("sendPost="+sendPost);
//	}
//}*/
//
//function handleServletShowSelected() {
//	 if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
//         document.getElementById("mmmmm").innerHTML = xmlhttp.responseText;
//   }
//}
//
//function outMoneyServlet(){
//	if(xmlhttp){
//		
//			var category = document.getElementById("categoryOut").value;
//			var type = document.getElementById("typeOut").value;
//			var amount = document.getElementById("amountOut").value;
//			var descrip = document.getElementById("descripOut").value;
//			var email = document.getElementById("email").value;
//			var sendPost = "category="+category+"&type="+type+"&amount="+amount+"&descrip="+descrip+"&email="+email;
//			xmlhttp.onreadystatechange = handleServletShowSelected;
//			xmlhttp.open("POST", "OutMoneyServlet", true);
//			xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
//			xmlhttp.send(sendPost);
//		
//		
//	}
//}
//
//function sendMoney() {
//	if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
//        document.getElementById("mmmmm").innerHTML = xmlhttp.responseText;
//  }
//}

//Pass data to Servlet OutMoneyServlet 
$(document).ready(function(){
	$("#outMoney").click(function(){
		var amount = $('#amount').val();
		if(amount){
			var dataString = {category:$("#category").val(), type:$("#type").val(), amount:amount, descrip:$("#descrip").val()};
			$.ajax({
				type: "POST",
				url: "OutMoneyServlet",
				data: dataString,
				success:function(){
					$("#messages").append("<div class=\"alert alert-success\">Data passed sucessefull</div>");
				},
				error:function(){
					alert('try again');
				}
			});
		} else {
//			setTimeout(function(){
				$("#messages").append("<div class=\"alert alert-error\">Field amont empty</div>").fadeOut().delay(5000);
//			}, 10000);
			
		}
		
//		return false;
	});
});
//Render user transaction
//$(document).ready(function() {
//	 
//       
//    //checks for the button click event
//    $("#renderTable").click(function (e){
//           
//            //make the AJAX request, dataType is set to json
//            //meaning we are expecting JSON data in response from the server
//            $.ajax({
//                type: "POST",
//                url: "OutTransactionInfoServlet",
//                success: function( data, textStatus, jqXHR) {
//                    //our country code was correct so we have some information to display
//                     if(data){
//                    	 var obj = $.parseJSON(data.trim());
//                    	 var table= "<table border=\"1\">";
//                    	 $.each(obj, function(index, element) {
//                             table+='<tr><td>'+element.sum+"</td><td>"+element.description+"</td><td>"+element.typecategory.name+"</td><td>"+element.id+"X"+"</td></tr>";
//                         });
//                    	 table +=  "</table border=\"1\">";
//                    	 $("#divRenderTable").append(table);
//                     } 
//                     else {
//                         $("#divRenderTable").html("<div><b>Country code in Invalid!</b></div>");
//                     }
//                },
//                
//                //If there was no resonse from the server
//                error: function(jqXHR, textStatus, errorThrown){
//                     console.log("Something really bad happened " + textStatus);
//                      $("#ajaxResponse").html(jqXHR.responseText);
//                },
//                
//                //capture the request before it was sent to server
//                beforeSend: function(jqXHR, settings){
//                    //adding some Dummy data to the request
//                    settings.data += "&dummyData=whatever";
//                    //disable the button until we get the response
//                    $('#renderTabl1e').attr("disabled", true);
//                },
//                
//                //this is called after the response or error functions are finsihed
//                //so that we can take some action
//                complete: function(jqXHR, textStatus){
//                    //enable the button 
//                    $('#renderTable1').attr("disabled", false);
//                }
//      
//            });  
//    });
// 
//});

$(document).ready(function() {

  
//checks for the button click event
$("#test").click(function (e){
       var s = $("testClick").val();
       var dataString = "sendPost="+s;
       //make the AJAX request, dataType is set to json
       //meaning we are expecting JSON data in response from the server
       var i=1;
       $.ajax({
           type: "POST",
           url: "ShowSelectedServlet",
           data: dataString,
           success: function( data, textStatus, jqXHR) {
               //our country code was correct so we have some information to display
        	   i++;
                alert(data+"   " +i)
           },
           
           //If there was no resonse from the server
           error: function(jqXHR, textStatus, errorThrown){
                console.log("Something really bad happened " + textStatus);
                 $("#ajaxResponse").html(jqXHR.responseText);
           },
           
           //capture the request before it was sent to server
           beforeSend: function(jqXHR, settings){
               //adding some Dummy data to the request
               settings.data += "&dummyData=whatever";
               //disable the button until we get the response
               $('#renderTabl1e').attr("disabled", true);
           },
           
           //this is called after the response or error functions are finsihed
           //so that we can take some action
           complete: function(jqXHR, textStatus){
               //enable the button 
               $('#renderTable1').attr("disabled", false);
           }
 
       });  
});

});


