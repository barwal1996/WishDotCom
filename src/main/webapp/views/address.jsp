<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    

<%@ page language="java" import="com.niit.tlc.model.Customer"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Billing Address</title>
        <!-- Font Awesome icons (free version) -->
<link href="<c:url value="/resources/static/css/all.min.css"/>"
	rel="stylesheet" />
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- Tempusdominus Bbootstrap 4 -->
<link
	href="<c:url value="/resources/static/css/tempusdominus-bootstrap-4.min.css"/>"
	rel="stylesheet" />

<link href="<c:url value="/resources/static/css/fontawesome.min.css"/>"
	rel="stylesheet" />
<!-- iCheck -->
<link
	href="<c:url value="/resources/static/css/icheck-bootstrap.min.css"/>"
	rel="stylesheet" />

<!-- Theme style -->
<link href="<c:url value="/resources/static/css/adminlte.min.css"/>"
	rel="stylesheet" />
<!-- overlayScrollbars -->
<link
	href="<c:url value="/resources/static/css/OverlayScrollbars.min.css"/>"
	rel="stylesheet" />

<!-- Google Font: Source Sans Pro -->
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700"
	rel="stylesheet">
       <link href="<c:url value="/resources/static/style/bootstrap.min.css" />"rel="stylesheet">  
<link href="<c:url value="/resources/static/css/address.css"/>" rel="stylesheet" >
</head>
<body class="page" >
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand js-scroll-trigger" href="index">Start
				WishStore</a>
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto my-2 my-lg-0">
				<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="/loginCustomer">Home</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#about">About</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#">Product</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#services">Services</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="tempdata">Contact</a></li>
					<li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          My Account
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="viewDetails">View Profile</a>
          <a class="dropdown-item" href="update">Update Profile</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="customerDashboard">View Dashboard</a>
        </div>
      </li>

					<li class="nav-item">
						<a class="nav-link js-scroll-trigger" href="logout">Log out <%
out.print(request.getSession().getAttribute("user"));
%></a>
					</li>

				</ul>
			</div>
		</div>
	</nav>


	

	<!-- Content Wrapper. Contains page content -->
	<div class="container">

      
<div  class="address">
<h1>Enter Billing Address</h1>
<form id="addressform" action="saveAddress" method="post" modelAttribute="address">



<p class="contact"><label for="houseNumber">House No.</label></p>
<input type="text" id="houseno"  name="houseNumber" placeholder="House number" tabindex="1" type="text">


<p class="contact"><label for="city">City</label></p>
<input id="city"  name="city" placeholder="City" tabindex="2" type="text" >

<p class="contact"><label for="pincode">Pincode</label></p>
<input type="number" id="pincode"  name="pincode" placeholder="Pincode" tabindex="3" type="text">

<p class="contact"><label for="state">State</label></p>
<input type="text" id="state" name="state" tabindex="4" >

<%
Customer s=(Customer)request.getSession().getAttribute("userCust");

%>

<input type="hidden" name="customerid"  path="customer" value="<%=s.getPhoneNo() %>" >

<br>
<input class="button" name="submit" id="submit" tabindex="5" value="Submit!" type="submit"> 
</form>
</div>

</div>




 <footer class="main-footer">
    <strong>Copyright &copy; 2020 <a href="#">WishDotCom</a>.</strong>
    All rights reserved.
   <style>
.main-footer {
  position: fixed;
   right:1px;
  bottom: 0;
  width: 100%;
  background-color: black;
  color: white;
  text-align: center;
}
</style>
  </footer>
</body>
</html>