function checkProvider(form) {
	var flag = true;
	document.getElementById("adviceSuggestionInfo.upFileRealName").value = document.getElementById("upFile").value;
	document.getElementById("adviceSuggestionInfo.upFileRealName1").value = document.getElementById("upFile1").value;
	document.getElementById("adviceSuggestionInfo.upFileRealName2").value = document.getElementById("upFile2").value;
	if (checkTips()) {
		removeTip();
		return confirm("本记录提交后不可删除、修改，\n确认提交请点击\"确认\"。");
	}
	return false;
}

function checkTips() {
	var tips = document.getElementsByName("tip");
	for ( var i = 0; i < tips.length; i++) {
		if (tips[i].innerHTML != "" && tips[i].id !="span") {
			alert("未能提交，请检查填写项。");
			return false;
		}
	}
	return true;
}

function removeTip() {
	var advComment = document.getElementById("adviceSuggestionInfo.asComment").value;
	if (advComment == "此处限填写300字以内") {
		document.getElementById("adviceSuggestionInfo.asComment").value = "";
	}
}

function addTip() {
	var advComment = document.getElementById("adviceSuggestionInfo.asComment").value;
	if (advComment == "") {
		document.getElementById("adviceSuggestionInfo.asComment").value = "此处限填写300字以内";
	}
}

function checkNull(id, tip) {
	var val = document.getElementById(id).value;
	if (val == "") {
		document.getElementById(tip).innerHTML = "*此项为必填项！";
	} else {
		document.getElementById(tip).innerHTML = "";
	}
}

function checkCount(id, tip) {
	var len = document.getElementById(id).value.length;
	if (len > 300) {
		document.getElementById(tip).innerHTML = "字数已达到最大长度！";
		document.getElementById(id).value = document.getElementById(id).value.substring(0,300);
	}else{
		document.getElementById(tip).innerHTML = "";
	}
}

function checkSelected(id, tip) {
	var sel = document.getElementById(id);
	var opts = sel.options;
	if (opts[0].selected) {
		document.getElementById(tip).innerHTML = "*此项为必填项！";
	} else {
		document.getElementById(tip).innerHTML = "";
	}
}

function checkTel(id, tip) {
	var regex = /^(13|14|15|18)\d{9}$/;
	var regex1 = /^(((0\d{3}[\-])?\d{7}|(0\d{2}[\-])?\d{8}))([\-]\d{2,4})?$/;
	var tel = document.getElementById(id).value;
	if (regex.test(tel)||regex1.test(tel)) {
		document.getElementById(tip).innerHTML = "";
	} else {
		document.getElementById(tip).innerHTML = "*您填写的号码有误，请重新填写！";
	}
}
function savedraft() {
	Ext.Ajax.request({
		method:'post',
		url:'user/saveDraft.action',
		params:{
			asNo:document.getElementById("adviceSuggestionInfo.asNo").value,
			asTheme:document.getElementById("adviceSuggestionInfo.asTheme")==null?"":document.getElementById("adviceSuggestionInfo.asTheme").value,
			asObjectType:document.getElementById("adviceSuggestionInfo.asObjectType")==null?"":document.getElementById("adviceSuggestionInfo.asObjectType").value,
			asObjectName:document.getElementById("adviceSuggestionInfo.asObjectName")==null?"":document.getElementById("adviceSuggestionInfo.asObjectName").value,
			asComment:document.getElementById("adviceSuggestionInfo.asComment")==null?"":document.getElementById("adviceSuggestionInfo.asComment").value,
			contacter:document.getElementById("adviceSuggestionInfo.contacter")==null?"":document.getElementById("adviceSuggestionInfo.contacter").value,
			tel:document.getElementById("adviceSuggestionInfo.tel")==null?"":document.getElementById("adviceSuggestionInfo.tel").value
		},
		success:function(reps,opts){
			var responseText = eval('('+reps.responseText+')');
			var msg = responseText.msg;
			alert(msg);
		}
	});
}

function get2LevelDict(id){
		var asObjectType = document.getElementById(id).value;
		if(asObjectType == ""){
			document.getElementById("span").innerHTML = "<select><option>请选择</option></select>";
			document.getElementById("tip2").innerHTML = "*";
		}else{
		
  		Ext.Ajax.request({
  			method:'post',
  			url:'user/get2LevelDict.action',
  			params:{parentDictId:asObjectType,dictType:'asObjectName'},
  			success:function(resp,opts){
  				var respText = eval('(' + resp.responseText + ')');                                                   
                var asObjectNameSelHTML = respText.asObjectNameSelHTML;
                document.getElementById("span").innerHTML = asObjectNameSelHTML;
  			}
  		});
		}
	}

function checkspan(){
	var spans = document.getElementsByTagName("span");
	for(var i=0;i<spans.length;i++){
		if(spans[i].id.indexOf("extend")==-1){
			alert(spans[i].class);
			if(spans[i].innerHTML != ""){
				alert("请填写必填项！");
				return false;
			}
		}
	}
	return true;
}

function checkspans(){
	var spanss = $("span[class='spanalert']");
	for(var i=0;i<spanss.length;i++){
		if(spanss.get(i).innerHTML !=""){
			alert("请填写必填项！");
			return false;
		}
	}
	return true;
}

function checkNum(val,tip){
	var regex = /^[0-9]+(\.[0-9]+)?$/ ;// /^\d+(\.\d{1,4})?$/;
	
	if(regex.test(val)){
		document.getElementById(tip).innerHTML = "";
	} else {
		document.getElementById(tip).innerHTML = "*请填写数字类型！";
	}
}

/*身份证ID格式*/
function checkID(val,tip){
	isIDCard1=/^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$/;
	isIDCard2=/^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/; 
	if(isIDCard1.test(val) || isIDCard2.test(val)){
		document.getElementById(tip).innerHTML="";
	}else{
		document.getElementById(tip).innerHTML="身份证格式错误！";
	}
}

/*组织机构代码格式*/
function checkCode(val,tip){
	isCode = /^[a-zA-Z\d]{8}\-[a-zA-Z\d]$/;
	if(isCode.test(val)){
		document.getElementById(tip).innerHTML="";
	}else{
		document.getElementById(tip).innerHTML="格式错误！";
	}
}
/*营业执照格式*/
function checkLicense(val,tip){
	isLicense = /^\d{15}$/;
	if(isLicense.test(val)){
		document.getElementById(tip).innerHTML="";
	}else{
		document.getElementById(tip).innerHTML="格式错误！";
	}
}
function exists(id,url,span){
	var val = document.getElementById(id).value;
	Ext.Ajax.request({
		method:'post',
		url:url+val,
		success:function(reps,opts){
			var responseText = decodeJSON(reps);
			if(responseText.exist){
				checkNull(id,span);
			}else{
				document.getElementById(span).innerHTML = "*该值已存在！";
			}
		}
	});
}