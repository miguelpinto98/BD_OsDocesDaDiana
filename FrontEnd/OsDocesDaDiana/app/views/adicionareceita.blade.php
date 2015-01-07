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
			<div class="comment-reply-wraper" style="height:920px";>
				<div class="comment-reply" style="height:870px";>
					<div class="post-comment-wrapper" style="height:870px";>
						<div class="post-comment" style="height:840px";>
							<form method="post" id="adicionareceita" name="adicionareceita" action="adicionareceita" enctype="multipart/form-data">			
										
										<div class="post-comment-box"style="height:30px" name="adicionareceita" action="adicionareceita">
											<span>Categoria</span>
											<textarea id="categoria" style="margin-left:160px; height:20px; width:250px" name="categoria" value="" onblur="textareaLabel(0);" onfocus="textareaLabel(1);"></textarea>
										</div>

										<div class="main-separator1"></div>	


										<div class="post-comment-box"style="height:30px">
											<span>Nome Receita</span>
											<textarea id="nome" style="margin-left:130px; height:20px; width:250px" name="nome" value="" onblur="textareaLabel(0);" onfocus="textareaLabel(1);"></textarea>
										</div>
										<div class="main-separator1"></div>

										<div class="post-comment-box" style="height:30px">
											<span>Tempo de Preparação (minutos)</span>
											<textarea id="tempo" style="margin-left:16px; height:20px; width:150px" name="tempo" value="" onblur="textareaLabel(0);" onfocus="textareaLabel(1);"></textarea>
										</div>
										<div class="main-separator1"></div>

										<div class="post-comment-box" style="height:30px">
											<span>Dose (número de pessoas)</span>
											<textarea id="dose" style="margin-left:50px; height:20px; width:150px" name="dose" value="" onblur="textareaLabel(0);" onfocus="textareaLabel(1);"></textarea>
										</div>
										<div class="main-separator1"></div>

										<div class="post-comment-box" style="height:30px">
											<span>Valor Nutricional (Total Kcal)</span>
											<textarea id="valornutricional" style="margin-left:45px; height:20px; width:150px" name="valornutricional" value="" onblur="textareaLabel(0);" onfocus="textareaLabel(1);"></textarea>
										</div>
										<div class="main-separator1"></div>

										<div class="post-comment-box" style="height:30px">
											<span>Custo (Total em €)</span>
											<textarea id="custo" style="margin-left:105px; height:20px; width:150px" name="custo" value="" onblur="textareaLabel(0);" onfocus="textareaLabel(1);"></textarea>
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
										
										<div class="post-comment-box">
											<label for="file">Imagens:</label>
											<input type="file" name="file" multiple="multiple"><br>
											<!--<input type="submit" name="submit" value="Carregar">-->
										</div>
									

										<div class="separator"></div>
											<div class="comment-box-footer" style="height:30px">
												<div class="comment-submit" style="height:30px">
												<input type="submit" name="Receita" id="comment-submit" class="comment-submit" value="Submeter"/>
												</div>
											</div>

							</form>
									</div>
									</div>
								</div>
							</div>
						</div>
						

						
				</div>
			</div>

@include('footer')

@stop