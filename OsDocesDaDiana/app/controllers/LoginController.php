<?php

class LoginController extends BaseController {

	/**
	 * Display a listing of the resource.
	 *
	 * @return Response
	 */
	public function index()
	{
		return View::make('login/login');
	}

	public function valida() {
		//var_dump(Input::all()); exit();
		$data = Input::all();
		
		if(strcmp($data['loginBtn'],'ENTRAR AGORA') == 0) {
			$validator = Validator::make($data,array(
				'username' => 'required',
				'password' => 'required|min:6'));
		} else {
			$validator = Validator::make($data,array(
				'name' => 'required',
				'username' => 'required|unique:UTILIZADORES',
				'email' => 'required|email|unique:UTILIZADORES', //unique:users
				'password' => 'required|min:6|confirmed'
				//'password_confirmation' => 'required|min:6|confirmed'
				));
		}

		if ($validator->fails()) {
			$messages = array(
				'email.required' => 'We need to know your e-mail address!',
				'password.min:6' => 'Password deve ter pelo menos 6 caracteres');

			var_dump($messages);
			exit();
		} else {
			if(strcmp($data['loginBtn'],'ENTRAR AGORA') == 0) {
				$aux = $data['username'];
				$aux2 = md5($data['password']);
				
				$user = User::where('username', '=', $data['username'])->firstOrFail();
				if(isset($user)) {
				    if($user->password == md5($data['password'])) { // If their password is still MD5
				        Auth::login($user);
				        echo 'aaaaa';
    				}
    				else
    					return 'falhou pass';
				}
				else
					return 'erro1';
			} else {
				$pass = md5($data['password']);
				$user = new User;
					$user->username = $data['username'];
					$user->nome = $data['name'];
					$user->email = $data['email'];
					$user->password = $pass;
					$user->tipo = 0;
					$user->save();

					return Redirect::to('/login')->with('message', 'Thanks for registering!');
			}
		}

		/*
		//	return 'ATE AMANHA';
		//} else {
		//	$aux = $data['username'];
		//	$aux2 = $data['password'];

		//	var_dump(Auth::attempt(array("nomeutilizador" => "admin", "password" => "'0'"))) ;

		//$queries = DB::getQueryLog();
		//$last_query = end($queries);

		//echo '<pre>';
		//print_r($last_query);
		//print_r($queries);
		
		if($result=DB::table('UTILIZADORES')->where('nomeutilizador',$data['username'])->where('pass‌​word', md5($data['password']))) { 
			//successfully log in 
			echo 'OK';
		}

		;
		print_r($result);
		*/
	}

}