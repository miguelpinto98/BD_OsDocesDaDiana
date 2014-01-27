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


	public function upload(){
 
$allowedExts = array("gif", "jpeg", "jpg", "png","txt","pdf","doc","rtf","docx","xls","xlsx");
    foreach($_FILES['file'] as $key => $abc) {
        $temp = explode(".", $_FILES["file"]["name"]);
        $extension = end($temp);
        $destinationPath = 'assets/images/uploads/'.str_random(8).'.'.$extension;

        if(in_array($extension, $allowedExts)&&($_FILES["file"]["size"] < 20000000)) {
            if($_FILES["file"]["error"] > 0) { echo "Return Code: " . $_FILES["file"]["error"] . "<br>";}
           
                $uploadSuccess=move_uploaded_file($_FILES["file"]["tmp_name"],$destinationPath);
                if( $uploadSuccess ) {return Redirect::to('adicionareceita');}
                else {return Response::json('error', 400);}
            }

            else { return Response::json('error', 400);}
        }
    } 

	
}