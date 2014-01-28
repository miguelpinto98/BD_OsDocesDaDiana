@extends('layout')

<?php if(Auth::check()) { ;?> 
	@include('headerbar_logged')
<?php } else { ;?> 
	@include('headerbar_guest')
<?php } ;?>

@section('content')
<div class="center">
	<div id="comments-box" class="content-box">
		<div id="login-box">
			<div class="login-register">					
				<div id="login" class="login login2" style="padding:10px;">
					<div class="title">Adicionar Receita</div>
					<div class="login-divider"></div>
				</div>
			</div>
		</div>
		
		<div class="comments-header">
			<div class="comment-reply-wraper" style="height:900px";>
				<div class="comment-reply" style="height:850px";>
					<div class="post-comment-wrapper" style="height:840px";>
						<div class="post-comment" style="height:810px";>
							<form method="post" id="adicionareceita">			
										
										<div class="post-comment-box"style="height:30px">
											<span>Categoria</span>
											<select class="dropdown" style="margin-left:155px; height:20px; width:200px">
												<option value="" class="label">Seleccione</option>
												<option value="1">Doces de Colher</option>
												<option value="2">Bolinhos</option>
												<option value="3">Bolos</option>
												<option value="4">Bolachas e Biscoitos</option>
												<option value="5">Tartes</option>
												<option value="6">Tortas</option>
												<option value="7">Pudins</option>
												<option value="8">Bombons e Docinhos</option>
												<option value="9">Semi-Frios</option>
												<option value="10">Gelados</option>
												<option value="11">Doces Fritos</option>
												<option value="12">Frutos e Outros</option>
												<option value=""></option>
											</select>
										</div>


										<div class="main-separator1"></div>	


										<div class="post-comment-box"style="height:30px">
											<span>Nome</span>
											<textarea id="nome" style="margin-left:185px; height:20px; width:200px" name="nome" value="" onblur="textareaLabel(0);" onfocus="textareaLabel(1);"></textarea>
										</div>
										<div class="main-separator1"></div>

										<div class="post-comment-box" style="height:30px">
											<span>Tempo de Preparação</span>
											<textarea id="tempo" style="margin-left:80px; height:20px; width:200px" name="tempo" value="" onblur="textareaLabel(0);" onfocus="textareaLabel(1);"></textarea>
										</div>
										<div class="main-separator1"></div>

										<div class="post-comment-box" style="height:30px">
											<span>Dose (número de pessoas)</span>
											<textarea id="dose" style="margin-left:50px; height:20px; width:200px" name="dose" value="" onblur="textareaLabel(0);" onfocus="textareaLabel(1);"></textarea>
										</div>
										<div class="main-separator1"></div>

										<div class="post-comment-box" style="height:30px">
											<span>Valor Nutricional</span>
											<textarea id="valornutricional" style="margin-left:120px; height:20px; width:200px" name="valornutricional" value="" onblur="textareaLabel(0);" onfocus="textareaLabel(1);"></textarea>
										</div>
										<div class="main-separator1"></div>

										<div class="post-comment-box" style="height:30px">
											<span>Custo (em €/por dose)</span>
											<textarea id="custo" style="margin-left:80px; height:20px; width:200px" name="custo" value="" onblur="textareaLabel(0);" onfocus="textareaLabel(1);"></textarea>
										</div>
										<div class="main-separator1"></div>



										<div class="post-comment-box">
											<span>Ingredientes&nbsp;&nbsp;</span>
											<textarea id="ing" style="margin-left:10px; width:500px" name="ing" value="" onblur="textareaLabel(0);" onfocus="textareaLabel(1);"></textarea>
										</div>

										<div class="main-separator1"></div>

										<div class="post-comment-box">
											<span>Preparação&nbsp;&nbsp; </span>
											<textarea id="prep" style="margin-left:15px; width:500px" name="prep" value="" onblur="textareaLabel(0);" onfocus="textareaLabel(1);"></textarea>
										</div>

										<div class="main-separator1"></div>
										
										<form action="adicionareceita" method="post" enctype="multipart/form-data">
										<label for="file">Imagens:</label>
										<input type="file" name="file" multiple="multiple"><br>
										<input type="submit" name="submit" value="Carregar">
										</form>

										<div class="separator"></div>
											<div class="comment-box-footer">
												<div class="comment-submit">

												<input type="submit" method="post" name="comment-submit" id="comment-submit" class="comment-submit" value="Submeter"/>

												</div>
											</div>

										</div>
									</div>
								</div>
							</div>
						</div>
						

						
				</div>
			</div>

@include('footer')

@stop