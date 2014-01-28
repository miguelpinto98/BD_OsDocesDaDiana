<?php

class PerfilController extends BaseController {

	/**
	 * Display a listing of the resource.
	 *
	 * @return Response
	 */
	public function index() {
		$user = Auth::user()->username;
		$receitas = Receita::where('username','=',$user)->get();

		$data = array('receitas'=>$receitas);

		return View::make('perfil',$data);
	}


	public function uploadf(){
		$user = Auth::user()->username;
        $allowedExts = array("jpeg", "jpg", "png","JPEG", "JPG", "PNG");
		$temp = explode(".", $_FILES["file"]["name"]);
        $extension = end($temp);
        $filename= $temp[0];
        $destinationPath = 'assets/images/Users/'.($user).'.'.$extension;

        if(in_array($extension, $allowedExts)&&($_FILES["file"]["size"] < 20000000)) {
              if($_FILES["file"]["error"] > 0){ echo "Return Code: " . $_FILES["file"]["error"] . "<br>";}
              else{
                    $uploadSuccess=move_uploaded_file($_FILES["file"]["tmp_name"],$destinationPath);
                    if( $uploadSuccess ){ return Redirect::to('sobrenos');} 
                    else { return Response::json('error', 400);}
           		}
        }
        else {return "Invalid file";}
    }
  

	
	/* function alteradados() {
		$data = Input::all();
		var_dump($data); exit();
		
		if(strcmp($data['cena'],'Alterar Dados') == 0) {
       		$validator = Validator::make($data,array(
       			'email' => 'email|unique:UTILIZADORES',
         		'pass' => 'min:6'));
     	} 
	    if ($validator->fails()) {
	       	$messages = array(
	       		'email.unique:UTILIZADORES' => 'Já existe conta com este e-mail',
	         	'password.min:6' => 'Password deve ter pelo menos 6 caracteres');
	 	
	       		var_dump($data);
	       		echo 'AQUI';
	    } else {
	    	if(strcmp($data['cena'],'Alterar Dados') == 0) {
	         	$aux1 = $data['email'];
	         	$aux2 = md5($data['pass']);
	         	$aux3 = $data['desc'];
	         	
	         	
	         	if($aux1 !=NULL) DB::table('utilizadores')->where('username', user()->username)->update(array('email' => $aux1));
	         	if($aux2 !=NULL) DB::table('utilizadores')->where('username', user()->username)->update(array('password' => $aux2));
	         	if($aux3 !=NULL) DB::table('utilizadores')->where('username', user()->username)->update(array('descricao' => $aux3));

           }
	        }
	}

	*/
}