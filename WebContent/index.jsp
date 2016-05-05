<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="client.css">
</head>
<body>
	<h2>Jersey RESTful Web Application!</h2>
	<p>
		<a href="webapi/myresource">Jersey resource</a>
	<p>
		Visit <a href="http://jersey.java.net">Project Jersey website</a> for
		more information on Jersey!
	<hr>
	<a href="webapi/myresource/list">list</a>
	<hr>
	<form action="webapi/myresource/classifier" method="post"
		enctype="multipart/form-data">
		<p>
			<input type="file" name="traningdata">
		</p>
		<p>
			<input type="submit" value="sumit">
		</p>
	</form>

	<hr>
	<form method="post" action="webapi/myresource/question">
		<input type="text" value="質問を受けつけましょう" name="question"/>
		<input type="submit" value="submit"/>
	</form>
</body>

</html>