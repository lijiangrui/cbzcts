function supplierList(id){
	$.post(
      "patrol/patrolAction!supplierList.action", 
      {areaId: id},
	  function(data){
    	  var avilibleTags = data[1].tags;
    	  $("#supplierName").autocomplete({
    		  source:avilibleTags,
    		  select: function( event, ui ) {
    			  var val = ui.item.value;
    			  $("#sid option").each(function(){
    				  if($(this).text()==val){
    					  $(this).attr("selected",true);
    				  }
    			  });
    			  checkSelected('sid','span2');
    			  
    		  }
    	  });
    	  $('#td').html(data[0].supplierHTML+"<span id='span2' class='spanalert'>*</span>");
      },"json");
}