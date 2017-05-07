<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.HashMap" %>
    <%
	    HashMap<String,String> users = new HashMap<String,String>();
		users.put("qwerty","123");
		users.put("asd", "345");
    	String status = request.getParameter("status");
    	String username="";
    	int opStat = 0;
    	if(status!=null)	{
    		if(status.equals("2"))
    			session.invalidate();
    		else{
	    		username = request.getParameter("username");
	    		String password = request.getParameter("password");
	    		if(!users.containsKey(username))	{
	    			opStat = 1;
	    		}
	    		else if(users.containsKey(username))	{
	    			if(!users.get(username).equals(password))	{
	    				opStat = 2;
	    			}
	    			else if(users.get(username).equals(password))	{
	    				session.setAttribute("user", username);
	    				response.sendRedirect("DataCapture.jsp");
	    			}
	    		}
    		}
    	}
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

	</style>

</head>

<body>

	<div class="container">
        <div class="jumbotron">
            <div class="container">
                <form class="form-horizontal" method="get">
                    <fieldset>
					<input type="hidden" value="1" name="status"/>
                    <!-- Form Name -->
                    <legend class="text-center">Login</legend>
                    <%if(opStat == 1){ %>
					<div class="alert-danger col-xs-4 text-center col-xs-push-4">Invalid Username</div>
					<%}else if(opStat == 2){ %>
					<div class="alert-danger col-xs-4 text-center col-xs-push-4">Wrong password</div>
					<%}%>
					<hr>
                    <!-- Text input-->
                    <div class="form-group">
                      <label class="col-md-4 control-label" for="username">Username</label>  
                      <div class="col-md-4">
                      <input id="username" name="username" type="text" placeholder="username" class="form-control input-md" required="" <%if(opStat == 2) out.print("value="+username); %>>
                      <span class="help-block">Enter User Name</span>  
                      </div>
                    </div>

                    <!-- Password input-->
                    <div class="form-group">
                      <label class="col-md-4 control-label" for="password">Password</label>
                      <div class="col-md-4">
                        <input id="password" name="password" type="password" placeholder="password" class="form-control input-md" required="">
                        <span class="help-block">Enter Password</span>
                      </div>
                    </div>
                        <!-- Button -->
                    <div class="form-group">
                      <label class="col-md-4 control-label" for="login"></label>
                      <div class="col-md-4">
                            <button id="login" name="login" class="btn btn-primary">Login</button>
                        </div>
                    </div>
                    </fieldset>
                </form>
            </div>
        </div>
	</div>

	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

	<script>
	</script>

</body>

</html>