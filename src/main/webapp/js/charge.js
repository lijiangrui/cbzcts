function supplierList(id){
	$.post(
      "chargeAction!supplierList.action", 
      {areaId: id},
	  function(data){
    	  $('#td').html(data.supplierHTML+"<span id='span2'>*</span>");
      },"json");
}