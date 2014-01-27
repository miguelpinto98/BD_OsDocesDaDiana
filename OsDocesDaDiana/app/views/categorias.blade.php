@extends('layout')

<?php if(Auth::check()) { ;?> 
	@include('headerbar_logged')
<?php } else { ;?> 
	@include('headerbar_guest')
<?php } ;?>

@section('content')
	<div class="center">
		<div id="news-box" class="content-box">
			<div id="news-list" class="news-list">
				

				<div class="clear"></div>
					<div id="new55" class="item first">
						<!--Primeiro Quadrado-->
							<div class="new-imagecategorias">
								<a href="categorias/Doces de Colher">
									<img src="assets/images/categorias/docesdecolher.png" width="217px" height="217px"/>
								</a>
								<div class="title-bg">
									
									<div class="title"><?php echo link_to('categorias/Doces de Colher','Doces de Colher');?></div>
								</div>
							</div>
						<!--Primeiro Quadrado-->


						<!--Segundo Quadrado-->
							<div class="new-imagecategorias">
								<a href="categorias/Bolinhos">
									<img src="assets/images/categorias/cupcakes.png" width="217px" height="217px"/>
								</a>
									<div class="title-bg">
										<div class="title"><?php echo link_to('categorias/Bolinhos','Bolinhos');?></div>
									</div>
							</div>
						<!--Segundo Quadrado-->


						<!--Terceiro Quadrado-->
							<div class="new-imagecategorias">
								<a href="categorias/Bolos">
									<img src="assets/images/categorias/bolos.png" width="217px" height="217px"/>
								</a>
									<div class="title-bg">
										<div class="title"><?php echo link_to('categorias/Bolos','Bolos');?></div>
									</div>
							</div>
						<!--Terceiro Quadrado-->

						<!--Quarto Quadrado-->
							<div class="new-imagecategorias">
								<a href="categorias/Bolachas e Biscoitos">
									<img src="assets/images/categorias/bolachas.png" width="217px" height="217px"/>
								</a>
									<div class="title-bg">
										<div class="title"><?php echo link_to('categorias/Bolachas e Biscoitos','Bolachas e Biscoitos');?></div>
									</div>
							</div>
						<!-- Quarto Quadrado-->
					</div>



				<div class="clear"></div>
					<div id="new50" class="item">
				
						<!--Quinto Quadrado-->
							<div class="new-imagecategorias">
								<a href="categorias/Tartes">
									<img src="assets/images/categorias/tartes.png" width="217px" height="217px"/>
								</a>
									<div class="title-bg">
										<div class="title"><?php echo link_to('categorias/Tartes','Tartes');?></div>
									</div>
							</div>
						<!--Quinto Quadrado-->


						<!--Sexto Quadrado-->
							<div class="new-imagecategorias">
								<a href="categorias/Tortas">
									<img src="assets/images/categorias/torta.png" width="217px" height="217px"/>
								</a>
									<div class="title-bg">
										<div class="title"><?php echo link_to('categorias/Tortas','Tortas');?></div>
									</div>
							</div>
						<!--Sexto Quadrado-->

						<!--Sétimo Quadrado-->
							<div class="new-imagecategorias">
								<a href="categorias/Pudins">
									<img src="assets/images/categorias/pudim.png" width="217px" height="217px"/>
								</a>
									<div class="title-bg">
										<div class="title"><?php echo link_to('categorias/Pudins','Pudins');?></div>
									</div>
							</div>
						<!--Sétimo Quadrado-->


						<!--Oitavo Quadrado-->
							<div class="new-imagecategorias">
								<a href="categorias/Bombons e Docinhos">
									<img src="assets/images/categorias/bombons.png" width="217px" height="217px"/>
								</a>
									<div class="title-bg">
										<div class="title"><?php echo link_to('categorias/Bombons e Docinhos','Bombons e Docinhos');?></div>
									</div>
							</div>
						<!--Oitavo Quadrado-->
					</div>



				<div class="clear"></div>
					<div id="new50" class="item">
						


						<!--Nono Quadrado-->
							<div class="new-imagecategorias">
								<a href="categorias/Semi-frios">
									<img src="assets/images/categorias/semi-frio.png" width="217px" height="217px"/>
								</a>
									<div class="title-bg">
										<div class="title"><?php echo link_to('categorias/Semi-frios','Semi-frios');?></div>
									</div>
							</div>
						<!--Nono Quadrado-->

						<!--Décimo Quadrado-->
							<div class="new-imagecategorias">
								<a href="categorias/Gelados">
									<img src="assets/images/categorias/gelado.png" width="217px" height="217px"/>
								</a>
									<div class="title-bg">
										<div class="title"><?php echo link_to('categorias/Gelados','Gelados');?></div>
									</div>
							</div>
						<!--Décimo Quadrado-->


						<!--Décimo-primeiro Quadrado-->
							<div class="new-imagecategorias">
								<a href="categorias/Doces Fritos">
									<img src="assets/images/categorias/frito2.png" width="217px" height="217px"/>
								</a>
									<div class="title-bg">
										<div class="title"><?php echo link_to('categorias/Doces Fritos','Doces Fritos');?></div>
									</div>
							</div>
						<!--Décimo-primeiro Quadrado-->


						<!--Décimo-segundo Quadrado-->
							<div class="new-imagecategorias">
								<a href="categorias/Frutos e Outros">
									<img src="assets/images/categorias/fruto.png" width="217px" height="217px"/>
								</a>
									<div class="title-bg">
										<div class="title"><?php echo link_to('categorias/Frutos e Outros','Frutos e Outros');?></div>
									</div>
							</div>
						<!--Décimo-segundo Quadrado-->
					</div>

			</div>
		</div>
	</div>

@include('footer')

@stop