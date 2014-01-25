@extends('layout')

<?php if(Auth::check()) { ;?> 
	@include('headerbar_logged')
<?php } else { ;?> 
	@include('headerbar_guest')
<?php } ;?>

@section('content')
	<div class="center">

			<!--RECEITA-->
				<div id="player-box" class="content-box">
					<div id="movie5170" class="player-aux" style="overflow: visible; padding-bottom: 25px;">
						<div class="thumb" title="Os Selvagens da Noite">
							<a href="./wareztuga.tv - Os Selvagens da Noite (1979)_files/wareztuga.tv - Os Selvagens da Noite (1979).html" class="thumb-aux">
							<img src="assets/images/categorias/teste.png" width="165px" height="190px">
							<div class="thumb-effect" title="Os Selvagens da Noite"></div>
							</a>
						</div>
							<div class="movie-info">
								<a class="movie-name">Doce da Avó</a>
								<div class="clear"></div>
								<div class="movie-detailed-info">
									<div class="detailed-aux" style="height: 20px; line-height: 18px;">
										<span class="genre">Receita por:
											<a href="perfil.html" style="">Mariana63</a> em <a href="categoria.html" style="">Doces de Colher</a>
										</span>
									</div>
									<div class="detailed-aux">
										<span class="director-caption">Tempo de Preparação:</span>
										<span class="director">1000 minutos</span><br>
										<span class="director-caption">Dose:</span>
										<span class="director">6363 pessoas</span><br>
										<span class="director-caption">Custo (por dose):</span>
										<span class="director">777777 €</span><br>
										<span class="director-caption">Valor Nutricional (por dose):</span>
										<span class="director">550 kCal</span>
									</div>
								</div>
								<div class="clear"></div>

								<div class="wtv-rating"></span><span class="full"></span><span class="full"></span><span class="full"></span><span class="full"></span><span></span></div>
								<div class="votes">
									<span class="average">4</span> /5 (<span>34</span> votos)
								</div>
								<div class="clear"></div>
									<!--<span id="movie-synopsis" class="movie-synopsis">Texto.<a href="javascript: readMore('movies', 5170);">ler mais</a></span>
									<span id="movie-synopsis-aux" class="movie-synopsis-aux">Texto todo.</span>-->
							</div>


							<div class="movie-info2">
								<div class="thumb2">
									<a href="#" class="thumb-aux">
										<img src="assets/images/categorias/cupcakes.png" width="100px" height="100px">
									</a>
								</div>
								<div class="thumb2">
									<a href="#" class="thumb-aux">
										<img src="assets/images/categorias/cupcakes.png" width="100px" height="100px">
									</a>
								</div>
								<div class="thumb2">
									<a href="#" class="thumb-aux">
										<img src="assets/images/categorias/cupcakes.png" width="100px" height="100px">
									</a>
								</div>
								<div class="thumb2">
									<a href="#" class="thumb-aux">
										<img src="assets/images/categorias/cupcakes.png" width="100px" height="100px">
									</a>
								</div>
								<div class="thumb2">
									<a href="#" class="thumb-aux">
										<img src="assets/images/categorias/cupcakes.png" width="100px" height="100px">
									</a>
								</div>
								<div class="thumb2">
									<a href="#" class="thumb-aux">
										<img src="assets/images/categorias/cupcakes.png" width="100px" height="100px">
									</a>
								</div>
						</div>	

							<div class="clear"></div>
					</div>

					<div class="player-aux" style="padding-top: 0px; display: block;">
						<div id="movie-actions" class="movie-actions">
							<a id="faved" href="javascript: playerMovieAction('movies', 5170, 'faved');" class="faved ">Adicionar esta receita aos favoritos<span class="fave"></span></a>
							<a id="watched" href="javascript: playerMovieAction('movies', 5170, 'watched');" class="watched ">Seguir Chef<span class="watch"></span></a>

							<div id="movie-rate" class="movie-rate">
								<span class="raterLabel">Classifique esta receita</span>
								<div class="stars">
									<a href="javascript: mediaRater('movies', 5158, 6);" id="rater6"></a><a href="javascript: mediaRater('movies', 5158, 7);" id="rater7"></a><a href="javascript: mediaRater('movies', 5158, 8);" id="rater8"></a><a href="javascript: mediaRater('movies', 5158, 9);" id="rater9"></a><a href="javascript: mediaRater('movies', 5158, 10);" id="rater10"></a>
								</div>
								<input type="hidden" id="raterDefault" value="0" />
							</div>
						</div>
					</div>
					<div class="main-separatorr"></div>


					<div class="player-aux" style="overflow: visible; padding-bottom: 25px;">
						<div class="lista-ing">
							<span class="ing">Ingredientes:</span>
							<div class="clear"></div>
							<ul>
								<li class="">200g de manteiga</li>
								<li class="">5 ovos</li>
								<li class="">leite</li>
							</ul>
						</div>

						
						<div class="preparacao">
							<span class="p">Preparação:</span>
								<div class="texto">
									<span>
										BlaBlaBla1BlaBlaBla23BlaBlaBla4BlaBlaBla5BlaBlaBla6BlaBlaBla7BlaBlaBla8BlaBlaBla9BlaBlaBla10BlaBlaBla11BlaBlaBla12BlaBlaBla13BlaBlaBla14BlaBlaBla15<br>BlaBlaBla20
									</span>										
								</div>
						</div>


						
					</div>


				</div>


					
					
			<!--RECEITA-->

	</div>

@include('footer')	
@stop