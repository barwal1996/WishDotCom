<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<%@ page language="java" import="com.niit.tlc.model.Customer"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product List</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Font Awesome -->
<link href="<c:url value="/resources/static/css/styles.css"/>"
	rel="stylesheet" />

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
</head>
<body class="page" background-color="#d7f7a3">
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

		
<%
String usersess=(String)request.getSession().getAttribute("user");
 pageContext.setAttribute("usersess", usersess);
%>

		<c:if test="${usersess!=null}">
					<li class="nav-item">
						<a href="logout">Log out <%
out.print(request.getSession().getAttribute("user"));
%></a>
					</li>		
</c:if>		

				</ul>
			</div>
		</div>
	</nav>
	

  <div class="container">
    




<h1><strong>Product List</strong></h1>
<style>
#product {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#product td, #product th {
  border: 1px solid #ddd;
  padding: 8px;
}

#product tr:nth-child(even){background-color: #f2f2f2;}

#product tr:hover {background-color: #ddd;}

#product th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
</style>

    <table id="product" class="table table-info "border="1" cellpadding="10">
    <caption></caption>
        <thead class="table table-sm table-dark">
            <tr >
                <th  scope="col">Product ID</th>
                <th  scope="col">Looks</th>
                <th  scope="col">Name</th>
                <th  scope="col">Brand</th>
                <th  scope="col">Price</th>
                <th  scope="col">Product Description</th>
                <th  scope="col">Action</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${listproducts}" var="product">
        
 <%-- <%
String usersess=(String)request.getSession().getAttribute("user");
%> --%>
<% 
String k=null;
if(usersess!=null){
	k=usersess;
}
else{
	k=null;
}
%>
         <!-- construct an "update" link with customer id -->
							<c:url var="buyNow" value="buyproduct">
								<c:param name="id" value="${product.productId}" />
								<c:param name="prodPrice" value="${product.productPrice}" />
								<c:param name="prodName" value="${product.productName}" />
								
							</c:url>

					
            <tr>
                <td  scope="col">${product.productId}</td>
                <td  scope="col"><img src="/resources/static/productimages/${product.fileLocation}"></td>
                <td  scope="col">${product.productName}</td>
                <td  scope="col">${product.productBrand}</td>
                <td  scope="col">${product.productPrice}</td>
                <td  scope="col">${product.productDescription}</td>
                <td  scope="col">
                   	<!-- display the update link --> 
                   	<c:if test="${usersess==null}">
									<a class="btn btn-primary" href="LoginPage" role="button">Login To Buy</a>
								</c:if>
                
                
                  <c:if test="${usersess!=null}">
									<a class="btn btn-primary" href="${buyNow}" role="button">Buy Now</a>
								</c:if>
								
                </td>
                
            </tr>
             </c:forEach>
        </tbody>
    </table>
    </div>
  
    
   
    


<%-- <% String pid=request.getParameter("id");
   request.getSession().setAttribute("prdtid", pid);
   
   String pprice=request.getParameter("prodPrice");
   request.getSession().setAttribute("prodPrice", pprice);
   
   String pname=request.getParameter("prodName");
   request.getSession().setAttribute("prodName", pname);
%>		 --%>

<input type="hidden" name="usersess" value="hello">
<%-- <c:forEach items="${listproducts}" var="prod">
    
      <h1>  ${prod.productId} </h1> --%>
        <%-- <c:forEach items="${branch.users}" var="user">
            <td>${user.first_name}</td>
        </c:forEach>  --%>        
   
<%-- </c:forEach> --%>
 </div>
 </section>
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