
@section('headerbar')
	<div id="topBar">
		<div class="center">
			<div class="topNav">
				<div class="opts">
        			<div class="to-right">
						<a href="login.html" class="myAccount">Login | Registar</a>
					</div>
				</div>
			</div>
		</div>
	</div>
			
	<!-- BARRA PRETA -->						
	<nav>
		<div class="center">
			<div class="mainNav">
				<div id="logo" class="logo"><a href="index-2.html"></a></div>
							<!--
							Christmas Logo
							<a href="index.php" class="christmas" onmouseover="$('nav div.mainNav div#logo a').addClass('hover');" onmouseout="$('nav div.mainNav div#logo a').removeClass('hover');"></a>-->

				<ul>
					<!--<li class="first"><a href="index.php" class="home slctd">Entrada</a></li>-->
					<li class="first "><a href="categorias.html" class="movies ">Categorias</a></li>
					<li class=""><a href="#" class="series ">Novidades</a></li>
					<li class="last"><a href="listachefs.html" class="news ">Chefs</a></li>
				</ul>

				<div class="box-search">
					<form action="javascript: search('movies', 0);" method="post" id="movies-searchForm" onsubmit="if(($('#movies-searchForm input#searchBox').attr('defaultText') == $('#movies-searchForm input#searchBox').val()) || ($('#movies-searchForm input#searchBox').val() == '')) return false;">
					<input type="text" name="searchBox" id="searchBox" value="Pesquise por uma receita" onfocus="vfocus(this, 'Procure aqui um filme');" onblur="vblur(this, 'Procure aqui um filme');" defaulttext="Procure aqui um filme" />
					<a href="javascript:;" class="search-btn" onclick="$('#movies-searchForm').submit();"><span></span>
					</a>
					</form>
				</div>
			</div>
		</div>
	</nav>

	<!-- BARRA PRETA -->
	<div class="clear"></div>

@stop