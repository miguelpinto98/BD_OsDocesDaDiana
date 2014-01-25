@extends('layout')

@include('headerbar')

@section('content')
		<div class="center">
				<div id="account-box" class="content-box">
					<div class="left-content">

						<!--Utilizador-->	
							<div class="account-settings-wrapper">
								<div class="account-settings">
									<div id="settings-window"></div>
										<div class="settings-header">
											<div class="avatar">
												<img data-cfsrc="images/users/avatars/zoe_saldana.png" alt="98jigs" src="./Minha Conta_files/zoe_saldana.png">
											</div>
											<div class="user-info">
												<div class="username">Utilizador</div>
												<div class="register-date">Desde&nbsp;<span>12 de Dezembro, 2011</span></div>
											</div>
										</div>
											<div class="settings-content">												
												<div class="account-options2">
													<span class="label">Reputação:</span>
													<span class="texto2">5 estrelas</span>
												</div>
												<div class="account-options2">
													<span class="label">Localidade:</span>
													<span class="texto2">Braga</span>
												</div>
												<div class="separator"></div>
												<div class="account-options">
													<span class="label">Sobre mim:</span>
													<span class="texto1">239 caracteres.</span>
												</div>

											</div>
									</div>
								</div>
						<!--Utilizador-->

						<!--Gerir Conta-->
							<div class="subscribe-series">
								<div class="subscribe-header">Gerir conta</div>
								<div class="separator"> </div>
								<div class="subscribe-content">
									
									<div class="options-content">
										<span class="label">Alterar dados:</span> 
										<div class="imagem"><span>-&nbsp;&nbsp;</span><a href="javascript: openAccountSettings('pw');">E-mail</a></div>
										<div class="imagem"><span>-&nbsp;&nbsp;</span><a href="javascript: openAccountSettings('pw');">Password</a></div>
										<div class="imagem"> <span>-&nbsp;&nbsp;</span> <a href="javascript: openAccountSettings('avatar');">Imagem de perfil</a></div>
										<div class="imagem"><span>-&nbsp;&nbsp;</span><a href="javascript: openAccountSettings('pw');">Descrição pessoal</a></div>
									</div>

									<div class="login-register2">				
										<div id="login" class="login">
											<div class="login-form">
												<form method="post" id="loginForm" name="loginForm" onsubmit="validateLogin(); return false;">
													<input type="button" name="loginBtn" id="loginBtn" class="form-btn" value="Adicionar Nova Receita" onclick="location.href='adicionarReceita.html';"/>
												</form>
											</div>
										</div>
									</div>
								</div>
							</div>
						<!--Gerir Conta-->

					</div>

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


									<div id="accmedia183" class="accmedia-item first series">
										<a href="serie.php?s=90210" title="90210">
											<img src="images/series_v2_thumbs/thumb183.png" alt="90210">
											<div class="thumb-effect"></div>
										</a>
										<a href="javascript:;" class="remove-media-content series" onclick="removeMediaContent('series', 183, 'Deseja remover este conteúdo desta lista?');"></a>
									</div>
									


								</div>
							</div>


								<div id="pagination" class="pagination" style="margin-top: 10px;">
									<div class="pagination-aux">
										<a href="#" onclick="return false;" class="actual">1</a><a href="javascript: myAccount('accountMedia.ajax.php?p=2&cat=movies', $('#accountMediaChangeContent'));" onclick="scrollToDiv('#content #account-box');">2</a>
									</div>
								</div>
					</div>

				</div>
			</div>
@include('footer')

@stop