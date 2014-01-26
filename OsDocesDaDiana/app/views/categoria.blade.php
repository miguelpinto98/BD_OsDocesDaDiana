@extends('layout')

<?php if(Auth::check()) { ;?> 
	@include('headerbar_logged')
<?php } else { ;?> 
	@include('headerbar_guest')
<?php } ;?>

@section('content')
	<div class="center">
					
					<div id="requests-box" class="content-box">
						<div class="reqRightContent">
							<div id="requests" class="requests">
								<div class="reqOrder">
									<div class="hmReq">
										Categoria: <span>Doces de Colher</span>
										&nbsp;<span class="pipe">|</span>&nbsp;
										Ordernar por:&nbsp;
										<a href="javascript: requestsOrderBy('date');" id="date" class="slctd">Pontuação</a>, <a href="javascript: requestsOrderBy('name');" id="name" class="">Título</a>
									</div>
									<input type="hidden" value="" id="reqOrderValue" />
								</div>
									<input type="hidden" id="reqsListTypeActive" value="series" />
									<div class="clear"></div>
				
						<div id="requestsList" class="requestsList">

							<div id="req404" class="request first">
								<div class="thumb">
									<a href="receita1.html" target="_blank">
										<img src="assets/images/categorias/docesdecolher.png" width="150px" height="150px"><noscript><img src="images/requests_thumbs/thumb404.jpg"></noscript>
										</a>
								</div>
								<div class="reqInfo">
									<span class="hmReqs" style="overflow:hidden;">Doce da Avó</span>
									<div class="wtv-rating" style="padding-left:40px;">
										<span class="full"></span>
										<span class="full"></span>
										<span class="full"></span>
										<span class="full"></span>
										<span></span>
									</div>
								</div>
							</div>


							<div id="req404" class="request">
								<div class="thumb">
									<a href="receita1.html" target="_blank">
										<img src="assets/images/categorias/docesdecolher.png" width="150px" height="150px"><noscript><img src="images/requests_thumbs/thumb404.jpg"></noscript>
										</a>
								</div>
								<div class="reqInfo">
									<span class="hmReqs">Doce da Avó</span>
									<div class="wtv-rating" style="padding-left:40px;">
										<span class="full"></span>
										<span class="full"></span>
										<span class="full"></span>
										<span class="full"></span>
										<span></span>
									</div>
								</div>
							</div>




						
						</div>


				<div id="pagination" class="pagination" style="padding-right:20px;">
					<div class="pagination-aux">
						<a href="#" onclick="return false;" class="actual">1</a><a href="javascript: requestsList('series', 'pagination', 2);">2</a><a href="javascript: requestsList('series', 'pagination', 3);">3</a><span>...</span><a href="javascript: requestsList('series', 'pagination', 420);">10</a>
					</div>
				</div>


			</div></div></div></div>

@include('footer')

@stop