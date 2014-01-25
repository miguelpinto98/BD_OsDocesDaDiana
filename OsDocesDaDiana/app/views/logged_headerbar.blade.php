@section('logged_headerbar')
<div class="center">
	<div class="topNav">
		<a href="http://www.wareztuga.tv/account.php" class="avatar"><img src="./wareztuga.tv - Filmes, Séries, Anime e Documentários HD Online Legendados_files/zoe_saldana.png" alt="98jigs"></a>
		<form method="post" id="logoutForm">
		
		<input type="hidden" name="logout" value="true">
		<!--	<a href="javascript:;" onclick="$(&#39;form#logoutForm&#39;).submit(); return false;" title="Sair"></a>-->
		</form>
		
		<div class="opts">
			<div class="to-right">
				<a href="http://www.wareztuga.tv/account.php" class="myAccount">A Minha Conta</a>
				<span class="pipe"></span>
				<a href="http://www.wareztuga.tv/notifications.php" class="notifsslctd"><span class="icon"></span><span>7</span> Notificações</a>
				<a href="http://www.wareztuga.tv/account.php?action=faved" class="faves"><span class="icon"></span><span>6</span> Favoritos</a>
				<a href="http://www.wareztuga.tv/account.php?action=cliped" class="agends"><span class="icon"></span><span>0</span> Agendados</a>
				<span class="pipe"></span>
				<a href="http://www.wareztuga.tv/account.php" class="username">98jigs</a>
			</div>
		</div>
	</div>
</div>
@stop