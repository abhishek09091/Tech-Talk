<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Tech Talk Form</title>

        <!-- CSS -->
		<link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:400,300,600">
        <link rel="stylesheet" href="assests/assets/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="assests/assets/css/form-elements.css">
        <link rel="stylesheet" href="assests/assets/css/style.css">
		
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="assets/assets/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assests/assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assests/assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assests/assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="assests/assets/ico/apple-touch-icon-57-precomposed.png">
		<style>
		span#sizing-addon1 {
    font-size: larger;
    height: 49px;
}
		</style>
		<style>
	.input-append .add-on:last-child, .input-append .btn:last-child, .input-append .btn-group:last-child>.dropdown-toggle {
    -webkit-border-radius: 0 4px 4px 0;
    -moz-border-radius: 0 4px 4px 0;
    border-radius: 0 4px 4px 0;
    height: 50px;
    font-size: smaller;
}
		</style>
		 
    
 <script type="text/javascript"
     src="http://cdnjs.cloudflare.com/ajax/libs/jquery/1.8.3/jquery.min.js">
    </script> 
    </head>

    <body>

		<!-- Top content -->
        <div class="top-content">
        	
            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <h1 style="color:#000;">Tech Talk Form</h1>
                            <div class="description">
                            	<p style="color:#000;">
	                            	We need technology in every classroom and in every student and teachers hand, because it is the pen and paper of our time, and it is the lens through which we experience much of our world.
	                            	            <p style="color:#000"> - David Warlick </p>
                            	</p>
                            </div>
                        </div>
                    </div> 
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                        	<div class="form-top">
                    			<h3>Tech Talk Form</h3>
                        		<p>Fill in the for Tech Talk</p>
                            </div>
                            <div class="form-bottom contact-form">
			                    <form role="form" action="addtechtalk" method="post">
									<div class="form-group">
			                    		<label class="sr-only" for="title">Title</label>
			                        	<input type="text" name="title" placeholder="Title of Tech Talk..." class="contact-email form-control" id="contact-email">
			                        </div>
			                    	<div class="form-group">
			                    		<label class="sr-only" for="speaker">Speaker</label>
			                        	<input type="text" name="speaker" placeholder="Speaker Name..." class="contact-email form-control" id="contact-email">
			                        </div>
									
									<div id="datetimepicker4" class="input-append form-group">
									<input data-format="yyyy-MM-dd" type="text"  name="techTalkDate" placeholder="Tech Talk Date..."></input>
									<span class="add-on mychange"  id="sizing-addon1">
									<i class="fa fa-calendar fa-th-large" aria-hidden="true"></i>
									</i>
									</span>
									</div>
									
									
									<!--<div id="datetimepicker3" class="input-append form-group">
										<input data-format="hh:mm:ss" type="text" name="techTalkStartTime" placeholder="Tech Talk Start Time..."></input>
										<span class="add-on">
												<i class="fa fa-clock-o" aria-hidden="true"></i>
										</span>
									</div>
								
									<div id="datetimepicker5" class="input-append form-group">
										<input data-format="hh:mm:ss" type="text" name="techTalkEndTime" placeholder="Tech Talk End Time..."></input>
										<span class="add-on">
												<i class="fa fa-clock-o" aria-hidden="true"></i>
										</span>
									</div>
-->
			                        <div class="form-group">
			                        	<label class="sr-only" for="contact-message">Description</label>
			                        	<textarea name="description" placeholder="Description about Tech Talk..." class="contact-message form-control" id="contact-message"></textarea>
			                        </div>
			                        <button class="btn btn-info btn-block login" name="LOGIN"  type="submit">Add Tech Talk</button>
			                    </form>
		                    </div>
                        </div>
                    </div>
                </div>
            </div>
            
        </div>


        <!-- Javascript -->
		
		
		<script type="text/javascript">
  $(function() {
    $('#datetimepicker4').datetimepicker({
      pickTime: false
    });
  });
</script>
	<script type="text/javascript">
  $(function() {
    $('#datetimepicker3').datetimepicker({
      pickDate: false
    });
  });
</script>	
<script type="text/javascript">
  $(function() {
    $('#datetimepicker5').datetimepicker({
      pickDate: false
    });
  });
</script>
		
       
      
    <script type="text/javascript"
     src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/js/bootstrap.min.js">
    </script>
    <script type="text/javascript"
     src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.min.js">
    </script>
    <script type="text/javascript"
     src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.pt-BR.js">
    </script>
        <script src="assests/assets/js/jquery.backstretch.min.js"></script>
        <script src="assests/assets/js/scripts.js"></script>
        
        <!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->

    </body>

</html>