<?php

class ChefsListaController extends BaseController {

	/**
	 * Display a listing of the resource.
	 *
	 * @return Response
	 */
	public function index()
	{
		$users = User::all();
		$data = array('users' => $users);

		return View::make('listachefs', $data);
	}
}