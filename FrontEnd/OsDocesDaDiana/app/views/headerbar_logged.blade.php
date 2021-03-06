@section('headerbar_logged')

<div id="topBar">
	<div class="center">
	<div class="topNav">

	<a class="avatar"><img src="{{ asset(Auth::user()->avatar); }}"></a>
			<form method="post" id="logoutForm">
			
			<input type="hidden" name="logout" value="true">
			<!--	<a href="javascript:;" onclick="$(&#39;form#logoutForm&#39;).submit(); return false;" title="Sair"></a>-->
			</form>
		<div class="opts">
			<div class="to-right">
					<a class="icon"><?php echo 'Bem-vindo '.Auth::user()->nome  ;?></a><span class="pipe"></span>
					<?php echo link_to('perfil','A minha Conta', array('class'=>'myAccount')); ?>
					<!--<span class="pipe"></span>
					<a href="http://www.wareztuga.tv/notifications.php" class="notifsslctd"><span class="icon"></span><span>7</span> Notificações</a>
					<a href="http://www.wareztuga.tv/account.php?action=faved" class="faves"><span class="icon"></span><span>6</span> Favoritos</a>
					<a href="http://www.wareztuga.tv/account.php?action=cliped" class="agends"><span class="icon"></span><span>0</span> Agendados</a>-->
					<span class="pipe"></span>
					
					<?php echo link_to('logout','Sair', array('class'=>'myAccount')); ?>
					<!--<a href="http://www.wareztuga.tv/account.php" class="username">98jigs</a>-->
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