function showSearch(btn){
	var display = document.getElementById("div").style.display;
	if(display == ""){
		document.getElementById("div").style.display="none";
		btn.value = btn.value.replace("收起","展开");
	}else{
		document.getElementById("div").style.display="";
		btn.value = btn.value.replace("展开","收起");
	}
}