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

	/*public function favorita($idreceita){
		$user = Auth::user()->username;
		$receita = ReceitaSeguida::where('idreceita','=', $idreceita)->get();

		if ($receita == NULL) {
			$recSeg = new ReceitaSeguida;
			$recSeg->username = $user;
			$recSeg->idreceita = $idreceita;
			$recSeg->save;
		}


		else { DB::table('receitasseguidas')->where('idreceita','=', $idreceita)->delete(); }

		return Redirect::to('receita/'.$idreceita);		
	}

	public function seguido($idchef){
		$user = Auth::user()->username;

		if(user()->)

		$chefSeg = new ChefSeguido;
		$chefSeg->username = $user;
		$chefSeg->chefeseguido = $idchef;
		$chefSeg->save;

		return Redirect::to('receita/'.$idreceita);	
	}*/
}