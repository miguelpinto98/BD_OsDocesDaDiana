<?php

class ReceitaController extends \BaseController {

	/**
	 * Display a listing of the resource.
	 *
	 * @return Response
	 */
	public function index($idreceita) {
		$receita = Receita::where('idreceita','=',$idreceita)->firstOrFail();
		$comentarios = Comentario::where('idreceita','=', $idreceita)->orderBy('created_at','desc')->get();
		$imagens = DB::table('Imagens')->where('idreceita', $idreceita)->get();

		$data = array('receita' => $receita, 'comentarios'=> $comentarios, 'imagens'=>$imagens);

		return View::make('receita1',$data);
	}

	public function comentario($idreceita) {
		$data = Input::all();
		if(strcmp($data['comment-submit'],'Submeter') == 0) {
            $validator = Validator::make($data,array(
                'commentBox' => 'required'));
        }

        if($validator->fails()) {
            $messages = array(
                'commentBox.required' => 'Comentario não pode ir a vazio');
                var_dump($messages); echo "ERROR"; exit();
        } else {
        	$coment = new Comentario;

        	$coment->idreceita = $idreceita;
        	$coment->username = Auth::user()->username;
        	$coment->comentario = $data['commentBox'];
        	$coment->save();

        	return Redirect::to('receita/'.$idreceita);
        }
	}

	public function favorita($idreceita){
		$user = Auth::user()->username;
		$rec = ReceitaSeguida::where('IDRECEITA','=',$idreceita)->where('USERNAME','=',$user)->get();

		if(count($rec)!=0) {
			ReceitaSeguida::where('IDRECEITA','=',$idreceita)->where('USERNAME','=',$user)->delete();
		}
		else {
			$recSeg = new ReceitaSeguida;
			$recSeg->username = $user;
			$recSeg->idreceita = $idreceita;
			$recSeg->save();
		}
		return Redirect::to('receita/'.$idreceita);		
	}

	public function seguir($idreceita){
		$user = Auth::user()->username;
		$cs = Receita::where('idreceita','=',$idreceita)->firstOrFail();
		$rec = ChefSeguido::where('username','=',$user)->where('chefeseguido','=',$cs->username)->get();

		if(count($rec)!=0) {
			ChefSeguido::where('username','=',$user)->where('chefeseguido','=',$cs->username)->delete();
		}
		else {
			$seg = new ChefSeguido;
			$seg->username = $user;
			$seg->chefeseguido = $cs->username;
			$seg->save();
		}
		return Redirect::to('receita/'.$idreceita);		
	}

	public function avaliar($idreceita, $rate) {
		$user = Auth::user()->username;
		$existe = AvaliacaoUtilizador::where('username','=',$user)->where('idreceita','=',$idreceita)->get();

		if(count($existe)!=0) {
			;//AvaliacaoUtilizador::where('username','=',$user)->where('idreceita','=',$idreceita)->delete();
		} else {
			$av = new AvaliacaoUtilizador;
			$av->username = $user;
			$av->idreceita = $idreceita;
			$av->valor = $rate;
			$av->save();
		}
		return Redirect::to('receita/'.$idreceita);	
	}
}