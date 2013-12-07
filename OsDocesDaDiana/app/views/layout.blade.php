<!DOCTYPE html>
<html>
	<head>
		<title>Os Doces da Diana</title>
											
		<link rel="shortcut icon" href="{{ asset('assets/images/favicon.ico'); }}"/>
		<link rel="stylesheet" type="text/css" href="{{ asset('assets/styles/newstyle.css'); }}" />
		<script type="text/javascript" src="{{ asset('assets/scripts/flexcroll.js'); }}"></script>
		<script type="text/javascript" src="{{ asset('assets/scripts/newfunctions.js'); }}"></script>

		<!-- WOWSLIDER -->
		<link rel="stylesheet" type="text/css" href="{{ asset('assets/scripts/engine1//style.css'); }}" media="screen" />
		<script type="text/javascript" src="{{ asset('engine1//jquery.js'); }}"></script>
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