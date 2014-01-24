<?php

/*
|--------------------------------------------------------------------------
| Application Routes
|--------------------------------------------------------------------------
|
| Here is where you can register all of the routes for an application.
| It's a breeze. Simply tell Laravel the URIs it should respond to
| and give it the Closure to execute when that URI is requested.
|
*/

Route::get('/', 'HomeController@index');
Route::get('/login','LoginController@index');
Route::post('/login','LoginController@valida');
Route::get('/categorias', 'CategoriasController@index');
Route::get('/chefs', 'ChefsListaController@index');
Route::get('/sobre', 'SobreNosController@index');