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
							<div class="comment-reply-wraper" style="height:750px";>
								<div class="comment-reply" style="height:700px";>
									
								<div class="post-comment-wrapper" style="height:660px";>
									<div class="post-comment" style="height:630px";>

															
										<div class="post-comment-box"style="height:30px">
											<span id="comment-box-label" class="comment-box-label">Nome</span>
											<textarea id="commentBox" style="height:20px" name="commentBox" value="" onblur="textareaLabel(0);" onfocus="textareaLabel(1);"></textarea>
										</div>
										<div class="main-separator1"></div>

										<div class="post-comment-box" style="height:30px">
											<span id="comment-box-label" class="comment-box-label">Tempo de Preparação</span>
											<textarea id="commentBox" style="height:20px" name="commentBox" value="" onblur="textareaLabel(0);" onfocus="textareaLabel(1);"></textarea>
										</div>
										<div class="main-separator1"></div>

										<div class="post-comment-box" style="height:30px">
											<span id="comment-box-label" class="comment-box-label">Dose (número de pessoas)</span>
											<textarea id="commentBox" style="height:20px" name="commentBox" value="" onblur="textareaLabel(0);" onfocus="textareaLabel(1);"></textarea>
										</div>
										<div class="main-separator1"></div>

										<div class="post-comment-box" style="height:30px">
											<span id="comment-box-label" class="comment-box-label">Custo por dose</span>
											<textarea id="commentBox" style="height:20px" name="commentBox" value="" onblur="textareaLabel(0);" onfocus="textareaLabel(1);"></textarea>
										</div>
										<div class="main-separator1"></div>



										<div class="post-comment-box">
											<span id="comment-box-label" class="comment-box-label">Ingredientes</span>
											<textarea id="commentBox" name="commentBox" value="" onblur="textareaLabel(0);" onfocus="textareaLabel(1);"></textarea>
										</div>
										<div class="main-separator1"></div>

										<div class="post-comment-box">
											<span id="comment-box-label" class="comment-box-label">Preparação</span>
											<textarea id="commentBox" name="commentBox" value="" onblur="textareaLabel(0);" onfocus="textareaLabel(1);"></textarea>
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