@extends('layout')

<?php if(Auth::check()) { ;?> 
	@include('headerbar_logged')
<?php } else { 
	echo link_to('logout','');
	} ;?>

@section('content')
<div class="center">
	<div id="account-box" class="content-box">
		<div class="left-content">

		<!--Utilizador-->	
		<div class="account-settings-wrapper">
			<div class="account-settings">
				<div class="settings-header">
					<div class="avatar">
						<img src="{{ asset( $user = Auth::user()-> avatar) }}">
					</div>
					
					<div class="user-info">
						<div class="username"> {{ Auth::user()->nome }} </div>
						<div class="register-date">Desde&nbsp;<span>{{date(Auth::user()->created_at) }}</span></div>
					</div>
				</div>
				<div class="settings-content">												
					<div class="account-options2">
						<span class="label">Reputação:</span>
						<span class="texto2"> {{ Auth::user()->valoravaliacoes }} estrelas</span>
					</div>
					
					<div class="account-options2">
						<span class="label">Localidade:</span>
						<span class="texto2">{{ Auth::user()->localidade }}</span>
					</div>
					<div class="separator"></div>
					<div class="account-options">
						<span class="label">Sobre mim:</span>
						<span class="texto1">{{ Auth::user()->descricao }}</span>
					</div>
				</div>
			</div>
		</div>
		
		<!--Gerir Conta-->
			<div class="subscribe-series">
			<div class="subscribe-header">Gerir conta</div>
			<div class="separator"></div>
			
			<div class="subscribe-content">							
				<div class="options-content">
					<span class="label">Alterar dados:</span>
					
					<div class="post-comment-box"style="height:15px">
						<span>E-mail</span>
						<textarea id="nome" style="margin-left:30px; margin-top:5px; height:20px; width:160px" name="nome" value="" onblur="textareaLabel(0);" onfocus="textareaLabel(1);"></textarea>
					</div>
					<div class="main-separator1"></div>

					<div class="post-comment-box"style="height:15px">
						<span>Password</span>
						<textarea id="nome" style="margin-left:10px; margin-top:5px; height:20px; width:160px" name="nome" value="" onblur="textareaLabel(0);" onfocus="textareaLabel(1);"></textarea>
					</div>
					<div class="main-separator1"></div>

					<div class="post-comment-box"style="height:15px">
						<span>Descrição</span>
						<textarea id="nome" style="margin-left:9px; margin-top:5px; height:20px; width:160px" name="nome" value="" onblur="textareaLabel(0);" onfocus="textareaLabel(1);"></textarea>
					</div>
					<div class="main-separator1"></div>

					<form action="adicionareceita" method="post" enctype="multipart/form-data" style="margin-top:30px">
						<label for="file">Imagens:</label>
						<input type="file" name="file" multiple="multiple"><br>
						<input type="submit" name="submit" value="Carregar">
					</form>


					</div>


				<div class="login-register2">				
					<div id="login" class="login">
						<div class="login-form">
							<form method="post" style="margin-top:10px; margin-left:10px" id="loginForm" name="loginForm" onsubmit="validateLogin(); return false;">
								<?php echo link_to('adicionareceita', 'Adicionar Nova Receita', array('type'=>'button','class'=>'form-btn')); ?>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		</div>
		<!--Gerir Conta-->
		<div class="media-box">
			<div id="mediaHeader" class="media-header">
				<div id="mediaHeader-movies" class="media-header-option movies">
					<a href="javascript: myAccount('accountMedia.ajax.php?cat=movies', $('#accountMediaChangeContent')); setAccountCategory('movies');">
					<div class="media-header-option-label">As Minhas Receitas</div>
					</a>
				</div>
				<div id="mediaHeader-series" class="media-header-option series">
					<a href="javascript: myAccount('accountMedia.ajax.php?cat=series', $('#accountMediaChangeContent')); setAccountCategory('series');">
					<div class="media-header-option-label">Receitas Favoritas</div>
					</a>
				</div>
				<div id="mediaHeader-episodes" class="media-header-option episodes">
					<a href="javascript: myAccount('accountMedia.ajax.php?cat=episodes', $('#accountMediaChangeContent')); setAccountCategory('episodes');">
					<div class="media-header-option-label">Chefs Seguidos</div>
					</a>
				</div>
			</div>
			<div id="mediaAccountContent" class="media-account-content">								
				<input type="hidden" name="selectedCat" id="selectedCat" value="series">
				<div id="mediaHeaderOptions" class="media-header-options">
					<div class="movies-order without-icon" style="width: 300px; margin-top: 15px;">
						<div class="movies-order-caption">Ordernar por:
							<a href="javascript: myAccount('accountMedia.ajax.php?p=1&order=name&cat=series', $('#accountMediaChangeContent')); setOrderBy('account', 'name');" style="font-family: 'HelveticaNeueBold';">Título</a>,
							<a href="javascript: myAccount('accountMedia.ajax.php?p=1&order=date&cat=series', $('#accountMediaChangeContent')); setOrderBy('account', 'date');" style="">Data</a>,
							<a href="javascript: myAccount('accountMedia.ajax.php?p=1&order=year&cat=series', $('#accountMediaChangeContent')); setOrderBy('account', 'year');" style="">Ano</a>
						</div>
						<input type="hidden" value="name" id="account-order">
					</div>
				</div>
				<div class="clear"></div>

				<div class="account-media-divider"></div>
				<div id="mediaAccountContent" class="media-account-content">
					@foreach($receitas as $receita)
					<?php $img = DB::table('Imagens')->where('idreceita', $receita->idreceita)->first(); ?>

					<div id="$receita->idreceita" class="accmedia-item">
						<a href="{{ '/receita/'.$receita->idreceita }}" title="{{ $receita->nome }}">
						@if($img)
							<img src="{{ asset($img->imagem); }}" height="95" width="141">
						@endif	
						<div class="thumb-effect"></div>
						</a>
						<!--<a href="javascript:;" class="remove-media-content" onclick="removeMediaContent('receitas', 183, 'Deseja remover este conteúdo desta lista?');"></a>-->
					</div>
					@endforeach	
				</div>
			</div>
<!--
			<div id="pagination" class="pagination" style="margin-top: 10px;">
				<div class="pagination-aux">
					<a href="#" onclick="return false;" class="actual">1</a><a href="javascript: myAccount('accountMedia.ajax.php?p=2&cat=movies', $('#accountMediaChangeContent'));" onclick="scrollToDiv('#content #account-box');">2</a>
				</div>
			</div> -->
		</div>
	</div>
</div>
@include('footer')
@stop