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
					</div></div>


						
						<div class="comments-header">
							<div class="comment-reply-wraper" style="height:850px";>
								<div class="comment-reply" style="height:800px";>
									
								<div class="post-comment-wrapper" style="height:800px";>
									<div class="post-comment" style="height:770px";>

															
										<div class="post-comment-box"style="height:30px">
											<span>Categoria</span>
											<textarea id="categoria" style="margin-left:160px; height:20px; width:120px" name="categoria" value="" onblur="textareaLabel(0);" onfocus="textareaLabel(1);"></textarea>
										</div>
										<div class="main-separator1"></div>	


										<div class="post-comment-box"style="height:30px">
											<span>Nome</span>
											<textarea id="nome" style="margin-left:185px; height:20px; width:120px" name="nome" value="" onblur="textareaLabel(0);" onfocus="textareaLabel(1);"></textarea>
										</div>
										<div class="main-separator1"></div>

										<div class="post-comment-box" style="height:30px">
											<span>Tempo de Preparação</span>
											<textarea id="tempo" style="margin-left:80px; height:20px; width:120px" name="tempo" value="" onblur="textareaLabel(0);" onfocus="textareaLabel(1);"></textarea>
										</div>
										<div class="main-separator1"></div>

										<div class="post-comment-box" style="height:30px">
											<span>Dose (número de pessoas)</span>
											<textarea id="DOSE" style="margin-left:50px; height:20px; width:120px" name="dose" value="" onblur="textareaLabel(0);" onfocus="textareaLabel(1);"></textarea>
										</div>
										<div class="main-separator1"></div>

										<div class="post-comment-box" style="height:30px">
											<span>Custo (em €/por dose)</span>
											<textarea id="custo" style="margin-left:80px; height:20px; width:120px" name="custo" value="" onblur="textareaLabel(0);" onfocus="textareaLabel(1);"></textarea>
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
													<a href="javascript:;" id="comment-submit" onclick="putComment(&#39;movies&#39;, 5170, 1)"><span></span>Submeter</a>
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