@extends('layout')

@include('headerbar')

@section('content')
	<div class="center">
				
				
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
							<script type="text/javascript" src="engine1//wowslider.js"></script>
							<script type="text/javascript" src="engine1//script.js"></script>
				

						<!-- <div class="pub" style="width: 978px; height: 200px;"></div> -->
			<!-- ANUNCIOS-->

				<div class="main-separator"></div>


				<!-- CORPO-->				
					<div id="movies-box" class="content-box">

					<!-- BARRA CINZENTA-->		<!-- Tentativa para criar botao dinamico
						<div class="box-header">
						<div class="categorias-receita">
							<div class="categorias-receita-box">
								<span>Seleccione uma Categoria</span>
								<div class="escolha-categoria">
									<div class="categorias-dropdown">
										
									</div>
								</div>
							</div>
						</div> 		-->
						<div class="box-header">
						<div class="categorias-receita">
							<div class="categorias-receita-box">
								<select name="Categorias" class="">
									<option value="-1">Seleccionar uma categoria</option>
									<option class="" value="#">XXXXXXXX</option>
									<option class="" value="#">AAAAAAAA</option>
								</select>
							</div>
						</div>


						<input type="hidden" id="boxheaderBtnSlctd" value="" />
						<ul class="movies-box-btn">
							<li id="movies" class="first "><a href="javascript:;" onclick="changeHighLightsContent('movies', 'movies');">Mais Recentes</a></li>
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

							<!-- quadrados pequenos -->
								<div id="5" class="item first under5">
									<a href="moviefb5f.html?m=The_Worlds_End">
										<img style="display:none;visibility:hidden;" data-cfsrc="images/movies_thumbs/thumb5129.png" alt="The World's End" title="The World's End" /><noscript>
										<img src="images/movies_thumbs/thumb5129.png" alt="The World's End" title="The World's End" /></noscript>
								<div class="thumb-effect" title="The World's End"></div>
									</a>
								</div>


								<div id="5" class="item under5">
									<a href="movieba68.html?m=Prisoners">
										<img style="display:none;visibility:hidden;" data-cfsrc="images/movies_thumbs/thumb5128.png" alt="Raptadas" title="Raptadas" /><noscript>
										<img src="images/movies_thumbs/thumb5128.png" alt="Raptadas" title="Raptadas" /></noscript>
											<div class="thumb-effect" title="Raptadas"></div>
									</a>
								</div>

								<div id="5" class="item under5">
									<a href="movieba68.html?m=Prisoners">
										<img style="display:none;visibility:hidden;" data-cfsrc="images/movies_thumbs/thumb5128.png" alt="Raptadas" title=		"Raptadas" /><noscript>
										<img src="images/movies_thumbs/thumb5128.png" alt="Raptadas" title="Raptadas" /></noscript>
											<div class="thumb-effect" title="Raptadas"></div>
									</a>
								</div>

								<div id="5" class="item under5">
									<a href="movieba68.html?m=Prisoners">
										<img style="display:none;visibility:hidden;" data-cfsrc="images/movies_thumbs/thumb5128.png" alt="Raptadas" title="Raptadas" /><noscript>
										<img src="images/movies_thumbs/thumb5128.png" alt="Raptadas" title="Raptadas" /></noscript>
											<div class="thumb-effect" title="Raptadas"></div>
									</a>
								</div>


								<div id="5" class="item under5">
									<a href="movieba68.html?m=Prisoners">
										<img style="display:none;visibility:hidden;" data-cfsrc="images/movies_thumbs/thumb5128.png" alt="Raptadas" title="Raptadas" /><noscript>
										<img src="images/movies_thumbs/thumb5128.png" alt="Raptadas" title="Raptadas" /></noscript>
											<div class="thumb-effect" title="Raptadas"></div>
									</a>
								</div>


								<div id="5" class="item first">
									<a href="moviea189.html?m=Planes">
										<img style="display:none;visibility:hidden;" data-cfsrc="images/movies_thumbs/thumb5062.png" alt="AviÃµes" title="AviÃµes" /><noscript>
										<img src="images/movies_thumbs/thumb5062.png" alt="AviÃµes" title="AviÃµes" /></noscript>
											<div class="thumb-effect" title="AviÃµes"></div>
									</a>
								</div>



								<div id="5" class="item">
									<a href="moviebac2.html?m=2_Guns">
										<img style="display:none;visibility:hidden;" data-cfsrc="images/movies_thumbs/thumb5061.png" alt="Dois Tiros" title="Dois Tiros" /><noscript>
										<img src="images/movies_thumbs/thumb5061.png" alt="Dois Tiros" title="Dois Tiros" /></noscript>
											<div class="thumb-effect" title="Dois Tiros"></div>
									</a>
								</div>


								<div id="5" class="item">
									<a href="moviebac2.html?m=2_Guns">
										<img style="display:none;visibility:hidden;" data-cfsrc="images/movies_thumbs/thumb5061.png" alt="Dois Tiros" title="Dois Tiros" /><noscript>
										<img src="images/movies_thumbs/thumb5061.png" alt="Dois Tiros" title="Dois Tiros" /></noscript>
											<div class="thumb-effect" title="Dois Tiros"></div>
									</a>
								</div>

							<!-- quadrados pequenos -->

							</div></div>

								<!-- scrollbar lateral -->
									<div class="list-scrollbar" id="movies-list-scrollbar">
									<div class="scrollbar-up"></div>
										<div class="scrollbar-down"></div>
											<div class="scrollbar-bg">
												<div class="scrollbar-btn"></div>
											</div>
									</div>
								<!-- scrollbar lateral -->

							</div>
						<!-- CAIXAS PEQUENAS + SCROLL -->

						<!-- CAIXAS GRANDES + SCROLL -->
							<div class="news-list-content">
							<div id="mycustomscroll" class="movies-news-list flexcroll">
								<div id="horizontalwrap" class="list-aux">
									
							<!-- quadrados grandes -->

								<div id="new55" class="movie-new first">
									<div class="nimg">
										<a href="new084c.html?n=Filme_da_Semana_3_Biutiful">
											<img style="display:none;visibility:hidden;" data-cfsrc="images/news/new55.png" alt="" /><noscript><img src="images/news/new55.png" alt="" /></noscript>
												<div class="img-effect"></div>
										</a>
											<div class="title-bg">
												<div class="title"><a href="new084c.html?n=Filme_da_Semana_3_Biutiful">Nome1</a></div>
											</div>
									</div>
											<div class="preview"><span>Descrição1</span></div>
								</div>



								<div id="new54" class="movie-new">
									<div class="nimg">
										<a href="new2043.html?n=Um_Mal_Nunca_Vem_So_Lock_Stock_and_Two_Smoking_Barrels">
											<img style="display:none;visibility:hidden;" data-cfsrc="images/news/new54.png" alt="" /><noscript><img src="images/news/new54.png" alt="" /></noscript>
												<div class="img-effect"></div>
										</a>
											<div class="title-bg">
												<div class="title"><a href="new2043.html?n=Um_Mal_Nunca_Vem_So_Lock_Stock_and_Two_Smoking_Barrels">Nome2</a></div>
											</div>
									</div>
												<div class="preview"><span>Descrição2.</span></div>
								</div>



									<div id="new54" class="movie-new">
									<div class="nimg">
										<a href="new2043.html?n=Um_Mal_Nunca_Vem_So_Lock_Stock_and_Two_Smoking_Barrels">
											<img style="display:none;visibility:hidden;" data-cfsrc="images/news/new54.png" alt="" /><noscript><img src="images/news/new54.png" alt="" /></noscript>
												<div class="img-effect"></div>
										</a>
											<div class="title-bg">
												<div class="title"><a href="new2043.html?n=Um_Mal_Nunca_Vem_So_Lock_Stock_and_Two_Smoking_Barrels">Nome2</a></div>
											</div>
									</div>
												<div class="preview"><span>Descrição2.</span></div>
								</div>





								<div id="new26" class="movie-new">				
									<div class="nimg">
										<a href="new1ab7.html?n=Nolan_termina_saga_Batman">
											<img style="display:none;visibility:hidden;" data-cfsrc="images/news/new26.png" alt="" /><noscript><img src="images/news/new26.png" alt="" /></noscript>
												<div class="img-effect"></div>
										</a>
											<div class="title-bg">
												<div class="title"><a href="new1ab7.html?n=Nolan_termina_saga_Batman">Nome3</a></div>
											</div>
									</div>
												<div class="preview"><span>Descrição3.</span></div>
								</div>

							<!-- quadrados grandes -->

							</div></div></div>
						<!-- CAIXAS GRANDES + SCROLL -->

						</div>


						<!-- BARRA COMENTARIOS -->
						<div id="movies-box-comments" class="box-comments">
							<div class="msgs-header">
								<span>Mensagens Recentes</span>
							</div>
								<div id="movies-comments-list" class="comments-list">
									<!-- comentarios -->
										<div id="msg811192" class="item first" title="Escrito em 'Alone in the Dark - Sozinhos no Escuro'">
										<input type="hidden" name="movies-lcID" id="movies-lcID" value="811192" />
										<a href="movie2934.html?m=Alone_in_the_Dark&amp;comment=811192">
											<div class="msg-info">
												<div class="avatar">
													<img style="display:none;visibility:hidden;" data-cfsrc="images/users/avatar736262.png" alt=""/>
													<noscript>
													<img src="images/users/avatar736262.png" alt="" /></noscript>
												</div>
													<div class="user-date">
														<div class="user"><span>Utilizador1</span>
														<div class="online"></div>
														</div>
															<div class="date"><span>há x minutos</span></div>
												</div>
											</div>
													<div class="preview"> <span>Comentário1</span></div>
										</a>
										</div>



						<div id="msg811189" class="item" title="Escrito em 'Depois da Vida'">	
						<a href="movie3e9f.html?m=AfterLife&amp;comment=811189">
						<div class="msg-info">
							<div class="avatar">
								<img style="display:none;visibility:hidden;" data-cfsrc="images/users/avatar736262.png" alt=""/>
								<noscript>
								<img src="images/users/avatar736262.png" alt="" /></noscript>
							</div>
								<div class="user-date">
									<div class="user"><span>Utilizador2</span>
										<div class="online"></div>
									</div>
										<div class="date"><span>há x minutos</span></div>
								</div>
						</div>
							<div class="preview"><span>Comentário2</span></div>
						</a>
						</div>

									<!-- comentarios -->
								</div>
						</div>
						<!-- BARRA COMENTARIOS -->

						</div>
					<!-- CAIXA (comentÃ¡rios e imagens)-->

					</div>
				<!-- CORPO-->


				<div class="main-separator"></div>

				</div>

				<div class="main-separator"></div>
@stop