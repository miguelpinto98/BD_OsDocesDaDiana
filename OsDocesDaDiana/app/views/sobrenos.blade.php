@extends('layout')

<?php if(Auth::check()) { ;?> 
	@include('headerbar_logged')
<?php } else { ;?> 
	@include('headerbar_guest')
<?php } ;?>

@section('content')


	<div id="content">
		<div class="center">
			<div id="login-box" class="content-box">
				<div class="login-register">						
								
					<div id="login" class="login login2">
						<div class="title">Sobre Nós</div>
						<div class="login-divider"></div>
						Os Doces da Diana é um website criado com a finalidade de partilhar deliciosas receitas de doces, o seu funcionamento tem como motor a cooperação entre utilizadores, onde estes visualizam, partilham e classificam receitas. 
						<p></p><b> Desenvolvido por:</b><p><br>

						<div class="row">						
							<div style="width:20%;float:left;">
					            <div class="content-panel">
					                <div class="boxgrid slideright">
					                    <img class="cover" src="assets/images/pics/1.jpg" alt="" style="left: 0px;">
					                    <h3 style="text-align:center;">Diana Lemos</h3>
					                    <p style="text-align:center;">a61031</p>
					                </div>
					            </div>
					        </div>

					        <div style="width:20%;float:left;">
					            <div class="content-panel">
					                <div class="boxgrid slideright">
					                    <img class="cover" src="assets/images/pics/2.jpg" alt="" style="left: 0px;" hspace="7">
					                    <h3 style="text-align:center;">Mariana Medeiros</h3>
					                    <p style="text-align:center;">a61041</p>
					                </div>
					            </div>
					        </div>
							
					        <div style="width:20%;float:left;">
					            <div class="content-panel">
					                <div class="boxgrid slideright">
					                    <img class="cover" src="assets/images/pics/3.jpg" alt="" style="left: 0px;" hspace="7">
					                    <h3 style="text-align:center;">Mário Leite</h3>
					                    <p style="text-align:center;">a61021</p>
					                </div>
					            </div>
					        </div>

					        <div style="width:20%;float:left;">
					            <div class="content-panel">
					                <div class="boxgrid slideright">
					                    <img class="cover" src="assets/images/pics/4.jpg" alt="" style="left: 0px;" hspace="7">
					                    <h3 style="text-align:center;">Miguel Pinto</h3>
					                    <p style="text-align:center;">a61049</p>
					                </div>
					            </div>
					        </div>

					        <div style="width:20%;float:left;">
					            <div class="content-panel">
					                <div class="boxgrid slideright">
					                    <img class="cover" src="assets/images/pics/5.jpg" alt="" style="left: 0px;" hspace="7">
					                    <h3 style="text-align:center;">Pedro Duarte</h3>
					                    <p style="text-align:center;">a61071</p>
					                </div>
					            </div>
					        </div>
					    </div>
					</div>
				</div>						
			</div>
		</div>
	</div>



			<script type="text/javascript" src="assets/scripts/modernizr.custom.js"></script>
			<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js"></script>
			<script src="assets/scripts/jquery.flexslider-min.js" type="text/javascript"></script>
			<script src="assets/scripts/jquery.backstretch.min.js" type="text/javascript"></script>
			<script src="assets/scripts/bootstrap.min.js"></script>
			<script type="text/javascript" src="assets/scripts/jquery.cslider.js"></script>
			<script type="text/javascript" src="assets/scripts/script.js"></script>
			<script type="text/javascript">parallax(); large_navbar_change(); large_slider_top(); parallax_slider(); clients(); portfolio_effects();</script>
	


@include('footer')

@stop