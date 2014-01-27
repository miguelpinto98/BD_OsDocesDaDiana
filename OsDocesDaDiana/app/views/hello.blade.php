@extends('layout')

<?php if(Auth::check()) { ;?> 
	@include('headerbar_logged')
<?php } else { ;?> 
	@include('headerbar_guest')
<?php } ;?>

@section('content')
<div class="center">
				<!--
			
					<div id="wowslider-container1">
						<div class="ws_images">
							<ul>
								<li><img src="assets/images/slide/images/a.jpg" alt="A" title="A" id="wows1_0"/></li>
								<li><img src="assets/images/slide/images/b.png" alt="63" title="63" id="wows1_1"/></li>
								<li><img src="assets/images/slide/images/c.jpg" alt="é" title="é" id="wows1_2"/></li>
								<li><img src="assets/images/slide/images/d.jpg" alt="mesmo" title="mesmo" id="wows1_3"/></li>
								<li><img src="assets/images/slide/images/e.png" alt="gira" title="gira" id="wows1_4"/></li>
								<li><img src="assets/images/slide/images/f.png" alt=":o" title=":o" id="wows1_5"/></li>
							</ul>
						</div>

						<div class="ws_bullets">
							<div>
								<a href="#" title="a"><img src="assets/images/slide/tooltips/a.jpg" alt="a"/>1</a>
								<a href="#" title="b"><img src="assets/images/slide/tooltips/b.png" alt="b"/>2</a>
								<a href="#" title="c"><img src="assets/images/slide/tooltips/c.jpg" alt="c"/>3</a>
								<a href="#" title="d"><img src="assets/images/slide/tooltips/d.jpg" alt="d"/>4</a>
								<a href="#" title="e"><img src="assets/images/slide/tooltips/e.png" alt="e"/>5</a>
								<a href="#" title="f"><img src="assets/images/slide/tooltips/f.png" alt="f"/>6</a>
							</div>
						</div>
						
						<span class="wsl"><a href="#"></a></span>
							<a href="#" class="ws_frame"></a>
							<div class="ws_shadow"></div>
							</div>
							<script type="text/javascript" src="assets/slide/wowslider.js"></script>
							<script type="text/javascript" src="assets/slide//script.js"></script>
			
		

				<div class="main-separator"></div>-->

			
	<div id="movies-box" class="content-box" style="height:800px; padding-bottom:10px">
	<!-- BARRA CINZENTA-->
		<div class="box-header"> 
			<div class="btn-group">
				<button data-toggle="dropdown" class="btn dropdown-toggle">Seleccione uma categoria <span class="caret"></span></button>
					<ul class="dropdown-menu">
					    <li><a href="#">Doces de Colher</a></li>
					    <li><a href="#">Bolinhos</a></li>
					    <li><a href="#">Bolos</a></li>
					    <li><a href="#">Bolachas e Biscoitos</a></li>
					    <li><a href="#">Tartes</a></li>
					    <li><a href="#">Tortas</a></li>
					    <li><a href="#">Pudins</a></li>
					    <li><a href="#">Bombons e Docinhos</a></li>
					    <li><a href="#">Semi-Frios</a></li>
					    <li><a href="#">Gelados</a></li>
					    <li><a href="#">Doces Fritos</a></li>
					    <li><a href="#">Frutos e Outros</a></li>
					</ul>
			</div>
                    <ul class="movies-box-btn">
						<li id="movies" class="first"><a href="javascript:;" onclick="changeHighLightsContent('movies', 'movies');">Mais Recentes</a></li>
                        <li id="featuredmovies" class=""><a href="javascript:;" onclick="changeHighLightsContent('movies', 'featuredmovies');">Em Destaque</a></li> <!--class="slctd"-->
                        <li id="mostviewedmovies" class=""><a href="javascript:;" onclick="changeHighLightsContent('movies', 'mostviewedmovies');">Mais Vistas</a></li>
                        <li id="recommendedmovies" class=""><a href="javascript:;" onclick="changeHighLightsContent('movies', 'recommendedmovies');">Recomendadas</a></li>
                    </ul> 
        </div>
	<!-- BARRA CINZENTA-->
	<!-- CAIXA (comentÃ¡rios e imagens)-->
	<div id="movies-box-content" class="movies-box-content" style="padding: 15px;">
		<div class="movies-box-media">
			<!-- CAIXAS PEQUENAS + SCROLL -->				
			<div class="movies-list-content">
				<div id="movies-list" class="movies-list">
					<div class="list-aux">


						<!--	
								$num = sql_row_count(SELECT * from table);
								$c=1;									
									while($c<=$num){
										if($c<=$num && $c==1){
											echo {
												<div id="5" class="item first under3" title="Peixe com Atum">
													<a href="moviefb5f.html?m=The_Worlds_End">
														<img style="display:none;visibility:hidden;" data-cfsrc="images/movies_thumbs/thumb5129.png" alt="The World's End" title="The World's End" /><noscript>
														<img src="images/movies_thumbs/thumb5129.png" alt="The World's End" title="The World's End" /></noscript>
														<div class="thumb-effect" title="The World's End"></div>
														<div class="img-effect"></div>
													</a>
													<div class="title-bg">
													<div class="title"><a href="#">Ver Receita</a></div>
													</div>
												</div>
											}
											$c++; break;
										}

										if($c<=$num && $c==2){
											echo {
													<div id="5" class="item under3" title="Peixe com Atum">
														<a href="moviefb5f.html?m=The_Worlds_End">
															<img style="display:none;visibility:hidden;" data-cfsrc="images/movies_thumbs/thumb5129.png" alt="The World's End" title="The World's End" /><noscript>
															<img src="images/movies_thumbs/thumb5129.png" alt="The World's End" title="The World's End" /></noscript>
															<div class="thumb-effect" title="The World's End"></div>
															<div class="img-effect"></div>
														</a>
														<div class="title-bg">
														<div class="title"><a href="#">Ver Receita</a></div>
														</div>
													</div>
												}
												$c++; break;
										}

										if($c<=$num && $c==3){
											echo {
													<div id="5" class="item under3" title="Peixe com Atum">
														<a href="moviefb5f.html?m=The_Worlds_End">
															<img style="display:none;visibility:hidden;" data-cfsrc="images/movies_thumbs/thumb5129.png" alt="The World's End" title="The World's End" /><noscript>
															<img src="images/movies_thumbs/thumb5129.png" alt="The World's End" title="The World's End" /></noscript>
															<div class="thumb-effect" title="The World's End"></div>
															<div class="img-effect"></div>
														</a>
														<div class="title-bg">
														<div class="title"><a href="#">Ver Receita</a></div>
														</div>
													</div>
												}
												$c++; break;
										}

										if($c<=$num && ($c==4 || $c==7 || $c==10 || $c==13)){
											echo {
													<div id="5" class="item first" title="Peixe com Atum">
														<a href="moviefb5f.html?m=The_Worlds_End">
															<img style="display:none;visibility:hidden;" data-cfsrc="images/movies_thumbs/thumb5129.png" alt="The World's End" title="The World's End" /><noscript>
															<img src="images/movies_thumbs/thumb5129.png" alt="The World's End" title="The World's End" /></noscript>
															<div class="thumb-effect" title="The World's End"></div>
															<div class="img-effect"></div>
														</a>
														<div class="title-bg">
														<div class="title"><a href="#">Ver Receita</a></div>
														</div>
													</div>
												}
												$c++; break;
										}

										if($c<=$num && ($c==5 || $c==6 || $c==8 || $c==9 || $c==11 || $c==12)){
											echo {
													<div id="5" class="item" title="Peixe com Atum">
														<a href="moviefb5f.html?m=The_Worlds_End">
															<img style="display:none;visibility:hidden;" data-cfsrc="images/movies_thumbs/thumb5129.png" alt="The World's End" title="The World's End" /><noscript>
															<img src="images/movies_thumbs/thumb5129.png" alt="The World's End" title="The World's End" /></noscript>
															<div class="thumb-effect" title="The World's End"></div>
															<div class="img-effect"></div>
														</a>
														<div class="title-bg">
														<div class="title"><a href="#">Ver Receita</a></div>
														</div>
													</div>
												}
												$c++; break;
										}
									}		
							 -->

						
							<!-- primeira linha -->


		@foreach($receitas as $receita)
			<?php $img = DB::table('Imagens')->where('idreceita', $receita->idreceita)->first() ;?>
			<div id="{{ $receita->idreceita }}" class="item" title="{{ $receita->nome }}">
				<a href="<?php echo asset('/receita/'.$receita->idreceita) ;?>">
				@if($img)
				<img style="display:none;visibility:hidden;" title="{{ $receita->nome }}" />
				<img src="<?php echo asset($img->imagem) ;?>" width="160" heigth="160" title="{{ $receita->nome }}" />
				@endif	
				<div class="thumb-effect" title="{{ $receita->nome }}"></div>
				<div class="img-effect"></div>
				</a>
				<div class="title-bg">
					<div class="title"><a href="<?php echo '/receita/'.$receita->idreceita ;?>">Ver Receita</a></div>
				</div>
			</div>
		@endforeach						
		</div>
	</div>

	
</div> 
</div>


	<!-- BARRA COMENTARIOS -->
	<div id="movies-box-comments" class="box-comments">
		<div class="msgs-header">
			<span>Comentários Recentes</span>
		</div>
		<div id="movies-comments-list" class="comments-list">
		<!-- comentarios -->
		<?php $i=0;?>
		@foreach($coments as $coment)
			<?php $tbl = DB::table('Receitas')->where('idreceita', $coment->idreceita )->first() ;?>
			 <div id="{{ $coment->idreceita }}" class="item" title="{{ $tbl->nome }}">
				<input type="hidden" name="N.D." id="N.D." value="N.D." />
				<a href="<?php echo '/receita/'.$coment->idreceita ;?>">
				<div class="msg-info">
					<div class="user-date">
						<div class="user"><span>{{ $coment->username }}</span></div>
						<div class="date"><span>{{ $coment->created_at }}</span></div>
					</div>
				</div>
				<div class="preview"> <span> {{ $coment->comentario }}</span></div>
				<!--</a>-->
			</div>
				<?php $i++;?>
				@if($i==5)
					<?break;?>
				@endif
			@endforeach
		</div>
	</div>
	<!-- BARRA COMENTARIOS -->
</div>
</div>			
</div>

@include('footer')
@stop