<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.iwinner.belk.hrportal.form.EmployeePrimaryVO" %>
<%-- <%
	String utyp = request.getParameter("usertyp");
	String uid = request.getParameter("loggedid");
%>
 --%>

<%

EmployeePrimaryVO employeeVo=(EmployeePrimaryVO)request.getAttribute("employeeVO");

%>
<html><head><title>Profile Page</title>
<body bgcolor="#ffcc99">
<script type="text/javascript">
tmonth=new Array("JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC");
 
function GetClock(){
d = new Date();
nday   = d.getDay();
nmonth = d.getMonth();
ndate  = d.getDate();
nyear = d.getYear();
if(nyear<1000) nyear=nyear-100;


document.getElementById('clockbox').innerHTML=""+ndate+"-"+tmonth[nmonth]+"-"+nyear+"";
setTimeout("GetClock()", 1000);
}
window.onload=GetClock;
</script>
<script type="text/javascript">
function func(a){
url="ProfilePage.jsp"
window.open(
		url,'popUpWindow','height=250,width=500,left=50,top=30,resizable=no,scrollbars=no,toolbar=yes,menubar=no,location=no,directories=no,status=yes')
}
</script>
<b><div id="clockbox"></div></b>
<p><div align="right"> <img src="${pageContext.request.contextPath}/images/unii.jpg" width="10%" height="5%"></div></p>
<hr noshade size="2" color="black">

<%-- <%
String eid=uid;



Statement st;
try{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
 Connection con = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=C:/Documents and Settings/user/Desktop/apache-tomcat-7.0.34/webapps/hrp/DataBase/EmployeeStatus.mdb"); 
String query = "SELECT * FROM HrefTable WHERE EID='"+eid+"'";
st = con.createStatement();
ResultSet rs = st.executeQuery(query);
%>
<%
while(rs.next()){
%>
 --%>

<p style="margin-left:220px; font-style:italic;"><b>At  <%=employeeVo.getEmpLocation()%> On <%=employeeVo.getEmpProjectName()%>  Project</b></p>

<table style="margin-left:30px;">
<tr>
<th>
<img src='<%=employeeVo.getEmpImgLocation()%>'  style="float:left; position:relative; top:-15px;" border="1" onClick="func('Hello')" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<img src="${pageContext.request.contextPath}/images/phone.jpg" border="1" style="width:15px; height:30px"/>&nbsp;&nbsp;&nbsp;
<input type="text" name="name" value='<%=employeeVo.getEmpPhone()%>'  readonly/><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<img src="${pageContext.request.contextPath}/images/mail.png" border="1" style="width:15px; height:20px" />&nbsp;&nbsp;&nbsp;
<input type="text" name="name" value='<%=employeeVo.getEmpEmail()%>' readonly/>
</th></tr>
<tr><td><%-- <%=rs.getString("Name")%> --%><input type="radio" checked="checked" /></td></tr>
<%-- <%
}
%>
<%
}
catch(Exception e){
e.printStackTrace();
}
%>
 --%>
</table>


<hr noshade size="2" color="black" >
<table style="margin-left:50px;">
<tr>
<th>VIEW&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>

<th>ENTER</th>
</tr>
<tr>
<input type="hidden" name="empUserName" value='<%=employeeVo.getEmpName()%>' id="empUserName" />

<th><br><input type="submit" style="height: 25px; width: 180px" value="HR E FILE" onclick="return viewhref();"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>

<th><br><input  type="submit" style="height: 25px; width: 180px"  value="PMO REPORT" /></th>

</tr>
<tr>
<th><br><input type="submit" style="height: 25px; width: 180px" value="ATTENDENCE REPORT" onclick="return viewAnuualrpt('');"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>

<th><br><input type="submit" style="height: 25px; width: 180px" value="CHANGE PASSWORD" onclick="return changepwd('');"/></th>
</th>
</tr>

<tr>
<th><br><input type="submit" style="height: 25px; width: 180px" value="PMO REPORT" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
</tr>
</table>

<form name="AttndProfileForm" method="post" action="/hrp/servlet/ViewAnnualRptServlet">
<input type="hidden" name="eid" id="eid" value=""/>
<input type="hidden" name="yer" id="yer" value="Profile"/>
</form>

</body>
<script type="text/javascript">
function viewAnuualrpt(eid)
{		
	var d1 = new Date();
	var curr_year = d1.getFullYear();

	document.getElementById('eid').value = eid;	
	document.getElementById('yer').value = curr_year;	
	document.AttndProfileForm.action  ='/hrp/servlet/ViewAnnualRptServlet';
    document.AttndProfileForm.submit();

}
function viewhref()
{		
	alert("button Clicked");
    document.AttndProfileForm.action='hrForm.action';
    //empUserName
    document.AttndProfileForm.submit();
    
}
function changepwd(eid)
{		
	
	<%-- document.getElementById('eid').value =<%=employeeVo.getEmpName()%>;; --%>	
	document.AttndProfileForm.action='ChangePwd.action';
    document.AttndProfileForm.submit();

}
function openPage(pageURL)
{
	window.location.href = pageURL;
}


</script>
</html>