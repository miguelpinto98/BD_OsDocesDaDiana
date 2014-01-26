<?php

class AdicionaController extends BaseController {

	/**
	 * Display a listing of the resource.
	 *
	 * @return Response
	 */
	public function index()
	{
		return View::make('adicionareceita');
	}



	public function upload() {
        $allowedExts = array("gif", "jpeg", "jpg", "png","txt","pdf","doc","rtf","docx","xls","xlsx");
    
        foreach($_FILES['file'] as $key => $abc) {
            $temp = explode(".", $_FILES["file"]["name"]);
            $extension = end($temp);
            $destinationPath = 'uploads/'.str_random(8).'.'.$extension;
            var_dump($_FILES); exit();
            if(in_array($extension, $allowedExts) && ($_FILES["file"]["size"] < 20000000)) {
                if($_FILES["file"]["error"] > 0) {
                    echo "Return Code: " . $_FILES["file"]["error"] . "<br>";
                }
                $uploadSuccess=move_uploaded_file($_FILES["file"]["tmp_name"],$destinationPath);
                if( $uploadSuccess ) {
                    return Redirect::to('adicion');
                } else {
                    return Response::json('error_else', 400);
                }
            } else { 
                return Response::json('error_else_final', 400);
            }
        }
    }  
}
	