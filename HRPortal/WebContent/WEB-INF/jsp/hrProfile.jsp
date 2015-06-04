<%@ page import="java.sql.*" %>
<%@ page import="com.iwinner.belk.hrportal.helper.*" %>
<html>
<title>HR E File</title>
<head>
<style>
body
{
background-color:#FFCC99;
}
</style>
</head>
<script type="text/javascript"	src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript"	src="${pageContext.request.contextPath}/js/jquery.query-2.1.7.js"></script>

<title><spring:message code="TITLE"></spring:message></title>

<script type="text/javascript">
$( document ).ready(function() {
	alert('loaded');
	$("#employeeName").focus();
	 $("#checkUserId").click(function(e)
			 {
		 		var username = document.getElementById("employeeName").value;
			     var postData = $(this).serialize();
			     var formURL = $(this).attr("action");
			     alert(username)
			     $.ajax(
			     {
			         url : "hrEfileNameCheck.action?username="+username,
			         type: "POST",
			         data : postData,
			         dataType: 'json',
			         success:function(data, textStatus, jqXHR)
			         {
			            $("#empProjModu").val(data.employeeVo.empModule);
			            $("#empDesg").val(data.employeeVo.empDesg);
			            $("#empDOB").val(data.employeeVo.empDOBDate);
			            $("#empDOJ").val(data.employeeVo.joinDate);
			            $("#empDORe").val(data.employeeVo.empRelDate);
			            $("#empProj").val(data.employeeVo.empProjectName);
			            $("#empAdd").val(data.employeeVo.address);
			           
			            
			            $("#empBondStat").val(data.employeeVo.joinDate);
			            $("#empBondEnd").val(data.employeeVo.empBondEndDate);
			            $("#empLoc").val(data.employeeVo.empLocation);
			            $("#empMobile").val(data.employeeVo.empPhone);
			            
			            
			            $("#empSkype").val(data.employeeVo.empSkypeId);
			            $("#empDoc").val(data.employeeVo.empDouc);
			            $("#empComm").val(data.employeeVo.empComments);
			            $("#empCard").val(data.employeeVo.empCardType);
			            document.getElementById("welcometext").innerHTML="";
			         },
			         error: function(jqXHR, textStatus, errorThrown)
			         {
			        	 /* $("#welcometext").val(jqXHR.responseText); */
			             $("#empProjModu").val("");
			             $("#empDesg").val("");
			             $("#empDOB").val("");
			             $("#empDOJ").val("");
			             $("#empDORe").val("");
			             $("#empProj").val("");
			            $("#empAdd").val("");
			            $("#empBondStat").val("");
			            $("#empBondEnd").val("");
			            $("#empLoc").val("");
			            $("#empMobile").val("");
			            
			            $("#empSkype").val("");
			            $("#empDoc").val("");
			            $("#empComm").val("");
			            $("#empCard").val("");
			            document.getElementById("welcometext").innerHTML="User name is not found";
			         }
			     });
			     e.preventDefault(); //STOP default action
			     e.unbind(); //unbind. to stop multiple form submit.
			 });

});
</script>

<!-- 

$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$


 -->

<h3><center>HR E-FILE</center></h3>
<%-- <%
String eid=request.getParameter("eid");
String name=request.getParameter("name");

Statement st;
try{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance(); 
Connection con = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=C:/Documents and Settings/user/Desktop/apache-tomcat-7.0.34/webapps/hrp/DataBase/EmployeeStatus.mdb");
st = con.createStatement();
ResultSet rs = st.executeQuery("SELECT * FROM HrefTable WHERE EID='"+eid+"'");
%>
<%
while(rs.next()){
%>
 --%>
<form action="hrProfile.action" method="post">
<table align="center" width="650px">
<TR>
<TD><LABEL ><b>ENAME</b></LABEL><TD><INPUT type="text" <%-- value="<%=rs.getString("EID")%>" --%> size="20" id="employeeName">
<td><input type="submit" name="CheckUser" value="CheckUser" id="checkUserId"/></td>
<td><div id="welcometext" /></td>		
<%-- <TD><LABEL><b>EID</b></LABEL> <TD><INPUT type="text" value="<%=rs.getString("Name")%>" size="20"> --%>
</tr>

<TR>
<TD><LABEL ><b>DESIGNATION</b></LABEL><TD><INPUT type="text" id="empDesg" size="20"  >
<TD><LABEL><b>MODULE</LABEL> <TD><INPUT type="text" id="empProjModu" size="20"  >
</tr>
<TR>
<TD><LABEL ><b>DATE OF BIRTH</b></LABEL><TD><INPUT type="text" id="empDOB" size="20" >
<TD><LABEL ><b>DATE OF JOINING</b></LABEL> <TD><INPUT type="text" id="empDOJ" size="20"  >
</tr>
<TR>
<TD><LABEL ><b>DATE OF RELIEVING</b></LABEL><TD><INPUT type="text" id="empDORe" size="20"  >
<TD><LABEL ><b>PROJECT</b></LABEL> <TD><INPUT type="text" id="empProj" size="20" >
</tr>
</table>
<TABLE align="center" width="650px">

<tr>
<td><b>ADDRESS&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b>
<input type="text" id="empAdd" size="72" >
</tr>
</table>

<table align="center" width="650px">
<TR>
<TD><LABEL ><b>BOND START&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></LABEL>
<TD><INPUT type="text" id="empBondStat" size="20"  >
<TD><LABEL ><b>BOND ENDS&nbsp;&nbsp;&nbsp;&nbsp;</b></LABEL> <TD>
<INPUT type="text" id="empBondEnd" size="20"  >
</tr>

<TR>
<TD><LABEL ><b>LOCATION</b></LABEL><TD><INPUT type="text" id="empLoc" size="20" >
<TD><LABEL ><b>MOBILE</b></LABEL> <TD><INPUT type="text" id="empMobile" size="20"  >
</tr>

<TR>
<TD><LABEL ><b>SKYPE ID</b></LABEL><TD><INPUT type="text" id="empSkype" size="20" >
<TD><LABEL ><b>DOCUMENTS&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></LABEL> <TD>
<INPUT type="text" id="empDoc"  size="20"  >
</tr>
</table>
<TABLE align="center" width="650px">
<tr>
<td><b>COMMENTS&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b>
<input type="text" id="empComm" size="72" >

</tr>
</table>
<br>
<table align="center" width="650px">
<TR>
<TD><LABEL ><b>YELLOW CARD&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></LABEL><TD>
<INPUT type="text" id="empCard" size="20"  >
<TD><LABEL ><b>RED CARD&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></LABEL> <TD><INPUT type="text" <%-- value="<%=rs.getString("RedCard")%>" --%> size="20"  >
</tr>
</table>
<br>

<table align="center" width="650px">
<TR>
<TD><LABEL >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</LABEL><TD>
<INPUT type="submit" <%-- value="<%=rs.getString("YellowCard")%>" --%>  id="hrEfileSub" value="ClickHere">
<TD><LABEL >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></LABEL> 
<TD><INPUT type="submit" <%-- value="<%=rs.getString("RedCard")%>" --%>  name="hrEfileCancel" value="CancelHere">
</tr>
</table>

<%-- <%
}
%>

<%
}

catch(Exception e){
e.printStackTrace();
}
%> --%>
</form>