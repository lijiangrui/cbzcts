function isExist(no,tip){
	  $.post("supplierAction!isExist.action",
			 {"no":no},
			 function(data){
				if(data.isExist) document.getElementById(tip).innerHTML="该企业已经存在！";
			 }, "json");
	  
  }