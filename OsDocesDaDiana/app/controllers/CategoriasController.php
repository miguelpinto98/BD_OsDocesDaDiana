<?php

class CategoriasController extends BaseController {

	/**
	 * Display a listing of the resource.
	 *
	 * @return Response
	 */
	public function index()
	{
		return View::make('categorias');
	}

	public function getCategoria($id) {

	}

	public function show($nomecategoria) {
		return $nomecategoria;
	}
}