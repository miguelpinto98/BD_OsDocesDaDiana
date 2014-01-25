@section('guest_headerbar')	
<div class="center">
	<div class="topNav">
		<div class="opts">
			<div class="to-right">
				<?php echo link_to('login','Login | Registar', array('class'=>'myAccount')); ?>
			</div>
		</div>
	</div>
</div>
@stop