<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String swfFilePath=(String)session.getAttribute("swfFilePath");      
%>  
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
	<html>  
	<head>  
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
	<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>  
	<script type="text/javascript" src="<%=basePath%>js/flexpaper_flash.js"></script>  
	<script type="text/javascript" src="<%=basePath%>js/flexpaper_flash_debug.js"></script>
	  
	<title>档案预览</title>  
	  
	</head>  
	<body>   
        <div align="center">  
            <a id="viewerPlaceHolder" style="width:1000px;height:600px;display:block;"></a>  
        	<script type="text/javascript">   
      var fp = new FlexPaperViewer(     
               'FlexPaperViewer',  
               'viewerPlaceHolder', { config : {  
               SwfFile : escape('<%=swfFilePath%>'),  
               Scale : 0.6,   
               ZoomTransition : 'easeOut',  
               ZoomTime : 0.5,  
               ZoomInterval : 0.2,  
               FitPageOnLoad : true,  
               FitWidthOnLoad : false,  
               FullScreenAsMaxWindow : true,  
               ProgressiveLoading : true,  
               MinZoomSize : 0.2,  
               MaxZoomSize : 5,  
               SearchMatchAll : false,  
               InitViewMode : 'SinglePage',  
                 
               ViewModeToolsVisible : true,  
               ZoomToolsVisible : true,  
               NavToolsVisible : true,  
               CursorToolsVisible : true,  
               SearchToolsVisible : true,  
               PrintEnabled : true,
               localeChain: 'zh_CN'  
               }});  
	</script>  
        </div>  
</body>  
</html> 
