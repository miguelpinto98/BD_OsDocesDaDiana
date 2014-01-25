@extends('layout')

@include('headerbar')

@section('content')
		<div class="center">					
			<div id="news-box" class="content-box">
				

				<div class="movies-order" style="margin-top: 30px; margin-left: 23px;">
					<div class="movies-order-caption">Ordernar por:
						<a href="javascript: ajaxRequestGET('news.ajax733c.html?p=1&amp;order=date', $('#news-box')); setOrderBy('news', 'date');" style="">Nome</a> | 
						<a href="javascript: ajaxRequestGET('news.ajaxa94b.html?p=1&amp;order=name', $('#news-box')); setOrderBy('news', 'name');" style="">Pontuação</a> | 
						<a href="javascript: ajaxRequestGET('news.ajaxa6cf.html?p=1&amp;order=views', $('#news-box')); setOrderBy('news', 'views');" style="">Número de Receitas Publicadas</a>
						<!--<a href="javascript: ajaxRequestGET('news.ajaxaf79.html?p=1&amp;order=msgs', $('#news-box')); setOrderBy('news', 'msgs');" style="">...</a>-->
					</div>
						<input type="hidden" value="" id="news-order" />
				</div>


				<div id="pagination" class="pagination" style="margin-top: 25px;">
					<div class="pagination-aux">
						<a href="#" onclick="return false;" class="actual">1</a><a href="javascript: ajaxRequestGET('news.ajax905b.html?p=2', $('#news-box'));">2</a><a href="javascript: ajaxRequestGET('news.ajax2207.html?p=3', $('#news-box'));">3</a><span>...</span><a href="javascript: ajaxRequestGET('news.ajax42dc.html?p=6', $('#news-box'));">6</a>
					</div>
				</div>


				<!-- A pág expande mas tinha só 4 por página -->
				<div id="news-list" class="news-list">
					
					<div class="clear"></div>
					<div id="new55" class="item first">
						<div class="new-image">
							<a href="new084c.html?n=Filme_da_Semana_3_Biutiful">
								<img style="display:none;visibility:hidden;" data-cfsrc="images/news/new55.png" alt="Filme da Semana #3 - Biutiful" /><noscript>
								<img src="images/news/new55.png" alt="Filme da Semana #3 - Biutiful"/></noscript>
								<div class="img-effect"></div>
							</a>
						</div>
						<div class="new-info">
							<div class="title"><a href="new084c.html?n=Filme_da_Semana_3_Biutiful">Nome</a></div>
							<div class="new-type"><a href="#">Visitar Perfil</a></div>
							<div class="clear"></div>
							<div class="divider"></div>
							<div class="body"><span>Olá. Eu sou a Mariana mas também me chamam 63linda ou simplesmente 63... <p></p>Ps- Nesta caixa cabem 325 caracteres.</span></div>
							<div class="divider" style="margin-top: 15px;"></div>
							<div class="new-details">
								<div class="comments">Pontuação <span>5</span> estrelas</div>
								<div class="comments">Seguido por <span>10</span> chefs</div>
								<div class="comments"><span>5</span> Receitas próprias</div>
							</div>
						</div>
					</div>


					<div class="clear"></div>
					<div id="new50" class="item">
						<div class="new-image">
							<a href="new12cb.html?n=Reveladas_novas_imagens_de_O_Hobbit_A_Desolacao_de_Smaug">
								<img style="display:none;visibility:hidden;" data-cfsrc="images/news/new50.png" alt="Reveladas novas imagens de "O Hobbit: A Desolação de Smaug""/>
								<div class="img-effect"></div>
							</a>
						</div>
						<div class="new-info">
							<div class="title"><a href="new084c.html?n=Filme_da_Semana_3_Biutiful">Nome</a></div>
							<div class="new-type"><a href="#">Visitar Perfil</a></div>
							<div class="clear"></div>
							<div class="divider"></div>
							<div class="body"><span>Olá. Eu sou a Mariana mas também me chamam 63linda ou simplesmente 63... <p></p>Ps- Nesta caixa cabem 325 caracteres.</span></div>
							<div class="divider" style="margin-top: 15px;"></div>
							<div class="new-details">
								<div class="comments">Pontuação <span>5</span> estrelas</div>
								<div class="comments">Seguido por <span>10</span> chefs</div>
								<div class="comments"><span>5</span> Receitas próprias</div>
							</div>
						</div>
					</div>
				</div>


				<div id="pagination" class="pagination" style="margin-top: 5px; margin-bottom: 25px;">
					<div class="pagination-aux">
						<a href="#" onclick="return false;" class="actual">1</a>
						<a href="javascript: ajaxRequestGET('news.ajax905b.html?p=2', $('#news-box'));" onclick="paginationScroll();">2</a>
						<a href="javascript: ajaxRequestGET('news.ajax2207.html?p=3', $('#news-box'));" onclick="paginationScroll();">3</a>
						<span>...</span>
						<a href="javascript: ajaxRequestGET('news.ajax42dc.html?p=6', $('#news-box'));" onclick="paginationScroll();">6</a>
					</div>
				</div>

			</div>
		</div>

@include('footer')

@stop