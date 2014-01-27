<?php

class ReceitaController extends \BaseController {

	/**
	 * Display a listing of the resource.
	 *
	 * @return Response
	 */
	public function index($idreceita) {
		$receita = Receitas::where('idreceita','=',$idreceita)->firstOrFail();
		$comentarios = Comentarios::where('idreceita','=', $idreceita)->orderBy('created_at','asc')->get();
		$imagens = DB::table('Imagens')->where('idreceita', $idreceita)->get();

		$data = array('receita' => $receita, 'comentarios'=> $comentarios, 'imagens'=>$imagens);

		return View::make('receita1',$data);
	}

	/**
	 * Show the form for creating a new resource.
	 *
	 * @return Response
	 */
	public function create()
	{
		//
	}

	/**
	 * Store a newly created resource in storage.
	 *
	 * @return Response
	 */
	public function store()
	{
		//
	}

	/**
	 * Display the specified resource.
	 *
	 * @param  int  $id
	 * @return Response
	 */
	public function show($id)
	{
		//
	}

	/**
	 * Show the form for editing the specified resource.
	 *
	 * @param  int  $id
	 * @return Response
	 */
	public function edit($id)
	{
		//
	}

	/**
	 * Update the specified resource in storage.
	 *
	 * @param  int  $id
	 * @return Response
	 */
	public function update($id)
	{
		//
	}

	/**
	 * Remove the specified resource from storage.
	 *
	 * @param  int  $id
	 * @return Response
	 */
	public function destroy($id)
	{
		//
	}

}