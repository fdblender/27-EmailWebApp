<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Data Entry</title>

</script>

</head>
<body>
	<h2>Send Email</h2>
	<form onsubmit="return validateForm()" action="SendEmail" method="get">
		<p>To:</p>
		<input type="text" name="to" id="to" value=""></input>
		<p>From:</p>
		<input type="text" name="from" id="from" value=""></input>
		<p>Subject:</p>
		<input type="text" name="subject" id="subject" value=""></input> 
		<p>Content:</p>
		<input type="textarea" rows=4 cols=20 maxlength=140 name="body" id="doby" value=""></input>
		<input type="submit" name="submit" id="submit" value="Submit"></input>
	</form>

	<script>
		// calling this function is not working
		function IsEmpty(objectfield, stringfield) {
			alert("value: " + objectvalue);
			objectvalue = objectfield.value.length;
			if (objectvalue == '') {
				alert("Oops.. Please fill out the value of " + stringfield);
				objectfield.style.background = 'Yellow';
				return false;
			} else {
				return true;
			}
		}		
		
	</script>

</body>
</html>