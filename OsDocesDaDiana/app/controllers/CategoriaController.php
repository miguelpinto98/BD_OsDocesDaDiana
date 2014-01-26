<?php

class CategoriaController extends BaseController {

	/**
	 * Display a listing of the resource.
	 *
	 * @return Response
	 */
	public function index()
	{
		var_dump(Input::all()); exit();
		return View::make('categoria');
	}
}