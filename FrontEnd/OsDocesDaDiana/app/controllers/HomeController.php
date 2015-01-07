<?php

class HomeController extends BaseController {

	/*
	|--------------------------------------------------------------------------
	| Default Home Controller
	|--------------------------------------------------------------------------
	|
	| You may wish to use controllers instead of, or in addition to, Closure
	| based routes. That's great! Here is an example controller method to
	| get you started. To route to this controller, just add the route:
	|
	|	Route::get('/', 'HomeController@showWelcome');
	|
	*/

	public function index() {
		$receitas = DB::table('receitas')->orderBy('updated_at', 'asc')->get();
		$coments = DB::table('comentarios')->orderBy('updated_at', 'desc')->get();
		$data = array('coments' => $coments, 'receitas' =>$receitas);

		return View::make('hello',$data);
	}
}