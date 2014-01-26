<!DOCTYPE html>
<html>
	<head>
		<title>Os Doces da Diana</title>



		<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>

		<link rel="stylesheet" type="text/css" href="{{ asset('assets/styles/newstyle.css'); }}">
		<link rel="stylesheet" type="text/css" href="{{ asset('assets/styles/bootstrap.css'); }}">
		<script type="text/javascript" src="{{ asset('assets/scripts/newfunctions.js'); }}"></script>
		<script type="text/javascript" src="{{ asset('assets/scripts/jquery.min.js'); }}"></script>
		<link rel="stylesheet" type="text/css" href="{{ asset('assets/slide/style.css'); }}" media="screen" />
		<script type="text/javascript" src="{{ asset('assets/slide/jquery.js'); }}"></script>
		<script type="text/javascript" src="{{ asset('assets/scripts/flexcroll.js'); }}"></script>
		<script src="{{ asset('assets/scripts/bootstrap.js'); }}"></script>

		<!-- PARA QUE SERVE ISTO-->
		<script type="text/javascript" src="../js/bootstrap.min.js"></script>

	</head>
	
	<body>
		<header>
		<?php if(Auth::check()) { ;?>
				@yield('headerbar_logged')
		<?php } else { ;?>
				@yield('headerbar_guest')
		<?php	} ;?>	
		</header>

		<div id="content">
			@yield('content')
		</div>
		
		<footer>
			@yield('footer');
		</footer>	

	</body>
</html>