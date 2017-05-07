<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*" %>
    <%
    	String user = (String)session.getAttribute("user");
    	if(user == null)
    		response.sendRedirect("index.jsp");
    	Date date = new Date();
    %>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" media="screen" href="css/bootstrap.min.css">

	<title>Income Tax Calculator</title>

	<!--  -->

	<style>
	body{padding-bottom:50px}
	</style>

</head>

<body>

	<div class="container">
		
        <div class="jumbotron">
	<div class="container text-center">
		<h2> Welcome <%=user %></h2>
		<h3>Date: <%=date.toString() %></h3>
	</div>
	</div>
        <div class="jumbotron">
	<div class="container">
		<form class="form-horizontal" action="CalculateTax.jsp">
            <fieldset>

            <!-- Form Name -->
            <legend>Fill In Details</legend>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="name">Name</label>  
              <div class="col-md-4">
              <input id="name" name="name" type="text" placeholder="Will Smith" class="form-control input-md" required="">

              </div>
            </div>

            <!-- Multiple Radios (inline) -->
            <div class="form-group">
              <label class="col-md-4 control-label" for="gender">Gender</label>
              <div class="col-md-4"> 
                <label class="radio-inline" for="gender-0">
                  <input type="radio" name="gender" id="gender-0" value="male" checked="checked">
                  Male
                </label> 
                <label class="radio-inline" for="gender-1">
                  <input type="radio" name="gender" id="gender-1" value="female">
                  Female
                </label>
              </div>
            </div>

            <!-- Select Basic -->
            <div class="form-group">
              <label class="col-md-4 control-label" for="org">Organization</label>
              <div class="col-md-4">
                <select id="org" name="org" class="form-control">
                  <option value="google">Google</option>
                  <option value="apple">Apple</option>
                  <option value="ms">Microsoft</option>
                  <option value="tcs">TCS</option>
                  <option value="wipro">Wipro</option>
                  <option value="cog">Cognizant</option>
                  <option value="dell">Dell</option>
                  <option value="hp">HP</option>
                  <option value="infy">Infosys</option>
                </select>
              </div>
            </div>
             <!-- Number input-->
                    <div class="form-group">
                      <label class="col-md-4 control-label" for="salary">Salary</label>  
                      <div class="col-md-4">
                      <input id="salary" name="salary" type="number" placeholder="Salary" class="form-control input-md" required="">                      
                      </div>
                    </div>
			   <!-- Button -->
                    <div class="form-group">
                      <label class="col-md-4 control-label" for="submit"></label>
                      <div class="col-md-4">
                            <button id="submit" name="submit" class="btn btn-primary">Calculate Tax</button>
                        </div>
                    </div>
            </fieldset>
        </form>

	</div>
</div>
<%
	if(session.getAttribute("name") != null)	{
		String name = (String)session.getAttribute("name");
		String gender = (String)session.getAttribute("gender");
		String org = (String)session.getAttribute("org");
		double salary = (Double)session.getAttribute("salary");
		double incomeTax = (Double)session.getAttribute("it");
		double percent = (Double)session.getAttribute("percent");
		
	
%>
	<div class="jumbotron">
	<div class="container text-center">
		<h2> Income Tax</h2>
		<p>
			Name: <%=name %><br/>
			Gender: <%=gender %><br/>
			Organization: <%=org %><br/>
			Salary: <%=salary %><br/>
			Income Tax: <%=incomeTax %><br/>
			Percentage: <%=percent %>%<br/>
		</p>
	</div>
	</div>
	<%} %>
	<a class="btn btn-danger btn-lg" href="index.jsp?status=2">Logout</a>
	</div>

	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

	<script>
	</script>

</body>

</html>
