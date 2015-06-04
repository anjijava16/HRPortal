<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body bgcolor="#ffcc99"><!-- <img src="img/h_logo.jpeg" border="3" width="100%" height="25%"> -->
<form name="cpwd" action="passwordUpdate.action" method="post">
<br /><br />
<h2 align="center">CHANGE PASSWORD</h2>
<input type="hidden" name="eid" id="eid">
<table  align="center">
<tr>
<td><b>Current Password&nbsp;:</b></td>
<td><input type="password" name="currentpwd" id="currentpwd" size="20" /></td>
</tr>
<tr><td></td></tr>
<tr><td></td></tr>
<tr>
<td><b>New Password &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</b></td>
<td><input type="password" name="newpwd"  id="newpwd" size="20" /></td>
</tr>
<tr><td></td></tr>
<tr><td></td></tr>
<tr>
<td><b>Confirm Password&nbsp;:</b></td>
<td><input type="password" name="confirmpwd" id="confirmpwd" size="20" /></td>
</tr>
</table>
<br />
<br />
<table align="center">
<tr>
<td>
<input type="submit" value="Submit" /></td>
<td><input type="reset" value="Reset" /></td>
</tr>
</table>
<center>
<%if(request.getAttribute("pmessage")!=null)
			{out.println(request.getAttribute("pmessage"));}%></center><br>
</form>
</body>
</html>