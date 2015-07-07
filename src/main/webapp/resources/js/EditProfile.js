/**
 * 
 */

$(document).ready(function(){
	$(".editlink").on("click", function(e){
	  e.preventDefault();
	var id=$(this).attr('id');
	
	console.log(id);
		var dataset = $(this).prev(".datainfo");
		var savebtn = $(this).next(".savebtn");
		var theid   = dataset.attr("id");
		var newid   = theid+"-form";
		var currval = dataset.text();
		
		dataset.empty();
		if(id=='emailclick' || id=='unameclick' || id=='phonenoclick' || id=='techclick' || id=='ansclick')
			{
			$('<input type="text" name="'+newid+'" id="'+newid+'" value="'+currval+'" class="hlite">').appendTo(dataset);
			}
		else if(id=='imgclick')
			{
		$('<input type="file" name="'+newid+'" id="'+newid+'" value="'+currval+'" class="hlite">').appendTo(dataset);
			}
		else if(id=='secquestionclick')
			{
			$('<div id="secquesdiv" name="'+newid+'" id="'+newid+'" class="hlite""></div>').appendTo(dataset);
			$.ajax({
				url : 'http://localhost:8080/FeedBackAutomation/registration/getSecQuestions',
				method : 'GET',
				datatype : "json",
				contentType : 'application/json',
				success : function(data) {
					processData(data);
				},
				error : function() {
					alert('error')
				}

			});

			}
		
		$(this).css("display", "none");
		savebtn.css("display", "block");
	});
	
	
	$(".savebtn").on("click", function(e){
		e.preventDefault();
		var sid=$(this).attr('id');
		console.log(sid);
		var elink   = $(this).prev(".editlink");
		var dataset = elink.prev(".datainfo");
		var newid   = dataset.attr("id");
		
		var cinput  = "#"+newid+"-form";
		var einput  = $(cinput);
		var newval  = einput.attr("value");
		var empid=document.getElementById("empid").value;
		ajaxCall(empid,sid,newval,einput,dataset,elink);
	});
});
function ajaxCall(empid,sid,newval,einput,dataset,elink)
{
	
	$.ajax({
		url : '../Trainee/updateUserInfo',
		method : 'GET',
		contentType : 'application/json',
		data:{
			EmpId:empid,
			name:sid,
			value:newval
		},
		success : function(data) {
			
			console.log(data);
			if(data=='success')
				{
				$(".savebtn").css("display", "none");
				einput.remove();
				dataset.html(newval);
				
				elink.css("display", "block");
			
				}
			else if(data=='format error')
				{
				alert('email is not in valid format');
				}
			else if('query problem')
				{
				alert('problem in query');
				}
		},
		error : function() {
			console.log('error');
		}

	});
	}
function processData(data)
{
	alert('in processData');
	var dropdown="<select onchange='callSecAjax();' name='Technology' id='Technology'> <option id='defaultechnology' value=''>--SelectTechnology</option>";
	
	for (var i = 0; i < data.length; i++) {

		dropdown+="<option value='"+data[i]+"'>"+data[i]+"java</option>";
	}
	dropdown+="</select>";
	alert('dropdown');
	document.getElementById('secquesdiv').innerHTML=dropdown;
	
	}