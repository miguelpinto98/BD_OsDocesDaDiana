<?php

class PerfilController extends BaseController {

	/**
	 * Display a listing of the resource.
	 *
	 * @return Response
	 */
	public function index() {
		$user = Auth::user()->username;
		$receitas = Receitas::where('username','=',$user)->get();

		$data = array('receitas'=>$receitas);

		return View::make('perfil',$data);
	}

	
}