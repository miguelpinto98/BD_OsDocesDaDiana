<?php

class AdicionaController extends BaseController {

    /**
     * Display a listing of the resource.
     *
     * @return Response
     */
    public function index(){ return View::make('adicionareceita');}

  public function upload(){
        $allowedExts = array("gif", "jpeg", "jpg", "png","txt","pdf","doc","rtf","docx","xls","xlsx");
        foreach($_FILES['file'] as $key => $abc) {
            $temp = explode(".", $_FILES["file"]["name"]); 
            $extension = end($temp);   
            $destinationPath = 'assets/images/uploads/'.str_random(8).'.'.$extension;

            if(in_array($extension, $allowedExts)&&($_FILES["file"]["size"] < 20000000)) {
                if($_FILES["file"]["error"] > 0) { echo "Return Code: " . $_FILES["file"]["error"] . "<br>";}

                    $uploadSuccess=move_uploaded_file($_FILES["file"]["tmp_name"],$destinationPath);
                    if( $uploadSuccess ) {return Redirect::to('categorias');}
                    else {return Response::json('error', 400);}
                }

                else { return Response::json('error', 400);}
        }
    }

    public function create() {
        $data = Input::all();

        if(strcmp($data['Receita'],'Submeter') == 0) {
            $validator = Validator::make($data,array(
                'nome' => 'required',
                'tempo' => 'required|numeric',
                'dose' => 'required|numeric',
                'valornutricional' => 'required|numeric',
                'custo' => 'required|numeric',
                'ing' => 'required',
                'prep' => 'required'));
        }
        if($validator->fails()) {
            $messages = array(
                'nome.required' => 'Receita com parametros incorretos');
                var_dump($messages); echo "ERROR"; exit();
        } else {
            $receita = new Receita;

            $receita->nome = $data['nome'];
            $receita->descricao = $data['prep'];
            $receita->nrimagens = 0;
            $receita->categoria = $data['categoria'];
            $receita->username = Auth::user()->username;
            $receita->nravaliacoes = 0;
            $receita->custo = $data['custo'];
            $receita->apagado = 0;
            $receita->tempopreparacao = $data['tempo'];
            $receita->dose = $data['dose'];
            $receita->ingredientes = $data['ing'];
            $receita->vnutricional = $data['valornutricional'];
            $receita->save();
            $insr = Receita::where('nome','=',$data['nome'])->OrderBy('updated_at','desc')->firstOrFail();

            return Redirect::to('/receita/'.$insr->idreceita);
        }
    }
}
    
