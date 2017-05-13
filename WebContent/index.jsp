<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Simple Login and Signup Form </title>
<!-- custom-theme -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Simple Login and Signup Form web template Responsive, Login form web template,Flat Pricing tables,Flat Drop downs  Sign up Web Templates, Flat Web Templates, Login sign up Responsive web template, SmartPhone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //custom-theme -->
<link href="assests/css/style25.css" rel="stylesheet" type="text/css" media="all" />
<!-- js -->

<script src="assests/js/jquery-1.9.1.min.js"></script>
<script src="assests/js/jquery-2.1.4.min.js"></script>
<script src="assests/js/jquery.vide.min.js"></script>
<!--// js -->
<link rel="stylesheet" type="text/css" href="assests/css/easy-responsive-tabs.css " />
 <link href="//fonts.googleapis.com/css?family=Questrial" rel="stylesheet">
</head>
<body class="bg agileinfo " data-vide-bg="assests/video/social2" >
   <h1 class="agile_head text-center">ATMECS Tech-Talk</h1> 
  <h3 class="agile_head text-center" style="color:#fff">${info}</h3>
   <div class="w3layouts_main wrap"  >
    
    <!--Horizontal Tab-->
        <div id="parentHorizontalTab_agile">
            <ul class="resp-tabs-list hor_1">
                <li>LogIn</li>
                <li>SignUp</li>
            </ul>
            <div class="resp-tabs-container hor_1">
               <div class="w3_agile_login">
                    <form action="./login" method="post" class="agile_form">
                     <p>Email</p>
					  <input type="email" name="employeeEmail"  placeholder="Your Email" pattern="^[a-z]+@atmecs.com"  value="" required="required"/>
					  <p>Password</p>
					  <input type="password" class="password" name="employeePassword"  placeholder="Your Password" pattern="^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$" required="required" />
					  
					  <input type="submit" value="LogIn" class="agileinfo" />
					</form>
					 
                    
                </div>
                <div class="agile_its_registration">
                    <form action="./signup" method="post" class="agile_form">
					  <p>Username</p>
					  <input type="text" name="employeeName" placeholder="Your Name" required="required" />
					  <p>Email</p>
					  <input type="email" name="employeeEmail"  placeholder="Your Email" pattern="^[a-z]+@atmecs.com"  value="" required="required"/>
					  
					  <p>Password</p>
					  <input type="password" name="employeePassword" id="password1" placeholder="Your Password" pattern="^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$" required="required" />
					  <p>Confirm Password</p>
					  <input type="password" name="employeePassword1" id="password2" placeholder="Re-Enter Your Password" pattern="^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$" required="required" />
         	  			
					   <input type="submit" value="Signup"/>
					   <input type="reset" value="Reset" />
					</form> 
				</div>
            </div>
        </div>
		 <!-- //Horizontal Tab -->
    </div>
	<div class="agileits_w3layouts_copyright text-center">
			<p>� 2017 ATMECS Tech Talk Portal. All rights reserved | Design by <a href="//atmecs.com">Abhishek Tripathi and Vaibhav Singh</a></p>
	</div>
<!--tabs-->
<script src="assests/js/easyResponsiveTabs.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	//Horizontal Tab
	$('#parentHorizontalTab_agile').easyResponsiveTabs({
		type: 'default', //Types: default, vertical, accordion
		width: 'auto', //auto or any width like 600px
		fit: true, // 100% fit in a container
		tabidentify: 'hor_1', // The tab groups identifier
		activate: function(event) { // Callback function if tab is switched
			var $tab = $(this);
			var $info = $('#nested-tabInfo');
			var $name = $('span', $info);
			$name.text($tab.text());
			$info.show();
		}
	});
});
</script>
<script type="text/javascript">
		window.onload = function () {
			document.getElementById("password1").onchange = validatePassword;
			document.getElementById("password2").onchange = validatePassword;
		}
		function validatePassword(){
			var pass2=document.getElementById("password2").value;
			var pass1=document.getElementById("password1").value;
			if(pass1!=pass2)
				document.getElementById("password2").setCustomValidity("Passwords Don't Match");
			else
				document.getElementById("password2").setCustomValidity('');	 
				//empty string means no validation error
		}

</script>
<!-- js -->

<!-- //js -->
<!--//tabs-->
</body>
</html>
