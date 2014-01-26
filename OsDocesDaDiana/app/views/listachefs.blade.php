@extends('layout')

<?php if(Auth::check()) { ;?> 
	@include('headerbar_logged')
<?php } else { ;?> 
	@include('headerbar_guest')
<?php } ;?>

@section('content')
<div class="center">					
	<div id="news-box" class="content-box">
		<div class="movies-order" style="margin-top: 30px; margin-left: 23px;">
			<div class="movies-order-caption">Ordernar por:
				<a href="#">Nome</a>
				<!--<a href="javascript: ajaxRequestGET('news.ajax733c.html?p=1&amp;order=date', $('#news-box')); setOrderBy('news', 'date');" style="">Nome</a> | 
				<a href="javascript: ajaxRequestGET('news.ajaxa94b.html?p=1&amp;order=name', $('#news-box')); setOrderBy('news', 'name');" style="">Pontuação</a> | 
				<a href="javascript: ajaxRequestGET('news.ajaxa6cf.html?p=1&amp;order=views', $('#news-box')); setOrderBy('news', 'views');" style="">Número de Receitas Publicadas</a>
				<a href="javascript: ajaxRequestGET('news.ajaxaf79.html?p=1&amp;order=msgs', $('#news-box')); setOrderBy('news', 'msgs');" style="">...</a>-->
			</div>
			<input type="hidden" value="" id="news-order" />
		</div>
		
		<!-- Mostra os números de página
		<div id="pagination" class="pagination" style="margin-top: 25px;">
			<div class="pagination-aux">
				<a href="#" onclick="return false;" class="actual">1</a><a href="javascript: ajaxRequestGET('news.ajax905b.html?p=2', $('#news-box'));">2</a><a href="javascript: ajaxRequestGET('news.ajax2207.html?p=3', $('#news-box'));">3</a><span>...</span><a href="javascript: ajaxRequestGET('news.ajax42dc.html?p=6', $('#news-box'));">6</a>
			</div>
		</div>
		-->

		<!-- A pág expande mas tinha só 4 por página -->

		<div id="news-list" class="news-list">
			@foreach( $users as $user )
			<div class="clear"></div>
				<div class="item">
					<div class="new-image">
						<img src="{{ $user->avatar }}" height="180" width="180">
					</div>
				<div class="new-info">
					<div class="title"> {{ $user->nome }}</div>
					<div class="new-type"><a href="#">Visitar Perfil</a></div>
					<div class="clear"></div>
					<div class="divider"></div>
					<div class="body"> {{$user->descricao}} </div>
					<div class="divider" style="margin-top: 15px;"></div>
					<div class="new-details">
						<div class="comments">Pontuação de {{ $user->valoravaliacoes }} estrelas</div>
						<div class="comments">Seguido por <span>10</span> chefs (N.D.)</div>
						<div class="comments"> {{ $user->nrreceitas }} Receitas próprias</div>
					</div>
				</div>
				</div>
			@endforeach

<!--<div id="pagination" class="pagination" style="margin-top: 5px; margin-bottom: 25px;">
	<div class="pagination-aux">
	<a href="#" onclick="return false;" class="actual">1</a>
	<a href="javascript: ajaxRequestGET('news.ajax905b.html?p=2', $('#news-box'));" onclick="paginationScroll();">2</a>
	<a href="javascript: ajaxRequestGET('news.ajax2207.html?p=3', $('#news-box'));" onclick="paginationScroll();">3</a>
	<span>...</span>
	<a href="javascript: ajaxRequestGET('news.ajax42dc.html?p=6', $('#news-box'));" onclick="paginationScroll();">6</a>
	</div>
</div> -->

	</div>
</div>
<div class="main-separator"></div>
@include('footer')

@stop