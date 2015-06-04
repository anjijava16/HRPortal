<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String id = request.getParameter("eid");
	
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
<script language="javascript">

function check(eid)
{
   if ( cpwd.newpwd.value !=  cpwd.confirmpwd.value )
   {
         alert("New password and confirm password are not matching.");
         document.cpwd.confirmpwd.focus();
         return false;
   }
   document.getElementById('eid').value = eid;	
   return true;
}

</script>
</head>
<body bgcolor="#ffcc99"><!-- <img src="img/h_logo.jpeg" border="3" width="100%" height="25%"> -->
<form name="cpwd" action="/hrp/servlet/CheckPwdServlet" onsubmit="return check('<%=id%>')">
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
<%if(request.getParameter("Msg")!=null)
			{out.println(request.getParameter("Msg"));}%></center><br>
</form>
</body>
</html>