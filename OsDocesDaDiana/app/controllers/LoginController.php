<?php

class LoginController extends \BaseController {

	/**
	 * Display a listing of the resource.
	 *
	 * @return Response
	 */
	public function index()
	{
		return View::make('login/index');
	}

	public function valida() {
		//var_dump(Input::all()); exit();
		$data = Input::all();
		$validator = Validator::make(
	    	$data,
	    	array(
	        	'username' => 'required',
	        	'password' => 'required|min:6'
	    	)
		);

		if ($validator->fails()) {
			return 'ATE AMANHA';
		} else {
			if (Auth::attempt(array('username' => $data['username'], 'password' => md5($data['password'])))) {
    			return 'OLA';
			}
		}
	}

}