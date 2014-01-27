<?php

class CategoriaController extends BaseController {

	/**
	 * Display a listing of the resource.
	 *
	 * @return Response
	 */
	public function index($nomecategoria) {
		$receitas = Receitas::where('categoria','=',$nomecategoria)->get();
		$data = array('receitas' => $receitas, 'categoria'=>$nomecategoria);

		return View::make('categoria',$data);
	}
}