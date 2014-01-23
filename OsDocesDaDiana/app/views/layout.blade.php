<!DOCTYPE html>
<html>
	<head>
		<title>Os Doces da Diana</title>

		<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
		<link rel="shortcut icon" href="assets/images/favicon.ico" />

		<link rel="stylesheet" type="text/css" href="assets/styles/newstyle.css" />
		<link rel="stylesheet" type="text/css" href="assets/styles/bootstrap.css">
		<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
		<script type="text/javascript" src="../js/bootstrap.min.js"></script>
		<link rel="stylesheet" type="text/css" href="assets/slide/style.css" media="screen" />
		<script type="text/javascript" src="assets/slide/jquery.js"></script>
		<script type="text/javascript" src="assets/scripts/flexcroll.js"></script>
		<script src="assets/scripts/bootstrap.js"></script>
		<script type="text/javascript">
			$(function(){
				$(".dropdown-toggle").dropdown();
			});  
		</script>
		
		<script language='javascript' type='text/javascript'>
			if (top != self) {
			top.location.href = location.href;
			}
		</script>	
	</head>
	
	<body>
		<header>
			@yield('headerbar');
		</header>

		<div id="content">
			@yield('content')
		</div>
	</body>
</html>