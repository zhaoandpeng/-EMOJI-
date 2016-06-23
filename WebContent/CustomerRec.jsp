<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户端录制视频测试DEMO</title>
<link href="css/default.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript" src="anychat/anychatsdk.js"></script>
<script type="text/javascript" src="anychat/backbusiness.js"></script>
<script type="text/javascript" src="anychat/anychatevent.js"></script>
<script type="text/javascript" src="anychat/jquery.min.js"></script> 
</head>
<body onload="initThing()">
	<div id="AnyChatLocalVideoDiv">  
        <div id="header">  
            <h1>客户端录制DEMO测试</h1>  
        </div>  
        <div id="search">  
              
        </div>  
        <div id="search2">  
            
        </div>
        <div id="search3">  
            &nbsp;&nbsp;&nbsp;&nbsp;<button class='className' id="startVideo" onclick="startVideo()">开始录制</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button class='className' id="endVideo" onclick="endVideo()">结束录制</button>
        </div>
    </div> 
</body>
</html>