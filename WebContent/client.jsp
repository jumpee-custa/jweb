<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/jweb/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="/jweb/css/client.css">
</head>
<body>
<script type="text/javascript" src="/jweb/lib/jquery-1.12.3.min.js"></script>
<script type="text/javascript" src="/jweb/js/client.js"></script>
<script language="javascript" type="text/javascript"> </script>

	<title>watson client</title>
</head>
<body>
<h2>watson client test!!</h2>
<div class="box1" id="div_box1">
	<!-- <label for="question" accesskey="q" >質問</label> -->
	<input type="text" name="question" id="question" value="質問を受け付けてます。" ></input>
	<input type="submit" id="qsend" name="qsend" value="send"/>
</div>
<div class="box1" id="div_body2">

	<select name="kindselect" id="kindselect">
		<option value="001">OS</option>
		<option value="002">LANGUAGE</option>
		<option value="003">DB</option>
	</select>
	<a href="/jweb/webapi/myresource/dbtest">mysql connection test!</a>

</div>

</body>
</html>