@extends('layout')

@include('headerbar')

@section('content')
		<div class="center">



				<div id="login-box" class="content-box">
					<div class="login-register">					
						<div id="login" class="login login2">
							<div class="title">Entrar</div>
							<div class="login-divider"></div>
							<div class="login-form">
								<form method="post" id="loginForm" name="loginForm" action="login">
									<div class="user">
										<span id="nicknameLabel" class="loginLabel">Nome de Utilizador</span>
										<input type="text" name="nickname" id="nickname" class="form-input" value="" onfocus="loginFields(1, 'nickname');" onblur="loginFields(0, 'nickname');" defaulttext="Nome de Utilizador" />	
									</div>
									<div class="pw">
										<span id="passwordLabel" class="loginLabel">Password</span>
										<input type="password" name="password" id="password" class="form-input" value="" onfocus="loginFields(1, 'password');" onblur="loginFields(0, 'password');" defaulttext="Password" />	
									</div>
									<input type="submit" name="loginBtn" id="loginBtn" class="form-btn" value="ENTRAR AGORA" />
									<!--<span>Esqueceu-se dos dados de acesso? <a href="javascript:;" onclick="openPasswordRecovery();">Clique aqui</a>.</span>-->
								</form>
							</div>
						</div>
					</div>
				</div>



				<div class="main-separator1"></div>

				<div id="login-box" class="content-box">
					<div class="login-register">
						<div id="login" class="login login2">
							<div class="title">Registar</div>
							<div class="login-divider"></div>
								<div class="login-form">
									<form method="post" id="loginForm" name="loginForm" onsubmit="validateLogin(); return false;">
										<!-- CAMPOS -->
												<div class="user">
													<span id="usernameLabel" class="loginLabel">Nome</span>
													<input type="text" name="name" id="username" class="form-input" value="" onfocus="loginFields(1, 'username');" onblur="loginFields(0, 'username');" defaulttext="Nome" />	
												</div>

												<div class="user">
													<span id="nikcname1Label" class="loginLabel">Nome de Utilizador</span>
													<input type="text" name="nikcname1" id="nikcname1" class="form-input" value="" onfocus="loginFields(1, 'nikcname1');" onblur="loginFields(0, 'nikcname1');" defaulttext="Nome de Utilizador" />	
												</div>
												
												<div class="user">
													<span id="mailLabel" class="loginLabel">E-mail</span>
													<input type="text" name="email" id="email" class="form-input" value="" onfocus="loginFields(1, 'email');" onblur="loginFields(0, 'email');" defaulttext="Email" />	
												</div></br></br></br>

												<div class="pw">
													<span id="password3Label" class="loginLabel">Password</span>
													<input type="password" name="password3" id="password3" class="form-input" value="" onfocus="loginFields(1, 'password3');" onblur="loginFields(0, 'password3');" defaulttext="Password" />
												</div>

												<div class="pw">
													<span id="passwordcLabel" class="loginLabel">Confirmar Password</span>
													<input type="password" name="passwordc" id="passwordc" class="form-input" value="" onfocus="loginFields(1, 'passwordc');" onblur="loginFields(0, 'passwordc');" defaulttext="Password" />
												</div>
										<!-- CAMPOS -->

										<input type="submit" name="loginBtn" id="loginBtn" class="form-btn" value="REGISTAR"/>
										<!--<span>Esqueceu-se dos dados de acesso? <a href="javascript:;" onclick="openPasswordRecovery();">Clique aqui</a>.</span>-->
									</form>
								</div>
						</div>
					</div>
				</div>

			</div>

@include('footer')

@stop