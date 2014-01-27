@extends('layout')

<?php if(Auth::check()) { ;?> 
	@include('headerbar_logged')
<?php } else { ;?> 
	@include('headerbar_guest')
<?php } ;?>

@section('content')
<div class="center">
<?php $res=0 ;?>
<!--RECEITA-->
	<div id="player-box" class="content-box">
		<div id="movie5170" class="player-aux" style="overflow: visible; padding-bottom: 25px;">
			<div class="thumb" title="">
				<a class="thumb-aux">
					<img src="{{ asset('assets/images/categorias/teste.png'); }}" width="165px" height="190px">
					<div class="thumb-effect" title=""></div>
				</a>
			</div>
			<div class="movie-info">
				<a class="movie-name">{{ $receita->nome }}</a>
				<div class="clear"></div>
				<div class="movie-detailed-info">
					<div class="detailed-aux" style="height: 20px; line-height: 18px;">
						<span class="genre">Receita por: {{ $receita->username }} em <?php echo link_to('categorias/'.$receita->categoria,$receita->categoria); ?></span>
					</div>
					<div class="detailed-aux">
						<span class="director-caption">Tempo de Preparação:</span>
						<span class="director">{{$receita->tempopreparacao}} minutos</span><br>
						<span class="director-caption">Dose:</span>
						<span class="director">{{$receita->dose}} pessoas</span><br>
						<span class="director-caption">Custo (por dose):</span>
						<span class="director">N.D. €</span><br>
						<span class="director-caption">Valor Nutricional (por dose):</span>
						<span class="director">N.D.</span>
					</div>
				</div>
				<div class="clear"></div>
				<div class="wtv-rating">
					@if($receita->nravaliacoes == 0)
						<span></span>
						<span></span>
						<span></span>
						<span></span>
						<span></span>
					@else 
						<?php
							$res = $receita->valoravaliacoes/$receita->nravaliacoes; 
							$i=0;
							while($i<5) { ?>
								@if($i < $res)
									<span class="full"></span>
								@else
									<span></span>
								@endif												
								<?php		$i++;
								}?>	
								@endif
				</div>
				<div class="votes">
					<span class="average">{{$res}}</span> /5 (<span>{{ $receita->nravaliacoes }}</span> votos)
				</div>
				<div class="clear"></div>
			</div>
			<div class="movie-info2">
				<div class="thumb2">
					<a href="" class="thumb-aux">
					<img src="{{ asset('assets/images/categorias/teste.png'); }}" width="100px" height="100px">
					</a>
				</div>
				<div class="thumb2">
					<a href="" class="thumb-aux">
					<img src="{{ asset('assets/images/categorias/cupcakes.png'); }}" width="100px" height="100px">
					</a>
				</div>
				<div class="thumb2">
					<a href="" class="thumb-aux">
					<img src="{{ asset('assets/images/categorias/teste.png'); }}" width="100px" height="100px">
					</a>
				</div>
				<div class="thumb2">
					<a href="" class="thumb-aux">
					<img src="{{ asset('assets/images/categorias/cupcakes.png'); }}" width="100px" height="100px">
					</a>
				</div>
				<div class="thumb2">
					<a href="" class="thumb-aux">
					<img src="{{ asset('assets/images/categorias/teste.png'); }}" width="100px" height="100px">
					</a>
				</div>
				<div class="thumb2">
					<a href="" class="thumb-aux">
					<img src="{{ asset('assets/images/categorias/cupcakes.png'); }}" width="100px" height="100px">
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
	</div>
	<!--VER RECEITA vvv -->
	<div id="" class="content-box">
		<div class="ver-receita">
			<a href="receita2.html" id="comment-submit">Ver receita</a>
		</div>
	</div>

	<div class="main-separator"></div>

	@if(Auth::check())
	<div id="comments-box" class="content-box">
						<div class="comments-header">
							<div class="comment-reply-wraper">
								<div class="comment-reply">
									<div class="user-info">
										<div class="avatar">
											<img data-cfsrc="images/users/avatars/zoe_saldana.png" alt="" src="./wareztuga.tv - Os Selvagens da Noite (1979)_files/zoe_saldana.png">
										</div>
										<div class="username"><span>98jigs</span></div>
									</div>
								<div class="post-comment-wrapper">
									<div class="post-comment">
										<div class="comment-box-arrow"></div>
										<div class="post-comment-box">
											<span id="comment-box-label" class="comment-box-label">Deixe aqui o seu comentário.</span>
											<textarea id="commentBox" name="commentBox" value="" onblur="textareaLabel(0);" onfocus="textareaLabel(1);"></textarea>
										</div>
										<div class="separator"></div>
											<div class="comment-box-footer">
												<div class="comment-submit">
													<a href="javascript:;" id="comment-submit" onclick="putComment(&#39;movies&#39;, 5170, 1)"><span></span>Submeter</a>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						

						<div id="comments-list" class="comments-list">
							
							<!--Comentário Esquerdo-->
								<div class="left-comments">				
									<div id="comment812604" class="item-wrapper first ">
										<div class="item">
											<div class="comment-header">
												<div class="avatar">
													<img data-cfsrc="images/users/avatars/zooey_deschanel.png" alt="pinkwargasm" src="./wareztuga.tv - Os Selvagens da Noite (1979)_files/zooey_deschanel.png">		
												</div>
												<div class="comment-info">
													<div class="comment-user">
														<div class="username"><span>Utilizador1</span></div>
														</div>
												</div>
											</div>
											<div class="clear"></div>
											<div class="comment-body">
												<span>Comentário1.</span>
											</div>
											
										</div>
									</div>			
								</div>
							<!--Comentário Esquerdo-->

							<!--Comentário Direito-->
								<div class="right-comments">
									<div id="comment812562" class="item-wrapper first even">
										<div class="item ">
											<div class="comment-header">
												<div class="avatar">
													<img data-cfsrc="images/users/avatar167315.jpg" alt="DONMIRA" src="./wareztuga.tv - Os Selvagens da Noite (1979)_files/avatar167315.jpg">
												</div>
												<div class="comment-info">
													<div class="comment-user">
														<div class="username">
															<span>Utilizador2</span>
														</div>
														</div>
												</div>
											</div>
											<div class="clear"></div>
						<div class="comment-body">
							<span>Comentário2.</span>
						</div>						
					</div>
				</div>
			</div>
	@endif		

<!--
			<div id="pagination" class="pagination" style="margin-top: 20px; clear: both;">
				<div class="pagination-aux">
					<a href="javascript:;" onclick="return false;" class="actual">1</a><a href="javascript:;" onclick="reloadComments(&#39;movies&#39;, 5170, 2); scrollToDiv(&#39;#comments-list&#39;);">2</a>
				</div>
			</div> -->
		</div>
	</div>
</div>

@include('footer')
@stop