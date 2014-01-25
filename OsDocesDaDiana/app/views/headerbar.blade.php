@section('headerbar')
	<div id="topBar">
		<div class="center">
			<div class="topNav">
				<div class="opts">
					<div class="to-right">
						<?php echo link_to('login','Login | Registar', array('class'=>'myAccount')); ?>
					</div>
				</div>
			</div>
		</div>
	</div>

			
	<!-- BARRA PRETA -->						
	<nav>
		<div class="center">
			<div class="mainNav">
				<div id="logo" class="logo" title="Página Inicial"><?php echo link_to('/',''); ?></div>
					<ul>
						<li class="first">
							<?php echo link_to('categorias','Categorias', array('class'=>'movies')); ?>							
						</li>
						<li class="">
							<?php echo link_to('listachefs','Chefs', array('class'=>'mm')); ?>
						
						</li>
						<li class="last">
							<?php echo link_to('sobrenos','Sobre Nós', array('class'=>'news')); ?>
						</li>
					</ul>

				<div class="box-search">
					<form action="javascript: search('movies', 0);" method="post" id="movies-searchForm" onsubmit="if(($('#movies-searchForm input#searchBox').attr('defaultText') == $('#movies-searchForm input#searchBox').val()) || ($('#movies-searchForm input#searchBox').val() == '')) return false;">
						<input type="text" name="searchBox" id="searchBox" value="Pesquise por uma receita" onfocus="vfocus(this, 'Pesquise por uma receita');" onblur="vblur(this, 'Pesquise por uma receita');" defaulttext="Procure aqui um filme" />
						<a href="javascript:;" class="search-btn" onclick="$('#movies-searchForm').submit();"><span></span></a>
					</form>
				</div>
			</div>
		</div>
	</nav>

	<!-- BARRA PRETA -->
	<div class="clear"></div>

@stop