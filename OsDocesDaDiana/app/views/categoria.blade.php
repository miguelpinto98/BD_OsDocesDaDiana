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
						Categoria: <span>{{ $categoria }}</span>
					<!--	&nbsp;<span class="pipe">|</span>&nbsp;
						Ordernar por:&nbsp;
						<a href="javascript: requestsOrderBy('date');" id="date" class="slctd">Pontuação</a>, 
						<a href="javascript: requestsOrderBy('name');" id="name" class="">Título</a> -->
					</div>
					<input type="hidden" value="" id="reqOrderValue" />
				</div>
				<input type="hidden" id="reqsListTypeActive" value="series" />
				
				<div class="clear"></div>
					<div id="requestsList" class="requestsList">
						@foreach($receitas as $receita)
						<?php $img = DB::table('Imagens')->where('idreceita', $receita->idreceita)->first() ;?>
							<div id="{{ $receita->idreceita }}" class="request">
								<div class="thumb">
									<a href="<?php echo 'receita/'.$receita->idreceita ;?>"> <!-- FALTA COLOCAR AS IMAGENS -->
										@if($img)
											<img src="<?php echo $img->imagem; ?>" width="150px" height="150px">
										<noscript><img src="images/requests_thumbs/thumb404.jpg"></noscript>
										@endif
									</a>
								</div>
								<div class="reqInfo">
									<span class="hmReqs" style="overflow:hidden;">{{ $receita->nome }}</span>
									<div class="wtv-rating" style="padding-left:40px;">
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
											}
										?>	
									@endif
									</div>
								</div>
							</div>
						@endforeach
					</div>
			<!--		<div id="pagination" class="pagination" style="padding-right:20px;">
						<div class="pagination-aux">
							<a href="#" onclick="return false;" class="actual">1</a>
							<a href="javascript: requestsList('series', 'pagination', 2);">2</a>
							<a href="javascript: requestsList('series', 'pagination', 3);">3</a>
							<span>...</span><a href="javascript: requestsList('series', 'pagination', 420);">10</a>
						</div> 
					</div>-->
			</div>
		</div>
	</div>
</div>
@include('footer')
@stop