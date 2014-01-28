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
				@foreach($imagens as $imagem)
					<img src="{{ asset($imagem->imagem) }}" width="165px" height="190px">
					<div class="thumb-effect" title=""></div>
				<?php break; ?>
				@endforeach	
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
						<span class="director">{{$receita->custo}} €</span><br>
						<span class="director-caption">Valor Nutricional (por dose):</span>
						<span class="director">{{ $receita->vnutricional}} Kcal</span>
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

			@foreach($imagens as $imagem)
			<div class="thumb2">
				<a href="" class="thumb-aux">

				<img src="{{ asset($imagem->imagem); }}" width="100px" height="100px">
				</a>
			</div>
			@endforeach
			</div>	
			<div class="clear"></div>
		</div>
		@if(Auth::check())
		<div class="player-aux" style="padding-top: 0px; display: block;">
			<div id="movie-actions" class="movie-actions">
				<a id="faved" href="javascript: playerMovieAction('movies', 5170, 'faved');" class="faved ">Adicionar esta receita aos favoritos<span class="fave"></span></a>
				<a id="watched" href="javascript: playerMovieAction('movies', 5170, 'watched');" class="watched ">Seguir Chef<span class="watch"></span></a>
					<div id="movie-rate" class="movie-rate">
						<span class="raterLabel">Classifique esta receita</span>
						<div class="stars">
							<a href="javascript: mediaRater('receita', {{$receita->idreceita}}, 1);" id="rater1"></a>
							<a href="javascript: mediaRater('receita', {{$receita->idreceita}}, 2);" id="rater2"></a>
							<a href="javascript: mediaRater('receita', {{$receita->idreceita}}, 3);" id="rater3"></a>
							<a href="javascript: mediaRater('receita', {{$receita->idreceita}}, 4);" id="rater4"></a>
							<a href="javascript: mediaRater('receita', {{$receita->idreceita}}, 5);" id="rater5"></a>
						</div>
						<input type="hidden" id="raterDefault" value="0" />
					</div>
			</div>
		</div>
		@endif
	</div>
	<!--VER RECEITA vvv -->
				
				<div id="player-box" class="content-box">
					<div id="movie5170" class="player-aux" style="overflow: visible; padding-bottom: 25px;">
								<div class="movie-info">									
									<div class="movie-detailed-info">	
									</div>							
								
									<!--<span id="movie-synopsis" class="movie-synopsis">Texto.<a href="javascript: readMore('movies', 5170);">ler mais</a></span>
									<span id="movie-synopsis-aux" class="movie-synopsis-aux">Texto todo.</span>-->
							</div>


							<div class="clear"></div>
					</div>
				
					
					<div class="player-aux" style="overflow: visible; padding-bottom: 25px;">
						<div class="lista-ing">
							<span class="ing">Ingredientes:</span>
							<div class="clear"></div>
							<ul>
							<?php $ingr = explode(", ", $receita->ingredientes) ;?>
							@foreach($ingr as $i)
								<li class="">{{ $i }}</li>
							@endforeach
							</ul>
						</div>

						
						<div class="preparacao">
							<span class="p">Preparação:</span>
								<div class="texto">
									<span>
									{{$receita->descricao}}
									</span>										
								</div>
						</div>
						

						
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
							<img src="{{ asset(Auth::user()->avatar); }}">
						</div>
						<div class="username"><span>{{Auth::user()->username}}</span></div>
					</div>
					<form method="post">
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
									<input type="submit" name="comment-submit" id="comment-submit" class="comment-submit" value="Submeter"></input>
								</div>
							</div>
						</div>
					</div>
					</form>
				</div>
			</div>
		</div>

		<div id="comments-list" class="comments-list">
		<?php $res=1; ?>
		<?php $count = count($comentarios); ?>
		@foreach($comentarios as $comentario)
			<?php $tbl = DB::table('Utilizadores')->where('username', $comentario->username)->first() ;?>

		<!--Comentário Esquerdo-->
		@if($res % 2 == 0)
			<div class="left-comments">				
				<div id="comment812604" class="item-wrapper first ">
					<div class="item">
						<div class="comment-header">
							<div class="avatar">
								<img src="{{ asset($tbl->avatar); }}">		
							</div>
						<div class="comment-info">
							<div class="comment-user">
								<div class="username"><span>{{ $comentario->username }}</span></div>
								<div class="comment-date"><span>{{ $comentario->created_at }}</span></div>
							</div>
							<div class="comment-number">{{ $count; }}</div> <?php $count--;?>
						</div>
						</div>
						<div class="clear"></div>
							<div class="comment-body">
								<span>{{ $comentario->comentario }}</span>
							</div>						
					</div>
				</div>			
			</div>
		@endif
		<!--Comentário Direito-->
		@if($res % 2 != 0)
			<div class="right-comments">
				<div id="comment812562" class="item-wrapper first even">
					<div class="item ">
						<div class="comment-header">
							<div class="avatar">
								<img src="{{ asset($tbl->avatar); }}">
							</div>
						<div class="comment-info">
							<div class="comment-user">
								<div class="username"><span>{{ $comentario->username }}</span></div>
								<div class="comment-date"><span>{{ $comentario->created_at }}</span></div>
							</div>
							<div class="comment-number">{{ $count; }}</div> <?php $count--;?>
						</div>
						</div>
						<div class="clear"></div>
						<div class="comment-body">
							<span>{{ $comentario->comentario }}</span>
						</div>						
					</div>
				</div>
			</div>
		@endif
		<?php $res++; ?>
		@endforeach	
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